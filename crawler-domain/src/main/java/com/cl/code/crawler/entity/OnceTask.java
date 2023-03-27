package com.cl.code.crawler.entity;

import com.cl.code.crawler.value.object.ID;

/**
 * 单次任务
 *
 * @author chengliang
 * @since 1.0.0
 */
public class OnceTask extends AbstractTask {

    public OnceTask(ID taksId, CrawlSource crawlSource) {
        super(taksId, crawlSource);
    }

    public void start() {
        System.out.println("OnceTask.start");
        super.start();
    }

}
