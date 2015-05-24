<h1>POST</h1>

<%@page import="javax.jcr.Session,org.apache.sling.jcr.api.*,javax.jcr.*" %>
<%@include file="/libs/foundation/global.jsp"%>
<%@ page session="false"%>
<%@ taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling/1.0" %>
<cq:defineObjects />
<sling:defineObjects />

<% 
final SlingRepository repos =
sling.getService(SlingRepository.class);
Session session = repos.loginAdministrative(null);

Node root = session.getRootNode();

Node a = root.addNode("mynode");
a.setPrimaryType("cq:Page");
session.save(); 
session.logout();

%>
    