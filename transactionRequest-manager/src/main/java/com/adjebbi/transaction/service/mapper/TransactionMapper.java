package com.adjebbi.transaction.service.mapper;

import com.adjebbi.transaction.model.Transaction;
import com.adjebbi.transaction.service.dto.TransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@Mapper(componentModel = "spring", imports = {UUID.class})
public interface TransactionMapper extends IEntityMapper<TransactionRequest, Transaction>{

    @Override
    @Mapping(target = "id",  expression = "java( UUID.randomUUID().toString() )")
    Transaction toEntity(TransactionRequest dto);

}
