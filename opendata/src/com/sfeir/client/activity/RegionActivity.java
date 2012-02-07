package com.sfeir.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.view.RegionView;
import com.sfeir.shared.RegionProxy;

public class RegionActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;

	

	public RegionActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}


	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		RegionView regionView = clientFactory.getRegionView();
		regionView.setPresenter(this);
		fetchAllRegion(regionView);
		containerWidget.setWidget(regionView.asWidget());
	}


	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	private void fetchAllRegion(final RegionView display) {
		clientFactory.getRequestFactory().regionRequest().findAllRegions().fire(new Receiver<List<RegionProxy>>() {
            @Override
            public void onSuccess(List<RegionProxy> response) {
            	display.setAllRegion(response);
            }
        });
	}

}
