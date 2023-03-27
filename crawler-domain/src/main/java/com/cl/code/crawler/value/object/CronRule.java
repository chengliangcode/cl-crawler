package com.cl.code.crawler.value.object;

/**
 * @author chengliang
 * @since 1.0.0
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
