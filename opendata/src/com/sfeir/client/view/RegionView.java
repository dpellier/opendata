package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.client.presenter.RegionPresenter;

public class RegionView extends Composite implements
		RegionPresenter.RegionDisplay {
	
	private DockLayoutPanel panel = null;
	private FlexTable regions = new FlexTable();
	
	public RegionView() {
		// Fil d'ariane
		HorizontalPanel fil = new HorizontalPanel();
		Anchor region = new Anchor("Region");
		region.setEnabled(false);
		fil.add(region);
		

		panel = new DockLayoutPanel(Unit.EM);
		panel.setSize("500px", "200px");
		panel.addNorth(fil, 2);
		panel.addSouth(new ScrollPanel(regions), 10);
		
		initWidget(panel);
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
