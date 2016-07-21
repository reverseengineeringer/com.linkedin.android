package com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CtaAction$Action
  implements FissileDataModel<Action>, UnionTemplate<Action>
{
  public static final CtaActionBuilder.ActionBuilder BUILDER = CtaActionBuilder.ActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLikeActionValue;
  public final boolean hasMessageActionValue;
  public final LikeAction likeActionValue;
  public final MessageAction messageActionValue;
  
  CtaAction$Action(MessageAction paramMessageAction, LikeAction paramLikeAction, boolean paramBoolean1, boolean paramBoolean2)
  {
    messageActionValue = paramMessageAction;
    likeActionValue = paramLikeAction;
    hasMessageActionValue = paramBoolean1;
    hasLikeActionValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Action accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMessageActionValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ctaActions.MessageAction");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = messageActionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label145;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasLikeActionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ctaActions.LikeAction");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label154;
        }
        localObject1 = LikeAction.accept(paramDataProcessor);
        label91:
        if (localObject1 == null) {
          break label172;
        }
      }
    }
    label145:
    label154:
    label172:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      return new Action((MessageAction)localObject2, (LikeAction)localObject1, bool1, bool2);
      localObject1 = (MessageAction)paramDataProcessor.processDataTemplate(messageActionValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (LikeAction)paramDataProcessor.processDataTemplate(likeActionValue);
      break label91;
    }
    label177:
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
      paramObject = (Action)paramObject;
      if (messageActionValue != null)
      {
        if (messageActionValue.equals(messageActionValue)) {}
      }
      else {
        while (messageActionValue != null) {
          return false;
        }
      }
      if (likeActionValue == null) {
        break;
      }
    } while (likeActionValue.equals(likeActionValue));
    for (;;)
    {
      return false;
      if (likeActionValue == null) {
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
    if (hasMessageActionValue)
    {
      if (messageActionValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(messageActionValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasLikeActionValue)
      {
        i = j + 1;
        if (likeActionValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(likeActionValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = messageActionValue.getSerializedSize() + 7;
      break;
      label114:
      i += likeActionValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (messageActionValue != null) {}
    for (int i = messageActionValue.hashCode();; i = 0)
    {
      if (likeActionValue != null) {
        j = likeActionValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Action");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(324469014);
        if (hasMessageActionValue)
        {
          localByteBuffer.put((byte)1);
          if (messageActionValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, messageActionValue._cachedId);
            messageActionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLikeActionValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (likeActionValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, likeActionValue._cachedId);
            likeActionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          messageActionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          likeActionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaAction.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */