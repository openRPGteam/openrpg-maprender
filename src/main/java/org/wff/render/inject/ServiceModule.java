package org.wff.render.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.wff.render.httpclient.HttpClientFabric;
import org.wff.render.httpclient.impl.OkHttpFabric;
import org.wff.render.world.GlobalWorldInterface;
import org.wff.render.world.GlobalWorldLocalImpl;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(GlobalWorldInterface.class).to(GlobalWorldLocalImpl.class);
        bind(HttpClientFabric.class).to(OkHttpFabric.class).in(Scopes.SINGLETON);
    }
}
