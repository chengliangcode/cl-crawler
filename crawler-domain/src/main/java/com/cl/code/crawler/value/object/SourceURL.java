package com.cl.code.crawler.value.object;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chengliang
 * @since 1.0.0
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

    @Override
    public String toString() {
        return url.toString();
    }

}
