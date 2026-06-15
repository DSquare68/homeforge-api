package com.github.dsquare68.homeforgeapi.spi;

/**
 * Immutable descriptor returned by {@link HubPlugin#getMetadata()}.
 *
 * <p>HUB uses this to:
 * <ul>
 *   <li>Register the plugin in the database</li>
 *   <li>Add a sidebar entry (icon + label pointing to {@code path})</li>
 *   <li>Create the plugin's dedicated PostgreSQL schema ({@code schema})</li>
 * </ul>
 *
 * @param id          unique snake_case identifier, e.g. {@code gym_tracker}
 * @param name        human-readable display name, e.g. {@code Gym Tracker}
 * @param version     semver string, e.g. {@code 1.0.0}
 * @param description short description shown in the plugin manager
 * @param path        URL path under HUB root, e.g. {@code /gym} → accessible at
 *                    {@code https://hub.local/gym}
 * @param schema      PostgreSQL schema name for plugin-owned tables,
 *                    e.g. {@code gym_schema}
 * @param icon        Vaadin Lumo icon name or {@code null} for default
 */
public record PluginMetadata(
        String id,
        String name,
        String version,
        String description,
        String path,
        String schema,
        String icon
) {
    /**
     * Convenience factory – uses {@code null} icon (HUB will render a puzzle-piece default).
     */
    public static PluginMetadata of(
            String id, String name, String version,
            String description, String path, String schema) {
        return new PluginMetadata(id, name, version, description, path, schema, null);
    }
}
