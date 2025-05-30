package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public BigDecimal getOrderTotal() {
        return items.stream()
                .map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Sandwich> getSandwiches() {
        return items.stream()
                .filter(i -> i instanceof Sandwich)
                .map(i -> (Sandwich) i)
                .toList();
    }

    public List<SideItem> getSideItems() {
        return items.stream()
                .filter(i -> i instanceof SideItem)
                .map(i -> (SideItem) i)
                .toList();
    }
}
