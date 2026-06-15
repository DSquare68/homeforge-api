package com.github.dsquare68.homeforgeapi.storage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Plugin-scoped key-value / entity storage.
 *
 * <p>All operations are automatically scoped to the calling plugin's schema.
 * Plugins MUST NOT issue raw SQL against the shared {@code hub_schema}.
 *
 * <p>For advanced use-cases (JPA entities, Flyway migrations) plugins receive a
 * dedicated {@link javax.sql.DataSource} pre-configured for their own schema –
 * see {@code HubApi#storage().dataSource()}.
 */
public interface StorageApi {

    /**
     * Persist an entity.  Returns the saved instance (may carry generated id).
     */
    <T> T save(T entity);

    /**
     * Find an entity by its primary key.
     */
    <T> Optional<T> findById(Class<T> type, UUID id);

    /**
     * Return all entities of the given type owned by the calling plugin.
     */
    <T> List<T> findAll(Class<T> type);

    /**
     * Delete an entity by its primary key.
     *
     * @return {@code true} if an entity was actually deleted
     */
    <T> boolean delete(Class<T> type, UUID id);

    /**
     * A {@link javax.sql.DataSource} scoped to the plugin's PostgreSQL schema.
     * Use this to drive Flyway migrations or a plugin-local JPA context.
     */
    javax.sql.DataSource dataSource();
}
