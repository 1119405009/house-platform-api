package com.house.platform.api.config;


import com.baidu.aip.imagesearch.AipImageSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Author felix
 * @Description
 * @Date 10:34
 */
@Configuration
public class AiServiceConfig {

    @Autowired
    public AiServiceProperties properties;

    @Bean
    public AipImageSearch aipImageSearch() {
        AipImageSearch client = new AipImageSearch(properties.getAppId(),
                 properties.getAppKey(), properties.getSecretKey());
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }

}


