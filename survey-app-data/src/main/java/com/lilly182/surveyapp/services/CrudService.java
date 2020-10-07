package com.lilly182.surveyapp.services;

public interface CrudService<T,ID> {
    Iterable<T> list();

    T create(T object);

    T read(ID id);

    T update(ID id, T object);

    void delete(ID id);
}
