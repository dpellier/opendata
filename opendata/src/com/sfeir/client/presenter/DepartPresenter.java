package com.sfeir.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.client.ServiceOpenDataAsync;
import com.sfeir.client.presenter.RegionPresenter.RegionDisplay;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;

public class DepartPresenter implements Presenter {
	public static interface DepartDisplay {
		void setAllDepart(List<String> depart);
		HasClickHandlers getList();
		int getClickedRow(ClickEvent event);
		Widget asWidget();
	}

	private final ServiceOpenDataAsync rpcService;
	private final HandlerManager eventBus;
	private final DepartDisplay display;
	private List<Depart> departs = new ArrayList<Depart>();
	private Long idRegion;
	
	
	public DepartPresenter(Long idRegion, ServiceOpenDataAsync rpcService,
			HandlerManager eventBus, DepartDisplay view) {
		this.idRegion = idRegion;
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}
	
	public void go(final HasWidgets container) {
	    //bind();
	    container.clear();
	    container.add(display.asWidget());
	    fetchAllDepart();
	  }
	
	private void fetchAllDepart() {
		rpcService.getAllDepart(idRegion, new AsyncCallback<List<Depart>>() {
			
			@Override
			public void onSuccess(List<Depart> result) {
				departs = result;
				List<String> names = new ArrayList<String>();
				for (Depart dep : result) {
					names.add(dep.getName());
				}
				display.setAllDepart(names);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO a finir
			}
		});
}
}
