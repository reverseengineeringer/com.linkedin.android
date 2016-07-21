package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ArticleUpdate
  implements FissileDataModel<ArticleUpdate>, RecordTemplate<ArticleUpdate>
{
  public static final ArticleUpdateBuilder BUILDER = ArticleUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Content content;
  public final long createdTime;
  public final boolean hasContent;
  public final boolean hasCreatedTime;
  
  ArticleUpdate(Content paramContent, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    content = paramContent;
    createdTime = paramLong;
    hasContent = paramBoolean1;
    hasCreatedTime = paramBoolean2;
    _cachedId = null;
  }
  
  public final ArticleUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Content localContent = null;
    boolean bool = false;
    if (hasContent)
    {
      paramDataProcessor.startRecordField$505cff1c("content");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localContent = content.accept(paramDataProcessor);
      if (localContent == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasCreatedTime)
      {
        paramDataProcessor.startRecordField$505cff1c("createdTime");
        paramDataProcessor.processLong(createdTime);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasContent) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localContent = (Content)paramDataProcessor.processDataTemplate(content);
      break;
    }
    label140:
    return new ArticleUpdate(localContent, createdTime, bool, hasCreatedTime);
    label158:
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
      paramObject = (ArticleUpdate)paramObject;
      if (content != null)
      {
        if (content.equals(content)) {}
      }
      else {
        while (content != null) {
          return false;
        }
      }
    } while (createdTime == createdTime);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasContent) {
      if (content._cachedId == null) {
        break label76;
      }
    }
    label76:
    for (i = PegasusBinaryUtils.getEncodedLength(content._cachedId) + 9;; i = content.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasCreatedTime) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (content != null) {}
    for (int i = content.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + (int)(createdTime ^ createdTime >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ArticleUpdate");
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
    label262:
    label270:
    label272:
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
        localByteBuffer.putInt(2127459807);
        if (hasContent)
        {
          localByteBuffer.put((byte)1);
          if (content._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, content._cachedId);
            content.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCreatedTime) {
              break label262;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(createdTime);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label270;
          }
          if (str != null) {
            break label272;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          content.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
  
  public static final class Content
    implements FissileDataModel<Content>, UnionTemplate<Content>
  {
    public static final ArticleUpdateBuilder.ContentBuilder BUILDER = ArticleUpdateBuilder.ContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasShareArticleValue;
    public final boolean hasShareVideoValue;
    public final ShareArticle shareArticleValue;
    public final ShareVideo shareVideoValue;
    
    Content(ShareArticle paramShareArticle, ShareVideo paramShareVideo, boolean paramBoolean1, boolean paramBoolean2)
    {
      shareArticleValue = paramShareArticle;
      shareVideoValue = paramShareVideo;
      hasShareArticleValue = paramBoolean1;
      hasShareVideoValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Content accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasShareArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareArticle");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = shareArticleValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
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
        if (hasShareVideoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareVideo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = shareVideoValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new Content((ShareArticle)localObject2, (ShareVideo)localObject1, bool1, bool2);
        localObject1 = (ShareArticle)paramDataProcessor.processDataTemplate(shareArticleValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (ShareVideo)paramDataProcessor.processDataTemplate(shareVideoValue);
        break label95;
      }
      label181:
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
        if (shareArticleValue != null)
        {
          if (shareArticleValue.equals(shareArticleValue)) {}
        }
        else {
          while (shareArticleValue != null) {
            return false;
          }
        }
        if (shareVideoValue == null) {
          break;
        }
      } while (shareVideoValue.equals(shareVideoValue));
      for (;;)
      {
        return false;
        if (shareVideoValue == null) {
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
        if (hasShareVideoValue)
        {
          i = j + 1;
          if (shareVideoValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareVideoValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = shareArticleValue.getSerializedSize() + 7;
        break;
        label114:
        i += shareVideoValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (shareArticleValue != null) {}
      for (int i = shareArticleValue.hashCode();; i = 0)
      {
        if (shareVideoValue != null) {
          j = shareVideoValue.hashCode();
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
          localByteBuffer.putInt(1901666140);
          if (hasShareArticleValue)
          {
            localByteBuffer.put((byte)1);
            if (shareArticleValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, shareArticleValue._cachedId);
              shareArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasShareVideoValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (shareVideoValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, shareVideoValue._cachedId);
              shareVideoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            shareArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            shareVideoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */