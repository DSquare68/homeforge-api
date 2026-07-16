package com.github.dsquare68.homeforgeapi.ui;

import com.vaadin.flow.component.applayout.AppLayout;

/**
 * Shared parent layout for HUB plugin views.
 *
 * <p>This class lives in the plugin API on purpose: it is loaded by the HUB
 * host's (parent) classloader and is therefore the <em>same</em> {@code Class}
 * instance in both the host and every PF4J-loaded plugin. That identity is what
 * lets a plugin view declare {@code @Route(layout = BaseLayout.class)} and have
 * Vaadin match it across the plugin/host classloader boundary.
 *
 * <p>The HUB host's own {@code Home} view extends this class to add the
 * navbar/drawer chrome; plugin views route into that same shell.
 */
public class BaseLayout extends AppLayout {
}
