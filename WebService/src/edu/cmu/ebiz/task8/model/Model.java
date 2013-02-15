package edu.cmu.ebiz.task8.model;

/**
 * add DAO class here and init.
 * then in the action
 * you can access DAO 
 * 
 * @author taozheng
 *
 */

public class Model {
	private ZillowDAO zillowDAO;
	private RecommendedWebsitesDAO recommendedWebsitesDAO;

	public Model() {
		zillowDAO = new ZillowDAO();
		recommendedWebsitesDAO = new RecommendedWebsitesDAO();
	}
	
	public ZillowDAO getZillowDAO() { return zillowDAO; }

	public RecommendedWebsitesDAO getRecommendedWebsitesDAO() {
		return recommendedWebsitesDAO;
	}
	
}
