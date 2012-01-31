package com.sfeir.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sfeir.server.dao.DepartDao;
import com.sfeir.server.dao.RegionDao;

/**
 * Initialisation du data store au demarrage du contexte. 
 * @author sfeir
 *
 */
public class DatastoreContextListener implements ServletContextListener {

	

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		RegionDao regionDao = new RegionDao();
		regionDao.initData();
		new DepartDao().initData();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
