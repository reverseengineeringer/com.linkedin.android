package com.linkedin.android.pegasus.gen.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Locale
  implements FissileDataModel<Locale>, RecordTemplate<Locale>
{
  public static final LocaleBuilder BUILDER = LocaleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String country;
  public final boolean hasCountry;
  public final boolean hasLanguage;
  public final boolean hasVariant;
  public final String language;
  public final String variant;
  
  Locale(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    language = paramString1;
    country = paramString2;
    variant = paramString3;
    hasLanguage = paramBoolean1;
    hasCountry = paramBoolean2;
    hasVariant = paramBoolean3;
    _cachedId = null;
  }
  
  public final Locale accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasLanguage)
    {
      paramDataProcessor.startRecordField$505cff1c("language");
      paramDataProcessor.processString(language);
    }
    if (hasCountry)
    {
      paramDataProcessor.startRecordField$505cff1c("country");
      paramDataProcessor.processString(country);
    }
    if (hasVariant)
    {
      paramDataProcessor.startRecordField$505cff1c("variant");
      paramDataProcessor.processString(variant);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasLanguage) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.Locale", "language");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new Locale(language, country, variant, hasLanguage, hasCountry, hasVariant);
    }
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
      paramObject = (Locale)paramObject;
      if (language != null)
      {
        if (language.equals(language)) {}
      }
      else {
        while (language != null) {
          return false;
        }
      }
      if (country != null)
      {
        if (country.equals(country)) {}
      }
      else {
        while (country != null) {
          return false;
        }
      }
      if (variant == null) {
        break;
      }
    } while (variant.equals(variant));
    for (;;)
    {
      return false;
      if (variant == null) {
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
    if (hasLanguage) {
      i = PegasusBinaryUtils.getEncodedLength(language) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCountry) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(country);
    }
    j = i + 1;
    i = j;
    if (hasVariant) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(variant);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (language != null)
    {
      i = language.hashCode();
      if (country == null) {
        break label87;
      }
    }
    label87:
    for (int j = country.hashCode();; j = 0)
    {
      if (variant != null) {
        k = variant.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Locale");
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
    label231:
    label241:
    label249:
    label251:
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
        localByteBuffer.putInt(-1983216830);
        if (hasLanguage)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, language);
          if (!hasCountry) {
            break label231;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, country);
          if (!hasVariant) {
            break label241;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, variant);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label249;
          }
          if (str != null) {
            break label251;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.Locale
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */