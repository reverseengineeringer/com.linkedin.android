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
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareDocument
  implements FissileDataModel<ShareDocument>, RecordTemplate<ShareDocument>
{
  public static final ShareDocumentBuilder BUILDER = ShareDocumentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText attributedText;
  public final String fileName;
  public final boolean hasAttributedText;
  public final boolean hasFileName;
  public final boolean hasImage;
  public final boolean hasText;
  public final boolean hasType;
  public final boolean hasUrl;
  public final Image image;
  public final AnnotatedText text;
  public final FileType type;
  public final String url;
  
  ShareDocument(AnnotatedText paramAnnotatedText, AttributedText paramAttributedText, Image paramImage, FileType paramFileType, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    text = paramAnnotatedText;
    attributedText = paramAttributedText;
    image = paramImage;
    type = paramFileType;
    fileName = paramString1;
    url = paramString2;
    hasText = paramBoolean1;
    hasAttributedText = paramBoolean2;
    hasImage = paramBoolean3;
    hasType = paramBoolean4;
    hasFileName = paramBoolean5;
    hasUrl = paramBoolean6;
    _cachedId = null;
  }
  
  public final ShareDocument accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label291;
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
          break label300;
        }
        localObject1 = attributedText.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label318;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label327;
        }
        localObject1 = image.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label345;
        }
      }
    }
    label291:
    label300:
    label318:
    label327:
    label345:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      if (hasFileName)
      {
        paramDataProcessor.startRecordField$505cff1c("fileName");
        paramDataProcessor.processString(fileName);
      }
      if (hasUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("url");
        paramDataProcessor.processString(url);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label450;
      }
      try
      {
        if (hasImage) {
          break label351;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument", "image");
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
    }
    label351:
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument", "type");
    }
    if (!hasFileName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument", "fileName");
    }
    if (!hasUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument", "url");
    }
    return new ShareDocument((AnnotatedText)localObject2, (AttributedText)localObject3, (Image)localObject1, type, fileName, url, bool1, bool2, bool3, hasType, hasFileName, hasUrl);
    label450:
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
      paramObject = (ShareDocument)paramObject;
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
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (fileName != null)
      {
        if (fileName.equals(fileName)) {}
      }
      else {
        while (fileName != null) {
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
          break label223;
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
          break label236;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasFileName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(fileName);
      }
      j = i + 1;
      i = j;
      if (hasUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
      }
      __sizeOfObject = i;
      return i;
      i = text.getSerializedSize() + 7;
      break;
      label223:
      i += attributedText.getSerializedSize();
      break label93;
      label236:
      i += image.getSerializedSize();
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
      if (type == null) {
        break label164;
      }
      m = type.hashCode();
      label76:
      if (fileName == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = fileName.hashCode();; n = 0)
    {
      if (url != null) {
        i1 = url.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareDocument");
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
    label319:
    label345:
    label439:
    label464:
    label474:
    label499:
    label509:
    label519:
    label529:
    label537:
    label539:
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
        localByteBuffer.putInt(200738313);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAttributedText) {
              break label464;
            }
            localByteBuffer.put((byte)1);
            if (attributedText._cachedId == null) {
              break label439;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
            attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasImage) {
              break label499;
            }
            localByteBuffer.put((byte)1);
            if (image._cachedId == null) {
              break label474;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
            image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasType) {
              break label509;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
            if (!hasFileName) {
              break label519;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, fileName);
            if (!hasUrl) {
              break label529;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, url);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label537;
          }
          if (str != null) {
            break label539;
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
          localByteBuffer.put((byte)0);
          break label319;
          localByteBuffer.put((byte)0);
          break label345;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */