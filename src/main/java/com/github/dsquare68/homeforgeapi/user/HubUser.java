package com.github.dsquare68.homeforgeapi.user;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Immutable snapshot of a HUB user exposed to plugins.
 *
 * <p>Plugins receive this object from {@link UserApi#currentUser()} and MUST NOT
 * cache it across requests – always re-fetch for freshness.
 *
 * @param id          unique user identifier
 * @param username    login username
 * @param email       email address
 * @param displayName optional display / full name
 * @param roles       set of role names, e.g. {@code ["USER", "ADMIN"]}
 */
public record HubUser(
        UUID id,
        String username,
        String email,
        String displayName,
        LocalDateTime createdAt,
        LocalDateTime lastLoginAt,
        Set<String> roles
) {}
