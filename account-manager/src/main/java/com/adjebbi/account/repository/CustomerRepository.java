package com.adjebbi.account.repository;

import com.adjebbi.account.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
