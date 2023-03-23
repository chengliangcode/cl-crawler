package com.cl.code.crawler.value.object;

/**
 * @author chengliang
 * @version 1.0.0
 * @since 2023/3/22 14:31
 */
public class CronRule {

    private final String rule;

    public CronRule(String rule) {
        if (rule == null) {
            throw new RuntimeException("cron 表达式不能为空");
        }
        this.rule = rule;
    }

    public String getRule() {
        return this.rule;
    }

}
