package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareJob;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareContent
  implements FissileDataModel<ShareContent>, UnionTemplate<ShareContent>
{
  public static final ShareContentBuilder BUILDER = ShareContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasShareArticleValue;
  public final boolean hasShareJobValue;
  public final boolean hasUpdateValue;
  public final ShareArticle shareArticleValue;
  public final ShareJob shareJobValue;
  public final Update updateValue;
  
  ShareContent(ShareArticle paramShareArticle, ShareJob paramShareJob, Update paramUpdate, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    shareArticleValue = paramShareArticle;
    shareJobValue = paramShareJob;
    updateValue = paramUpdate;
    hasShareArticleValue = paramBoolean1;
    hasShareJobValue = paramBoolean2;
    hasUpdateValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final ShareContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasShareArticleValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareArticle");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = shareArticleValue.accept(paramDataProcessor);
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
      if (hasShareJobValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareJob");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = shareJobValue.accept(paramDataProcessor);
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
      if (hasUpdateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.Update");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = updateValue.accept(paramDataProcessor);
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
      return new ShareContent((ShareArticle)localObject2, (ShareJob)localObject3, (Update)localObject1, bool1, bool2, bool3);
      localObject1 = (ShareArticle)paramDataProcessor.processDataTemplate(shareArticleValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ShareJob)paramDataProcessor.processDataTemplate(shareJobValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (Update)paramDataProcessor.processDataTemplate(updateValue);
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
      paramObject = (ShareContent)paramObject;
      if (shareArticleValue != null)
      {
        if (shareArticleValue.equals(shareArticleValue)) {}
      }
      else {
        while (shareArticleValue != null) {
          return false;
        }
      }
      if (shareJobValue != null)
      {
        if (shareJobValue.equals(shareJobValue)) {}
      }
      else {
        while (shareJobValue != null) {
          return false;
        }
      }
      if (updateValue == null) {
        break;
      }
    } while (updateValue.equals(updateValue));
    for (;;)
    {
      return false;
      if (updateValue == null) {
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
    if (hasShareArticleValue)
    {
      if (shareArticleValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(shareArticleValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasShareJobValue)
      {
        i = j + 1;
        if (shareJobValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareJobValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasUpdateValue)
      {
        i = j + 1;
        if (updateValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(updateValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = shareArticleValue.getSerializedSize() + 7;
      break;
      label156:
      i += shareJobValue.getSerializedSize();
      break label93;
      label169:
      i += updateValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (shareArticleValue != null)
    {
      i = shareArticleValue.hashCode();
      if (shareJobValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = shareJobValue.hashCode();; j = 0)
    {
      if (updateValue != null) {
        k = updateValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareContent");
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
        localByteBuffer.putInt(-648079831);
        if (hasShareArticleValue)
        {
          localByteBuffer.put((byte)1);
          if (shareArticleValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareArticleValue._cachedId);
            shareArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareJobValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (shareJobValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareJobValue._cachedId);
            shareJobValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUpdateValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (updateValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, updateValue._cachedId);
            updateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          shareArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          shareJobValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          updateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.ShareContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */