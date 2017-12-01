package de.conet.hack.realtime.chat.server.entities._common;

/**
 * Common interface for all Enums that must be persisted. Every Enum-Value needs a unique id per enum-class, that is
 * stored in the database.
 */
public interface PersistableEnum<T> {
    /**
     *
     * @return The value that is stored in the database for the enum-value.
     */
    T getEnumId();
}
