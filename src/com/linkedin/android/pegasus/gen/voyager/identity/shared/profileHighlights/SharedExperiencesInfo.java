package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

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
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SharedExperiencesInfo
  implements FissileDataModel<SharedExperiencesInfo>, RecordTemplate<SharedExperiencesInfo>
{
  public static final SharedExperiencesInfoBuilder BUILDER = SharedExperiencesInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSharedExperiences;
  public final List<SharedExperienceInfo> sharedExperiences;
  
  SharedExperiencesInfo(List<SharedExperienceInfo> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      sharedExperiences = paramList;
      hasSharedExperiences = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final SharedExperiencesInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    SharedExperienceInfo localSharedExperienceInfo = null;
    boolean bool = false;
    if (hasSharedExperiences)
    {
      paramDataProcessor.startRecordField$505cff1c("sharedExperiences");
      sharedExperiences.size();
      paramDataProcessor.startArray$13462e();
      localObject = localSharedExperienceInfo;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = sharedExperiences.iterator();
      if (localIterator.hasNext())
      {
        localSharedExperienceInfo = (SharedExperienceInfo)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSharedExperienceInfo = localSharedExperienceInfo.accept(paramDataProcessor);; localSharedExperienceInfo = (SharedExperienceInfo)paramDataProcessor.processDataTemplate(localSharedExperienceInfo))
        {
          if ((localObject != null) && (localSharedExperienceInfo != null)) {
            ((List)localObject).add(localSharedExperienceInfo);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label226;
      }
    }
    label226:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label292;
      }
      try
      {
        if (hasSharedExperiences) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedExperiencesInfo", "sharedExperiences");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (sharedExperiences != null)
    {
      paramDataProcessor = sharedExperiences.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SharedExperienceInfo)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedExperiencesInfo", "sharedExperiences");
        }
      }
    }
    return new SharedExperiencesInfo((List)localObject, bool);
    label292:
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
      paramObject = (SharedExperiencesInfo)paramObject;
      if (sharedExperiences == null) {
        break;
      }
    } while (sharedExperiences.equals(sharedExperiences));
    for (;;)
    {
      return false;
      if (sharedExperiences == null) {
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
    if (hasSharedExperiences)
    {
      i += 2;
      Iterator localIterator = sharedExperiences.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        SharedExperienceInfo localSharedExperienceInfo = (SharedExperienceInfo)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localSharedExperienceInfo.getSerializedSize();
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
    if (sharedExperiences != null) {}
    for (int i = sharedExperiences.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SharedExperiencesInfo");
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
        localByteBuffer.putInt(-923000960);
        if (hasSharedExperiences)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, sharedExperiences.size());
          Iterator localIterator = sharedExperiences.iterator();
          while (localIterator.hasNext())
          {
            SharedExperienceInfo localSharedExperienceInfo = (SharedExperienceInfo)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localSharedExperienceInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localSharedExperienceInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedExperiencesInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */