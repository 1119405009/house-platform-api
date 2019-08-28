package com.house.platform.api.util;

public class TokenUtil {

  public static final String USER_PREFIX = "@u" ;
  public static final String DEVICE_PREFIX = "@d" ;

  public static String generateUser(){
    return USER_PREFIX + UUIDUtil.getUUID(32);
  }

  public static String generateClient(){
    return DEVICE_PREFIX + UUIDUtil.getUUID(32);
  }

  public static String generateAdmin(){
    return UUIDUtil.getUUID(32);
  }

}
