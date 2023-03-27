package com.cl.code.crawler.value.object;

/**
 * 访问器设置
 *
 * @author chengliang
 * @since 1.0.0
 */
public class AccessorConfig {

    /**
     * 重试次数
     */
    private final int retryNumber;

    /**
     * 重试间隔（单位：ms）
     */
    private final long retryInterval;

    /**
     * 超时时间（单位：ms）
     */
    private final long timeout;

    public AccessorConfig(int retryNumber, long retryInterval, long timeout) {
        this.retryNumber = retryNumber;
        this.retryInterval = retryInterval;
        this.timeout = timeout;
    }

    public static AccessorConfig time3() {
        return new AccessorConfig(3, 1000L, 10000L);
    }

    public static AccessorConfig none() {
        return new AccessorConfig(0, 0L, 0);
    }

    public int getRetryNumber() {
        return retryNumber;
    }

    public long getRetryInterval() {
        return this.retryInterval;
    }

    public long getTimeout() {
        return timeout;
    }

}
