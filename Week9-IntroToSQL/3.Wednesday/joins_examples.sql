-- inner joins
-- bring two or more tables together (temporarily)

SELECT ProductId, ProductName, suppliers.ContactName, suppliers.Address
FROM products
JOIN suppliers ON products.SupplierID = suppliers.SupplierID;

-- join more than one table together
SELECT ProductID, ProductName, suppliers.CompanyName, suppliers.Country,
  categories.CategoryName, categories.Description
FROM products
JOIN suppliers ON products.SupplierID = suppliers.SupplierID
JOIN categories ON products.CategoryID = categories.CategoryID;

-- same query, less typing
SELECT ProductID, ProductName, s.CompanyName, s.Country, c.CategoryName,
       c.Description
FROM products p
JOIN suppliers s ON p.SupplierID = s.SupplierID
JOIN categories c ON p.CategoryID = c.CategoryID;

       



