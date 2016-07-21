package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

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

public final class WvmpViewersCard
  implements FissileDataModel<WvmpViewersCard>, RecordTemplate<WvmpViewersCard>
{
  public static final WvmpViewersCardBuilder BUILDER = WvmpViewersCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasInsightCards;
  public final List<WvmpInsightCard> insightCards;
  
  WvmpViewersCard(List<WvmpInsightCard> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      insightCards = paramList;
      hasInsightCards = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final WvmpViewersCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    WvmpInsightCard localWvmpInsightCard = null;
    boolean bool = false;
    if (hasInsightCards)
    {
      paramDataProcessor.startRecordField$505cff1c("insightCards");
      insightCards.size();
      paramDataProcessor.startArray$13462e();
      localObject = localWvmpInsightCard;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = insightCards.iterator();
      if (localIterator.hasNext())
      {
        localWvmpInsightCard = (WvmpInsightCard)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localWvmpInsightCard = localWvmpInsightCard.accept(paramDataProcessor);; localWvmpInsightCard = (WvmpInsightCard)paramDataProcessor.processDataTemplate(localWvmpInsightCard))
        {
          if ((localObject != null) && (localWvmpInsightCard != null)) {
            ((List)localObject).add(localWvmpInsightCard);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label226;
      }
    }
    label226:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label292;
      }
      try
      {
        if (hasInsightCards) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCard", "insightCards");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (insightCards != null)
    {
      paramDataProcessor = insightCards.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((WvmpInsightCard)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCard", "insightCards");
        }
      }
    }
    return new WvmpViewersCard((List)localObject, bool);
    label292:
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
      paramObject = (WvmpViewersCard)paramObject;
      if (insightCards == null) {
        break;
      }
    } while (insightCards.equals(insightCards));
    for (;;)
    {
      return false;
      if (insightCards == null) {
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
    int j = i;
    if (hasInsightCards)
    {
      i += 2;
      Iterator localIterator = insightCards.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        WvmpInsightCard localWvmpInsightCard = (WvmpInsightCard)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localWvmpInsightCard.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (insightCards != null) {}
    for (int i = insightCards.hashCode();; i = 0)
    {
      i += 527;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpViewersCard");
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
        localByteBuffer.putInt(164428667);
        if (hasInsightCards)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, insightCards.size());
          Iterator localIterator = insightCards.iterator();
          while (localIterator.hasNext())
          {
            WvmpInsightCard localWvmpInsightCard = (WvmpInsightCard)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localWvmpInsightCard.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localWvmpInsightCard.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */