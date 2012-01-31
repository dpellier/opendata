package com.sfeir.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class RegionClickEvent extends GwtEvent<RegionClickEventHandler> {
	public static Type<RegionClickEventHandler> TYPE = new Type<RegionClickEventHandler>();
	private final Long id;

	public RegionClickEvent(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public Type<RegionClickEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RegionClickEventHandler handler) {
		handler.onRegionClick(this);
	}
}