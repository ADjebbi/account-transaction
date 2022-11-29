package com.adjebbi.account.service.mapper;

import com.adjebbi.account.model.Account;
import com.adjebbi.account.service.dto.AccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.UUID;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Mapper(componentModel = "spring", imports = {UUID.class})
public interface AccountMapper extends IEntityMapper<AccountRequest, Account>{

    @Override
    @Mapping(source="customerID",target = "customer.id")
    @Mapping(target = "id",  expression = "java( UUID.randomUUID().toString() )")
    Account toEntity(AccountRequest dto);

}
