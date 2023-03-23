package com.cl.code.crawler.entity;

import com.cl.code.crawler.value.object.ID;
import com.cl.code.crawler.value.object.PointTime;

/**
 * 任务
 *
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/22 15:33
 */
public abstract class Task {

    private ID taksId;

    private PointTime startUpTime;

    private CrawlSource crawlSource;

}
