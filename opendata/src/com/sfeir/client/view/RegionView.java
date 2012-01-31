package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.client.presenter.RegionPresenter;

public class RegionView extends Composite implements
		RegionPresenter.RegionDisplay {

	@UiTemplate("Region.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, RegionView> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	FlexTable regions = new FlexTable();

	public RegionView() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setAllRegion(List<String> regionList) {
		regions.removeAllRows();
		for (int index = 0; index < regionList.size(); index++) {
			regions.setText(index, 1, regionList.get(index));
		}
	}

	public int getClickedRow(ClickEvent event) {
		Cell row = regions.getCellForEvent(event);
		return row.getCellIndex();
	}

	public HasClickHandlers getList() {
		return regions;
	}

	public Widget asWidget() {
		return this;
	}
}
