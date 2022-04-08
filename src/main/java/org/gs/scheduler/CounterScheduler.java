package org.gs.scheduler;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class CounterScheduler {

    private AtomicInteger counter = new AtomicInteger();

    public int get() {
        return counter.get();
    }

    @Scheduled(every = "10s")
    void incrementEach10s() {
        counter.incrementAndGet();
    }

    @Scheduled(cron = "0 42 8 * * ?")
    void cronJobTime(ScheduledExecution execution) {
        counter.incrementAndGet();
        System.out.println(execution.getScheduledFireTime());
    }

    @Scheduled(cron = "{counter.cron.expression}")
    void cronJobConfig() {
        counter.incrementAndGet();
        System.out.println("Cron Job Config completed");
    }

}
