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
	private PolicyDAO policyDAO;
	private SearchDAO searchDAO;
	private GrantLoansDAO grantLoansDAO;
	
	public Model() {
		zillowDAO = new ZillowDAO();
		recommendedWebsitesDAO = new RecommendedWebsitesDAO();
		policyDAO = new PolicyDAO();
		searchDAO = new SearchDAO();
		grantLoansDAO = new GrantLoansDAO();
	}
	
	public ZillowDAO getZillowDAO() { return zillowDAO; }

	public RecommendedWebsitesDAO getRecommendedWebsitesDAO() {
		return recommendedWebsitesDAO;
	}
	
	public PolicyDAO getPolicyDAO() {
		return policyDAO;
	}

	public SearchDAO getSearchDAO() {
		return searchDAO;
	}
	
	public GrantLoansDAO getGrantLoansDAO() {
		return grantLoansDAO;
	}
}
