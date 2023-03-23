package com.cl.code.crawler.value.object;

import java.time.Instant;

/**
 * 时间点
 *
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/22 15:37
 */
public class PointTime {

    private final Instant time;

    public PointTime(Long time) {
        if (time == null) {
            throw new RuntimeException("时间不能为空");
        }
        if (time.toString().length() != 13) {
            throw new RuntimeException("时间不符合毫秒格式");
        }
        this.time = Instant.ofEpochMilli(time);
    }

    public Long getTime() {
        return this.time.toEpochMilli();
    }

}
