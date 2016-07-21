package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SingleTextPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfilePromotion$Prompt
  implements FissileDataModel<Prompt>, UnionTemplate<Prompt>
{
  public static final ProfilePromotionBuilder.PromptBuilder BUILDER = ProfilePromotionBuilder.PromptBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasPremiumUpsellPromptValue;
  public final boolean hasSingleTextPromptValue;
  public final boolean hasSuggestedEndorsementPromptValue;
  public final PremiumUpsellPrompt premiumUpsellPromptValue;
  public final SingleTextPrompt singleTextPromptValue;
  public final SuggestedEndorsementPrompt suggestedEndorsementPromptValue;
  
  ProfilePromotion$Prompt(SuggestedEndorsementPrompt paramSuggestedEndorsementPrompt, SingleTextPrompt paramSingleTextPrompt, PremiumUpsellPrompt paramPremiumUpsellPrompt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    suggestedEndorsementPromptValue = paramSuggestedEndorsementPrompt;
    singleTextPromptValue = paramSingleTextPrompt;
    premiumUpsellPromptValue = paramPremiumUpsellPrompt;
    hasSuggestedEndorsementPromptValue = paramBoolean1;
    hasSingleTextPromptValue = paramBoolean2;
    hasPremiumUpsellPromptValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Prompt accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasSuggestedEndorsementPromptValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = suggestedEndorsementPromptValue.accept(paramDataProcessor);
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
      if (hasSingleTextPromptValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.prompts.SingleTextPrompt");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = singleTextPromptValue.accept(paramDataProcessor);
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
      if (hasPremiumUpsellPromptValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = premiumUpsellPromptValue.accept(paramDataProcessor);
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
      return new Prompt((SuggestedEndorsementPrompt)localObject2, (SingleTextPrompt)localObject3, (PremiumUpsellPrompt)localObject1, bool1, bool2, bool3);
      localObject1 = (SuggestedEndorsementPrompt)paramDataProcessor.processDataTemplate(suggestedEndorsementPromptValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SingleTextPrompt)paramDataProcessor.processDataTemplate(singleTextPromptValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (PremiumUpsellPrompt)paramDataProcessor.processDataTemplate(premiumUpsellPromptValue);
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
      paramObject = (Prompt)paramObject;
      if (suggestedEndorsementPromptValue != null)
      {
        if (suggestedEndorsementPromptValue.equals(suggestedEndorsementPromptValue)) {}
      }
      else {
        while (suggestedEndorsementPromptValue != null) {
          return false;
        }
      }
      if (singleTextPromptValue != null)
      {
        if (singleTextPromptValue.equals(singleTextPromptValue)) {}
      }
      else {
        while (singleTextPromptValue != null) {
          return false;
        }
      }
      if (premiumUpsellPromptValue == null) {
        break;
      }
    } while (premiumUpsellPromptValue.equals(premiumUpsellPromptValue));
    for (;;)
    {
      return false;
      if (premiumUpsellPromptValue == null) {
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
    if (hasSuggestedEndorsementPromptValue)
    {
      if (suggestedEndorsementPromptValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(suggestedEndorsementPromptValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSingleTextPromptValue)
      {
        i = j + 1;
        if (singleTextPromptValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(singleTextPromptValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasPremiumUpsellPromptValue)
      {
        i = j + 1;
        if (premiumUpsellPromptValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(premiumUpsellPromptValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = suggestedEndorsementPromptValue.getSerializedSize() + 7;
      break;
      label156:
      i += singleTextPromptValue.getSerializedSize();
      break label93;
      label169:
      i += premiumUpsellPromptValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (suggestedEndorsementPromptValue != null)
    {
      i = suggestedEndorsementPromptValue.hashCode();
      if (singleTextPromptValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = singleTextPromptValue.hashCode();; j = 0)
    {
      if (premiumUpsellPromptValue != null) {
        k = premiumUpsellPromptValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Prompt");
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
        localByteBuffer.putInt(-2122678209);
        if (hasSuggestedEndorsementPromptValue)
        {
          localByteBuffer.put((byte)1);
          if (suggestedEndorsementPromptValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedEndorsementPromptValue._cachedId);
            suggestedEndorsementPromptValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSingleTextPromptValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (singleTextPromptValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, singleTextPromptValue._cachedId);
            singleTextPromptValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPremiumUpsellPromptValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (premiumUpsellPromptValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, premiumUpsellPromptValue._cachedId);
            premiumUpsellPromptValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          suggestedEndorsementPromptValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          singleTextPromptValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          premiumUpsellPromptValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotion.Prompt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */