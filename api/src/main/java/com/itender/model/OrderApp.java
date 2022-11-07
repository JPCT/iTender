package com.itender.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.itender.utils.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderApp {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "table_app_id", nullable = false)
    private Bench bench;

    @Column
    private OrderStatus status = OrderStatus.INIT;

    @ManyToOne
    @JoinColumn(name = "user_app_id", nullable = false)
    private UserApp waiter;

    @Column
    private LocalDateTime orderDate;

    @Column
    private LocalDateTime confirmDate;

    @Column
    private LocalDateTime cookingDate;

    @Column
    private LocalDateTime deliverDate;

    @Column
    private LocalDateTime payDate;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private Long price;

}
