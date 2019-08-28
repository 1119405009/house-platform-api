package com.house.platform.api;

import com.house.platform.api.util.SpringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.TimeZone;

@SpringBootApplication
@ServletComponentScan
//@EnableJpaRepositories(repositoryBaseClass = BaseDaoImpl.class)
//@EnableScheduling
@EnableSwagger2
public class Application {

  public static void main(final String[] args) {
    TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    System.setProperty("user.timezone", "Asia/Shanghai");
    SpringUtils.setApplicationContext(SpringApplication.run(Application.class, args));
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      } };
  }
  @Bean
  public Docket controllerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder()
            .title("标题：房子百度AI检索_API_接口文档")
            .description("描述：用于房子百度AI检索")
                .contact(new Contact("felix", null, "1119405009@qq.com"))
                .version("版本号:1.0")
                .build())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.house.platform.api.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource("config.yml"));
    configurer.setProperties(yaml.getObject());
    return configurer;
  }
}
