package com.sfeir.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.sfeir.client.view.DepartView;
import com.sfeir.client.view.DepartViewImpl;
import com.sfeir.client.view.RegionView;
import com.sfeir.client.view.RegionViewImpl;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final RegionView regionView = new RegionViewImpl();
	private static final DepartView departView = new DepartViewImpl();
	private static final ServiceOpenDataAsync rpcService = GWT.create(ServiceOpenData.class);
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}
	

	@Override
	public RegionView getRegionView() {
		return regionView;
	}

	@Override
	public DepartView getDepartView() {
		return departView;
	}

	@Override
	public ServiceOpenDataAsync getRpcService() {
		return rpcService;
	}

	
}