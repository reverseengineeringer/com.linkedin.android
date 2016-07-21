package com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfile;
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

public final class SameTitleInfo
  implements FissileDataModel<SameTitleInfo>, RecordTemplate<SameTitleInfo>
{
  public static final SameTitleInfoBuilder BUILDER = SameTitleInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<HighlightsMiniProfile> endorsers;
  public final boolean hasEndorsers;
  public final boolean hasTitle;
  public final boolean hasTotalCount;
  public final String title;
  public final int totalCount;
  
  SameTitleInfo(List<HighlightsMiniProfile> paramList, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      endorsers = paramList;
      totalCount = paramInt;
      title = paramString;
      hasEndorsers = paramBoolean1;
      hasTotalCount = paramBoolean2;
      hasTitle = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final SameTitleInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    HighlightsMiniProfile localHighlightsMiniProfile = null;
    boolean bool = false;
    if (hasEndorsers)
    {
      paramDataProcessor.startRecordField$505cff1c("endorsers");
      endorsers.size();
      paramDataProcessor.startArray$13462e();
      localObject = localHighlightsMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = endorsers.iterator();
      if (localIterator.hasNext())
      {
        localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localHighlightsMiniProfile = localHighlightsMiniProfile.accept(paramDataProcessor);; localHighlightsMiniProfile = (HighlightsMiniProfile)paramDataProcessor.processDataTemplate(localHighlightsMiniProfile))
        {
          if ((localObject != null) && (localHighlightsMiniProfile != null)) {
            ((List)localObject).add(localHighlightsMiniProfile);
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
      if (hasTotalCount)
      {
        paramDataProcessor.startRecordField$505cff1c("totalCount");
        paramDataProcessor.processInt(totalCount);
      }
      if (hasTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("title");
        paramDataProcessor.processString(title);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label396;
      }
      try
      {
        if (hasEndorsers) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo", "endorsers");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTotalCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo", "totalCount");
    }
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo", "title");
    }
    if (endorsers != null)
    {
      paramDataProcessor = endorsers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((HighlightsMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo", "endorsers");
        }
      }
    }
    return new SameTitleInfo((List)localObject, totalCount, title, bool, hasTotalCount, hasTitle);
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
      paramObject = (SameTitleInfo)paramObject;
      if (endorsers != null)
      {
        if (endorsers.equals(endorsers)) {}
      }
      else {
        while (endorsers != null) {
          return false;
        }
      }
      if (totalCount != totalCount) {
        return false;
      }
      if (title == null) {
        break;
      }
    } while (title.equals(title));
    for (;;)
    {
      return false;
      if (title == null) {
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
    if (hasEndorsers)
    {
      i += 2;
      Iterator localIterator = endorsers.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localHighlightsMiniProfile.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTotalCount) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
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
    if (endorsers != null) {}
    for (int i = endorsers.hashCode();; i = 0)
    {
      int k = totalCount;
      if (title != null) {
        j = title.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SameTitleInfo");
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
    label340:
    label348:
    label350:
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
        localByteBuffer.putInt(396184806);
        if (hasEndorsers)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, endorsers.size());
          Iterator localIterator = endorsers.iterator();
          while (localIterator.hasNext())
          {
            HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localHighlightsMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localHighlightsMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTotalCount)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalCount);
          if (!hasTitle) {
            break label340;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label348;
          }
          if (str != null) {
            break label350;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SameTitleInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */