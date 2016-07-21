package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class TopSkillsAnalytics
  implements FissileDataModel<TopSkillsAnalytics>, RecordTemplate<TopSkillsAnalytics>
{
  public static final TopSkillsAnalyticsBuilder BUILDER = TopSkillsAnalyticsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasTopSkills;
  public final List<TopSkill> topSkills;
  
  TopSkillsAnalytics(List<TopSkill> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      topSkills = paramList;
      hasTopSkills = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final TopSkillsAnalytics accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    TopSkill localTopSkill = null;
    boolean bool = false;
    if (hasTopSkills)
    {
      paramDataProcessor.startRecordField$505cff1c("topSkills");
      topSkills.size();
      paramDataProcessor.startArray$13462e();
      localObject = localTopSkill;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = topSkills.iterator();
      if (localIterator.hasNext())
      {
        localTopSkill = (TopSkill)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localTopSkill = localTopSkill.accept(paramDataProcessor);; localTopSkill = (TopSkill)paramDataProcessor.processDataTemplate(localTopSkill))
        {
          if ((localObject != null) && (localTopSkill != null)) {
            ((List)localObject).add(localTopSkill);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label269;
      }
    }
    label269:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label285;
      }
      if (!hasTopSkills) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (topSkills == null) {
          break;
        }
        paramDataProcessor = topSkills.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((TopSkill)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillsAnalytics", "topSkills");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new TopSkillsAnalytics((List)localObject, bool);
    label285:
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
      paramObject = (TopSkillsAnalytics)paramObject;
      if (topSkills == null) {
        break;
      }
    } while (topSkills.equals(topSkills));
    for (;;)
    {
      return false;
      if (topSkills == null) {
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
    int j = i;
    if (hasTopSkills)
    {
      i += 2;
      Iterator localIterator = topSkills.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        TopSkill localTopSkill = (TopSkill)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localTopSkill.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (topSkills != null) {}
    for (int i = topSkills.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TopSkillsAnalytics");
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
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-213921085);
        if (hasTopSkills)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, topSkills.size());
          Iterator localIterator = topSkills.iterator();
          while (localIterator.hasNext())
          {
            TopSkill localTopSkill = (TopSkill)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localTopSkill.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localTopSkill.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillsAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */