package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AggregateFollowCard
  implements FissileDataModel<AggregateFollowCard>, RecordTemplate<AggregateFollowCard>
{
  public static final AggregateFollowCardBuilder BUILDER = AggregateFollowCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<ActorMiniProfile> followers;
  public final boolean hasFollowers;
  public final boolean hasNumFollowers;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final long numFollowers;
  public final long publishedAt;
  public final boolean read;
  
  AggregateFollowCard(long paramLong1, List<ActorMiniProfile> paramList, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    publishedAt = paramLong1;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      followers = paramList;
      numFollowers = paramLong2;
      read = paramBoolean1;
      hasPublishedAt = paramBoolean2;
      hasFollowers = paramBoolean3;
      hasNumFollowers = paramBoolean4;
      hasRead = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final AggregateFollowCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject = null;
    ActorMiniProfile localActorMiniProfile = null;
    boolean bool = false;
    if (hasFollowers)
    {
      paramDataProcessor.startRecordField$505cff1c("followers");
      followers.size();
      paramDataProcessor.startArray$13462e();
      localObject = localActorMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = followers.iterator();
      if (localIterator.hasNext())
      {
        localActorMiniProfile = (ActorMiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localActorMiniProfile = localActorMiniProfile.accept(paramDataProcessor);; localActorMiniProfile = (ActorMiniProfile)paramDataProcessor.processDataTemplate(localActorMiniProfile))
        {
          if ((localObject != null) && (localActorMiniProfile != null)) {
            ((List)localObject).add(localActorMiniProfile);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (bool = true;; bool = false)
    {
      if (hasNumFollowers)
      {
        paramDataProcessor.startRecordField$505cff1c("numFollowers");
        paramDataProcessor.processLong(numFollowers);
      }
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label448;
      }
      try
      {
        if (hasPublishedAt) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasFollowers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "followers");
    }
    if (!hasNumFollowers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "numFollowers");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "read");
    }
    if (followers != null)
    {
      paramDataProcessor = followers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ActorMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "followers");
        }
      }
    }
    return new AggregateFollowCard(publishedAt, (List)localObject, numFollowers, read, hasPublishedAt, bool, hasNumFollowers, hasRead);
    label448:
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
      paramObject = (AggregateFollowCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (followers != null)
      {
        if (followers.equals(followers)) {}
      }
      else {
        while (followers != null) {
          return false;
        }
      }
      if (numFollowers != numFollowers) {
        return false;
      }
    } while (read == read);
    return false;
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
    i += 1;
    j = i;
    if (hasFollowers)
    {
      i += 2;
      Iterator localIterator = followers.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        ActorMiniProfile localActorMiniProfile = (ActorMiniProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localActorMiniProfile.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasNumFollowers) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasRead) {
      i = j + 1;
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
    int k = (int)(publishedAt ^ publishedAt >>> 32);
    if (followers != null) {}
    for (int i = followers.hashCode();; i = 0)
    {
      int m = (int)(numFollowers ^ numFollowers >>> 32);
      if (read) {
        j = 1;
      }
      i = ((i + (k + 527) * 31) * 31 + m) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AggregateFollowCard");
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
    label281:
    label329:
    label381:
    label387:
    label395:
    label397:
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
        localByteBuffer.putInt(1203132163);
        Iterator localIterator;
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (hasFollowers)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, followers.size());
            localIterator = followers.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label281;
            }
            ActorMiniProfile localActorMiniProfile = (ActorMiniProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localActorMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localActorMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasNumFollowers)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numFollowers);
          if (!hasRead) {
            break label387;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label381;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label395;
          }
          if (str != null) {
            break label397;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label329;
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
    implements RecordTemplateBuilder<AggregateFollowCard>
  {
    private List<ActorMiniProfile> followers = null;
    private boolean hasFollowers = false;
    private boolean hasNumFollowers = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private long numFollowers = 0L;
    private long publishedAt = 0L;
    public boolean read = false;
    
    public Builder() {}
    
    public Builder(AggregateFollowCard paramAggregateFollowCard)
    {
      publishedAt = publishedAt;
      followers = followers;
      numFollowers = numFollowers;
      read = read;
      hasPublishedAt = hasPublishedAt;
      hasFollowers = hasFollowers;
      hasNumFollowers = hasNumFollowers;
      hasRead = hasRead;
    }
    
    public final AggregateFollowCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AggregateFollowCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (followers != null)
      {
        paramFlavor = followers.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((ActorMiniProfile)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "followers");
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "publishedAt");
              }
              if (!hasFollowers) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "followers");
              }
              if (!hasNumFollowers) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "numFollowers");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "read");
            }
          }
        }
      }
      return new AggregateFollowCard(publishedAt, followers, numFollowers, read, hasPublishedAt, hasFollowers, hasNumFollowers, hasRead);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */