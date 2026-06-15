package com.github.dsquare68.homeforgeapi.dashboard;

/**
 * Register widgets on the HUB dashboard.
 *
 * <p>Example:
 * <pre>{@code
 * api.dashboard().registerWidget(
 *     WidgetDescriptor.builder()
 *         .id("gym.summary")
 *         .title("Today's Workout")
 *         .viewClass(GymSummaryWidget.class)
 *         .width(WidgetSize.MEDIUM)
 *         .build()
 * );
 * }</pre>
 */
public interface DashboardApi {

    /**
     * Register a widget contributed by this plugin.
     * Called during {@code HubPlugin#onActivate}.
     */
    void registerWidget(WidgetDescriptor descriptor);

    /**
     * Remove a previously registered widget.
     * Called automatically during plugin deactivation, but plugins may call
     * this explicitly to remove a widget at runtime.
     *
     * @param widgetId the id set in {@link WidgetDescriptor#id()}
     */
    void unregisterWidget(String widgetId);
}
