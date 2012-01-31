package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.sfeir.client.presenter.DepartPresenter.DepartDisplay;

public class DepartView extends Composite implements DepartDisplay {
	
	private DockLayoutPanel panel = null;
	private FlexTable departements = new FlexTable();
	
	public DepartView() {
		// Fil d'ariane
		HorizontalPanel fil = new HorizontalPanel();
		Anchor region = new Anchor("Region");
		region.setEnabled(true);
		Anchor departement = new Anchor("Departement");
		departement.setEnabled(false);
		fil.add(region);
		fil.add(departement);

		panel = new DockLayoutPanel(Unit.EM);
		panel.setSize("500px", "200px");
		panel.addNorth(fil, 2);
		panel.addSouth(new ScrollPanel(departements), 10);
		
		initWidget(panel);
	}
	

	@Override
	public void setAllDepart(List<String> departList) {
		
		for (int index = 0; index < departList.size(); index++) {
			departements.setText(index, 0, departList.get(index));
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

}
