package com.sfeir.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sfeir.server.domain.Depart;
import com.sfeir.server.domain.Region;
import com.sfeir.server.domain.Ville;

/**
 * Initialisation du data store au demarrage du contexte.
 * 
 * @author sfeir
 * 
 */
public class DatastoreContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if (Region.countRegion() == 0) {
			parseFichierRegion();
		}
		if (Depart.countDepart() == 0) {
			parseFichierDepart();
		}
		if (Ville.countVille() == 0) {
			parseFichierVille();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void parseFichierVille() {

		BufferedReader reader = null;
		String ligne = null;
		try {
			reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("liste_ville.txt"), "UTF-8"));
			while ((ligne = reader.readLine()) != null) {
				String[] data = ligne.split(";");
				Ville t = new Ville();
				t.setId(data[2] + data[3] + data[4]);
				t.setName(data[11]);
				t.setDepartId(data[3]);
				t.setVersion(1);
				t.persist();
			}
		} catch (Exception e) {
			throw new RuntimeException(
					"impossible de parser la ligne:" + ligne, e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	public void parseFichierRegion() {
		BufferedReader reader = null;
		try {
			String ligne;
			reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("liste_region.txt"), "UTF-8"));
			while ((ligne = reader.readLine()) != null) {
				String[] data = ligne.split("\\t+", -1);
				Region r = new Region();
				r.setId(data[0]);
				r.setVersion(1);
				r.setName(data[4]);
				r.persist();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	public void parseFichierDepart() {
		BufferedReader reader = null;
		try {
			String ligne;
			reader = new BufferedReader(new InputStreamReader(this.getClass()
					.getResourceAsStream("liste_depart.txt"), "UTF-8"));
			while ((ligne = reader.readLine()) != null) {
				String[] data = ligne.split("\\t+");
				Depart d = new Depart();
				d.setId(data[1]);
				d.setName(data[5]);
				d.setRegionId(data[0]);
				d.persist();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

}
