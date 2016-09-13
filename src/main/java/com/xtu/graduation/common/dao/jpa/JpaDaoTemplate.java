package com.xtu.graduation.common.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.xtu.graduation.common.dao.IDaoSupport;
/**
 * 基于jpa的dao基类(IDaoSupport)的接口实现
 * @author Xia
 * @since JpaDaoTemplate.java 2016年3月29日
 */
public class JpaDaoTemplate implements IDaoSupport{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	/**
	 * query preparation
	 * @param query      a query object of JPA
	 * @param params   parameters for the query
	 */
	private void prepareQuery(Query query, Object... params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
	}
	/**
	 * query preparation
	 * @param query      a query object of JPA
	 * @param params   parameters for the query
	 */
	private void prepareQuery(Query query, Map<String, ?> params) {
		if (params != null) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}
	/**
	 * query preparation for pagination
	 * @param query      a query object of JPA
 	 * @param firstResult  the first record's position
	 * @param maxResult  the offset of the query

	 */
	private void prepareQuery(Query query, int firstResult, int maxResult) {
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
	}
	/**
	 * query preparation for pagination
	 * @param query      a query object of JPA
 	 * @param firstResult  the first record's position
	 * @param maxResult  the offset of the query
	 	 * 	@param params   parameters for the query
	 */
	private void prepareQuery(Query query, int firstResult, int maxResult,
			Object... params) {
		prepareQuery(query, params);
		prepareQuery(query, firstResult, maxResult);
	}
	/**
	 * query preparation for pagination
	 * @param query      a query object of JPA
 	 * @param firstResult  the first record's position
	 * @param maxResult  the offset of the query
	 * 	@param params   parameters for the query
	 */
	private void prepareQuery(Query query, int firstResult, int maxResult,
			Map<String, ?> params) {
		prepareQuery(query, params);
		prepareQuery(query, firstResult, maxResult);
	}

	@Override
	/**
	 * is the object in the entities' cache
	 * @param the objects to be checked in the cache of the persistance manager
	 */
	public boolean contains(Object entity) {
		return em.contains(entity);
	}

	@Override
	/**
	 * refreshing entities' cache
	 * @param the objects to be refreshed in the cache of the persistance manager
	 */
	public void refresh(Object entity) {
		em.refresh(entity);
	}

	@Override
	/**
	 * saving the object
	 * @param the objects to be saved 
	 */
	public void save(Object entity) {
		em.persist(entity);
	}

	@Override
	/**
	 * saving the object
	 * @param the objects to be updated 
	 */
	public void update(Object entity) {
		em.merge(entity);
	}

	@Override
	/**
	 * saving the object
	 * @param the object to be deleted 
	 */
	public void delete(Object entity) {
		em.remove(entity);
	}

	@Override
	/**
	 * saving the object
	 * @param the object to be deleted 
	 */
	public void delete(Class<?> entityClass, Object id) {
		em.remove(em.getReference(entityClass, id));
	}

	@Override
	/**
	 * saving the object
	 * @param the object to be deleted 
	 */
	public void delete(Class<?> entityClass, List<?> ids) {
		String queryString = "DELETE FROM " + entityClass.getName()
				+ " entity WHERE entity.id IN (:ids)";
		Query query = em.createQuery(queryString);
		query.setParameter("ids", ids);
		query.executeUpdate();
	}

	@Override
	/**
	 * updating the objects via query string
	 * @param the query string 
	 */
	public void execute(String queryString) {
		Query query = em.createQuery(queryString);
		query.executeUpdate();
	}

