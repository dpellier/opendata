package com.sfeir.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.sfeir.client.event.BreadcrumbClickEvent;
import com.sfeir.client.event.BreadcrumbClickEventHandler;
import com.sfeir.client.event.RegionClickEvent;
import com.sfeir.client.event.RegionClickEventHandler;
import com.sfeir.client.presenter.DepartPresenter;
import com.sfeir.client.presenter.Presenter;
import com.sfeir.client.presenter.RegionPresenter;
import com.sfeir.client.view.DepartView;
import com.sfeir.client.view.RegionView;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final ServiceOpenDataAsync rpcService;
	private HasWidgets container;

	public AppController(ServiceOpenDataAsync rpcService,
			HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);
		eventBus.addHandler(RegionClickEvent.TYPE,
				new RegionClickEventHandler() {
					public void onRegionClick(RegionClickEvent event) {
						doShowDepart(event.getId());
					}
				});
		eventBus.addHandler(BreadcrumbClickEvent.TYPE,
				new BreadcrumbClickEventHandler() {

					@Override
					public void onRegionClick(BreadcrumbClickEvent event) {
						doShowRegion();
					}

					@Override
					public void onDepartClick(BreadcrumbClickEvent event) {
						// TODO Auto-generated method stub
					}
				});
	}

	private void doShowDepart(Long id) {
		History.newItem("region_" + id);
		Presenter presenter = new DepartPresenter(id, rpcService, eventBus,
				new DepartView());
		presenter.go(container);
	}

	private void doShowRegion() {
		History.newItem("region");
		Presenter presenter = new RegionPresenter(rpcService, eventBus,
				new RegionView());
		presenter.go(container);
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;

		String token = History.getToken();
		if ("".equals(History.getToken())) {
			History.newItem("region");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("region")) {
				presenter = new RegionPresenter(rpcService, eventBus,
						new RegionView());
			} else if (token.startsWith("region_")) {
				Long idRegion = Long.parseLong(token.substring(
						token.indexOf('_') + 1, token.length()));
				presenter = new DepartPresenter(idRegion, rpcService, eventBus,
						new DepartView());
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

}
