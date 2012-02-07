package com.sfeir.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;


@Entity
public class Depart {
	
	/** Methode obligatoire pour RF. */
	public Depart() {};

	@Id
	@Column(name="id")
	private String id;
	
	@Version
	@Column(name="version")
	private Integer version;

	private String name;
	private String regionId;
	
	/** Methode obligatoire pour RF. */
	public String getId() { return id; }
	/** Methode obligatoire pour RF. */
	public Integer getVersion() { return version; }
	
	public void setVersion(Integer version) { this.version = version; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getRegionId() { return regionId; }
	public void setRegionId(String regionId) { this.regionId = regionId; }

	
	
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
	
	public static long countDepart() {
		EntityManager em = getEntityManager();
		try {
			return ((Number) em.createQuery("select count(v) from Depart v").getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	
	/** Methode obligatoire pour RF. */
	public static Depart findDepart(String id) {
		if (id == null) {
			return null;
		}
		EntityManager em = getEntityManager();
		try {
			Depart depart = em.find(Depart.class, id);
			return depart;
		} finally {
			em.close();
		}
	}

	/**
	 * @return Tous les depart
	 */
	@SuppressWarnings("unchecked")
	public static List<Depart> findAllDeparts() {
		EntityManager em = getEntityManager();
		try {
			List<Depart> departs = em.createQuery("select v from Depart v").getResultList();
			departs.size();
			return departs;
		} finally {
			em.close();
		}
	}

	/**
	 * @param firstResult
	 * @param maxResult
	 * @return - pour la pagination, retourne tous les depart commencant a firstResult et se limitant a maxResult.
	 */
	@SuppressWarnings("unchecked")
	public static List<Depart> findDeparts(int firstResult, int maxResult) {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select v from Depart v");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			List<Depart> departs = query.getResultList();
			return departs;
		} finally {
			em.close();
		}
	}

	public static List<Depart> findDepartsByRegionId(String regionId) {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select v from Depart v where v.regionId =:regionId order by v.name");
			query.setParameter("regionId", regionId);
			@SuppressWarnings("unchecked")
			List<Depart> departs = query.getResultList();
			departs.size();
			return departs;
		} finally {
			em.close();
		}
	}
}
