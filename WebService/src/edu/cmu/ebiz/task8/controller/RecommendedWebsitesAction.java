package edu.cmu.ebiz.task8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean;
import edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean;
import edu.cmu.ebiz.task8.model.Model;
import edu.cmu.ebiz.task8.model.RecommendedWebsitesDAO;




public class RecommendedWebsitesAction extends Action {
	
	private RecommendedWebsitesDAO recommendedWebsitesDAO;

	public RecommendedWebsitesAction(Model model) {
		recommendedWebsitesDAO = model.getRecommendedWebsitesDAO();
	}
	
	public String getName() { return "recommendedwebsites.do"; }
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			
			ArrayList<RecommendedWebsitesBean> manage = recommendedWebsitesDAO.getManageABusinessCategory();		
			request.setAttribute("manage", manage);
			
			ArrayList<RecommendedWebsitesBean> finance = recommendedWebsitesDAO.getFinanceABusinessCategory();		
			request.setAttribute("finance", finance);
			
			ArrayList<RecommendedWebsitesBean> register = recommendedWebsitesDAO.getRegisterABusinessCategory();		
			request.setAttribute("register", register);
			
			ArrayList<RecommendedWebsitesBean> start = recommendedWebsitesDAO.getStartABusinessCategory();		
			request.setAttribute("start", start);
			
			ArrayList<RecommendedWebsitesBean> law = recommendedWebsitesDAO.getLawCategory();		
			request.setAttribute("law", law);
			
			ArrayList<RecommendedWebsitesBean> others = recommendedWebsitesDAO.getOtherCategory();		
			request.setAttribute("others", others);
			
			return "recommendedwebsites.jsp";
		} catch (Exception e) {
			errors.add(e.getMessage());
			return "error.jsp";
		} 
	}
}

