<%--

  mycomp component.

  

--%><%@page import="java.util.Calendar"%>
<%@page import="javax.jcr.Session" %>
<%@page import = "java.io.*,com.day.cq.search.*,java.util.List,javax.xml.parsers.*,javax.xml.transform.*,javax.xml.transform.dom.DOMSource,javax.xml.transform.stream.StreamResult,com.day.cq.search.result.*,org.w3c.dom.*"%>

<%
%>
<%@include file="/libs/foundation/global.jsp"%>
<%@ taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling/1.0" %>
<cq:defineObjects />
<sling:defineObjects />
<%
%><%@page session="false" %>
<%
%><% 
	// TODO add you code here
Session session = resourceResolver.adaptTo(Session.class);
		QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
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
                out.println("path : ");
    	            Element resultel = doc.createElement( "result" );
    	            root.appendChild( resultel );
    	                     
    	            Element pathel = doc.createElement( "path" );
    	            pathel.appendChild( doc.createTextNode(path ) );
    	            resultel.appendChild( pathel );
    	                                   
    	    }

    	    //close the session
    	    session.logout();             
    	    //response.getWriter().println(convertToString(doc)); //;  // Convert the XML to a string to return to the web client
    	    //logger.info(convertToString(doc));
    	    
    	    try {
    	    	   Transformer transformer = TransformerFactory.newInstance().newTransformer();
    	    	   StreamResult result1 = new StreamResult(new StringWriter());
    	    	  DOMSource source = new DOMSource(doc);
    	    	  transformer.transform(source, result1);
                //out.println(result1.getWriter().toString());
                //out.println(doc.toString());
    	    	} catch(Exception ex) {
    	    	          ex.printStackTrace();
    	    	}
    	                 
    	}
    	 catch(Exception e){
    	     //log.info(e.getMessage());
    	  }
    	 //return null; 
    	    
    	 
%>

<%="value..." %>

  


