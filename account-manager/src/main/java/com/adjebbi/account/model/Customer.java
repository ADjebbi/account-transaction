package com.adjebbi.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public final class Customer {

    @Id
    @Column(name = "id", nullable = false)
    public String id;

    @Column(name = "name", nullable = false)
    public String name;

    @OneToMany(mappedBy= "customer")
    public Set<Account> accounts;
}
