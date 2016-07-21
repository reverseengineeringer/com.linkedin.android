package com.conviva.session;

import com.conviva.api.ClientSettings;
import com.conviva.api.SystemSettings;
import com.conviva.api.system.ICallbackInterface;
import com.conviva.api.system.IStorageInterface;
import com.conviva.json.IJsonInterface;
import com.conviva.protocol.Protocol;
import com.conviva.utils.CallbackWithTimeout;
import com.conviva.utils.Config;
import com.conviva.utils.Config.1SavedData;
import com.conviva.utils.Logger;
import com.conviva.utils.Storage;
import java.util.HashMap;
import java.util.Map;

final class Session$1
  implements ICallbackInterface
{
  Session$1(Session paramSession) {}
  
  public final void done(boolean paramBoolean, String paramString)
  {
    Session localSession = this$0;
    Object localObject1 = "-1";
    if (!_cleanedUp)
    {
      if (!Boolean.valueOf(paramBoolean).booleanValue()) {
        _logger.error("received no response (or a bad response) to heartbeat POST request.");
      }
    }
    else {
      return;
    }
    Map localMap = _jsonInterface.decode(paramString);
    if (localMap == null)
    {
      _logger.warning("JSON: Received null decoded response");
      return;
    }
    paramString = (String)localObject1;
    if (localMap.containsKey("seq")) {
      paramString = localMap.get("seq").toString();
    }
    _logger.debug("onHeartbeatResponse(): received valid response for HB[" + paramString + "]");
    Object localObject2;
    if (localMap.containsKey("clid"))
    {
      paramString = localMap.get("clid").toString();
      if (!paramString.equals(_clientConfig.get("clientId")))
      {
        _logger.debug("onHeartbeatResponse(): setting the client id to " + paramString + " (from server)");
        _clientConfig.set("clientId", paramString);
        localObject2 = _clientConfig;
        localObject1 = new Config.1SavedData((Config)localObject2);
        paramString = _storage;
        HashMap localHashMap = new HashMap();
        localHashMap.put("clId", _config.get("clientId"));
        localObject2 = _jsonInterface.encode(localHashMap);
        localObject1 = _callbackWithTimeout.getWrapperCallback((ICallbackInterface)localObject1, _systemSettings.storageTimeout * 1000, "storage save timeout");
        _logger.debug("load(): calling StorageInterface.saveData");
        _storageInterface.saveData("Conviva", "sdkConfig", (String)localObject2, (ICallbackInterface)localObject1);
      }
    }
    if ((localMap.containsKey("slg")) && (((Boolean)localMap.get("slg")).booleanValue()))
    {
      paramBoolean = true;
      label361:
      if (paramBoolean != ((Boolean)_clientConfig.get("sendLogs")).booleanValue())
      {
        localObject1 = _logger;
        localObject2 = new StringBuilder("Turning ");
        if (!paramBoolean) {
          break label664;
        }
      }
    }
    label664:
    for (paramString = "on";; paramString = "off")
    {
      ((Logger)localObject1).info(paramString + " sending of logs");
      _clientConfig.set("sendLogs", Boolean.valueOf(paramBoolean));
      if (localMap.containsKey("hbi"))
      {
        long l = ((Long)localMap.get("hbi")).longValue();
        if (_clientSettings.heartbeatInterval != l)
        {
          _logger.info("Received hbIntervalMs from server " + l);
          _clientSettings.heartbeatInterval = ((int)l);
          localSession.createHBTimer();
        }
      }
      if (localMap.containsKey("gw"))
      {
        paramString = (String)localMap.get("gw");
        if (!_clientSettings.gatewayUrl.equals(paramString))
        {
          _logger.info("Received gatewayUrl from server " + paramString);
          _clientSettings.gatewayUrl = paramString;
        }
      }
      if (!localMap.containsKey("err")) {
        break;
      }
      paramString = (String)localMap.get("err");
      if (paramString.equals(Protocol.BACKEND_RESPONSE_NO_ERRORS)) {
        break;
      }
      _logger.error("onHeartbeatResponse(): error posting heartbeat: " + paramString);
      return;
      paramBoolean = false;
      break label361;
    }
  }
}

/* Location:
 * Qualified Name:     com.conviva.session.Session.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */