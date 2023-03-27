package com.cl.code.crawler.factory;

import com.cl.code.crawler.entity.CrawlSource;
import com.cl.code.crawler.entity.OnceTask;
import com.cl.code.crawler.entity.AbstractTask;
import com.cl.code.crawler.value.object.ID;

import java.time.Instant;

/**
 * 任务工厂
 *
 * @author chengliang
 * @since 1.0.0
 */
public class TaskFactory {

    public AbstractTask createTask(CrawlSource crawlSource) {
        Instant now = Instant.now();
        return new OnceTask(new ID(now.toEpochMilli() + "-" + now.getNano()), crawlSource);
    }

}
