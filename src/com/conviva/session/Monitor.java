package com.conviva.session;

import com.conviva.api.Client.AdPlayer;
import com.conviva.api.Client.AdStream;
import com.conviva.api.Client.ErrorSeverity;
import com.conviva.api.ContentMetadata;
import com.conviva.api.SystemFactory;
import com.conviva.api.player.PlayerStateManager;
import com.conviva.api.player.PlayerStateManager.PlayerState;
import com.conviva.internal.StreamerError;
import com.conviva.protocol.Protocol;
import com.conviva.utils.ExceptionCatcher;
import com.conviva.utils.Logger;
import com.conviva.utils.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class Monitor
  implements IMonitorNotifier
{
  private Client.AdPlayer _adPlayer = null;
  private boolean _adPlaying = false;
  private Client.AdStream _adStream = null;
  public int _bitrateKbps = -1;
  int _contentLenSec = -1;
  public ContentMetadata _contentMetadata = null;
  int _encodedFps = -1;
  EventQueue _eventQueue = null;
  public ExceptionCatcher _exceptionCatcher = null;
  private boolean _hasJoined = false;
  public boolean _ignoreBitrateAndResource = false;
  private boolean _ignoreEncodedFrameRateAndDuration = false;
  private boolean _ignoreError = false;
  private boolean _ignorePlayerState = false;
  public Logger _logger;
  boolean _pauseJoin = false;
  PlayerStateManager.PlayerState _playerState = PlayerStateManager.PlayerState.NOT_MONITORED;
  public PlayerStateManager _playerStateManager = null;
  int _playingFpsObservationCount = 0;
  double _playingFpsTotal = 0.0D;
  private PlayerStateManager.PlayerState _pooledPlayerState = PlayerStateManager.PlayerState.NOT_MONITORED;
  private boolean _preloading = false;
  public String _resource = null;
  int _sessionFlags = 7;
  public int _sessionId = 0;
  public double _startTimeMs = 0.0D;
  private SystemFactory _systemFactory = null;
  private Time _time = null;
  
  public Monitor(int paramInt, EventQueue paramEventQueue, ContentMetadata paramContentMetadata, SystemFactory paramSystemFactory)
    throws Exception
  {
    _sessionId = paramInt;
    _eventQueue = paramEventQueue;
    _contentMetadata = paramContentMetadata;
    _systemFactory = paramSystemFactory;
    _logger = _systemFactory.buildLogger();
    _logger._moduleName = "Monitor";
    _logger._sessionId = _sessionId;
    _exceptionCatcher = _systemFactory.buildExceptionCatcher();
    _time = _systemFactory.buildTime();
    _systemFactory.buildTimer();
  }
  
  private void enqueueEvent(String paramString, Map<String, Object> paramMap)
  {
    if (_eventQueue != null) {
      _eventQueue.enqueueEvent(paramString, paramMap, (int)(_time.current() - _startTimeMs));
    }
  }
  
  private static int parseInt$505cff29(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public final void detachPlayer()
    throws Exception
  {
    _logger.info("detachPlayer()");
    updateMetrics();
    if (_playerStateManager != null) {
      _exceptionCatcher.runProtected(new Callable() {}, "detachPlayer");
    }
  }
  
  public final void enqueueStateChange(String paramString, Object paramObject1, Object paramObject2)
  {
    HashMap localHashMap1 = new HashMap();
    if (paramObject1 != null)
    {
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put(paramString, paramObject1);
      localHashMap1.put("old", localHashMap2);
    }
    paramObject1 = new HashMap();
    ((HashMap)paramObject1).put(paramString, paramObject2);
    localHashMap1.put("new", paramObject1);
    enqueueEvent("CwsStateChangeEvent", localHashMap1);
  }
  
  public final void onError(StreamerError paramStreamerError)
  {
    if ((_errorCode == null) || (_errorCode == ""))
    {
      _logger.error("OnError(): invalid error message string: " + _errorCode);
      return;
    }
    if (_severity == null)
    {
      _logger.error("OnError(): invalid error message severity");
      return;
    }
    if (_ignoreError)
    {
      _logger.info("monitor.onError(): ignored");
      return;
    }
    _logger.info("Enqueue CwsErrorEvent");
    if (_severity == Client.ErrorSeverity.FATAL) {}
    for (boolean bool = true;; bool = false)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ft", Boolean.valueOf(bool));
      localHashMap.put("err", _errorCode.toString());
      enqueueEvent("CwsErrorEvent", localHashMap);
      return;
    }
  }
  
  public final void onMetadata(Map<String, String> paramMap)
  {
    int i;
    label199:
    for (;;)
    {
      try
      {
        if (paramMap.containsKey("framerate"))
        {
          i = parseInt$505cff29((String)paramMap.get("framerate"));
          if (i <= 0) {
            break label199;
          }
          if (!_ignoreEncodedFrameRateAndDuration)
          {
            _encodedFps = i;
            _logger.info("onMetadata(): Received framerate metadata: " + _encodedFps);
          }
        }
        else
        {
          if (!paramMap.containsKey("duration")) {
            return;
          }
          i = parseInt$505cff29((String)paramMap.get("duration"));
          if (i <= 0) {
            break label251;
          }
          if (_ignoreEncodedFrameRateAndDuration) {
            break;
          }
          _contentLenSec = i;
          _logger.info("onMetadata(): Received duration metadata: " + i);
          return;
        }
        _logger.info("onMetadata(): Ignored framerate metadata: " + _encodedFps);
        continue;
        _logger.warning("onMetadata(): Ignored invalid framerate metadata: " + i);
      }
      catch (Exception paramMap)
      {
        _logger.error("monitor.OnMetadata() error: " + paramMap.toString());
        return;
      }
    }
    _logger.info("onMetadata(): Ignored duration metadata: " + i);
    return;
    label251:
    _logger.warning("onMetadata(): Ignored invalid duration metadata: " + i);
  }
  
  public final void setBitrateKbps(int paramInt)
  {
    _logger.debug("setBitrateKbps()");
    if (_ignoreBitrateAndResource) {
      _logger.info("setBitrateKbps(): ignored");
    }
    int i;
    do
    {
      return;
      i = _bitrateKbps;
    } while ((i == paramInt) || (paramInt < -1));
    _logger.info("Change bitrate from " + i + " to " + paramInt);
    Integer localInteger = null;
    if (i > 0) {
      localInteger = Integer.valueOf(i);
    }
    enqueueStateChange("br", localInteger, Integer.valueOf(paramInt));
    _bitrateKbps = paramInt;
  }
  
  public final void setPlayerState(PlayerStateManager.PlayerState paramPlayerState)
  {
    if (_playerState.equals(paramPlayerState)) {
      return;
    }
    if ((_playerState.equals(PlayerStateManager.PlayerState.NOT_MONITORED)) && (!paramPlayerState.equals(PlayerStateManager.PlayerState.NOT_MONITORED))) {
      _pooledPlayerState = paramPlayerState;
    }
    if (_ignorePlayerState)
    {
      Logger localLogger = _logger;
      StringBuilder localStringBuilder = new StringBuilder("OnPlayerStateChange(): ").append(paramPlayerState).append(" (pooled, ");
      if (_adPlaying) {}
      for (paramPlayerState = "ad playing";; paramPlayerState = "preloading")
      {
        localLogger.debug(paramPlayerState + ")");
        return;
      }
    }
    _logger.debug("OnPlayerStateChange(): " + paramPlayerState);
    if ((!_hasJoined) && (paramPlayerState.equals(PlayerStateManager.PlayerState.PLAYING)))
    {
      _hasJoined = true;
      _logger.info("TogglePauseJoin()");
      if (_pauseJoin) {
        break label250;
      }
      _logger.info("TogglePauseJoin(): same value ignoring");
    }
    for (;;)
    {
      enqueueStateChange("ps", Integer.valueOf(Protocol.convertPlayerState(_playerState)), Integer.valueOf(Protocol.convertPlayerState(paramPlayerState)));
      _logger.info("SetPlayerState(): changing player state from " + _playerState + " to " + paramPlayerState);
      _playerState = paramPlayerState;
      return;
      label250:
      enqueueStateChange("pj", Boolean.valueOf(_pauseJoin), Boolean.valueOf(false));
      _pauseJoin = false;
    }
  }
  
  final void updateMetrics()
  {
    if (_playerStateManager == null) {}
    double d;
    do
    {
      do
      {
        return;
      } while (!_playerState.equals(PlayerStateManager.PlayerState.PLAYING));
      d = _playerStateManager._renderedFrameRate;
    } while (d < 0.0D);
    _playingFpsTotal = (d + _playingFpsTotal);
    _playingFpsObservationCount += 1;
  }
}

/* Location:
 * Qualified Name:     com.conviva.session.Monitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */