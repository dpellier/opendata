package com.sfeir.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface BreadcrumbClickEventHandler extends EventHandler {
	void onRegionClick(BreadcrumbClickEvent event);

	void onDepartClick(BreadcrumbClickEvent event);
}
