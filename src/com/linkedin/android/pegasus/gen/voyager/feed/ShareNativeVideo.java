package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareNativeVideo
  implements FissileDataModel<ShareNativeVideo>, RecordTemplate<ShareNativeVideo>
{
  public static final ShareNativeVideoBuilder BUILDER = ShareNativeVideoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText attributedText;
  public final String description;
  public final boolean hasAttributedText;
  public final boolean hasDescription;
  public final boolean hasSubtitle;
  public final boolean hasText;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final boolean hasUrn;
  public final boolean hasVideoPlayMetadata;
  public final String subtitle;
  public final AnnotatedText text;
  public final String title;
  public final String url;
  public final Urn urn;
  public final VideoPlayMetadata videoPlayMetadata;
  
  ShareNativeVideo(Urn paramUrn, String paramString1, String paramString2, String paramString3, VideoPlayMetadata paramVideoPlayMetadata, AnnotatedText paramAnnotatedText, AttributedText paramAttributedText, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    urn = paramUrn;
    title = paramString1;
    subtitle = paramString2;
    description = paramString3;
    videoPlayMetadata = paramVideoPlayMetadata;
    text = paramAnnotatedText;
    attributedText = paramAttributedText;
    url = paramString4;
    hasUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasSubtitle = paramBoolean3;
    hasDescription = paramBoolean4;
    hasVideoPlayMetadata = paramBoolean5;
    hasText = paramBoolean6;
    hasAttributedText = paramBoolean7;
    hasUrl = paramBoolean8;
    _cachedId = null;
  }
  
  public final ShareNativeVideo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasSubtitle)
    {
      paramDataProcessor.startRecordField$505cff1c("subtitle");
      paramDataProcessor.processString(subtitle);
    }
    if (hasDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("description");
      paramDataProcessor.processString(description);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label164:
    Object localObject3;
    boolean bool2;
    if (hasVideoPlayMetadata)
    {
      paramDataProcessor.startRecordField$505cff1c("videoPlayMetadata");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = videoPlayMetadata.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label349;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label358;
        }
        localObject1 = text.accept(paramDataProcessor);
        label203:
        if (localObject1 == null) {
          break label376;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label214:
      localObject1 = null;
      bool3 = false;
      if (hasAttributedText)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label385;
        }
        localObject1 = attributedText.accept(paramDataProcessor);
        label254:
        if (localObject1 == null) {
          break label403;
        }
      }
    }
    label349:
    label358:
    label376:
    label385:
    label403:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("url");
        paramDataProcessor.processString(url);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label486;
      }
      try
      {
        if (hasUrn) {
          break label409;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo", "urn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (VideoPlayMetadata)paramDataProcessor.processDataTemplate(videoPlayMetadata);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label164;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break label203;
      bool2 = false;
      localObject3 = localObject1;
      break label214;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label254;
    }
    label409:
    if (!hasVideoPlayMetadata) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo", "videoPlayMetadata");
    }
    return new ShareNativeVideo(urn, title, subtitle, description, (VideoPlayMetadata)localObject2, (AnnotatedText)localObject3, (AttributedText)localObject1, url, hasUrn, hasTitle, hasSubtitle, hasDescription, bool1, bool2, bool3, hasUrl);
    label486:
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
      paramObject = (ShareNativeVideo)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (subtitle != null)
      {
        if (subtitle.equals(subtitle)) {}
      }
      else {
        while (subtitle != null) {
          return false;
        }
      }
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (videoPlayMetadata != null)
      {
        if (videoPlayMetadata.equals(videoPlayMetadata)) {}
      }
      else {
        while (videoPlayMetadata != null) {
          return false;
        }
      }
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributedText != null)
      {
        if (attributedText.equals(attributedText)) {}
      }
      else {
        while (attributedText != null) {
          return false;
        }
      }
      if (url == null) {
        break;
      }
    } while (url.equals(url));
    for (;;)
    {
      return false;
      if (url == null) {
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
    if (hasUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasSubtitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subtitle);
    }
    j = i + 1;
    i = j;
    if (hasDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
    }
    j = i + 1;
    i = j;
    if (hasVideoPlayMetadata) {
      i = j + 1 + videoPlayMetadata.getSerializedSize();
    }
    j = i + 1;
    i = j;
    if (hasText)
    {
      i = j + 1;
      if (text._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasAttributedText)
      {
        i = j + 1;
        if (attributedText._cachedId == null) {
          break label274;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
      }
      __sizeOfObject = i;
      return i;
      i += text.getSerializedSize();
      break;
      label274:
      i += attributedText.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i1;
    if (urn != null)
    {
      i = urn.hashCode();
      if (title == null) {
        break label198;
      }
      j = title.hashCode();
      if (subtitle == null) {
        break label203;
      }
      k = subtitle.hashCode();
      if (description == null) {
        break label208;
      }
      m = description.hashCode();
      if (videoPlayMetadata == null) {
        break label214;
      }
      n = videoPlayMetadata.hashCode();
      if (text == null) {
        break label220;
      }
      i1 = text.hashCode();
      label108:
      if (attributedText == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = attributedText.hashCode();; i2 = 0)
    {
      if (url != null) {
        i3 = url.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
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
      n = 0;
      break label92;
      i1 = 0;
      break label108;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareNativeVideo");
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
    label170:
    label196:
    label222:
    label258:
    label318:
    label378:
    label447:
    label457:
    label467:
    label477:
    label487:
    label512:
    label522:
    label547:
    label557:
    label565:
    label567:
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
        localByteBuffer.putInt(1118259436);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasTitle) {
            break label447;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasSubtitle) {
            break label457;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subtitle);
          if (!hasDescription) {
            break label467;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasVideoPlayMetadata) {
            break label477;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.put((byte)1);
          videoPlayMetadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          if (!hasText) {
            break label512;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label487;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAttributedText) {
            break label547;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label522;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasUrl) {
            break label557;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label565;
          }
          if (str != null) {
            break label567;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label258;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label318;
          localByteBuffer.put((byte)0);
          break label318;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label378;
          localByteBuffer.put((byte)0);
          break label378;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */