package com.linkedin.gen.avro2pegasus.events.player;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PlayerState$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerState.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */