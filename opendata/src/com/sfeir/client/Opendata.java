package com.sfeir.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.sfeir.client.mvp.AppActivityMapper;
import com.sfeir.client.mvp.AppPlaceHistoryMapper;
import com.sfeir.client.place.BasicPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Opendata implements EntryPoint {

 	private SimplePanel mainPanel = new SimplePanel();
//	private SimplePanel breadcrumbPanel = new SimplePanel();
	private Place defaultPlace = new BasicPlace();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ClientFactory clientFactory = GWT.create(ClientFactory.class);

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper,
				clientFactory.getEventBus());
		activityManager.setDisplay(mainPanel);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), defaultPlace );

		RootPanel.get().add(mainPanel);
//		RootPanel.get("breadcrumbPanel").add(breadcrumbPanel);
		
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
	}
}
