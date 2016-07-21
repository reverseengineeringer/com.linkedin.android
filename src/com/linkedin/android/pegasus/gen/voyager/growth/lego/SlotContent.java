package com.linkedin.android.pegasus.gen.voyager.growth.lego;

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

public final class SlotContent
  implements FissileDataModel<SlotContent>, RecordTemplate<SlotContent>
{
  public static final SlotContentBuilder BUILDER = SlotContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<GroupContent> groups;
  public final boolean hasGroups;
  public final boolean hasSlotId;
  public final String slotId;
  
  SlotContent(String paramString, List<GroupContent> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    slotId = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      groups = paramString;
      hasSlotId = paramBoolean1;
      hasGroups = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final SlotContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSlotId)
    {
      paramDataProcessor.startRecordField$505cff1c("slotId");
      paramDataProcessor.processString(slotId);
    }
    Object localObject = null;
    GroupContent localGroupContent = null;
    boolean bool = false;
    if (hasGroups)
    {
      paramDataProcessor.startRecordField$505cff1c("groups");
      groups.size();
      paramDataProcessor.startArray$13462e();
      localObject = localGroupContent;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = groups.iterator();
      if (localIterator.hasNext())
      {
        localGroupContent = (GroupContent)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localGroupContent = localGroupContent.accept(paramDataProcessor);; localGroupContent = (GroupContent)paramDataProcessor.processDataTemplate(localGroupContent))
        {
          if ((localObject != null) && (localGroupContent != null)) {
            ((List)localObject).add(localGroupContent);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasSlotId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent", "slotId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasGroups) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent", "groups");
    }
    if (groups != null)
    {
      paramDataProcessor = groups.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((GroupContent)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent", "groups");
        }
      }
    }
    return new SlotContent(slotId, (List)localObject, hasSlotId, bool);
    label344:
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
      paramObject = (SlotContent)paramObject;
      if (slotId != null)
      {
        if (slotId.equals(slotId)) {}
      }
      else {
        while (slotId != null) {
          return false;
        }
      }
      if (groups == null) {
        break;
      }
    } while (groups.equals(groups));
    for (;;)
    {
      return false;
      if (groups == null) {
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
    if (hasSlotId) {
      i = PegasusBinaryUtils.getEncodedLength(slotId) + 8;
    }
    i += 1;
    int j = i;
    if (hasGroups)
    {
      i += 2;
      Iterator localIterator = groups.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        GroupContent localGroupContent = (GroupContent)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localGroupContent.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (slotId != null) {}
    for (int i = slotId.hashCode();; i = 0)
    {
      if (groups != null) {
        j = groups.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SlotContent");
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
    label283:
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
        localByteBuffer.putInt(-1783328230);
        Iterator localIterator;
        if (hasSlotId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, slotId);
          if (hasGroups)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, groups.size());
            localIterator = groups.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
            }
            GroupContent localGroupContent = (GroupContent)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localGroupContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localGroupContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */