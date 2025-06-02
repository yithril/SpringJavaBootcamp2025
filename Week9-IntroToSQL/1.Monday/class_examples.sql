SELECT *
FROM products
WHERE category = 'Beverages';

/*All beverages that are above $18*/
SELECT *
FROM products
WHERE category = 'Beverages' AND list_price > 18;

/*not equal to is different than java
all products that are not condiments*/
SELECT *
FROM products
WHERE category <> 'Condiments';

/*I want all products that are between 18 and 30 dollars*/
SELECT *
FROM products
WHERE list_price BETWEEN 18 AND 30;

/* Order by comes after WHERE */
SELECT *
FROM Employees
ORDER BY last_name DESC;

/*Can we combine where and Order by? Sure can!*/
SELECT * 
FROM Employees
WHERE City = 'Seattle'
ORDER BY last_name;

/*What cities are our employees from? Remove duplicates*/
SELECT DISTINCT(city)
FROM Employees;

/* Find products with tea in the name. LIKE is contains() in Java */
/* % is called wildcard */
SELECT *
FROM products
WHERE product_name LIKE '%Tea%';

/*Find products whose code starts with NWTD */
SELECT *
FROM products
WHERE product_code LIKE 'NWTD%';