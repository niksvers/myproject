package com.nikhil.packageone;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator, BundleListener {
	
	private final static Logger logger = LoggerFactory.getLogger(AuthUserFilter.class);
	
	private static String typeAsString(BundleEvent event) {
		if (event == null) {
			return "null";
		}
		int type = event.getType();
		switch (type) {
		case BundleEvent.INSTALLED:
			return "INSTALLED";
		case BundleEvent.LAZY_ACTIVATION:
			return "LAZY_ACTIVATION";
		case BundleEvent.RESOLVED:
			return "RESOLVED";
		case BundleEvent.STARTED:
			return "STARTED";
		case BundleEvent.STARTING:
			return "Starting";
		case BundleEvent.STOPPED:
			return "STOPPED";
		case BundleEvent.UNINSTALLED:
			return "UNINSTALLED";
		case BundleEvent.UNRESOLVED:
			return "UNRESOLVED";
		case BundleEvent.UPDATED:
			return "UPDATED";
		default:
			return "unknown event type: " + type;
		}
	}

	public void start(BundleContext context) throws Exception {
		//logger.info("***********Starting Bundle Listener*********************");
		logger.info("*************Starting Bundle Listener - " + context.hashCode());
		context.addBundleListener(this);
	}

	public void stop(BundleContext context) throws Exception {
		logger.info("************Stopping Bundle Listener - " + context.hashCode());
		context.removeBundleListener(this);
	}

	public void bundleChanged(BundleEvent event) {
		String symbolicName = event.getBundle().getSymbolicName();
		String type = typeAsString(event);
		logger.info("********************BundleChanged: " + symbolicName + ", event.type: " + type);
	}

}