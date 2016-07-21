package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DiscussionWithArticle
  implements FissileDataModel<DiscussionWithArticle>, RecordTemplate<DiscussionWithArticle>
{
  public static final DiscussionWithArticleBuilder BUILDER = DiscussionWithArticleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AnnotatedText body;
  public final String contentDescription;
  public final String contentId;
  public final Image contentImage;
  public final String contentSource;
  public final String contentTitle;
  public final String contentUrl;
  public final Urn contentUrn;
  public final boolean hasBody;
  public final boolean hasContentDescription;
  public final boolean hasContentId;
  public final boolean hasContentImage;
  public final boolean hasContentSource;
  public final boolean hasContentTitle;
  public final boolean hasContentUrl;
  public final boolean hasContentUrn;
  public final boolean hasTitle;
  public final String title;
  
  DiscussionWithArticle(String paramString1, AnnotatedText paramAnnotatedText, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Image paramImage, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    title = paramString1;
    body = paramAnnotatedText;
    contentId = paramString2;
    contentUrl = paramString3;
    contentTitle = paramString4;
    contentSource = paramString5;
    contentDescription = paramString6;
    contentImage = paramImage;
    contentUrn = paramUrn;
    hasTitle = paramBoolean1;
    hasBody = paramBoolean2;
    hasContentId = paramBoolean3;
    hasContentUrl = paramBoolean4;
    hasContentTitle = paramBoolean5;
    hasContentSource = paramBoolean6;
    hasContentDescription = paramBoolean7;
    hasContentImage = paramBoolean8;
    hasContentUrn = paramBoolean9;
    _cachedId = null;
  }
  
  public final DiscussionWithArticle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = body.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label347;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label81:
      if (hasContentId)
      {
        paramDataProcessor.startRecordField$505cff1c("contentId");
        paramDataProcessor.processString(contentId);
      }
      if (hasContentUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("contentUrl");
        paramDataProcessor.processString(contentUrl);
      }
      if (hasContentTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("contentTitle");
        paramDataProcessor.processString(contentTitle);
      }
      if (hasContentSource)
      {
        paramDataProcessor.startRecordField$505cff1c("contentSource");
        paramDataProcessor.processString(contentSource);
      }
      if (hasContentDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("contentDescription");
        paramDataProcessor.processString(contentDescription);
      }
      localObject1 = null;
      bool2 = false;
      if (hasContentImage)
      {
        paramDataProcessor.startRecordField$505cff1c("contentImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label356;
        }
        localObject1 = contentImage.accept(paramDataProcessor);
        label245:
        if (localObject1 == null) {
          break label374;
        }
      }
    }
    label347:
    label356:
    label374:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasContentUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("contentUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(contentUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label525;
      }
      try
      {
        if (hasTitle) {
          break label379;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(body);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(contentImage);
      break label245;
    }
    label379:
    if (!hasContentId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentId");
    }
    if (!hasContentUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentUrl");
    }
    if (!hasContentTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentTitle");
    }
    if (!hasContentSource) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentSource");
    }
    return new DiscussionWithArticle(title, (AnnotatedText)localObject2, contentId, contentUrl, contentTitle, contentSource, contentDescription, (Image)localObject1, contentUrn, hasTitle, bool1, hasContentId, hasContentUrl, hasContentTitle, hasContentSource, hasContentDescription, bool2, hasContentUrn);
    label525:
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
      paramObject = (DiscussionWithArticle)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (contentId != null)
      {
        if (contentId.equals(contentId)) {}
      }
      else {
        while (contentId != null) {
          return false;
        }
      }
      if (contentUrl != null)
      {
        if (contentUrl.equals(contentUrl)) {}
      }
      else {
        while (contentUrl != null) {
          return false;
        }
      }
      if (contentTitle != null)
      {
        if (contentTitle.equals(contentTitle)) {}
      }
      else {
        while (contentTitle != null) {
          return false;
        }
      }
      if (contentSource != null)
      {
        if (contentSource.equals(contentSource)) {}
      }
      else {
        while (contentSource != null) {
          return false;
        }
      }
      if (contentDescription != null)
      {
        if (contentDescription.equals(contentDescription)) {}
      }
      else {
        while (contentDescription != null) {
          return false;
        }
      }
      if (contentImage != null)
      {
        if (contentImage.equals(contentImage)) {}
      }
      else {
        while (contentImage != null) {
          return false;
        }
      }
      if (contentUrn == null) {
        break;
      }
    } while (contentUrn.equals(contentUrn));
    for (;;)
    {
      return false;
      if (contentUrn == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBody)
    {
      i = j + 1;
      if (body._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(body._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasContentId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentId);
      }
      j = i + 1;
      i = j;
      if (hasContentUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentUrl);
      }
      j = i + 1;
      i = j;
      if (hasContentTitle) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentTitle);
      }
      j = i + 1;
      i = j;
      if (hasContentSource) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentSource);
      }
      j = i + 1;
      i = j;
      if (hasContentDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentDescription);
      }
      j = i + 1;
      i = j;
      if (hasContentImage)
      {
        i = j + 1;
        if (contentImage._cachedId == null) {
          break label299;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(contentImage._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasContentUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(contentUrn));
      }
      __sizeOfObject = i;
      return i;
      i += body.getSerializedSize();
      break;
      label299:
      i += contentImage.getSerializedSize();
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
    if (title != null)
    {
      i = title.hashCode();
      if (body == null) {
        break label220;
      }
      j = body.hashCode();
      if (contentId == null) {
        break label225;
      }
      k = contentId.hashCode();
      if (contentUrl == null) {
        break label230;
      }
      m = contentUrl.hashCode();
      if (contentTitle == null) {
        break label236;
      }
      n = contentTitle.hashCode();
      if (contentSource == null) {
        break label242;
      }
      i1 = contentSource.hashCode();
      if (contentDescription == null) {
        break label248;
      }
      i2 = contentDescription.hashCode();
      label124:
      if (contentImage == null) {
        break label254;
      }
    }
    label220:
    label225:
    label230:
    label236:
    label242:
    label248:
    label254:
    for (int i3 = contentImage.hashCode();; i3 = 0)
    {
      if (contentUrn != null) {
        i4 = contentUrn.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DiscussionWithArticle");
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
    label196:
    label222:
    label248:
    label274:
    label300:
    label326:
    label386:
    label463:
    label488:
    label498:
    label508:
    label518:
    label528:
    label538:
    label548:
    label573:
    label583:
    label591:
    label593:
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
        localByteBuffer.putInt(-1659766364);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasBody) {
            break label488;
          }
          localByteBuffer.put((byte)1);
          if (body._cachedId == null) {
            break label463;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, body._cachedId);
          body.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasContentId) {
            break label498;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentId);
          if (!hasContentUrl) {
            break label508;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentUrl);
          if (!hasContentTitle) {
            break label518;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentTitle);
          if (!hasContentSource) {
            break label528;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentSource);
          if (!hasContentDescription) {
            break label538;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentDescription);
          if (!hasContentImage) {
            break label573;
          }
          localByteBuffer.put((byte)1);
          if (contentImage._cachedId == null) {
            break label548;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, contentImage._cachedId);
          contentImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasContentUrn) {
            break label583;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(contentUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label591;
          }
          if (str != null) {
            break label593;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          body.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label196;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label248;
          localByteBuffer.put((byte)0);
          break label274;
          localByteBuffer.put((byte)0);
          break label300;
          localByteBuffer.put((byte)0);
          break label326;
          localByteBuffer.put((byte)1);
          contentImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label386;
          localByteBuffer.put((byte)0);
          break label386;
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
    implements RecordTemplateBuilder<DiscussionWithArticle>
  {
    public AnnotatedText body = null;
    public String contentDescription = null;
    public String contentId = null;
    public Image contentImage = null;
    public String contentSource = null;
    public String contentTitle = null;
    public String contentUrl = null;
    public Urn contentUrn = null;
    public boolean hasBody = false;
    public boolean hasContentDescription = false;
    public boolean hasContentId = false;
    public boolean hasContentImage = false;
    public boolean hasContentSource = false;
    public boolean hasContentTitle = false;
    public boolean hasContentUrl = false;
    public boolean hasContentUrn = false;
    public boolean hasTitle = false;
    public String title = null;
    
    public final DiscussionWithArticle build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (DiscussionWithArticle.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new DiscussionWithArticle(title, body, contentId, contentUrl, contentTitle, contentSource, contentDescription, contentImage, contentUrn, hasTitle, hasBody, hasContentId, hasContentUrl, hasContentTitle, hasContentSource, hasContentDescription, hasContentImage, hasContentUrn);
        if (!hasTitle) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "title");
        }
        if (!hasContentId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentId");
        }
        if (!hasContentUrl) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentUrl");
        }
        if (!hasContentTitle) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentTitle");
        }
      } while (hasContentSource);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle", "contentSource");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */