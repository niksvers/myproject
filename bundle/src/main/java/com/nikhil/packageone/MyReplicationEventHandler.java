package com.nikhil.packageone;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import java.util.Calendar;
import java.util.Date;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import org.apache.sling.jcr.resource.JcrResourceResolverFactory;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Service(value = EventHandler.class)
@Component(immediate = true)
@Property(name = "event.topics", value = ReplicationAction.EVENT_TOPIC)

public class MyReplicationEventHandler implements EventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(MyReplicationEventHandler.class);
    
//    @Reference
//    private JcrResourceResolverFactory jcrResourceResolverFactory;
//    
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    
    @Reference
    private SlingRepository slingRepo;
    
    private Session session;

    @Override
    public void handleEvent(Event event) {
        try {
            ReplicationAction replicationAction = ReplicationAction.fromEvent(event);
            
            if(replicationAction.getType() == ReplicationActionType.ACTIVATE){
            
//                ResourceResolver resourceResolver = jcrResourceResolverFactory.getAdministrativeResourceResolver(null);

			Date date = new Date();   // given date
			Calendar calendar = Calendar.getInstance(); // creates a new calendar instance
			calendar.setTime(date);   // assigns calendar to given date 
//calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
int minute = calendar.get(Calendar.MINUTE);        // gets hour in 12h format

//if(minute%2!=0)
//{
//	throw new RepositoryException();
//}
	
//calendar.get(Calendar.MONTH);       // gets month number, NOTE this is zero based!
                
                session = slingRepo.loginAdministrative(null);
                
                Map<String,Object> authInfo = new HashMap<String, Object>();
                authInfo.put(JcrResourceConstants.AUTHENTICATION_INFO_SESSION,session);
				
				logger.info("******************BEFORE Current time ");
				for(int i=1; i<10000; i++)
				{
					
				}
				calendar = Calendar.getInstance(); // creates a new calendar instance
			calendar.setTime(date);   // assigns calendar to given date 
//calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
minute = calendar.get(Calendar.MINUTE); 
			logger.info("******************AFTER Current time : " + minute + "******************");

                ResourceResolver resourceResolver = resourceResolverFactory.getResourceResolver(authInfo);
                PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
                Page currentPage = pageManager.getContainingPage(replicationAction.getPath());
                logger.info("Replication fired for: *******************************************"); //, currentPage.getPath());
            }
            
        }
        catch (LoginException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (RepositoryException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
			logger.info("EXCEPTION.........#####################################################################");
        }finally{
            
            if(session !=  null){
                session.logout();
                
            }
        }
        

    }

}
