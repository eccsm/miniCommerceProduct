package tr.nttdata.poc.minicommerce.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RedisEvictionScheduler {
    @Autowired
    private CacheManager cacheManager;

    @Scheduled(cron="0 0 0 * * *")
    public void evictAllCaches() {
        System.out.println("Scheduled");
        evictAllCacheValues();
    }

    public void evictAllCacheValues() {
        System.out.println("Evicting productsCache");
        cacheManager.getCache("productsCache").clear();
    }

}
