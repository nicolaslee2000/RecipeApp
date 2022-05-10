package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public abstract class DAO {
	
	//사용하시면 되는 메소드들 시작:
	
	protected boolean isExists(String query, Object... obj) {
		try {
			initConnect();
			initPstmt(query, obj);
			conn.commit();
			return rs.next();
		} catch (ClassNotFoundException | SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	protected <T> List<T> getDTOs(String query, Class<?> c) {
		List<T> content = null;
		try {
			initConnect();
			initStmt(query);
			content = getContentList(c);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return content;
	}
	
	protected <T> List<T> getDTOs(String query, Consumer<PreparedStatement> con, Class<?> c) {
		List<T> content = null;
		try {
			initConnect();
			initPstmt(query, con);
			content = getContentList(c);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
	protected void updateTable(String query) {
		try {
			initConnect();
			initStmtUpdate(query);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void updateTable(String query, Consumer<PreparedStatement> con) {
		try {
			initConnect();
			initPstmtUpdate(query, con);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//사용 메소드들 종료 이 및부터는 내부처리해주는 메소드들입니다
	//혹시 어떻게 작동되는지 궁금하신분들을 위해 간단한 설명(신경 안쓰셔도 됩니다)
	//
	//reflection이란걸 통해 클레스의 필드를 가져오고 recursion으로 그 클레스에 필드로 정의된 dto클레스를 생성, 정보를 저장합니다
	//reflection만 조금 아시면 금방 이해되실겁니다
	
	private Connection conn;
	private String username;
	private String password;
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	Map<Class<?>, Method> rsMethods;
	Map<Class<?>, Method> psMethods;
	
	public DAO(String username, String password) {
		this.username = username;
		this.password = password;
		try {
			rsMethods = getRSMethods();
			psMethods = getPstmtMethods();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private void initConnect() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);
	}
	
	private void initStmt(String query) throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
	}
	
	private void initStmtUpdate(String query) throws SQLException {
		stmt = conn.createStatement();
		stmt.executeUpdate(query);
	}

	private void initPstmt(String query, Object... obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		pstmt = conn.prepareStatement(query);
		for(int i = 0; i < obj.length; i ++) {
			psMethods.get(obj[i].getClass()).invoke(pstmt, i+1, obj[i]);
		}
		
		rs = pstmt.executeQuery();
	}
	
	private void initPstmt(String query, Consumer<PreparedStatement> con) throws SQLException {
		pstmt = conn.prepareStatement(query);
		con.accept(pstmt);
		rs = pstmt.executeQuery();
	}
	
	private void initPstmtUpdate(String query, Consumer<PreparedStatement> con) throws SQLException {
		pstmt = conn.prepareStatement(query);
		con.accept(pstmt);
		pstmt.executeUpdate();
	}
	
	private List<String> getAllFields(Class<?> c) {
		List<String> fields = Arrays.stream(c.getDeclaredFields()).map(e -> e.getName()).collect(Collectors.toList());
		return fields;
	}
	

	private List<String> getRetainingColumns(Class<?> c) throws SQLException {
		//matching object fields to column names is case insensitive
		rsmd = rs.getMetaData();
		List<String> fields = getAllFields(c);
		List<String> columns = new ArrayList<>();
		for(int i = 0; i < rsmd.getColumnCount(); i++) {
			//case insensitive checking
			String column = fields.stream().filter(rsmd.getColumnName(i+1)::equalsIgnoreCase).findFirst().orElse(null);
			if(column != null) {
				columns.add(column);
			}
		}
		return columns;
	}
	
	//A recursion function to loop through class fields and classes declared as fields within the class
	//temp global list outside recursion method to prevent stackoverflow
	private List<String> temp = new ArrayList<String>();
	private Object setDTO(Class<?> c) throws Exception {
		Object obj = c.getDeclaredConstructor().newInstance();
		for(String str :getAllFields(c)) {
			Field field = c.getDeclaredField(str);
			field.setAccessible(true);
			//begin recursion when field is a DTO class
			if(field.getName().matches(".*(?i)DTO")) {
				//skip if this class has already passed through recursion
				if(temp.stream().anyMatch(field.getName()::equalsIgnoreCase)) {
					continue;
				}
				temp.add(field.getName());
				field.set(obj, setDTO(Class.forName(field.getType().getName())));
			}
			
		} 
		for(String str2 : getRetainingColumns(c)) {
			//set field of obj, invoke method of rs which is implementing methods of ResultSet
			//rs is an instance of Method that reflects the method being invoked
			Field field = c.getDeclaredField(str2);
			field.setAccessible(true);
			field.set(obj, rsMethods.get(field.getType()).invoke(rs, str2));
		}
		
		//prevent instantiating redundant object when all fields in said object is null
		for(String str : getAllFields(c)) {
			Field field = c.getDeclaredField(str);
			field.setAccessible(true);
			if(field.get(obj) != null) {
				return obj;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	//using recursion
	//getting retaining fields of class and table columns including class within class using recursion
	private <T> List<T> getContentList(Class<?> c) throws Exception {
		List<T> content = new ArrayList<>();
		while(rs.next()) {
			temp.add(c.getSimpleName());
			Object obj = setDTO(c);
			//clear temp list after whole recursion
			temp.clear();
			content.add((T) obj);
		}
		return content;
	}
	
	private void exit() throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(rs != null) {
			rs.close();
		}
	}
	
	
	//method to get every needed methods of resultset using reflection, then stream filtering mapping it to each return value
	private Map<Class<?>, Method> getRSMethods() throws NoSuchMethodException, SecurityException {
		Class<?> resultSet = ResultSet.class;
		Method[] rsMethods = resultSet.getMethods(); 
		Map<Class<?>, Method> rsmethods = Arrays.stream(rsMethods)
				.filter(e -> e.getParameterCount() == 1)
				.filter(e -> e.getParameterTypes()[0].equals(String.class))
				.filter(e -> e.getName().substring(3).compareToIgnoreCase(e.getReturnType().getSimpleName()) == 0)
				.collect(Collectors.toMap(e -> e.getReturnType(), e -> e));
		//manually adding setBytes method
		rsmethods.put(byte[].class, ResultSet.class.getMethod("getBytes", String.class));
		
		return rsmethods;
	}
	
	//method to get every needed methods of preparedStatement using reflection
	private Map<Class<?>, Method> getPstmtMethods() throws NoSuchMethodException, SecurityException {
		Class<?> preparedStatement = PreparedStatement.class;
		Method[] psMethods = preparedStatement.getMethods(); 
		Map<Class<?>, Method> methods = Arrays.stream(psMethods)
				.filter(e -> e.getParameterCount() == 2)
				.filter(e -> e.getParameterTypes()[0].equals(int.class))
				.filter(e -> e.getReturnType().equals(Void.TYPE))
				.filter(e -> e.getName().startsWith("set"))
				.filter(e -> !e.getName().substring(3).startsWith("N"))
				.filter(e -> !e.getName().contains("Stream"))
				.collect(Collectors.toMap(e -> e.getParameterTypes()[1], e -> e));
		//manually adding setBytes method
//		methods.put(byte[].class, preparedStatement.getMethod("setBytes", String.class));
		
		return methods;
	}
}


