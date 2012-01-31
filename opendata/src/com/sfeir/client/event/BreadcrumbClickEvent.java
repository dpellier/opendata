package com.sfeir.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class BreadcrumbClickEvent extends GwtEvent<BreadcrumbClickEventHandler> {

	public static Type<BreadcrumbClickEventHandler> TYPE = new Type<BreadcrumbClickEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<BreadcrumbClickEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(BreadcrumbClickEventHandler handler) {
		handler.onRegionClick(this);
	}

}
