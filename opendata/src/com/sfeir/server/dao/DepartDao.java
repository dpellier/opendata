package com.sfeir.server.dao;

import com.googlecode.objectify.ObjectifyService;
import com.sfeir.shared.Depart;

public class DepartDao extends GenericDao<Depart> {

	static {
		ObjectifyService.register(Depart.class);
	}

	public DepartDao() {
		super(Depart.class);
	}

	public void initData() {
		if (ofy().query(Depart.class).count() == 0) {
			this.add(new Depart("Essonne"));
			this.add(new Depart("Hauts de Seine"));
		}
	}
}
