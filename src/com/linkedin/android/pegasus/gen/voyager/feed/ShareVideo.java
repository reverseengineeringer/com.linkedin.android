package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.FeedMiniArticle;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareVideo
  implements FissileDataModel<ShareVideo>, RecordTemplate<ShareVideo>
{
  public static final ShareVideoBuilder BUILDER = ShareVideoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FeedMiniArticle article;
  public final AttributedText attributedText;
  public final String description;
  public final long duration;
  public final boolean hasArticle;
  public final boolean hasAttributedText;
  public final boolean hasDescription;
  public final boolean hasDuration;
  public final boolean hasImage;
  public final boolean hasNumViews;
  public final boolean hasSubtitle;
  public final boolean hasText;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final boolean hasUrn;
  public final Image image;
  public final int numViews;
  public final String subtitle;
  public final AnnotatedText text;
  public final String title;
  public final String url;
  public final Urn urn;
  
  ShareVideo(Urn paramUrn, String paramString1, String paramString2, String paramString3, String paramString4, AnnotatedText paramAnnotatedText, AttributedText paramAttributedText, Image paramImage, FeedMiniArticle paramFeedMiniArticle, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    urn = paramUrn;
    title = paramString1;
    subtitle = paramString2;
    description = paramString3;
    url = paramString4;
    text = paramAnnotatedText;
    attributedText = paramAttributedText;
    image = paramImage;
    article = paramFeedMiniArticle;
    duration = paramLong;
    numViews = paramInt;
    hasUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasSubtitle = paramBoolean3;
    hasDescription = paramBoolean4;
    hasUrl = paramBoolean5;
    hasText = paramBoolean6;
    hasAttributedText = paramBoolean7;
    hasImage = paramBoolean8;
    hasArticle = paramBoolean9;
    hasDuration = paramBoolean10;
    hasNumViews = paramBoolean11;
    _cachedId = null;
  }
  
  public final ShareVideo accept(DataProcessor paramDataProcessor)
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
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label189:
    Object localObject3;
    boolean bool2;
    label228:
    label239:
    Object localObject4;
    boolean bool3;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label451;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasAttributedText)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label460;
        }
        localObject1 = attributedText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label478;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label487;
        }
        localObject1 = image.accept(paramDataProcessor);
        label279:
        if (localObject1 == null) {
          break label505;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label291:
      localObject1 = null;
      bool4 = false;
      if (hasArticle)
      {
        paramDataProcessor.startRecordField$505cff1c("article");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label515;
        }
        localObject1 = article.accept(paramDataProcessor);
        label331:
        if (localObject1 == null) {
          break label533;
        }
      }
    }
    label451:
    label460:
    label478:
    label487:
    label505:
    label515:
    label533:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasDuration)
      {
        paramDataProcessor.startRecordField$505cff1c("duration");
        paramDataProcessor.processLong(duration);
      }
      if (hasNumViews)
      {
        paramDataProcessor.startRecordField$505cff1c("numViews");
        paramDataProcessor.processInt(numViews);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label636;
      }
      try
      {
        if (hasTitle) {
          break label539;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label189;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label228;
      bool2 = false;
      localObject3 = localObject1;
      break label239;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label279;
      bool3 = false;
      localObject4 = localObject1;
      break label291;
      localObject1 = (FeedMiniArticle)paramDataProcessor.processDataTemplate(article);
      break label331;
    }
    label539:
    if (!hasUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo", "url");
    }
    return new ShareVideo(urn, title, subtitle, description, url, (AnnotatedText)localObject2, (AttributedText)localObject3, (Image)localObject4, (FeedMiniArticle)localObject1, duration, numViews, hasUrn, hasTitle, hasSubtitle, hasDescription, hasUrl, bool1, bool2, bool3, bool4, hasDuration, hasNumViews);
    label636:
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
      paramObject = (ShareVideo)paramObject;
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
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
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
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
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
      if (duration != duration) {
        return false;
      }
    } while (numViews == numViews);
    return false;
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
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
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
          break label368;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
      label229:
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label381;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
      label271:
      j = i + 1;
      i = j;
      if (hasArticle)
      {
        i = j + 1;
        if (article._cachedId == null) {
          break label394;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(article._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasDuration) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasNumViews) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      i += text.getSerializedSize();
      break;
      label368:
      i += attributedText.getSerializedSize();
      break label229;
      label381:
      i += image.getSerializedSize();
      break label271;
      label394:
      i += article.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
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
    label108:
    int i2;
    if (urn != null)
    {
      i = urn.hashCode();
      if (title == null) {
        break label245;
      }
      j = title.hashCode();
      if (subtitle == null) {
        break label250;
      }
      k = subtitle.hashCode();
      if (description == null) {
        break label255;
      }
      m = description.hashCode();
      if (url == null) {
        break label261;
      }
      n = url.hashCode();
      if (text == null) {
        break label267;
      }
      i1 = text.hashCode();
      if (attributedText == null) {
        break label273;
      }
      i2 = attributedText.hashCode();
      label124:
      if (image == null) {
        break label279;
      }
    }
    label245:
    label250:
    label255:
    label261:
    label267:
    label273:
    label279:
    for (int i3 = image.hashCode();; i3 = 0)
    {
      if (article != null) {
        i4 = article.hashCode();
      }
      i = (((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + (int)(duration ^ duration >>> 32)) * 31 + numViews;
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
      i2 = 0;
      break label124;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareVideo");
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
    label172:
    label198:
    label224:
    label250:
    label310:
    label370:
    label430:
    label490:
    label514:
    label581:
    label591:
    label601:
    label611:
    label621:
    label646:
    label656:
    label681:
    label691:
    label716:
    label726:
    label751:
    label761:
    label771:
    label779:
    label781:
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
        localByteBuffer.putInt(-1024219790);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasTitle) {
            break label581;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasSubtitle) {
            break label591;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subtitle);
          if (!hasDescription) {
            break label601;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasUrl) {
            break label611;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasText) {
            break label646;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label621;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAttributedText) {
            break label681;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label656;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasImage) {
            break label716;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label691;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasArticle) {
            break label751;
          }
          localByteBuffer.put((byte)1);
          if (article._cachedId == null) {
            break label726;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, article._cachedId);
          article.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDuration) {
            break label761;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(duration);
          if (!hasNumViews) {
            break label771;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numViews);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label779;
          }
          if (str != null) {
            break label781;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label172;
          localByteBuffer.put((byte)0);
          break label198;
          localByteBuffer.put((byte)0);
          break label224;
          localByteBuffer.put((byte)0);
          break label250;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label310;
          localByteBuffer.put((byte)0);
          break label310;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label370;
          localByteBuffer.put((byte)0);
          break label370;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label430;
          localByteBuffer.put((byte)0);
          break label430;
          localByteBuffer.put((byte)1);
          article.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label490;
          localByteBuffer.put((byte)0);
          break label490;
          localByteBuffer.put((byte)0);
          break label514;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareVideo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */