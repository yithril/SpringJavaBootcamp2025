const API_BASE = "http://localhost:8080/products"; 

async function fetchProducts() {
  const res = await fetch(API_BASE);
  return await res.json();
}

async function fetchProduct(id) {
  const res = await fetch(`${API_BASE}/${id}`);
  return await res.json();
}

async function createProduct(product) {
  const res = await fetch(API_BASE, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(product)
  });
  return await res.json();
}

async function updateProduct(id, product) {
  await fetch(`${API_BASE}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(product)
  });
}

async function deleteProduct(id) {
  await fetch(`${API_BASE}/${id}`, { method: "DELETE" });
}
