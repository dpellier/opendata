package com.sfeir.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.Ville;

public class VilleViewImpl extends Composite implements VilleView {

	@UiTemplate("Ville.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, VilleViewImpl> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	FlexTable villes = new FlexTable();
	private Presenter listener;
	private List<Ville> listVilles = new ArrayList<Ville>();

	public VilleViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setAllVille(List<Ville> villeList) {
		listVilles = villeList;
		for (int index = 0; index < villeList.size(); index++) {
			Label label = new Label(villeList.get(index).getName());
			label.setStyleName("pointer");
			villes.setWidget(index, 1, label);
		}

	}

	@Override
	public int getClickedRow(ClickEvent event) {
		Cell row = villes.getCellForEvent(event);
		return row.getRowIndex();
	}

	public void setPresenter(Presenter presenter) {
		this.listener = presenter;
	}
	
	public void clearRows() {
		villes.removeAllRows();
	}

}
