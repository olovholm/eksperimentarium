package net.lovholm.eksperimentarium;


import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

    T findOne(final Long id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final Long entityId);
}
