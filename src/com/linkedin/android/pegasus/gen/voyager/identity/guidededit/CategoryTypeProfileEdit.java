package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CategoryTypeProfileEdit
  implements FissileDataModel<CategoryTypeProfileEdit>, RecordTemplate<CategoryTypeProfileEdit>
{
  public static final CategoryTypeProfileEditBuilder BUILDER = CategoryTypeProfileEditBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasOneClick;
  public final boolean hasProfileCategory;
  public final boolean hasUpdateCategory;
  public final boolean hasUpdateEntityUrn;
  public final boolean oneClick;
  public final ProfileCategories profileCategory;
  public final boolean updateCategory;
  public final Urn updateEntityUrn;
  
  CategoryTypeProfileEdit(ProfileCategories paramProfileCategories, boolean paramBoolean1, Urn paramUrn, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    profileCategory = paramProfileCategories;
    updateCategory = paramBoolean1;
    updateEntityUrn = paramUrn;
    oneClick = paramBoolean2;
    hasProfileCategory = paramBoolean3;
    hasUpdateCategory = paramBoolean4;
    hasUpdateEntityUrn = paramBoolean5;
    hasOneClick = paramBoolean6;
    _cachedId = null;
  }
  
  public final CategoryTypeProfileEdit accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasProfileCategory)
    {
      paramDataProcessor.startRecordField$505cff1c("profileCategory");
      paramDataProcessor.processEnum(profileCategory);
    }
    if (hasUpdateCategory)
    {
      paramDataProcessor.startRecordField$505cff1c("updateCategory");
      paramDataProcessor.processBoolean(updateCategory);
    }
    if (hasUpdateEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("updateEntityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(updateEntityUrn));
    }
    if (hasOneClick)
    {
      paramDataProcessor.startRecordField$505cff1c("oneClick");
      paramDataProcessor.processBoolean(oneClick);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasProfileCategory) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit", "profileCategory");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasUpdateCategory) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit", "updateCategory");
      }
      return new CategoryTypeProfileEdit(profileCategory, updateCategory, updateEntityUrn, oneClick, hasProfileCategory, hasUpdateCategory, hasUpdateEntityUrn, hasOneClick);
    }
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
      paramObject = (CategoryTypeProfileEdit)paramObject;
      if (profileCategory != null)
      {
        if (profileCategory.equals(profileCategory)) {}
      }
      else {
        while (profileCategory != null) {
          return false;
        }
      }
      if (updateCategory != updateCategory) {
        return false;
      }
      if (updateEntityUrn != null)
      {
        if (updateEntityUrn.equals(updateEntityUrn)) {}
      }
      else {
        while (updateEntityUrn != null) {
          return false;
        }
      }
    } while (oneClick == oneClick);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasProfileCategory) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasUpdateCategory) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasUpdateEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(updateEntityUrn));
    }
    j = i + 1;
    i = j;
    if (hasOneClick) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label39:
    int k;
    if (profileCategory != null)
    {
      i = profileCategory.hashCode();
      if (!updateCategory) {
        break label95;
      }
      j = 1;
      if (updateEntityUrn == null) {
        break label100;
      }
      k = updateEntityUrn.hashCode();
      label54:
      if (!oneClick) {
        break label105;
      }
    }
    for (;;)
    {
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label95:
      j = 0;
      break label39;
      label100:
      k = 0;
      break label54;
      label105:
      m = 0;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    int j = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CategoryTypeProfileEdit");
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
    label166:
    label175:
    label209:
    label234:
    label286:
    label292:
    label302:
    label312:
    label318:
    label326:
    label328:
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
        localByteBuffer.putInt(310554764);
        if (hasProfileCategory)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, profileCategory.ordinal());
          if (!hasUpdateCategory) {
            break label292;
          }
          localByteBuffer.put((byte)1);
          if (!updateCategory) {
            break label286;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasUpdateEntityUrn) {
            break label302;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(updateEntityUrn));
          if (!hasOneClick) {
            break label318;
          }
          localByteBuffer.put((byte)1);
          if (!oneClick) {
            break label312;
          }
          i = j;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label326;
          }
          if (str != null) {
            break label328;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label166;
          localByteBuffer.put((byte)0);
          break label175;
          localByteBuffer.put((byte)0);
          break label209;
          i = 0;
          break label234;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */