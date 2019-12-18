create table ingredientamount
(
    id           int auto_increment
        primary key,
    RecipeID     int         null,
    IngredientID int         null,
    amount       double      null,
    unit         varchar(10) null
);

INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (1, 1, 1, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (2, 1, 2, 300, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (3, 1, 3, 40, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (4, 1, 7, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (5, 1, 8, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (6, 1, 13, 20, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (7, 1, 20, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (8, 2, 1, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (9, 2, 2, 300, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (10, 2, 10, 2, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (11, 2, 17, 50, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (12, 2, 4, 50, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (13, 2, 7, 40, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (14, 2, 8, 25, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (15, 3, 1, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (16, 3, 2, 100, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (17, 3, 10, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (18, 3, 15, 40, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (19, 3, 11, 15, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (20, 3, 13, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (21, 3, 17, 15, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (22, 3, 7, 15, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (23, 4, 1, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (24, 4, 9, 2, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (25, 4, 21, 0.5, 'tbsp');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (26, 4, 22, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (27, 4, 23, 0.5, 'pck');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (28, 4, 24, 25, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (29, 4, 25, 0.5, 'tbsp');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (30, 4, 26, 1, 'tsp');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (31, 4, 15, 1.5, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (32, 4, 27, 0.5, 'tbsp');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (33, 4, 28, 0.5, 'tbsp');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (34, 4, 29, 1.5, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (35, 4, 17, 25, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (36, 4, 7, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (37, 4, 3, 12.5, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (38, 5, 1, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (39, 5, 7, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (40, 5, 5, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (41, 5, 6, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (42, 5, 2, 125, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (43, 5, 18, 150, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (44, 5, 13, 5, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (45, 5, 30, 15, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (46, 5, 15, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (47, 6, 1, 1, 'pcs');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (48, 6, 2, 100, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (49, 6, 7, 20, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (50, 6, 15, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (51, 6, 12, 20, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (52, 6, 19, 10, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (53, 6, 22, 20, 'g');
INSERT INTO idealfood.ingredientamount (id, RecipeID, IngredientID, amount, unit) VALUES (54, 6, 3, 20, 'g');
create table ingredients
(
    id            int auto_increment
        primary key,
    name          varchar(50) null,
    calories      double      null,
    protein       double      null,
    fat           double      null,
    carbohydrates double      null
);

INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (1, 'burger bun', 202, 6, 12, 70);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (2, 'ground beef', 160, 20, 10, 0);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (3, 'cheddar cheese', 300, 20, 35, 5);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (4, 'mozzarella cheese', 300, 22, 30, 5);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (5, 'tomato', 18, 2, 0, 25);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (6, 'cucumber', 15, 0, 0, 17);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (7, 'lettuce', 10, 0, 0, 12);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (8, 'onion', 40, 5, 0, 40);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (9, 'mushroom', 22, 9, 0, 15);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (10, 'egg', 100, 10, 10, 0);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (11, 'asparges', 25, 6, 0, 24);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (12, 'guacamole', 300, 11, 40, 40);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (13, 'ketchup', 203, 4, 17, 68);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (14, 'hummus', 273, 8, 34, 29);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (15, 'red onion', 40, 5, 0, 40);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (16, 'paprika', 37, 4, 0, 31);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (17, 'mayonaise', 553, 5, 60, 40);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (18, 'sweet potatoe', 100, 7, 2, 50);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (19, 'broccoli', 35, 8, 0, 30);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (20, 'mustard', 251, 5, 30, 34);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (21, 'olive oil', 900, 0, 95, 0);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (22, 'red pepper', 37, 2, 0, 31);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (23, 'thyme', 0, 0, 0, 0);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (25, 'sun dried tomato paste', 350, 5, 50, 25);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (26, 'smoked paprika', 0, 0, 0, 0);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (29, 'garlic cloves', 35, 4, 2, 25);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (30, 'carrot', 40, 2, 0, 40);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (31, 'red kidney beens', 100, 8, 1, 11);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (32, 'chilli powder', 2, 1, 0, 2);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (33, 'beef stock cube', 18, 0, 1, 1);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (34, 'bell pepper', 30, 2, 1, 6);
INSERT INTO idealfood.ingredients (id, name, calories, protein, fat, carbohydrates) VALUES (35, 'canned beef', 147, 20, 10, 0);
create table recipes
(
    id     int auto_increment
        primary key,
    name   varchar(50)   null,
    howto  varchar(5000) null,
    images blob          null
);

INSERT INTO idealfood.recipes (id, name, howto, images) VALUES (1, 'Beefaholic', 'Preheat the oven to 200ºC/400ºF/gas 6. and form 2 burger patties & roast for about 15 min. Cut the vegetables while you roast the patties. When the beef are done put a piece of cheddar cheese on each and put the burger bun in the oven for 3 minuts. Slice the bun and ketchup and mustard on the buttom. Put a patty on and the other patty on the first. Put the vegetables on top and put the top of the burger bun on top of that.', 0x68747470733A2F2F692E696D6775722E636F6D2F4F736A4D5961442E706E67);
INSERT INTO idealfood.recipes (id, name, howto, images) VALUES (2, 'Eggylicious', 'Preheat the oven to 200ºC/400ºF/gas 6. and form 3 burger patties & roast for about 15 minuts. When the patties are almost done put sliced mozzerella cheese on 1 of the patties. Cut the lettuce and fry 2 eggs and put the burger bun in the over for 3 minuts. Slice the bun and put mayonnaise on both top and buttom. Put lettuce on the buttom bun and a patty on top. Put one egg of the patty and a patty on top with an egg on. Put the last patty on top and the burger bun on top.', 0x68747470733A2F2F692E696D6775722E636F6D2F587443425134302E706E67);
INSERT INTO idealfood.recipes (id, name, howto, images) VALUES (3, 'Hella Home Style', 'Preheat the oven to 200ºC/400ºF/gas 6. & form 2 burger patties & roast for about 15 minuts. After 10 min fry an egg and put the burger bun in the oven for 3 minuts. Slice the asparagus and make the thyme ready. Slice the burger bun and spread mayonnaise and ketchup on the bottom. Put some asparagus on, a patty on top, springle some thyme and put next patty on top. Springle some thyme on and put the egg on top with some asparagus. Spread some mustard on the top burger bun and put that on top of the rest.', 0x68747470733A2F2F692E696D6775722E636F6D2F786B3675776F542E6A7067);
INSERT INTO idealfood.recipes (id, name, howto, images) VALUES (4, 'Light & Licious', 'Heat oil in a large skillet over medium high heat. Add garlic and onion. Turn heat up to high and add beef. Cook, breaking it up as you go, until mostly browned. Add Chili Spice Mix. Cook until beef is browned all over. (This step helps release extra flavour from the spices). Add remaining ingredients, with 1/2 cup of water for Quick Cook or 1 1/2 cups for Slow Cook. Bring to simmer, then adjust heat per step below: Quick Cook - 20 to 40 minutes, uncovered, on medium low heat so it''s bubbling gently; OR Slow Cook - 1.5 hours to 2 hours, covered, on low heat so it''s bubbling very gently. (Note 3 Slow Cooker). Adjust salt and pepper to taste just before serving. Serve over rice, or ladle into bowls and serve with corn chips or warm tortillas on the side with Toppings of choice (Note 6). See Note 7 for more serving options. My usual: Either over rice or with corn chips, always with sour cream, cheese and coriander. Warm the oven 10 minuts before the chile con carne are done and warm the burger bun for 3 minuts. Slice it and put a big spoon of the chile con carne on the bottom bun. Put some mozzerella cheese and lettuce on top and more cheese and put the burger bun top on top of that.', 0x68747470733A2F2F692E696D6775722E636F6D2F4A4E34766558732E706E67);
INSERT INTO idealfood.recipes (id, name, howto, images) VALUES (5, 'Mother Earth', 'Preheat the oven to 200ºC/400ºF/gas 6. Wash 2 large sweet potatoes under cold running water, scrubbing well with a scrubber to get rid of any dirt (there’s no need to peel them). Cut each sweet potato in half lengthways, cut each half in half lengthways, then each piece in half again so you end up with 8 wedges. Add to a large mixing bowl, then sprinkle over a tiny pinch of sea salt and black pepper, and ½ a teaspoon of sweet smoked paprika. Drizzle with 1 tablespoon of olive oil, then toss everything together to coat. Spread out into a single layer in a large baking tray, then bake for 35 to 40 minutes, or until golden and cooked through. Leave to sit for a couple of minutes (this will make it easier to remove them from the tray), then use a fish slice to transfer them to a serving dish. Form a burger patty and roast for about 15 minuts. Slice tomatoes, cucumber and asparagus in to cubes. Give the burger bun 3 minuts at 200 C / 392 F and slice it. Spread mayonnaise on the bun and put lettuce on the bottom bun. Put the patty on top and top up with the relish and serve with the sweet potatoes.', 0x68747470733A2F2F692E696D6775722E636F6D2F743739783254462E706E67);
INSERT INTO idealfood.recipes (id, name, howto, images) VALUES (6, 'Cheesy', 'Preheat the oven to 200ºC/400ºF/gas 6. Slice the muchrooms, broccoli and red onion and roast on the pan for about 8-10 minuts. Form a burger patty and roast for about 15 minuts. The last minuts put the mozzerella slices over the burger patty and melt. Slice a red onion, a mozerella beef and a tomato. Warm the burger bun for 3 minuts and spread the hummus and guacamole on the bottom bun. Put the mushroommix on top and the burger patty and mozzerella cheese on top of that. Put red onion and tomatoes on top. Spread some mayonnaise on top of the burger bun and top of the burger.', 0x68747470733A2F2F692E696D6775722E636F6D2F6862656D554D6A2E706E67);