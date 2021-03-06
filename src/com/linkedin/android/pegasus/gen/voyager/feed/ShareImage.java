package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
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

public final class ShareImage
  implements FissileDataModel<ShareImage>, RecordTemplate<ShareImage>
{
  public static final ShareImageBuilder BUILDER = ShareImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText attributedText;
  public final String contentType;
  public final String fileId;
  public final boolean hasAttributedText;
  public final boolean hasContentType;
  public final boolean hasFileId;
  public final boolean hasImage;
  public final boolean hasOriginalImage;
  public final boolean hasText;
  public final Image image;
  public final Image originalImage;
  public final AnnotatedText text;
  
  ShareImage(AnnotatedText paramAnnotatedText, AttributedText paramAttributedText, Image paramImage1, Image paramImage2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    text = paramAnnotatedText;
    attributedText = paramAttributedText;
    image = paramImage1;
    originalImage = paramImage2;
    contentType = paramString1;
    fileId = paramString2;
    hasText = paramBoolean1;
    hasAttributedText = paramBoolean2;
    hasImage = paramBoolean3;
    hasOriginalImage = paramBoolean4;
    hasContentType = paramBoolean5;
    hasFileId = paramBoolean6;
    _cachedId = null;
  }
  
  public final ShareImage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
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
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label318;
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
          break label327;
        }
        localObject1 = attributedText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label345;
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
          break label354;
        }
        localObject1 = image.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label372;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasOriginalImage)
      {
        paramDataProcessor.startRecordField$505cff1c("originalImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label382;
        }
        localObject1 = originalImage.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label400;
        }
      }
    }
    label318:
    label327:
    label345:
    label354:
    label372:
    label382:
    label400:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasContentType)
      {
        paramDataProcessor.startRecordField$505cff1c("contentType");
        paramDataProcessor.processString(contentType);
      }
      if (hasFileId)
      {
        paramDataProcessor.startRecordField$505cff1c("fileId");
        paramDataProcessor.processString(fileId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label463;
      }
      try
      {
        if (hasImage) {
          break label406;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareImage", "image");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(originalImage);
      break label198;
    }
    label406:
    if (!hasFileId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareImage", "fileId");
    }
    return new ShareImage((AnnotatedText)localObject2, (AttributedText)localObject3, (Image)localObject4, (Image)localObject1, contentType, fileId, bool1, bool2, bool3, bool4, hasContentType, hasFileId);
    label463:
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
      paramObject = (ShareImage)paramObject;
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
      if (originalImage != null)
      {
        if (originalImage.equals(originalImage)) {}
      }
      else {
        while (originalImage != null) {
          return false;
        }
      }
      if (contentType != null)
      {
        if (contentType.equals(contentType)) {}
      }
      else {
        while (contentType != null) {
          return false;
        }
      }
      if (fileId == null) {
        break;
      }
    } while (fileId.equals(fileId));
    for (;;)
    {
      return false;
      if (fileId == null) {
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
    int j;
    if (hasText)
    {
      if (text._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(text._cachedId) + 9;
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
          break label248;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label261;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasOriginalImage)
      {
        i = j + 1;
        if (originalImage._cachedId == null) {
          break label274;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(originalImage._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasContentType) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentType);
      }
      j = i + 1;
      i = j;
      if (hasFileId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(fileId);
      }
      __sizeOfObject = i;
      return i;
      i = text.getSerializedSize() + 7;
      break;
      label248:
      i += attributedText.getSerializedSize();
      break label93;
      label261:
      i += image.getSerializedSize();
      break label135;
      label274:
      i += originalImage.getSerializedSize();
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
    if (text != null)
    {
      i = text.hashCode();
      if (attributedText == null) {
        break label154;
      }
      j = attributedText.hashCode();
      if (image == null) {
        break label159;
      }
      k = image.hashCode();
      if (originalImage == null) {
        break label164;
      }
      m = originalImage.hashCode();
      label76:
      if (contentType == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = contentType.hashCode();; n = 0)
    {
      if (fileId != null) {
        i1 = fileId.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareImage");
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
    label376:
    label470:
    label495:
    label505:
    label530:
    label540:
    label565:
    label575:
    label585:
    label593:
    label595:
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
        localByteBuffer.putInt(847668003);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAttributedText) {
              break label495;
            }
            localByteBuffer.put((byte)1);
            if (attributedText._cachedId == null) {
              break label470;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
            attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasImage) {
              break label530;
            }
            localByteBuffer.put((byte)1);
            if (image._cachedId == null) {
              break label505;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
            image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasOriginalImage) {
              break label565;
            }
            localByteBuffer.put((byte)1);
            if (originalImage._cachedId == null) {
              break label540;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, originalImage._cachedId);
            originalImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasContentType) {
              break label575;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, contentType);
            if (!hasFileId) {
              break label585;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, fileId);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label593;
          }
          if (str != null) {
            break label595;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          originalImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)0);
          break label376;
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
    implements RecordTemplateBuilder<ShareImage>
  {
    private AttributedText attributedText = null;
    private String contentType = null;
    private String fileId = null;
    private boolean hasAttributedText = false;
    private boolean hasContentType = false;
    private boolean hasFileId = false;
    private boolean hasImage = false;
    private boolean hasOriginalImage = false;
    private boolean hasText = false;
    private Image image = null;
    private Image originalImage = null;
    private AnnotatedText text = null;
    
    public Builder() {}
    
    public Builder(ShareImage paramShareImage)
    {
      text = text;
      attributedText = attributedText;
      image = image;
      originalImage = originalImage;
      contentType = contentType;
      fileId = fileId;
      hasText = hasText;
      hasAttributedText = hasAttributedText;
      hasImage = hasImage;
      hasOriginalImage = hasOriginalImage;
      hasContentType = hasContentType;
      hasFileId = hasFileId;
    }
    
    public final ShareImage build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ShareImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ShareImage(text, attributedText, image, originalImage, contentType, fileId, hasText, hasAttributedText, hasImage, hasOriginalImage, hasContentType, hasFileId);
        if (!hasImage) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareImage", "image");
        }
      } while (hasFileId);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareImage", "fileId");
    }
    
    public final Builder setContentType(String paramString)
    {
      if (paramString == null)
      {
        hasContentType = false;
        contentType = null;
        return this;
      }
      hasContentType = true;
      contentType = paramString;
      return this;
    }
    
    public final Builder setFileId(String paramString)
    {
      if (paramString == null)
      {
        hasFileId = false;
        fileId = null;
        return this;
      }
      hasFileId = true;
      fileId = paramString;
      return this;
    }
    
    public final Builder setImage(Image paramImage)
    {
      if (paramImage == null)
      {
        hasImage = false;
        image = null;
        return this;
      }
      hasImage = true;
      image = paramImage;
      return this;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */