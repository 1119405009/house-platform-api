package com.house.platform.api.util;

import org.springframework.context.ApplicationContext;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by teruo on 2018-11-26.
 */
public class SpringUtils {
  private static ApplicationContext applicationContext = null;

  public static void setApplicationContext(ApplicationContext applicationContext) {
    if (SpringUtils.applicationContext == null) {
      SpringUtils.applicationContext = applicationContext;
    }
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public static Object getBean(String name) {
    return getApplicationContext().getBean(name);

  }

  public static <T> T getBean(Class<T> clazz) {
    return getApplicationContext().getBean(clazz);
  }

  public static <T> T getBean(String name, Class<T> clazz) {
    return getApplicationContext().getBean(name, clazz);
  }

  public static boolean isExclusion(PathMatcher pathMatcher,Set<String> excludesPattern, HttpServletRequest httpRequest){
    if (excludesPattern == null) {
      return false;
    } else {
      Iterator<String> i$ = excludesPattern.iterator();

      String pattern;
      do {
        if (!i$.hasNext()) {
          return false;
        }

        pattern = i$.next();
      } while(!pathMatcher.match(pattern, httpRequest.getRequestURI()));

      return true;
    }
  }
}
