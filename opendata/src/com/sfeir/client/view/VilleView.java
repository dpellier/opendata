package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.VilleProxy;

public interface VilleView extends IsWidget {

	void setAllVille(List<VilleProxy> allVilles);
	void setPresenter(Presenter presenter);
	int getClickedRow(ClickEvent event);
	void setNbVilleMax(int nbVille);
}