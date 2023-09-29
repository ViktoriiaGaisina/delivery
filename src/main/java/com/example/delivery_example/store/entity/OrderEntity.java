package com.example.delivery_example.store.entity;

import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders", schema = "delivery")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "number_of_order", unique = true, nullable = false)
    private String numberOfOrder;

    @Column(name = "created_date", nullable = false)
    private Instant created = Instant.now();

    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private CustomerEntity customerEntity;

    @ManyToMany
    @JoinTable(
            schema = "delivery",
            name = "order_dish",
            joinColumns = @JoinColumn(name = "fk_order_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_dish_id")
    )
    private List<DishEntity> dishEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "fk_status_id")
    private StatusOrderEntity statusOrderEntity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return numberOfOrder == that.numberOfOrder && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfOrder);
    }
}
