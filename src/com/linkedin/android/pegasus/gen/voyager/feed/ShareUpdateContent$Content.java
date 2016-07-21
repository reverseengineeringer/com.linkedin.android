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

public final class ShareUpdateContent$Content
  implements FissileDataModel<Content>, UnionTemplate<Content>
{
  public static final ShareUpdateContentBuilder.ContentBuilder BUILDER = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasShareArticleValue;
  public final boolean hasShareDocumentValue;
  public final boolean hasShareImageValue;
  public final boolean hasShareJobValue;
  public final boolean hasShareTextValue;
  public final boolean hasShareVideoValue;
  public final ShareArticle shareArticleValue;
  public final ShareDocument shareDocumentValue;
  public final ShareImage shareImageValue;
  public final ShareJob shareJobValue;
  public final ShareText shareTextValue;
  public final ShareVideo shareVideoValue;
  
  ShareUpdateContent$Content(ShareText paramShareText, ShareArticle paramShareArticle, ShareDocument paramShareDocument, ShareImage paramShareImage, ShareJob paramShareJob, ShareVideo paramShareVideo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    shareTextValue = paramShareText;
    shareArticleValue = paramShareArticle;
    shareDocumentValue = paramShareDocument;
    shareImageValue = paramShareImage;
    shareJobValue = paramShareJob;
    shareVideoValue = paramShareVideo;
    hasShareTextValue = paramBoolean1;
    hasShareArticleValue = paramBoolean2;
    hasShareDocumentValue = paramBoolean3;
    hasShareImageValue = paramBoolean4;
    hasShareJobValue = paramBoolean5;
    hasShareVideoValue = paramBoolean6;
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
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    label198:
    label210:
    Object localObject6;
    boolean bool5;
    if (hasShareTextValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareText");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = shareTextValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label373;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasShareArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareArticle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label382;
        }
        localObject1 = shareArticleValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label400;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasShareDocumentValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareDocument");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label409;
        }
        localObject1 = shareDocumentValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label427;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasShareImageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label437;
        }
        localObject1 = shareImageValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label455;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasShareJobValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareJob");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label465;
        }
        localObject1 = shareJobValue.accept(paramDataProcessor);
        label250:
        if (localObject1 == null) {
          break label483;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label262:
      localObject1 = null;
      bool6 = false;
      if (hasShareVideoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareVideo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label493;
        }
        localObject1 = shareVideoValue.accept(paramDataProcessor);
        label302:
        if (localObject1 == null) {
          break label511;
        }
      }
    }
    label373:
    label382:
    label400:
    label409:
    label427:
    label437:
    label455:
    label465:
    label483:
    label493:
    label511:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label517;
      }
      return new Content((ShareText)localObject2, (ShareArticle)localObject3, (ShareDocument)localObject4, (ShareImage)localObject5, (ShareJob)localObject6, (ShareVideo)localObject1, bool1, bool2, bool3, bool4, bool5, bool6);
      localObject1 = (ShareText)paramDataProcessor.processDataTemplate(shareTextValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ShareArticle)paramDataProcessor.processDataTemplate(shareArticleValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (ShareDocument)paramDataProcessor.processDataTemplate(shareDocumentValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (ShareImage)paramDataProcessor.processDataTemplate(shareImageValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (ShareJob)paramDataProcessor.processDataTemplate(shareJobValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (ShareVideo)paramDataProcessor.processDataTemplate(shareVideoValue);
      break label302;
    }
    label517:
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
      if (shareTextValue != null)
      {
        if (shareTextValue.equals(shareTextValue)) {}
      }
      else {
        while (shareTextValue != null) {
          return false;
        }
      }
      if (shareArticleValue != null)
      {
        if (shareArticleValue.equals(shareArticleValue)) {}
      }
      else {
        while (shareArticleValue != null) {
          return false;
        }
      }
      if (shareDocumentValue != null)
      {
        if (shareDocumentValue.equals(shareDocumentValue)) {}
      }
      else {
        while (shareDocumentValue != null) {
          return false;
        }
      }
      if (shareImageValue != null)
      {
        if (shareImageValue.equals(shareImageValue)) {}
      }
      else {
        while (shareImageValue != null) {
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
    if (hasShareTextValue)
    {
      if (shareTextValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(shareTextValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasShareArticleValue)
      {
        i = j + 1;
        if (shareArticleValue._cachedId == null) {
          break label282;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareArticleValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasShareDocumentValue)
      {
        i = j + 1;
        if (shareDocumentValue._cachedId == null) {
          break label295;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareDocumentValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasShareImageValue)
      {
        i = j + 1;
        if (shareImageValue._cachedId == null) {
          break label308;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareImageValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasShareJobValue)
      {
        i = j + 1;
        if (shareJobValue._cachedId == null) {
          break label321;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareJobValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasShareVideoValue)
      {
        i = j + 1;
        if (shareVideoValue._cachedId == null) {
          break label334;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareVideoValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = shareTextValue.getSerializedSize() + 7;
      break;
      label282:
      i += shareArticleValue.getSerializedSize();
      break label93;
      label295:
      i += shareDocumentValue.getSerializedSize();
      break label135;
      label308:
      i += shareImageValue.getSerializedSize();
      break label177;
      label321:
      i += shareJobValue.getSerializedSize();
      break label219;
      label334:
      i += shareVideoValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (shareTextValue != null)
    {
      i = shareTextValue.hashCode();
      if (shareArticleValue == null) {
        break label154;
      }
      j = shareArticleValue.hashCode();
      if (shareDocumentValue == null) {
        break label159;
      }
      k = shareDocumentValue.hashCode();
      if (shareImageValue == null) {
        break label164;
      }
      m = shareImageValue.hashCode();
      label76:
      if (shareJobValue == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = shareJobValue.hashCode();; n = 0)
    {
      if (shareVideoValue != null) {
        i1 = shareVideoValue.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
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
    label290:
    label350:
    label410:
    label538:
    label563:
    label573:
    label598:
    label608:
    label633:
    label643:
    label668:
    label678:
    label703:
    label711:
    label713:
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
        localByteBuffer.putInt(1773021846);
        if (hasShareTextValue)
        {
          localByteBuffer.put((byte)1);
          if (shareTextValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareTextValue._cachedId);
            shareTextValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareArticleValue) {
              break label563;
            }
            localByteBuffer.put((byte)1);
            if (shareArticleValue._cachedId == null) {
              break label538;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareArticleValue._cachedId);
            shareArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareDocumentValue) {
              break label598;
            }
            localByteBuffer.put((byte)1);
            if (shareDocumentValue._cachedId == null) {
              break label573;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareDocumentValue._cachedId);
            shareDocumentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareImageValue) {
              break label633;
            }
            localByteBuffer.put((byte)1);
            if (shareImageValue._cachedId == null) {
              break label608;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareImageValue._cachedId);
            shareImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareJobValue) {
              break label668;
            }
            localByteBuffer.put((byte)1);
            if (shareJobValue._cachedId == null) {
              break label643;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareJobValue._cachedId);
            shareJobValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareVideoValue) {
              break label703;
            }
            localByteBuffer.put((byte)1);
            if (shareVideoValue._cachedId == null) {
              break label678;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareVideoValue._cachedId);
            shareVideoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label711;
          }
          if (str != null) {
            break label713;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          shareTextValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          shareArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          shareDocumentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          shareImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          shareJobValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label410;
          localByteBuffer.put((byte)0);
          break label410;
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
  
  public static final class Builder
  {
    private boolean hasShareArticleValue = false;
    private boolean hasShareDocumentValue = false;
    private boolean hasShareImageValue = false;
    private boolean hasShareJobValue = false;
    private boolean hasShareTextValue = false;
    private boolean hasShareVideoValue = false;
    private ShareArticle shareArticleValue = null;
    private ShareDocument shareDocumentValue = null;
    private ShareImage shareImageValue = null;
    private ShareJob shareJobValue = null;
    private ShareText shareTextValue = null;
    private ShareVideo shareVideoValue = null;
    
    public final ShareUpdateContent.Content build()
      throws BuilderException
    {
      int j = 0;
      if (hasShareTextValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasShareArticleValue) {
        i = j + 1;
      }
      j = i;
      if (hasShareDocumentValue) {
        j = i + 1;
      }
      i = j;
      if (hasShareImageValue) {
        i = j + 1;
      }
      j = i;
      if (hasShareJobValue) {
        j = i + 1;
      }
      i = j;
      if (hasShareVideoValue) {
        i = j + 1;
      }
      if (i > 1) {
        throw new UnionMemberCountException("Content", i);
      }
      return new ShareUpdateContent.Content(shareTextValue, shareArticleValue, shareDocumentValue, shareImageValue, shareJobValue, shareVideoValue, hasShareTextValue, hasShareArticleValue, hasShareDocumentValue, hasShareImageValue, hasShareJobValue, hasShareVideoValue);
    }
    
    public final Builder setShareArticleValue(ShareArticle paramShareArticle)
    {
      if (paramShareArticle == null)
      {
        hasShareArticleValue = false;
        shareArticleValue = null;
        return this;
      }
      hasShareArticleValue = true;
      shareArticleValue = paramShareArticle;
      return this;
    }
    
    public final Builder setShareImageValue(ShareImage paramShareImage)
    {
      if (paramShareImage == null)
      {
        hasShareImageValue = false;
        shareImageValue = null;
        return this;
      }
      hasShareImageValue = true;
      shareImageValue = paramShareImage;
      return this;
    }
    
    public final Builder setShareTextValue(ShareText paramShareText)
    {
      if (paramShareText == null)
      {
        hasShareTextValue = false;
        shareTextValue = null;
        return this;
      }
      hasShareTextValue = true;
      shareTextValue = paramShareText;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */