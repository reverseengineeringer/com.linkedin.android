package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
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

public final class WvmpSummaryInsightCard
  implements FissileDataModel<WvmpSummaryInsightCard>, RecordTemplate<WvmpSummaryInsightCard>
{
  public static final WvmpSummaryInsightCardBuilder BUILDER = WvmpSummaryInsightCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Card> cards;
  public final boolean hasCards;
  public final boolean hasNumViews;
  public final boolean hasNumViewsChangeInPercentage;
  public final boolean hasTimeFrame;
  public final boolean hasWvmpMetadata;
  public final long numViews;
  public final int numViewsChangeInPercentage;
  public final TimeFrame timeFrame;
  public final WvmpMetadata wvmpMetadata;
  
  WvmpSummaryInsightCard(long paramLong, int paramInt, List<Card> paramList, TimeFrame paramTimeFrame, WvmpMetadata paramWvmpMetadata, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    numViews = paramLong;
    numViewsChangeInPercentage = paramInt;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      cards = paramList;
      timeFrame = paramTimeFrame;
      wvmpMetadata = paramWvmpMetadata;
      hasNumViews = paramBoolean1;
      hasNumViewsChangeInPercentage = paramBoolean2;
      hasCards = paramBoolean3;
      hasTimeFrame = paramBoolean4;
      hasWvmpMetadata = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final WvmpSummaryInsightCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    if (hasNumViewsChangeInPercentage)
    {
      paramDataProcessor.startRecordField$505cff1c("numViewsChangeInPercentage");
      paramDataProcessor.processInt(numViewsChangeInPercentage);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasCards)
    {
      paramDataProcessor.startRecordField$505cff1c("cards");
      cards.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = cards.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (Card)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Card)localObject2).accept(paramDataProcessor);; localObject2 = (Card)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      if (hasTimeFrame)
      {
        paramDataProcessor.startRecordField$505cff1c("timeFrame");
        paramDataProcessor.processEnum(timeFrame);
      }
      localObject2 = null;
      bool2 = false;
      if (hasWvmpMetadata)
      {
        paramDataProcessor.startRecordField$505cff1c("wvmpMetadata");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label366;
        }
        localObject2 = wvmpMetadata.accept(paramDataProcessor);
        label297:
        if (localObject2 == null) {
          break label384;
        }
      }
    }
    label366:
    label384:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label498;
      }
      if (!hasCards) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasNumViews) {
          break label390;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard", "numViews");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (WvmpMetadata)paramDataProcessor.processDataTemplate(wvmpMetadata);
      break label297;
    }
    label390:
    if (!hasTimeFrame) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard", "timeFrame");
    }
    if (cards != null)
    {
      paramDataProcessor = cards.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Card)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard", "cards");
        }
      }
    }
    return new WvmpSummaryInsightCard(numViews, numViewsChangeInPercentage, (List)localObject1, timeFrame, (WvmpMetadata)localObject2, hasNumViews, hasNumViewsChangeInPercentage, bool1, hasTimeFrame, bool2);
    label498:
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
      paramObject = (WvmpSummaryInsightCard)paramObject;
      if (numViews != numViews) {
        return false;
      }
      if (numViewsChangeInPercentage != numViewsChangeInPercentage) {
        return false;
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
      if (timeFrame != null)
      {
        if (timeFrame.equals(timeFrame)) {}
      }
      else {
        while (timeFrame != null) {
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
    if (hasNumViewsChangeInPercentage) {
      i = j + 4;
    }
    i += 1;
    j = i;
    if (hasCards)
    {
      i += 2;
      Iterator localIterator = cards.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Card localCard = (Card)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localCard.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTimeFrame) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasWvmpMetadata)
    {
      i = j + 1;
      if (wvmpMetadata._cachedId == null) {
        break label205;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpMetadata._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label205:
      i += wvmpMetadata.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int m = (int)(numViews ^ numViews >>> 32);
    int n = numViewsChangeInPercentage;
    int i;
    if (cards != null)
    {
      i = cards.hashCode();
      if (timeFrame == null) {
        break label122;
      }
    }
    label122:
    for (int j = timeFrame.hashCode();; j = 0)
    {
      if (wvmpMetadata != null) {
        k = wvmpMetadata.hashCode();
      }
      i = (j + (i + ((m + 527) * 31 + n) * 31) * 31) * 31 + k;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpSummaryInsightCard");
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
    label158:
    label275:
    label308:
    label315:
    label447:
    label472:
    label480:
    label482:
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
        localByteBuffer.putInt(2033088297);
        Iterator localIterator;
        if (hasNumViews)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasNumViewsChangeInPercentage) {
            break label275;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numViewsChangeInPercentage);
          if (!hasCards) {
            break label308;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, cards.size());
          localIterator = cards.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label315;
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
            break label158;
          }
          localByteBuffer.put((byte)1);
          localCard.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasTimeFrame)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, timeFrame.ordinal());
          if (!hasWvmpMetadata) {
            break label472;
          }
          localByteBuffer.put((byte)1);
          if (wvmpMetadata._cachedId == null) {
            break label447;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, wvmpMetadata._cachedId);
          wvmpMetadata.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label480;
          }
          if (str != null) {
            break label482;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */