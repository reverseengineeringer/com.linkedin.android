package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

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
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AnalyticsHighlight
  implements FissileDataModel<AnalyticsHighlight>, RecordTemplate<AnalyticsHighlight>
{
  public static final AnalyticsHighlightBuilder BUILDER = AnalyticsHighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasObjectUrn;
  public final boolean hasTrackingId;
  public final boolean hasValue;
  public final Urn objectUrn;
  public final String trackingId;
  public final Value value;
  
  AnalyticsHighlight(Value paramValue, String paramString, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    value = paramValue;
    trackingId = paramString;
    objectUrn = paramUrn;
    hasValue = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasObjectUrn = paramBoolean3;
    _cachedId = null;
  }
  
  public final AnalyticsHighlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Value localValue = null;
    boolean bool = false;
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label151;
      }
      localValue = value.accept(paramDataProcessor);
      if (localValue == null) {
        break label168;
      }
    }
    label151:
    label168:
    for (bool = true;; bool = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      if (hasObjectUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("objectUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label237;
      }
      try
      {
        if (hasValue) {
          break label173;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localValue = (Value)paramDataProcessor.processDataTemplate(value);
      break;
    }
    label173:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight", "trackingId");
    }
    if (!hasObjectUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight", "objectUrn");
    }
    return new AnalyticsHighlight(localValue, trackingId, objectUrn, bool, hasTrackingId, hasObjectUrn);
    label237:
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
      paramObject = (AnalyticsHighlight)paramObject;
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
          return false;
        }
      }
      if (objectUrn == null) {
        break;
      }
    } while (objectUrn.equals(objectUrn));
    for (;;)
    {
      return false;
      if (objectUrn == null) {
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
    if (hasValue) {
      if (value._cachedId == null) {
        break label115;
      }
    }
    label115:
    for (i = PegasusBinaryUtils.getEncodedLength(value._cachedId) + 9;; i = value.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      j = i + 1;
      i = j;
      if (hasObjectUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
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
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      if (objectUrn != null) {
        j = objectUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AnalyticsHighlight");
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
    label196:
    label298:
    label308:
    label316:
    label318:
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
        localByteBuffer.putInt(979540423);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          if (value._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, value._cachedId);
            value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTrackingId) {
              break label298;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
            if (!hasObjectUrn) {
              break label308;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label316;
          }
          if (str != null) {
            break label318;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
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
  
  public static final class Value
    implements FissileDataModel<Value>, UnionTemplate<Value>
  {
    public static final AnalyticsHighlightBuilder.ValueBuilder BUILDER = AnalyticsHighlightBuilder.ValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CompanyHighlight companyHighlightValue;
    public final boolean hasCompanyHighlightValue;
    public final boolean hasOccupationHighlightValue;
    public final boolean hasRegionHighlightValue;
    public final boolean hasViewReferrerSourceHighlightValue;
    public final OccupationHighlight occupationHighlightValue;
    public final RegionHighlight regionHighlightValue;
    public final ViewReferrerSourceHighlight viewReferrerSourceHighlightValue;
    
    Value(CompanyHighlight paramCompanyHighlight, OccupationHighlight paramOccupationHighlight, RegionHighlight paramRegionHighlight, ViewReferrerSourceHighlight paramViewReferrerSourceHighlight, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      companyHighlightValue = paramCompanyHighlight;
      occupationHighlightValue = paramOccupationHighlight;
      regionHighlightValue = paramRegionHighlight;
      viewReferrerSourceHighlightValue = paramViewReferrerSourceHighlight;
      hasCompanyHighlightValue = paramBoolean1;
      hasOccupationHighlightValue = paramBoolean2;
      hasRegionHighlightValue = paramBoolean3;
      hasViewReferrerSourceHighlightValue = paramBoolean4;
      _cachedId = null;
    }
    
    public final Value accept(DataProcessor paramDataProcessor)
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
      if (hasCompanyHighlightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.CompanyHighlight");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = companyHighlightValue.accept(paramDataProcessor);
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
        if (hasOccupationHighlightValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label270;
          }
          localObject1 = occupationHighlightValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label288;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasRegionHighlightValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.RegionHighlight");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label297;
          }
          localObject1 = regionHighlightValue.accept(paramDataProcessor);
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
        if (hasViewReferrerSourceHighlightValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceHighlight");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label325;
          }
          localObject1 = viewReferrerSourceHighlightValue.accept(paramDataProcessor);
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
        return new Value((CompanyHighlight)localObject2, (OccupationHighlight)localObject3, (RegionHighlight)localObject4, (ViewReferrerSourceHighlight)localObject1, bool1, bool2, bool3, bool4);
        localObject1 = (CompanyHighlight)paramDataProcessor.processDataTemplate(companyHighlightValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (OccupationHighlight)paramDataProcessor.processDataTemplate(occupationHighlightValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (RegionHighlight)paramDataProcessor.processDataTemplate(regionHighlightValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (ViewReferrerSourceHighlight)paramDataProcessor.processDataTemplate(viewReferrerSourceHighlightValue);
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
        paramObject = (Value)paramObject;
        if (companyHighlightValue != null)
        {
          if (companyHighlightValue.equals(companyHighlightValue)) {}
        }
        else {
          while (companyHighlightValue != null) {
            return false;
          }
        }
        if (occupationHighlightValue != null)
        {
          if (occupationHighlightValue.equals(occupationHighlightValue)) {}
        }
        else {
          while (occupationHighlightValue != null) {
            return false;
          }
        }
        if (regionHighlightValue != null)
        {
          if (regionHighlightValue.equals(regionHighlightValue)) {}
        }
        else {
          while (regionHighlightValue != null) {
            return false;
          }
        }
        if (viewReferrerSourceHighlightValue == null) {
          break;
        }
      } while (viewReferrerSourceHighlightValue.equals(viewReferrerSourceHighlightValue));
      for (;;)
      {
        return false;
        if (viewReferrerSourceHighlightValue == null) {
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
      if (hasCompanyHighlightValue)
      {
        if (companyHighlightValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(companyHighlightValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasOccupationHighlightValue)
        {
          i = j + 1;
          if (occupationHighlightValue._cachedId == null) {
            break label198;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(occupationHighlightValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasRegionHighlightValue)
        {
          i = j + 1;
          if (regionHighlightValue._cachedId == null) {
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(regionHighlightValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasViewReferrerSourceHighlightValue)
        {
          i = j + 1;
          if (viewReferrerSourceHighlightValue._cachedId == null) {
            break label224;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(viewReferrerSourceHighlightValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = companyHighlightValue.getSerializedSize() + 7;
        break;
        label198:
        i += occupationHighlightValue.getSerializedSize();
        break label93;
        label211:
        i += regionHighlightValue.getSerializedSize();
        break label135;
        label224:
        i += viewReferrerSourceHighlightValue.getSerializedSize();
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
      if (companyHighlightValue != null)
      {
        i = companyHighlightValue.hashCode();
        if (occupationHighlightValue == null) {
          break label110;
        }
        j = occupationHighlightValue.hashCode();
        label45:
        if (regionHighlightValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = regionHighlightValue.hashCode();; k = 0)
      {
        if (viewReferrerSourceHighlightValue != null) {
          m = viewReferrerSourceHighlightValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
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
          localByteBuffer.putInt(1124942328);
          if (hasCompanyHighlightValue)
          {
            localByteBuffer.put((byte)1);
            if (companyHighlightValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, companyHighlightValue._cachedId);
              companyHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasOccupationHighlightValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (occupationHighlightValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, occupationHighlightValue._cachedId);
              occupationHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasRegionHighlightValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (regionHighlightValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, regionHighlightValue._cachedId);
              regionHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasViewReferrerSourceHighlightValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (viewReferrerSourceHighlightValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, viewReferrerSourceHighlightValue._cachedId);
              viewReferrerSourceHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            companyHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            occupationHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            regionHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            viewReferrerSourceHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */