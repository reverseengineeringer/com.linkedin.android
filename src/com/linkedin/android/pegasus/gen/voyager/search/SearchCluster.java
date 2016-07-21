package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class SearchCluster
  implements FissileDataModel<SearchCluster>, RecordTemplate<SearchCluster>
{
  public static final SearchClusterBuilder BUILDER = SearchClusterBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<SearchHit> elements;
  public final List<Guide> guides;
  public final boolean hasElements;
  public final boolean hasGuides;
  public final boolean hasHitType;
  public final boolean hasKeywords;
  public final boolean hasTitle;
  public final boolean hasTotal;
  public final boolean hasType;
  public final SearchType hitType;
  public final String keywords;
  public final String title;
  public final long total;
  public final ClusterType type;
  
  SearchCluster(String paramString1, long paramLong, List<SearchHit> paramList, List<Guide> paramList1, String paramString2, ClusterType paramClusterType, SearchType paramSearchType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    title = paramString1;
    total = paramLong;
    if (paramList == null)
    {
      paramString1 = null;
      elements = paramString1;
      if (paramList1 != null) {
        break label123;
      }
    }
    label123:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList1))
    {
      guides = paramString1;
      keywords = paramString2;
      type = paramClusterType;
      hitType = paramSearchType;
      hasTitle = paramBoolean1;
      hasTotal = paramBoolean2;
      hasElements = paramBoolean3;
      hasGuides = paramBoolean4;
      hasKeywords = paramBoolean5;
      hasType = paramBoolean6;
      hasHitType = paramBoolean7;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  private SearchCluster accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasTotal)
    {
      paramDataProcessor.startRecordField$505cff1c("total");
      paramDataProcessor.processLong(total);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    if (hasElements)
    {
      paramDataProcessor.startRecordField$505cff1c("elements");
      elements.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = elements.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (SearchHit)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((SearchHit)localObject2).accept(paramDataProcessor);; localObject2 = (SearchHit)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      localObject3 = null;
      bool2 = false;
      if (!hasGuides) {
        break label415;
      }
      paramDataProcessor.startRecordField$505cff1c("guides");
      guides.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = guides.iterator();
      label307:
      if (!localIterator.hasNext()) {
        break label401;
      }
      localObject3 = (Guide)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label385;
      }
    }
    label385:
    for (Object localObject3 = ((Guide)localObject3).accept(paramDataProcessor);; localObject3 = (Guide)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label307;
      bool1 = false;
      break;
    }
    label401:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label415:
      if (hasKeywords)
      {
        paramDataProcessor.startRecordField$505cff1c("keywords");
        paramDataProcessor.processString(keywords);
      }
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      if (hasHitType)
      {
        paramDataProcessor.startRecordField$505cff1c("hitType");
        paramDataProcessor.processEnum(hitType);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label738;
      }
      if (!hasElements) {
        localObject1 = Collections.emptyList();
      }
      if (!hasGuides) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchCluster", "type");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasHitType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchCluster", "hitType");
    }
    if (elements != null)
    {
      paramDataProcessor = elements.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchHit)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchCluster", "elements");
        }
      }
    }
    if (guides != null)
    {
      paramDataProcessor = guides.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Guide)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchCluster", "guides");
        }
      }
    }
    return new SearchCluster(title, total, (List)localObject1, (List)localObject2, keywords, type, hitType, hasTitle, hasTotal, bool1, bool2, hasKeywords, hasType, hasHitType);
    label738:
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
      paramObject = (SearchCluster)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (total != total) {
        return false;
      }
      if (elements != null)
      {
        if (elements.equals(elements)) {}
      }
      else {
        while (elements != null) {
          return false;
        }
      }
      if (guides != null)
      {
        if (guides.equals(guides)) {}
      }
      else {
        while (guides != null) {
          return false;
        }
      }
      if (keywords != null)
      {
        if (keywords.equals(keywords)) {}
      }
      else {
        while (keywords != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (hitType == null) {
        break;
      }
    } while (hitType.equals(hitType));
    for (;;)
    {
      return false;
      if (hitType == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTotal) {
      i = j + 8;
    }
    i += 1;
    j = i;
    Iterator localIterator;
    Object localObject;
    if (hasElements)
    {
      i += 2;
      localIterator = elements.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (SearchHit)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((SearchHit)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasGuides)
    {
      i += 2;
      localIterator = guides.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Guide)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Guide)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasKeywords) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(keywords);
    }
    j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasHitType) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int i2;
    int j;
    label62:
    int k;
    label79:
    int m;
    if (title != null)
    {
      i = title.hashCode();
      i2 = (int)(total ^ total >>> 32);
      if (elements == null) {
        break label179;
      }
      j = elements.hashCode();
      if (guides == null) {
        break label184;
      }
      k = guides.hashCode();
      if (keywords == null) {
        break label189;
      }
      m = keywords.hashCode();
      label95:
      if (type == null) {
        break label195;
      }
    }
    label179:
    label184:
    label189:
    label195:
    for (int n = type.hashCode();; n = 0)
    {
      if (hitType != null) {
        i1 = hitType.hashCode();
      }
      i = (n + (m + (k + (j + ((i + 527) * 31 + i2) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label62;
      k = 0;
      break label79;
      m = 0;
      break label95;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchCluster");
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
    label511:
    label583:
    label593:
    label601:
    label603:
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
        localByteBuffer.putInt(1837770504);
        Iterator localIterator;
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasTotal) {
            break label279;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(total);
          if (!hasElements) {
            break label312;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, elements.size());
          localIterator = elements.iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label319;
          }
          localObject = (SearchHit)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((SearchHit)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label162;
          }
          localByteBuffer.put((byte)1);
          ((SearchHit)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasGuides)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, guides.size());
          localIterator = guides.iterator();
          while (localIterator.hasNext())
          {
            localObject = (Guide)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Guide)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((Guide)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasKeywords)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, keywords);
          if (!hasType) {
            break label583;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasHitType) {
            break label593;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, hitType.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label601;
          }
          if (str != null) {
            break label603;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label511;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchCluster
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */