package com.cl.code.crawler.entity;

/**
 * 访问器设置
 *
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/22 14:31
 */
public class AccessorConfig {

    /**
     * 重试次数
     */
    private Integer retryNumber;

    /**
     * 重试间隔（单位：ms）
     */
    private Long retryInterval;

    public AccessorConfig(Integer retryNumber, Long retryInterval) {
        this.retryNumber = retryNumber;
        this.retryInterval = retryInterval;
    }

}
