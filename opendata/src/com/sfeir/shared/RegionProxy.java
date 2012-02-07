package com.sfeir.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(com.sfeir.server.domain.Region.class)
public interface RegionProxy extends EntityProxy {
	
	String getId();
	String getName();
}
