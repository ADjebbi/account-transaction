package com.adjebbi.transaction.model;

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
@Table(name="transaction")
public class Transaction {
    @Id
    @Column(name = "id", nullable = false)
    public String id;

    @Column(name = "account_id", nullable = false)
    public String accountID;

    @Column(name = "customer_id", nullable = false)
    public String customerID;

    @Column(name = "credit", nullable = false)
    public String credit;

}
