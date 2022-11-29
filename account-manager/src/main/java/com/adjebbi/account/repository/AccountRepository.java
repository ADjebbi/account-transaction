package com.adjebbi.account.repository;

import com.adjebbi.account.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
public interface AccountRepository extends CrudRepository<Account, String> {

}
