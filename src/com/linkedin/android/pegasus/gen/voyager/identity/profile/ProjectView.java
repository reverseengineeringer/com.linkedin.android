package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
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

public final class ProjectView
  implements FissileDataModel<ProjectView>, RecordTemplate<ProjectView>
{
  public static final ProjectViewBuilder BUILDER = ProjectViewBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Project> elements;
  public final boolean hasElements;
  public final boolean hasPaging;
  public final boolean hasProfileId;
  public final CollectionMetadata paging;
  public final String profileId;
  
  ProjectView(String paramString, CollectionMetadata paramCollectionMetadata, List<Project> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    profileId = paramString;
    paging = paramCollectionMetadata;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      elements = paramString;
      hasProfileId = paramBoolean1;
      hasPaging = paramBoolean2;
      hasElements = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final ProjectView accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasProfileId)
    {
      paramDataProcessor.startRecordField$505cff1c("profileId");
      paramDataProcessor.processString(profileId);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    int i;
    if (hasPaging)
    {
      paramDataProcessor.startRecordField$505cff1c("paging");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = paging.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localProject = null;
      bool2 = false;
      if (!hasElements) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("elements");
      elements.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localProject;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = elements.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localProject = (Project)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (Project localProject = localProject.accept(paramDataProcessor);; localProject = (Project)paramDataProcessor.processDataTemplate(localProject))
    {
      if ((localObject1 != null) && (localProject != null)) {
        ((List)localObject1).add(localProject);
      }
      i += 1;
      break label156;
      localObject1 = (CollectionMetadata)paramDataProcessor.processDataTemplate(paging);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
    }
    label272:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label286:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label428;
      }
      try
      {
        if (hasPaging) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProjectView", "paging");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasElements) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProjectView", "elements");
    }
    if (elements != null)
    {
      paramDataProcessor = elements.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Project)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProjectView", "elements");
        }
      }
    }
    return new ProjectView(profileId, (CollectionMetadata)localObject2, (List)localObject1, hasProfileId, bool1, bool2);
    label428:
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
      paramObject = (ProjectView)paramObject;
      if (profileId != null)
      {
        if (profileId.equals(profileId)) {}
      }
      else {
        while (profileId != null) {
          return false;
        }
      }
      if (paging != null)
      {
        if (paging.equals(paging)) {}
      }
      else {
        while (paging != null) {
          return false;
        }
      }
      if (elements == null) {
        break;
      }
    } while (elements.equals(elements));
    for (;;)
    {
      return false;
      if (elements == null) {
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
    if (hasProfileId) {
      i = PegasusBinaryUtils.getEncodedLength(profileId) + 8;
    }
    int j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasPaging)
    {
      i = j + 1;
      if (paging._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(paging._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasElements) {
        break label181;
      }
      i += 2;
      localIterator = elements.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label181;
      }
      Project localProject = (Project)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += paging.getSerializedSize();
        break;
      }
      i += localProject.getSerializedSize();
    }
    label181:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (profileId != null)
    {
      i = profileId.hashCode();
      if (paging == null) {
        break label89;
      }
    }
    label89:
    for (int j = paging.hashCode();; j = 0)
    {
      if (elements != null) {
        k = elements.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProjectView");
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
    label196:
    label313:
    label338:
    label371:
    label378:
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
        localByteBuffer.putInt(1570154818);
        Iterator localIterator;
        if (hasProfileId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, profileId);
          if (!hasPaging) {
            break label338;
          }
          localByteBuffer.put((byte)1);
          if (paging._cachedId == null) {
            break label313;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, paging._cachedId);
          paging.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasElements) {
            break label371;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, elements.size());
          localIterator = elements.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label378;
          }
          Project localProject = (Project)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localProject.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            paging.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label196;
            localByteBuffer.put((byte)0);
            break label196;
          }
          localByteBuffer.put((byte)1);
          localProject.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProjectView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */