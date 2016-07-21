package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class Subchannels
  implements RecordTemplate<Subchannels>
{
  public static final SubchannelsBuilder BUILDER = SubchannelsBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int badge;
  public final boolean hasBadge;
  public final boolean hasNotificationCenter;
  public final boolean hasSound;
  public final boolean hasText;
  public final boolean notificationCenter;
  public final String sound;
  public final String text;
  
  Subchannels(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    text = paramString1;
    badge = paramInt;
    sound = paramString2;
    notificationCenter = paramBoolean1;
    hasText = paramBoolean2;
    hasBadge = paramBoolean3;
    hasSound = paramBoolean4;
    hasNotificationCenter = paramBoolean5;
    _cachedId = null;
  }
  
  public final Subchannels accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    if (hasBadge)
    {
      paramDataProcessor.startRecordField$505cff1c("badge");
      paramDataProcessor.processInt(badge);
    }
    if (hasSound)
    {
      paramDataProcessor.startRecordField$505cff1c("sound");
      paramDataProcessor.processString(sound);
    }
    if (hasNotificationCenter)
    {
      paramDataProcessor.startRecordField$505cff1c("notificationCenter");
      paramDataProcessor.processBoolean(notificationCenter);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new Subchannels(text, badge, sound, notificationCenter, hasText, hasBadge, hasSound, hasNotificationCenter);
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
      paramObject = (Subchannels)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (badge != badge) {
        return false;
      }
      if (sound != null)
      {
        if (sound.equals(sound)) {}
      }
      else {
        while (sound != null) {
          return false;
        }
      }
    } while (notificationCenter == notificationCenter);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int m;
    if (text != null)
    {
      i = text.hashCode();
      m = badge;
      if (sound == null) {
        break label93;
      }
    }
    label93:
    for (int j = sound.hashCode();; j = 0)
    {
      if (notificationCenter) {
        k = 1;
      }
      i = (j + ((i + 527) * 31 + m) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.Subchannels
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */