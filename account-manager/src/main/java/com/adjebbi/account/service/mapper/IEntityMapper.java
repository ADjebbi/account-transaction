package com.adjebbi.account.service.mapper;

import java.util.List;

/**
 * @author Djebbi.Achref@scheidt-bachmann.de
 */

public interface IEntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List <E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
