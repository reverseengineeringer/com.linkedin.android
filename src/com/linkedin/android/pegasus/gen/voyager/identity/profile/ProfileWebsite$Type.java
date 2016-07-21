package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileWebsite$Type
  implements FissileDataModel<Type>, UnionTemplate<Type>
{
  public static final ProfileWebsiteBuilder.TypeBuilder BUILDER = ProfileWebsiteBuilder.TypeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final CustomWebsite customWebsiteValue;
  public final boolean hasCustomWebsiteValue;
  public final boolean hasStandardWebsiteValue;
  public final StandardWebsite standardWebsiteValue;
  
  ProfileWebsite$Type(StandardWebsite paramStandardWebsite, CustomWebsite paramCustomWebsite, boolean paramBoolean1, boolean paramBoolean2)
  {
    standardWebsiteValue = paramStandardWebsite;
    customWebsiteValue = paramCustomWebsite;
    hasStandardWebsiteValue = paramBoolean1;
    hasCustomWebsiteValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Type accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasStandardWebsiteValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.StandardWebsite");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = standardWebsiteValue.accept(paramDataProcessor);
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
      if (hasCustomWebsiteValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.CustomWebsite");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = customWebsiteValue.accept(paramDataProcessor);
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
      return new Type((StandardWebsite)localObject2, (CustomWebsite)localObject1, bool1, bool2);
      localObject1 = (StandardWebsite)paramDataProcessor.processDataTemplate(standardWebsiteValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (CustomWebsite)paramDataProcessor.processDataTemplate(customWebsiteValue);
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
      paramObject = (Type)paramObject;
      if (standardWebsiteValue != null)
      {
        if (standardWebsiteValue.equals(standardWebsiteValue)) {}
      }
      else {
        while (standardWebsiteValue != null) {
          return false;
        }
      }
      if (customWebsiteValue == null) {
        break;
      }
    } while (customWebsiteValue.equals(customWebsiteValue));
    for (;;)
    {
      return false;
      if (customWebsiteValue == null) {
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
    if (hasStandardWebsiteValue)
    {
      if (standardWebsiteValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(standardWebsiteValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasCustomWebsiteValue)
      {
        i = j + 1;
        if (customWebsiteValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(customWebsiteValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = standardWebsiteValue.getSerializedSize() + 7;
      break;
      label114:
      i += customWebsiteValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (standardWebsiteValue != null) {}
    for (int i = standardWebsiteValue.hashCode();; i = 0)
    {
      if (customWebsiteValue != null) {
        j = customWebsiteValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Type");
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
        localByteBuffer.putInt(23844710);
        if (hasStandardWebsiteValue)
        {
          localByteBuffer.put((byte)1);
          if (standardWebsiteValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, standardWebsiteValue._cachedId);
            standardWebsiteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCustomWebsiteValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (customWebsiteValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, customWebsiteValue._cachedId);
            customWebsiteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          standardWebsiteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          customWebsiteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
  {
    private CustomWebsite customWebsiteValue = null;
    private boolean hasCustomWebsiteValue = false;
    private boolean hasStandardWebsiteValue = false;
    private StandardWebsite standardWebsiteValue = null;
    
    public final ProfileWebsite.Type build()
      throws BuilderException
    {
      int i = 0;
      if (hasStandardWebsiteValue) {
        i = 0 + 1;
      }
      int j = i;
      if (hasCustomWebsiteValue) {
        j = i + 1;
      }
      if (j > 1) {
        throw new UnionMemberCountException("Type", 2);
      }
      return new ProfileWebsite.Type(standardWebsiteValue, customWebsiteValue, hasStandardWebsiteValue, hasCustomWebsiteValue);
    }
    
    public final Builder setCustomWebsiteValue(CustomWebsite paramCustomWebsite)
    {
      if (paramCustomWebsite == null)
      {
        hasCustomWebsiteValue = false;
        customWebsiteValue = null;
        return this;
      }
      hasCustomWebsiteValue = true;
      customWebsiteValue = paramCustomWebsite;
      return this;
    }
    
    public final Builder setStandardWebsiteValue(StandardWebsite paramStandardWebsite)
    {
      if (paramStandardWebsite == null)
      {
        hasStandardWebsiteValue = false;
        standardWebsiteValue = null;
        return this;
      }
      hasStandardWebsiteValue = true;
      standardWebsiteValue = paramStandardWebsite;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite.Type
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */