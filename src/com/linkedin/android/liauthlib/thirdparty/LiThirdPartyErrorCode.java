package com.linkedin.android.liauthlib.thirdparty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum LiThirdPartyErrorCode
{
  static final Map<String, LiThirdPartyErrorCode> UAS_MOBILESDK_ERROR_MAPPER;
  
  static
  {
    INTERNAL_ERROR = new LiThirdPartyErrorCode("INTERNAL_ERROR", 1);
    UNKNOWN_ERROR = new LiThirdPartyErrorCode("UNKNOWN_ERROR", 2);
    SERVER_ERRUR = new LiThirdPartyErrorCode("SERVER_ERRUR", 3);
    LINKEDIN_APP_NOT_FOUND = new LiThirdPartyErrorCode("LINKEDIN_APP_NOT_FOUND", 4);
    NOT_AUTHENTICATED = new LiThirdPartyErrorCode("NOT_AUTHENTICATED", 5);
    $VALUES = new LiThirdPartyErrorCode[] { INVALID_REQUEST, INTERNAL_ERROR, UNKNOWN_ERROR, SERVER_ERRUR, LINKEDIN_APP_NOT_FOUND, NOT_AUTHENTICATED };
    HashMap localHashMap = new HashMap();
    localHashMap.put("unauthorized_client", NOT_AUTHENTICATED);
    localHashMap.put("invalid_scope", INVALID_REQUEST);
    localHashMap.put("invalid_os_identifier", INVALID_REQUEST);
    localHashMap.put("invalid_request", INVALID_REQUEST);
    localHashMap.put("access_denied", NOT_AUTHENTICATED);
    localHashMap.put("server_error", SERVER_ERRUR);
    UAS_MOBILESDK_ERROR_MAPPER = Collections.unmodifiableMap(localHashMap);
  }
  
  private LiThirdPartyErrorCode() {}
  
  public static LiThirdPartyErrorCode fromMobileSDKUasCode(String paramString)
  {
    paramString = (LiThirdPartyErrorCode)UAS_MOBILESDK_ERROR_MAPPER.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return UNKNOWN_ERROR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyErrorCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */