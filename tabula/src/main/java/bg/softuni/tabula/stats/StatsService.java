package bg.softuni.tabula.stats;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

//Използва се за мониторинг на посещенията на сайта ни
@Service
public class StatsService {
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private final Instant startedOn = Instant.now();

    public void incRequestCount() {
        requestCount.incrementAndGet();
    }

    public int getRequestCount() {
        return requestCount.get();
    }

    public Instant getStartedOn() {
        return startedOn;
    }
}
