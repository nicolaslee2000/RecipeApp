
package main;

import gui.MainFrame;

/**
 *
 * @author Nicolaslee
 */
public class Main {
    public static void main(String args[]) {
        com.formdev.flatlaf.FlatLightLaf.setup();


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
