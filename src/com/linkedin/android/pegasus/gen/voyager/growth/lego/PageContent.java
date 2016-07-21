package com.linkedin.android.pegasus.gen.voyager.growth.lego;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullMapValueException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class PageContent
  implements FissileDataModel<PageContent>, RecordTemplate<PageContent>
{
  public static final PageContentBuilder BUILDER = PageContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasSlots;
  public final Map<String, SlotContent> slots;
  
  PageContent(Urn paramUrn, Map<String, SlotContent> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    entityUrn = paramUrn;
    if (paramMap == null) {}
    for (paramMap = null;; paramMap = Collections.unmodifiableMap(paramMap))
    {
      slots = paramMap;
      hasEntityUrn = paramBoolean1;
      hasSlots = paramBoolean2;
      paramMap = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
    }
  }
  
  private PageContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    SlotContent localSlotContent = null;
    boolean bool = false;
    if (hasSlots)
    {
      paramDataProcessor.startRecordField$505cff1c("slots");
      slots.size();
      paramDataProcessor.startMap$13462e();
      localObject = localSlotContent;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new HashMap();
      }
      int i = 0;
      Iterator localIterator = slots.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramDataProcessor.processMapKey((String)localEntry.getKey(), i);
        localSlotContent = (SlotContent)localEntry.getValue();
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSlotContent = localSlotContent.accept(paramDataProcessor);; localSlotContent = (SlotContent)paramDataProcessor.processDataTemplate(localSlotContent))
        {
          if ((localObject != null) && (localSlotContent != null)) {
            ((Map)localObject).put(localEntry.getKey(), localSlotContent);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endMap();
      if (localObject == null) {
        break label293;
      }
    }
    label293:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label391;
      }
      try
      {
        if (hasEntityUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSlots) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent", "slots");
    }
    if (slots != null)
    {
      paramDataProcessor = slots.values().iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SlotContent)paramDataProcessor.next() == null) {
          throw new NullMapValueException("com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent", "slots");
        }
      }
    }
    return new PageContent(entityUrn, (Map)localObject, hasEntityUrn, bool);
    label391:
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
      paramObject = (PageContent)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (slots == null) {
        break;
      }
    } while (slots.equals(slots));
    for (;;)
    {
      return false;
      if (slots == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    i += 1;
    int j = i;
    if (hasSlots)
    {
      i += 2;
      localObject1 = slots.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject2).getKey());
        localObject2 = (SlotContent)((Map.Entry)localObject2).getValue();
        i = i + 2 + j + 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((SlotContent)localObject2).getSerializedSize();
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
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      if (slots != null) {
        j = slots.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PageContent");
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
    label326:
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
        localByteBuffer.putInt(998427785);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (hasSlots)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, slots.size());
            localObject1 = slots.entrySet().iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label326;
            }
            Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
            paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject2).getKey());
            localObject2 = (SlotContent)((Map.Entry)localObject2).getValue();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((SlotContent)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            ((SlotContent)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */