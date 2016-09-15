package modules;

import com.google.inject.AbstractModule;
import tasks.ExampleTask;


public class ExampleModule extends AbstractModule {
    @Override
    protected void configure() {
        // We bind the "ExampleTask" class eagerly so it'll be started when the application starts
        // see: https://www.playframework.com/documentation/2.5.x/JavaDependencyInjection#Eager-bindings
        bind(ExampleTask.class).asEagerSingleton();
    }
}
