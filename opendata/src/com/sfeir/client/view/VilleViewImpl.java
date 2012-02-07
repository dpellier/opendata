package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.VilleProxy;

public class VilleViewImpl extends Composite implements VilleView {

	@UiTemplate("Ville.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, VilleViewImpl> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	CellTable<VilleProxy> villes;
	@UiField(provided=true)
	SimplePager pager;
	private Presenter listener;
	private int nbVilleMax = 0;

	public VilleViewImpl() {
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setVisible(false);
		//pager.setDisplay(villes);
		initWidget(binder.createAndBindUi(this));
		defineTable();
	}
		
	/**
	 * Instancie et configure la table
	 * @return
	 */
	private void defineTable() {
		TextColumn<VilleProxy> nameColumn = new TextColumn<VilleProxy>() {
			@Override
			public String getValue(VilleProxy object) {
				return object.getName();
			}
		};
		
		villes.setWidth("100%", true);
		villes.addColumn(nameColumn);
	}

	@Override
	public void setAllVille(List<VilleProxy> villeList) {
		//villes.setRowCount(nbVilleMax);
		villes.setRowCount(villeList.size());
		villes.setRowData(0, villeList);
		
		pager.setVisible(true);
		pager.setDisplay(villes);
	}

	@Override
	public int getClickedRow(ClickEvent event) {
		//Cell row = villes.getCellForEvent(event);
		//return row.getRowIndex();
		return 0;
	}

	public void setPresenter(Presenter presenter) {
		this.listener = presenter;
	}

	public void setNbVilleMax(int nbVilleMax) {
		this.nbVilleMax = nbVilleMax;
	}

}
