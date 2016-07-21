package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DiscussionUpdateContent$Content
  implements FissileDataModel<Content>, UnionTemplate<Content>
{
  public static final DiscussionUpdateContentBuilder.ContentBuilder BUILDER = DiscussionUpdateContentBuilder.ContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final DiscussionBase discussionBaseValue;
  public final DiscussionWithArticle discussionWithArticleValue;
  public final DiscussionWithImage discussionWithImageValue;
  public final boolean hasDiscussionBaseValue;
  public final boolean hasDiscussionWithArticleValue;
  public final boolean hasDiscussionWithImageValue;
  
  DiscussionUpdateContent$Content(DiscussionBase paramDiscussionBase, DiscussionWithArticle paramDiscussionWithArticle, DiscussionWithImage paramDiscussionWithImage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    discussionBaseValue = paramDiscussionBase;
    discussionWithArticleValue = paramDiscussionWithArticle;
    discussionWithImageValue = paramDiscussionWithImage;
    hasDiscussionBaseValue = paramBoolean1;
    hasDiscussionWithArticleValue = paramBoolean2;
    hasDiscussionWithImageValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Content accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasDiscussionBaseValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.DiscussionBase");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = discussionBaseValue.accept(paramDataProcessor);
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
      if (hasDiscussionWithArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.DiscussionWithArticle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = discussionWithArticleValue.accept(paramDataProcessor);
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
      if (hasDiscussionWithImageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.DiscussionWithImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = discussionWithImageValue.accept(paramDataProcessor);
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
      return new Content((DiscussionBase)localObject2, (DiscussionWithArticle)localObject3, (DiscussionWithImage)localObject1, bool1, bool2, bool3);
      localObject1 = (DiscussionBase)paramDataProcessor.processDataTemplate(discussionBaseValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (DiscussionWithArticle)paramDataProcessor.processDataTemplate(discussionWithArticleValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (DiscussionWithImage)paramDataProcessor.processDataTemplate(discussionWithImageValue);
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
      paramObject = (Content)paramObject;
      if (discussionBaseValue != null)
      {
        if (discussionBaseValue.equals(discussionBaseValue)) {}
      }
      else {
        while (discussionBaseValue != null) {
          return false;
        }
      }
      if (discussionWithArticleValue != null)
      {
        if (discussionWithArticleValue.equals(discussionWithArticleValue)) {}
      }
      else {
        while (discussionWithArticleValue != null) {
          return false;
        }
      }
      if (discussionWithImageValue == null) {
        break;
      }
    } while (discussionWithImageValue.equals(discussionWithImageValue));
    for (;;)
    {
      return false;
      if (discussionWithImageValue == null) {
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
    if (hasDiscussionBaseValue)
    {
      if (discussionBaseValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(discussionBaseValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasDiscussionWithArticleValue)
      {
        i = j + 1;
        if (discussionWithArticleValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(discussionWithArticleValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasDiscussionWithImageValue)
      {
        i = j + 1;
        if (discussionWithImageValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(discussionWithImageValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = discussionBaseValue.getSerializedSize() + 7;
      break;
      label156:
      i += discussionWithArticleValue.getSerializedSize();
      break label93;
      label169:
      i += discussionWithImageValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (discussionBaseValue != null)
    {
      i = discussionBaseValue.hashCode();
      if (discussionWithArticleValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = discussionWithArticleValue.hashCode();; j = 0)
    {
      if (discussionWithImageValue != null) {
        k = discussionWithImageValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Content");
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
        localByteBuffer.putInt(-1278765733);
        if (hasDiscussionBaseValue)
        {
          localByteBuffer.put((byte)1);
          if (discussionBaseValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, discussionBaseValue._cachedId);
            discussionBaseValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDiscussionWithArticleValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (discussionWithArticleValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, discussionWithArticleValue._cachedId);
            discussionWithArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDiscussionWithImageValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (discussionWithImageValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, discussionWithImageValue._cachedId);
            discussionWithImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          discussionBaseValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          discussionWithArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          discussionWithImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
  {
    public DiscussionBase discussionBaseValue = null;
    public DiscussionWithArticle discussionWithArticleValue = null;
    public DiscussionWithImage discussionWithImageValue = null;
    public boolean hasDiscussionBaseValue = false;
    public boolean hasDiscussionWithArticleValue = false;
    public boolean hasDiscussionWithImageValue = false;
    
    public final DiscussionUpdateContent.Content build()
      throws BuilderException
    {
      int j = 0;
      if (hasDiscussionBaseValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasDiscussionWithArticleValue) {
        i = j + 1;
      }
      j = i;
      if (hasDiscussionWithImageValue) {
        j = i + 1;
      }
      if (j > 1) {
        throw new UnionMemberCountException("Content", j);
      }
      return new DiscussionUpdateContent.Content(discussionBaseValue, discussionWithArticleValue, discussionWithImageValue, hasDiscussionBaseValue, hasDiscussionWithArticleValue, hasDiscussionWithImageValue);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdateContent.Content
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */