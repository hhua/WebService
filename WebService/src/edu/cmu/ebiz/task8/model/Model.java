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

	public Model() {
		zillowDAO = new ZillowDAO();
	}
	
	public ZillowDAO getZillowDAO() { return zillowDAO; }
}
