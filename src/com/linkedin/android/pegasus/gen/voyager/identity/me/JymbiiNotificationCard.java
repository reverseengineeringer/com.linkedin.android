package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation;
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

public final class JymbiiNotificationCard
  implements FissileDataModel<JymbiiNotificationCard>, RecordTemplate<JymbiiNotificationCard>
{
  public static final JymbiiNotificationCardBuilder BUILDER = JymbiiNotificationCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasJobRecommendations;
  public final boolean hasJobsCount;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final List<EntitiesJobRecommendation> jobRecommendations;
  public final long jobsCount;
  public final long publishedAt;
  public final boolean read;
  
  JymbiiNotificationCard(long paramLong1, long paramLong2, List<EntitiesJobRecommendation> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    publishedAt = paramLong1;
    jobsCount = paramLong2;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      jobRecommendations = paramList;
      read = paramBoolean1;
      hasPublishedAt = paramBoolean2;
      hasJobsCount = paramBoolean3;
      hasJobRecommendations = paramBoolean4;
      hasRead = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final JymbiiNotificationCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    if (hasJobsCount)
    {
      paramDataProcessor.startRecordField$505cff1c("jobsCount");
      paramDataProcessor.processLong(jobsCount);
    }
    Object localObject = null;
    EntitiesJobRecommendation localEntitiesJobRecommendation = null;
    boolean bool = false;
    if (hasJobRecommendations)
    {
      paramDataProcessor.startRecordField$505cff1c("jobRecommendations");
      jobRecommendations.size();
      paramDataProcessor.startArray$13462e();
      localObject = localEntitiesJobRecommendation;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = jobRecommendations.iterator();
      if (localIterator.hasNext())
      {
        localEntitiesJobRecommendation = (EntitiesJobRecommendation)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localEntitiesJobRecommendation = localEntitiesJobRecommendation.accept(paramDataProcessor);; localEntitiesJobRecommendation = (EntitiesJobRecommendation)paramDataProcessor.processDataTemplate(localEntitiesJobRecommendation))
        {
          if ((localObject != null) && (localEntitiesJobRecommendation != null)) {
            ((List)localObject).add(localEntitiesJobRecommendation);
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasJobsCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobsCount");
    }
    if (!hasJobRecommendations) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobRecommendations");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "read");
    }
    if (jobRecommendations != null)
    {
      paramDataProcessor = jobRecommendations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesJobRecommendation)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobRecommendations");
        }
      }
    }
    return new JymbiiNotificationCard(publishedAt, jobsCount, (List)localObject, read, hasPublishedAt, hasJobsCount, bool, hasRead);
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
      paramObject = (JymbiiNotificationCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (jobsCount != jobsCount) {
        return false;
      }
      if (jobRecommendations != null)
      {
        if (jobRecommendations.equals(jobRecommendations)) {}
      }
      else {
        while (jobRecommendations != null) {
          return false;
        }
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
    j = i + 1;
    i = j;
    if (hasJobsCount) {
      i = j + 8;
    }
    i += 1;
    j = i;
    if (hasJobRecommendations)
    {
      i += 2;
      Iterator localIterator = jobRecommendations.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        EntitiesJobRecommendation localEntitiesJobRecommendation = (EntitiesJobRecommendation)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localEntitiesJobRecommendation.getSerializedSize();
        }
      }
    }
    j += 1;
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
    int m = (int)(jobsCount ^ jobsCount >>> 32);
    if (jobRecommendations != null) {}
    for (int i = jobRecommendations.hashCode();; i = 0)
    {
      if (read) {
        j = 1;
      }
      i = (i + ((k + 527) * 31 + m) * 31) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JymbiiNotificationCard");
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
    label158:
    label275:
    label308:
    label315:
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
        localByteBuffer.putInt(-163684268);
        Iterator localIterator;
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasJobsCount) {
            break label275;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(jobsCount);
          if (!hasJobRecommendations) {
            break label308;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, jobRecommendations.size());
          localIterator = jobRecommendations.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label315;
          }
          EntitiesJobRecommendation localEntitiesJobRecommendation = (EntitiesJobRecommendation)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesJobRecommendation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label158;
          }
          localByteBuffer.put((byte)1);
          localEntitiesJobRecommendation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasRead)
        {
          localByteBuffer.put((byte)1);
          if (read)
          {
            i = 1;
            localByteBuffer.put((byte)i);
          }
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
          i = 0;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<JymbiiNotificationCard>
  {
    private boolean hasJobRecommendations = false;
    private boolean hasJobsCount = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private List<EntitiesJobRecommendation> jobRecommendations = null;
    private long jobsCount = 0L;
    private long publishedAt = 0L;
    public boolean read = false;
    
    public Builder() {}
    
    public Builder(JymbiiNotificationCard paramJymbiiNotificationCard)
    {
      publishedAt = publishedAt;
      jobsCount = jobsCount;
      jobRecommendations = jobRecommendations;
      read = read;
      hasPublishedAt = hasPublishedAt;
      hasJobsCount = hasJobsCount;
      hasJobRecommendations = hasJobRecommendations;
      hasRead = hasRead;
    }
    
    public final JymbiiNotificationCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (JymbiiNotificationCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (jobRecommendations != null)
      {
        paramFlavor = jobRecommendations.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((EntitiesJobRecommendation)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobRecommendations");
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "publishedAt");
              }
              if (!hasJobsCount) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobsCount");
              }
              if (!hasJobRecommendations) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "jobRecommendations");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard", "read");
            }
          }
        }
      }
      return new JymbiiNotificationCard(publishedAt, jobsCount, jobRecommendations, read, hasPublishedAt, hasJobsCount, hasJobRecommendations, hasRead);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */