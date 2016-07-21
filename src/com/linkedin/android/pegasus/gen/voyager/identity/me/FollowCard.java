package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class FollowCard
  implements FissileDataModel<FollowCard>, RecordTemplate<FollowCard>
{
  public static final FollowCardBuilder BUILDER = FollowCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ActorMiniProfile follower;
  public final boolean hasFollower;
  public final boolean hasOccupation;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final Occupation occupation;
  public final long publishedAt;
  public final boolean read;
  
  FollowCard(long paramLong, ActorMiniProfile paramActorMiniProfile, boolean paramBoolean1, Occupation paramOccupation, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    publishedAt = paramLong;
    follower = paramActorMiniProfile;
    read = paramBoolean1;
    occupation = paramOccupation;
    hasPublishedAt = paramBoolean2;
    hasFollower = paramBoolean3;
    hasRead = paramBoolean4;
    hasOccupation = paramBoolean5;
    _cachedId = null;
  }
  
  public final FollowCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasFollower)
    {
      paramDataProcessor.startRecordField$505cff1c("follower");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = follower.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label214;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label81:
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      localObject1 = null;
      bool2 = false;
      if (hasOccupation)
      {
        paramDataProcessor.startRecordField$505cff1c("occupation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label223;
        }
        localObject1 = occupation.accept(paramDataProcessor);
        label145:
        if (localObject1 == null) {
          break label241;
        }
      }
    }
    label214:
    label223:
    label241:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label314;
      }
      try
      {
        if (hasPublishedAt) {
          break label246;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (ActorMiniProfile)paramDataProcessor.processDataTemplate(follower);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Occupation)paramDataProcessor.processDataTemplate(occupation);
      break label145;
    }
    label246:
    if (!hasFollower) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "follower");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "read");
    }
    return new FollowCard(publishedAt, (ActorMiniProfile)localObject2, read, (Occupation)localObject1, hasPublishedAt, bool1, hasRead, bool2);
    label314:
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
      paramObject = (FollowCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (follower != null)
      {
        if (follower.equals(follower)) {}
      }
      else {
        while (follower != null) {
          return false;
        }
      }
      if (read != read) {
        return false;
      }
      if (occupation == null) {
        break;
      }
    } while (occupation.equals(occupation));
    for (;;)
    {
      return false;
      if (occupation == null) {
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
    if (hasPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasFollower)
    {
      i = j + 1;
      if (follower._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(follower._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasOccupation)
      {
        i = j + 1;
        if (occupation._cachedId == null) {
          break label155;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(occupation._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += follower.getSerializedSize();
      break;
      label155:
      i += occupation.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int m = (int)(publishedAt ^ publishedAt >>> 32);
    int i;
    if (follower != null)
    {
      i = follower.hashCode();
      if (!read) {
        break label102;
      }
    }
    label102:
    for (int j = 1;; j = 0)
    {
      if (occupation != null) {
        k = occupation.hashCode();
      }
      i = (j + (i + (m + 527) * 31) * 31) * 31 + k;
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
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FollowCard");
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
    label194:
    label218:
    label227:
    label330:
    label355:
    label365:
    label371:
    label381:
    label406:
    label414:
    label416:
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
        localByteBuffer.putInt(2126636997);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasFollower) {
            break label355;
          }
          localByteBuffer.put((byte)1);
          if (follower._cachedId == null) {
            break label330;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, follower._cachedId);
          follower.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRead) {
            break label371;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label365;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasOccupation) {
            break label406;
          }
          localByteBuffer.put((byte)1);
          if (occupation._cachedId == null) {
            break label381;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, occupation._cachedId);
          occupation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label414;
          }
          if (str != null) {
            break label416;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          follower.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label194;
          localByteBuffer.put((byte)0);
          break label194;
          i = 0;
          break label218;
          localByteBuffer.put((byte)0);
          break label227;
          localByteBuffer.put((byte)1);
          occupation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<FollowCard>
  {
    private ActorMiniProfile follower = null;
    private boolean hasFollower = false;
    private boolean hasOccupation = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private Occupation occupation = null;
    private long publishedAt = 0L;
    public boolean read = false;
    
    public Builder() {}
    
    public Builder(FollowCard paramFollowCard)
    {
      publishedAt = publishedAt;
      follower = follower;
      read = read;
      occupation = occupation;
      hasPublishedAt = hasPublishedAt;
      hasFollower = hasFollower;
      hasRead = hasRead;
      hasOccupation = hasOccupation;
    }
    
    public final FollowCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FollowCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new FollowCard(publishedAt, follower, read, occupation, hasPublishedAt, hasFollower, hasRead, hasOccupation);
        if (!hasPublishedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "publishedAt");
        }
        if (!hasFollower) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "follower");
        }
      } while (hasRead);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "read");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */