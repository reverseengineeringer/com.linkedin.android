package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CareerAbout
  implements FissileDataModel<CareerAbout>, RecordTemplate<CareerAbout>
{
  public static final CareerAboutBuilder BUILDER = CareerAboutBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String careersSubtitle;
  public final String careersTitle;
  public final boolean hasCareersSubtitle;
  public final boolean hasCareersTitle;
  public final boolean hasImage;
  public final boolean hasText;
  public final boolean hasTitle;
  public final CareerImage image;
  public final String text;
  public final String title;
  
  CareerAbout(String paramString1, String paramString2, CareerImage paramCareerImage, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    title = paramString1;
    text = paramString2;
    image = paramCareerImage;
    careersTitle = paramString3;
    careersSubtitle = paramString4;
    hasTitle = paramBoolean1;
    hasText = paramBoolean2;
    hasImage = paramBoolean3;
    hasCareersTitle = paramBoolean4;
    hasCareersSubtitle = paramBoolean5;
    _cachedId = null;
  }
  
  public final CareerAbout accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    CareerImage localCareerImage = null;
    boolean bool = false;
    if (hasImage)
    {
      paramDataProcessor.startRecordField$505cff1c("image");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label206;
      }
      localCareerImage = image.accept(paramDataProcessor);
      if (localCareerImage == null) {
        break label223;
      }
    }
    label206:
    label223:
    for (bool = true;; bool = false)
    {
      if (hasCareersTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("careersTitle");
        paramDataProcessor.processString(careersTitle);
      }
      if (hasCareersSubtitle)
      {
        paramDataProcessor.startRecordField$505cff1c("careersSubtitle");
        paramDataProcessor.processString(careersSubtitle);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label228;
      }
      return new CareerAbout(title, text, localCareerImage, careersTitle, careersSubtitle, hasTitle, hasText, bool, hasCareersTitle, hasCareersSubtitle);
      localCareerImage = (CareerImage)paramDataProcessor.processDataTemplate(image);
      break;
    }
    label228:
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
      paramObject = (CareerAbout)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
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
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (careersTitle != null)
      {
        if (careersTitle.equals(careersTitle)) {}
      }
      else {
        while (careersTitle != null) {
          return false;
        }
      }
      if (careersSubtitle == null) {
        break;
      }
    } while (careersSubtitle.equals(careersSubtitle));
    for (;;)
    {
      return false;
      if (careersSubtitle == null) {
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
    if (hasText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(text);
    }
    j = i + 1;
    i = j;
    if (hasImage)
    {
      i = j + 1;
      if (image._cachedId == null) {
        break label162;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasCareersTitle) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(careersTitle);
      }
      j = i + 1;
      i = j;
      if (hasCareersSubtitle) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(careersSubtitle);
      }
      __sizeOfObject = i;
      return i;
      label162:
      i += image.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (title != null)
    {
      i = title.hashCode();
      if (text == null) {
        break label132;
      }
      j = text.hashCode();
      if (image == null) {
        break label137;
      }
      k = image.hashCode();
      label60:
      if (careersTitle == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = careersTitle.hashCode();; m = 0)
    {
      if (careersSubtitle != null) {
        n = careersSubtitle.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerAbout");
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
    label162:
    label222:
    label248:
    label317:
    label327:
    label352:
    label362:
    label372:
    label380:
    label382:
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
        localByteBuffer.putInt(554198736);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasText) {
            break label317;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, text);
          if (!hasImage) {
            break label352;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label327;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCareersTitle) {
            break label362;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, careersTitle);
          if (!hasCareersSubtitle) {
            break label372;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, careersSubtitle);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label380;
          }
          if (str != null) {
            break label382;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label222;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label248;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAbout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */