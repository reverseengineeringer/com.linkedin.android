package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.crosspromo.fe.api.bolton.android.JobRecommendationBoltOn;
import com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn;
import com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Bolton$BoltOnUnion
  implements FissileDataModel<BoltOnUnion>, UnionTemplate<BoltOnUnion>
{
  public static final BoltonBuilder.BoltOnUnionBuilder BUILDER = BoltonBuilder.BoltOnUnionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasJobRecommendationBoltOnValue;
  public final boolean hasPulseTrendingArticleBoltOnValue;
  public final boolean hasSocialProofBoltOnValue;
  public final JobRecommendationBoltOn jobRecommendationBoltOnValue;
  public final PulseTrendingArticleBoltOn pulseTrendingArticleBoltOnValue;
  public final SocialProofBoltOn socialProofBoltOnValue;
  
  Bolton$BoltOnUnion(SocialProofBoltOn paramSocialProofBoltOn, PulseTrendingArticleBoltOn paramPulseTrendingArticleBoltOn, JobRecommendationBoltOn paramJobRecommendationBoltOn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    socialProofBoltOnValue = paramSocialProofBoltOn;
    pulseTrendingArticleBoltOnValue = paramPulseTrendingArticleBoltOn;
    jobRecommendationBoltOnValue = paramJobRecommendationBoltOn;
    hasSocialProofBoltOnValue = paramBoolean1;
    hasPulseTrendingArticleBoltOnValue = paramBoolean2;
    hasJobRecommendationBoltOnValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final BoltOnUnion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasSocialProofBoltOnValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.crosspromo.fe.api.bolton.SocialProofBoltOn");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = socialProofBoltOnValue.accept(paramDataProcessor);
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
      if (hasPulseTrendingArticleBoltOnValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.crosspromo.fe.api.bolton.PulseTrendingArticleBoltOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = pulseTrendingArticleBoltOnValue.accept(paramDataProcessor);
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
      if (hasJobRecommendationBoltOnValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.crosspromo.fe.api.bolton.JobRecommendationBoltOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = jobRecommendationBoltOnValue.accept(paramDataProcessor);
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
      return new BoltOnUnion((SocialProofBoltOn)localObject2, (PulseTrendingArticleBoltOn)localObject3, (JobRecommendationBoltOn)localObject1, bool1, bool2, bool3);
      localObject1 = (SocialProofBoltOn)paramDataProcessor.processDataTemplate(socialProofBoltOnValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (PulseTrendingArticleBoltOn)paramDataProcessor.processDataTemplate(pulseTrendingArticleBoltOnValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (JobRecommendationBoltOn)paramDataProcessor.processDataTemplate(jobRecommendationBoltOnValue);
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
      paramObject = (BoltOnUnion)paramObject;
      if (socialProofBoltOnValue != null)
      {
        if (socialProofBoltOnValue.equals(socialProofBoltOnValue)) {}
      }
      else {
        while (socialProofBoltOnValue != null) {
          return false;
        }
      }
      if (pulseTrendingArticleBoltOnValue != null)
      {
        if (pulseTrendingArticleBoltOnValue.equals(pulseTrendingArticleBoltOnValue)) {}
      }
      else {
        while (pulseTrendingArticleBoltOnValue != null) {
          return false;
        }
      }
      if (jobRecommendationBoltOnValue == null) {
        break;
      }
    } while (jobRecommendationBoltOnValue.equals(jobRecommendationBoltOnValue));
    for (;;)
    {
      return false;
      if (jobRecommendationBoltOnValue == null) {
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
    if (hasSocialProofBoltOnValue)
    {
      if (socialProofBoltOnValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(socialProofBoltOnValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasPulseTrendingArticleBoltOnValue)
      {
        i = j + 1;
        if (pulseTrendingArticleBoltOnValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pulseTrendingArticleBoltOnValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasJobRecommendationBoltOnValue)
      {
        i = j + 1;
        if (jobRecommendationBoltOnValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobRecommendationBoltOnValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = socialProofBoltOnValue.getSerializedSize() + 7;
      break;
      label156:
      i += pulseTrendingArticleBoltOnValue.getSerializedSize();
      break label93;
      label169:
      i += jobRecommendationBoltOnValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (socialProofBoltOnValue != null)
    {
      i = socialProofBoltOnValue.hashCode();
      if (pulseTrendingArticleBoltOnValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = pulseTrendingArticleBoltOnValue.hashCode();; j = 0)
    {
      if (jobRecommendationBoltOnValue != null) {
        k = jobRecommendationBoltOnValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BoltOnUnion");
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
        localByteBuffer.putInt(2125125086);
        if (hasSocialProofBoltOnValue)
        {
          localByteBuffer.put((byte)1);
          if (socialProofBoltOnValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialProofBoltOnValue._cachedId);
            socialProofBoltOnValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPulseTrendingArticleBoltOnValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (pulseTrendingArticleBoltOnValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pulseTrendingArticleBoltOnValue._cachedId);
            pulseTrendingArticleBoltOnValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobRecommendationBoltOnValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (jobRecommendationBoltOnValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobRecommendationBoltOnValue._cachedId);
            jobRecommendationBoltOnValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          socialProofBoltOnValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          pulseTrendingArticleBoltOnValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          jobRecommendationBoltOnValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.Bolton.BoltOnUnion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */