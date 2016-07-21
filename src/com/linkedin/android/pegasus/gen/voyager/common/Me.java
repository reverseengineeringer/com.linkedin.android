package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.PublicContactInfo;
import com.linkedin.android.pegasus.gen.voyager.premium.MemberGroup;
import com.linkedin.android.pegasus.gen.voyager.premium.PaidProduct;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Me
  implements FissileDataModel<Me>, RecordTemplate<Me>
{
  public static final MeBuilder BUILDER = MeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasMemberGroup;
  public final boolean hasMiniProfile;
  public final boolean hasPaidProducts;
  public final boolean hasPlainId;
  public final boolean hasPremiumSubscriber;
  public final boolean hasPublicContactInfo;
  public final MemberGroup memberGroup;
  public final MiniProfile miniProfile;
  public final List<PaidProduct> paidProducts;
  public final long plainId;
  public final boolean premiumSubscriber;
  public final PublicContactInfo publicContactInfo;
  
  Me(long paramLong, MiniProfile paramMiniProfile, PublicContactInfo paramPublicContactInfo, boolean paramBoolean1, List<PaidProduct> paramList, MemberGroup paramMemberGroup, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    plainId = paramLong;
    miniProfile = paramMiniProfile;
    publicContactInfo = paramPublicContactInfo;
    premiumSubscriber = paramBoolean1;
    if (paramList == null) {}
    for (paramMiniProfile = null;; paramMiniProfile = Collections.unmodifiableList(paramList))
    {
      paidProducts = paramMiniProfile;
      memberGroup = paramMemberGroup;
      hasPlainId = paramBoolean2;
      hasMiniProfile = paramBoolean3;
      hasPublicContactInfo = paramBoolean4;
      hasPremiumSubscriber = paramBoolean5;
      hasPaidProducts = paramBoolean6;
      hasMemberGroup = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  private Me accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPlainId)
    {
      paramDataProcessor.startRecordField$505cff1c("plainId");
      paramDataProcessor.processLong(plainId);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    boolean bool2;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label310;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPublicContactInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("publicContactInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label319;
        }
        localObject1 = publicContactInfo.accept(paramDataProcessor);
        label121:
        if (localObject1 == null) {
          break label337;
        }
        bool2 = true;
      }
    }
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      if (hasPremiumSubscriber)
      {
        paramDataProcessor.startRecordField$505cff1c("premiumSubscriber");
        paramDataProcessor.processBoolean(premiumSubscriber);
      }
      localObject1 = null;
      Iterator localIterator = null;
      bool3 = false;
      if (!hasPaidProducts) {
        break label361;
      }
      paramDataProcessor.startRecordField$505cff1c("paidProducts");
      paidProducts.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = paidProducts.iterator();
      while (localIterator.hasNext())
      {
        PaidProduct localPaidProduct = (PaidProduct)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum(localPaidProduct);
        if (localObject1 != null) {
          ((List)localObject1).add(localPaidProduct);
        }
        i += 1;
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      label310:
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      label319:
      localObject1 = (PublicContactInfo)paramDataProcessor.processDataTemplate(publicContactInfo);
      break label121;
      label337:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label361:
      if (hasMemberGroup)
      {
        paramDataProcessor.startRecordField$505cff1c("memberGroup");
        paramDataProcessor.processEnum(memberGroup);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label579;
      }
      if (!hasPaidProducts) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasPlainId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Me", "plainId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasMiniProfile) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Me", "miniProfile");
    }
    if (!hasPublicContactInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Me", "publicContactInfo");
    }
    if (paidProducts != null)
    {
      paramDataProcessor = paidProducts.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PaidProduct)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.common.Me", "paidProducts");
        }
      }
    }
    return new Me(plainId, (MiniProfile)localObject2, (PublicContactInfo)localObject3, premiumSubscriber, (List)localObject1, memberGroup, hasPlainId, bool1, bool2, hasPremiumSubscriber, bool3, hasMemberGroup);
    label579:
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
      paramObject = (Me)paramObject;
      if (plainId != plainId) {
        return false;
      }
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (publicContactInfo != null)
      {
        if (publicContactInfo.equals(publicContactInfo)) {}
      }
      else {
        while (publicContactInfo != null) {
          return false;
        }
      }
      if (premiumSubscriber != premiumSubscriber) {
        return false;
      }
      if (paidProducts != null)
      {
        if (paidProducts.equals(paidProducts)) {}
      }
      else {
        while (paidProducts != null) {
          return false;
        }
      }
      if (memberGroup == null) {
        break;
      }
    } while (memberGroup.equals(memberGroup));
    for (;;)
    {
      return false;
      if (memberGroup == null) {
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
    if (hasPlainId) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasPublicContactInfo)
      {
        i = j + 1;
        if (publicContactInfo._cachedId == null) {
          break label200;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(publicContactInfo._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasPremiumSubscriber) {
        i = j + 1;
      }
      i += 1;
      j = i;
      if (!hasPaidProducts) {
        break label213;
      }
      i += 2;
      Iterator localIterator = paidProducts.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localIterator.next();
        i += 2;
      }
      i += miniProfile.getSerializedSize();
      break;
      label200:
      i += publicContactInfo.getSerializedSize();
    }
    label213:
    j += 1;
    i = j;
    if (hasMemberGroup) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = (int)(plainId ^ plainId >>> 32);
    int i;
    int j;
    label60:
    int k;
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (publicContactInfo == null) {
        break label149;
      }
      j = publicContactInfo.hashCode();
      if (!premiumSubscriber) {
        break label154;
      }
      k = 1;
      label69:
      if (paidProducts == null) {
        break label159;
      }
    }
    label149:
    label154:
    label159:
    for (int m = paidProducts.hashCode();; m = 0)
    {
      if (memberGroup != null) {
        n = memberGroup.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
      k = 0;
      break label69;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Me");
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
    label195:
    label255:
    label279:
    label374:
    label399:
    label409:
    label434:
    label444:
    label450:
    label460:
    label539:
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
        localByteBuffer.putInt(-200625824);
        if (hasPlainId)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(plainId);
          if (!hasMiniProfile) {
            break label399;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label374;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPublicContactInfo) {
            break label434;
          }
          localByteBuffer.put((byte)1);
          if (publicContactInfo._cachedId == null) {
            break label409;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, publicContactInfo._cachedId);
          publicContactInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPremiumSubscriber) {
            break label450;
          }
          localByteBuffer.put((byte)1);
          if (!premiumSubscriber) {
            break label444;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (!hasPaidProducts) {
            break label460;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, paidProducts.size());
          Iterator localIterator = paidProducts.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, ((PaidProduct)localIterator.next()).ordinal());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label195;
          localByteBuffer.put((byte)0);
          break label195;
          localByteBuffer.put((byte)1);
          publicContactInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label255;
          localByteBuffer.put((byte)0);
          break label255;
          i = 0;
          break label279;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasMemberGroup)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, memberGroup.ordinal());
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label539;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Me
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */