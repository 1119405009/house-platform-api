package com.house.platform.api.config;


/*
 * @Author felix
 * @Description
 * @Date 10:33
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@ConfigurationProperties(prefix = "baiduai")
@Configuration
public class AiServiceProperties {

    private String appId;

    private String appKey;

    private String secretKey;


}
