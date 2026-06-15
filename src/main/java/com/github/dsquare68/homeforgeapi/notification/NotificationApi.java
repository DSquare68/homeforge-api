package com.github.dsquare68.homeforgeapi.notification;

import java.util.UUID;

/**
 * Send in-platform notifications to HUB users.
 */
public interface NotificationApi {

    /**
     * Notify a specific user.
     *
     * @param userId   target user id
     * @param message  notification body text
     * @param severity {@link Severity#INFO}, {@link Severity#WARNING}, or {@link Severity#ERROR}
     */
    void notifyUser(UUID userId, String message, Severity severity);

    /**
     * Broadcast a notification to every logged-in user.
     * Use sparingly – reserved for platform-wide events.
     */
    void broadcast(String message, Severity severity);

    enum Severity {
        INFO, WARNING, ERROR
    }
}
