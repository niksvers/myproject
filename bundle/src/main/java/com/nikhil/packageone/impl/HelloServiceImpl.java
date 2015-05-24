package com.nikhil.packageone.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.jcr.resource.JcrResourceConstants;

import com.day.cq.wcm.api.PageManager;
import com.nikhil.packageone.HelloService;

/**
 * One implementation of the {@link HelloService}. Note that
 * the repository is injected, not retrieved.
 */
@Service
@Component(metatype = false)
public class HelloServiceImpl implements HelloService {
    
    @Reference
    private SlingRepository repository;
    
    @Reference
    ResourceResolverFactory resolverFactory;
    
    @Reference
    private ResourceResolver resourceResolver;
    
    @Reference
    private QueryBuilder queryBuilder;
    
    

    public String getRepositoryName() {
    	
    	try {
    		
         repository.getDescriptor(Repository.REP_NAME_DESC);
        
        Session session = null;
        session = repository.loginAdministrative(null);
        Map<String,Object> authInfo = new HashMap<String, Object>();
        authInfo.put(JcrResourceConstants.AUTHENTICATION_INFO_SESSION,
        session);
        
			ResourceResolver resourceResolver =
			resolverFactory.getAdministrativeResourceResolver(authInfo);
		
        PageManager pageManager=
        		resourceResolver.adaptTo(PageManager.class);
        
        
        
    	} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//Session session = resourceResolver.adaptTo(Session.class);
    	 //Query query = queryBuilder.createQuery(PredicateGroup.create(request.getParameterMap()), session);
    	 //SearchResult result = query.getResult();
    	 
    	 return "String..";
    }
    
    

}
