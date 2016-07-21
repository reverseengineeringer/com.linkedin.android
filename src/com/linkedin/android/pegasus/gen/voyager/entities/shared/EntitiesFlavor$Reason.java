package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EntitiesFlavor$Reason
  implements FissileDataModel<Reason>, UnionTemplate<Reason>
{
  public static final EntitiesFlavorBuilder.ReasonBuilder BUILDER = EntitiesFlavorBuilder.ReasonBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final CompanyRecruitReason companyRecruitReasonValue;
  public final boolean hasCompanyRecruitReasonValue;
  public final boolean hasInNetworkReasonValue;
  public final boolean hasSchoolRecruitReasonValue;
  public final InNetworkReason inNetworkReasonValue;
  public final SchoolRecruitReason schoolRecruitReasonValue;
  
  EntitiesFlavor$Reason(InNetworkReason paramInNetworkReason, CompanyRecruitReason paramCompanyRecruitReason, SchoolRecruitReason paramSchoolRecruitReason, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    inNetworkReasonValue = paramInNetworkReason;
    companyRecruitReasonValue = paramCompanyRecruitReason;
    schoolRecruitReasonValue = paramSchoolRecruitReason;
    hasInNetworkReasonValue = paramBoolean1;
    hasCompanyRecruitReasonValue = paramBoolean2;
    hasSchoolRecruitReasonValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Reason accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasInNetworkReasonValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.InNetworkReason");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = inNetworkReasonValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label205;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasCompanyRecruitReasonValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.CompanyRecruitReason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = companyRecruitReasonValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label232;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasSchoolRecruitReasonValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.SchoolRecruitReason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = schoolRecruitReasonValue.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label259;
        }
      }
    }
    label205:
    label214:
    label232:
    label241:
    label259:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label265;
      }
      return new Reason((InNetworkReason)localObject2, (CompanyRecruitReason)localObject3, (SchoolRecruitReason)localObject1, bool1, bool2, bool3);
      localObject1 = (InNetworkReason)paramDataProcessor.processDataTemplate(inNetworkReasonValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (CompanyRecruitReason)paramDataProcessor.processDataTemplate(companyRecruitReasonValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SchoolRecruitReason)paramDataProcessor.processDataTemplate(schoolRecruitReasonValue);
      break label146;
    }
    label265:
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
      paramObject = (Reason)paramObject;
      if (inNetworkReasonValue != null)
      {
        if (inNetworkReasonValue.equals(inNetworkReasonValue)) {}
      }
      else {
        while (inNetworkReasonValue != null) {
          return false;
        }
      }
      if (companyRecruitReasonValue != null)
      {
        if (companyRecruitReasonValue.equals(companyRecruitReasonValue)) {}
      }
      else {
        while (companyRecruitReasonValue != null) {
          return false;
        }
      }
      if (schoolRecruitReasonValue == null) {
        break;
      }
    } while (schoolRecruitReasonValue.equals(schoolRecruitReasonValue));
    for (;;)
    {
      return false;
      if (schoolRecruitReasonValue == null) {
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
    if (hasInNetworkReasonValue)
    {
      if (inNetworkReasonValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(inNetworkReasonValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasCompanyRecruitReasonValue)
      {
        i = j + 1;
        if (companyRecruitReasonValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(companyRecruitReasonValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSchoolRecruitReasonValue)
      {
        i = j + 1;
        if (schoolRecruitReasonValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolRecruitReasonValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = inNetworkReasonValue.getSerializedSize() + 7;
      break;
      label156:
      i += companyRecruitReasonValue.getSerializedSize();
      break label93;
      label169:
      i += schoolRecruitReasonValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (inNetworkReasonValue != null)
    {
      i = inNetworkReasonValue.hashCode();
      if (companyRecruitReasonValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = companyRecruitReasonValue.hashCode();; j = 0)
    {
      if (schoolRecruitReasonValue != null) {
        k = schoolRecruitReasonValue.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Reason");
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
    label230:
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(-1658429585);
        if (hasInNetworkReasonValue)
        {
          localByteBuffer.put((byte)1);
          if (inNetworkReasonValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inNetworkReasonValue._cachedId);
            inNetworkReasonValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCompanyRecruitReasonValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (companyRecruitReasonValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, companyRecruitReasonValue._cachedId);
            companyRecruitReasonValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSchoolRecruitReasonValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (schoolRecruitReasonValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, schoolRecruitReasonValue._cachedId);
            schoolRecruitReasonValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          inNetworkReasonValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          companyRecruitReasonValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          schoolRecruitReasonValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor.Reason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */