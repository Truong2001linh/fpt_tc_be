package com.example.appvaccine.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_payment")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentID")
    private Integer paymentId;

    @Column(name = "paymentMethod")
    private Long paymentMethod;

    @Column(name = "statusPayment")
    private String statusPayment;

    @OneToOne(mappedBy = "pay",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private VaccinationRegist vaccinationRegist;



}
