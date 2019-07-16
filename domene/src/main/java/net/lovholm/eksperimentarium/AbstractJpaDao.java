package net.lovholm.eksperimentarium;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractJpaDao< T extends Serializable> {

    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public void setClazz( Class< T > clazzToSet ) {
        this.clazz = clazzToSet;
    }

    public T findOne( Long id ){
        return entityManager.find( clazz, id );
    }
    public List< T > findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    public T create( T entity ){
        entityManager.persist( entity );
        entityManager.flush();
        return entity;
    }

    public T update( T entity ){
        entityManager.merge( entity );
        entityManager.flush();

        return entity;
    }

    public void delete( T entity ){
        entityManager.remove( entity );
        entityManager.flush();

    }
    public void deleteById( Long entityId ){
        T entity = findOne( entityId );
        delete( entity );
    }
}