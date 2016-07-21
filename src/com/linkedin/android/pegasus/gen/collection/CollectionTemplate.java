package com.linkedin.android.pegasus.gen.collection;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CollectionTemplate<E extends FissileDataModel<E>, M extends FissileDataModel<M>>
  implements FissileDataModel<CollectionTemplate<E, M>>, RecordTemplate<CollectionTemplate<E, M>>
{
  protected static final JsonKeyStore JSON_KEY_STORE;
  public final String __model_id;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final List<E> elements;
  public final boolean hasElements;
  public final boolean hasMetadata;
  public final boolean hasPaging;
  public final String id;
  public final M metadata;
  public final com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata paging;
  public final String type;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("elements");
    JSON_KEY_STORE.put("paging");
    JSON_KEY_STORE.put("metadata");
  }
  
  public CollectionTemplate(List<E> paramList, M paramM, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata paramCollectionMetadata, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList;
    if (paramList == null)
    {
      localList = null;
      elements = localList;
      metadata = paramM;
      paging = paramCollectionMetadata;
      if ((!paramBoolean1) || (paramList == null)) {
        break label157;
      }
      paramBoolean1 = true;
      label52:
      hasElements = paramBoolean1;
      if ((!paramBoolean2) || (paramM == null)) {
        break label163;
      }
      paramBoolean1 = true;
      label70:
      hasMetadata = paramBoolean1;
      if ((!paramBoolean3) || (paramCollectionMetadata == null)) {
        break label169;
      }
    }
    label157:
    label163:
    label169:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      hasPaging = paramBoolean1;
      id = paramString2;
      type = paramString1;
      paramList = (List<E>)localObject;
      if (paramString1 != null)
      {
        paramList = (List<E>)localObject;
        if (paramString2 != null) {
          paramList = MessageFormat.format("{0}:{1}", new Object[] { paramString1, paramString2 });
        }
      }
      __model_id = paramList;
      return;
      localList = Collections.unmodifiableList(paramList);
      break;
      paramBoolean1 = false;
      break label52;
      paramBoolean1 = false;
      break label70;
    }
  }
  
  public static <E extends FissileDataModel<E>, EMB extends FissileDataModelBuilder<E>> CollectionTemplateJsonParser<E, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> of(EMB paramEMB)
  {
    return new CollectionTemplateJsonParser(paramEMB, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata.BUILDER);
  }
  
  public static <E extends FissileDataModel<E>> CollectionTemplate<E, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> of(CollectionTemplate<E, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate)
  {
    return new CollectionTemplate(elements, metadata, paging, type, id, hasElements, hasMetadata, hasPaging);
  }
  
  public final CollectionTemplate<E, M> copyWithNewElements(List<E> paramList)
  {
    FissileDataModel localFissileDataModel = metadata;
    com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata localCollectionMetadata = paging;
    String str1 = type;
    String str2 = id;
    if (paramList != null) {}
    for (boolean bool = true;; bool = false) {
      return new CollectionTemplate(paramList, localFissileDataModel, localCollectionMetadata, str1, str2, bool, hasMetadata, hasPaging);
    }
  }
  
  public final CollectionTemplate<E, M> copyWithNewElementsMetadataAndPaging(List<E> paramList, M paramM, com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata paramCollectionMetadata)
  {
    boolean bool2 = false;
    String str1 = type;
    String str2 = id;
    if (paramM != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramCollectionMetadata != null) {
        bool2 = true;
      }
      return new CollectionTemplate(paramList, paramM, paramCollectionMetadata, str1, str2, true, bool1, bool2);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!paramObject.getClass().equals(getClass()))) {
        return false;
      }
      paramObject = (CollectionTemplate)paramObject;
      if (type == null)
      {
        if (type == null) {}
      }
      else {
        while (!type.equals(type)) {
          return false;
        }
      }
      if (id == null)
      {
        if (id == null) {}
      }
      else {
        while (!id.equals(id)) {
          return false;
        }
      }
      if (elements == null)
      {
        if (elements == null) {}
      }
      else {
        while (!elements.equals(elements)) {
          return false;
        }
      }
      if (metadata == null)
      {
        if (metadata == null) {}
      }
      else {
        while (!metadata.equals(metadata)) {
          return false;
        }
      }
      if (paging != null) {
        break;
      }
    } while (paging == null);
    while (!paging.equals(paging)) {
      return false;
    }
    return true;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i;
    if (hasElements)
    {
      i = 5 + 1 + 2;
      Iterator localIterator = elements.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        FissileDataModel localFissileDataModel = (FissileDataModel)localIterator.next();
        if (localFissileDataModel != null) {
          if (localFissileDataModel.id() != null) {
            i = i + 1 + (PegasusBinaryUtils.getEncodedLength(localFissileDataModel.id()) + 2);
          } else {
            i = i + 1 + localFissileDataModel.getSerializedSize();
          }
        }
      }
    }
    int j = 5 + 1;
    if (hasMetadata)
    {
      i = j + 1;
      if (metadata.id() != null)
      {
        i = i + 1 + (PegasusBinaryUtils.getEncodedLength(metadata.id()) + 2);
        if (!hasPaging) {
          break label279;
        }
        i += 1;
        if (paging._cachedId == null) {
          break label264;
        }
        i = i + 1 + (PegasusBinaryUtils.getEncodedLength(paging._cachedId) + 2);
        label191:
        if (type == null) {
          break label286;
        }
        i = i + 1 + (PegasusBinaryUtils.getEncodedLength(type) + 2);
        label212:
        if (id == null) {
          break label293;
        }
        i = i + 1 + (PegasusBinaryUtils.getEncodedLength(id) + 2);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = i + 1 + metadata.getSerializedSize();
      break;
      i = j + 1;
      break;
      label264:
      i = i + 1 + paging.getSerializedSize();
      break label191;
      label279:
      i += 1;
      break label191;
      label286:
      i += 1;
      break label212;
      label293:
      i += 1;
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label33:
    int k;
    label42:
    int m;
    if (type == null)
    {
      i = 0;
      if (id != null) {
        break label105;
      }
      j = 0;
      if (elements != null) {
        break label116;
      }
      k = 0;
      if (metadata != null) {
        break label129;
      }
      m = 0;
      label52:
      if (paging != null) {
        break label141;
      }
    }
    for (;;)
    {
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = type.hashCode();
      break;
      label105:
      j = id.hashCode();
      break label33;
      label116:
      k = elements.hashCode();
      break label42;
      label129:
      m = metadata.hashCode();
      break label52;
      label141:
      n = paging.hashCode();
    }
  }
  
  public final String id()
  {
    return __model_id;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((__model_id == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without ID/CacheKey/ByteBuffer to fission");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (__model_id != null) {
        paramFissionAdapter.writeToCache(__model_id, null, 0, paramFissionTransaction);
      }
    }
    label376:
    label402:
    label500:
    label525:
    label535:
    label545:
    label553:
    label555:
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
        localByteBuffer.putInt(0);
        if (hasElements)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, elements.size());
          Iterator localIterator = elements.iterator();
          while (localIterator.hasNext())
          {
            FissileDataModel localFissileDataModel = (FissileDataModel)localIterator.next();
            if (localFissileDataModel != null) {
              if (localFissileDataModel.id() != null)
              {
                localByteBuffer.put((byte)0);
                paramFissionAdapter.writeString(localByteBuffer, localFissileDataModel.id());
                localFissileDataModel.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              }
              else
              {
                localByteBuffer.put((byte)1);
                localFissileDataModel.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
              }
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasMetadata)
        {
          localByteBuffer.put((byte)1);
          if (metadata.id() != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, metadata.id());
            metadata.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPaging) {
              break label525;
            }
            localByteBuffer.put((byte)1);
            if (paging._cachedId == null) {
              break label500;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, paging._cachedId);
            paging.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (type == null) {
              break label535;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, type);
            if (id == null) {
              break label545;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, id);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label553;
          }
          if (__model_id != null) {
            break label555;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          metadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          paging.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label376;
          localByteBuffer.put((byte)0);
          break label376;
          localByteBuffer.put((byte)0);
          break label402;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(__model_id, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (__model_id.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(__model_id) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, __model_id);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class CollectionTemplateJsonParser<E extends FissileDataModel<E>, M extends FissileDataModel<M>>
    implements FissileDataModelBuilder<CollectionTemplate<E, M>>, DataTemplateBuilder<CollectionTemplate<E, M>>
  {
    private final FissileDataModelBuilder<E> elementModelBuilder;
    private final FissileDataModelBuilder<M> metadataModelBuilder;
    
    public CollectionTemplateJsonParser(FissileDataModelBuilder<E> paramFissileDataModelBuilder, FissileDataModelBuilder<M> paramFissileDataModelBuilder1)
    {
      elementModelBuilder = paramFissileDataModelBuilder;
      metadataModelBuilder = paramFissileDataModelBuilder1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.collection.CollectionTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */