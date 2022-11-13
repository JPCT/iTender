package com.itender.bff.common.utils;

public interface ClassMapper<T, U> {

    U toDomain(T entity, U domain);

    T toEntity(U domain, T entity);

}
