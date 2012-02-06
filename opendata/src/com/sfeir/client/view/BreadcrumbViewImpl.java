package com.sfeir.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.client.activity.Presenter;

public class BreadcrumbViewImpl implements BreadcrumbView {


	@UiTemplate("Breadcrumb.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, BreadcrumbViewImpl> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	private Presenter listener;
	@UiField
	UListElement liste;
	
	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.listener = presenter; 
	}

}
