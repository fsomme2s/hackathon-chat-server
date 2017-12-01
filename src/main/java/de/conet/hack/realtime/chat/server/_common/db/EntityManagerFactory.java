package de.conet.hack.realtime.chat.server._common.db;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;

/**
 * Factory for JPA EntityManager.
 */
@ApplicationScoped
public class EntityManagerFactory {

    @PersistenceContext(unitName = "INMEMORY")
    private EntityManager entityManager;

    @Produces
    @TransactionScoped
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
