package com.sfeir.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sfeir.client.ServiceOpenData;
import com.sfeir.server.dao.RegionDao;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
* The server side implementation of the RPC service.
*/
@SuppressWarnings("serial")
public class ServiceOpenDataImpl extends RemoteServiceServlet implements ServiceOpenData {
	
	private final RegionDao regionDao = new RegionDao();
	
	public List<Region> getAllRegion() {
		List<Region> res = new ArrayList<Region>();
		try {
			for (Region reg : regionDao.getAll("name")) {
				res.add(reg);
			}
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<Depart> getAllDepart(Long idRegion) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Depart depart = new Depart();
		depart.setId(2l);
		depart.setName("Un departement");
		return Arrays.asList(depart);
	}
	
	
}
