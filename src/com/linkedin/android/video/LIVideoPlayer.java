package com.linkedin.android.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.CryptoException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.google.android.exoplayer.DummyTrackRenderer;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.ExoPlayer.Listener;
import com.google.android.exoplayer.ExoPlayerImpl;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer.EventListener;
import com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer.EventListener;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioTrack.InitializationException;
import com.google.android.exoplayer.audio.AudioTrack.WriteException;
import com.google.android.exoplayer.chunk.ChunkSampleSource.EventListener;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.MultiTrackChunkSource;
import com.google.android.exoplayer.hls.HlsSampleSource.EventListener;
import com.google.android.exoplayer.metadata.MetadataTrackRenderer.MetadataRenderer;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.TextRenderer;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.BandwidthMeter.EventListener;
import com.linkedin.android.video.controller.LIPlayerControl;
import com.linkedin.android.video.controller.MediaController;
import com.linkedin.android.video.listener.CaptionListener;
import com.linkedin.android.video.listener.Id3MetadataListener;
import com.linkedin.android.video.listener.InfoListener;
import com.linkedin.android.video.listener.InternalErrorListener;
import com.linkedin.android.video.listener.PlayerListener;
import com.linkedin.android.video.listener.PlayerViewListener;
import com.linkedin.android.video.perf.ILIVideoPlayerAnalytics;
import com.linkedin.android.video.perf.ILIVideoPlayerAnalytics.VideoPlayerState;
import com.linkedin.android.video.perf.LIVideoPerfMetadata;
import com.linkedin.android.video.renderer.RendererBuilder;
import com.linkedin.android.video.tracking.IPlayerEventTracker;
import com.linkedin.android.video.tracking.PlayerEventDebugUtil;
import com.linkedin.android.video.tracking.TrackingUtil;
import com.linkedin.android.video.util.BitmapUtils;
import com.linkedin.android.video.util.NetworkInfoUtil;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.player.NetworkState;
import com.linkedin.gen.avro2pegasus.events.player.PlayPauseChangedReason;
import com.linkedin.gen.avro2pegasus.events.player.PlayerFeatureFlag;
import com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.player.PlayerSeekEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.player.PlayerState;
import com.linkedin.gen.avro2pegasus.events.player.PlayerState.Builder;
import com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEvent.Builder;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class LIVideoPlayer
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, ExoPlayer.Listener, MediaCodecAudioTrackRenderer.EventListener, MediaCodecVideoTrackRenderer.EventListener, ChunkSampleSource.EventListener, HlsSampleSource.EventListener, TextRenderer, BandwidthMeter.EventListener
{
  public static final int DISABLED_TRACK = -1;
  public static final int OPTION_BIT_ENABLE_AUDIO = 6;
  public static final int OPTION_BIT_ENABLE_DEBUG = 9;
  public static final int OPTION_BIT_ENABLE_METADATA = 8;
  public static final int OPTION_BIT_ENABLE_TEXT = 7;
  public static final int OPTION_BIT_ENABLE_VIDEO = 5;
  public static final int OPTION_BIT_RENDERING_AUDIO = 1;
  public static final int OPTION_BIT_RENDERING_DEBUG = 4;
  public static final int OPTION_BIT_RENDERING_METADATA = 3;
  public static final int OPTION_BIT_RENDERING_TEXT = 2;
  public static final int OPTION_BIT_RENDERING_VIDEO = 0;
  public static final int PRIMARY_TRACK = 0;
  private static final int RENDERER_BUILDING_STATE_BUILDING = 2;
  private static final int RENDERER_BUILDING_STATE_BUILT = 3;
  private static final int RENDERER_BUILDING_STATE_IDLE = 1;
  public static final int RENDERER_COUNT = 5;
  public static final String TAG = LIVideoPlayer.class.getSimpleName();
  private static final long TRACKING_EVENT_TIMER_TASK_INTERVAL = 3000L;
  public static final int TYPE_AUDIO = 1;
  public static final int TYPE_DEBUG = 4;
  public static final int TYPE_METADATA = 3;
  public static final int TYPE_TEXT = 2;
  public static final int TYPE_VIDEO = 0;
  protected static final Handler mainHandler = new Handler(Looper.getMainLooper());
  private List<ILIVideoPlayerAnalytics> analyticsProviders;
  private boolean backgrounded;
  private LIVideoPlayer.InternalRendererBuilderCallback builderCallback;
  private CaptionListener captionListener;
  private int currentBitrate;
  private BandwidthMeter dataBandwidthMeter;
  private IPlayerEventTracker eventTracker;
  private int height = -1;
  private Id3MetadataListener id3MetadataListener;
  private InfoListener infoListener;
  private int initOptions;
  private boolean initializingVideo = false;
  private InternalErrorListener internalErrorListener;
  private boolean lastReportedPlayWhenReady;
  private int lastReportedPlaybackState;
  private String mediaUrn;
  private MultiTrackChunkSource[] multiTrackSources;
  private final ExoPlayer player;
  private LIPlayerControl playerControl;
  private final CopyOnWriteArrayList<PlayerListener> playerListeners;
  private final CopyOnWriteArrayList<PlayerViewListener> playerViewListeners;
  private RendererBuilder rendererBuilder;
  private int rendererBuildingState;
  private int[] selectedTracks;
  private boolean shouldLoop = false;
  private Surface surface;
  private ISystemDelegate systemDelegate;
  private WeakReference<TextureView> textureViewReference;
  private String[][] trackNames;
  private Timer trackingEventTimer;
  private LIVideoPlayer.TrackingEventsTimerTask trackingEventsTimerTask;
  private TrackingObject trackingObject;
  private String trackingUniqueVideoViewId;
  private Format videoFormat;
  private TrackRenderer videoRenderer;
  private int videoTrackToRestore;
  private int width = -1;
  
  public LIVideoPlayer(int paramInt1, int paramInt2, boolean paramBoolean, IPlayerEventTracker paramIPlayerEventTracker, ISystemDelegate paramISystemDelegate)
  {
    player = new ExoPlayerImpl(paramInt1, paramInt2);
    player.addListener(this);
    playerListeners = new CopyOnWriteArrayList();
    playerViewListeners = new CopyOnWriteArrayList();
    lastReportedPlaybackState = 1;
    rendererBuildingState = 1;
    selectedTracks = new int[5];
    shouldLoop = paramBoolean;
    initOptions = 16777215;
    playerControl = null;
    textureViewReference = new WeakReference(null);
    eventTracker = paramIPlayerEventTracker;
    systemDelegate = paramISystemDelegate;
    trackingUniqueVideoViewId = UUID.randomUUID().toString();
    analyticsProviders = new ArrayList();
  }
  
  private void cancelTrackingEventTimer()
  {
    if (trackingEventTimer != null)
    {
      trackingEventTimer.cancel();
      trackingEventTimer = null;
    }
  }
  
  @ILIVideoPlayerAnalytics.VideoPlayerState
  private int convertPlayerState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4: 
      return 4;
    case 2: 
      return 3;
    case 1: 
      return 1;
    case 5: 
      return 5;
    }
    return 2;
  }
  
  private void maybeReportPlayerState()
  {
    boolean bool = player.getPlayWhenReady();
    int i = getPlaybackState();
    if ((lastReportedPlayWhenReady != bool) || (lastReportedPlaybackState != i))
    {
      Iterator localIterator = playerListeners.iterator();
      while (localIterator.hasNext()) {
        ((PlayerListener)localIterator.next()).onStateChanged(bool, i);
      }
      localIterator = playerViewListeners.iterator();
      while (localIterator.hasNext()) {
        ((PlayerViewListener)localIterator.next()).onStateChanged(bool, i);
      }
      lastReportedPlayWhenReady = bool;
      lastReportedPlaybackState = i;
    }
  }
  
  private void notifyInitEnd()
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).onVideoInitEnd();
    }
    initializingVideo = false;
  }
  
  private void pushSurface(boolean paramBoolean)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("pushSurface: ");
    if (videoRenderer == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(str, bool);
      if (videoRenderer != null) {
        break;
      }
      return;
    }
    if (paramBoolean)
    {
      player.blockingSendMessage$2158118c(videoRenderer, surface);
      return;
    }
    player.sendMessage$2158118c(videoRenderer, surface);
  }
  
  private void pushTrackSelection(int paramInt, boolean paramBoolean)
  {
    if (multiTrackSources == null) {
      return;
    }
    int i = selectedTracks[paramInt];
    if (i == -1)
    {
      player.setRendererEnabled(paramInt, false);
      return;
    }
    if (multiTrackSources[paramInt] == null)
    {
      player.setRendererEnabled(paramInt, paramBoolean);
      return;
    }
    boolean bool = player.getPlayWhenReady();
    player.setPlayWhenReady(false);
    player.setRendererEnabled(paramInt, false);
    player.sendMessage$2158118c(multiTrackSources[paramInt], Integer.valueOf(i));
    player.setRendererEnabled(paramInt, paramBoolean);
    player.setPlayWhenReady(bool);
  }
  
  public void addAnalyticsProvider(ILIVideoPlayerAnalytics paramILIVideoPlayerAnalytics)
  {
    analyticsProviders.add(paramILIVideoPlayerAnalytics);
  }
  
  public void addListener(PlayerListener paramPlayerListener)
  {
    if (!playerListeners.contains(paramPlayerListener)) {
      playerListeners.add(paramPlayerListener);
    }
  }
  
  public void addViewListener(PlayerViewListener paramPlayerViewListener)
  {
    if (!playerViewListeners.contains(paramPlayerViewListener)) {
      playerViewListeners.add(paramPlayerViewListener);
    }
  }
  
  public void attachSurfaceView(SurfaceView paramSurfaceView)
  {
    Log.d(TAG, "attach surface view");
    paramSurfaceView.getHolder().addCallback(this);
  }
  
  public void attachTextureView(TextureView paramTextureView)
  {
    paramTextureView.setSurfaceTextureListener(this);
    textureViewReference = new WeakReference(paramTextureView);
  }
  
  public void blockingClearSurface()
  {
    if (surface != null)
    {
      surface.release();
      surface = null;
    }
    pushSurface(true);
  }
  
  public Bitmap captureScreenshot()
  {
    if ((textureViewReference != null) && (textureViewReference.get() != null)) {
      return ((TextureView)textureViewReference.get()).getBitmap();
    }
    return null;
  }
  
  public void detachSurfaceView(SurfaceView paramSurfaceView)
  {
    paramSurfaceView.getHolder().removeCallback(this);
    blockingClearSurface();
  }
  
  public void detachTextureView()
  {
    if (textureViewReference.get() != null)
    {
      ((TextureView)textureViewReference.get()).setSurfaceTextureListener(null);
      blockingClearSurface();
      textureViewReference.clear();
    }
  }
  
  public void detachTextureView(TextureView paramTextureView)
  {
    paramTextureView.setSurfaceTextureListener(null);
    blockingClearSurface();
    textureViewReference.clear();
  }
  
  public void enableLooping(boolean paramBoolean)
  {
    shouldLoop = paramBoolean;
  }
  
  public PlayerState getCurrentPlayerState()
    throws BuilderException
  {
    PlayerState localPlayerState = getCurrentPlayerStateBuilder().build(RecordTemplate.Flavor.RECORD);
    String str = PlayerEventDebugUtil.playerState2String(localPlayerState);
    Log.d(TAG, str);
    return localPlayerState;
  }
  
  public PlayerState.Builder getCurrentPlayerStateBuilder()
  {
    PlayerState.Builder localBuilder = new PlayerState.Builder();
    Object localObject = mediaUrn;
    if (localObject == null)
    {
      hasMediaUrn = false;
      mediaUrn = null;
      localObject = Boolean.valueOf(getPlayerControlInstance().isPlaying());
      if (localObject != null) {
        break label289;
      }
      hasIsPlaying = false;
      isPlaying = false;
      label52:
      localObject = Integer.valueOf((int)(player.getDuration() / 1000L));
      if (localObject != null) {
        break label305;
      }
      hasLength = false;
      length = 0;
      label84:
      localBuilder.setTimeElapsed(Integer.valueOf((int)(player.getCurrentPosition() / 1000L)));
      localObject = NetworkInfoUtil.networkType2NetworkState(systemDelegate.getTelephonyManager(), systemDelegate.getConnectivityManager());
      if ((localObject != null) && (!((NetworkState)localObject).equals(NetworkState.UNKNOWN))) {
        break label321;
      }
      hasNetworkType = false;
      networkType = NetworkState.UNKNOWN;
      label154:
      localObject = trackingUniqueVideoViewId;
      if (localObject != null) {
        break label334;
      }
      hasMediaViewTrackingId = false;
      mediaViewTrackingId = null;
      label173:
      localObject = Integer.valueOf(TrackingUtil.getAudioVolumePercent(systemDelegate.getAudioManager()));
      if (localObject != null) {
        break label347;
      }
      hasVolume = false;
      volume = 0;
      label203:
      localObject = PlayerFeatureFlag.NOT_MEASURED;
      if ((localObject != null) && (!((PlayerFeatureFlag)localObject).equals(PlayerFeatureFlag.NOT_MEASURED))) {
        break label363;
      }
      hasFullScreen = false;
      fullScreen = PlayerFeatureFlag.NOT_MEASURED;
      label233:
      localObject = Float.valueOf(1.0F);
      if (localObject != null) {
        break label376;
      }
      hasSpeed = false;
    }
    for (speed = 0.0F;; speed = ((Float)localObject).floatValue())
    {
      localObject = Integer.valueOf(currentBitrate);
      if (localObject != null) {
        break label392;
      }
      hasBitrate = false;
      bitrate = 0;
      return localBuilder;
      hasMediaUrn = true;
      mediaUrn = ((String)localObject);
      break;
      label289:
      hasIsPlaying = true;
      isPlaying = ((Boolean)localObject).booleanValue();
      break label52;
      label305:
      hasLength = true;
      length = ((Integer)localObject).intValue();
      break label84;
      label321:
      hasNetworkType = true;
      networkType = ((NetworkState)localObject);
      break label154;
      label334:
      hasMediaViewTrackingId = true;
      mediaViewTrackingId = ((String)localObject);
      break label173;
      label347:
      hasVolume = true;
      volume = ((Integer)localObject).intValue();
      break label203;
      label363:
      hasFullScreen = true;
      fullScreen = ((PlayerFeatureFlag)localObject);
      break label233;
      label376:
      hasSpeed = true;
    }
    label392:
    hasBitrate = true;
    bitrate = ((Integer)localObject).intValue();
    return localBuilder;
  }
  
  public Bitmap getCurrentScreenshot()
  {
    return BitmapUtils.loadBitmap((View)textureViewReference.get());
  }
  
  public ExoPlayer getExoplayer()
  {
    return player;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public MetadataTrackRenderer.MetadataRenderer<Map<String, Object>> getId3MetadataRenderer()
  {
    return new LIVideoPlayer.1(this);
  }
  
  public boolean getInitOptions(int paramInt)
  {
    return (initOptions & 1 << paramInt) > 0;
  }
  
  public Handler getMainHandler()
  {
    return mainHandler;
  }
  
  public int getPlaybackState()
  {
    int i;
    if (rendererBuildingState == 2) {
      i = 2;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = player.getPlaybackState();
        i = j;
      } while (rendererBuildingState != 3);
      i = j;
    } while (j != 1);
    return 2;
  }
  
  public LIPlayerControl getPlayerControlInstance()
  {
    if (playerControl == null) {
      playerControl = new LIPlayerControl(this);
    }
    return playerControl;
  }
  
  public int getSelectedTrackIndex(int paramInt)
  {
    return selectedTracks[paramInt];
  }
  
  public String[] getTracks(int paramInt)
  {
    if (trackNames == null) {
      return null;
    }
    return trackNames[paramInt];
  }
  
  public Format getVideoFormat()
  {
    return videoFormat;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public boolean hasSurface()
  {
    return surface != null;
  }
  
  public void notifyInitStart()
  {
    boolean bool = true;
    if (!initializingVideo)
    {
      if (getPlaybackState() == 4) {}
      for (int i = 1;; i = 0)
      {
        Iterator localIterator = analyticsProviders.iterator();
        while (localIterator.hasNext())
        {
          ILIVideoPlayerAnalytics localILIVideoPlayerAnalytics = (ILIVideoPlayerAnalytics)localIterator.next();
          localILIVideoPlayerAnalytics.onVideoInitStart();
          if (i != 0) {
            localILIVideoPlayerAnalytics.onVideoInitEnd();
          }
        }
      }
      if (i != 0) {
        break label85;
      }
    }
    for (;;)
    {
      initializingVideo = bool;
      return;
      label85:
      bool = false;
    }
  }
  
  public void onAudioTrackInitializationError(AudioTrack.InitializationException paramInitializationException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(7);
    }
    if (internalErrorListener != null) {
      internalErrorListener.onAudioTrackInitializationError(paramInitializationException);
    }
  }
  
  public void onAudioTrackWriteError(AudioTrack.WriteException paramWriteException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(6);
    }
    if (internalErrorListener != null) {
      internalErrorListener.onAudioTrackWriteError(paramWriteException);
    }
  }
  
  public void onBandwidthSample(int paramInt, long paramLong1, long paramLong2)
  {
    if (infoListener != null) {
      infoListener.onBandwidthSample(paramInt, paramLong1, paramLong2);
    }
  }
  
  public void onCryptoError(MediaCodec.CryptoException paramCryptoException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(1);
    }
    if (internalErrorListener != null) {
      internalErrorListener.onCryptoError(paramCryptoException);
    }
  }
  
  public void onCues(List<Cue> paramList)
  {
    if ((captionListener != null) && (selectedTracks[2] != -1)) {
      captionListener.onCues(paramList);
    }
  }
  
  public void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException paramDecoderInitializationException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(3);
    }
    if (internalErrorListener != null) {
      internalErrorListener.onDecoderInitializationError(paramDecoderInitializationException);
    }
  }
  
  public void onDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    if (infoListener != null) {
      infoListener.onDecoderInitialized(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, int paramInt3)
  {
    currentBitrate = bitrate;
    if (infoListener == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      videoFormat = paramFormat;
      infoListener.onVideoFormatEnabled(paramFormat, paramInt2, paramInt3);
    }
    for (;;)
    {
      paramFormat = analyticsProviders.iterator();
      while (paramFormat.hasNext()) {
        ((ILIVideoPlayerAnalytics)paramFormat.next()).updateBitrate(currentBitrate);
      }
      break;
      if (paramInt1 == 1) {
        infoListener.onAudioFormatEnabled(paramFormat, paramInt2, paramInt3);
      }
    }
  }
  
  public void onDrawnToSurface(Surface paramSurface)
  {
    Log.d(TAG, "onDrawnToSurface");
    paramSurface = playerListeners.iterator();
    while (paramSurface.hasNext()) {
      ((PlayerListener)paramSurface.next()).onRenderStart();
    }
    paramSurface = playerViewListeners.iterator();
    while (paramSurface.hasNext()) {
      ((PlayerViewListener)paramSurface.next()).onRenderStart();
    }
  }
  
  public void onDrmSessionManagerError(Exception paramException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(5);
    }
    if (internalErrorListener != null) {
      internalErrorListener.onDrmSessionManagerError(paramException);
    }
  }
  
  public void onDroppedFrames(int paramInt, long paramLong)
  {
    if (infoListener != null) {
      infoListener.onDroppedFrames(paramInt, paramLong);
    }
  }
  
  public void onLoadCanceled(int paramInt, long paramLong) {}
  
  public void onLoadCompleted(int paramInt1, long paramLong1, int paramInt2, int paramInt3, Format paramFormat, int paramInt4, int paramInt5, long paramLong2, long paramLong3)
  {
    if (infoListener != null) {
      infoListener.onLoadCompleted(paramInt1, paramLong1, paramInt2, paramInt3, paramFormat, paramInt4, paramInt5, paramLong2, paramLong3);
    }
  }
  
  public void onLoadError(int paramInt, IOException paramIOException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(0);
    }
    if (internalErrorListener != null) {
      internalErrorListener.onLoadError(paramInt, paramIOException);
    }
  }
  
  public void onLoadStarted(int paramInt1, long paramLong, int paramInt2, int paramInt3, Format paramFormat, int paramInt4, int paramInt5)
  {
    if (infoListener != null) {
      infoListener.onLoadStarted(paramInt1, paramLong, paramInt2, paramInt3, paramFormat, paramInt4, paramInt5);
    }
  }
  
  public void onPlayWhenReadyCommitted()
  {
    Log.d(TAG, "onPlayWhenReadyCommitted");
    Iterator localIterator = playerListeners.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (PlayerListener)localIterator.next();
      if (getPlayerControlInstance().isPlaying()) {
        ((PlayerListener)localObject).onRenderStart();
      } else {
        ((PlayerListener)localObject).onRenderStop();
      }
    }
    localIterator = playerViewListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PlayerViewListener)localIterator.next();
      if (getPlayerControlInstance().isPlaying()) {
        ((PlayerViewListener)localObject).onRenderStart();
      }
    }
  }
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(4);
    }
    rendererBuildingState = 1;
    localIterator = playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListener)localIterator.next()).onError(paramExoPlaybackException);
    }
    localIterator = playerViewListeners.iterator();
    while (localIterator.hasNext()) {
      ((PlayerViewListener)localIterator.next()).onError(paramExoPlaybackException);
    }
    cancelTrackingEventTimer();
  }
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).onPlayerStateChanged(paramBoolean, convertPlayerState(paramInt));
    }
    maybeReportPlayerState();
    Log.d(TAG, "ExoPlayer state changed to: " + paramInt);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (initializingVideo) {
          notifyInitEnd();
        }
        cancelTrackingEventTimer();
      } while (!getPlayerControlInstance().isPlaying());
      trackingEventTimer = new Timer();
      trackingEventsTimerTask = new LIVideoPlayer.TrackingEventsTimerTask(this, null);
      trackingEventTimer.schedule(trackingEventsTimerTask, 0L, 3000L);
      Log.d(TAG, "trackingEventsTimerTask task scheduled");
      return;
      cancelTrackingEventTimer();
    } while (!shouldLoop);
    player.seekTo(0L);
  }
  
  public void onRenderers(String[][] paramArrayOfString, MultiTrackChunkSource[] paramArrayOfMultiTrackChunkSource, TrackRenderer[] paramArrayOfTrackRenderer, BandwidthMeter paramBandwidthMeter)
  {
    dataBandwidthMeter = paramBandwidthMeter;
    builderCallback = null;
    paramBandwidthMeter = paramArrayOfString;
    if (paramArrayOfString == null) {
      paramBandwidthMeter = new String[5][];
    }
    paramArrayOfString = paramArrayOfMultiTrackChunkSource;
    if (paramArrayOfMultiTrackChunkSource == null) {
      paramArrayOfString = new MultiTrackChunkSource[5];
    }
    int i = 0;
    if (i < 5)
    {
      if (paramArrayOfTrackRenderer[i] == null) {
        paramArrayOfTrackRenderer[i] = new DummyTrackRenderer();
      }
      while (paramBandwidthMeter[i] != null)
      {
        i += 1;
        break;
      }
      if (paramArrayOfString[i] == null) {}
      for (int j = 1;; j = allSources.length)
      {
        paramBandwidthMeter[i] = new String[j];
        break;
      }
    }
    trackNames = paramBandwidthMeter;
    videoRenderer = paramArrayOfTrackRenderer[0];
    multiTrackSources = paramArrayOfString;
    pushSurface(false);
    pushTrackSelection(0, getInitOptions(0));
    pushTrackSelection(1, getInitOptions(6));
    pushTrackSelection(2, getInitOptions(7));
    player.prepare(paramArrayOfTrackRenderer);
    rendererBuildingState = 3;
  }
  
  public void onRenderersError(Exception paramException)
  {
    Iterator localIterator = analyticsProviders.iterator();
    while (localIterator.hasNext()) {
      ((ILIVideoPlayerAnalytics)localIterator.next()).updateError(2);
    }
    builderCallback = null;
    if (internalErrorListener != null) {
      internalErrorListener.onRendererInitializationError(paramException);
    }
    localIterator = playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListener)localIterator.next()).onError(paramException);
    }
    localIterator = playerViewListeners.iterator();
    while (localIterator.hasNext()) {
      ((PlayerViewListener)localIterator.next()).onError(paramException);
    }
    cancelTrackingEventTimer();
    rendererBuildingState = 1;
    maybeReportPlayerState();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.d(TAG, "onSurfaceTextureAvailable");
    setSurface(new Surface(paramSurfaceTexture));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Log.d(TAG, "Surface Texture destroyed");
    cancelTrackingEventTimer();
    blockingClearSurface();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.d(TAG, "Surface Texture size changed");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onUpstreamDiscarded(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2, float paramFloat)
  {
    Iterator localIterator = playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListener)localIterator.next()).onVideoSizeChanged(paramInt1, paramInt2, paramFloat);
    }
    width = paramInt1;
    height = paramInt2;
  }
  
  public void prepare()
  {
    if (rendererBuilder == null) {
      throw new IllegalStateException("renderBuilder cannot be null");
    }
    notifyInitStart();
    if (rendererBuildingState == 3) {
      player.stop();
    }
    if (builderCallback != null) {
      builderCallback.cancel();
    }
    videoFormat = null;
    videoRenderer = null;
    multiTrackSources = null;
    rendererBuildingState = 2;
    maybeReportPlayerState();
    builderCallback = new LIVideoPlayer.InternalRendererBuilderCallback(this, null);
    rendererBuilder.buildRenderers(this);
  }
  
  public void release()
  {
    if (builderCallback != null)
    {
      builderCallback.cancel();
      builderCallback = null;
    }
    rendererBuildingState = 1;
    surface = null;
    cancelTrackingEventTimer();
    removeListeners();
    player.release();
  }
  
  public void removeAnalyticsProviders()
  {
    analyticsProviders.clear();
  }
  
  public void removeListener(PlayerListener paramPlayerListener)
  {
    playerListeners.remove(paramPlayerListener);
  }
  
  public void removeListeners()
  {
    playerListeners.clear();
  }
  
  public void removeViewListener(PlayerViewListener paramPlayerViewListener)
  {
    playerViewListeners.remove(paramPlayerViewListener);
  }
  
  public void removeViewListeners()
  {
    playerViewListeners.clear();
  }
  
  public void seekTo(long paramLong)
  {
    player.seekTo(paramLong);
  }
  
  public void selectTrack(int paramInt1, int paramInt2)
  {
    if (selectedTracks[paramInt1] == paramInt2) {}
    do
    {
      return;
      selectedTracks[paramInt1] = paramInt2;
      pushTrackSelection(paramInt1, true);
    } while ((paramInt1 != 2) || (paramInt2 != -1) || (captionListener == null));
    captionListener.onCues(Collections.emptyList());
  }
  
  public void sendPlayerPlayPauseEvent(PlayPauseChangedReason paramPlayPauseChangedReason)
  {
    for (;;)
    {
      PlayerPlayPauseEvent.Builder localBuilder;
      try
      {
        localBuilder = new PlayerPlayPauseEvent.Builder();
        PlayerState localPlayerState = getCurrentPlayerState();
        if (localPlayerState == null)
        {
          hasState = false;
          state = null;
          if (paramPlayPauseChangedReason == null)
          {
            hasReason = false;
            reason = null;
            paramPlayPauseChangedReason = trackingObject;
            if (paramPlayPauseChangedReason != null) {
              break label123;
            }
            hasMediaTrackingObject = false;
            mediaTrackingObject = null;
            eventTracker.sendEvent(localBuilder);
          }
        }
        else
        {
          hasState = true;
          state = localPlayerState;
          continue;
        }
        hasReason = true;
      }
      catch (BuilderException paramPlayPauseChangedReason)
      {
        Log.e(TAG, "event tracking BuilderException:" + paramPlayPauseChangedReason);
        return;
      }
      reason = paramPlayPauseChangedReason;
      continue;
      label123:
      hasMediaTrackingObject = true;
      mediaTrackingObject = paramPlayPauseChangedReason;
    }
  }
  
  public void sendPlayerPositionChangedEvent()
  {
    for (;;)
    {
      Object localObject;
      try
      {
        PlayerPositionChangedEvent.Builder localBuilder = new PlayerPositionChangedEvent.Builder();
        localObject = getCurrentPlayerState();
        if (localObject == null)
        {
          hasState = false;
          state = null;
          localObject = trackingObject;
          if (localObject == null)
          {
            hasMediaTrackingObject = false;
            mediaTrackingObject = null;
            eventTracker.sendEvent(localBuilder);
          }
        }
        else
        {
          hasState = true;
          state = ((PlayerState)localObject);
          continue;
        }
        hasMediaTrackingObject = true;
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(TAG, "event tracking BuilderException:" + localBuilderException);
        return;
      }
      mediaTrackingObject = ((TrackingObject)localObject);
    }
  }
  
  public void sendPlayerSeekEvent(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = getCurrentPlayerStateBuilder();
        ((PlayerState.Builder)localObject).setTimeElapsed(Integer.valueOf(paramInt2));
        PlayerSeekEvent.Builder localBuilder = new PlayerSeekEvent.Builder();
        localObject = ((PlayerState.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
        hasState = true;
        state = ((PlayerState)localObject);
        localObject = Integer.valueOf(paramInt1);
        if (localObject == null)
        {
          hasPreviousTimeElapsed = false;
          previousTimeElapsed = 0;
          localObject = trackingObject;
          if (localObject == null)
          {
            hasMediaTrackingObject = false;
            mediaTrackingObject = null;
            eventTracker.sendEvent(localBuilder);
          }
        }
        else
        {
          hasPreviousTimeElapsed = true;
          previousTimeElapsed = ((Integer)localObject).intValue();
          continue;
        }
        hasMediaTrackingObject = true;
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(TAG, "event tracking BuilderException:" + localBuilderException);
        return;
      }
      mediaTrackingObject = ((TrackingObject)localObject);
    }
  }
  
  public void sendPlayerVolumeChangedEvent(int paramInt)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        PlayerVolumeChangedEvent.Builder localBuilder = new PlayerVolumeChangedEvent.Builder();
        localObject = getCurrentPlayerState();
        if (localObject == null)
        {
          hasState = false;
          state = null;
          localObject = Integer.valueOf(paramInt);
          if (localObject == null)
          {
            hasPreviousVolume = false;
            previousVolume = 0;
            localObject = trackingObject;
            if (localObject != null) {
              break label131;
            }
            hasMediaTrackingObject = false;
            mediaTrackingObject = null;
            eventTracker.sendEvent(localBuilder);
          }
        }
        else
        {
          hasState = true;
          state = ((PlayerState)localObject);
          continue;
        }
        hasPreviousVolume = true;
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(TAG, "event tracking BuilderException:" + localBuilderException);
        return;
      }
      previousVolume = ((Integer)localObject).intValue();
      continue;
      label131:
      hasMediaTrackingObject = true;
      mediaTrackingObject = ((TrackingObject)localObject);
    }
  }
  
  public void setBackgrounded(boolean paramBoolean)
  {
    if (backgrounded == paramBoolean) {
      return;
    }
    backgrounded = paramBoolean;
    if (paramBoolean)
    {
      videoTrackToRestore = getSelectedTrackIndex(0);
      selectTrack(0, -1);
      blockingClearSurface();
      return;
    }
    selectTrack(0, videoTrackToRestore);
  }
  
  public void setCaptionListener(CaptionListener paramCaptionListener)
  {
    captionListener = paramCaptionListener;
  }
  
  public void setInfoListener(InfoListener paramInfoListener)
  {
    infoListener = paramInfoListener;
  }
  
  public void setInitOptions(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      initOptions |= 1 << paramInt;
      return;
    }
    initOptions &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  public void setInitOptionsMask(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      initOptions |= paramInt;
      return;
    }
    initOptions &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setInternalErrorListener(InternalErrorListener paramInternalErrorListener)
  {
    internalErrorListener = paramInternalErrorListener;
  }
  
  public void setMediaController(MediaController paramMediaController)
  {
    paramMediaController.setMediaPlayer(getPlayerControlInstance());
    addListener(paramMediaController);
  }
  
  public void setMetadataListener(Id3MetadataListener paramId3MetadataListener)
  {
    id3MetadataListener = paramId3MetadataListener;
  }
  
  public void setPlayWhenReady(boolean paramBoolean)
  {
    player.setPlayWhenReady(paramBoolean);
  }
  
  public void setRendererBuilder(RendererBuilder paramRendererBuilder)
  {
    rendererBuilder = paramRendererBuilder;
  }
  
  public void setSurface(Surface paramSurface)
  {
    surface = paramSurface;
    pushSurface(false);
  }
  
  public void setupTracking(LIVideoPerfMetadata paramLIVideoPerfMetadata)
    throws BuilderException
  {
    mediaUrn = objectUrn;
    trackingObject = TrackingUtil.createTrackingObject(mediaUrn, trackingId);
    currentBitrate = defaultBitrate;
  }
  
  public void stop()
  {
    player.stop();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d(TAG, "surface changed");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Log.d(TAG, "surface created");
    setSurface(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.d(TAG, "surface destroyed");
    cancelTrackingEventTimer();
    blockingClearSurface();
    paramSurfaceHolder = playerListeners.iterator();
    while (paramSurfaceHolder.hasNext()) {
      ((PlayerListener)paramSurfaceHolder.next()).onRenderStop();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.video.LIVideoPlayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */