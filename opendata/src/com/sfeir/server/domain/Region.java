package com.sfeir.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;


@Entity
public class Region {
	
	/** Methode obligatoire pour RF. */
	public Region() {};

	@Id
	@Column(name="id")
	private String id;
	
	@Version
	@Column(name="version")
	private Integer version;

	private String name;
	
	/** Methode obligatoire pour RF. */
	public String getId() { return id; }
	/** Methode obligatoire pour RF. */
	public Integer getVersion() { return version; }
	
	public void setVersion(Integer version) { this.version = version; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static final EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
	
	public void persist() {
		EntityManager em = getEntityManager();
		try {
			em.persist(this);
		} finally {
			em.close();
		}
	}
	
	public static long countRegion() {
		EntityManager em = getEntityManager();
		try {
			return ((Number) em.createQuery("select count(v) from Region v").getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	
	/** Methode obligatoire pour RF. */
	public static Region findRegion(String id) {
		if (id == null) {
			return null;
		}
		EntityManager em = getEntityManager();
		try {
			Region region = em.find(Region.class, id);
			return region;
		} finally {
			em.close();
		}
	}

	/**
	 * @return Toutes les regions
	 */
	@SuppressWarnings("unchecked")
	public static List<Region> findAllRegions() {
		EntityManager em = getEntityManager();
		try {
			List<Region> regions = em.createQuery("select v from Region v order by v.name").getResultList();
			regions.size();
			return regions;
		} finally {
			em.close();
		}
	}

	/**
	 * @param firstResult
	 * @param maxResult
	 * @return - pour la pagination, retourne toutes les regions commencant a firstResult et se limitant a maxResult.
	 */
	@SuppressWarnings("unchecked")
	public static List<Region> findRegions(int firstResult, int maxResult) {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select v from Region v");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			List<Region> regions = query.getResultList();
			return regions;
		} finally {
			em.close();
		}
	}
}
