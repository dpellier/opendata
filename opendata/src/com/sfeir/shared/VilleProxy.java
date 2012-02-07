package com.sfeir.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(com.sfeir.server.domain.Ville.class)
public interface VilleProxy extends EntityProxy {
	
	String getId();
	String getName();
	String getDepartId();
}
