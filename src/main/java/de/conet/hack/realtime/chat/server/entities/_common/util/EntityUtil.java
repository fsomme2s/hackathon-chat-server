package de.conet.hack.realtime.chat.server.entities._common.util;


import de.conet.hack.realtime.chat.server.entities._common.EntityWithId;
import de.conet.hack.realtime.chat.server.entities._common.IEntityWithId;

/**
 * Provides Helper-Methods for common tasks on
 * {@link IEntityWithId Entity classes}
 */
public final class EntityUtil {
    private EntityUtil() { /* Only static helper methods */ }

    /**
     * Check if an entity already exists in the database.
     *
     * @param entity
     * @return true if the given entity already has a valid ID, false otherwise.
     */
    public static boolean isPersisted(EntityWithId entity) {
        return entity.getId() != null && entity.getId() != 0;
    }

    /**
     * Throws an Exception if the given entity is not persisted.
     * <p>
     *  Use this method when it is not allowed to execute business logic on a nonpersistent entity, for example in
     *  a method that should update but not create an entity in the database.
     * </p>
     *
     * @param entity the entity to check
     * @throws IllegalStateException it the given entity is not persisted yet.
     */
    public static void assertPersisted(EntityWithId entity) throws IllegalStateException {
        if (! EntityUtil.isPersisted(entity)) {
            throw new IllegalStateException(String.format(
                    "Cannot update non-persistent %s entity!",
                    entity.getClass().getSimpleName()
            ));
        }
    }
}
