SELECT *
FROM products
WHERE ProductName = 'Aniseed Syrup';

/*All beverages that are above $18*/
SELECT *
FROM products
WHERE QuantityPerUnit > 1 AND UnitPrice > 18;

/*not equal to is different than java
all products that are not condiments*/
SELECT *
FROM products
WHERE ProductName <> 'Chai';

/*I want all products that are between 18 and 30 dollars*/
SELECT *
FROM products
WHERE UnitPrice BETWEEN 18 AND 30;

/* Order by comes after WHERE */
SELECT *
FROM Employees
ORDER BY LastName DESC;

/*Can we combine where and Order by? Sure can!*/
SELECT * 
FROM Employees
WHERE City = 'Seattle'
ORDER BY LastName;

/*What cities are our employees from? Remove duplicates*/
SELECT DISTINCT(city)
FROM Employees;

/* Find products with tea in the name. LIKE is contains() in Java */
/* % is called wildcard */
SELECT *
FROM products
WHERE ProductName LIKE '%Tea%';

/*Find products whose code starts with NWTD */
SELECT *
FROM products
WHERE ProductName LIKE 'Chef%';