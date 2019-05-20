package com.aem.community.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;



import org.osgi.framework.Constants;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;

import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;


//This is a component so it can provide or consume services
@Component


@Service

@Properties({
	@Property(name = Constants.SERVICE_DESCRIPTION, value = "First Custom workflow process implementation."),
	@Property(name = Constants.SERVICE_VENDOR, value = "Adobe"),
	@Property(name = "process.label", value = "First Custom Workflow Process Step") })
public class CustomWorkflowProcessStep implements WorkflowProcess 
{


	/** Default log. */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	public void execute(WorkItem item, WorkflowSession wfsession,MetaDataMap args) throws WorkflowException {

		try
		{
			log.info("Here in execute method");    //ensure that the execute method is invoked    

		}

		catch (Exception e)
		{
			e.printStackTrace()  ; 
		}
	}

}
