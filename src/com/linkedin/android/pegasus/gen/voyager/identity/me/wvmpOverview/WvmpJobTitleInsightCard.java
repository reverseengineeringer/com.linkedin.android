package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Insight;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadata;
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

public final class WvmpJobTitleInsightCard
  implements FissileDataModel<WvmpJobTitleInsightCard>, RecordTemplate<WvmpJobTitleInsightCard>
{
  public static final WvmpJobTitleInsightCardBuilder BUILDER = WvmpJobTitleInsightCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Card> cards;
  public final boolean hasCards;
  public final boolean hasInsight;
  public final boolean hasNumViews;
  public final boolean hasViewerTitle;
  public final boolean hasWvmpMetadata;
  public final Insight insight;
  public final long numViews;
  public final String viewerTitle;
  public final WvmpMetadata wvmpMetadata;
  
  WvmpJobTitleInsightCard(long paramLong, String paramString, Insight paramInsight, List<Card> paramList, WvmpMetadata paramWvmpMetadata, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    numViews = paramLong;
    viewerTitle = paramString;
    insight = paramInsight;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      cards = paramString;
      wvmpMetadata = paramWvmpMetadata;
      hasNumViews = paramBoolean1;
      hasViewerTitle = paramBoolean2;
      hasInsight = paramBoolean3;
      hasCards = paramBoolean4;
      hasWvmpMetadata = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final WvmpJobTitleInsightCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    if (hasViewerTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("viewerTitle");
      paramDataProcessor.processString(viewerTitle);
    }
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label106:
    boolean bool2;
    int i;
    if (hasInsight)
    {
      paramDataProcessor.startRecordField$505cff1c("insight");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = insight.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label272;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasCards) {
        break label311;
      }
      paramDataProcessor.startRecordField$505cff1c("cards");
      cards.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = cards.iterator();
      label181:
      if (!localIterator.hasNext()) {
        break label297;
      }
      localObject2 = (Card)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label281;
      }
    }
    label272:
    label281:
    for (Object localObject2 = ((Card)localObject2).accept(paramDataProcessor);; localObject2 = (Card)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label181;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label106;
    }
    label297:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      label311:
      localObject2 = null;
      bool3 = false;
      if (hasWvmpMetadata)
      {
        paramDataProcessor.startRecordField$505cff1c("wvmpMetadata");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label421;
        }
        localObject2 = wvmpMetadata.accept(paramDataProcessor);
        label351:
        if (localObject2 == null) {
          break label439;
        }
      }
    }
    label421:
    label439:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label549;
      }
      if (!hasCards) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasNumViews) {
          break label445;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard", "numViews");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      break;
      localObject2 = (WvmpMetadata)paramDataProcessor.processDataTemplate(wvmpMetadata);
      break label351;
    }
    label445:
    if (!hasViewerTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard", "viewerTitle");
    }
    if (cards != null)
    {
      paramDataProcessor = cards.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Card)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard", "cards");
        }
      }
    }
    return new WvmpJobTitleInsightCard(numViews, viewerTitle, (Insight)localObject3, (List)localObject1, (WvmpMetadata)localObject2, hasNumViews, hasViewerTitle, bool1, bool2, bool3);
    label549:
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
      paramObject = (WvmpJobTitleInsightCard)paramObject;
      if (numViews != numViews) {
        return false;
      }
      if (viewerTitle != null)
      {
        if (viewerTitle.equals(viewerTitle)) {}
      }
      else {
        while (viewerTitle != null) {
          return false;
        }
      }
      if (insight != null)
      {
        if (insight.equals(insight)) {}
      }
      else {
        while (insight != null) {
          return false;
        }
      }
      if (cards != null)
      {
        if (cards.equals(cards)) {}
      }
      else {
        while (cards != null) {
          return false;
        }
      }
      if (wvmpMetadata == null) {
        break;
      }
    } while (wvmpMetadata.equals(wvmpMetadata));
    for (;;)
    {
      return false;
      if (wvmpMetadata == null) {
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
    if (hasNumViews) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasViewerTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(viewerTitle);
    }
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasInsight)
    {
      i = j + 1;
      if (insight._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasCards) {
        break label202;
      }
      i += 2;
      localIterator = cards.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label202;
      }
      Card localCard = (Card)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += insight.getSerializedSize();
        break;
      }
      i += localCard.getSerializedSize();
    }
    label202:
    j += 1;
    i = j;
    if (hasWvmpMetadata)
    {
      i = j + 1;
      if (wvmpMetadata._cachedId == null) {
        break label251;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpMetadata._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label251:
      i += wvmpMetadata.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int n = (int)(numViews ^ numViews >>> 32);
    int i;
    int j;
    if (viewerTitle != null)
    {
      i = viewerTitle.hashCode();
      if (insight == null) {
        break label133;
      }
      j = insight.hashCode();
      label60:
      if (cards == null) {
        break label138;
      }
    }
    label133:
    label138:
    for (int k = cards.hashCode();; k = 0)
    {
      if (wvmpMetadata != null) {
        m = wvmpMetadata.hashCode();
      }
      i = (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpJobTitleInsightCard");
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
    label161:
    label221:
    label338:
    label348:
    label373:
    label406:
    label413:
    label541:
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
        localByteBuffer.putInt(1094987066);
        Iterator localIterator;
        if (hasNumViews)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasViewerTitle) {
            break label338;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, viewerTitle);
          if (!hasInsight) {
            break label373;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label348;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCards) {
            break label406;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, cards.size());
          localIterator = cards.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label413;
          }
          Card localCard = (Card)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localCard.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label161;
            localByteBuffer.put((byte)1);
            insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label221;
            localByteBuffer.put((byte)0);
            break label221;
          }
          localByteBuffer.put((byte)1);
          localCard.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasWvmpMetadata)
        {
          localByteBuffer.put((byte)1);
          if (wvmpMetadata._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, wvmpMetadata._cachedId);
            wvmpMetadata.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label541;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          wvmpMetadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */