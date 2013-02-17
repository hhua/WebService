package edu.cmu.ebiz.task8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.mybeans.form.FormBeanFactory;

import edu.cmu.ebiz.task8.bean.PolicyBean;

import edu.cmu.ebiz.task8.formbean.PolicyForm;
import edu.cmu.ebiz.task8.model.Model;
import edu.cmu.ebiz.task8.model.PolicyDAO;



public class PolicyAction extends Action {

	private FormBeanFactory<PolicyForm> formBeanFactory = FormBeanFactory
			.getInstance(PolicyForm.class);

	private PolicyDAO policyDAO;
	
	public PolicyAction(Model model) {
		policyDAO = model.getPolicyDAO();	
	}

	public String getName() {
		return "policy.do";
	}

	public String perform(HttpServletRequest request) {
		// Set up the errors list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		

		try {
			PolicyForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			String state = form.getState();
			String city = form.getCity();
			String businesstype = request.getParameter("businesstype");
			ArrayList<PolicyBean> policy = policyDAO.getPolicy(state,city,businesstype);
			request.setAttribute("policy", policy);
			
			if (!form.isPresent()) {
	            return "policy.jsp";
	        }
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "policy.jsp";
	        } 
			return "policy.jsp";
			
		} catch ( Exception e) {
			errors.add(e.getMessage());
			return "error.jsp";
		} 
	}
}
