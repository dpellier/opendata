package com.sfeir.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Opendata implements EntryPoint {


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ServiceOpenDataAsync rpcService = GWT.create(ServiceOpenData.class);
		HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(rpcService, eventBus);
	    appViewer.go(RootPanel.get());
	}
}

