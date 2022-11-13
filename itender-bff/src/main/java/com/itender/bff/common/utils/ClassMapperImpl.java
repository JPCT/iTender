package com.itender.bff.common.utils;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClassMapperImpl<T,U> implements ClassMapper <T,U> {
    @Override
    public U toDomain(T entity, U domain) {
        ModelMapper mapper = new ModelMapper();
        return (U) mapper.map(entity, domain.getClass());
    }

    @Override
    public T toEntity(U domain, T entity) {
        ModelMapper mapper = new ModelMapper();
        return (T) mapper.map(domain, entity.getClass());
    }
}
