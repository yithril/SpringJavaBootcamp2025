(async function () {
  const container = document.getElementById("table-container");
  const products = await fetchProducts();
  console.log("All products from API:", products);
  if (!products.length) return;

  let html = `<table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Actions</th>
      </tr>
    </thead>
    <tbody>`;

  for (const product of products) {
    html += `<tr>
      <td>${product.productId}</td>
      <td>${product.productName}</td>
      <td>${product.unitPrice}</td>
      <td>${product.unitsInStock}</td>
      <td>
        <a href="product-form.html?id=${product.productId}" class="btn btn-sm btn-warning">Edit</a>
        <button onclick="handleDelete(${product.productId})" class="btn btn-sm btn-danger ms-1">Delete</button>
      </td>
    </tr>`;
  }

  html += "</tbody></table>";
  container.innerHTML = html;
})();

async function handleDelete(id) {
  if (confirm("Are you sure you want to delete this product?")) {
    await deleteProduct(id);
    location.reload();
  }
}
