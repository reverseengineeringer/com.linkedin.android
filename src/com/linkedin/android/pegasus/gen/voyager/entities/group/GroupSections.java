package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GroupSections
  implements FissileDataModel<GroupSections>, RecordTemplate<GroupSections>
{
  public static final GroupSectionsBuilder BUILDER = GroupSectionsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Section details;
  public final boolean hasDetails;
  public final boolean hasPosts;
  public final Section posts;
  
  GroupSections(Section paramSection1, Section paramSection2, boolean paramBoolean1, boolean paramBoolean2)
  {
    posts = paramSection1;
    details = paramSection2;
    hasPosts = paramBoolean1;
    hasDetails = paramBoolean2;
    _cachedId = null;
  }
  
  public final GroupSections accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    Section localSection;
    if (hasPosts)
    {
      paramDataProcessor.startRecordField$505cff1c("posts");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localSection = posts.accept(paramDataProcessor);
        if (localSection == null) {
          break label149;
        }
        bool1 = true;
        localObject = localSection;
      }
    }
    else
    {
      label56:
      localSection = null;
      bool2 = false;
      if (hasDetails)
      {
        paramDataProcessor.startRecordField$505cff1c("details");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localSection = details.accept(paramDataProcessor);
        label95:
        if (localSection == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new GroupSections((Section)localObject, localSection, bool1, bool2);
      localSection = (Section)paramDataProcessor.processDataTemplate(posts);
      break;
      bool1 = false;
      localObject = localSection;
      break label56;
      localSection = (Section)paramDataProcessor.processDataTemplate(details);
      break label95;
    }
    label181:
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
      paramObject = (GroupSections)paramObject;
      if (posts != null)
      {
        if (posts.equals(posts)) {}
      }
      else {
        while (posts != null) {
          return false;
        }
      }
      if (details == null) {
        break;
      }
    } while (details.equals(details));
    for (;;)
    {
      return false;
      if (details == null) {
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
    if (hasPosts)
    {
      if (posts._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(posts._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasDetails)
      {
        i = j + 1;
        if (details._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(details._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = posts.getSerializedSize() + 7;
      break;
      label114:
      i += details.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (posts != null) {}
    for (int i = posts.hashCode();; i = 0)
    {
      if (details != null) {
        j = details.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GroupSections");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(171049488);
        if (hasPosts)
        {
          localByteBuffer.put((byte)1);
          if (posts._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, posts._cachedId);
            posts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDetails) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (details._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, details._cachedId);
            details.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          posts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          details.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.GroupSections
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */