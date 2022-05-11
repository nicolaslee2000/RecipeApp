CREATE OR REPLACE TRIGGER recipes_recipe_id_trg BEFORE
    INSERT ON recipes
    FOR EACH ROW
BEGIN
    :new.recipe_id := recipes_recipe_id_seq.nextval;
END;

