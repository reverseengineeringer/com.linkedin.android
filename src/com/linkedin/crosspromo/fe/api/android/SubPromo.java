package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SubPromo
  implements FissileDataModel<SubPromo>, RecordTemplate<SubPromo>
{
  public static final SubPromoBuilder BUILDER = SubPromoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String actionUrl;
  public final List<Bolton> boltons;
  public final boolean hasActionUrl;
  public final boolean hasBoltons;
  public final boolean hasImages;
  public final boolean hasMetricsMap;
  public final boolean hasStoreUrl;
  public final boolean hasTType;
  public final boolean hasTexts;
  public final Map<String, Image> images;
  public final Map<String, MetricsInfo> metricsMap;
  public final String storeUrl;
  public final String tType;
  public final Map<String, RichText> texts;
  
  SubPromo(String paramString1, String paramString2, String paramString3, Map<String, Image> paramMap, Map<String, RichText> paramMap1, Map<String, MetricsInfo> paramMap2, List<Bolton> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    tType = paramString1;
    actionUrl = paramString2;
    storeUrl = paramString3;
    if (paramMap == null)
    {
      paramString1 = null;
      images = paramString1;
      if (paramMap1 != null) {
        break label134;
      }
      paramString1 = null;
      label48:
      texts = paramString1;
      if (paramMap2 != null) {
        break label143;
      }
      paramString1 = null;
      label60:
      metricsMap = paramString1;
      if (paramList != null) {
        break label152;
      }
    }
    label134:
    label143:
    label152:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      boltons = paramString1;
      hasTType = paramBoolean1;
      hasActionUrl = paramBoolean2;
      hasStoreUrl = paramBoolean3;
      hasImages = paramBoolean4;
      hasTexts = paramBoolean5;
      hasMetricsMap = paramBoolean6;
      hasBoltons = paramBoolean7;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableMap(paramMap);
      break;
      paramString1 = Collections.unmodifiableMap(paramMap1);
      break label48;
      paramString1 = Collections.unmodifiableMap(paramMap2);
      break label60;
    }
  }
  
  public final SubPromo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTType)
    {
      paramDataProcessor.startRecordField$505cff1c("tType");
      paramDataProcessor.processString(tType);
    }
    if (hasActionUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("actionUrl");
      paramDataProcessor.processString(actionUrl);
    }
    if (hasStoreUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("storeUrl");
      paramDataProcessor.processString(storeUrl);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasImages)
    {
      paramDataProcessor.startRecordField$505cff1c("images");
      images.size();
      paramDataProcessor.startMap$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new HashMap();
      }
      i = 0;
      localObject3 = images.entrySet().iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        paramDataProcessor.processMapKey((String)((Map.Entry)localObject4).getKey(), i);
        localObject2 = (Image)((Map.Entry)localObject4).getValue();
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Image)localObject2).accept(paramDataProcessor);; localObject2 = (Image)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((Map)localObject1).put(((Map.Entry)localObject4).getKey(), localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endMap();
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
      if (!hasTexts) {
        break label512;
      }
      paramDataProcessor.startRecordField$505cff1c("texts");
      texts.size();
      paramDataProcessor.startMap$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new HashMap();
      }
      i = 0;
      localObject4 = texts.entrySet().iterator();
      label367:
      if (!((Iterator)localObject4).hasNext()) {
        break label494;
      }
      localObject5 = (Map.Entry)((Iterator)localObject4).next();
      paramDataProcessor.processMapKey((String)((Map.Entry)localObject5).getKey(), i);
      localObject3 = (RichText)((Map.Entry)localObject5).getValue();
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label478;
      }
    }
    label478:
    for (Object localObject3 = ((RichText)localObject3).accept(paramDataProcessor);; localObject3 = (RichText)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject1 != null) && (localObject3 != null)) {
        ((Map)localObject1).put(((Map.Entry)localObject5).getKey(), localObject3);
      }
      i += 1;
      break label367;
      bool1 = false;
      localObject2 = localObject1;
      break;
    }
    label494:
    paramDataProcessor.endMap();
    label512:
    boolean bool3;
    label588:
    Object localObject6;
    if (localObject1 != null)
    {
      bool2 = true;
      localObject3 = localObject1;
      localObject4 = null;
      localObject1 = null;
      bool3 = false;
      if (!hasMetricsMap) {
        break label734;
      }
      paramDataProcessor.startRecordField$505cff1c("metricsMap");
      metricsMap.size();
      paramDataProcessor.startMap$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new HashMap();
      }
      i = 0;
      localObject5 = metricsMap.entrySet().iterator();
      if (!((Iterator)localObject5).hasNext()) {
        break label716;
      }
      localObject6 = (Map.Entry)((Iterator)localObject5).next();
      paramDataProcessor.processMapKey((String)((Map.Entry)localObject6).getKey(), i);
      localObject4 = (MetricsInfo)((Map.Entry)localObject6).getValue();
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label700;
      }
    }
    label700:
    for (Object localObject4 = ((MetricsInfo)localObject4).accept(paramDataProcessor);; localObject4 = (MetricsInfo)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject1 != null) && (localObject4 != null)) {
        ((Map)localObject1).put(((Map.Entry)localObject6).getKey(), localObject4);
      }
      i += 1;
      break label588;
      bool2 = false;
      localObject3 = localObject1;
      break;
    }
    label716:
    paramDataProcessor.endMap();
    if (localObject1 != null)
    {
      bool3 = true;
      localObject4 = localObject1;
      label734:
      localObject1 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasBoltons) {
        break label922;
      }
      paramDataProcessor.startRecordField$505cff1c("boltons");
      boltons.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject6 = boltons.iterator();
      label809:
      if (!((Iterator)localObject6).hasNext()) {
        break label908;
      }
      localObject5 = (Bolton)((Iterator)localObject6).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label892;
      }
    }
    label892:
    for (Object localObject5 = ((Bolton)localObject5).accept(paramDataProcessor);; localObject5 = (Bolton)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject1 != null) && (localObject5 != null)) {
        ((List)localObject1).add(localObject5);
      }
      i += 1;
      break label809;
      bool3 = false;
      localObject4 = localObject1;
      break;
    }
    label908:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label922:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new SubPromo(tType, actionUrl, storeUrl, (Map)localObject2, (Map)localObject3, (Map)localObject4, (List)localObject1, hasTType, hasActionUrl, hasStoreUrl, bool1, bool2, bool3, bool4);
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
      paramObject = (SubPromo)paramObject;
      if (tType != null)
      {
        if (tType.equals(tType)) {}
      }
      else {
        while (tType != null) {
          return false;
        }
      }
      if (actionUrl != null)
      {
        if (actionUrl.equals(actionUrl)) {}
      }
      else {
        while (actionUrl != null) {
          return false;
        }
      }
      if (storeUrl != null)
      {
        if (storeUrl.equals(storeUrl)) {}
      }
      else {
        while (storeUrl != null) {
          return false;
        }
      }
      if (images != null)
      {
        if (images.equals(images)) {}
      }
      else {
        while (images != null) {
          return false;
        }
      }
      if (texts != null)
      {
        if (texts.equals(texts)) {}
      }
      else {
        while (texts != null) {
          return false;
        }
      }
      if (metricsMap != null)
      {
        if (metricsMap.equals(metricsMap)) {}
      }
      else {
        while (metricsMap != null) {
          return false;
        }
      }
      if (boltons == null) {
        break;
      }
    } while (boltons.equals(boltons));
    for (;;)
    {
      return false;
      if (boltons == null) {
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
    if (hasTType) {
      i = PegasusBinaryUtils.getEncodedLength(tType) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasActionUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(actionUrl);
    }
    j = i + 1;
    i = j;
    if (hasStoreUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(storeUrl);
    }
    i += 1;
    j = i;
    Iterator localIterator;
    Object localObject;
    if (hasImages)
    {
      i += 2;
      localIterator = images.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
        localObject = (Image)((Map.Entry)localObject).getValue();
        i = i + 2 + j + 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Image)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasTexts)
    {
      i += 2;
      localIterator = texts.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
        localObject = (RichText)((Map.Entry)localObject).getValue();
        i = i + 2 + j + 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((RichText)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasMetricsMap)
    {
      i += 2;
      localIterator = metricsMap.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
        localObject = (MetricsInfo)((Map.Entry)localObject).getValue();
        i = i + 2 + j + 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MetricsInfo)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasBoltons)
    {
      i += 2;
      localIterator = boltons.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Bolton)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Bolton)localObject).getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label78:
    int n;
    if (tType != null)
    {
      i = tType.hashCode();
      if (actionUrl == null) {
        break label184;
      }
      j = actionUrl.hashCode();
      if (storeUrl == null) {
        break label189;
      }
      k = storeUrl.hashCode();
      if (images == null) {
        break label194;
      }
      m = images.hashCode();
      if (texts == null) {
        break label200;
      }
      n = texts.hashCode();
      label96:
      if (metricsMap == null) {
        break label206;
      }
    }
    label184:
    label189:
    label194:
    label200:
    label206:
    for (int i1 = metricsMap.hashCode();; i1 = 0)
    {
      if (boltons != null) {
        i2 = boltons.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label78;
      n = 0;
      break label96;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SubPromo");
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
    label342:
    label352:
    label385:
    label392:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1801204899);
        Iterator localIterator;
        if (hasTType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, tType);
          if (!hasActionUrl) {
            break label342;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, actionUrl);
          if (!hasStoreUrl) {
            break label352;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, storeUrl);
          if (!hasImages) {
            break label385;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, images.size());
          localIterator = images.entrySet().iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label392;
          }
          localObject = (Map.Entry)localIterator.next();
          paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
          localObject = (Image)((Map.Entry)localObject).getValue();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((Image)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label164;
            localByteBuffer.put((byte)0);
            break label190;
          }
          localByteBuffer.put((byte)1);
          ((Image)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasTexts)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, texts.size());
          localIterator = texts.entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
            localObject = (RichText)((Map.Entry)localObject).getValue();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((RichText)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((RichText)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasMetricsMap)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, metricsMap.size());
          localIterator = metricsMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
            localObject = (MetricsInfo)((Map.Entry)localObject).getValue();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MetricsInfo)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((MetricsInfo)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasBoltons)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, boltons.size());
          localIterator = boltons.iterator();
          while (localIterator.hasNext())
          {
            localObject = (Bolton)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Bolton)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((Bolton)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.SubPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */