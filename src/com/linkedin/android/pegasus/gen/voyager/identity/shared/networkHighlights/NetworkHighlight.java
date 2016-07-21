package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NetworkHighlight
  implements FissileDataModel<NetworkHighlight>, RecordTemplate<NetworkHighlight>
{
  public static final NetworkHighlightBuilder BUILDER = NetworkHighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Detail detail;
  public final boolean hasDetail;
  public final boolean hasReason;
  public final NetworkHighlightReason reason;
  
  NetworkHighlight(Detail paramDetail, NetworkHighlightReason paramNetworkHighlightReason, boolean paramBoolean1, boolean paramBoolean2)
  {
    detail = paramDetail;
    reason = paramNetworkHighlightReason;
    hasDetail = paramBoolean1;
    hasReason = paramBoolean2;
    _cachedId = null;
  }
  
  public final NetworkHighlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Detail localDetail = null;
    boolean bool = false;
    if (hasDetail)
    {
      paramDataProcessor.startRecordField$505cff1c("detail");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localDetail = detail.accept(paramDataProcessor);
      if (localDetail == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasReason)
      {
        paramDataProcessor.startRecordField$505cff1c("reason");
        paramDataProcessor.processEnum(reason);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasDetail) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight", "detail");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localDetail = (Detail)paramDataProcessor.processDataTemplate(detail);
      break;
    }
    label140:
    return new NetworkHighlight(localDetail, reason, bool, hasReason);
    label158:
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
      paramObject = (NetworkHighlight)paramObject;
      if (detail != null)
      {
        if (detail.equals(detail)) {}
      }
      else {
        while (detail != null) {
          return false;
        }
      }
      if (reason == null) {
        break;
      }
    } while (reason.equals(reason));
    for (;;)
    {
      return false;
      if (reason == null) {
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
    if (hasDetail) {
      if (detail._cachedId == null) {
        break label75;
      }
    }
    label75:
    for (i = PegasusBinaryUtils.getEncodedLength(detail._cachedId) + 9;; i = detail.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasReason) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (detail != null) {}
    for (int i = detail.hashCode();; i = 0)
    {
      if (reason != null) {
        j = reason.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NetworkHighlight");
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
    label267:
    label275:
    label277:
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
        localByteBuffer.putInt(800897265);
        if (hasDetail)
        {
          localByteBuffer.put((byte)1);
          if (detail._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, detail._cachedId);
            detail.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasReason) {
              break label267;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, reason.ordinal());
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label275;
          }
          if (str != null) {
            break label277;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          detail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
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
  
  public static final class Detail
    implements FissileDataModel<Detail>, UnionTemplate<Detail>
  {
    public static final NetworkHighlightBuilder.DetailBuilder BUILDER = NetworkHighlightBuilder.DetailBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final DescriptiveCompany descriptiveCompanyValue;
    public final DescriptiveRegion descriptiveRegionValue;
    public final DescriptiveSchool descriptiveSchoolValue;
    public final DescriptiveSeniorCompany descriptiveSeniorCompanyValue;
    public final boolean hasDescriptiveCompanyValue;
    public final boolean hasDescriptiveRegionValue;
    public final boolean hasDescriptiveSchoolValue;
    public final boolean hasDescriptiveSeniorCompanyValue;
    
    Detail(DescriptiveCompany paramDescriptiveCompany, DescriptiveSchool paramDescriptiveSchool, DescriptiveRegion paramDescriptiveRegion, DescriptiveSeniorCompany paramDescriptiveSeniorCompany, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      descriptiveCompanyValue = paramDescriptiveCompany;
      descriptiveSchoolValue = paramDescriptiveSchool;
      descriptiveRegionValue = paramDescriptiveRegion;
      descriptiveSeniorCompanyValue = paramDescriptiveSeniorCompany;
      hasDescriptiveCompanyValue = paramBoolean1;
      hasDescriptiveSchoolValue = paramBoolean2;
      hasDescriptiveRegionValue = paramBoolean3;
      hasDescriptiveSeniorCompanyValue = paramBoolean4;
      _cachedId = null;
    }
    
    public final Detail accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      if (hasDescriptiveCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveCompany");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = descriptiveCompanyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label261;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasDescriptiveSchoolValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveSchool");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label270;
          }
          localObject1 = descriptiveSchoolValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label288;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasDescriptiveRegionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveRegion");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label297;
          }
          localObject1 = descriptiveRegionValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label315;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        label158:
        localObject1 = null;
        bool4 = false;
        if (hasDescriptiveSeniorCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveSeniorCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label325;
          }
          localObject1 = descriptiveSeniorCompanyValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label343;
          }
        }
      }
      label261:
      label270:
      label288:
      label297:
      label315:
      label325:
      label343:
      for (boolean bool4 = true;; bool4 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label349;
        }
        return new Detail((DescriptiveCompany)localObject2, (DescriptiveSchool)localObject3, (DescriptiveRegion)localObject4, (DescriptiveSeniorCompany)localObject1, bool1, bool2, bool3, bool4);
        localObject1 = (DescriptiveCompany)paramDataProcessor.processDataTemplate(descriptiveCompanyValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (DescriptiveSchool)paramDataProcessor.processDataTemplate(descriptiveSchoolValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (DescriptiveRegion)paramDataProcessor.processDataTemplate(descriptiveRegionValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (DescriptiveSeniorCompany)paramDataProcessor.processDataTemplate(descriptiveSeniorCompanyValue);
        break label198;
      }
      label349:
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
        paramObject = (Detail)paramObject;
        if (descriptiveCompanyValue != null)
        {
          if (descriptiveCompanyValue.equals(descriptiveCompanyValue)) {}
        }
        else {
          while (descriptiveCompanyValue != null) {
            return false;
          }
        }
        if (descriptiveSchoolValue != null)
        {
          if (descriptiveSchoolValue.equals(descriptiveSchoolValue)) {}
        }
        else {
          while (descriptiveSchoolValue != null) {
            return false;
          }
        }
        if (descriptiveRegionValue != null)
        {
          if (descriptiveRegionValue.equals(descriptiveRegionValue)) {}
        }
        else {
          while (descriptiveRegionValue != null) {
            return false;
          }
        }
        if (descriptiveSeniorCompanyValue == null) {
          break;
        }
      } while (descriptiveSeniorCompanyValue.equals(descriptiveSeniorCompanyValue));
      for (;;)
      {
        return false;
        if (descriptiveSeniorCompanyValue == null) {
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
      if (hasDescriptiveCompanyValue)
      {
        if (descriptiveCompanyValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(descriptiveCompanyValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasDescriptiveSchoolValue)
        {
          i = j + 1;
          if (descriptiveSchoolValue._cachedId == null) {
            break label198;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptiveSchoolValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasDescriptiveRegionValue)
        {
          i = j + 1;
          if (descriptiveRegionValue._cachedId == null) {
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptiveRegionValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasDescriptiveSeniorCompanyValue)
        {
          i = j + 1;
          if (descriptiveSeniorCompanyValue._cachedId == null) {
            break label224;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptiveSeniorCompanyValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = descriptiveCompanyValue.getSerializedSize() + 7;
        break;
        label198:
        i += descriptiveSchoolValue.getSerializedSize();
        break label93;
        label211:
        i += descriptiveRegionValue.getSerializedSize();
        break label135;
        label224:
        i += descriptiveSeniorCompanyValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int m = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      int j;
      if (descriptiveCompanyValue != null)
      {
        i = descriptiveCompanyValue.hashCode();
        if (descriptiveSchoolValue == null) {
          break label110;
        }
        j = descriptiveSchoolValue.hashCode();
        label45:
        if (descriptiveRegionValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = descriptiveRegionValue.hashCode();; k = 0)
      {
        if (descriptiveSeniorCompanyValue != null) {
          m = descriptiveSeniorCompanyValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
      label290:
      label418:
      label443:
      label453:
      label478:
      label488:
      label513:
      label521:
      label523:
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
          localByteBuffer.putInt(1727971851);
          if (hasDescriptiveCompanyValue)
          {
            localByteBuffer.put((byte)1);
            if (descriptiveCompanyValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, descriptiveCompanyValue._cachedId);
              descriptiveCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDescriptiveSchoolValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (descriptiveSchoolValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, descriptiveSchoolValue._cachedId);
              descriptiveSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDescriptiveRegionValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (descriptiveRegionValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, descriptiveRegionValue._cachedId);
              descriptiveRegionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDescriptiveSeniorCompanyValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (descriptiveSeniorCompanyValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, descriptiveSeniorCompanyValue._cachedId);
              descriptiveSeniorCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label521;
            }
            if (str != null) {
              break label523;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            descriptiveCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            descriptiveSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            descriptiveRegionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            descriptiveSeniorCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */