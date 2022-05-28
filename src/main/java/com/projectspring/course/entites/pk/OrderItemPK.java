package com.projectspring.course.entites.pk;

import com.projectspring.course.entites.Order;
import com.projectspring.course.entites.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() { return order; }

    public Product getProduct() { return product; }

    public void setOrder(Order order) { this.order = order; }

    public void setProduct(Product product) { this.product = product; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK)) return false;
        OrderItemPK that = (OrderItemPK) o;
        return order.equals(that.order) && product.equals(that.product);
    }

    @Override
    public int hashCode() { return Objects.hash(order, product); }
}
