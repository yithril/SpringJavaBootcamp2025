/*
List the product id, product name, unit price and category name of all
products. Order by category name and within that, by product name.
*/
SELECT productId, productName, unitPrice, c.categoryName
FROM products p
JOIN categories c ON p.categoryId = c.categoryId
ORDER BY c.categoryName, p.ProductName;

/*
List the product id, product name, unit price and supplier name of all
products that cost more than $75. Order by product name.
*/
SELECT productId, productName, unitPrice, companyName
FROM products
JOIN suppliers ON products.SupplierID = suppliers.supplierID
WHERE UnitPrice > 75
ORDER BY productName;

/*
List the product id, product name, unit price, category name, and supplier
name of every product. Order by product name.
*/
SELECT productId, productName, unitPrice, c.categoryName, s.CompanyName
FROM products p
JOIN categories c ON p.CategoryID = c.CategoryID
JOIN suppliers s ON p.SupplierID = s.SupplierID
ORDER BY productName;

/*
What is the product name(s) and categories of the most expensive
products? HINT: Find the max price in a subquery and then use that in
your more complex query that joins products with categories.
*/

SELECT productName, categoryName
FROM products
JOIN categories ON products.CategoryID = categories.CategoryID
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM products);

/*
List the order id, ship name, ship address, and shipping company name of
every order that shipped to Germany.
*/

SELECT orderId, shipName, shipAddress, shippers.ShipperID, shippers.CompanyName
FROM orders
JOIN shippers ON shippers.ShipperID = orders.ShipVia
WHERE shipCountry = 'Germany';

/*
List the order id, order date, ship name, ship address of all orders that
ordered "Sasquatch Ale"?
*/
SELECT o.orderId, o.orderDate, o.shipName, o.shipAddress
FROM orders o
JOIN `order details` od ON o.OrderID = od.OrderID
JOIN products p ON od.ProductID = p.ProductId
WHERE p.ProductName = 'Sasquatch Ale';
