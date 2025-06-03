SELECT * FROM Customers;

SELECT ContactName, CompanyName
FROM Customers;

SELECT DISTINCT(Country)
FROM Customers;

SELECT *
FROM Customers
WHERE Country = 'UK';

SELECT *
FROM orders
WHERE freight BETWEEN 50 AND 100;

SELECT * 
FROM Orders
WHERE OrderDate > '1997-01-01' 
AND (ShipCountry = 'USA' OR ShipCountry = 'Canada');

/* Write a SQL query to display orders from the Orders table 
where the ShipCountry is in ('France', 'Belgium', 'Germany')*/
SELECT *
FROM Orders
WHERE ShipCountry IN ('France', 'Belgium', 'Germany');

SELECT *
FROM products
WHERE UnitPrice BETWEEN 10 AND 20;

/*
Write a SQL query to select all suppliers from the Suppliers table 
and order them by Country in ascending order.
*/

SELECT *
FROM suppliers
ORDER BY Country;

SELECT *
FROM customers
ORDER BY ContactName DESC;