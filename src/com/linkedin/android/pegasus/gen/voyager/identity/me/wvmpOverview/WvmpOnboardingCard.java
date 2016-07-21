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

public final class WvmpOnboardingCard
  implements FissileDataModel<WvmpOnboardingCard>, RecordTemplate<WvmpOnboardingCard>
{
  public static final WvmpOnboardingCardBuilder BUILDER = WvmpOnboardingCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Card> cards;
  public final boolean hasCards;
  public final boolean hasLegoTrackingToken;
  public final boolean hasWvmpMetadata;
  public final String legoTrackingToken;
  public final WvmpMetadata wvmpMetadata;
  
  WvmpOnboardingCard(String paramString, List<Card> paramList, WvmpMetadata paramWvmpMetadata, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    legoTrackingToken = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      cards = paramString;
      wvmpMetadata = paramWvmpMetadata;
      hasLegoTrackingToken = paramBoolean1;
      hasCards = paramBoolean2;
      hasWvmpMetadata = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final WvmpOnboardingCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasLegoTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
      paramDataProcessor.processString(legoTrackingToken);
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
      localObject2 = null;
      bool2 = false;
      if (hasWvmpMetadata)
      {
        paramDataProcessor.startRecordField$505cff1c("wvmpMetadata");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label316;
        }
        localObject2 = wvmpMetadata.accept(paramDataProcessor);
        label247:
        if (localObject2 == null) {
          break label334;
        }
      }
    }
    label316:
    label334:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label413;
      }
      if (!hasCards) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasLegoTrackingToken) {
          break label340;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCard", "legoTrackingToken");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (WvmpMetadata)paramDataProcessor.processDataTemplate(wvmpMetadata);
      break label247;
    }
    label340:
    if (cards != null)
    {
      paramDataProcessor = cards.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Card)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCard", "cards");
        }
      }
    }
    return new WvmpOnboardingCard(legoTrackingToken, (List)localObject1, (WvmpMetadata)localObject2, hasLegoTrackingToken, bool1, bool2);
    label413:
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
      paramObject = (WvmpOnboardingCard)paramObject;
      if (legoTrackingToken != null)
      {
        if (legoTrackingToken.equals(legoTrackingToken)) {}
      }
      else {
        while (legoTrackingToken != null) {
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
    int i = 0 + 1 + 4 + 1;
    if (hasLegoTrackingToken) {
      i = PegasusBinaryUtils.getEncodedLength(legoTrackingToken) + 8;
    }
    i += 1;
    int j = i;
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
    if (hasWvmpMetadata)
    {
      i = j + 1;
      if (wvmpMetadata._cachedId == null) {
        break label175;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpMetadata._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label175:
      i += wvmpMetadata.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (legoTrackingToken != null)
    {
      i = legoTrackingToken.hashCode();
      if (cards == null) {
        break label89;
      }
    }
    label89:
    for (int j = cards.hashCode();; j = 0)
    {
      if (wvmpMetadata != null) {
        k = wvmpMetadata.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpOnboardingCard");
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
    label283:
    label411:
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
        localByteBuffer.putInt(507372460);
        Iterator localIterator;
        if (hasLegoTrackingToken)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
          if (hasCards)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, cards.size());
            localIterator = cards.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
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
            }
            localByteBuffer.put((byte)1);
            localCard.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
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
            break label411;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */