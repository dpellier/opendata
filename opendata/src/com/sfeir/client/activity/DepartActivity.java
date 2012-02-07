package com.sfeir.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.place.DepartPlace;
import com.sfeir.client.view.DepartView;
import com.sfeir.shared.DepartProxy;

public class DepartActivity extends AbstractActivity implements Presenter {
	
	private ClientFactory clientFactory;
	private String idRegion;


	public DepartActivity(DepartPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		idRegion = place.getIdRegion();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
	

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		DepartView view = clientFactory.getDepartView();
		view.setPresenter(this);
		fetchAllDepart(view);
		containerWidget.setWidget(view.asWidget());
	}
	

	private void fetchAllDepart(final DepartView display) {
		clientFactory.getRequestFactory().departRequest().findDepartsByRegionId(idRegion).fire(new Receiver<List<DepartProxy>>() {
            @Override
            public void onSuccess(List<DepartProxy> response) {
            	display.setAllDepart(response, idRegion);
            }
        });
	}

}
