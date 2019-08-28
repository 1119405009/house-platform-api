package com.house.platform.api.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

  public static void noLoginResponse(HttpServletResponse response){
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    try {
      response.getWriter().write("验证失败");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
