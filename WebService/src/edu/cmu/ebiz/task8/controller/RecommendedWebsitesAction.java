package edu.cmu.ebiz.task8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean;
import edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean;
import edu.cmu.ebiz.task8.model.Model;
import edu.cmu.ebiz.task8.model.RecommendedWebsitesDAO;




//public class RecommendedWebsitesAction extends Action {
//	
//	private RecommendedWebsitesDAO recommendedWebsitesDAO;
//
//	public RecommendedWebsitesAction(Model model) {
//		recommendedWebsitesDAO = model.getRecommendedWebsitesDAO();
//	}
//	
//	public String getName() { return "customerhistory.do"; }
//	
////	public String perform(HttpServletRequest request) {
//////		List<String> errors = new ArrayList<String>();
//////		request.setAttribute("errors", errors);
////		
//////		try {
//////			int customerId = (Integer) request.getSession(false).getAttribute("customerId");
//////			
//////			RecommendedWebsitesBean manage = recommendedWebsitesDAO.getManageABusinessCategory();
//////			TransactionHistoryBean[] historyList = transactionHistoryDAO.getTransactions(customer.getCustomerId());
//////			request.setAttribute("transactionHistory", historyList);
//////			return "customer-viewtransaction.jsp";
//////		} catch (MyDAOException e) {
//////			errors.add(e.getMessage());
//////			return "error.jsp";
//////		} 
////	}
//}
//
