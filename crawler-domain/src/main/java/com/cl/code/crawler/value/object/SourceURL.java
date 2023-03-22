package com.cl.code.crawler.value.object;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/22 14:31
 */
public class SourceURL {

    private final URL url;

    public SourceURL(String url) {
        if (url == null || "".equals(url.trim())) {
            throw new RuntimeException("源地址不能为空");
        }
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URL getUrl() {
        return url;
    }

    public String getStringUrl() {
        return url.toString();
    }

}
