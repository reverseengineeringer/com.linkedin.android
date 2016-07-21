package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Link;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CareerResources
  implements FissileDataModel<CareerResources>, RecordTemplate<CareerResources>
{
  public static final CareerResourcesBuilder BUILDER = CareerResourcesBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLinks;
  public final boolean hasMedia;
  public final List<Link> links;
  public final CareerRichMedia media;
  
  CareerResources(List<Link> paramList, CareerRichMedia paramCareerRichMedia, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      links = paramList;
      media = paramCareerRichMedia;
      hasLinks = paramBoolean1;
      hasMedia = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final CareerResources accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasLinks)
    {
      paramDataProcessor.startRecordField$505cff1c("links");
      links.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = links.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (Link)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Link)localObject2).accept(paramDataProcessor);; localObject2 = (Link)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      localObject1 = null;
      bool2 = false;
      if (hasMedia)
      {
        paramDataProcessor.startRecordField$505cff1c("media");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label314;
        }
        localObject1 = media.accept(paramDataProcessor);
        label222:
        if (localObject1 == null) {
          break label332;
        }
      }
    }
    label314:
    label332:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label353;
      }
      try
      {
        if (links == null) {
          break label338;
        }
        paramDataProcessor = links.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Link)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.CareerResources", "links");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (CareerRichMedia)paramDataProcessor.processDataTemplate(media);
      break label222;
    }
    label338:
    return new CareerResources((List)localObject2, (CareerRichMedia)localObject1, bool1, bool2);
    label353:
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
      paramObject = (CareerResources)paramObject;
      if (links != null)
      {
        if (links.equals(links)) {}
      }
      else {
        while (links != null) {
          return false;
        }
      }
      if (media == null) {
        break;
      }
    } while (media.equals(media));
    for (;;)
    {
      return false;
      if (media == null) {
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
    j += 1;
    i = j;
    if (hasMedia)
    {
      i = j + 1;
      if (media._cachedId == null) {
        break label153;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(media._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label153:
      i += media.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (links != null) {}
    for (int i = links.hashCode();; i = 0)
    {
      if (media != null) {
        j = media.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerResources");
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
    label375:
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
        localByteBuffer.putInt(-192600095);
        if (hasLinks)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, links.size());
          Iterator localIterator = links.iterator();
          while (localIterator.hasNext())
          {
            Link localLink = (Link)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localLink.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localLink.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasMedia)
        {
          localByteBuffer.put((byte)1);
          if (media._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, media._cachedId);
            media.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label375;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          media.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerResources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */