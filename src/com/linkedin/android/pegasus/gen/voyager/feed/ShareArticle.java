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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareArticle
  implements FissileDataModel<ShareArticle>, RecordTemplate<ShareArticle>
{
  public static final ShareArticleBuilder BUILDER = ShareArticleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final FeedMiniArticle article;
  public final ArticleType articleType;
  public final AttributedText attributedText;
  public final Author author;
  public final String description;
  public final boolean hasArticle;
  public final boolean hasArticleType;
  public final boolean hasAttributedText;
  public final boolean hasAuthor;
  public final boolean hasDescription;
  public final boolean hasImage;
  public final boolean hasPublisher;
  public final boolean hasResolvedUrl;
  public final boolean hasSubtitle;
  public final boolean hasText;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final boolean hasUrn;
  public final Image image;
  public final CompanyActor publisher;
  public final String resolvedUrl;
  public final String subtitle;
  public final AnnotatedText text;
  public final String title;
  public final String url;
  public final Urn urn;
  
  ShareArticle(Urn paramUrn, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AnnotatedText paramAnnotatedText, AttributedText paramAttributedText, Image paramImage, ArticleType paramArticleType, CompanyActor paramCompanyActor, Author paramAuthor, FeedMiniArticle paramFeedMiniArticle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    urn = paramUrn;
    title = paramString1;
    subtitle = paramString2;
    description = paramString3;
    url = paramString4;
    resolvedUrl = paramString5;
    text = paramAnnotatedText;
    attributedText = paramAttributedText;
    image = paramImage;
    articleType = paramArticleType;
    publisher = paramCompanyActor;
    author = paramAuthor;
    article = paramFeedMiniArticle;
    hasUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasSubtitle = paramBoolean3;
    hasDescription = paramBoolean4;
    hasUrl = paramBoolean5;
    hasResolvedUrl = paramBoolean6;
    hasText = paramBoolean7;
    hasAttributedText = paramBoolean8;
    hasImage = paramBoolean9;
    hasArticleType = paramBoolean10;
    hasPublisher = paramBoolean11;
    hasAuthor = paramBoolean12;
    hasArticle = paramBoolean13;
    _cachedId = null;
  }
  
  public final ShareArticle accept(DataProcessor paramDataProcessor)
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
    if (hasResolvedUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("resolvedUrl");
      paramDataProcessor.processString(resolvedUrl);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label214:
    Object localObject3;
    boolean bool2;
    label253:
    label264:
    Object localObject4;
    boolean bool3;
    label304:
    label316:
    Object localObject5;
    boolean bool4;
    label381:
    label393:
    Object localObject6;
    boolean bool5;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label555;
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
          break label564;
        }
        localObject1 = attributedText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label582;
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
          break label591;
        }
        localObject1 = image.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label609;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasArticleType)
      {
        paramDataProcessor.startRecordField$505cff1c("articleType");
        paramDataProcessor.processEnum(articleType);
      }
      localObject5 = null;
      bool4 = false;
      if (hasPublisher)
      {
        paramDataProcessor.startRecordField$505cff1c("publisher");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label619;
        }
        localObject1 = publisher.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label637;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasAuthor)
      {
        paramDataProcessor.startRecordField$505cff1c("author");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label647;
        }
        localObject1 = author.accept(paramDataProcessor);
        label433:
        if (localObject1 == null) {
          break label665;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label445:
      localObject1 = null;
      bool6 = false;
      if (hasArticle)
      {
        paramDataProcessor.startRecordField$505cff1c("article");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label675;
        }
        localObject1 = article.accept(paramDataProcessor);
        label485:
        if (localObject1 == null) {
          break label693;
        }
      }
    }
    label555:
    label564:
    label582:
    label591:
    label609:
    label619:
    label637:
    label647:
    label665:
    label675:
    label693:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label823;
      }
      try
      {
        if (hasTitle) {
          break label699;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label214;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label253;
      bool2 = false;
      localObject3 = localObject1;
      break label264;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label304;
      bool3 = false;
      localObject4 = localObject1;
      break label316;
      localObject1 = (CompanyActor)paramDataProcessor.processDataTemplate(publisher);
      break label381;
      bool4 = false;
      localObject5 = localObject1;
      break label393;
      localObject1 = (Author)paramDataProcessor.processDataTemplate(author);
      break label433;
      bool5 = false;
      localObject6 = localObject1;
      break label445;
      localObject1 = (FeedMiniArticle)paramDataProcessor.processDataTemplate(article);
      break label485;
    }
    label699:
    if (!hasUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "url");
    }
    if (!hasArticleType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "articleType");
    }
    return new ShareArticle(urn, title, subtitle, description, url, resolvedUrl, (AnnotatedText)localObject2, (AttributedText)localObject3, (Image)localObject4, articleType, (CompanyActor)localObject5, (Author)localObject6, (FeedMiniArticle)localObject1, hasUrn, hasTitle, hasSubtitle, hasDescription, hasUrl, hasResolvedUrl, bool1, bool2, bool3, hasArticleType, bool4, bool5, bool6);
    label823:
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
      paramObject = (ShareArticle)paramObject;
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
      if (resolvedUrl != null)
      {
        if (resolvedUrl.equals(resolvedUrl)) {}
      }
      else {
        while (resolvedUrl != null) {
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
      if (articleType != null)
      {
        if (articleType.equals(articleType)) {}
      }
      else {
        while (articleType != null) {
          return false;
        }
      }
      if (publisher != null)
      {
        if (publisher.equals(publisher)) {}
      }
      else {
        while (publisher != null) {
          return false;
        }
      }
      if (author != null)
      {
        if (author.equals(author)) {}
      }
      else {
        while (author != null) {
          return false;
        }
      }
      if (article == null) {
        break;
      }
    } while (article.equals(article));
    for (;;)
    {
      return false;
      if (article == null) {
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
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasResolvedUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(resolvedUrl);
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
          break label459;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
      label254:
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label472;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
      label296:
      j = i + 1;
      i = j;
      if (hasArticleType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasPublisher)
      {
        i = j + 1;
        if (publisher._cachedId == null) {
          break label485;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(publisher._cachedId);
      }
      label355:
      j = i + 1;
      i = j;
      if (hasAuthor)
      {
        i = j + 1;
        if (author._cachedId == null) {
          break label498;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(author._cachedId);
      }
      label397:
      j = i + 1;
      i = j;
      if (hasArticle)
      {
        i = j + 1;
        if (article._cachedId == null) {
          break label511;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(article._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += text.getSerializedSize();
      break;
      label459:
      i += attributedText.getSerializedSize();
      break label254;
      label472:
      i += image.getSerializedSize();
      break label296;
      label485:
      i += publisher.getSerializedSize();
      break label355;
      label498:
      i += author.getSerializedSize();
      break label397;
      label511:
      i += article.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i8 = 0;
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
    label124:
    int i3;
    label140:
    int i4;
    label156:
    int i5;
    label172:
    int i6;
    if (urn != null)
    {
      i = urn.hashCode();
      if (title == null) {
        break label308;
      }
      j = title.hashCode();
      if (subtitle == null) {
        break label313;
      }
      k = subtitle.hashCode();
      if (description == null) {
        break label318;
      }
      m = description.hashCode();
      if (url == null) {
        break label324;
      }
      n = url.hashCode();
      if (resolvedUrl == null) {
        break label330;
      }
      i1 = resolvedUrl.hashCode();
      if (text == null) {
        break label336;
      }
      i2 = text.hashCode();
      if (attributedText == null) {
        break label342;
      }
      i3 = attributedText.hashCode();
      if (image == null) {
        break label348;
      }
      i4 = image.hashCode();
      if (articleType == null) {
        break label354;
      }
      i5 = articleType.hashCode();
      if (publisher == null) {
        break label360;
      }
      i6 = publisher.hashCode();
      label188:
      if (author == null) {
        break label366;
      }
    }
    label308:
    label313:
    label318:
    label324:
    label330:
    label336:
    label342:
    label348:
    label354:
    label360:
    label366:
    for (int i7 = author.hashCode();; i7 = 0)
    {
      if (article != null) {
        i8 = article.hashCode();
      }
      i = (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i8;
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
      i3 = 0;
      break label140;
      i4 = 0;
      break label156;
      i5 = 0;
      break label172;
      i6 = 0;
      break label188;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareArticle");
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
    label276:
    label336:
    label396:
    label456:
    label485:
    label545:
    label605:
    label708:
    label718:
    label728:
    label738:
    label748:
    label758:
    label783:
    label793:
    label818:
    label828:
    label853:
    label863:
    label873:
    label898:
    label908:
    label933:
    label943:
    label968:
    label976:
    label978:
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
        localByteBuffer.putInt(-590692565);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasTitle) {
            break label708;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasSubtitle) {
            break label718;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subtitle);
          if (!hasDescription) {
            break label728;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasUrl) {
            break label738;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasResolvedUrl) {
            break label748;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, resolvedUrl);
          if (!hasText) {
            break label783;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label758;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAttributedText) {
            break label818;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label793;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasImage) {
            break label853;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label828;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasArticleType) {
            break label863;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, articleType.ordinal());
          if (!hasPublisher) {
            break label898;
          }
          localByteBuffer.put((byte)1);
          if (publisher._cachedId == null) {
            break label873;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, publisher._cachedId);
          publisher.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAuthor) {
            break label933;
          }
          localByteBuffer.put((byte)1);
          if (author._cachedId == null) {
            break label908;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, author._cachedId);
          author.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasArticle) {
            break label968;
          }
          localByteBuffer.put((byte)1);
          if (article._cachedId == null) {
            break label943;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, article._cachedId);
          article.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label976;
          }
          if (str != null) {
            break label978;
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
          localByteBuffer.put((byte)0);
          break label276;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label336;
          localByteBuffer.put((byte)0);
          break label336;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label396;
          localByteBuffer.put((byte)0);
          break label396;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label456;
          localByteBuffer.put((byte)0);
          break label456;
          localByteBuffer.put((byte)0);
          break label485;
          localByteBuffer.put((byte)1);
          publisher.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label545;
          localByteBuffer.put((byte)0);
          break label545;
          localByteBuffer.put((byte)1);
          author.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label605;
          localByteBuffer.put((byte)0);
          break label605;
          localByteBuffer.put((byte)1);
          article.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Author
    implements FissileDataModel<Author>, UnionTemplate<Author>
  {
    public static final ShareArticleBuilder.AuthorBuilder BUILDER = ShareArticleBuilder.AuthorBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final ExternalAuthor externalAuthorValue;
    public final boolean hasExternalAuthorValue;
    public final boolean hasInfluencerActorValue;
    public final boolean hasMemberActorValue;
    public final InfluencerActor influencerActorValue;
    public final MemberActor memberActorValue;
    
    Author(ExternalAuthor paramExternalAuthor, InfluencerActor paramInfluencerActor, MemberActor paramMemberActor, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      externalAuthorValue = paramExternalAuthor;
      influencerActorValue = paramInfluencerActor;
      memberActorValue = paramMemberActor;
      hasExternalAuthorValue = paramBoolean1;
      hasInfluencerActorValue = paramBoolean2;
      hasMemberActorValue = paramBoolean3;
      _cachedId = null;
    }
    
    public final Author accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      if (hasExternalAuthorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ExternalAuthor");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = externalAuthorValue.accept(paramDataProcessor);
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
        if (hasInfluencerActorValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.InfluencerActor");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label214;
          }
          localObject1 = influencerActorValue.accept(paramDataProcessor);
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
        if (hasMemberActorValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.MemberActor");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label241;
          }
          localObject1 = memberActorValue.accept(paramDataProcessor);
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
        return new Author((ExternalAuthor)localObject2, (InfluencerActor)localObject3, (MemberActor)localObject1, bool1, bool2, bool3);
        localObject1 = (ExternalAuthor)paramDataProcessor.processDataTemplate(externalAuthorValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (InfluencerActor)paramDataProcessor.processDataTemplate(influencerActorValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (MemberActor)paramDataProcessor.processDataTemplate(memberActorValue);
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
        paramObject = (Author)paramObject;
        if (externalAuthorValue != null)
        {
          if (externalAuthorValue.equals(externalAuthorValue)) {}
        }
        else {
          while (externalAuthorValue != null) {
            return false;
          }
        }
        if (influencerActorValue != null)
        {
          if (influencerActorValue.equals(influencerActorValue)) {}
        }
        else {
          while (influencerActorValue != null) {
            return false;
          }
        }
        if (memberActorValue == null) {
          break;
        }
      } while (memberActorValue.equals(memberActorValue));
      for (;;)
      {
        return false;
        if (memberActorValue == null) {
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
      if (hasExternalAuthorValue)
      {
        if (externalAuthorValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(externalAuthorValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasInfluencerActorValue)
        {
          i = j + 1;
          if (influencerActorValue._cachedId == null) {
            break label156;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(influencerActorValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasMemberActorValue)
        {
          i = j + 1;
          if (memberActorValue._cachedId == null) {
            break label169;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(memberActorValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = externalAuthorValue.getSerializedSize() + 7;
        break;
        label156:
        i += influencerActorValue.getSerializedSize();
        break label93;
        label169:
        i += memberActorValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (externalAuthorValue != null)
      {
        i = externalAuthorValue.hashCode();
        if (influencerActorValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = influencerActorValue.hashCode();; j = 0)
      {
        if (memberActorValue != null) {
          k = memberActorValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Author");
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
          localByteBuffer.putInt(-1731124413);
          if (hasExternalAuthorValue)
          {
            localByteBuffer.put((byte)1);
            if (externalAuthorValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, externalAuthorValue._cachedId);
              externalAuthorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInfluencerActorValue) {
                break label383;
              }
              localByteBuffer.put((byte)1);
              if (influencerActorValue._cachedId == null) {
                break label358;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, influencerActorValue._cachedId);
              influencerActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMemberActorValue) {
                break label418;
              }
              localByteBuffer.put((byte)1);
              if (memberActorValue._cachedId == null) {
                break label393;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, memberActorValue._cachedId);
              memberActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            externalAuthorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            influencerActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            memberActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<ShareArticle>
  {
    private FeedMiniArticle article = null;
    public ArticleType articleType = null;
    private AttributedText attributedText = null;
    private ShareArticle.Author author = null;
    public String description = null;
    private boolean hasArticle = false;
    public boolean hasArticleType = false;
    private boolean hasAttributedText = false;
    private boolean hasAuthor = false;
    public boolean hasDescription = false;
    public boolean hasImage = false;
    private boolean hasPublisher = false;
    public boolean hasResolvedUrl = false;
    public boolean hasSubtitle = false;
    private boolean hasText = false;
    public boolean hasTitle = false;
    public boolean hasUrl = false;
    public boolean hasUrn = false;
    public Image image = null;
    private CompanyActor publisher = null;
    public String resolvedUrl = null;
    public String subtitle = null;
    private AnnotatedText text = null;
    public String title = null;
    public String url = null;
    public Urn urn = null;
    
    public Builder() {}
    
    public Builder(ShareArticle paramShareArticle)
    {
      urn = urn;
      title = title;
      subtitle = subtitle;
      description = description;
      url = url;
      resolvedUrl = resolvedUrl;
      text = text;
      attributedText = attributedText;
      image = image;
      articleType = articleType;
      publisher = publisher;
      author = author;
      article = article;
      hasUrn = hasUrn;
      hasTitle = hasTitle;
      hasSubtitle = hasSubtitle;
      hasDescription = hasDescription;
      hasUrl = hasUrl;
      hasResolvedUrl = hasResolvedUrl;
      hasText = hasText;
      hasAttributedText = hasAttributedText;
      hasImage = hasImage;
      hasArticleType = hasArticleType;
      hasPublisher = hasPublisher;
      hasAuthor = hasAuthor;
      hasArticle = hasArticle;
    }
    
    public final ShareArticle build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ShareArticle.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ShareArticle(urn, title, subtitle, description, url, resolvedUrl, text, attributedText, image, articleType, publisher, author, article, hasUrn, hasTitle, hasSubtitle, hasDescription, hasUrl, hasResolvedUrl, hasText, hasAttributedText, hasImage, hasArticleType, hasPublisher, hasAuthor, hasArticle);
        if (!hasTitle) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "title");
        }
        if (!hasUrl) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "url");
        }
      } while (hasArticleType);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle", "articleType");
    }
    
    public final Builder setText(AnnotatedText paramAnnotatedText)
    {
      if (paramAnnotatedText == null)
      {
        hasText = false;
        text = null;
        return this;
      }
      hasText = true;
      text = paramAnnotatedText;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */