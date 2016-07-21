package com.conviva.utils;

import com.conviva.api.system.ICallbackInterface;
import com.conviva.json.IJsonInterface;
import com.conviva.protocol.Protocol;
import java.util.Map;

public final class Config$1LoadedData
  implements ICallbackInterface
{
  public Config$1LoadedData(Config paramConfig) {}
  
  public final void done(boolean paramBoolean, String paramString)
  {
    Object localObject;
    Logger localLogger;
    Map localMap;
    if (paramBoolean) {
      if (paramString != null)
      {
        localObject = this$0;
        localLogger = null;
        localMap = _jsonInterface.decode(paramString);
        if (localMap != null) {
          break label106;
        }
        _loadedEmpty = true;
        localLogger = this$0._logger;
        localObject = new StringBuilder("load(): configuration successfully loaded from local storage");
        if (!this$0._loadedEmpty) {
          break label216;
        }
        paramString = " (was empty)";
        label72:
        localLogger.debug(paramString + ".");
      }
    }
    for (;;)
    {
      this$0._loaded = true;
      Config.access$300(this$0);
      return;
      label106:
      paramString = localLogger;
      if (localMap != null)
      {
        paramString = localLogger;
        if (localMap.containsKey("clId")) {
          paramString = localMap.get("clId").toString();
        }
      }
      if ((paramString == null) || (paramString.equals(Protocol.DEFAULT_CLIENT_ID)) || (paramString.equals("null")) || (paramString.length() <= 0)) {
        break;
      }
      _config.put("clientId", paramString);
      _logger.info("parse(): setting the client id to " + paramString + " (from local storage)");
      break;
      label216:
      paramString = "";
      break label72;
      this$0._logger.error("load(): error loading configuration from local storage: " + paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Config.1LoadedData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */