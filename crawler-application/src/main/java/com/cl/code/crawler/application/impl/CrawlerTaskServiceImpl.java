package com.cl.code.crawler.application.impl;

import com.cl.code.crawler.application.CrawlerTaskService;
import com.cl.code.crawler.entity.AbstractTask;
import com.cl.code.crawler.entity.CrawlSource;
import com.cl.code.crawler.factory.TaskFactory;
import com.cl.code.crawler.value.object.SourceURL;

import javax.annotation.Resource;

/**
 * 爬取任务实现类
 *
 * @author chengliang
 * @since 1.0.0
 */
public class CrawlerTaskServiceImpl implements CrawlerTaskService {

    @Resource
    private TaskFactory taskFactory;

    @Override
    public AbstractTask createTask(String name, String url) {
        taskFactory = new TaskFactory();
        return taskFactory.createTask(new CrawlSource(name, new SourceURL(url)));
    }


}
