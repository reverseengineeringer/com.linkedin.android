package com.linkedin.android.pegasus.gen.voyager.premium.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfinderMiniRequestForProposals
  implements FissileDataModel<ProfinderMiniRequestForProposals>, RecordTemplate<ProfinderMiniRequestForProposals>
{
  public static final ProfinderMiniRequestForProposalsBuilder BUILDER = ProfinderMiniRequestForProposalsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasServiceCategoryName;
  public final boolean hasTotalNonActionedProposalCount;
  public final String serviceCategoryName;
  public final int totalNonActionedProposalCount;
  
  ProfinderMiniRequestForProposals(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    serviceCategoryName = paramString;
    totalNonActionedProposalCount = paramInt;
    hasServiceCategoryName = paramBoolean1;
    hasTotalNonActionedProposalCount = paramBoolean2;
    _cachedId = null;
  }
  
  public final ProfinderMiniRequestForProposals accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasServiceCategoryName)
    {
      paramDataProcessor.startRecordField$505cff1c("serviceCategoryName");
      paramDataProcessor.processString(serviceCategoryName);
    }
    if (hasTotalNonActionedProposalCount)
    {
      paramDataProcessor.startRecordField$505cff1c("totalNonActionedProposalCount");
      paramDataProcessor.processInt(totalNonActionedProposalCount);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasServiceCategoryName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals", "serviceCategoryName");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasTotalNonActionedProposalCount) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals", "totalNonActionedProposalCount");
      }
      return new ProfinderMiniRequestForProposals(serviceCategoryName, totalNonActionedProposalCount, hasServiceCategoryName, hasTotalNonActionedProposalCount);
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
      paramObject = (ProfinderMiniRequestForProposals)paramObject;
      if (serviceCategoryName != null)
      {
        if (serviceCategoryName.equals(serviceCategoryName)) {}
      }
      else {
        while (serviceCategoryName != null) {
          return false;
        }
      }
    } while (totalNonActionedProposalCount == totalNonActionedProposalCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasServiceCategoryName) {
      i = PegasusBinaryUtils.getEncodedLength(serviceCategoryName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTotalNonActionedProposalCount) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (serviceCategoryName != null) {}
    for (int i = serviceCategoryName.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + totalNonActionedProposalCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfinderMiniRequestForProposals");
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
    label203:
    label211:
    label213:
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
        localByteBuffer.putInt(-992310964);
        if (hasServiceCategoryName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, serviceCategoryName);
          if (!hasTotalNonActionedProposalCount) {
            break label203;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalNonActionedProposalCount);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label211;
          }
          if (str != null) {
            break label213;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */