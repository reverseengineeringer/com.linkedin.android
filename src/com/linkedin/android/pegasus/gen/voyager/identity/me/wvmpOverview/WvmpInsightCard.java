package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

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

public final class WvmpInsightCard
  implements FissileDataModel<WvmpInsightCard>, RecordTemplate<WvmpInsightCard>
{
  public static final WvmpInsightCardBuilder BUILDER = WvmpInsightCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasObjectUrn;
  public final boolean hasTrackingId;
  public final boolean hasValue;
  public final Urn objectUrn;
  public final String trackingId;
  public final Value value;
  
  WvmpInsightCard(Value paramValue, String paramString, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    value = paramValue;
    trackingId = paramString;
    objectUrn = paramUrn;
    hasValue = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasObjectUrn = paramBoolean3;
    _cachedId = null;
  }
  
  public final WvmpInsightCard accept(DataProcessor paramDataProcessor)
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard", "value");
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
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard", "trackingId");
    }
    if (!hasObjectUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard", "objectUrn");
    }
    return new WvmpInsightCard(localValue, trackingId, objectUrn, bool, hasTrackingId, hasObjectUrn);
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
      paramObject = (WvmpInsightCard)paramObject;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpInsightCard");
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
        localByteBuffer.putInt(-1949925093);
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
    public static final WvmpInsightCardBuilder.ValueBuilder BUILDER = WvmpInsightCardBuilder.ValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasWvmpCompanyInsightCardValue;
    public final boolean hasWvmpJobTitleInsightCardValue;
    public final boolean hasWvmpOnboardingCardValue;
    public final boolean hasWvmpSourceInsightCardValue;
    public final boolean hasWvmpSummaryInsightCardValue;
    public final WvmpCompanyInsightCard wvmpCompanyInsightCardValue;
    public final WvmpJobTitleInsightCard wvmpJobTitleInsightCardValue;
    public final WvmpOnboardingCard wvmpOnboardingCardValue;
    public final WvmpSourceInsightCard wvmpSourceInsightCardValue;
    public final WvmpSummaryInsightCard wvmpSummaryInsightCardValue;
    
    Value(WvmpSummaryInsightCard paramWvmpSummaryInsightCard, WvmpCompanyInsightCard paramWvmpCompanyInsightCard, WvmpJobTitleInsightCard paramWvmpJobTitleInsightCard, WvmpSourceInsightCard paramWvmpSourceInsightCard, WvmpOnboardingCard paramWvmpOnboardingCard, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      wvmpSummaryInsightCardValue = paramWvmpSummaryInsightCard;
      wvmpCompanyInsightCardValue = paramWvmpCompanyInsightCard;
      wvmpJobTitleInsightCardValue = paramWvmpJobTitleInsightCard;
      wvmpSourceInsightCardValue = paramWvmpSourceInsightCard;
      wvmpOnboardingCardValue = paramWvmpOnboardingCard;
      hasWvmpSummaryInsightCardValue = paramBoolean1;
      hasWvmpCompanyInsightCardValue = paramBoolean2;
      hasWvmpJobTitleInsightCardValue = paramBoolean3;
      hasWvmpSourceInsightCardValue = paramBoolean4;
      hasWvmpOnboardingCardValue = paramBoolean5;
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
      label146:
      label158:
      Object localObject5;
      boolean bool4;
      if (hasWvmpSummaryInsightCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = wvmpSummaryInsightCardValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label317;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasWvmpCompanyInsightCardValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label326;
          }
          localObject1 = wvmpCompanyInsightCardValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label344;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasWvmpJobTitleInsightCardValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label353;
          }
          localObject1 = wvmpJobTitleInsightCardValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label371;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasWvmpSourceInsightCardValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label381;
          }
          localObject1 = wvmpSourceInsightCardValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label399;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        label210:
        localObject1 = null;
        bool5 = false;
        if (hasWvmpOnboardingCardValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpOnboardingCard");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label409;
          }
          localObject1 = wvmpOnboardingCardValue.accept(paramDataProcessor);
          label250:
          if (localObject1 == null) {
            break label427;
          }
        }
      }
      label317:
      label326:
      label344:
      label353:
      label371:
      label381:
      label399:
      label409:
      label427:
      for (boolean bool5 = true;; bool5 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label433;
        }
        return new Value((WvmpSummaryInsightCard)localObject2, (WvmpCompanyInsightCard)localObject3, (WvmpJobTitleInsightCard)localObject4, (WvmpSourceInsightCard)localObject5, (WvmpOnboardingCard)localObject1, bool1, bool2, bool3, bool4, bool5);
        localObject1 = (WvmpSummaryInsightCard)paramDataProcessor.processDataTemplate(wvmpSummaryInsightCardValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (WvmpCompanyInsightCard)paramDataProcessor.processDataTemplate(wvmpCompanyInsightCardValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (WvmpJobTitleInsightCard)paramDataProcessor.processDataTemplate(wvmpJobTitleInsightCardValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (WvmpSourceInsightCard)paramDataProcessor.processDataTemplate(wvmpSourceInsightCardValue);
        break label198;
        bool4 = false;
        localObject5 = localObject1;
        break label210;
        localObject1 = (WvmpOnboardingCard)paramDataProcessor.processDataTemplate(wvmpOnboardingCardValue);
        break label250;
      }
      label433:
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
        if (wvmpSummaryInsightCardValue != null)
        {
          if (wvmpSummaryInsightCardValue.equals(wvmpSummaryInsightCardValue)) {}
        }
        else {
          while (wvmpSummaryInsightCardValue != null) {
            return false;
          }
        }
        if (wvmpCompanyInsightCardValue != null)
        {
          if (wvmpCompanyInsightCardValue.equals(wvmpCompanyInsightCardValue)) {}
        }
        else {
          while (wvmpCompanyInsightCardValue != null) {
            return false;
          }
        }
        if (wvmpJobTitleInsightCardValue != null)
        {
          if (wvmpJobTitleInsightCardValue.equals(wvmpJobTitleInsightCardValue)) {}
        }
        else {
          while (wvmpJobTitleInsightCardValue != null) {
            return false;
          }
        }
        if (wvmpSourceInsightCardValue != null)
        {
          if (wvmpSourceInsightCardValue.equals(wvmpSourceInsightCardValue)) {}
        }
        else {
          while (wvmpSourceInsightCardValue != null) {
            return false;
          }
        }
        if (wvmpOnboardingCardValue == null) {
          break;
        }
      } while (wvmpOnboardingCardValue.equals(wvmpOnboardingCardValue));
      for (;;)
      {
        return false;
        if (wvmpOnboardingCardValue == null) {
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
      if (hasWvmpSummaryInsightCardValue)
      {
        if (wvmpSummaryInsightCardValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(wvmpSummaryInsightCardValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasWvmpCompanyInsightCardValue)
        {
          i = j + 1;
          if (wvmpCompanyInsightCardValue._cachedId == null) {
            break label240;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpCompanyInsightCardValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasWvmpJobTitleInsightCardValue)
        {
          i = j + 1;
          if (wvmpJobTitleInsightCardValue._cachedId == null) {
            break label253;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpJobTitleInsightCardValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasWvmpSourceInsightCardValue)
        {
          i = j + 1;
          if (wvmpSourceInsightCardValue._cachedId == null) {
            break label266;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpSourceInsightCardValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasWvmpOnboardingCardValue)
        {
          i = j + 1;
          if (wvmpOnboardingCardValue._cachedId == null) {
            break label279;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpOnboardingCardValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = wvmpSummaryInsightCardValue.getSerializedSize() + 7;
        break;
        label240:
        i += wvmpCompanyInsightCardValue.getSerializedSize();
        break label93;
        label253:
        i += wvmpJobTitleInsightCardValue.getSerializedSize();
        break label135;
        label266:
        i += wvmpSourceInsightCardValue.getSerializedSize();
        break label177;
        label279:
        i += wvmpOnboardingCardValue.getSerializedSize();
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
      label45:
      int k;
      if (wvmpSummaryInsightCardValue != null)
      {
        i = wvmpSummaryInsightCardValue.hashCode();
        if (wvmpCompanyInsightCardValue == null) {
          break label132;
        }
        j = wvmpCompanyInsightCardValue.hashCode();
        if (wvmpJobTitleInsightCardValue == null) {
          break label137;
        }
        k = wvmpJobTitleInsightCardValue.hashCode();
        label60:
        if (wvmpSourceInsightCardValue == null) {
          break label142;
        }
      }
      label132:
      label137:
      label142:
      for (int m = wvmpSourceInsightCardValue.hashCode();; m = 0)
      {
        if (wvmpOnboardingCardValue != null) {
          n = wvmpOnboardingCardValue.hashCode();
        }
        i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
        _cachedHashCode = i;
        return i;
        i = 0;
        break;
        j = 0;
        break label45;
        k = 0;
        break label60;
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
      label350:
      label478:
      label503:
      label513:
      label538:
      label548:
      label573:
      label583:
      label608:
      label616:
      label618:
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
          localByteBuffer.putInt(383855860);
          if (hasWvmpSummaryInsightCardValue)
          {
            localByteBuffer.put((byte)1);
            if (wvmpSummaryInsightCardValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, wvmpSummaryInsightCardValue._cachedId);
              wvmpSummaryInsightCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasWvmpCompanyInsightCardValue) {
                break label503;
              }
              localByteBuffer.put((byte)1);
              if (wvmpCompanyInsightCardValue._cachedId == null) {
                break label478;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, wvmpCompanyInsightCardValue._cachedId);
              wvmpCompanyInsightCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasWvmpJobTitleInsightCardValue) {
                break label538;
              }
              localByteBuffer.put((byte)1);
              if (wvmpJobTitleInsightCardValue._cachedId == null) {
                break label513;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, wvmpJobTitleInsightCardValue._cachedId);
              wvmpJobTitleInsightCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasWvmpSourceInsightCardValue) {
                break label573;
              }
              localByteBuffer.put((byte)1);
              if (wvmpSourceInsightCardValue._cachedId == null) {
                break label548;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, wvmpSourceInsightCardValue._cachedId);
              wvmpSourceInsightCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasWvmpOnboardingCardValue) {
                break label608;
              }
              localByteBuffer.put((byte)1);
              if (wvmpOnboardingCardValue._cachedId == null) {
                break label583;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, wvmpOnboardingCardValue._cachedId);
              wvmpOnboardingCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label616;
            }
            if (str != null) {
              break label618;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            wvmpSummaryInsightCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            wvmpCompanyInsightCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            wvmpJobTitleInsightCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            wvmpSourceInsightCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label350;
            localByteBuffer.put((byte)0);
            break label350;
            localByteBuffer.put((byte)1);
            wvmpOnboardingCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */