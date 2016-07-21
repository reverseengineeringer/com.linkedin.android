package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuidedEditCategory$CategoryType
  implements FissileDataModel<CategoryType>, UnionTemplate<CategoryType>
{
  public static final GuidedEditCategoryBuilder.CategoryTypeBuilder BUILDER = GuidedEditCategoryBuilder.CategoryTypeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final CategoryTypeCustom categoryTypeCustomValue;
  public final CategoryTypeProfileEdit categoryTypeProfileEditValue;
  public final boolean hasCategoryTypeCustomValue;
  public final boolean hasCategoryTypeProfileEditValue;
  
  GuidedEditCategory$CategoryType(CategoryTypeProfileEdit paramCategoryTypeProfileEdit, CategoryTypeCustom paramCategoryTypeCustom, boolean paramBoolean1, boolean paramBoolean2)
  {
    categoryTypeProfileEditValue = paramCategoryTypeProfileEdit;
    categoryTypeCustomValue = paramCategoryTypeCustom;
    hasCategoryTypeProfileEditValue = paramBoolean1;
    hasCategoryTypeCustomValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final CategoryType accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasCategoryTypeProfileEditValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.guidededit.CategoryTypeProfileEdit");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = categoryTypeProfileEditValue.accept(paramDataProcessor);
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
      if (hasCategoryTypeCustomValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.guidededit.CategoryTypeCustom");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = categoryTypeCustomValue.accept(paramDataProcessor);
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
      return new CategoryType((CategoryTypeProfileEdit)localObject2, (CategoryTypeCustom)localObject1, bool1, bool2);
      localObject1 = (CategoryTypeProfileEdit)paramDataProcessor.processDataTemplate(categoryTypeProfileEditValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (CategoryTypeCustom)paramDataProcessor.processDataTemplate(categoryTypeCustomValue);
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
      paramObject = (CategoryType)paramObject;
      if (categoryTypeProfileEditValue != null)
      {
        if (categoryTypeProfileEditValue.equals(categoryTypeProfileEditValue)) {}
      }
      else {
        while (categoryTypeProfileEditValue != null) {
          return false;
        }
      }
      if (categoryTypeCustomValue == null) {
        break;
      }
    } while (categoryTypeCustomValue.equals(categoryTypeCustomValue));
    for (;;)
    {
      return false;
      if (categoryTypeCustomValue == null) {
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
    if (hasCategoryTypeProfileEditValue)
    {
      if (categoryTypeProfileEditValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(categoryTypeProfileEditValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasCategoryTypeCustomValue)
      {
        i = j + 1;
        if (categoryTypeCustomValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(categoryTypeCustomValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = categoryTypeProfileEditValue.getSerializedSize() + 7;
      break;
      label114:
      i += categoryTypeCustomValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (categoryTypeProfileEditValue != null) {}
    for (int i = categoryTypeProfileEditValue.hashCode();; i = 0)
    {
      if (categoryTypeCustomValue != null) {
        j = categoryTypeCustomValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CategoryType");
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
        localByteBuffer.putInt(219265078);
        if (hasCategoryTypeProfileEditValue)
        {
          localByteBuffer.put((byte)1);
          if (categoryTypeProfileEditValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, categoryTypeProfileEditValue._cachedId);
            categoryTypeProfileEditValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCategoryTypeCustomValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (categoryTypeCustomValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, categoryTypeCustomValue._cachedId);
            categoryTypeCustomValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          categoryTypeProfileEditValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          categoryTypeCustomValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory.CategoryType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */