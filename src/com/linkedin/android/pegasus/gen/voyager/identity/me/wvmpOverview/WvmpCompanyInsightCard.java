package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
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

public final class WvmpCompanyInsightCard
  implements FissileDataModel<WvmpCompanyInsightCard>, RecordTemplate<WvmpCompanyInsightCard>
{
  public static final WvmpCompanyInsightCardBuilder BUILDER = WvmpCompanyInsightCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Card> cards;
  public final List<EntitiesFlavor> flavors;
  public final boolean hasCards;
  public final boolean hasFlavors;
  public final boolean hasInsight;
  public final boolean hasMiniCompany;
  public final boolean hasNumViews;
  public final boolean hasWvmpMetadata;
  public final Insight insight;
  public final MiniCompany miniCompany;
  public final long numViews;
  public final WvmpMetadata wvmpMetadata;
  
  WvmpCompanyInsightCard(long paramLong, Insight paramInsight, MiniCompany paramMiniCompany, List<Card> paramList, WvmpMetadata paramWvmpMetadata, List<EntitiesFlavor> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    numViews = paramLong;
    insight = paramInsight;
    miniCompany = paramMiniCompany;
    if (paramList == null)
    {
      paramInsight = null;
      cards = paramInsight;
      wvmpMetadata = paramWvmpMetadata;
      if (paramList1 != null) {
        break label111;
      }
    }
    label111:
    for (paramInsight = null;; paramInsight = Collections.unmodifiableList(paramList1))
    {
      flavors = paramInsight;
      hasNumViews = paramBoolean1;
      hasInsight = paramBoolean2;
      hasMiniCompany = paramBoolean3;
      hasCards = paramBoolean4;
      hasWvmpMetadata = paramBoolean5;
      hasFlavors = paramBoolean6;
      _cachedId = null;
      return;
      paramInsight = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final WvmpCompanyInsightCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    Object localObject4;
    boolean bool2;
    label121:
    label133:
    boolean bool3;
    int i;
    Object localObject5;
    if (hasInsight)
    {
      paramDataProcessor.startRecordField$505cff1c("insight");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = insight.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label299;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject4 = null;
      bool2 = false;
      if (hasMiniCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("miniCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label308;
        }
        localObject1 = miniCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label326;
        }
        bool2 = true;
        localObject4 = localObject1;
      }
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasCards) {
        break label366;
      }
      paramDataProcessor.startRecordField$505cff1c("cards");
      cards.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject5 = cards.iterator();
      label208:
      if (!((Iterator)localObject5).hasNext()) {
        break label352;
      }
      localObject2 = (Card)((Iterator)localObject5).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label336;
      }
    }
    label299:
    label308:
    label326:
    label336:
    for (Object localObject2 = ((Card)localObject2).accept(paramDataProcessor);; localObject2 = (Card)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label208;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label81;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break label121;
      bool2 = false;
      localObject4 = localObject1;
      break label133;
    }
    label352:
    paramDataProcessor.endArray();
    label366:
    boolean bool4;
    if (localObject1 != null)
    {
      bool3 = true;
      localObject5 = null;
      bool4 = false;
      if (hasWvmpMetadata)
      {
        paramDataProcessor.startRecordField$505cff1c("wvmpMetadata");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label572;
        }
        localObject2 = wvmpMetadata.accept(paramDataProcessor);
        label406:
        if (localObject2 == null) {
          break label590;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      label418:
      localObject2 = null;
      localEntitiesFlavor = null;
      bool5 = false;
      if (!hasFlavors) {
        break label630;
      }
      paramDataProcessor.startRecordField$505cff1c("flavors");
      flavors.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localEntitiesFlavor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = flavors.iterator();
      label493:
      if (!localIterator.hasNext()) {
        break label616;
      }
      localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label600;
      }
    }
    label572:
    label590:
    label600:
    for (EntitiesFlavor localEntitiesFlavor = localEntitiesFlavor.accept(paramDataProcessor);; localEntitiesFlavor = (EntitiesFlavor)paramDataProcessor.processDataTemplate(localEntitiesFlavor))
    {
      if ((localObject2 != null) && (localEntitiesFlavor != null)) {
        ((List)localObject2).add(localEntitiesFlavor);
      }
      i += 1;
      break label493;
      bool3 = false;
      break;
      localObject2 = (WvmpMetadata)paramDataProcessor.processDataTemplate(wvmpMetadata);
      break label406;
      bool4 = false;
      localObject5 = localObject2;
      break label418;
    }
    label616:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label630:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label858;
      }
      if (!hasCards) {
        localObject1 = Collections.emptyList();
      }
      if (!hasFlavors) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasNumViews) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard", "numViews");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasMiniCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard", "miniCompany");
    }
    if (cards != null)
    {
      paramDataProcessor = cards.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Card)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard", "cards");
        }
      }
    }
    if (flavors != null)
    {
      paramDataProcessor = flavors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesFlavor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard", "flavors");
        }
      }
    }
    return new WvmpCompanyInsightCard(numViews, (Insight)localObject3, (MiniCompany)localObject4, (List)localObject1, (WvmpMetadata)localObject5, (List)localObject2, hasNumViews, bool1, bool2, bool3, bool4, bool5);
    label858:
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
      paramObject = (WvmpCompanyInsightCard)paramObject;
      if (numViews != numViews) {
        return false;
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
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
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
      if (wvmpMetadata != null)
      {
        if (wvmpMetadata.equals(wvmpMetadata)) {}
      }
      else {
        while (wvmpMetadata != null) {
          return false;
        }
      }
      if (flavors == null) {
        break;
      }
    } while (flavors.equals(flavors));
    for (;;)
    {
      return false;
      if (flavors == null) {
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
    label118:
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
      j = i + 1;
      i = j;
      if (hasMiniCompany)
      {
        i = j + 1;
        if (miniCompany._cachedId == null) {
          break label208;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId);
      }
      i += 1;
      j = i;
      if (!hasCards) {
        break label232;
      }
      i += 2;
      localIterator = cards.iterator();
    }
    Object localObject;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label232;
      }
      localObject = (Card)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += insight.getSerializedSize();
        break;
        label208:
        i += miniCompany.getSerializedSize();
        break label118;
      }
      i += ((Card)localObject).getSerializedSize();
    }
    label232:
    j += 1;
    i = j;
    if (hasWvmpMetadata)
    {
      i = j + 1;
      if (wvmpMetadata._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(wvmpMetadata._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasFlavors) {
        break label375;
      }
      i += 2;
      localIterator = flavors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label375;
      }
      localObject = (EntitiesFlavor)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += wvmpMetadata.getSerializedSize();
        break;
      }
      i += ((EntitiesFlavor)localObject).getSerializedSize();
    }
    label375:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = (int)(numViews ^ numViews >>> 32);
    int i;
    int j;
    label60:
    int k;
    if (insight != null)
    {
      i = insight.hashCode();
      if (miniCompany == null) {
        break label157;
      }
      j = miniCompany.hashCode();
      if (cards == null) {
        break label162;
      }
      k = cards.hashCode();
      label77:
      if (wvmpMetadata == null) {
        break label167;
      }
    }
    label157:
    label162:
    label167:
    for (int m = wvmpMetadata.hashCode();; m = 0)
    {
      if (flavors != null) {
        n = flavors.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
      k = 0;
      break label77;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpCompanyInsightCard");
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
    label196:
    label256:
    label373:
    label398:
    label408:
    label433:
    label466:
    label473:
    label698:
    label705:
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
        localByteBuffer.putInt(624413709);
        Iterator localIterator;
        if (hasNumViews)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasInsight) {
            break label398;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label373;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMiniCompany) {
            break label433;
          }
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId == null) {
            break label408;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
          miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCards) {
            break label466;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, cards.size());
          localIterator = cards.iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label473;
          }
          localObject = (Card)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((Card)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label196;
            localByteBuffer.put((byte)0);
            break label196;
            localByteBuffer.put((byte)1);
            miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label256;
            localByteBuffer.put((byte)0);
            break label256;
          }
          localByteBuffer.put((byte)1);
          ((Card)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
            if (!hasFlavors) {
              break label698;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, flavors.size());
            localIterator = flavors.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label705;
          }
          localObject = (EntitiesFlavor)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((EntitiesFlavor)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            wvmpMetadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          ((EntitiesFlavor)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */