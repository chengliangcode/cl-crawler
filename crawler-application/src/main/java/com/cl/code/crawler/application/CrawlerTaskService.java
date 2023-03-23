package com.cl.code.crawler.application;

import com.cl.code.crawler.entity.Task;

/**
 * 爬取任务类
 *
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/23 16:50
 */
public interface CrawlerTaskService {

    Task createTask(String name, String url);
    
}
