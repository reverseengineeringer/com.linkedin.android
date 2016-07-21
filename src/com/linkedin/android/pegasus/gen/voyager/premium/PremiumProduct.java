package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PremiumProduct
  implements FissileDataModel<PremiumProduct>, RecordTemplate<PremiumProduct>
{
  public static final PremiumProductBuilder BUILDER = PremiumProductBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<PremiumAction> actions;
  public final List<PremiumFeature> allFeatures;
  public final List<PremiumFAQ> faqs;
  public final boolean hasActions;
  public final boolean hasAllFeatures;
  public final boolean hasFaqs;
  public final boolean hasHeader;
  public final boolean hasHighlightedFeatures;
  public final boolean hasProductCode;
  public final boolean hasProductDesc;
  public final boolean hasProductFamily;
  public final boolean hasProductId;
  public final boolean hasProductName;
  public final boolean hasPromotion;
  public final String header;
  public final List<PremiumFeature> highlightedFeatures;
  public final String productCode;
  public final String productDesc;
  public final PremiumProductFamily productFamily;
  public final String productId;
  public final String productName;
  public final PremiumPromotion promotion;
  
  PremiumProduct(String paramString1, String paramString2, String paramString3, PremiumProductFamily paramPremiumProductFamily, String paramString4, String paramString5, List<PremiumFeature> paramList1, List<PremiumFeature> paramList2, List<PremiumAction> paramList, List<PremiumFAQ> paramList3, PremiumPromotion paramPremiumPromotion, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    header = paramString1;
    productName = paramString2;
    productDesc = paramString3;
    productFamily = paramPremiumProductFamily;
    productCode = paramString4;
    productId = paramString5;
    if (paramList1 == null)
    {
      paramString1 = null;
      highlightedFeatures = paramString1;
      if (paramList2 != null) {
        break label182;
      }
      paramString1 = null;
      label66:
      allFeatures = paramString1;
      if (paramList != null) {
        break label191;
      }
      paramString1 = null;
      label78:
      actions = paramString1;
      if (paramList3 != null) {
        break label200;
      }
    }
    label182:
    label191:
    label200:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList3))
    {
      faqs = paramString1;
      promotion = paramPremiumPromotion;
      hasHeader = paramBoolean1;
      hasProductName = paramBoolean2;
      hasProductDesc = paramBoolean3;
      hasProductFamily = paramBoolean4;
      hasProductCode = paramBoolean5;
      hasProductId = paramBoolean6;
      hasHighlightedFeatures = paramBoolean7;
      hasAllFeatures = paramBoolean8;
      hasActions = paramBoolean9;
      hasFaqs = paramBoolean10;
      hasPromotion = paramBoolean11;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableList(paramList1);
      break;
      paramString1 = Collections.unmodifiableList(paramList2);
      break label66;
      paramString1 = Collections.unmodifiableList(paramList);
      break label78;
    }
  }
  
  public final PremiumProduct accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      paramDataProcessor.processString(header);
    }
    if (hasProductName)
    {
      paramDataProcessor.startRecordField$505cff1c("productName");
      paramDataProcessor.processString(productName);
    }
    if (hasProductDesc)
    {
      paramDataProcessor.startRecordField$505cff1c("productDesc");
      paramDataProcessor.processString(productDesc);
    }
    if (hasProductFamily)
    {
      paramDataProcessor.startRecordField$505cff1c("productFamily");
      paramDataProcessor.processEnum(productFamily);
    }
    if (hasProductCode)
    {
      paramDataProcessor.startRecordField$505cff1c("productCode");
      paramDataProcessor.processString(productCode);
    }
    if (hasProductId)
    {
      paramDataProcessor.startRecordField$505cff1c("productId");
      paramDataProcessor.processString(productId);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasHighlightedFeatures)
    {
      paramDataProcessor.startRecordField$505cff1c("highlightedFeatures");
      highlightedFeatures.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = highlightedFeatures.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (PremiumFeature)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((PremiumFeature)localObject2).accept(paramDataProcessor);; localObject2 = (PremiumFeature)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      localObject1 = null;
      bool2 = false;
      if (!hasAllFeatures) {
        break label519;
      }
      paramDataProcessor.startRecordField$505cff1c("allFeatures");
      allFeatures.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = allFeatures.iterator();
      label403:
      if (!((Iterator)localObject4).hasNext()) {
        break label501;
      }
      localObject3 = (PremiumFeature)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label485;
      }
    }
    label485:
    for (Object localObject3 = ((PremiumFeature)localObject3).accept(paramDataProcessor);; localObject3 = (PremiumFeature)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject1 != null) && (localObject3 != null)) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
      break label403;
      bool1 = false;
      localObject2 = localObject1;
      break;
    }
    label501:
    paramDataProcessor.endArray();
    label519:
    boolean bool3;
    if (localObject1 != null)
    {
      bool2 = true;
      localObject3 = localObject1;
      localObject4 = null;
      localObject1 = null;
      bool3 = false;
      if (!hasActions) {
        break label707;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject5 = actions.iterator();
      label590:
      if (!((Iterator)localObject5).hasNext()) {
        break label689;
      }
      localObject4 = (PremiumAction)((Iterator)localObject5).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label673;
      }
    }
    label673:
    for (Object localObject4 = ((PremiumAction)localObject4).accept(paramDataProcessor);; localObject4 = (PremiumAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject1 != null) && (localObject4 != null)) {
        ((List)localObject1).add(localObject4);
      }
      i += 1;
      break label590;
      bool2 = false;
      localObject3 = localObject1;
      break;
    }
    label689:
    paramDataProcessor.endArray();
    label707:
    boolean bool4;
    if (localObject1 != null)
    {
      bool3 = true;
      localObject4 = localObject1;
      localObject5 = null;
      localObject1 = null;
      bool4 = false;
      if (!hasFaqs) {
        break label895;
      }
      paramDataProcessor.startRecordField$505cff1c("faqs");
      faqs.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = faqs.iterator();
      label778:
      if (!localIterator.hasNext()) {
        break label877;
      }
      localObject5 = (PremiumFAQ)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label861;
      }
    }
    label861:
    for (Object localObject5 = ((PremiumFAQ)localObject5).accept(paramDataProcessor);; localObject5 = (PremiumFAQ)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject1 != null) && (localObject5 != null)) {
        ((List)localObject1).add(localObject5);
      }
      i += 1;
      break label778;
      bool3 = false;
      localObject4 = localObject1;
      break;
    }
    label877:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool4 = true;
      localObject5 = localObject1;
      label895:
      localObject1 = null;
      bool5 = false;
      if (hasPromotion)
      {
        paramDataProcessor.startRecordField$505cff1c("promotion");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label997;
        }
        localObject1 = promotion.accept(paramDataProcessor);
        label935:
        if (localObject1 == null) {
          break label1015;
        }
      }
    }
    label997:
    label1015:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1467;
      }
      try
      {
        if (hasHeader) {
          break label1021;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool4 = false;
      localObject5 = localObject1;
      break;
      localObject1 = (PremiumPromotion)paramDataProcessor.processDataTemplate(promotion);
      break label935;
    }
    label1021:
    if (!hasProductName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "productName");
    }
    if (!hasProductDesc) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "productDesc");
    }
    if (!hasProductFamily) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "productFamily");
    }
    if (!hasProductCode) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "productCode");
    }
    if (!hasProductId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "productId");
    }
    if (!hasHighlightedFeatures) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "highlightedFeatures");
    }
    if (!hasAllFeatures) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "allFeatures");
    }
    if (!hasActions) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "actions");
    }
    if (!hasFaqs) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "faqs");
    }
    if (highlightedFeatures != null)
    {
      paramDataProcessor = highlightedFeatures.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PremiumFeature)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "highlightedFeatures");
        }
      }
    }
    if (allFeatures != null)
    {
      paramDataProcessor = allFeatures.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PremiumFeature)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "allFeatures");
        }
      }
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PremiumAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "actions");
        }
      }
    }
    if (faqs != null)
    {
      paramDataProcessor = faqs.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PremiumFAQ)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct", "faqs");
        }
      }
    }
    return new PremiumProduct(header, productName, productDesc, productFamily, productCode, productId, (List)localObject2, (List)localObject3, (List)localObject4, (List)localObject5, (PremiumPromotion)localObject1, hasHeader, hasProductName, hasProductDesc, hasProductFamily, hasProductCode, hasProductId, bool1, bool2, bool3, bool4, bool5);
    label1467:
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
      paramObject = (PremiumProduct)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (productName != null)
      {
        if (productName.equals(productName)) {}
      }
      else {
        while (productName != null) {
          return false;
        }
      }
      if (productDesc != null)
      {
        if (productDesc.equals(productDesc)) {}
      }
      else {
        while (productDesc != null) {
          return false;
        }
      }
      if (productFamily != null)
      {
        if (productFamily.equals(productFamily)) {}
      }
      else {
        while (productFamily != null) {
          return false;
        }
      }
      if (productCode != null)
      {
        if (productCode.equals(productCode)) {}
      }
      else {
        while (productCode != null) {
          return false;
        }
      }
      if (productId != null)
      {
        if (productId.equals(productId)) {}
      }
      else {
        while (productId != null) {
          return false;
        }
      }
      if (highlightedFeatures != null)
      {
        if (highlightedFeatures.equals(highlightedFeatures)) {}
      }
      else {
        while (highlightedFeatures != null) {
          return false;
        }
      }
      if (allFeatures != null)
      {
        if (allFeatures.equals(allFeatures)) {}
      }
      else {
        while (allFeatures != null) {
          return false;
        }
      }
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (faqs != null)
      {
        if (faqs.equals(faqs)) {}
      }
      else {
        while (faqs != null) {
          return false;
        }
      }
      if (promotion == null) {
        break;
      }
    } while (promotion.equals(promotion));
    for (;;)
    {
      return false;
      if (promotion == null) {
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
    if (hasHeader) {
      i = PegasusBinaryUtils.getEncodedLength(header) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasProductName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(productName);
    }
    j = i + 1;
    i = j;
    if (hasProductDesc) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(productDesc);
    }
    j = i + 1;
    i = j;
    if (hasProductFamily) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasProductCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(productCode);
    }
    j = i + 1;
    i = j;
    if (hasProductId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(productId);
    }
    i += 1;
    j = i;
    Iterator localIterator;
    Object localObject;
    if (hasHighlightedFeatures)
    {
      i += 2;
      localIterator = highlightedFeatures.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PremiumFeature)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PremiumFeature)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasAllFeatures)
    {
      i += 2;
      localIterator = allFeatures.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PremiumFeature)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PremiumFeature)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasActions)
    {
      i += 2;
      localIterator = actions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PremiumAction)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PremiumAction)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasFaqs)
    {
      i += 2;
      localIterator = faqs.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PremiumFAQ)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PremiumFAQ)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPromotion)
    {
      i = j + 1;
      if (promotion._cachedId == null) {
        break label556;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(promotion._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label556:
      i += promotion.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
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
    label126:
    int i3;
    label144:
    int i4;
    if (header != null)
    {
      i = header.hashCode();
      if (productName == null) {
        break label272;
      }
      j = productName.hashCode();
      if (productDesc == null) {
        break label277;
      }
      k = productDesc.hashCode();
      if (productFamily == null) {
        break label282;
      }
      m = productFamily.hashCode();
      if (productCode == null) {
        break label288;
      }
      n = productCode.hashCode();
      if (productId == null) {
        break label294;
      }
      i1 = productId.hashCode();
      if (highlightedFeatures == null) {
        break label300;
      }
      i2 = highlightedFeatures.hashCode();
      if (allFeatures == null) {
        break label306;
      }
      i3 = allFeatures.hashCode();
      if (actions == null) {
        break label312;
      }
      i4 = actions.hashCode();
      label162:
      if (faqs == null) {
        break label318;
      }
    }
    label272:
    label277:
    label282:
    label288:
    label294:
    label300:
    label306:
    label312:
    label318:
    for (int i5 = faqs.hashCode();; i5 = 0)
    {
      if (promotion != null) {
        i6 = promotion.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6;
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
      break label126;
      i3 = 0;
      break label144;
      i4 = 0;
      break label162;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumProduct");
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
    label164:
    label190:
    label219:
    label245:
    label271:
    label388:
    label398:
    label408:
    label418:
    label428:
    label461:
    label468:
    label1007:
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
        localByteBuffer.putInt(1644383868);
        Iterator localIterator;
        if (hasHeader)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, header);
          if (!hasProductName) {
            break label388;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, productName);
          if (!hasProductDesc) {
            break label398;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, productDesc);
          if (!hasProductFamily) {
            break label408;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, productFamily.ordinal());
          if (!hasProductCode) {
            break label418;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, productCode);
          if (!hasProductId) {
            break label428;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, productId);
          if (!hasHighlightedFeatures) {
            break label461;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, highlightedFeatures.size());
          localIterator = highlightedFeatures.iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label468;
          }
          localObject = (PremiumFeature)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((PremiumFeature)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label164;
            localByteBuffer.put((byte)0);
            break label190;
            localByteBuffer.put((byte)0);
            break label219;
            localByteBuffer.put((byte)0);
            break label245;
            localByteBuffer.put((byte)0);
            break label271;
          }
          localByteBuffer.put((byte)1);
          ((PremiumFeature)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasAllFeatures)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, allFeatures.size());
          localIterator = allFeatures.iterator();
          while (localIterator.hasNext())
          {
            localObject = (PremiumFeature)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((PremiumFeature)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((PremiumFeature)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localIterator = actions.iterator();
          while (localIterator.hasNext())
          {
            localObject = (PremiumAction)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((PremiumAction)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((PremiumAction)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasFaqs)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, faqs.size());
          localIterator = faqs.iterator();
          while (localIterator.hasNext())
          {
            localObject = (PremiumFAQ)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((PremiumFAQ)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((PremiumFAQ)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasPromotion)
        {
          localByteBuffer.put((byte)1);
          if (promotion._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, promotion._cachedId);
            promotion.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label1007;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          promotion.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */