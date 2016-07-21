package com.linkedin.gen.avro2pegasus.events.player;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PlayerState
  implements RecordTemplate<PlayerState>
{
  public static final PlayerStateBuilder BUILDER = PlayerStateBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final int bitrate;
  public final PlayerFeatureFlag casting;
  public final PlayerFeatureFlag ccVisible;
  public final PlayerFeatureFlag downloaded;
  public final PlayerFeatureFlag fullScreen;
  public final boolean hasBitrate;
  public final boolean hasCasting;
  public final boolean hasCcVisible;
  public final boolean hasDownloaded;
  public final boolean hasFullScreen;
  public final boolean hasIsPlaying;
  public final boolean hasLength;
  public final boolean hasMediaUrn;
  public final boolean hasMediaViewTrackingId;
  public final boolean hasNetworkType;
  public final boolean hasSpeed;
  public final boolean hasTimeElapsed;
  public final boolean hasVolume;
  public final boolean isPlaying;
  public final int length;
  public final String mediaUrn;
  public final String mediaViewTrackingId;
  public final NetworkState networkType;
  public final float speed;
  public final int timeElapsed;
  public final int volume;
  
  PlayerState(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, PlayerFeatureFlag paramPlayerFeatureFlag1, PlayerFeatureFlag paramPlayerFeatureFlag2, PlayerFeatureFlag paramPlayerFeatureFlag3, NetworkState paramNetworkState, float paramFloat, PlayerFeatureFlag paramPlayerFeatureFlag4, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14)
  {
    mediaUrn = paramString1;
    length = paramInt1;
    mediaViewTrackingId = paramString2;
    volume = paramInt2;
    timeElapsed = paramInt3;
    isPlaying = paramBoolean1;
    ccVisible = paramPlayerFeatureFlag1;
    fullScreen = paramPlayerFeatureFlag2;
    downloaded = paramPlayerFeatureFlag3;
    networkType = paramNetworkState;
    speed = paramFloat;
    casting = paramPlayerFeatureFlag4;
    bitrate = paramInt4;
    hasMediaUrn = paramBoolean2;
    hasLength = paramBoolean3;
    hasMediaViewTrackingId = paramBoolean4;
    hasVolume = paramBoolean5;
    hasTimeElapsed = paramBoolean6;
    hasIsPlaying = paramBoolean7;
    hasCcVisible = paramBoolean8;
    hasFullScreen = paramBoolean9;
    hasDownloaded = paramBoolean10;
    hasNetworkType = paramBoolean11;
    hasSpeed = paramBoolean12;
    hasCasting = paramBoolean13;
    hasBitrate = paramBoolean14;
  }
  
  public final PlayerState accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasMediaUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("mediaUrn");
      paramDataProcessor.processString(mediaUrn);
    }
    if (hasLength)
    {
      paramDataProcessor.startRecordField$505cff1c("length");
      paramDataProcessor.processInt(length);
    }
    if (hasMediaViewTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("mediaViewTrackingId");
      paramDataProcessor.processString(mediaViewTrackingId);
    }
    if (hasVolume)
    {
      paramDataProcessor.startRecordField$505cff1c("volume");
      paramDataProcessor.processInt(volume);
    }
    if (hasTimeElapsed)
    {
      paramDataProcessor.startRecordField$505cff1c("timeElapsed");
      paramDataProcessor.processInt(timeElapsed);
    }
    if (hasIsPlaying)
    {
      paramDataProcessor.startRecordField$505cff1c("isPlaying");
      paramDataProcessor.processBoolean(isPlaying);
    }
    if (hasCcVisible)
    {
      paramDataProcessor.startRecordField$505cff1c("ccVisible");
      paramDataProcessor.processEnum(ccVisible);
    }
    if (hasFullScreen)
    {
      paramDataProcessor.startRecordField$505cff1c("fullScreen");
      paramDataProcessor.processEnum(fullScreen);
    }
    if (hasDownloaded)
    {
      paramDataProcessor.startRecordField$505cff1c("downloaded");
      paramDataProcessor.processEnum(downloaded);
    }
    if (hasNetworkType)
    {
      paramDataProcessor.startRecordField$505cff1c("networkType");
      paramDataProcessor.processEnum(networkType);
    }
    if (hasSpeed)
    {
      paramDataProcessor.startRecordField$505cff1c("speed");
      paramDataProcessor.processFloat(speed);
    }
    if (hasCasting)
    {
      paramDataProcessor.startRecordField$505cff1c("casting");
      paramDataProcessor.processEnum(casting);
    }
    if (hasBitrate)
    {
      paramDataProcessor.startRecordField$505cff1c("bitrate");
      paramDataProcessor.processInt(bitrate);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new PlayerState(mediaUrn, length, mediaViewTrackingId, volume, timeElapsed, isPlaying, ccVisible, fullScreen, downloaded, networkType, speed, casting, bitrate, hasMediaUrn, hasLength, hasMediaViewTrackingId, hasVolume, hasTimeElapsed, hasIsPlaying, hasCcVisible, hasFullScreen, hasDownloaded, hasNetworkType, hasSpeed, hasCasting, hasBitrate);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (PlayerState)paramObject;
      if (mediaUrn != null)
      {
        if (mediaUrn.equals(mediaUrn)) {}
      }
      else {
        while (mediaUrn != null) {
          return false;
        }
      }
      if (length != length) {
        return false;
      }
      if (mediaViewTrackingId != null)
      {
        if (mediaViewTrackingId.equals(mediaViewTrackingId)) {}
      }
      else {
        while (mediaViewTrackingId != null) {
          return false;
        }
      }
      if (volume != volume) {
        return false;
      }
      if (timeElapsed != timeElapsed) {
        return false;
      }
      if (isPlaying != isPlaying) {
        return false;
      }
      if (ccVisible != null)
      {
        if (ccVisible.equals(ccVisible)) {}
      }
      else {
        while (ccVisible != null) {
          return false;
        }
      }
      if (fullScreen != null)
      {
        if (fullScreen.equals(fullScreen)) {}
      }
      else {
        while (fullScreen != null) {
          return false;
        }
      }
      if (downloaded != null)
      {
        if (downloaded.equals(downloaded)) {}
      }
      else {
        while (downloaded != null) {
          return false;
        }
      }
      if (networkType != null)
      {
        if (networkType.equals(networkType)) {}
      }
      else {
        while (networkType != null) {
          return false;
        }
      }
      if (speed != speed) {
        return false;
      }
      if (casting != null)
      {
        if (casting.equals(casting)) {}
      }
      else {
        while (casting != null) {
          return false;
        }
      }
    } while (bitrate == bitrate);
    return false;
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int i5;
    int j;
    label51:
    int i6;
    int i7;
    int k;
    label72:
    int m;
    label88:
    int n;
    label104:
    int i1;
    label120:
    int i2;
    if (mediaUrn != null)
    {
      i = mediaUrn.hashCode();
      i5 = length;
      if (mediaViewTrackingId == null) {
        break label260;
      }
      j = mediaViewTrackingId.hashCode();
      i6 = volume;
      i7 = timeElapsed;
      if (!isPlaying) {
        break label265;
      }
      k = 1;
      if (ccVisible == null) {
        break label270;
      }
      m = ccVisible.hashCode();
      if (fullScreen == null) {
        break label276;
      }
      n = fullScreen.hashCode();
      if (downloaded == null) {
        break label282;
      }
      i1 = downloaded.hashCode();
      if (networkType == null) {
        break label288;
      }
      i2 = networkType.hashCode();
      label136:
      if (speed == 0.0F) {
        break label294;
      }
    }
    label260:
    label265:
    label270:
    label276:
    label282:
    label288:
    label294:
    for (int i3 = Float.floatToIntBits(speed);; i3 = 0)
    {
      if (casting != null) {
        i4 = casting.hashCode();
      }
      i = ((i3 + (i2 + (i1 + (n + (m + (k + (((j + ((i + 527) * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + bitrate;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label72;
      m = 0;
      break label88;
      n = 0;
      break label104;
      i1 = 0;
      break label120;
      i2 = 0;
      break label136;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<PlayerState>
  {
    public int bitrate = 0;
    private PlayerFeatureFlag casting = null;
    private PlayerFeatureFlag ccVisible = null;
    private PlayerFeatureFlag downloaded = null;
    public PlayerFeatureFlag fullScreen = null;
    public boolean hasBitrate = false;
    private boolean hasCasting = false;
    private boolean hasCcVisible = false;
    private boolean hasDownloaded = false;
    public boolean hasFullScreen = false;
    public boolean hasIsPlaying = false;
    public boolean hasLength = false;
    public boolean hasMediaUrn = false;
    public boolean hasMediaViewTrackingId = false;
    public boolean hasNetworkType = false;
    public boolean hasSpeed = false;
    private boolean hasTimeElapsed = false;
    public boolean hasVolume = false;
    public boolean isPlaying = false;
    public int length = 0;
    public String mediaUrn = null;
    public String mediaViewTrackingId = null;
    public NetworkState networkType = null;
    public float speed = 0.0F;
    private int timeElapsed = 0;
    public int volume = 0;
    
    public final PlayerState build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PlayerState.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PlayerState(mediaUrn, length, mediaViewTrackingId, volume, timeElapsed, isPlaying, ccVisible, fullScreen, downloaded, networkType, speed, casting, bitrate, hasMediaUrn, hasLength, hasMediaViewTrackingId, hasVolume, hasTimeElapsed, hasIsPlaying, hasCcVisible, hasFullScreen, hasDownloaded, hasNetworkType, hasSpeed, hasCasting, hasBitrate);
        if (!hasCcVisible) {
          ccVisible = PlayerFeatureFlag.NOT_MEASURED;
        }
        if (!hasFullScreen) {
          fullScreen = PlayerFeatureFlag.NOT_MEASURED;
        }
        if (!hasDownloaded) {
          downloaded = PlayerFeatureFlag.NOT_MEASURED;
        }
        if (!hasNetworkType) {
          networkType = NetworkState.UNKNOWN;
        }
        if (!hasCasting) {
          casting = PlayerFeatureFlag.NOT_MEASURED;
        }
        if (!hasMediaUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerState", "mediaUrn");
        }
        if (!hasLength) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerState", "length");
        }
        if (!hasMediaViewTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerState", "mediaViewTrackingId");
        }
        if (!hasVolume) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerState", "volume");
        }
        if (!hasTimeElapsed) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerState", "timeElapsed");
        }
      } while (hasIsPlaying);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerState", "isPlaying");
    }
    
    public final Builder setTimeElapsed(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasTimeElapsed = false;
        timeElapsed = 0;
        return this;
      }
      hasTimeElapsed = true;
      timeElapsed = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */