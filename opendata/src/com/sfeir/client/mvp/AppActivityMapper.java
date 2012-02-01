package com.sfeir.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.activity.DepartActivity;
import com.sfeir.client.activity.RegionActivity;
import com.sfeir.client.place.BasicPlace;
import com.sfeir.client.place.DepartPlace;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	

	@Override
	public Activity getActivity(Place place) {
		EventBus eventBus = clientFactory.getEventBus();
		if (place instanceof BasicPlace)
			return new RegionActivity(clientFactory);
		else if (place instanceof DepartPlace)
			return new DepartActivity((DepartPlace) place, clientFactory);

		return null;
	}



}
