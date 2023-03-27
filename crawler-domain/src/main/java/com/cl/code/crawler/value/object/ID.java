package com.cl.code.crawler.value.object;

/**
 * ID
 *
 * @author chengliang
 * @since 1.0.0
 */
public class ID {

    private final String id;

    public ID(Long id) {
        if (id == null) {
            throw new RuntimeException("ID不能为空");
        }
        this.id = id.toString();
    }

    public ID(String id) {
        if (id == null || "".equals(id.trim())) {
            throw new RuntimeException("ID不能为空");
        }
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }

}
