package edu.cmu.ebiz.task8.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;


import edu.cmu.ebiz.task8.bean.GrantLoansBean;
import edu.cmu.ebiz.task8.formbean.GrantLoanForm;
import edu.cmu.ebiz.task8.model.Model;
import edu.cmu.ebiz.task8.model.GrantLoansDAO;

public class GrantLoansAction extends Action {
	
	private FormBeanFactory<GrantLoanForm> formBeanFactory = FormBeanFactory
			.getInstance(GrantLoanForm.class);
	
	private GrantLoansDAO grantLoansDAO;
	
	public GrantLoansAction(Model model) {
		grantLoansDAO = model.getGrantLoansDAO();
	}

	public String getName() { return "grantloan.do"; };
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			GrantLoanForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if (!form.isPresent()) {
				return "GrantLoan.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "GrantLoan.jsp";
			}
			
			String state = form.getState();
			request.setAttribute("state", state);
			
			URL url = null;
			try {
				url = new URL("http://api.sba.gov/loans_grants/"+ state +"/for_profit/nil/nil.json");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<GrantLoansBean> loansList = grantLoansDAO.jsonParser(url) ;
			GrantLoansBean[] loans = new GrantLoansBean[loansList.size()];
			for(int i = 0; i<loansList.size(); i++) {
				loans[i] = loansList.get(i);
			}
			request.setAttribute("loansList", loans);
			
			
			return "GrantLoan.jsp";
			
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
	
}
