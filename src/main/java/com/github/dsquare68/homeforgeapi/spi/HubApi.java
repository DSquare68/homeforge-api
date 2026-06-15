package com.github.dsquare68.homeforgeapi.spi;

import com.github.dsquare68.homeforgeapi.dashboard.DashboardApi;
import com.github.dsquare68.homeforgeapi.notification.NotificationApi;
import com.github.dsquare68.homeforgeapi.storage.StorageApi;
import com.github.dsquare68.homeforgeapi.user.UserApi;

/**
 * Root API object passed to plugins during lifecycle callbacks.
 *
 * <p>Plugins MUST use these APIs instead of accessing platform infrastructure directly.
 *
 * <pre>{@code
 * // In your HubPlugin implementation:
 * public void onActivate(HubApi api) {
 *     this.currentUser = api.user().currentUser();
 *     api.notifications().notifyUser(currentUser.id(), "Plugin activated!", Severity.INFO);
 * }
 * }</pre>
 */
public interface HubApi {

    /** Access authenticated user information. */
    UserApi user();

    /** Persist and retrieve plugin-scoped data. */
    StorageApi storage();

    /** Send notifications through HUB. */
    NotificationApi notifications();

    /** Register dashboard widgets. */
    DashboardApi dashboard();
}
