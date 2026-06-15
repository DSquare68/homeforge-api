package com.github.dsquare68.homeforgeapi.spi;


import org.pf4j.ExtensionPoint;

/**
 * Primary SPI that every HUB plugin must implement.
 *
 * <p>HUB calls lifecycle methods in this order:
 * <ol>
 *   <li>{@link #getMetadata()} – read once at install time</li>
 *   <li>{@link #onInstall(HubApi)} – first-ever install (run migrations, seed data)</li>
 *   <li>{@link #onActivate(HubApi)} – every time the plugin is enabled</li>
 *   <li>{@link #registerRoutes(RouteConfiguration)} – register Vaadin routes</li>
 *   <li>{@link #onDeactivate()} – plugin being disabled</li>
 *   <li>{@link #onUninstall()} – plugin being permanently removed</li>
 * </ol>
 */
public interface HubPlugin extends ExtensionPoint {

    /**
     * Static metadata – read before the plugin is started.
     */
    PluginMetadata getMetadata();

    /**
     * Called once when the plugin is first installed.
     * Use this to run database migrations and seed required data.
     *
     * @param api the HUB platform API
     */
    void onInstall(HubApi api);

    /**
     * Called every time the plugin transitions from DISABLED → STARTED.
     *
     * @param api the HUB platform API
     */
    void onActivate(HubApi api);

    /**
     * Register Vaadin routes contributed by this plugin.
     * HUB calls this after {@link #onActivate(HubApi)} so that routes
     * are only live while the plugin is active.
     *
     * @param routes Vaadin's dynamic route configuration
     */
    void registerRoutes(String routes);

    /**
     * Called when the plugin transitions from STARTED → DISABLED.
     * Clean up in-memory state here; do NOT drop database objects.
     */
    void onDeactivate();

    /**
     * Called when the plugin is permanently removed.
     * Drop plugin-owned database schema/objects here if desired.
     */
    default void onUninstall() {
        // optional – override to perform cleanup
    }
}
