package tasks;

import akka.actor.*;
import play.Logger;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

@Singleton
public class ExampleTask {

    @Inject
    public ExampleTask(ActorSystem actorSystem) {
        actorSystem.scheduler().schedule(
                Duration.create(0, TimeUnit.MILLISECONDS), //Initial delay 0 milliseconds
                Duration.create(10, TimeUnit.SECONDS),     //Frequency 10 seconds
                new Runnable() {
                    @Override
                    public void run() {
                        Logger.error("Task is running!");
                    }
                },
                actorSystem.dispatcher()
        );
    }

}
