package com.cl.code.crawler.application;

import lombok.Data;

/**
 * @author chengliang
 * @since 1.0.0
 */
@Data
public class CompletionRequest {

    private String model = "text-davinci-003";

    private String prompt = "Say this is test";

}
