package com.linkedin.android.pegasus.gen.restli.common;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CollectionMetadata
  implements FissileDataModel<CollectionMetadata>, RecordTemplate<CollectionMetadata>
{
  public static final CollectionMetadataBuilder BUILDER = CollectionMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final int count;
  public final boolean hasCount;
  public final boolean hasLinks;
  public final boolean hasStart;
  public final boolean hasTotal;
  public final List<Link> links;
  public final int start;
  public final int total;
  
  CollectionMetadata(int paramInt1, int paramInt2, int paramInt3, List<Link> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    start = paramInt1;
    count = paramInt2;
    total = paramInt3;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      links = paramList;
      hasStart = paramBoolean1;
      hasCount = paramBoolean2;
      hasTotal = paramBoolean3;
      hasLinks = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final CollectionMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStart)
    {
      paramDataProcessor.startRecordField$505cff1c("start");
      paramDataProcessor.processInt(start);
    }
    if (hasCount)
    {
      paramDataProcessor.startRecordField$505cff1c("count");
      paramDataProcessor.processInt(count);
    }
    if (hasTotal)
    {
      paramDataProcessor.startRecordField$505cff1c("total");
      paramDataProcessor.processInt(total);
    }
    Object localObject = null;
    Link localLink = null;
    boolean bool = false;
    if (hasLinks)
    {
      paramDataProcessor.startRecordField$505cff1c("links");
      links.size();
      paramDataProcessor.startArray$13462e();
      localObject = localLink;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = links.iterator();
      if (localIterator.hasNext())
      {
        localLink = (Link)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localLink = localLink.accept(paramDataProcessor);; localLink = (Link)paramDataProcessor.processDataTemplate(localLink))
        {
          if ((localObject != null) && (localLink != null)) {
            ((List)localObject).add(localLink);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label429;
      }
      try
      {
        if (hasStart) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "start");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "count");
    }
    if (!hasLinks) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "links");
    }
    if (links != null)
    {
      paramDataProcessor = links.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Link)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "links");
        }
      }
    }
    return new CollectionMetadata(start, count, total, (List)localObject, hasStart, hasCount, hasTotal, bool);
    label429:
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
      paramObject = (CollectionMetadata)paramObject;
      if (start != start) {
        return false;
      }
      if (count != count) {
        return false;
      }
      if (total != total) {
        return false;
      }
      if (links == null) {
        break;
      }
    } while (links.equals(links));
    for (;;)
    {
      return false;
      if (links == null) {
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
    if (hasStart) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasCount) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasTotal) {
      i = j + 4;
    }
    i += 1;
    j = i;
    if (hasLinks)
    {
      i += 2;
      Iterator localIterator = links.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Link localLink = (Link)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localLink.getSerializedSize();
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
    int j = start;
    int k = count;
    int m = total;
    if (links != null) {}
    for (int i = links.hashCode();; i = 0)
    {
      i = (((j + 527) * 31 + k) * 31 + m) * 31 + i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CollectionMetadata");
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
    label182:
    label299:
    label309:
    label342:
    label349:
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
        localByteBuffer.putInt(277983044);
        Iterator localIterator;
        if (hasStart)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(start);
          if (!hasCount) {
            break label299;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(count);
          if (!hasTotal) {
            break label309;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(total);
          if (!hasLinks) {
            break label342;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, links.size());
          localIterator = links.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label349;
          }
          Link localLink = (Link)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localLink.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label158;
            localByteBuffer.put((byte)0);
            break label182;
          }
          localByteBuffer.put((byte)1);
          localLink.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<CollectionMetadata>
  {
    private int count = 0;
    private boolean hasCount = false;
    private boolean hasLinks = false;
    private boolean hasStart = false;
    private boolean hasTotal = false;
    private List<Link> links = null;
    private int start = 0;
    private int total = 0;
    
    public Builder() {}
    
    public Builder(CollectionMetadata paramCollectionMetadata)
    {
      start = start;
      count = count;
      total = total;
      links = links;
      hasStart = hasStart;
      hasCount = hasCount;
      hasTotal = hasTotal;
      hasLinks = hasLinks;
    }
    
    public final CollectionMetadata build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final CollectionMetadata build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (CollectionMetadata.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (links != null)
      {
        paramFlavor = links.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Link)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "links");
              if (!hasTotal) {
                total = 0;
              }
              if (!hasStart) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "start");
              }
              if (!hasCount) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "count");
              }
              if (hasLinks) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "links");
            }
          }
        }
      }
      return new CollectionMetadata(start, count, total, links, hasStart, hasCount, hasTotal, hasLinks);
    }
    
    public final Builder setCount(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasCount = false;
        count = 0;
        return this;
      }
      hasCount = true;
      count = paramInteger.intValue();
      return this;
    }
    
    public final Builder setLinks(List<Link> paramList)
    {
      if (paramList == null)
      {
        hasLinks = false;
        links = null;
        return this;
      }
      hasLinks = true;
      links = paramList;
      return this;
    }
    
    public final Builder setStart(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasStart = false;
        start = 0;
        return this;
      }
      hasStart = true;
      start = paramInteger.intValue();
      return this;
    }
    
    public final Builder setTotal(Integer paramInteger)
    {
      if ((paramInteger == null) || (paramInteger.intValue() == 0))
      {
        hasTotal = false;
        total = 0;
        return this;
      }
      hasTotal = true;
      total = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */