package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.crosspromo.common.android.Locale;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Image
  implements FissileDataModel<Image>, RecordTemplate<Image>
{
  public static final ImageBuilder BUILDER = ImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final float aspectRatio;
  public final boolean hasAspectRatio;
  public final boolean hasLocale;
  public final boolean hasUrl;
  public final Locale locale;
  public final String url;
  
  Image(String paramString, float paramFloat, Locale paramLocale, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    url = paramString;
    aspectRatio = paramFloat;
    locale = paramLocale;
    hasUrl = paramBoolean1;
    hasAspectRatio = paramBoolean2;
    hasLocale = paramBoolean3;
    _cachedId = null;
  }
  
  public final Image accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasAspectRatio)
    {
      paramDataProcessor.startRecordField$505cff1c("aspectRatio");
      paramDataProcessor.processFloat(aspectRatio);
    }
    Locale localLocale = null;
    boolean bool = false;
    if (hasLocale)
    {
      paramDataProcessor.startRecordField$505cff1c("locale");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label140;
      }
      localLocale = locale.accept(paramDataProcessor);
      if (localLocale == null) {
        break label157;
      }
    }
    label140:
    label157:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label162;
      }
      return new Image(url, aspectRatio, localLocale, hasUrl, hasAspectRatio, bool);
      localLocale = (Locale)paramDataProcessor.processDataTemplate(locale);
      break;
    }
    label162:
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
      paramObject = (Image)paramObject;
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (aspectRatio != aspectRatio) {
        return false;
      }
      if (locale == null) {
        break;
      }
    } while (locale.equals(locale));
    for (;;)
    {
      return false;
      if (locale == null) {
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
    if (hasUrl) {
      i = PegasusBinaryUtils.getEncodedLength(url) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasAspectRatio) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasLocale)
    {
      i = j + 1;
      if (locale._cachedId == null) {
        break label104;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(locale._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label104:
      i += locale.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (url != null)
    {
      i = url.hashCode();
      if (aspectRatio == 0.0F) {
        break label89;
      }
    }
    label89:
    for (int j = Float.floatToIntBits(aspectRatio);; j = 0)
    {
      if (locale != null) {
        k = locale.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Image");
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
    label160:
    label263:
    label273:
    label298:
    label306:
    label308:
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
        localByteBuffer.putInt(403486135);
        if (hasUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasAspectRatio) {
            break label263;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(aspectRatio);
          if (!hasLocale) {
            break label298;
          }
          localByteBuffer.put((byte)1);
          if (locale._cachedId == null) {
            break label273;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, locale._cachedId);
          locale.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label306;
          }
          if (str != null) {
            break label308;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label160;
          localByteBuffer.put((byte)1);
          locale.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.Image
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */