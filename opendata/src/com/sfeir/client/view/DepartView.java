package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.sfeir.client.presenter.DepartPresenter.DepartDisplay;

public class DepartView extends Composite implements DepartDisplay {

	@UiTemplate("Depart.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, DepartView> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	FlexTable departements = new FlexTable();
	@UiField
	Anchor region;

	public DepartView() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setAllDepart(List<String> departList) {

		for (int index = 0; index < departList.size(); index++) {
			Label label = new Label(departList.get(index));
			label.setStyleName("pointer");
			departements.setWidget(index, 1, label);
		}

	}

	@Override
	public HasClickHandlers getList() {
		return departements;
	}

	@Override
	public int getClickedRow(ClickEvent event) {
		Cell row = departements.getCellForEvent(event);
		return row.getCellIndex();
	}

	@Override
	public HasClickHandlers getLienRegion() {
		return region;
	}

}
