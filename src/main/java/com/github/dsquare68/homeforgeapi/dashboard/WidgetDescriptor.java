package com.github.dsquare68.homeforgeapi.dashboard;


/**
 * Describes a dashboard widget contributed by a plugin.
 *
 * @param id        unique widget id, e.g. {@code "gym.summary"} –
 *                  must be stable across restarts
 * @param title     human-readable title shown in the widget header
 * @param viewClass Vaadin {@link Component} subclass that renders the widget
 * @param size      preferred grid size
 * @param order     preferred sort order on the dashboard (lower = earlier)
 */
public record WidgetDescriptor(
        String id,
        String title,
        int order
) {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String title;
        private int order = 100;

        public Builder id(String id)                               { this.id = id; return this; }
        public Builder title(String title)                         { this.title = title; return this; }
        public Builder order(int order)                            { this.order = order; return this; }

        public WidgetDescriptor build() {
            if (id == null || title == null) {
                throw new IllegalStateException("id, title and viewClass are required");
            }
            return new WidgetDescriptor(id, title,  order);
        }
    }
}
