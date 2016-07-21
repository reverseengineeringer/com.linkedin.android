package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Action$Value
  implements FissileDataModel<Value>, UnionTemplate<Value>
{
  public static final ActionBuilder.ValueBuilder BUILDER = ActionBuilder.ValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AcceptSuggestedEndorsements acceptSuggestedEndorsementsValue;
  public final Dismiss dismissValue;
  public final boolean hasAcceptSuggestedEndorsementsValue;
  public final boolean hasDismissValue;
  public final boolean hasMessageValue;
  public final boolean hasRejectSuggestedEndorsementsValue;
  public final boolean hasUpgradeToPremiumValue;
  public final Message messageValue;
  public final RejectSuggestedEndorsements rejectSuggestedEndorsementsValue;
  public final UpgradeToPremium upgradeToPremiumValue;
  
  Action$Value(Dismiss paramDismiss, Message paramMessage, AcceptSuggestedEndorsements paramAcceptSuggestedEndorsements, RejectSuggestedEndorsements paramRejectSuggestedEndorsements, UpgradeToPremium paramUpgradeToPremium, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    dismissValue = paramDismiss;
    messageValue = paramMessage;
    acceptSuggestedEndorsementsValue = paramAcceptSuggestedEndorsements;
    rejectSuggestedEndorsementsValue = paramRejectSuggestedEndorsements;
    upgradeToPremiumValue = paramUpgradeToPremium;
    hasDismissValue = paramBoolean1;
    hasMessageValue = paramBoolean2;
    hasAcceptSuggestedEndorsementsValue = paramBoolean3;
    hasRejectSuggestedEndorsementsValue = paramBoolean4;
    hasUpgradeToPremiumValue = paramBoolean5;
    _cachedId = null;
  }
  
  public final Value accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label52:
    Object localObject3;
    boolean bool2;
    label91:
    label102:
    Object localObject4;
    boolean bool3;
    label142:
    label154:
    Object localObject5;
    boolean bool4;
    if (hasDismissValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.actions.Dismiss");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = Dismiss.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label309;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasMessageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.actions.Message");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label318;
        }
        localObject1 = messageValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label336;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasAcceptSuggestedEndorsementsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.actions.AcceptSuggestedEndorsements");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label345;
        }
        localObject1 = acceptSuggestedEndorsementsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label363;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasRejectSuggestedEndorsementsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.actions.RejectSuggestedEndorsements");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label373;
        }
        localObject1 = rejectSuggestedEndorsementsValue.accept(paramDataProcessor);
        label194:
        if (localObject1 == null) {
          break label391;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label206:
      localObject1 = null;
      bool5 = false;
      if (hasUpgradeToPremiumValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.promotions.actions.UpgradeToPremium");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label401;
        }
        localObject1 = UpgradeToPremium.accept(paramDataProcessor);
        label242:
        if (localObject1 == null) {
          break label419;
        }
      }
    }
    label309:
    label318:
    label336:
    label345:
    label363:
    label373:
    label391:
    label401:
    label419:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label425;
      }
      return new Value((Dismiss)localObject2, (Message)localObject3, (AcceptSuggestedEndorsements)localObject4, (RejectSuggestedEndorsements)localObject5, (UpgradeToPremium)localObject1, bool1, bool2, bool3, bool4, bool5);
      localObject1 = (Dismiss)paramDataProcessor.processDataTemplate(dismissValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label52;
      localObject1 = (Message)paramDataProcessor.processDataTemplate(messageValue);
      break label91;
      bool2 = false;
      localObject3 = localObject1;
      break label102;
      localObject1 = (AcceptSuggestedEndorsements)paramDataProcessor.processDataTemplate(acceptSuggestedEndorsementsValue);
      break label142;
      bool3 = false;
      localObject4 = localObject1;
      break label154;
      localObject1 = (RejectSuggestedEndorsements)paramDataProcessor.processDataTemplate(rejectSuggestedEndorsementsValue);
      break label194;
      bool4 = false;
      localObject5 = localObject1;
      break label206;
      localObject1 = (UpgradeToPremium)paramDataProcessor.processDataTemplate(upgradeToPremiumValue);
      break label242;
    }
    label425:
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
      if (dismissValue != null)
      {
        if (dismissValue.equals(dismissValue)) {}
      }
      else {
        while (dismissValue != null) {
          return false;
        }
      }
      if (messageValue != null)
      {
        if (messageValue.equals(messageValue)) {}
      }
      else {
        while (messageValue != null) {
          return false;
        }
      }
      if (acceptSuggestedEndorsementsValue != null)
      {
        if (acceptSuggestedEndorsementsValue.equals(acceptSuggestedEndorsementsValue)) {}
      }
      else {
        while (acceptSuggestedEndorsementsValue != null) {
          return false;
        }
      }
      if (rejectSuggestedEndorsementsValue != null)
      {
        if (rejectSuggestedEndorsementsValue.equals(rejectSuggestedEndorsementsValue)) {}
      }
      else {
        while (rejectSuggestedEndorsementsValue != null) {
          return false;
        }
      }
      if (upgradeToPremiumValue == null) {
        break;
      }
    } while (upgradeToPremiumValue.equals(upgradeToPremiumValue));
    for (;;)
    {
      return false;
      if (upgradeToPremiumValue == null) {
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
    if (hasDismissValue)
    {
      if (dismissValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(dismissValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasMessageValue)
      {
        i = j + 1;
        if (messageValue._cachedId == null) {
          break label240;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(messageValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasAcceptSuggestedEndorsementsValue)
      {
        i = j + 1;
        if (acceptSuggestedEndorsementsValue._cachedId == null) {
          break label253;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(acceptSuggestedEndorsementsValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasRejectSuggestedEndorsementsValue)
      {
        i = j + 1;
        if (rejectSuggestedEndorsementsValue._cachedId == null) {
          break label266;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(rejectSuggestedEndorsementsValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasUpgradeToPremiumValue)
      {
        i = j + 1;
        if (upgradeToPremiumValue._cachedId == null) {
          break label279;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(upgradeToPremiumValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = dismissValue.getSerializedSize() + 7;
      break;
      label240:
      i += messageValue.getSerializedSize();
      break label93;
      label253:
      i += acceptSuggestedEndorsementsValue.getSerializedSize();
      break label135;
      label266:
      i += rejectSuggestedEndorsementsValue.getSerializedSize();
      break label177;
      label279:
      i += upgradeToPremiumValue.getSerializedSize();
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
    if (dismissValue != null)
    {
      i = dismissValue.hashCode();
      if (messageValue == null) {
        break label132;
      }
      j = messageValue.hashCode();
      if (acceptSuggestedEndorsementsValue == null) {
        break label137;
      }
      k = acceptSuggestedEndorsementsValue.hashCode();
      label60:
      if (rejectSuggestedEndorsementsValue == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = rejectSuggestedEndorsementsValue.hashCode();; m = 0)
    {
      if (upgradeToPremiumValue != null) {
        n = upgradeToPremiumValue.hashCode();
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
        localByteBuffer.putInt(780843706);
        if (hasDismissValue)
        {
          localByteBuffer.put((byte)1);
          if (dismissValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, dismissValue._cachedId);
            dismissValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMessageValue) {
              break label503;
            }
            localByteBuffer.put((byte)1);
            if (messageValue._cachedId == null) {
              break label478;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, messageValue._cachedId);
            messageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAcceptSuggestedEndorsementsValue) {
              break label538;
            }
            localByteBuffer.put((byte)1);
            if (acceptSuggestedEndorsementsValue._cachedId == null) {
              break label513;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, acceptSuggestedEndorsementsValue._cachedId);
            acceptSuggestedEndorsementsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRejectSuggestedEndorsementsValue) {
              break label573;
            }
            localByteBuffer.put((byte)1);
            if (rejectSuggestedEndorsementsValue._cachedId == null) {
              break label548;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, rejectSuggestedEndorsementsValue._cachedId);
            rejectSuggestedEndorsementsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUpgradeToPremiumValue) {
              break label608;
            }
            localByteBuffer.put((byte)1);
            if (upgradeToPremiumValue._cachedId == null) {
              break label583;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, upgradeToPremiumValue._cachedId);
            upgradeToPremiumValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          dismissValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          messageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          acceptSuggestedEndorsementsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          rejectSuggestedEndorsementsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          upgradeToPremiumValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Action.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */