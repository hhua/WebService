package edu.cmu.ebiz.task8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.ebiz.task8.formbean.SimpleSearchForm;

public class SimpleSearchAction extends Action {
	private FormBeanFactory<SimpleSearchForm> formBeanFactory = FormBeanFactory
			.getInstance(SimpleSearchForm.class);

	public SimpleSearchAction() {

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "simple-search.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub

		// Set up error list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			SimpleSearchForm form = formBeanFactory.create(request);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "simplesearch.jsp";
			}

			// Check for any validation errors
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "simplesearch.jsp";
			}
			
			//handle request

			// Success
			return "simplesearch.jsp";
		} catch (FormBeanException e) {
			errors.add(e.toString());
			return "error.jsp";
		}
	}

}
