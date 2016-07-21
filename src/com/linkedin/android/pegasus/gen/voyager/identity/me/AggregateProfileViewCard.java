package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.TimeRange;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
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

public final class AggregateProfileViewCard
  implements FissileDataModel<AggregateProfileViewCard>, RecordTemplate<AggregateProfileViewCard>
{
  public static final AggregateProfileViewCardBuilder BUILDER = AggregateProfileViewCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasNumViewers;
  public final boolean hasProfileViewCta;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasSomeViewers;
  public final boolean hasViewsTimeRange;
  public final long numViewers;
  public final AttributedText profileViewCta;
  public final long publishedAt;
  public final boolean read;
  public final List<ProfileViewer> someViewers;
  public final TimeRange viewsTimeRange;
  
  AggregateProfileViewCard(long paramLong1, List<ProfileViewer> paramList, TimeRange paramTimeRange, long paramLong2, boolean paramBoolean1, AttributedText paramAttributedText, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    publishedAt = paramLong1;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      someViewers = paramList;
      viewsTimeRange = paramTimeRange;
      numViewers = paramLong2;
      read = paramBoolean1;
      profileViewCta = paramAttributedText;
      hasPublishedAt = paramBoolean2;
      hasSomeViewers = paramBoolean3;
      hasViewsTimeRange = paramBoolean4;
      hasNumViewers = paramBoolean5;
      hasRead = paramBoolean6;
      hasProfileViewCta = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  public final AggregateProfileViewCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    if (hasSomeViewers)
    {
      paramDataProcessor.startRecordField$505cff1c("someViewers");
      someViewers.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject3 = someViewers.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (ProfileViewer)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((ProfileViewer)localObject2).accept(paramDataProcessor);; localObject2 = (ProfileViewer)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      if (hasViewsTimeRange)
      {
        paramDataProcessor.startRecordField$505cff1c("viewsTimeRange");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label410;
        }
        localObject1 = viewsTimeRange.accept(paramDataProcessor);
        label247:
        if (localObject1 == null) {
          break label428;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label259:
      if (hasNumViewers)
      {
        paramDataProcessor.startRecordField$505cff1c("numViewers");
        paramDataProcessor.processLong(numViewers);
      }
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      localObject1 = null;
      bool3 = false;
      if (hasProfileViewCta)
      {
        paramDataProcessor.startRecordField$505cff1c("profileViewCta");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label438;
        }
        localObject1 = profileViewCta.accept(paramDataProcessor);
        label349:
        if (localObject1 == null) {
          break label456;
        }
      }
    }
    label410:
    label428:
    label438:
    label456:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label612;
      }
      try
      {
        if (hasPublishedAt) {
          break label462;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (TimeRange)paramDataProcessor.processDataTemplate(viewsTimeRange);
      break label247;
      bool2 = false;
      localObject3 = localObject1;
      break label259;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(profileViewCta);
      break label349;
    }
    label462:
    if (!hasSomeViewers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "someViewers");
    }
    if (!hasNumViewers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "numViewers");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "read");
    }
    if (someViewers != null)
    {
      paramDataProcessor = someViewers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ProfileViewer)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "someViewers");
        }
      }
    }
    return new AggregateProfileViewCard(publishedAt, (List)localObject2, (TimeRange)localObject3, numViewers, read, (AttributedText)localObject1, hasPublishedAt, bool1, bool2, hasNumViewers, hasRead, bool3);
    label612:
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
      paramObject = (AggregateProfileViewCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (someViewers != null)
      {
        if (someViewers.equals(someViewers)) {}
      }
      else {
        while (someViewers != null) {
          return false;
        }
      }
      if (viewsTimeRange != null)
      {
        if (viewsTimeRange.equals(viewsTimeRange)) {}
      }
      else {
        while (viewsTimeRange != null) {
          return false;
        }
      }
      if (numViewers != numViewers) {
        return false;
      }
      if (read != read) {
        return false;
      }
      if (profileViewCta == null) {
        break;
      }
    } while (profileViewCta.equals(profileViewCta));
    for (;;)
    {
      return false;
      if (profileViewCta == null) {
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
    if (hasPublishedAt) {
      i = j + 8;
    }
    i += 1;
    j = i;
    if (hasSomeViewers)
    {
      i += 2;
      Iterator localIterator = someViewers.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        ProfileViewer localProfileViewer = (ProfileViewer)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localProfileViewer.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasViewsTimeRange)
    {
      i = j + 1;
      if (viewsTimeRange._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viewsTimeRange._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasNumViewers) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasProfileViewCta)
      {
        i = j + 1;
        if (profileViewCta._cachedId == null) {
          break label261;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(profileViewCta._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += viewsTimeRange.getSerializedSize();
      break;
      label261:
      i += profileViewCta.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int n = (int)(publishedAt ^ publishedAt >>> 32);
    int i;
    int j;
    label62:
    int i1;
    if (someViewers != null)
    {
      i = someViewers.hashCode();
      if (viewsTimeRange == null) {
        break label148;
      }
      j = viewsTimeRange.hashCode();
      i1 = (int)(numViewers ^ numViewers >>> 32);
      if (!read) {
        break label153;
      }
    }
    label148:
    label153:
    for (int k = 1;; k = 0)
    {
      if (profileViewCta != null) {
        m = profileViewCta.hashCode();
      }
      i = (k + ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label62;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AggregateProfileViewCard");
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
    label282:
    label366:
    label390:
    label399:
    label527:
    label537:
    label543:
    label553:
    label578:
    label586:
    label588:
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
        localByteBuffer.putInt(283458368);
        Iterator localIterator;
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (hasSomeViewers)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, someViewers.size());
            localIterator = someViewers.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label282;
            }
            ProfileViewer localProfileViewer = (ProfileViewer)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localProfileViewer.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localProfileViewer.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasViewsTimeRange)
        {
          localByteBuffer.put((byte)1);
          if (viewsTimeRange._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, viewsTimeRange._cachedId);
            viewsTimeRange.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNumViewers) {
              break label527;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(numViewers);
            if (!hasRead) {
              break label543;
            }
            localByteBuffer.put((byte)1);
            if (!read) {
              break label537;
            }
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasProfileViewCta) {
              break label578;
            }
            localByteBuffer.put((byte)1);
            if (profileViewCta._cachedId == null) {
              break label553;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, profileViewCta._cachedId);
            profileViewCta.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label586;
          }
          if (str != null) {
            break label588;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          viewsTimeRange.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label366;
          i = 0;
          break label390;
          localByteBuffer.put((byte)0);
          break label399;
          localByteBuffer.put((byte)1);
          profileViewCta.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<AggregateProfileViewCard>
  {
    private boolean hasNumViewers = false;
    private boolean hasProfileViewCta = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasSomeViewers = false;
    private boolean hasViewsTimeRange = false;
    private long numViewers = 0L;
    private AttributedText profileViewCta = null;
    private long publishedAt = 0L;
    public boolean read = false;
    private List<ProfileViewer> someViewers = null;
    private TimeRange viewsTimeRange = null;
    
    public Builder() {}
    
    public Builder(AggregateProfileViewCard paramAggregateProfileViewCard)
    {
      publishedAt = publishedAt;
      someViewers = someViewers;
      viewsTimeRange = viewsTimeRange;
      numViewers = numViewers;
      read = read;
      profileViewCta = profileViewCta;
      hasPublishedAt = hasPublishedAt;
      hasSomeViewers = hasSomeViewers;
      hasViewsTimeRange = hasViewsTimeRange;
      hasNumViewers = hasNumViewers;
      hasRead = hasRead;
      hasProfileViewCta = hasProfileViewCta;
    }
    
    public final AggregateProfileViewCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AggregateProfileViewCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (someViewers != null)
      {
        paramFlavor = someViewers.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((ProfileViewer)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "someViewers");
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "publishedAt");
              }
              if (!hasSomeViewers) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "someViewers");
              }
              if (!hasNumViewers) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "numViewers");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard", "read");
            }
          }
        }
      }
      return new AggregateProfileViewCard(publishedAt, someViewers, viewsTimeRange, numViewers, read, profileViewCta, hasPublishedAt, hasSomeViewers, hasViewsTimeRange, hasNumViewers, hasRead, hasProfileViewCta);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */