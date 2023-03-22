package com.cl.code.crawler.domain;

import com.cl.code.crawler.value.object.SourceURL;

/**
 * 爬取源
 *
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/22 14:32
 */
public class CrawlSource {

    private final String name;

    private final SourceURL url;

    public CrawlSource(String name, SourceURL url) {
        if (name == null || url == null) {
            throw new RuntimeException("爬取源信息不能为空");
        }
        this.name = name;
        this.url = url;
    }

}
