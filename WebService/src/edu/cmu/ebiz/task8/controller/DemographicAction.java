package edu.cmu.ebiz.task8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.ebiz.task8.bean.PeopleIncomeBean;
import edu.cmu.ebiz.task8.bean.PeopleSegmentBean;
import edu.cmu.ebiz.task8.formbean.DemographicForm;
import edu.cmu.ebiz.task8.model.Model;
import edu.cmu.ebiz.task8.model.ZillowDAO;

public class DemographicAction extends Action {
	
	private FormBeanFactory<DemographicForm> formBeanFactory = FormBeanFactory
			.getInstance(DemographicForm.class);
	
	private ZillowDAO zillowDAO;
	
	public DemographicAction(Model model) {
		zillowDAO = model.getZillowDAO();
	}

	public String getName() { return "demographic.do"; };
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			DemographicForm form = formBeanFactory.create(request);
			
			if (!form.isPresent()) {
				return "demographic.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "demographic.jsp";
			}
			String state = form.getState();
			String city = form.getCity();
			String area = form.getArea();
			request.setAttribute("state", state);
			request.setAttribute("city", city);
			request.setAttribute("area", area);
			
			PeopleIncomeBean income = zillowDAO.getIncome(state, city, area);
			request.setAttribute("income", income);
			
			ArrayList<PeopleSegmentBean> segments = zillowDAO.getSegmentation(state, city, area);
			request.setAttribute("segments", segments);
			
			return "demographic.jsp";
			
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
