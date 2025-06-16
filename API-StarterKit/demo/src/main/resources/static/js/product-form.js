(async function () {
  const form = document.getElementById("product-form");
  const title = document.getElementById("form-title");
  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");

  // Load categories and suppliers into dropdowns
  async function loadDropdowns() {
    const [categories, suppliers] = await Promise.all([
      fetch("http://localhost:8080/categories").then(res => res.json()),
      fetch("http://localhost:8080/suppliers").then(res => res.json())
    ]);

    for (const c of categories) {
      const option = document.createElement("option");
      option.value = c.categoryId;
      option.textContent = c.categoryName;
      document.getElementById("categoryId").appendChild(option);
    }

    for (const s of suppliers) {
      const option = document.createElement("option");
      option.value = s.supplierId;
      option.textContent = s.companyName;
      document.getElementById("supplierId").appendChild(option);
    }
  }

  await loadDropdowns();

  // If editing an existing product
  if (id) {
    title.textContent = "Edit Product";
    const product = await fetch(`http://localhost:8080/products/${id}`).then(res => res.json());

    form.productName.value = product.productName;
    form.unitPrice.value = product.unitPrice;
    form.unitsInStock.value = product.unitsInStock;
    form.categoryId.value = product.categoryId ?? "";
    form.supplierId.value = product.supplierId ?? "";
  }

  // Handle form submission
  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const product = {
      productName: form.productName.value,
      unitPrice: parseFloat(form.unitPrice.value),
      unitsInStock: parseInt(form.unitsInStock.value),
      categoryId: parseInt(form.categoryId.value) || null,
      supplierId: parseInt(form.supplierId.value) || null
    };

    const url = id
      ? `http://localhost:8080/products/${id}`
      : `http://localhost:8080/products`;

    await fetch(url, {
      method: id ? "PUT" : "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product)
    });

    window.location.href = "products.html";
  });
})();
