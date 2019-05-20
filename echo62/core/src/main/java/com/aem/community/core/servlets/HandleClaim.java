package com.aem.community.core.servlets;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Session;
import javax.jcr.Value;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths="/bin/mySearchServlet", methods = "POST", metatype=true)
public class HandleClaim extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	private static final long serialVersionUID = 2598426539166789515L;
	private static final Logger log = LoggerFactory.getLogger(HandleClaim.class);
	private Session session;

	//Inject a Sling ResourceResolverFactory
	@Reference
	private ResourceResolverFactory resolverFactory;


	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException 
	{
		log.debug("Inside GET");
		doPost(request, response);
	}
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		log.debug("Inside POST");
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put(ResourceResolverFactory.SUBSERVICE, "subServ");
			ResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver(param);
			session = resourceResolver.adaptTo(Session.class);
			Node root = session.getRootNode(); 
			Node node = root.getNode("test"); 
			Property references = node.getProperty("somearraystring");     
			Value[] values = references.getValues();
			String multivalue = "";
			for (Value value : values) 
			{
				multivalue +=" "+value.getString();
			}
			System.out.println(node.getPath()); 
			System.out.println(node.getProperty("message").getString());
            node  = root.getNode("test/subtest");
			response.getWriter().write("I came from servlet"+node.getPath()+" "+node.getProperty("message").getString()+" <br>Multivalue "+multivalue);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}