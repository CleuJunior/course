package com.projectspring.course.entites.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int order;

    OrderStatus(int order) { this.order = order; }

    public int getOrder() { return this.order; }

    public static OrderStatus statusOf(int status) {
        for (OrderStatus orders : OrderStatus.values()) { if (orders.getOrder() == status) return orders; }

        throw new IllegalStateException("Invalid Status");
    }
}
