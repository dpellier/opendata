package com.sfeir.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.place.VillePlace;
import com.sfeir.client.view.VilleView;
import com.sfeir.shared.VilleProxy;

public class VilleActivity extends AbstractActivity implements Presenter {
	
	private ClientFactory clientFactory;
	private String idDepart;
	private String idRegion;


	public VilleActivity(VillePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		idDepart = place.getIdDepart();
		idRegion = place.getIdRegion();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
	

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		VilleView view = clientFactory.getVilleView();
		view.setPresenter(this);
		initPaging(view);
		fetchAllVille(view);
		containerWidget.setWidget(view.asWidget());
	}
	

	private void fetchAllVille(final VilleView display) {
		clientFactory.getRequestFactory().villeRequest().findVillesByDepartId(idDepart, 0, 15).fire(new Receiver<List<VilleProxy>>() {
            @Override
            public void onSuccess(List<VilleProxy> response) {
            	display.setAllVille(response);
            }
        });
	}
	
	private void initPaging(final VilleView display) {
		clientFactory.getRequestFactory().villeRequest().countVilleByDepartId(idDepart).fire(new Receiver<Integer>() {
            @Override
            public void onSuccess(Integer response) {
            	display.setNbVilleMax(response);
            }
        });
	}
}
