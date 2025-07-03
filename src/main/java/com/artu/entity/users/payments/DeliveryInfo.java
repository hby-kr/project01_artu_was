package com.artu.entity.users.payments;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "delivery_infos")
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id", nullable = false)
    private Integer deliveryId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private UserPurchaseList payment;

    @Size(max = 100)
    @Column(name = "receiver_name", length = 100)
    private String receiverName;

    @Size(max = 50)
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @ColumnDefault("'pending'")
    @Lob
    @Column(name = "delivery_status")
    private String deliveryStatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}