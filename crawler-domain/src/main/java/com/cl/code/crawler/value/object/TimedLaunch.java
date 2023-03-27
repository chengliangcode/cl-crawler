package com.cl.code.crawler.value.object;

/**
 * 定时启动
 *
 * @author chengliang
 * @since 1.0.0
 */
public class TimedLaunch extends AbstractLaunch {

    /**
     * 启动时间
     */
    private final PointTime launchTime;

    public TimedLaunch(PointTime launchTime) {
        this.launchTime = launchTime;
    }

    public PointTime getLaunchTime() {
        return launchTime;
    }


}
