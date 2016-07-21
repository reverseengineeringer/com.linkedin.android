package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GuidedEditCategory
  implements FissileDataModel<GuidedEditCategory>, RecordTemplate<GuidedEditCategory>
{
  public static final GuidedEditCategoryBuilder BUILDER = GuidedEditCategoryBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final CategoryType categoryType;
  public final String flowTrackingId;
  public final boolean hasCategoryType;
  public final boolean hasFlowTrackingId;
  public final boolean hasId;
  public final boolean hasTasks;
  public final CategoryNames id;
  public final List<GuidedEditTask> tasks;
  
  GuidedEditCategory(CategoryNames paramCategoryNames, CategoryType paramCategoryType, List<GuidedEditTask> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    id = paramCategoryNames;
    categoryType = paramCategoryType;
    if (paramList == null) {}
    for (paramCategoryNames = null;; paramCategoryNames = Collections.unmodifiableList(paramList))
    {
      tasks = paramCategoryNames;
      flowTrackingId = paramString;
      hasId = paramBoolean1;
      hasCategoryType = paramBoolean2;
      hasTasks = paramBoolean3;
      hasFlowTrackingId = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  private GuidedEditCategory accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processEnum(id);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    int i;
    if (hasCategoryType)
    {
      paramDataProcessor.startRecordField$505cff1c("categoryType");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = categoryType.accept(paramDataProcessor);
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
      localGuidedEditTask = null;
      bool2 = false;
      if (!hasTasks) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("tasks");
      tasks.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localGuidedEditTask;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = tasks.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localGuidedEditTask = (GuidedEditTask)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (GuidedEditTask localGuidedEditTask = localGuidedEditTask.accept(paramDataProcessor);; localGuidedEditTask = (GuidedEditTask)paramDataProcessor.processDataTemplate(localGuidedEditTask))
    {
      if ((localObject1 != null) && (localGuidedEditTask != null)) {
        ((List)localObject1).add(localGuidedEditTask);
      }
      i += 1;
      break label156;
      localObject1 = (CategoryType)paramDataProcessor.processDataTemplate(categoryType);
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
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        paramDataProcessor.processString(flowTrackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label480;
      }
      try
      {
        if (hasId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasCategoryType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory", "categoryType");
    }
    if (!hasTasks) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory", "tasks");
    }
    if (tasks != null)
    {
      paramDataProcessor = tasks.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((GuidedEditTask)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory", "tasks");
        }
      }
    }
    return new GuidedEditCategory(id, (CategoryType)localObject2, (List)localObject1, flowTrackingId, hasId, bool1, bool2, hasFlowTrackingId);
    label480:
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
      paramObject = (GuidedEditCategory)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (categoryType != null)
      {
        if (categoryType.equals(categoryType)) {}
      }
      else {
        while (categoryType != null) {
          return false;
        }
      }
      if (tasks != null)
      {
        if (tasks.equals(tasks)) {}
      }
      else {
        while (tasks != null) {
          return false;
        }
      }
      if (flowTrackingId == null) {
        break;
      }
    } while (flowTrackingId.equals(flowTrackingId));
    for (;;)
    {
      return false;
      if (flowTrackingId == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasId) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasCategoryType)
    {
      i = j + 1;
      if (categoryType._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(categoryType._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasTasks) {
        break label176;
      }
      i += 2;
      localIterator = tasks.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label176;
      }
      GuidedEditTask localGuidedEditTask = (GuidedEditTask)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += categoryType.getSerializedSize();
        break;
      }
      i += localGuidedEditTask.getSerializedSize();
    }
    label176:
    j += 1;
    i = j;
    if (hasFlowTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(flowTrackingId);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (id != null)
    {
      i = id.hashCode();
      if (categoryType == null) {
        break label112;
      }
      j = categoryType.hashCode();
      label45:
      if (tasks == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = tasks.hashCode();; k = 0)
    {
      if (flowTrackingId != null) {
        m = flowTrackingId.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GuidedEditCategory");
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
    label199:
    label316:
    label341:
    label374:
    label381:
    label450:
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
        localByteBuffer.putInt(1790734750);
        Iterator localIterator;
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, id.ordinal());
          if (!hasCategoryType) {
            break label341;
          }
          localByteBuffer.put((byte)1);
          if (categoryType._cachedId == null) {
            break label316;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, categoryType._cachedId);
          categoryType.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTasks) {
            break label374;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, tasks.size());
          localIterator = tasks.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label381;
          }
          GuidedEditTask localGuidedEditTask = (GuidedEditTask)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localGuidedEditTask.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            categoryType.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label199;
            localByteBuffer.put((byte)0);
            break label199;
          }
          localByteBuffer.put((byte)1);
          localGuidedEditTask.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasFlowTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, flowTrackingId);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label450;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
  
  public static final class CategoryType
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
    
    CategoryType(CategoryTypeProfileEdit paramCategoryTypeProfileEdit, CategoryTypeCustom paramCategoryTypeCustom, boolean paramBoolean1, boolean paramBoolean2)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */