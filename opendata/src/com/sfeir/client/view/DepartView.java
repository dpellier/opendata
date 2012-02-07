package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.DepartProxy;

public interface DepartView extends IsWidget {

	void setAllDepart(List<DepartProxy> depart, String idRegion);
	void setPresenter(Presenter presenter);
	int getClickedRow(ClickEvent event);

}