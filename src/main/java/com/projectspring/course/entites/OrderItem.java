package com.projectspring.course.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectspring.course.entites.pk.OrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity(name= "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem () { }

    public OrderItem (Order oder, Product product, Integer quantity, Double price) {
        id.setOrder(oder);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }


    public Integer getQuantity() { return quantity; }

    public Double getPrice() { return price; }

    @JsonIgnore
    public Order getOrder() { return id.getOrder(); }

    public Product getProduct() { return id.getProduct(); }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public void setPrice(Double price) { this.price = price; }

    public void setOrder(Order order) { id.setOrder(order); }

    public void setProduct(Product product) { id.setProduct(product); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
