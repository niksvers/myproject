package com.nikhil.packageone.impl;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;

import com.nikhil.packageone.HelloServicetwo;

/**
 * One implementation of the {@link HelloService}. Note that
 * the repository is injected, not retrieved.
 */
@Service
@Component(metatype = false)
public class HelloServicetwooImpl implements HelloServicetwo {
    
    @Reference
    private SlingRepository repository;

    public String getRepositoryName() {
        return repository.getDescriptor(Repository.REP_NAME_DESC);
    }

}
