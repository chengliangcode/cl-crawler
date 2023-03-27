package com.cl.code.crawler.application;

import com.cl.code.crawler.application.impl.CrawlerTaskServiceImpl;
import com.cl.code.crawler.entity.AbstractTask;

/**
 * @author chengliang
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        CrawlerTaskService crawlerTaskService = new CrawlerTaskServiceImpl();
        AbstractTask task = crawlerTaskService.createTask("测试网页", "https://bz.zzzmh.cn/index");
        System.out.println(task.getTaksId());
        task.start();
    }
}
