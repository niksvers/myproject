package com.nikhil.packageone;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
 


import org.apache.sling.jcr.api.SlingRepository;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.ResultPage;
import com.day.cq.search.result.SearchResult;

import javax.jcr.Session;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

@SlingServlet( paths={"/bin/myservlet/"}, methods = "GET", metatype=true )
@Properties({
    @Property(name="service.pid", value="com.adobe.unicom.v1.servlets.OmnnitureLoggingServlet",propertyPrivate=false),
    @Property(name="service.description",value="Omniture service call logging servlet", propertyPrivate=false),
    @Property(name="service.vendor",value="Adobe Systems Incorporated - Adobe@Adobe Team", propertyPrivate=false)
})

public class MySlingServlet extends SlingAllMethodsServlet
{
	@Reference
    private SlingRepository repository;
    
    @Reference
    ResourceResolverFactory resolverFactory;
    
    @Reference
    private ResourceResolver resourceResolver;
    
    @Reference
    private QueryBuilder queryBuilder;
    
    private final static Logger logger = LoggerFactory.getLogger(MySlingServlet.class);
    
	@Override
	 protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException 
	 {
		
		response.getWriter().println("Testing...........");
	 }
		/*
		 Session session = resourceResolver.adaptTo(Session.class);
    	 Query query = queryBuilder.createQuery(PredicateGroup.create(request.getParameterMap()), session);
    	 SearchResult result = query.getResult();
    	 
    	 List<ResultPage> list = result.getResultPages();
    	 for( ResultPage resultPage : list )
    	 {
    		 response.getWriter().println();
    	 }
    	 
    	 try{
    	// paging metadata
    	    int hitsPerPage = result.getHits().size(); // 20 (set above) or lower
    	    long totalMatches = result.getTotalMatches();
    	    long offset = result.getStartIndex();
    	    long numberOfPages = totalMatches / 20;
    	                 
    	    //Place the results in XML to return to client
    	    DocumentBuilderFactory factory =         DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document doc = builder.newDocument();
    	                              
    	    //Start building the XML to pass back to the AEM client
    	    Element root = doc.createElement( "results" );
    	    doc.appendChild( root );
    	                 
    	                 
    	    // iterating over the results
    	    for (Hit hit : result.getHits()) {
    	           String path = hit.getPath();
    	            //Create a result element
    	            Element resultel = doc.createElement( "result" );
    	            root.appendChild( resultel );
    	                     
    	            Element pathel = doc.createElement( "path" );
    	            pathel.appendChild( doc.createTextNode(path ) );
    	            resultel.appendChild( pathel );
    	                                   
    	    }
    	 
    	    //close the session
    	    session.logout();             
    	    response.getWriter().println(convertToString(doc)); //;  // Convert the XML to a string to return to the web client
    	    logger.info(convertToString(doc));
    	                 
    	}
    	 catch(Exception e){
    	     //log.info(e.getMessage());
    	  }
    	 //return null; 
    	}    
    	 
    	private String convertToString(Document xml)
    	{
    	try {
    	   Transformer transformer = TransformerFactory.newInstance().newTransformer();
    	  StreamResult result = new StreamResult(new StringWriter());
    	  DOMSource source = new DOMSource(xml);
    	  transformer.transform(source, result);
    	  return result.getWriter().toString();
    	} catch(Exception ex) {
    	          ex.printStackTrace();
    	}
    	  return null;
    	     }*/ 
    	 
	}

