package com.sda.goldmann.iss.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import javax.inject.Named;

public class ConfigurationModule extends AbstractModule {

    @Override
    public void configure() {
        // NOP
    }

    @Provides
    @Named("AstrosURL")
    String getAstrosURL() {
        return "http://api.open-notify.org/astros.json";
    }

    @Provides
    @Named("IssPositionURL")
    String getIssPositionURL() {
        return "http://api.open-notify.org/iss-now.json";
    }


}
