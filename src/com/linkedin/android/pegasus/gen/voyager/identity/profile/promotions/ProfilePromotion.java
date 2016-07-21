package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Action;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SingleTextPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfilePromotion
  implements FissileDataModel<ProfilePromotion>, RecordTemplate<ProfilePromotion>
{
  public static final ProfilePromotionBuilder BUILDER = ProfilePromotionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Action dismissAction;
  public final boolean hasDismissAction;
  public final boolean hasLegoTrackingToken;
  public final boolean hasPrimaryAction;
  public final boolean hasPrompt;
  public final boolean hasSecondaryAction;
  public final String legoTrackingToken;
  public final Action primaryAction;
  public final Prompt prompt;
  public final Action secondaryAction;
  
  ProfilePromotion(Prompt paramPrompt, Action paramAction1, Action paramAction2, Action paramAction3, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    prompt = paramPrompt;
    primaryAction = paramAction1;
    secondaryAction = paramAction2;
    dismissAction = paramAction3;
    legoTrackingToken = paramString;
    hasPrompt = paramBoolean1;
    hasPrimaryAction = paramBoolean2;
    hasSecondaryAction = paramBoolean3;
    hasDismissAction = paramBoolean4;
    hasLegoTrackingToken = paramBoolean5;
    _cachedId = null;
  }
  
  private ProfilePromotion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
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
    if (hasPrompt)
    {
      paramDataProcessor.startRecordField$505cff1c("prompt");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = prompt.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label293;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPrimaryAction)
      {
        paramDataProcessor.startRecordField$505cff1c("primaryAction");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label302;
        }
        localObject1 = primaryAction.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label320;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasSecondaryAction)
      {
        paramDataProcessor.startRecordField$505cff1c("secondaryAction");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label329;
        }
        localObject1 = secondaryAction.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label347;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasDismissAction)
      {
        paramDataProcessor.startRecordField$505cff1c("dismissAction");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label357;
        }
        localObject1 = dismissAction.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label375;
        }
      }
    }
    label293:
    label302:
    label320:
    label329:
    label347:
    label357:
    label375:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasLegoTrackingToken)
      {
        paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
        paramDataProcessor.processString(legoTrackingToken);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label411;
      }
      try
      {
        if (hasPrompt) {
          break label381;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotion", "prompt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Prompt)paramDataProcessor.processDataTemplate(prompt);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Action)paramDataProcessor.processDataTemplate(primaryAction);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (Action)paramDataProcessor.processDataTemplate(secondaryAction);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (Action)paramDataProcessor.processDataTemplate(dismissAction);
      break label198;
    }
    label381:
    return new ProfilePromotion((Prompt)localObject2, (Action)localObject3, (Action)localObject4, (Action)localObject1, legoTrackingToken, bool1, bool2, bool3, bool4, hasLegoTrackingToken);
    label411:
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
      paramObject = (ProfilePromotion)paramObject;
      if (prompt != null)
      {
        if (prompt.equals(prompt)) {}
      }
      else {
        while (prompt != null) {
          return false;
        }
      }
      if (primaryAction != null)
      {
        if (primaryAction.equals(primaryAction)) {}
      }
      else {
        while (primaryAction != null) {
          return false;
        }
      }
      if (secondaryAction != null)
      {
        if (secondaryAction.equals(secondaryAction)) {}
      }
      else {
        while (secondaryAction != null) {
          return false;
        }
      }
      if (dismissAction != null)
      {
        if (dismissAction.equals(dismissAction)) {}
      }
      else {
        while (dismissAction != null) {
          return false;
        }
      }
      if (legoTrackingToken == null) {
        break;
      }
    } while (legoTrackingToken.equals(legoTrackingToken));
    for (;;)
    {
      return false;
      if (legoTrackingToken == null) {
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
    int j;
    if (hasPrompt)
    {
      if (prompt._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(prompt._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasPrimaryAction)
      {
        i = j + 1;
        if (primaryAction._cachedId == null) {
          break label223;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(primaryAction._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSecondaryAction)
      {
        i = j + 1;
        if (secondaryAction._cachedId == null) {
          break label236;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(secondaryAction._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasDismissAction)
      {
        i = j + 1;
        if (dismissAction._cachedId == null) {
          break label249;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(dismissAction._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasLegoTrackingToken) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
      }
      __sizeOfObject = i;
      return i;
      i = prompt.getSerializedSize() + 7;
      break;
      label223:
      i += primaryAction.getSerializedSize();
      break label93;
      label236:
      i += secondaryAction.getSerializedSize();
      break label135;
      label249:
      i += dismissAction.getSerializedSize();
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
    if (prompt != null)
    {
      i = prompt.hashCode();
      if (primaryAction == null) {
        break label132;
      }
      j = primaryAction.hashCode();
      if (secondaryAction == null) {
        break label137;
      }
      k = secondaryAction.hashCode();
      label60:
      if (dismissAction == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = dismissAction.hashCode();; m = 0)
    {
      if (legoTrackingToken != null) {
        n = legoTrackingToken.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfilePromotion");
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
    label444:
    label469:
    label479:
    label504:
    label514:
    label539:
    label549:
    label557:
    label559:
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
        localByteBuffer.putInt(-1614725610);
        if (hasPrompt)
        {
          localByteBuffer.put((byte)1);
          if (prompt._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, prompt._cachedId);
            prompt.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPrimaryAction) {
              break label469;
            }
            localByteBuffer.put((byte)1);
            if (primaryAction._cachedId == null) {
              break label444;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, primaryAction._cachedId);
            primaryAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSecondaryAction) {
              break label504;
            }
            localByteBuffer.put((byte)1);
            if (secondaryAction._cachedId == null) {
              break label479;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, secondaryAction._cachedId);
            secondaryAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDismissAction) {
              break label539;
            }
            localByteBuffer.put((byte)1);
            if (dismissAction._cachedId == null) {
              break label514;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, dismissAction._cachedId);
            dismissAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLegoTrackingToken) {
              break label549;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label557;
          }
          if (str != null) {
            break label559;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          prompt.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          primaryAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          secondaryAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          dismissAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
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
  
  public static final class Prompt
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
    
    Prompt(SuggestedEndorsementPrompt paramSuggestedEndorsementPrompt, SingleTextPrompt paramSingleTextPrompt, PremiumUpsellPrompt paramPremiumUpsellPrompt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */