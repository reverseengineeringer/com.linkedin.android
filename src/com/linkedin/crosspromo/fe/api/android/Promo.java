package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Promo
  implements FissileDataModel<Promo>, RecordTemplate<Promo>
{
  public static final PromoBuilder BUILDER = PromoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String actionUrl;
  public final String appId;
  public final String appName;
  public final List<Bolton> boltons;
  public final boolean hasActionUrl;
  public final boolean hasAppId;
  public final boolean hasAppName;
  public final boolean hasBoltons;
  public final boolean hasImages;
  public final boolean hasLegoTrackingToken;
  public final boolean hasMetricsMap;
  public final boolean hasMetricsObject;
  public final boolean hasNeedSyncRendering;
  public final boolean hasNoCache;
  public final boolean hasStoreUrl;
  public final boolean hasSubPromos;
  public final boolean hasTType;
  public final boolean hasTexts;
  public final boolean hasWidgetId;
  public final Map<String, Image> images;
  public final String legoTrackingToken;
  public final Map<String, MetricsInfo> metricsMap;
  public final MetricsInfo metricsObject;
  public final boolean needSyncRendering;
  public final boolean noCache;
  public final String storeUrl;
  public final List<SubPromo> subPromos;
  public final String tType;
  public final Map<String, RichText> texts;
  public final String widgetId;
  
  Promo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, Map<String, Image> paramMap, Map<String, RichText> paramMap1, MetricsInfo paramMetricsInfo, Map<String, MetricsInfo> paramMap2, List<SubPromo> paramList, List<Bolton> paramList1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17)
  {
    tType = paramString1;
    widgetId = paramString2;
    appId = paramString3;
    appName = paramString4;
    actionUrl = paramString5;
    storeUrl = paramString6;
    legoTrackingToken = paramString7;
    needSyncRendering = paramBoolean1;
    noCache = paramBoolean2;
    if (paramMap == null)
    {
      paramString1 = null;
      images = paramString1;
      if (paramMap1 != null) {
        break label236;
      }
      paramString1 = null;
      label84:
      texts = paramString1;
      metricsObject = paramMetricsInfo;
      if (paramMap2 != null) {
        break label245;
      }
      paramString1 = null;
      label102:
      metricsMap = paramString1;
      if (paramList != null) {
        break label254;
      }
      paramString1 = null;
      label114:
      subPromos = paramString1;
      if (paramList1 != null) {
        break label263;
      }
    }
    label236:
    label245:
    label254:
    label263:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList1))
    {
      boltons = paramString1;
      hasTType = paramBoolean3;
      hasWidgetId = paramBoolean4;
      hasAppId = paramBoolean5;
      hasAppName = paramBoolean6;
      hasActionUrl = paramBoolean7;
      hasStoreUrl = paramBoolean8;
      hasLegoTrackingToken = paramBoolean9;
      hasNeedSyncRendering = paramBoolean10;
      hasNoCache = paramBoolean11;
      hasImages = paramBoolean12;
      hasTexts = paramBoolean13;
      hasMetricsObject = paramBoolean14;
      hasMetricsMap = paramBoolean15;
      hasSubPromos = paramBoolean16;
      hasBoltons = paramBoolean17;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableMap(paramMap);
      break;
      paramString1 = Collections.unmodifiableMap(paramMap1);
      break label84;
      paramString1 = Collections.unmodifiableMap(paramMap2);
      break label102;
      paramString1 = Collections.unmodifiableList(paramList);
      break label114;
    }
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
      paramObject = (Promo)paramObject;
      if (tType != null)
      {
        if (tType.equals(tType)) {}
      }
      else {
        while (tType != null) {
          return false;
        }
      }
      if (widgetId != null)
      {
        if (widgetId.equals(widgetId)) {}
      }
      else {
        while (widgetId != null) {
          return false;
        }
      }
      if (appId != null)
      {
        if (appId.equals(appId)) {}
      }
      else {
        while (appId != null) {
          return false;
        }
      }
      if (appName != null)
      {
        if (appName.equals(appName)) {}
      }
      else {
        while (appName != null) {
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
      if (legoTrackingToken != null)
      {
        if (legoTrackingToken.equals(legoTrackingToken)) {}
      }
      else {
        while (legoTrackingToken != null) {
          return false;
        }
      }
      if (needSyncRendering != needSyncRendering) {
        return false;
      }
      if (noCache != noCache) {
        return false;
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
      if (metricsObject != null)
      {
        if (metricsObject.equals(metricsObject)) {}
      }
      else {
        while (metricsObject != null) {
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
      if (subPromos != null)
      {
        if (subPromos.equals(subPromos)) {}
      }
      else {
        while (subPromos != null) {
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
    if (hasWidgetId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(widgetId);
    }
    j = i + 1;
    i = j;
    if (hasAppId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(appId);
    }
    j = i + 1;
    i = j;
    if (hasAppName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(appName);
    }
    j = i + 1;
    i = j;
    if (hasActionUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(actionUrl);
    }
    j = i + 1;
    i = j;
    if (hasStoreUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(storeUrl);
    }
    j = i + 1;
    i = j;
    if (hasLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
    }
    j = i + 1;
    i = j;
    if (hasNeedSyncRendering) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasNoCache) {
      i = j + 1;
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
    j += 1;
    i = j;
    if (hasMetricsObject)
    {
      i = j + 1;
      if (metricsObject._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(metricsObject._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasMetricsMap) {
        break label646;
      }
      i += 2;
      localIterator = metricsMap.entrySet().iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label646;
      }
      localObject = (Map.Entry)localIterator.next();
      j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
      localObject = (MetricsInfo)((Map.Entry)localObject).getValue();
      i = i + 2 + j + 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += metricsObject.getSerializedSize();
        break;
      }
      i += ((MetricsInfo)localObject).getSerializedSize();
    }
    label646:
    i = j + 1;
    j = i;
    if (hasSubPromos)
    {
      i += 2;
      localIterator = subPromos.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (SubPromo)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((SubPromo)localObject).getSerializedSize();
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
    int i4 = 1;
    int i10 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label48:
    int k;
    label63:
    int m;
    label79:
    int n;
    label95:
    int i1;
    label111:
    int i2;
    label127:
    int i3;
    label137:
    label144:
    int i5;
    label162:
    int i6;
    label180:
    int i7;
    label196:
    int i8;
    if (tType != null)
    {
      i = tType.hashCode();
      if (widgetId == null) {
        break label350;
      }
      j = widgetId.hashCode();
      if (appId == null) {
        break label355;
      }
      k = appId.hashCode();
      if (appName == null) {
        break label360;
      }
      m = appName.hashCode();
      if (actionUrl == null) {
        break label366;
      }
      n = actionUrl.hashCode();
      if (storeUrl == null) {
        break label372;
      }
      i1 = storeUrl.hashCode();
      if (legoTrackingToken == null) {
        break label378;
      }
      i2 = legoTrackingToken.hashCode();
      if (!needSyncRendering) {
        break label384;
      }
      i3 = 1;
      if (!noCache) {
        break label390;
      }
      if (images == null) {
        break label396;
      }
      i5 = images.hashCode();
      if (texts == null) {
        break label402;
      }
      i6 = texts.hashCode();
      if (metricsObject == null) {
        break label408;
      }
      i7 = metricsObject.hashCode();
      if (metricsMap == null) {
        break label414;
      }
      i8 = metricsMap.hashCode();
      label214:
      if (subPromos == null) {
        break label420;
      }
    }
    label350:
    label355:
    label360:
    label366:
    label372:
    label378:
    label384:
    label390:
    label396:
    label402:
    label408:
    label414:
    label420:
    for (int i9 = subPromos.hashCode();; i9 = 0)
    {
      if (boltons != null) {
        i10 = boltons.hashCode();
      }
      i = (i9 + (i8 + (i7 + (i6 + (i5 + ((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4) * 31) * 31) * 31) * 31) * 31) * 31 + i10;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label48;
      k = 0;
      break label63;
      m = 0;
      break label79;
      n = 0;
      break label95;
      i1 = 0;
      break label111;
      i2 = 0;
      break label127;
      i3 = 0;
      break label137;
      i4 = 0;
      break label144;
      i5 = 0;
      break label162;
      i6 = 0;
      break label180;
      i7 = 0;
      break label196;
      i8 = 0;
      break label214;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Promo");
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
    label216:
    label242:
    label268:
    label294:
    label318:
    label327:
    label351:
    label360:
    label512:
    label522:
    label532:
    label542:
    label552:
    label562:
    label572:
    label578:
    label588:
    label594:
    label627:
    label634:
    label1066:
    label1073:
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
        localByteBuffer.putInt(1005567923);
        Iterator localIterator;
        if (hasTType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, tType);
          if (!hasWidgetId) {
            break label512;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, widgetId);
          if (!hasAppId) {
            break label522;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appId);
          if (!hasAppName) {
            break label532;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appName);
          if (!hasActionUrl) {
            break label542;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, actionUrl);
          if (!hasStoreUrl) {
            break label552;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, storeUrl);
          if (!hasLegoTrackingToken) {
            break label562;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
          if (!hasNeedSyncRendering) {
            break label578;
          }
          localByteBuffer.put((byte)1);
          if (!needSyncRendering) {
            break label572;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasNoCache) {
            break label594;
          }
          localByteBuffer.put((byte)1);
          if (!noCache) {
            break label588;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasImages) {
            break label627;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, images.size());
          localIterator = images.entrySet().iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label634;
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
            localByteBuffer.put((byte)0);
            break label216;
            localByteBuffer.put((byte)0);
            break label242;
            localByteBuffer.put((byte)0);
            break label268;
            localByteBuffer.put((byte)0);
            break label294;
            i = 0;
            break label318;
            localByteBuffer.put((byte)0);
            break label327;
            i = 0;
            break label351;
            localByteBuffer.put((byte)0);
            break label360;
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
        if (hasMetricsObject)
        {
          localByteBuffer.put((byte)1);
          if (metricsObject._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, metricsObject._cachedId);
            metricsObject.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMetricsMap) {
              break label1066;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, metricsMap.size());
            localIterator = metricsMap.entrySet().iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label1073;
          }
          localObject = (Map.Entry)localIterator.next();
          paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
          localObject = (MetricsInfo)((Map.Entry)localObject).getValue();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((MetricsInfo)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            metricsObject.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          ((MetricsInfo)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasSubPromos)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, subPromos.size());
          localIterator = subPromos.iterator();
          while (localIterator.hasNext())
          {
            localObject = (SubPromo)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((SubPromo)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((SubPromo)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.Promo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */