package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class FeedMiniArticle
  implements FissileDataModel<FeedMiniArticle>, RecordTemplate<FeedMiniArticle>
{
  public static final FeedMiniArticleBuilder BUILDER = FeedMiniArticleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final MiniArticle article;
  public final Urn entityUrn;
  public final boolean hasArticle;
  public final boolean hasEntityUrn;
  public final boolean hasSaved;
  public final boolean saved;
  
  FeedMiniArticle(Urn paramUrn, MiniArticle paramMiniArticle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    article = paramMiniArticle;
    saved = paramBoolean1;
    hasEntityUrn = paramBoolean2;
    hasArticle = paramBoolean3;
    hasSaved = paramBoolean4;
    paramMiniArticle = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final FeedMiniArticle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasArticle)
    {
      paramDataProcessor.startRecordField$505cff1c("article");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label150;
      }
      localObject = article.accept(paramDataProcessor);
      if (localObject == null) {
        break label167;
      }
    }
    label150:
    label167:
    for (bool = true;; bool = false)
    {
      if (hasSaved)
      {
        paramDataProcessor.startRecordField$505cff1c("saved");
        paramDataProcessor.processBoolean(saved);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label236;
      }
      try
      {
        if (hasEntityUrn) {
          break label172;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniArticle)paramDataProcessor.processDataTemplate(article);
      break;
    }
    label172:
    if (!hasArticle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle", "article");
    }
    if (!hasSaved) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle", "saved");
    }
    return new FeedMiniArticle(entityUrn, (MiniArticle)localObject, saved, hasEntityUrn, bool, hasSaved);
    label236:
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
      paramObject = (FeedMiniArticle)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (article != null)
      {
        if (article.equals(article)) {}
      }
      else {
        while (article != null) {
          return false;
        }
      }
    } while (saved == saved);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasArticle)
    {
      i = j + 1;
      if (article._cachedId == null) {
        break label111;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(article._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSaved) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      label111:
      i += article.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (article == null) {
        break label81;
      }
    }
    label81:
    for (int j = article.hashCode();; j = 0)
    {
      if (saved) {
        k = 1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FeedMiniArticle");
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
    label204:
    label228:
    label280:
    label305:
    label315:
    label321:
    label329:
    label331:
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
        localByteBuffer.putInt(-2127154423);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasArticle) {
            break label305;
          }
          localByteBuffer.put((byte)1);
          if (article._cachedId == null) {
            break label280;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, article._cachedId);
          article.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSaved) {
            break label321;
          }
          localByteBuffer.put((byte)1);
          if (!saved) {
            break label315;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label329;
          }
          if (str != null) {
            break label331;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          article.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          i = 0;
          break label228;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */