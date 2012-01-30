package com.sfeir.server;

import java.util.ArrayList;
import java.util.List;

import com.sfeir.client.ServiceOpenData;
import com.sfeir.server.dao.Region;
import com.sfeir.server.dao.RegionDao;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
* The server side implementation of the RPC service.
*/
@SuppressWarnings("serial")
public class ServiceOpenDataImpl extends RemoteServiceServlet implements ServiceOpenData {
	
	private final RegionDao regionDao = new RegionDao();
	
	public List<String> getAllRegion() {
		List<String> res = new ArrayList<String>();
		try {
			for (Region reg : regionDao.getAll("name")) {
				res.add(reg.getName());
			}
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public Void initAllData() {
		regionDao.initData();
		return null;
	}
}
