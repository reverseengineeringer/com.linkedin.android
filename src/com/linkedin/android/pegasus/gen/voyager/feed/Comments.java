package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
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

public final class Comments
  implements FissileDataModel<Comments>, RecordTemplate<Comments>
{
  public static final CommentsBuilder BUILDER = CommentsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Comment> elements;
  public final boolean hasElements;
  public final boolean hasMetadata;
  public final boolean hasPaging;
  public final Metadata metadata;
  public final CollectionMetadata paging;
  
  Comments(List<Comment> paramList, CollectionMetadata paramCollectionMetadata, Metadata paramMetadata, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      elements = paramList;
      paging = paramCollectionMetadata;
      metadata = paramMetadata;
      hasElements = paramBoolean1;
      hasPaging = paramBoolean2;
      hasMetadata = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final Comments accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    if (hasElements)
    {
      paramDataProcessor.startRecordField$505cff1c("elements");
      elements.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject3 = elements.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Comment)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Comment)localObject2).accept(paramDataProcessor);; localObject2 = (Comment)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      bool2 = false;
      if (hasPaging)
      {
        paramDataProcessor.startRecordField$505cff1c("paging");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = paging.accept(paramDataProcessor);
        label222:
        if (localObject1 == null) {
          break label353;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label234:
      localObject1 = null;
      bool3 = false;
      if (hasMetadata)
      {
        paramDataProcessor.startRecordField$505cff1c("metadata");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label363;
        }
        localObject1 = metadata.accept(paramDataProcessor);
        label274:
        if (localObject1 == null) {
          break label381;
        }
      }
    }
    label335:
    label353:
    label363:
    label381:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label475;
      }
      try
      {
        if (hasElements) {
          break label387;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "elements");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (CollectionMetadata)paramDataProcessor.processDataTemplate(paging);
      break label222;
      bool2 = false;
      localObject3 = localObject1;
      break label234;
      localObject1 = (Metadata)paramDataProcessor.processDataTemplate(metadata);
      break label274;
    }
    label387:
    if (!hasPaging) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "paging");
    }
    if (elements != null)
    {
      paramDataProcessor = elements.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Comment)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "elements");
        }
      }
    }
    return new Comments((List)localObject2, (CollectionMetadata)localObject3, (Metadata)localObject1, bool1, bool2, bool3);
    label475:
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
      paramObject = (Comments)paramObject;
      if (elements != null)
      {
        if (elements.equals(elements)) {}
      }
      else {
        while (elements != null) {
          return false;
        }
      }
      if (paging != null)
      {
        if (paging.equals(paging)) {}
      }
      else {
        while (paging != null) {
          return false;
        }
      }
      if (metadata == null) {
        break;
      }
    } while (metadata.equals(metadata));
    for (;;)
    {
      return false;
      if (metadata == null) {
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
    if (hasElements)
    {
      i += 2;
      Iterator localIterator = elements.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Comment localComment = (Comment)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localComment.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPaging)
    {
      i = j + 1;
      if (paging._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(paging._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasMetadata)
      {
        i = j + 1;
        if (metadata._cachedId == null) {
          break label208;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(metadata._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += paging.getSerializedSize();
      break;
      label208:
      i += metadata.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (elements != null)
    {
      i = elements.hashCode();
      if (paging == null) {
        break label89;
      }
    }
    label89:
    for (int j = paging.hashCode();; j = 0)
    {
      if (metadata != null) {
        k = metadata.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Comments");
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
    label435:
    label460:
    label468:
    label470:
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
        localByteBuffer.putInt(969355788);
        if (hasElements)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, elements.size());
          Iterator localIterator = elements.iterator();
          while (localIterator.hasNext())
          {
            Comment localComment = (Comment)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localComment.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localComment.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasPaging)
        {
          localByteBuffer.put((byte)1);
          if (paging._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, paging._cachedId);
            paging.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMetadata) {
              break label460;
            }
            localByteBuffer.put((byte)1);
            if (metadata._cachedId == null) {
              break label435;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, metadata._cachedId);
            metadata.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label468;
          }
          if (str != null) {
            break label470;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          paging.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          metadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Comments>
  {
    private List<Comment> elements = null;
    private boolean hasElements = false;
    private boolean hasMetadata = false;
    private boolean hasPaging = false;
    private Metadata metadata = null;
    private CollectionMetadata paging = null;
    
    public Builder() {}
    
    public Builder(Comments paramComments)
    {
      elements = elements;
      paging = paging;
      metadata = metadata;
      hasElements = hasElements;
      hasPaging = hasPaging;
      hasMetadata = hasMetadata;
    }
    
    public final Comments build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Comments build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Comments.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (elements != null)
      {
        paramFlavor = elements.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Comment)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "elements");
              if (!hasElements) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "elements");
              }
              if (hasPaging) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "paging");
            }
          }
        }
      }
      return new Comments(elements, paging, metadata, hasElements, hasPaging, hasMetadata);
    }
    
    public final Builder setElements(List<Comment> paramList)
    {
      if (paramList == null)
      {
        hasElements = false;
        elements = null;
        return this;
      }
      hasElements = true;
      elements = paramList;
      return this;
    }
    
    public final Builder setMetadata(Metadata paramMetadata)
    {
      if (paramMetadata == null)
      {
        hasMetadata = false;
        metadata = null;
        return this;
      }
      hasMetadata = true;
      metadata = paramMetadata;
      return this;
    }
    
    public final Builder setPaging(CollectionMetadata paramCollectionMetadata)
    {
      if (paramCollectionMetadata == null)
      {
        hasPaging = false;
        paging = null;
        return this;
      }
      hasPaging = true;
      paging = paramCollectionMetadata;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Comments
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */