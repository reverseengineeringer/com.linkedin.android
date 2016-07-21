package com.linkedin.android.pegasus.gen.voyager.premium;

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

public final class PremiumAction
  implements FissileDataModel<PremiumAction>, RecordTemplate<PremiumAction>
{
  public static final PremiumActionBuilder BUILDER = PremiumActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final PremiumAttributedText attributedText;
  public final boolean hasAttributedText;
  public final boolean hasIOSProductIdentifier;
  public final boolean hasIOSQuote;
  public final boolean hasPriceId;
  public final boolean hasPromotionId;
  public final boolean hasQuote;
  public final boolean hasSubText;
  public final boolean hasText;
  public final String iOSProductIdentifier;
  public final String iOSQuote;
  public final String priceId;
  public final String promotionId;
  public final String quote;
  public final String subText;
  public final String text;
  
  PremiumAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, PremiumAttributedText paramPremiumAttributedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    text = paramString1;
    subText = paramString2;
    iOSProductIdentifier = paramString3;
    priceId = paramString4;
    promotionId = paramString5;
    quote = paramString6;
    iOSQuote = paramString7;
    attributedText = paramPremiumAttributedText;
    hasText = paramBoolean1;
    hasSubText = paramBoolean2;
    hasIOSProductIdentifier = paramBoolean3;
    hasPriceId = paramBoolean4;
    hasPromotionId = paramBoolean5;
    hasQuote = paramBoolean6;
    hasIOSQuote = paramBoolean7;
    hasAttributedText = paramBoolean8;
    _cachedId = null;
  }
  
  public final PremiumAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    if (hasSubText)
    {
      paramDataProcessor.startRecordField$505cff1c("subText");
      paramDataProcessor.processString(subText);
    }
    if (hasIOSProductIdentifier)
    {
      paramDataProcessor.startRecordField$505cff1c("iOSProductIdentifier");
      paramDataProcessor.processString(iOSProductIdentifier);
    }
    if (hasPriceId)
    {
      paramDataProcessor.startRecordField$505cff1c("priceId");
      paramDataProcessor.processString(priceId);
    }
    if (hasPromotionId)
    {
      paramDataProcessor.startRecordField$505cff1c("promotionId");
      paramDataProcessor.processString(promotionId);
    }
    if (hasQuote)
    {
      paramDataProcessor.startRecordField$505cff1c("quote");
      paramDataProcessor.processString(quote);
    }
    if (hasIOSQuote)
    {
      paramDataProcessor.startRecordField$505cff1c("iOSQuote");
      paramDataProcessor.processString(iOSQuote);
    }
    PremiumAttributedText localPremiumAttributedText = null;
    boolean bool = false;
    if (hasAttributedText)
    {
      paramDataProcessor.startRecordField$505cff1c("attributedText");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label268;
      }
      localPremiumAttributedText = attributedText.accept(paramDataProcessor);
      if (localPremiumAttributedText == null) {
        break label285;
      }
    }
    label268:
    label285:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label394;
      }
      try
      {
        if (hasText) {
          break label290;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction", "text");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localPremiumAttributedText = (PremiumAttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break;
    }
    label290:
    if (!hasPriceId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction", "priceId");
    }
    if (!hasQuote) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction", "quote");
    }
    return new PremiumAction(text, subText, iOSProductIdentifier, priceId, promotionId, quote, iOSQuote, localPremiumAttributedText, hasText, hasSubText, hasIOSProductIdentifier, hasPriceId, hasPromotionId, hasQuote, hasIOSQuote, bool);
    label394:
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
      paramObject = (PremiumAction)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (subText != null)
      {
        if (subText.equals(subText)) {}
      }
      else {
        while (subText != null) {
          return false;
        }
      }
      if (iOSProductIdentifier != null)
      {
        if (iOSProductIdentifier.equals(iOSProductIdentifier)) {}
      }
      else {
        while (iOSProductIdentifier != null) {
          return false;
        }
      }
      if (priceId != null)
      {
        if (priceId.equals(priceId)) {}
      }
      else {
        while (priceId != null) {
          return false;
        }
      }
      if (promotionId != null)
      {
        if (promotionId.equals(promotionId)) {}
      }
      else {
        while (promotionId != null) {
          return false;
        }
      }
      if (quote != null)
      {
        if (quote.equals(quote)) {}
      }
      else {
        while (quote != null) {
          return false;
        }
      }
      if (iOSQuote != null)
      {
        if (iOSQuote.equals(iOSQuote)) {}
      }
      else {
        while (iOSQuote != null) {
          return false;
        }
      }
      if (attributedText == null) {
        break;
      }
    } while (attributedText.equals(attributedText));
    for (;;)
    {
      return false;
      if (attributedText == null) {
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
    if (hasText) {
      i = PegasusBinaryUtils.getEncodedLength(text) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSubText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subText);
    }
    j = i + 1;
    i = j;
    if (hasIOSProductIdentifier) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(iOSProductIdentifier);
    }
    j = i + 1;
    i = j;
    if (hasPriceId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(priceId);
    }
    j = i + 1;
    i = j;
    if (hasPromotionId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(promotionId);
    }
    j = i + 1;
    i = j;
    if (hasQuote) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(quote);
    }
    j = i + 1;
    i = j;
    if (hasIOSQuote) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(iOSQuote);
    }
    j = i + 1;
    i = j;
    if (hasAttributedText)
    {
      i = j + 1;
      if (attributedText._cachedId == null) {
        break label237;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label237:
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
    if (text != null)
    {
      i = text.hashCode();
      if (subText == null) {
        break label198;
      }
      j = subText.hashCode();
      if (iOSProductIdentifier == null) {
        break label203;
      }
      k = iOSProductIdentifier.hashCode();
      if (priceId == null) {
        break label208;
      }
      m = priceId.hashCode();
      if (promotionId == null) {
        break label214;
      }
      n = promotionId.hashCode();
      if (quote == null) {
        break label220;
      }
      i1 = quote.hashCode();
      label108:
      if (iOSQuote == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = iOSQuote.hashCode();; i2 = 0)
    {
      if (attributedText != null) {
        i3 = attributedText.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumAction");
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
    label188:
    label214:
    label240:
    label266:
    label292:
    label395:
    label405:
    label415:
    label425:
    label435:
    label445:
    label455:
    label480:
    label488:
    label490:
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
        localByteBuffer.putInt(-195727702);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, text);
          if (!hasSubText) {
            break label395;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subText);
          if (!hasIOSProductIdentifier) {
            break label405;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, iOSProductIdentifier);
          if (!hasPriceId) {
            break label415;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, priceId);
          if (!hasPromotionId) {
            break label425;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, promotionId);
          if (!hasQuote) {
            break label435;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, quote);
          if (!hasIOSQuote) {
            break label445;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, iOSQuote);
          if (!hasAttributedText) {
            break label480;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label455;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label488;
          }
          if (str != null) {
            break label490;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
          localByteBuffer.put((byte)0);
          break label214;
          localByteBuffer.put((byte)0);
          break label240;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */