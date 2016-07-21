package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PremiumProducts
  implements FissileDataModel<PremiumProducts>, RecordTemplate<PremiumProducts>
{
  public static final PremiumProductsBuilder BUILDER = PremiumProductsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String footer;
  public final boolean hasFooter;
  public final boolean hasHeader;
  public final boolean hasProducts;
  public final boolean hasPromotionOffered;
  public final boolean hasRecommendedProductIndex;
  public final boolean hasWarningText;
  public final String header;
  public final List<PremiumProduct> products;
  public final boolean promotionOffered;
  public final int recommendedProductIndex;
  public final String warningText;
  
  PremiumProducts(String paramString1, String paramString2, List<PremiumProduct> paramList, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramString1;
    footer = paramString2;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      products = paramString1;
      warningText = paramString3;
      recommendedProductIndex = paramInt;
      promotionOffered = paramBoolean1;
      hasHeader = paramBoolean2;
      hasFooter = paramBoolean3;
      hasProducts = paramBoolean4;
      hasWarningText = paramBoolean5;
      hasRecommendedProductIndex = paramBoolean6;
      hasPromotionOffered = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  private PremiumProducts accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      paramDataProcessor.processString(header);
    }
    if (hasFooter)
    {
      paramDataProcessor.startRecordField$505cff1c("footer");
      paramDataProcessor.processString(footer);
    }
    Object localObject = null;
    PremiumProduct localPremiumProduct = null;
    boolean bool = false;
    if (hasProducts)
    {
      paramDataProcessor.startRecordField$505cff1c("products");
      products.size();
      paramDataProcessor.startArray$13462e();
      localObject = localPremiumProduct;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = products.iterator();
      if (localIterator.hasNext())
      {
        localPremiumProduct = (PremiumProduct)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localPremiumProduct = localPremiumProduct.accept(paramDataProcessor);; localPremiumProduct = (PremiumProduct)paramDataProcessor.processDataTemplate(localPremiumProduct))
        {
          if ((localObject != null) && (localPremiumProduct != null)) {
            ((List)localObject).add(localPremiumProduct);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label351;
      }
    }
    label351:
    for (bool = true;; bool = false)
    {
      if (hasWarningText)
      {
        paramDataProcessor.startRecordField$505cff1c("warningText");
        paramDataProcessor.processString(warningText);
      }
      if (hasRecommendedProductIndex)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendedProductIndex");
        paramDataProcessor.processInt(recommendedProductIndex);
      }
      if (hasPromotionOffered)
      {
        paramDataProcessor.startRecordField$505cff1c("promotionOffered");
        paramDataProcessor.processBoolean(promotionOffered);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label533;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasFooter) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts", "footer");
    }
    if (!hasProducts) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts", "products");
    }
    if (!hasRecommendedProductIndex) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts", "recommendedProductIndex");
    }
    if (!hasPromotionOffered) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts", "promotionOffered");
    }
    if (products != null)
    {
      paramDataProcessor = products.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PremiumProduct)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts", "products");
        }
      }
    }
    return new PremiumProducts(header, footer, (List)localObject, warningText, recommendedProductIndex, promotionOffered, hasHeader, hasFooter, bool, hasWarningText, hasRecommendedProductIndex, hasPromotionOffered);
    label533:
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
      paramObject = (PremiumProducts)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (footer != null)
      {
        if (footer.equals(footer)) {}
      }
      else {
        while (footer != null) {
          return false;
        }
      }
      if (products != null)
      {
        if (products.equals(products)) {}
      }
      else {
        while (products != null) {
          return false;
        }
      }
      if (warningText != null)
      {
        if (warningText.equals(warningText)) {}
      }
      else {
        while (warningText != null) {
          return false;
        }
      }
      if (recommendedProductIndex != recommendedProductIndex) {
        return false;
      }
    } while (promotionOffered == promotionOffered);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasHeader) {
      i = PegasusBinaryUtils.getEncodedLength(header) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFooter) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(footer);
    }
    i += 1;
    j = i;
    if (hasProducts)
    {
      i += 2;
      Iterator localIterator = products.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        PremiumProduct localPremiumProduct = (PremiumProduct)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localPremiumProduct.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasWarningText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(warningText);
    }
    j = i + 1;
    i = j;
    if (hasRecommendedProductIndex) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasPromotionOffered) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
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
    if (header != null)
    {
      i = header.hashCode();
      if (footer == null) {
        break label140;
      }
      j = footer.hashCode();
      if (products == null) {
        break label145;
      }
      k = products.hashCode();
      label62:
      if (warningText == null) {
        break label150;
      }
    }
    label140:
    label145:
    label150:
    for (int m = warningText.hashCode();; m = 0)
    {
      int i1 = recommendedProductIndex;
      if (promotionOffered) {
        n = 1;
      }
      i = ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i1) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label62;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumProducts");
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
    label279:
    label312:
    label319:
    label369:
    label393:
    label445:
    label455:
    label461:
    label469:
    label471:
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
        localByteBuffer.putInt(-1427288123);
        Iterator localIterator;
        if (hasHeader)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, header);
          if (!hasFooter) {
            break label279;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, footer);
          if (!hasProducts) {
            break label312;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, products.size());
          localIterator = products.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label319;
          }
          PremiumProduct localPremiumProduct = (PremiumProduct)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localPremiumProduct.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label162;
          }
          localByteBuffer.put((byte)1);
          localPremiumProduct.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasWarningText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, warningText);
          if (!hasRecommendedProductIndex) {
            break label445;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(recommendedProductIndex);
          if (!hasPromotionOffered) {
            break label461;
          }
          localByteBuffer.put((byte)1);
          if (!promotionOffered) {
            break label455;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label469;
          }
          if (str != null) {
            break label471;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label369;
          i = 0;
          break label393;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */