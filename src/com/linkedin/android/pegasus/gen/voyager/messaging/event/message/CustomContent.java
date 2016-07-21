package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CustomContent
  implements FissileDataModel<CustomContent>, UnionTemplate<CustomContent>
{
  public static final CustomContentBuilder BUILDER = CustomContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final ConversationNameUpdateContent conversationNameUpdateContentValue;
  public final GroupContent groupContentValue;
  public final boolean hasConversationNameUpdateContentValue;
  public final boolean hasGroupContentValue;
  public final boolean hasInmailContentValue;
  public final boolean hasShareArticleValue;
  public final boolean hasSpInmailContentValue;
  public final InmailContent inmailContentValue;
  public final ShareArticle shareArticleValue;
  public final SpInmailContent spInmailContentValue;
  
  CustomContent(ConversationNameUpdateContent paramConversationNameUpdateContent, InmailContent paramInmailContent, GroupContent paramGroupContent, SpInmailContent paramSpInmailContent, ShareArticle paramShareArticle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    conversationNameUpdateContentValue = paramConversationNameUpdateContent;
    inmailContentValue = paramInmailContent;
    groupContentValue = paramGroupContent;
    spInmailContentValue = paramSpInmailContent;
    shareArticleValue = paramShareArticle;
    hasConversationNameUpdateContentValue = paramBoolean1;
    hasInmailContentValue = paramBoolean2;
    hasGroupContentValue = paramBoolean3;
    hasSpInmailContentValue = paramBoolean4;
    hasShareArticleValue = paramBoolean5;
    _cachedId = null;
  }
  
  public final CustomContent accept(DataProcessor paramDataProcessor)
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
    if (hasConversationNameUpdateContentValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.message.ConversationNameUpdateContent");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = conversationNameUpdateContentValue.accept(paramDataProcessor);
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
      if (hasInmailContentValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.message.InmailContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label326;
        }
        localObject1 = inmailContentValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label344;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasGroupContentValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.message.GroupContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label353;
        }
        localObject1 = groupContentValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label371;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasSpInmailContentValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label381;
        }
        localObject1 = spInmailContentValue.accept(paramDataProcessor);
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
      if (hasShareArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareArticle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label409;
        }
        localObject1 = shareArticleValue.accept(paramDataProcessor);
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
      return new CustomContent((ConversationNameUpdateContent)localObject2, (InmailContent)localObject3, (GroupContent)localObject4, (SpInmailContent)localObject5, (ShareArticle)localObject1, bool1, bool2, bool3, bool4, bool5);
      localObject1 = (ConversationNameUpdateContent)paramDataProcessor.processDataTemplate(conversationNameUpdateContentValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (InmailContent)paramDataProcessor.processDataTemplate(inmailContentValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (GroupContent)paramDataProcessor.processDataTemplate(groupContentValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SpInmailContent)paramDataProcessor.processDataTemplate(spInmailContentValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (ShareArticle)paramDataProcessor.processDataTemplate(shareArticleValue);
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
      paramObject = (CustomContent)paramObject;
      if (conversationNameUpdateContentValue != null)
      {
        if (conversationNameUpdateContentValue.equals(conversationNameUpdateContentValue)) {}
      }
      else {
        while (conversationNameUpdateContentValue != null) {
          return false;
        }
      }
      if (inmailContentValue != null)
      {
        if (inmailContentValue.equals(inmailContentValue)) {}
      }
      else {
        while (inmailContentValue != null) {
          return false;
        }
      }
      if (groupContentValue != null)
      {
        if (groupContentValue.equals(groupContentValue)) {}
      }
      else {
        while (groupContentValue != null) {
          return false;
        }
      }
      if (spInmailContentValue != null)
      {
        if (spInmailContentValue.equals(spInmailContentValue)) {}
      }
      else {
        while (spInmailContentValue != null) {
          return false;
        }
      }
      if (shareArticleValue == null) {
        break;
      }
    } while (shareArticleValue.equals(shareArticleValue));
    for (;;)
    {
      return false;
      if (shareArticleValue == null) {
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
    if (hasConversationNameUpdateContentValue)
    {
      if (conversationNameUpdateContentValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(conversationNameUpdateContentValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasInmailContentValue)
      {
        i = j + 1;
        if (inmailContentValue._cachedId == null) {
          break label240;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(inmailContentValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasGroupContentValue)
      {
        i = j + 1;
        if (groupContentValue._cachedId == null) {
          break label253;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(groupContentValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasSpInmailContentValue)
      {
        i = j + 1;
        if (spInmailContentValue._cachedId == null) {
          break label266;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(spInmailContentValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasShareArticleValue)
      {
        i = j + 1;
        if (shareArticleValue._cachedId == null) {
          break label279;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareArticleValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = conversationNameUpdateContentValue.getSerializedSize() + 7;
      break;
      label240:
      i += inmailContentValue.getSerializedSize();
      break label93;
      label253:
      i += groupContentValue.getSerializedSize();
      break label135;
      label266:
      i += spInmailContentValue.getSerializedSize();
      break label177;
      label279:
      i += shareArticleValue.getSerializedSize();
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
    if (conversationNameUpdateContentValue != null)
    {
      i = conversationNameUpdateContentValue.hashCode();
      if (inmailContentValue == null) {
        break label132;
      }
      j = inmailContentValue.hashCode();
      if (groupContentValue == null) {
        break label137;
      }
      k = groupContentValue.hashCode();
      label60:
      if (spInmailContentValue == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = spInmailContentValue.hashCode();; m = 0)
    {
      if (shareArticleValue != null) {
        n = shareArticleValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CustomContent");
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
        localByteBuffer.putInt(299450472);
        if (hasConversationNameUpdateContentValue)
        {
          localByteBuffer.put((byte)1);
          if (conversationNameUpdateContentValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, conversationNameUpdateContentValue._cachedId);
            conversationNameUpdateContentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInmailContentValue) {
              break label503;
            }
            localByteBuffer.put((byte)1);
            if (inmailContentValue._cachedId == null) {
              break label478;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inmailContentValue._cachedId);
            inmailContentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasGroupContentValue) {
              break label538;
            }
            localByteBuffer.put((byte)1);
            if (groupContentValue._cachedId == null) {
              break label513;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, groupContentValue._cachedId);
            groupContentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSpInmailContentValue) {
              break label573;
            }
            localByteBuffer.put((byte)1);
            if (spInmailContentValue._cachedId == null) {
              break label548;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, spInmailContentValue._cachedId);
            spInmailContentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareArticleValue) {
              break label608;
            }
            localByteBuffer.put((byte)1);
            if (shareArticleValue._cachedId == null) {
              break label583;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareArticleValue._cachedId);
            shareArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          conversationNameUpdateContentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          inmailContentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          groupContentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          spInmailContentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          shareArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */