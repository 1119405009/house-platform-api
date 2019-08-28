package com.house.platform.api.util;

import java.util.UUID;

public class UUIDUtil {

  /**
   * 获取16位随机字符串
   *
   * @return String
   */
  public static String getUUID(int digit) {
    if(digit < 1 || digit > 32 ){
      throw new IllegalArgumentException("the range of digit is 1 to 32 ");
    }
    String uuid = UUID.randomUUID().toString();
    char[] cs = new char[digit];
    char c = 0;
    for (int i = 36, j = 0; i-- > 0 && j < digit; ) {
      if ((c = uuid.charAt(i)) != '-') {
        cs[j++] = c;
      }
    }
    return String.valueOf(cs);
  }

}
