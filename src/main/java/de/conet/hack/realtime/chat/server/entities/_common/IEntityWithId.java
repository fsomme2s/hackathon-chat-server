package de.conet.hack.realtime.chat.server.entities._common;

/**
 * JPA Entities with ID of type T
 * @param <T> Type of the Entitie's ID
 */
public interface IEntityWithId<T> {
    T getId();
    void setId(T id);
}
