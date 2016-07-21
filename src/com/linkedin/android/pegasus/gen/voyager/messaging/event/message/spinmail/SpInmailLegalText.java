package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SpInmailLegalText
  implements FissileDataModel<SpInmailLegalText>, RecordTemplate<SpInmailLegalText>
{
  public static final SpInmailLegalTextBuilder BUILDER = SpInmailLegalTextBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String customLegalText;
  public final String customLegalTextTracking;
  public final boolean hasCustomLegalText;
  public final boolean hasCustomLegalTextTracking;
  public final boolean hasStaticLegalText;
  public final boolean hasStaticLegalTextTracking;
  public final String staticLegalText;
  public final String staticLegalTextTracking;
  
  SpInmailLegalText(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    customLegalText = paramString1;
    staticLegalText = paramString2;
    customLegalTextTracking = paramString3;
    staticLegalTextTracking = paramString4;
    hasCustomLegalText = paramBoolean1;
    hasStaticLegalText = paramBoolean2;
    hasCustomLegalTextTracking = paramBoolean3;
    hasStaticLegalTextTracking = paramBoolean4;
    _cachedId = null;
  }
  
  public final SpInmailLegalText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCustomLegalText)
    {
      paramDataProcessor.startRecordField$505cff1c("customLegalText");
      paramDataProcessor.processString(customLegalText);
    }
    if (hasStaticLegalText)
    {
      paramDataProcessor.startRecordField$505cff1c("staticLegalText");
      paramDataProcessor.processString(staticLegalText);
    }
    if (hasCustomLegalTextTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("customLegalTextTracking");
      paramDataProcessor.processString(customLegalTextTracking);
    }
    if (hasStaticLegalTextTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("staticLegalTextTracking");
      paramDataProcessor.processString(staticLegalTextTracking);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new SpInmailLegalText(customLegalText, staticLegalText, customLegalTextTracking, staticLegalTextTracking, hasCustomLegalText, hasStaticLegalText, hasCustomLegalTextTracking, hasStaticLegalTextTracking);
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
      paramObject = (SpInmailLegalText)paramObject;
      if (customLegalText != null)
      {
        if (customLegalText.equals(customLegalText)) {}
      }
      else {
        while (customLegalText != null) {
          return false;
        }
      }
      if (staticLegalText != null)
      {
        if (staticLegalText.equals(staticLegalText)) {}
      }
      else {
        while (staticLegalText != null) {
          return false;
        }
      }
      if (customLegalTextTracking != null)
      {
        if (customLegalTextTracking.equals(customLegalTextTracking)) {}
      }
      else {
        while (customLegalTextTracking != null) {
          return false;
        }
      }
      if (staticLegalTextTracking == null) {
        break;
      }
    } while (staticLegalTextTracking.equals(staticLegalTextTracking));
    for (;;)
    {
      return false;
      if (staticLegalTextTracking == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasCustomLegalText) {
      i = PegasusBinaryUtils.getEncodedLength(customLegalText) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasStaticLegalText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(staticLegalText);
    }
    j = i + 1;
    i = j;
    if (hasCustomLegalTextTracking) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(customLegalTextTracking);
    }
    j = i + 1;
    i = j;
    if (hasStaticLegalTextTracking) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(staticLegalTextTracking);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (customLegalText != null)
    {
      i = customLegalText.hashCode();
      if (staticLegalText == null) {
        break label110;
      }
      j = staticLegalText.hashCode();
      label45:
      if (customLegalTextTracking == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = customLegalTextTracking.hashCode();; k = 0)
    {
      if (staticLegalTextTracking != null) {
        m = staticLegalTextTracking.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SpInmailLegalText");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label162:
    label188:
    label257:
    label267:
    label277:
    label285:
    label287:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(471783893);
        if (hasCustomLegalText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, customLegalText);
          if (!hasStaticLegalText) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, staticLegalText);
          if (!hasCustomLegalTextTracking) {
            break label267;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, customLegalTextTracking);
          if (!hasStaticLegalTextTracking) {
            break label277;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, staticLegalTextTracking);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label285;
          }
          if (str != null) {
            break label287;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLegalText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */