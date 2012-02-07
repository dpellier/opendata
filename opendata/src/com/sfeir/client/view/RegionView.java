package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.RegionProxy;

public interface RegionView extends IsWidget {

	void setAllRegion(List<RegionProxy> region);
	int getClickedRow(ClickEvent event);
	void setPresenter(Presenter presenter);
}