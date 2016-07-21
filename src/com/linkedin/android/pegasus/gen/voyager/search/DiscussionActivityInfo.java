package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DiscussionActivityInfo
  implements FissileDataModel<DiscussionActivityInfo>, RecordTemplate<DiscussionActivityInfo>
{
  public static final DiscussionActivityInfoBuilder BUILDER = DiscussionActivityInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String displayText;
  public final boolean hasDisplayText;
  public final boolean hasNumDiscussions;
  public final boolean hasPeriod;
  public final int numDiscussions;
  public final DiscussionActivityPeriod period;
  
  DiscussionActivityInfo(int paramInt, DiscussionActivityPeriod paramDiscussionActivityPeriod, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    numDiscussions = paramInt;
    period = paramDiscussionActivityPeriod;
    displayText = paramString;
    hasNumDiscussions = paramBoolean1;
    hasPeriod = paramBoolean2;
    hasDisplayText = paramBoolean3;
    _cachedId = null;
  }
  
  public final DiscussionActivityInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumDiscussions)
    {
      paramDataProcessor.startRecordField$505cff1c("numDiscussions");
      paramDataProcessor.processInt(numDiscussions);
    }
    if (hasPeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("period");
      paramDataProcessor.processEnum(period);
    }
    if (hasDisplayText)
    {
      paramDataProcessor.startRecordField$505cff1c("displayText");
      paramDataProcessor.processString(displayText);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumDiscussions) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo", "numDiscussions");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasPeriod) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo", "period");
      }
      if (!hasDisplayText) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo", "displayText");
      }
      return new DiscussionActivityInfo(numDiscussions, period, displayText, hasNumDiscussions, hasPeriod, hasDisplayText);
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
      paramObject = (DiscussionActivityInfo)paramObject;
      if (numDiscussions != numDiscussions) {
        return false;
      }
      if (period != null)
      {
        if (period.equals(period)) {}
      }
      else {
        while (period != null) {
          return false;
        }
      }
      if (displayText == null) {
        break;
      }
    } while (displayText.equals(displayText));
    for (;;)
    {
      return false;
      if (displayText == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumDiscussions) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasPeriod) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasDisplayText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayText);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int k = numDiscussions;
    if (period != null) {}
    for (int i = period.hashCode();; i = 0)
    {
      if (displayText != null) {
        j = displayText.hashCode();
      }
      i = (i + (k + 527) * 31) * 31 + j;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DiscussionActivityInfo");
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
    label163:
    label232:
    label242:
    label250:
    label252:
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
        localByteBuffer.putInt(1240283842);
        if (hasNumDiscussions)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numDiscussions);
          if (!hasPeriod) {
            break label232;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, period.ordinal());
          if (!hasDisplayText) {
            break label242;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayText);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label250;
          }
          if (str != null) {
            break label252;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label163;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */