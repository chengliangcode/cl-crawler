package com.cl.code.crawler.application;

import com.cl.code.crawler.entity.AbstractTask;

/**
 * 爬取任务类
 *
 * @author chengliang
 * @since 1.0.0
 */
public interface CrawlerTaskService {

    /**
     * 创建任务
     *
     * @param name 名字
     * @param url  url
     * @return {@link AbstractTask}
     */
    AbstractTask createTask(String name, String url);

}
