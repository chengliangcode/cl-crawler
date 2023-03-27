package com.cl.code.crawler.entity;

import com.cl.code.crawler.value.object.CronRule;
import com.cl.code.crawler.value.object.ID;
import com.cl.code.crawler.value.object.AbstractLaunch;

/**
 * 周期任务
 *
 * @author chengliang
 * @since 1.0.0
 */
public class CycleTask extends AbstractTask {

    private CronRule cronRule;

    public CycleTask(ID taksId, AbstractLaunch launchStrategy, CrawlSource crawlSource) {
        super(taksId, crawlSource);
    }
    
}
