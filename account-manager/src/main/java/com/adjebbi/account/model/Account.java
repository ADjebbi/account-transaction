package com.adjebbi.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public final class Account {

    @Id
    @Column(name = "id", nullable = false)
    public String id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    public Customer customer;

}
