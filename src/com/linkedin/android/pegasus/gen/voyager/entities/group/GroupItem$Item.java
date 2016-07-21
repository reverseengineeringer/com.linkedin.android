package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GroupItem$Item
  implements FissileDataModel<Item>, UnionTemplate<Item>
{
  public static final GroupItemBuilder.ItemBuilder BUILDER = GroupItemBuilder.ItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Description descriptionValue;
  public final boolean hasDescriptionValue;
  public final boolean hasNextGroupsCollectionValue;
  public final NextGroupsCollection nextGroupsCollectionValue;
  
  GroupItem$Item(NextGroupsCollection paramNextGroupsCollection, Description paramDescription, boolean paramBoolean1, boolean paramBoolean2)
  {
    nextGroupsCollectionValue = paramNextGroupsCollection;
    descriptionValue = paramDescription;
    hasNextGroupsCollectionValue = paramBoolean1;
    hasDescriptionValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Item accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasNextGroupsCollectionValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.group.NextGroupsCollection");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = nextGroupsCollectionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label149;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasDescriptionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.Description");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = descriptionValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new Item((NextGroupsCollection)localObject2, (Description)localObject1, bool1, bool2);
      localObject1 = (NextGroupsCollection)paramDataProcessor.processDataTemplate(nextGroupsCollectionValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Description)paramDataProcessor.processDataTemplate(descriptionValue);
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
      paramObject = (Item)paramObject;
      if (nextGroupsCollectionValue != null)
      {
        if (nextGroupsCollectionValue.equals(nextGroupsCollectionValue)) {}
      }
      else {
        while (nextGroupsCollectionValue != null) {
          return false;
        }
      }
      if (descriptionValue == null) {
        break;
      }
    } while (descriptionValue.equals(descriptionValue));
    for (;;)
    {
      return false;
      if (descriptionValue == null) {
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
    if (hasNextGroupsCollectionValue)
    {
      if (nextGroupsCollectionValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(nextGroupsCollectionValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasDescriptionValue)
      {
        i = j + 1;
        if (descriptionValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptionValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = nextGroupsCollectionValue.getSerializedSize() + 7;
      break;
      label114:
      i += descriptionValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (nextGroupsCollectionValue != null) {}
    for (int i = nextGroupsCollectionValue.hashCode();; i = 0)
    {
      if (descriptionValue != null) {
        j = descriptionValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Item");
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
        localByteBuffer.putInt(1673522347);
        if (hasNextGroupsCollectionValue)
        {
          localByteBuffer.put((byte)1);
          if (nextGroupsCollectionValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, nextGroupsCollectionValue._cachedId);
            nextGroupsCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDescriptionValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (descriptionValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, descriptionValue._cachedId);
            descriptionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          nextGroupsCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          descriptionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem.Item
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */