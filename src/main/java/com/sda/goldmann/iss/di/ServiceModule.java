package com.sda.goldmann.iss.di;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.sda.goldmann.iss.client.IssClient;
import com.sda.goldmann.iss.controller.ConsoleController;
import com.sda.goldmann.iss.service.HibernateService;
import com.sda.goldmann.iss.service.IssService;
import com.sda.goldmann.iss.service.IssServiceImpl;
import com.sda.goldmann.iss.service.PersonService;
import com.sda.goldmann.iss.service.PositionService;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IssService.class).to(IssServiceImpl.class);
    }

    @Provides
    @Singleton
    IssClient getMyService() {
        return new IssClient();
    }

    @Provides
    @Singleton
    ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Provides
    @Singleton
    HibernateService getHibernateService() {
        return new HibernateService();
    }

    @Provides
    @Singleton
    PositionService getPositionService(HibernateService hibernateService) {
        return new PositionService(hibernateService);
    }

    @Provides
    @Singleton
    PersonService getPersonService(HibernateService hibernateService) {
        return new PersonService(hibernateService);
    }

    @Provides
    @Singleton
    ConsoleController getConsoleController(
            IssServiceImpl issService,
            PositionService positionService,
            PersonService personService
    ) {
        return new ConsoleController(issService, positionService, personService);
    }
}
