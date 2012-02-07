package com.sfeir.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sfeir.server.domain.Depart;

@Service(Depart.class)
public interface DepartRequest extends RequestContext {

	Request<List<DepartProxy>> findAllDeparts();
	Request<List<DepartProxy>> findDeparts(int firstResult, int maxResult);
	Request<List<DepartProxy>> findDepartsByRegionId(String regionId);
}
