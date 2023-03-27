package com.cl.code.crawler.entity;

import com.cl.code.common.util.StringStreamUtils;
import com.cl.code.crawler.value.object.AccessorConfig;

import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.concurrent.*;

/**
 * 访问器
 *
 * @author chengliang
 * @since 1.0.0
 */
public class Accessor {

    private final AccessorConfig config;

    public Accessor(AccessorConfig config) {
        this.config = config;
    }

    /**
     * 访问网页
     *
     * @param crawlSource 爬取源
     * @return {@code String}
     * @throws ConnectException 连接异常
     */
    public String access(CrawlSource crawlSource) throws ConnectException {
        URL url = crawlSource.getUrl();
        try {
            return this.access(url);
        } catch (ConnectException e) {
            System.out.println(e.getMessage() + "，开始重试");
            int retryNumber = config.getRetryNumber();
            int time = 0;
            // 重试策略
            while (time < retryNumber) {
                try {
                    time++;
                    return this.access(url);
                } catch (ConnectException ex) {
                    System.out.println("第" + time + "次重试失败, 重试间隔：" + config.getRetryInterval() + "ms");
                }
            }
            if (time == retryNumber) {
                System.out.println("重试失败，放弃访问");
            }
            throw new ConnectException("访问失败");
        }
    }

    public String access(URL url) throws ConnectException {
        long start = Instant.now().getEpochSecond();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            // 访问网页
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            return StringStreamUtils.streamToString(urlConnection.getInputStream(), StandardCharsets.UTF_8);
        });

        String text = "访问成功";
        try {
            if (config.getTimeout() > 0) {
                // 超时处理
                return future.get(config.getTimeout(), TimeUnit.MILLISECONDS);
            } else {
                // 无超时处理
                return future.get();
            }
        } catch (TimeoutException e) {
            future.cancel(true);
            text = "访问超时";
            throw new ConnectException(text);
        } catch (InterruptedException e) {
            text = "访问被中断";
            throw new ConnectException(text);
        } catch (ExecutionException e) {
            text = "访问失败";
            throw new ConnectException(text);
        } finally {
            executor.shutdown();
            long end = Instant.now().getEpochSecond();
            System.out.println("访问网页：" + url.toString() + " 耗时：" + (end - start) + "s 结果：" + text);
        }
    }

}
