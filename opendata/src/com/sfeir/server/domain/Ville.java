package com.sfeir.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;


@Entity
public class Ville {
	
	/** Methode obligatoire pour RF. */
	public Ville() {};

	@Id
	@Column(name="id")
	private String id;
	
	@Version
	@Column(name="version")
	private Integer version;

	private String name;
	private String departId;
	
	/** Methode obligatoire pour RF. */
	public String getId() { return id; }
	/** Methode obligatoire pour RF. */
	public Integer getVersion() { return version; }
	
	public void setVersion(Integer version) { this.version = version; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDepartId() { return departId; }
	public void setDepartId(String departId) { this.departId = departId; }

	
	
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
	
	public static long countVille() {
		EntityManager em = getEntityManager();
		try {
			return ((Number) em.createQuery("select count(v) from Ville v").getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	
	/** Methode obligatoire pour RF. */
	public static Ville findVille(String id) {
		if (id == null) {
			return null;
		}
		EntityManager em = getEntityManager();
		try {
			Ville town = em.find(Ville.class, id);
			return town;
		} finally {
			em.close();
		}
	}

	/**
	 * @return Toutes les villes
	 */
	@SuppressWarnings("unchecked")
	public static List<Ville> findAllVilles() {
		EntityManager em = getEntityManager();
		try {
			List<Ville> villes = em.createQuery("select v from Ville v")
					.getResultList();
			// force la recuperation de toutes les villes.
			villes.size();
			return villes;
		} finally {
			em.close();
		}
	}

	/**
	 * @param firstResult
	 * @param maxResult
	 * @return - pour la pagination, retourne toutes les villes commencant a firstResult et se limitant a maxResult.
	 */
	@SuppressWarnings("unchecked")
	public static List<Ville> findVilles(int firstResult, int maxResult) {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select v from Ville v");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			List<Ville> villes = query.getResultList();
			return villes;
		} finally {
			em.close();
		}
	}

	public static List<Ville> findVillesByDepartId(String departId) {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select v from Ville v where v.departId =:departId order by v.name");
			query.setParameter("departId", departId);
			@SuppressWarnings("unchecked")
			List<Ville> villes = query.getResultList();
			villes.size();
			return villes;
		} finally {
			em.close();
		}
	}
}
