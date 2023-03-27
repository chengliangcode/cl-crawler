package com.cl.code.crawler.entity;

import com.cl.code.crawler.value.object.*;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * 任务
 *
 * @author chengliang
 * @since 1.0.0
 */
public abstract class AbstractTask implements Runnable {

    private final ID taksId;

    private AbstractLaunch launchStrategy;

    private final CrawlSource crawlSource;

    private final AccessorConfig accessorConfig;

    public AbstractTask(ID taksId, CrawlSource crawlSource) {
        this.taksId = taksId;
        this.crawlSource = crawlSource;
        this.accessorConfig = AccessorConfig.time3();
        this.launchStrategy = new DirectLaunch();
    }

    public ID getTaksId() {
        return taksId;
    }

    public void setStartUpTime(Long time) {
        PointTime pointTime = new PointTime(time);
        if (pointTime.isFuture()) {
            throw new RuntimeException("启动时间不能在当前时间之后");
        }
        this.launchStrategy = new TimedLaunch(new PointTime(time));
    }

    @Override
    public void run() {
        start();
    }

    public void start() {
        Accessor accessor = new Accessor(accessorConfig);
        Long delay = null;
        if (launchStrategy instanceof DirectLaunch) {
            // 直接启动
            delay = 0L;
        } else if (launchStrategy instanceof TimedLaunch) {
            // 定时启动
            long now = Instant.now().toEpochMilli();
            delay = ((TimedLaunch) launchStrategy).getLaunchTime().getTime() - now;
        }
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> future = executor.schedule(() -> accessor.access(crawlSource), delay, TimeUnit.MILLISECONDS);
        try {
            String html = future.get();
            System.out.println(html);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
