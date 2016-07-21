package com.conviva.session;

import com.conviva.api.Client;
import com.conviva.api.Client.DeviceType;
import com.conviva.api.ClientSettings;
import com.conviva.api.ContentMetadata;
import com.conviva.api.SystemFactory;
import com.conviva.api.SystemSettings;
import com.conviva.api.SystemSettings.LogLevel;
import com.conviva.api.system.ICallbackInterface;
import com.conviva.api.system.ICancelTimer;
import com.conviva.api.system.IGraphicalInterface;
import com.conviva.api.system.ILoggingInterface;
import com.conviva.api.system.IStorageInterface;
import com.conviva.json.IJsonInterface;
import com.conviva.json.SimpleJsonInterface;
import com.conviva.protocol.Protocol;
import com.conviva.utils.CallableWithParameters.With0;
import com.conviva.utils.CallbackWithTimeout;
import com.conviva.utils.Config;
import com.conviva.utils.Config.1SavedData;
import com.conviva.utils.ExceptionCatcher;
import com.conviva.utils.HttpClient;
import com.conviva.utils.Logger;
import com.conviva.utils.Storage;
import com.conviva.utils.SystemMetadata;
import com.conviva.utils.SystemMetadata.1MyCallable;
import com.conviva.utils.Time;
import com.conviva.utils.Timer;
import com.conviva.utils.Timer.1WrappedTimerAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public final class Session
{
  boolean _cleanedUp = false;
  private Client _client;
  public Config _clientConfig;
  ClientSettings _clientSettings;
  private String _clv = "2.109.0.30084";
  public ContentMetadata _contentMetadata = null;
  EventQueue _eventQueue;
  private IGraphicalInterface _graphicalInterface;
  ICancelTimer _hbTimer = null;
  public int _heartbeatSequenceNumber = 0;
  private HttpClient _httpClient;
  IJsonInterface _jsonInterface;
  public Logger _logger;
  public Monitor _monitor;
  private Protocol _protocol;
  private int _sessionId = 0;
  public double _startTimeMs = 0.0D;
  SystemFactory _systemFactory;
  private SystemMetadata _systemMetadata;
  public Time _time;
  Timer _timer;
  
  public Session(int paramInt, EventQueue paramEventQueue, ContentMetadata paramContentMetadata, Monitor paramMonitor, Client paramClient, ClientSettings paramClientSettings, Config paramConfig, SystemFactory paramSystemFactory)
    throws Exception
  {
    _sessionId = paramInt;
    _eventQueue = paramEventQueue;
    _contentMetadata = paramContentMetadata;
    _monitor = paramMonitor;
    _client = paramClient;
    _clientSettings = paramClientSettings;
    _clientConfig = paramConfig;
    _systemFactory = paramSystemFactory;
    _time = _systemFactory.buildTime();
    _timer = _systemFactory.buildTimer();
    _jsonInterface = new SimpleJsonInterface();
    _systemFactory.buildExceptionCatcher();
    _logger = _systemFactory.buildLogger();
    _logger._moduleName = "Session";
    _logger._sessionId = _sessionId;
    _httpClient = _systemFactory.buildHttpClient();
    paramEventQueue = _systemFactory;
    _systemMetadata = new SystemMetadata(paramEventQueue.buildLogger(), _metadataInterface, paramEventQueue.buildExceptionCatcher());
    _protocol = new Protocol();
    _graphicalInterface = _systemFactory._graphicalInterface;
    _systemFactory.buildCallbackWithTimeout();
    if ((_contentMetadata != null) && (_contentMetadata.custom == null)) {
      _contentMetadata.custom = new HashMap();
    }
  }
  
  private Map<String, Object> makeHeartbeat()
  {
    Object localObject1 = _eventQueue;
    Object localObject2 = _events;
    _events = new ArrayList();
    localObject1 = new HashMap();
    ((Map)localObject1).put("t", "CwsSessionHb");
    ((Map)localObject1).put("evs", localObject2);
    ((Map)localObject1).put("cid", _clientSettings.customerKey);
    ((Map)localObject1).put("clid", _clientConfig.get("clientId"));
    ((Map)localObject1).put("sid", Integer.valueOf(_sessionId));
    ((Map)localObject1).put("seq", Integer.valueOf(_heartbeatSequenceNumber));
    ((Map)localObject1).put("pver", Protocol.version);
    ((Map)localObject1).put("clv", _clv);
    ((Map)localObject1).put("iid", Integer.valueOf(_client._id));
    ((Map)localObject1).put("sdk", Boolean.valueOf(true));
    try
    {
      localObject2 = _systemMetadata;
      if (_cachedMetadata == null)
      {
        _cachedMetadata = new HashMap();
        _exceptionCatcher.runProtected(new SystemMetadata.1MyCallable((SystemMetadata)localObject2), "SystemMetadata.retrieve");
        if ((_cachedMetadata.containsKey(SystemMetadata.DEVICE_TYPE)) && ((String)_cachedMetadata.get(SystemMetadata.DEVICE_TYPE) == Client.DeviceType.UNKNOWN.toString())) {
          _cachedMetadata.remove(SystemMetadata.DEVICE_TYPE);
        }
      }
      ((Map)localObject1).put("pm", Protocol.buildPlatformMetadata(_cachedMetadata));
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
      if (localException1.size() == 0) {
        break label450;
      }
      ((Map)localObject1).put("tags", localException1);
      if ((_contentMetadata == null) || (_contentMetadata.viewerId == null)) {
        break label485;
      }
      ((Map)localObject1).put("vid", _contentMetadata.viewerId);
      if (_monitor == null) {
        break label1355;
      }
    }
    localObject2 = new HashMap();
    Object localObject4;
    Object localObject5;
    if (_contentMetadata != null)
    {
      localObject4 = _contentMetadata.custom.keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        String str = (String)_contentMetadata.custom.get(localObject5);
        if ((localObject5 != null) && (str != null) && (str.length() != 0)) {
          ((Map)localObject2).put(localObject5, str);
        }
      }
    }
    label450:
    label485:
    if (_contentMetadata != null) {
      ((Map)localObject1).put("an", _contentMetadata.assetName);
    }
    Object localObject3;
    switch (_contentMetadata.streamType)
    {
    default: 
      localObject3 = _monitor;
      ((Monitor)localObject3).updateMetrics();
      ((Map)localObject1).put("ps", Integer.valueOf(Protocol.convertPlayerState(_playerState)));
      ((Map)localObject1).put("pj", Boolean.valueOf(_pauseJoin));
      ((Map)localObject1).put("sf", Integer.valueOf(_sessionFlags));
      if (_playerStateManager != null)
      {
        localObject4 = (Map)((Map)localObject1).get("pm");
        if (localObject4 != null)
        {
          if (((Map)localObject4).get("fw") != null) {
            break label1373;
          }
          localObject5 = new Monitor.1MyCallable((Monitor)localObject3);
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        _exceptionCatcher.runProtected((Callable)localObject5, "updateHeartbeat.getPlayerType");
        if (playerType == null) {
          break label1373;
        }
        ((Map)localObject4).put("fw", playerType);
        i = 1;
        j = i;
        if (((Map)localObject4).get("fwv") == null) {
          localObject5 = new Monitor.2MyCallable((Monitor)localObject3);
        }
      }
      catch (Exception localException2)
      {
        try
        {
          _exceptionCatcher.runProtected((Callable)localObject5, "updateHeartbeat.getPlayerVersion");
          int j = i;
          if (playerVersion != null)
          {
            ((Map)localObject4).put("fwv", playerVersion);
            j = 1;
          }
          if (j != 0) {
            ((Map)localObject1).put("pm", localObject4);
          }
          if ((_contentMetadata != null) && (_contentMetadata.streamUrl != null)) {
            ((Map)localObject1).put("url", _contentMetadata.streamUrl);
          }
          if (_resource != null) {
            ((Map)localObject1).put("rs", _resource);
          }
          if ((_contentMetadata != null) && (_contentMetadata.duration > 0))
          {
            ((Map)localObject1).put("cl", Integer.valueOf(_contentMetadata.duration));
            if ((_contentMetadata == null) || (_contentMetadata.encodedFrameRate <= 0)) {
              continue;
            }
            ((Map)localObject1).put("efps", Integer.valueOf(_contentMetadata.encodedFrameRate));
            if (_playingFpsObservationCount <= 0) {
              continue;
            }
            i = (int)((_playingFpsTotal + 0.0D) / _playingFpsObservationCount);
            if (i >= 0) {
              ((Map)localObject1).put("afps", Integer.valueOf(i));
            }
            if (_bitrateKbps > 0) {
              ((Map)localObject1).put("br", Integer.valueOf(_bitrateKbps));
            }
            if ((_contentMetadata != null) && (_contentMetadata.applicationName != null)) {
              ((Map)localObject1).put("pn", _contentMetadata.applicationName);
            }
            if (((Boolean)_clientConfig.get("sendLogs")).booleanValue())
            {
              localObject3 = _systemFactory;
              localObject4 = (LinkedList)((LinkedList)_logBuffer).clone();
              _logBuffer.clear();
              ((Map)localObject1).put("lg", localObject4);
            }
            double d = _time.current();
            ((Map)localObject1).put("st", Integer.valueOf((int)(d - _startTimeMs)));
            ((Map)localObject1).put("cts", Double.valueOf(d / 1000.0D));
            _heartbeatSequenceNumber += 1;
            return (Map<String, Object>)localObject1;
            ((Map)localObject1).put("lv", Boolean.valueOf(true));
            break;
            ((Map)localObject1).put("lv", Boolean.valueOf(false));
            break;
            localException2 = localException2;
            _logger.error("Exception in updateHeartbeat.getPlayerType: " + localException2.toString());
            localException2.printStackTrace();
          }
        }
        catch (Exception localException3)
        {
          _logger.error("Exception in updateHeartbeat.getPlayerVersion: " + localException3.toString());
          localException3.printStackTrace();
          continue;
          if (_contentLenSec < 0) {
            continue;
          }
          ((Map)localObject1).put("cl", Integer.valueOf(_contentLenSec));
          continue;
          if (_encodedFps < 0) {
            continue;
          }
          ((Map)localObject1).put("efps", Integer.valueOf(_encodedFps));
          continue;
          i = -1;
          continue;
        }
      }
      label1355:
      ((Map)localObject1).put("sf", Integer.valueOf(0));
      continue;
      label1373:
      int i = 0;
    }
  }
  
  public final void createHBTimer()
  {
    if (_hbTimer != null)
    {
      _hbTimer.cancel();
      _hbTimer = null;
    }
    Timer localTimer = _timer;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        sendHeartbeat();
      }
    };
    int i = _clientSettings.heartbeatInterval;
    _hbTimer = localTimer.createTimer$23a07b1b(new Timer.1WrappedTimerAction(localTimer, "sendHeartbeat", local2), i * 1000);
  }
  
  public final boolean isVideoSession()
  {
    return _monitor != null;
  }
  
  public final void sendHeartbeat()
  {
    if (_cleanedUp) {}
    Object localObject;
    do
    {
      return;
      int i = 0;
      if (_eventQueue._events.size() > 0) {
        i = 1;
      }
      while ((i == 0) && ((_graphicalInterface.inSleepingMode()) || (!_graphicalInterface.isVisible())))
      {
        _logger.info("Do not send out heartbeat: player is sleeping or not visible");
        return;
        if (_monitor == null) {
          return;
        }
      }
      localObject = makeHeartbeat();
      localObject = _jsonInterface.encode((Map)localObject);
    } while (localObject == null);
    try
    {
      String str1 = _clientSettings.gatewayUrl + Protocol.gatewayPath;
      _logger.info("Send HB[" + (_heartbeatSequenceNumber - 1) + "]" + sessionTypeTag());
      Logger localLogger = _logger;
      String str2 = "heartbeat to be sent: " + (String)localObject;
      SystemSettings.LogLevel localLogLevel = SystemSettings.LogLevel.DEBUG;
      str2 = localLogger.formatMessage(str2, localLogLevel);
      _consoleInterface.consoleLog(str2, localLogLevel);
      _httpClient.request("POST", str1, (String)localObject, "application/json", new ICallbackInterface()
      {
        public final void done(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          Session localSession = Session.this;
          Object localObject1 = "-1";
          if (!_cleanedUp)
          {
            if (!Boolean.valueOf(paramAnonymousBoolean).booleanValue()) {
              _logger.error("received no response (or a bad response) to heartbeat POST request.");
            }
          }
          else {
            return;
          }
          Map localMap = _jsonInterface.decode(paramAnonymousString);
          if (localMap == null)
          {
            _logger.warning("JSON: Received null decoded response");
            return;
          }
          paramAnonymousString = (String)localObject1;
          if (localMap.containsKey("seq")) {
            paramAnonymousString = localMap.get("seq").toString();
          }
          _logger.debug("onHeartbeatResponse(): received valid response for HB[" + paramAnonymousString + "]");
          Object localObject2;
          if (localMap.containsKey("clid"))
          {
            paramAnonymousString = localMap.get("clid").toString();
            if (!paramAnonymousString.equals(_clientConfig.get("clientId")))
            {
              _logger.debug("onHeartbeatResponse(): setting the client id to " + paramAnonymousString + " (from server)");
              _clientConfig.set("clientId", paramAnonymousString);
              localObject2 = _clientConfig;
              localObject1 = new Config.1SavedData((Config)localObject2);
              paramAnonymousString = _storage;
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
            paramAnonymousBoolean = true;
            label361:
            if (paramAnonymousBoolean != ((Boolean)_clientConfig.get("sendLogs")).booleanValue())
            {
              localObject1 = _logger;
              localObject2 = new StringBuilder("Turning ");
              if (!paramAnonymousBoolean) {
                break label664;
              }
            }
          }
          label664:
          for (paramAnonymousString = "on";; paramAnonymousString = "off")
          {
            ((Logger)localObject1).info(paramAnonymousString + " sending of logs");
            _clientConfig.set("sendLogs", Boolean.valueOf(paramAnonymousBoolean));
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
              paramAnonymousString = (String)localMap.get("gw");
              if (!_clientSettings.gatewayUrl.equals(paramAnonymousString))
              {
                _logger.info("Received gatewayUrl from server " + paramAnonymousString);
                _clientSettings.gatewayUrl = paramAnonymousString;
              }
            }
            if (!localMap.containsKey("err")) {
              break;
            }
            paramAnonymousString = (String)localMap.get("err");
            if (paramAnonymousString.equals(Protocol.BACKEND_RESPONSE_NO_ERRORS)) {
              break;
            }
            _logger.error("onHeartbeatResponse(): error posting heartbeat: " + paramAnonymousString);
            return;
            paramAnonymousBoolean = false;
            break label361;
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      _logger.error("JSON post error: " + localException.toString());
    }
  }
  
  public final String sessionTypeTag()
  {
    if (_monitor == null) {}
    for (int i = 1; i != 0; i = 0) {
      return "(global session)";
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     com.conviva.session.Session
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */