package com.cl.code.crawler.entity;

import com.cl.code.crawler.value.object.SourceURL;

import java.net.URL;

/**
 * 爬取源
 *
 * @author chengliang
 * @since 1.0.0
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

    public String getName() {
        return this.name;
    }

    public URL getUrl() {
        return this.url.getUrl();
    }

}
