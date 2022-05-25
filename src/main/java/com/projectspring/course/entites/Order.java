package com.projectspring.course.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projectspring.course.entites.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'",
            timezone = "GMT"
    )
    private Instant instant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    private Integer orderStatus;

    public Order() { }

    public Order(Long id, Instant instant, User client, OrderStatus orderStatus) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        this.orderStatus = orderStatus.getOrder();
    }

    public Long getId() { return id; }


    public Instant getInstant() { return instant; }

    public void setInstant(Instant instant) { this.instant = instant; }

    public User getClient() { return client; }

    public void setClient(User client) { this.client = client; }

    public OrderStatus getOrderStatus() { return OrderStatus.statusOf(orderStatus); }

    public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus.get; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}