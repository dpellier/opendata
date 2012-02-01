package com.sfeir.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.sfeir.client.view.DepartView;
import com.sfeir.client.view.RegionView;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	ServiceOpenDataAsync getRpcService();
	RegionView getRegionView();
	DepartView getDepartView();
}
