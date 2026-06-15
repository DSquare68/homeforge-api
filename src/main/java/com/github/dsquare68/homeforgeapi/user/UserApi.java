package com.github.dsquare68.homeforgeapi.user;

import java.util.UUID;

/**
 * Provides authenticated user information to plugins.
 *
 * <p>All methods operate in the context of the currently authenticated session.
 */
public interface UserApi {

    /**
     * Returns the full {@link HubUser} for the currently authenticated user.
     *
     * @throws IllegalStateException if called outside a request context
     */
    HubUser currentUser();

    /**
     * Convenience method – returns only the current user's UUID.
     */
    default UUID currentUserId() {
        return currentUser().id();
    }

    /**
     * Returns {@code true} if the current user has the given role.
     *
     * @param role e.g. {@code "ADMIN"}, {@code "USER"}
     */
    boolean hasRole(String role);
}
