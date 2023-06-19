package com.renstate.platform.renstate.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    T save(T t) throws Exception;
    List<T> getAll() throws Exception;
    Optional<T> getById(Long id) throws Exception;
    void delete (Long id) throws Exception;
}
