package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TreasuryMedia$Data
  implements FissileDataModel<Data>, UnionTemplate<Data>
{
  public static final TreasuryMediaBuilder.DataBuilder BUILDER = TreasuryMediaBuilder.DataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLinkValue;
  public final boolean hasMediaProxyImageValue;
  public final boolean hasRichTextValue;
  public final boolean hasVideoValue;
  public final Link linkValue;
  public final MediaProxyImage mediaProxyImageValue;
  public final RichText richTextValue;
  public final Video videoValue;
  
  public TreasuryMedia$Data(Video paramVideo, MediaProxyImage paramMediaProxyImage, RichText paramRichText, Link paramLink, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    videoValue = paramVideo;
    mediaProxyImageValue = paramMediaProxyImage;
    richTextValue = paramRichText;
    linkValue = paramLink;
    hasVideoValue = paramBoolean1;
    hasMediaProxyImageValue = paramBoolean2;
    hasRichTextValue = paramBoolean3;
    hasLinkValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final Data accept(DataProcessor paramDataProcessor)
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
    if (hasVideoValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.treasury.Video");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = videoValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label261;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasMediaProxyImageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.MediaProxyImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = mediaProxyImageValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasRichTextValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.treasury.RichText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = richTextValue.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label315;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasLinkValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.treasury.Link");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = linkValue.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label343;
        }
      }
    }
    label261:
    label270:
    label288:
    label297:
    label315:
    label325:
    label343:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label349;
      }
      return new Data((Video)localObject2, (MediaProxyImage)localObject3, (RichText)localObject4, (Link)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (Video)paramDataProcessor.processDataTemplate(videoValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MediaProxyImage)paramDataProcessor.processDataTemplate(mediaProxyImageValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(richTextValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (Link)paramDataProcessor.processDataTemplate(linkValue);
      break label198;
    }
    label349:
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
      paramObject = (Data)paramObject;
      if (videoValue != null)
      {
        if (videoValue.equals(videoValue)) {}
      }
      else {
        while (videoValue != null) {
          return false;
        }
      }
      if (mediaProxyImageValue != null)
      {
        if (mediaProxyImageValue.equals(mediaProxyImageValue)) {}
      }
      else {
        while (mediaProxyImageValue != null) {
          return false;
        }
      }
      if (richTextValue != null)
      {
        if (richTextValue.equals(richTextValue)) {}
      }
      else {
        while (richTextValue != null) {
          return false;
        }
      }
      if (linkValue == null) {
        break;
      }
    } while (linkValue.equals(linkValue));
    for (;;)
    {
      return false;
      if (linkValue == null) {
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
    if (hasVideoValue)
    {
      if (videoValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(videoValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasMediaProxyImageValue)
      {
        i = j + 1;
        if (mediaProxyImageValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(mediaProxyImageValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasRichTextValue)
      {
        i = j + 1;
        if (richTextValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(richTextValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasLinkValue)
      {
        i = j + 1;
        if (linkValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(linkValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = videoValue.getSerializedSize() + 7;
      break;
      label198:
      i += mediaProxyImageValue.getSerializedSize();
      break label93;
      label211:
      i += richTextValue.getSerializedSize();
      break label135;
      label224:
      i += linkValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (videoValue != null)
    {
      i = videoValue.hashCode();
      if (mediaProxyImageValue == null) {
        break label110;
      }
      j = mediaProxyImageValue.hashCode();
      label45:
      if (richTextValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = richTextValue.hashCode();; k = 0)
    {
      if (linkValue != null) {
        m = linkValue.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Data");
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
    label418:
    label443:
    label453:
    label478:
    label488:
    label513:
    label521:
    label523:
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
        localByteBuffer.putInt(-1333573818);
        if (hasVideoValue)
        {
          localByteBuffer.put((byte)1);
          if (videoValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, videoValue._cachedId);
            videoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMediaProxyImageValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (mediaProxyImageValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mediaProxyImageValue._cachedId);
            mediaProxyImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRichTextValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (richTextValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, richTextValue._cachedId);
            richTextValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLinkValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (linkValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, linkValue._cachedId);
            linkValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label521;
          }
          if (str != null) {
            break label523;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          videoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          mediaProxyImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          richTextValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          linkValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    public boolean hasLinkValue = false;
    public boolean hasMediaProxyImageValue = false;
    public boolean hasRichTextValue = false;
    public boolean hasVideoValue = false;
    public Link linkValue = null;
    public MediaProxyImage mediaProxyImageValue = null;
    public RichText richTextValue = null;
    public Video videoValue = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia.Data
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */