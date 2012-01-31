package com.sfeir.server.dao;

import com.googlecode.objectify.ObjectifyService;
import com.sfeir.shared.Region;

public class RegionDao extends GenericDao<Region> {
	
	static {
		ObjectifyService.register(Region.class);
	}

	public RegionDao() {
		super(Region.class);
	}
	
	public void initData () {
		if (ofy().query(Region.class).count() == 0) {
			this.add(new Region("Guadeloupe", new String[]{}));
			this.add(new Region("Martinique", new String[]{}));
			this.add(new Region("Guyane", new String[]{}));
			this.add(new Region("La Réunion", new String[]{}));
			this.add(new Region("Île-de-France", new String[]{}));
			this.add(new Region("Champagne-Ardenne", new String[]{}));
			this.add(new Region("Picardie", new String[]{}));
			this.add(new Region("Haute-Normandie", new String[]{}));
			this.add(new Region("Centre", new String[]{}));
			this.add(new Region("Basse-Normandie", new String[]{}));
			this.add(new Region("Bourgogne", new String[]{}));
			this.add(new Region("Nord-Pas-de-Calais", new String[]{}));
			this.add(new Region("Lorraine", new String[]{}));
			this.add(new Region("Alsace", new String[]{}));
			this.add(new Region("Franche-Comté", new String[]{}));
			this.add(new Region("Pays de la Loire", new String[]{}));
			this.add(new Region("Bretagne", new String[]{}));
			this.add(new Region("Poitou-Charentes", new String[]{}));
			this.add(new Region("Aquitaine", new String[]{}));
			this.add(new Region("Midi-Pyrénées", new String[]{}));
			this.add(new Region("Limousin", new String[]{}));
			this.add(new Region("Rhône-Alpes", new String[]{}));
			this.add(new Region("Auvergne", new String[]{}));
			this.add(new Region("Languedoc-Roussillon", new String[]{}));
			this.add(new Region("Provence-Alpes-Côte d'Azur", new String[]{}));
			this.add(new Region("Corse", new String[]{}));
		}
	}
}
