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

public final class CareerAbout2
  implements FissileDataModel<CareerAbout2>, RecordTemplate<CareerAbout2>
{
  public static final CareerAbout2Builder BUILDER = CareerAbout2Builder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLinks;
  public final boolean hasMedia;
  public final boolean hasText;
  public final boolean hasTitle;
  public final List<Link> links;
  public final CareerRichMedia media;
  public final String text;
  public final String title;
  
  CareerAbout2(List<Link> paramList, CareerRichMedia paramCareerRichMedia, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      links = paramList;
      media = paramCareerRichMedia;
      title = paramString1;
      text = paramString2;
      hasLinks = paramBoolean1;
      hasMedia = paramBoolean2;
      hasTitle = paramBoolean3;
      hasText = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final CareerAbout2 accept(DataProcessor paramDataProcessor)
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
          break label364;
        }
        localObject1 = media.accept(paramDataProcessor);
        label222:
        if (localObject1 == null) {
          break label382;
        }
      }
    }
    label364:
    label382:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("title");
        paramDataProcessor.processString(title);
      }
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        paramDataProcessor.processString(text);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label419;
      }
      try
      {
        if (links == null) {
          break label388;
        }
        paramDataProcessor = links.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Link)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAbout2", "links");
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
    label388:
    return new CareerAbout2((List)localObject2, (CareerRichMedia)localObject1, title, text, bool1, bool2, hasTitle, hasText);
    label419:
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
      paramObject = (CareerAbout2)paramObject;
      if (links != null)
      {
        if (links.equals(links)) {}
      }
      else {
        while (links != null) {
          return false;
        }
      }
      if (media != null)
      {
        if (media.equals(media)) {}
      }
      else {
        while (media != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (text == null) {
        break;
      }
    } while (text.equals(text));
    for (;;)
    {
      return false;
      if (text == null) {
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
        break label203;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(media._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasTitle) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
      }
      j = i + 1;
      i = j;
      if (hasText) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(text);
      }
      __sizeOfObject = i;
      return i;
      label203:
      i += media.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (links != null)
    {
      i = links.hashCode();
      if (media == null) {
        break label112;
      }
      j = media.hashCode();
      label47:
      if (title == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = title.hashCode();; k = 0)
    {
      if (text != null) {
        m = text.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerAbout2");
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
    label333:
    label427:
    label437:
    label445:
    label447:
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
        localByteBuffer.putInt(-869447873);
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
            if (!hasTitle) {
              break label427;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, title);
            if (!hasText) {
              break label437;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, text);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label445;
          }
          if (str != null) {
            break label447;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          media.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label333;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAbout2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */