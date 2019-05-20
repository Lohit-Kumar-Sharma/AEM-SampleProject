package com.aem.community.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables=SlingHttpServletRequest.class)
public class FunctionalGroupAccordion {
	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionalGroupAccordion.class);
	private String message;
	@PostConstruct
	protected void init() {
		
		try{
	           LOGGER.info("Inside INIT");
	           setMessage("Hi BhaiLog I came from INIT function of Sling Model");
			}
		catch(Exception e) 
		{}
}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
