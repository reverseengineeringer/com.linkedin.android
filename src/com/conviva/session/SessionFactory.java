package com.conviva.session;

import com.conviva.api.Client;
import com.conviva.api.ClientSettings;
import com.conviva.api.SystemFactory;
import com.conviva.api.system.ICancelTimer;
import com.conviva.utils.Config;
import com.conviva.utils.Logger;
import com.conviva.utils.Time;
import java.util.HashMap;
import java.util.Map;

public final class SessionFactory
{
  public Client _client;
  public Config _clientConfig;
  public ClientSettings _clientSettings;
  public Logger _logger;
  public int _nextSessionKey = 0;
  public Map<Integer, Session> _sessionsByKey = null;
  public SystemFactory _systemFactory;
  
  public SessionFactory(Client paramClient, ClientSettings paramClientSettings, Config paramConfig, SystemFactory paramSystemFactory)
  {
    _client = paramClient;
    _clientSettings = paramClientSettings;
    _clientConfig = paramConfig;
    _systemFactory = paramSystemFactory;
    _logger = _systemFactory.buildLogger();
    _logger._moduleName = "SessionFactory";
    _nextSessionKey = 0;
    _sessionsByKey = new HashMap();
  }
  
  public final void cleanupSession(int paramInt, boolean paramBoolean)
  {
    Session localSession = (Session)_sessionsByKey.get(Integer.valueOf(paramInt));
    Object localObject;
    if (localSession != null)
    {
      if (paramBoolean) {
        _sessionsByKey.remove(Integer.valueOf(paramInt));
      }
      _logger.info("session id(" + paramInt + ") is cleaned up and removed from sessionFactory");
      _logger.info("Session.cleanup()" + localSession.sessionTypeTag());
      if (_hbTimer != null)
      {
        _hbTimer.cancel();
        _hbTimer = null;
      }
      _logger.debug("Schedule the last hb before session cleanup" + localSession.sessionTypeTag());
      if (localSession.isVideoSession())
      {
        _logger.info("cws.sendSessionEndEvent()");
        localObject = new HashMap();
        _eventQueue.enqueueEvent("CwsSessionEndEvent", (Map)localObject, (int)(_time.current() - _startTimeMs));
      }
      localSession.sendHeartbeat();
      if (localSession.isVideoSession())
      {
        localObject = _monitor;
        _logger.info("cleanup()");
        if (_playerStateManager == null) {}
      }
    }
    try
    {
      ((Monitor)localObject).detachPlayer();
      _eventQueue = null;
      _contentMetadata = null;
      _monitor = null;
      if (_eventQueue != null) {
        _eventQueue = null;
      }
      _contentMetadata = null;
      _clientSettings = null;
      _systemFactory = null;
      _time = null;
      _timer = null;
      _jsonInterface = null;
      _logger = null;
      _cleanedUp = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        _logger.error("Exception in cleanup: " + localException.toString());
        localException.printStackTrace();
      }
    }
  }
  
  public final Session getVideoSession(int paramInt)
  {
    Session localSession = (Session)_sessionsByKey.get(Integer.valueOf(paramInt));
    if ((localSession != null) && (localSession.isVideoSession())) {
      return localSession;
    }
    _logger.error("Client: invalid sessionId. Did you cleanup that session previously?");
    return null;
  }
}

/* Location:
 * Qualified Name:     com.conviva.session.SessionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */