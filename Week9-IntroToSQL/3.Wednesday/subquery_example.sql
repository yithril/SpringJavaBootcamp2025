-- 1. What is the name and unit price of the most expensive product?

SELECT ProductName, UnitPrice
FROM products
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM products);

-- What products are more expensive than the average product price?

SELECT ProductName, UnitPrice
FROM products
WHERE UnitPrice > (SELECT AVG(UnitPrice) FROM products);