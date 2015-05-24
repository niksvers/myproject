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
%>
    <form action="<%=currentNode.getPath()%>.html" method ="post">  
        <input type="text" name="name" /><br/>  

		<input type="submit" value="register"/>  
	</form> 


  


