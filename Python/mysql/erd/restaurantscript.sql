INSERT INTO restaurants (name, address, phone_number) VALUES ("Jessy's Restaraunt", "123 Fake St, Mexico City, DOJO", "1-921-202-2400");

SELECT * FROM restaurants;

INSERT INTO menus (type, restaurant_id) VALUES ("Lunch", 1);

INSERT INTO menu_items (name, type, description, price) VALUES ("Empanada", "Food", "Meat Patty", 3);
INSERT INTO menu_items (name, type, description, price) VALUES ("Chilaquiles", "Food", "tortilla food ", 15);

SELECT * FROM menu_items;

INSERT INTO menu_has_items (menu_id, menu_item_id) VALUES (1, 1);
INSERT INTO menu_has_items (menu_id, menu_item_id) VALUES (1, 2);
SELECT * FROM menu_has_items;

-- SELECT * FROM restaurants JOIN menus ON menus.restaurant_id = restaurants.id WHERE restaurants.id=1; 
SELECT menus.id AS menu_id, menu_items.id,menus.type AS menu_type,menu_items.name,menu_items.type,menu_items.price,menu_items.created_at,menu_items.updated_at FROM menus 
JOIN menu_has_items ON menus.id = menu_has_items.menu_id 
JOIN menu_items ON menu_has_items.menu_item_id = menu_items.id
WHERE menus.restaurant_id =1;


