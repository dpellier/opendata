package com.sfeir.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sfeir.server.domain.Ville;

@Service(Ville.class)
public interface VilleRequest extends RequestContext {

	Request<Integer> countVilleByDepartId(String departId);
	Request<List<VilleProxy>> findAllVilles();
	Request<List<VilleProxy>> findVillesByDepartId(String departId, int firstResult, int maxResult);
	Request<List<VilleProxy>> findVillesByDepartId(String departId);
}