	@Override
	/**
	 * updating the objects via query string
	 * @param the query string
	 * @param the object string
	 */
	public void execute(String queryString, Object... params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, params);
		query.executeUpdate();
	}

	@Override
	/**
	 * updating the objects via query string and map
	 * @param the query string   the HQL
	 * @param the object string   THE DATA PARAMETER MAP
	 */
	public void execute(String queryString, Map<String, ?> params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, params);
		query.executeUpdate();
	}

	@Override
	/**
	 * EXEUCTE A SQL BASED UPDATE SQL
	 * @param the query string   the HQL
	 */
	public void executeBySql(String queryString) {
		Query query = em.createNativeQuery(queryString);
		query.executeUpdate();
	}

	@Override
	/**
	 * EXEUCTE A SQL BASED UPDATE SQL AND PARAMETERS LIST
	 * 	@param the query string   the HQL
	 * @param the object oBJECT   THE DATA PARAMETER lIST
	 */
	public void executeBySql(String queryString, Object... params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, params);
		query.executeUpdate();
	}

	@Override
	/**
	 * EXEUCTE A SQL BASED UPDATE SQL AND PARAMETERS MAP
	 * 	@param the query string   the SQL
	 * @param the params oBJECT   THE DATA PARAMETER lIST
	 */
	public void executeBySql(String queryString, Map<String, ?> params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, params);
		query.executeUpdate();
	}

	@Override
	/**
	 * LOAD OBJEC TBY CLASS INACTANCE AND ID
	 * 	@param the entityClass string   the CLASS OBJECT
	 * @param the id  THE ID OF THE OBJECT INSTANCE
	 */
	public <T> T find(Class<T> entityClass, Object id) {
		return em.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * LOAD OBJEC TBY CLASS INACTANCE AND QUERY STRING
	 * 	@param the entityClass string   the CLASS OBJECT
	 * @param the queryString  THE hql 
	 */
	public <T> T find(Class<T> resultClass, String queryString) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, 0, 1);
		List<T> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * LOAD OBJEC TBY CLASS INACTANCE AND QUERY STRING AND PARAMETER LIST
	 * 	@param the entityClass string   the CLASS OBJECT
	 * @param the queryString  THE hql 
	 * @param the params  THE parameters for the query
	 */
	public <T> T find(Class<T> resultClass, String queryString,
			Object... params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, 0, 1, params);
		List<T> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * LOAD OBJEC TBY CLASS INACTANCE AND QUERY STRING AND PARAMETER LIST
	 * 	@param the entityClass string   the CLASS OBJECT
	 * @param the queryString  THE hql 
	 * @param the params  THE parameters map for the query
	 */
	public <T> T find(Class<T> resultClass, String queryString,
			Map<String, ?> params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, 0, 1, params);
		List<T> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Object findBySql(String queryString) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, 0, 1);
		List<?> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Object findBySql(String queryString, Object... params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, 0, 1, params);
		List<?> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Object findBySql(String queryString, Map<String, ?> params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, 0, 1, params);
		List<?> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	/**
	 * list all objects via HQL
	 * 	@param resultClass   The class instance of the result
	 */
	public <T> List<T> list(Class<T> entityClass) {
		String queryString = "SELECT entity FROM " + entityClass.getName()
				+ " entity";
		return list(entityClass, queryString);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param ids         query id list
	 */
	public <T> List<T> list(Class<T> entityClass, List<?> ids) {
		String queryString = "SELECT entity FROM " + entityClass.getName()
				+ " entity WHERE entity.id IN (:ids)";
		Query query = em.createQuery(queryString);
		query.setParameter("ids", ids);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param ids         query id list
	 */
	public <T> List<T> list(Class<T> entityClass, String queryString,
			List<?> ids) {
		Query query = em.createQuery(queryString);
		query.setParameter("ids", ids);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 */
	public <T> List<T> list(Class<T> resultClass, String queryString) {
		Query query = em.createQuery(queryString);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param params         query criteria map
	 */
	public <T> List<T> list(Class<T> resultClass, String queryString,
			Object... params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, params);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 */
	public <T> List<T> list(Class<T> resultClass, String queryString,
			Map<String, ?> params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, params);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 */
	public <T> List<T> list(Class<T> entityClass, int firstResult, int maxResult) {
		String queryString = "SELECT entity FROM " + entityClass.getName()
				+ " entity";
		Query query = em.createQuery(queryString);
		prepareQuery(query, firstResult, maxResult);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 * @param ids                query id list
	 */
	public <T> List<T> list(Class<T> entityClass, int firstResult,
			int maxResult, List<?> ids) {
		String queryString = "SELECT entity FROM " + entityClass.getName()
				+ " entity WHERE entity.id IN (:ids)";
		Query query = em.createQuery(queryString);
		prepareQuery(query, firstResult, maxResult);
		query.setParameter("ids", ids);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 */
	public <T> List<T> list(Class<T> resultClass, String queryString,
			int firstResult, int maxResult) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, firstResult, maxResult);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 * @param params         query criteria list
	 */
	public <T> List<T> list(Class<T> resultClass, String queryString,
			int firstResult, int maxResult, Object... params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, firstResult, maxResult, params);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * list objects via HQL, support query conditions, paginations
	 * 	@param resultClass   The class instance of the result
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 * @param params         query criteria map
	 */
	public <T> List<T> list(Class<T> resultClass, String queryString,
			int firstResult, int maxResult, Map<String, ?> params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, firstResult, maxResult, params);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * list objects via SQL, support query conditions, paginations
	 * 	@param queryString  the query string
	 */
	public List listBySql(String queryString) {
		Query query = em.createNativeQuery(queryString);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * list objects via SQL, support query conditions 
	 * 	@param queryString  the query string
	 * @param params         query criteria
	 */
	public List listBySql(String queryString, Object... params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, params);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * list objects via SQL, support query conditions, paginations
	 * 	@param queryString  the query string
	 * @param params         query criteria
	 */
	public List listBySql(String queryString, Map<String, ?> params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, params);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * list objects via SQL, support query conditions, paginations
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 */
	public List listBySql(String queryString, int firstResult, int maxResult) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, firstResult, maxResult);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * list objects via SQL, support query conditions, paginations
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 * @param params         query criteria
	 */
	public List listBySql(String queryString, int firstResult, int maxResult,
			Object... params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, firstResult, maxResult, params);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * list objects via SQL, support query conditions, paginations
	 * 	@param queryString  the query string
	 * @param firstResult     the first result for paging
	 * @param maxResult     the records of the page
	 * @param params         query criteria
	 */
	public List listBySql(String queryString, int firstResult, int maxResult,
			Map<String, ?> params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, firstResult, maxResult, params);
		return query.getResultList();
	}

	@Override
	/**
	 * counting function by HQL
	 * @param queryString  	the query string for counting
	 * @return
	 */
	public long count(Class<?> entityClass) {
		String queryString = "SELECT COUNT(entity) FROM "
				+ entityClass.getName() + " entity";
		Query query = em.createQuery(queryString);
		return (Long) query.getSingleResult();
	}

	@Override
	/**
	 * counting function by HQL
	 * @param queryString  	the query string for counting
	 * @return
	 */
	public long count(String queryString) {
		Query query = em.createQuery(queryString);
		return (Long) query.getSingleResult();
	}

	@Override
	/**
	 * counting function by HQL
	 * @param queryString  	the query string for counting
	 * @param params         	the parameters for querying
	 * @return
	 */
	public long count(String queryString, Object... params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, params);
		return (Long) query.getSingleResult();
	}

	@Override
	/**
	 * counting function 
	 * @param queryString  	the query string for counting
	 * @param params         	the parameters for querying
	 * @return
	 */
	public long count(String queryString, Map<String, ?> params) {
		Query query = em.createQuery(queryString);
		prepareQuery(query, params);
		return (Long) query.getSingleResult();
	}

	@Override
	/**
	 * counting function 
	 * @param queryString  	the query string for counting
	 * @param params         	the parameters for querying
	 * @return
	 */
	public long countBySql(String queryString) {
		Query query = em.createNativeQuery(queryString);
		return Long.parseLong(query.getSingleResult() + "");
	}

	@Override
	/**
	 * counting function 
	 * @param queryString  	the query string for counting
	 * @param params         	the parameters for querying
	 * @return
	 */
	public long countBySql(String queryString, Object... params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, params);
		return Long.parseLong(query.getSingleResult() + "");
	}

	@Override
	/**
	 * counting function 
	 * @param queryString  	the query string for counting
	 * @param params         	the parameters for querying
	 * @return
	 */
	public long countBySql(String queryString, Map<String, ?> params) {
		Query query = em.createNativeQuery(queryString);
		prepareQuery(query, params);
		return Long.parseLong(query.getSingleResult() + "");
	}

}
