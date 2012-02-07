package com.sfeir.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sfeir.server.domain.Region;

@Service(Region.class)
public interface RegionRequest extends RequestContext {

	Request<List<RegionProxy>> findAllRegions();
	Request<List<RegionProxy>> findRegions(int firstResult, int maxResult);
}
