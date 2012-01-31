package com.sfeir.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.client.ServiceOpenDataAsync;
import com.sfeir.client.event.RegionClickEvent;
import com.sfeir.shared.Region;

public class RegionPresenter implements Presenter {

	public static interface RegionDisplay {
		void setAllRegion(List<String> region);

		HasClickHandlers getList();

		int getClickedRow(ClickEvent event);

		Widget asWidget();
	}

	private final ServiceOpenDataAsync rpcService;
	private final HandlerManager eventBus;
	private final RegionDisplay display;
	private List<Region> regions = new ArrayList<Region>();

	public RegionPresenter(ServiceOpenDataAsync rpcService,
			HandlerManager eventBus, RegionDisplay view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}

	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
		fetchAllRegion();
	}

	private void bind() {
		display.getList().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int selectedRow = display.getClickedRow(event);

				if (selectedRow >= 0) {
					Long id = regions.get(selectedRow).getId();
					eventBus.fireEvent(new RegionClickEvent(id));
				}
			}
		});
	}

	private void fetchAllRegion() {
		rpcService.getAllRegion(new AsyncCallback<List<Region>>() {

			@Override
			public void onSuccess(List<Region> result) {
				regions = result;
				List<String> names = new ArrayList<String>();
				for (Region reg : result) {
					names.add(reg.getName());
				}
				display.setAllRegion(names);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO a finir
			}
		});
	}
}
