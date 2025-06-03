-- SUM AVG MIN MAX COUNT
-- Aggregate functions

-- How many products do we sell that are beverages?
-- "How many?" is handled by COUNT
SELECT COUNT(*)
FROM products
WHERE CategoryId = 1;

-- What is the price of our most expensive product?
SELECT MAX(UnitPrice)
FROM products;

-- What is the price of our least expensive product?
-- AS is an alias
SELECT MIN(UnitPrice) AS Min_Price
FROM products;

-- What is the average price of our products?
SELECT AVG(UnitPrice) AS Average_Price
FROM products;

-- What is the sum total of our employee salaries?
SELECT SUM(salary)
FROM employees;

-- a little spice
-- How many distinct customers are there in the orders table?
SELECT COUNT(DISTINCT CustomerId) AS Unique_Customers
FROM Orders;

-- breakdown of average freight by country
SELECT AVG(Freight), ShipCountry
FROM orders
WHERE ShipCountry IN ('UK', 'Germany', 'Belgium', 'Sweden')
GROUP BY ShipCountry
ORDER BY ShipCountry;

-- breakdown of average freight by country, but ONLY countries
-- with average freight greater than 60
SELECT AVG(Freight) AS Avg_Freight, ShipCountry
FROM orders
GROUP BY ShipCountry
HAVING Avg_Freight > 60
ORDER BY ShipCountry;