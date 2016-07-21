package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PromoAction
  implements FissileDataModel<PromoAction>, RecordTemplate<PromoAction>
{
  public static final PromoActionBuilder BUILDER = PromoActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText displayText;
  public final boolean hasDisplayText;
  public final boolean hasType;
  public final boolean hasUrl;
  public final PromoActionType type;
  public final String url;
  
  PromoAction(PromoActionType paramPromoActionType, AttributedText paramAttributedText, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    type = paramPromoActionType;
    displayText = paramAttributedText;
    url = paramString;
    hasType = paramBoolean1;
    hasDisplayText = paramBoolean2;
    hasUrl = paramBoolean3;
    _cachedId = null;
  }
  
  public final PromoAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    AttributedText localAttributedText = null;
    boolean bool = false;
    if (hasDisplayText)
    {
      paramDataProcessor.startRecordField$505cff1c("displayText");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localAttributedText = displayText.accept(paramDataProcessor);
      if (localAttributedText == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("url");
        paramDataProcessor.processString(url);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasType) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromoAction", "type");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributedText = (AttributedText)paramDataProcessor.processDataTemplate(displayText);
      break;
    }
    label165:
    if (!hasDisplayText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromoAction", "displayText");
    }
    return new PromoAction(type, localAttributedText, url, hasType, bool, hasUrl);
    label210:
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
      paramObject = (PromoAction)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (displayText != null)
      {
        if (displayText.equals(displayText)) {}
      }
      else {
        while (displayText != null) {
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
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasDisplayText)
    {
      i = j + 1;
      if (displayText._cachedId == null) {
        break label107;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(displayText._cachedId);
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
      label107:
      i += displayText.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (type != null)
    {
      i = type.hashCode();
      if (displayText == null) {
        break label87;
      }
    }
    label87:
    for (int j = displayText.hashCode();; j = 0)
    {
      if (url != null) {
        k = url.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PromoAction");
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
    label199:
    label268:
    label293:
    label303:
    label311:
    label313:
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
        localByteBuffer.putInt(-559769219);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasDisplayText) {
            break label293;
          }
          localByteBuffer.put((byte)1);
          if (displayText._cachedId == null) {
            break label268;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, displayText._cachedId);
          displayText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasUrl) {
            break label303;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label311;
          }
          if (str != null) {
            break label313;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          displayText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label199;
          localByteBuffer.put((byte)0);
          break label199;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PromoAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */