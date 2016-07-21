package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class WvmpCard
  implements FissileDataModel<WvmpCard>, RecordTemplate<WvmpCard>
{
  public static final WvmpCardBuilder BUILDER = WvmpCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasProfiles;
  public final boolean hasWvmpDurationInDays;
  public final boolean hasWvmpTotal;
  public final List<MiniProfile> profiles;
  public final int wvmpDurationInDays;
  public final long wvmpTotal;
  
  WvmpCard(List<MiniProfile> paramList, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      profiles = paramList;
      wvmpTotal = paramLong;
      wvmpDurationInDays = paramInt;
      hasProfiles = paramBoolean1;
      hasWvmpTotal = paramBoolean2;
      hasWvmpDurationInDays = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final WvmpCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    MiniProfile localMiniProfile = null;
    boolean bool = false;
    if (hasProfiles)
    {
      paramDataProcessor.startRecordField$505cff1c("profiles");
      profiles.size();
      paramDataProcessor.startArray$13462e();
      localObject = localMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = profiles.iterator();
      if (localIterator.hasNext())
      {
        localMiniProfile = (MiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localMiniProfile = localMiniProfile.accept(paramDataProcessor);; localMiniProfile = (MiniProfile)paramDataProcessor.processDataTemplate(localMiniProfile))
        {
          if ((localObject != null) && (localMiniProfile != null)) {
            ((List)localObject).add(localMiniProfile);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label276;
      }
    }
    label276:
    for (bool = true;; bool = false)
    {
      if (hasWvmpTotal)
      {
        paramDataProcessor.startRecordField$505cff1c("wvmpTotal");
        paramDataProcessor.processLong(wvmpTotal);
      }
      if (hasWvmpDurationInDays)
      {
        paramDataProcessor.startRecordField$505cff1c("wvmpDurationInDays");
        paramDataProcessor.processInt(wvmpDurationInDays);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label396;
      }
      try
      {
        if (hasProfiles) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard", "profiles");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasWvmpTotal) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard", "wvmpTotal");
    }
    if (!hasWvmpDurationInDays) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard", "wvmpDurationInDays");
    }
    if (profiles != null)
    {
      paramDataProcessor = profiles.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard", "profiles");
        }
      }
    }
    return new WvmpCard((List)localObject, wvmpTotal, wvmpDurationInDays, bool, hasWvmpTotal, hasWvmpDurationInDays);
    label396:
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
      paramObject = (WvmpCard)paramObject;
      if (profiles != null)
      {
        if (profiles.equals(profiles)) {}
      }
      else {
        while (profiles != null) {
          return false;
        }
      }
      if (wvmpTotal != wvmpTotal) {
        return false;
      }
    } while (wvmpDurationInDays == wvmpDurationInDays);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasProfiles)
    {
      i += 2;
      Iterator localIterator = profiles.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localMiniProfile.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasWvmpTotal) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasWvmpDurationInDays) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (profiles != null) {}
    for (int i = profiles.hashCode();; i = 0)
    {
      i = ((i + 527) * 31 + (int)(wvmpTotal ^ wvmpTotal >>> 32)) * 31 + wvmpDurationInDays;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpCard");
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
    label338:
    label346:
    label348:
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
        localByteBuffer.putInt(647108450);
        if (hasProfiles)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, profiles.size());
          Iterator localIterator = profiles.iterator();
          while (localIterator.hasNext())
          {
            MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasWvmpTotal)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(wvmpTotal);
          if (!hasWvmpDurationInDays) {
            break label338;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(wvmpDurationInDays);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label346;
          }
          if (str != null) {
            break label348;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */