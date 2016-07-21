package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
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

public final class AggregatePropCard
  implements FissileDataModel<AggregatePropCard>, RecordTemplate<AggregatePropCard>
{
  public static final AggregatePropCardBuilder BUILDER = AggregatePropCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHeadline;
  public final boolean hasPropType;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasSomeProps;
  public final AttributedText headline;
  public final PropType propType;
  public final long publishedAt;
  public final boolean read;
  public final List<PropCard> someProps;
  
  AggregatePropCard(PropType paramPropType, AttributedText paramAttributedText, List<PropCard> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    propType = paramPropType;
    headline = paramAttributedText;
    if (paramList == null) {}
    for (paramPropType = null;; paramPropType = Collections.unmodifiableList(paramList))
    {
      someProps = paramPropType;
      publishedAt = paramLong;
      read = paramBoolean1;
      hasPropType = paramBoolean2;
      hasHeadline = paramBoolean3;
      hasSomeProps = paramBoolean4;
      hasPublishedAt = paramBoolean5;
      hasRead = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  public final AggregatePropCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPropType)
    {
      paramDataProcessor.startRecordField$505cff1c("propType");
      paramDataProcessor.processEnum(propType);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    int i;
    if (hasHeadline)
    {
      paramDataProcessor.startRecordField$505cff1c("headline");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = headline.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localPropCard = null;
      bool2 = false;
      if (!hasSomeProps) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("someProps");
      someProps.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localPropCard;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = someProps.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localPropCard = (PropCard)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (PropCard localPropCard = localPropCard.accept(paramDataProcessor);; localPropCard = (PropCard)paramDataProcessor.processDataTemplate(localPropCard))
    {
      if ((localObject1 != null) && (localPropCard != null)) {
        ((List)localObject1).add(localPropCard);
      }
      i += 1;
      break label156;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headline);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
    }
    label272:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label286:
      if (hasPublishedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("publishedAt");
        paramDataProcessor.processLong(publishedAt);
      }
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label551;
      }
      try
      {
        if (hasPropType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "propType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasHeadline) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "headline");
    }
    if (!hasSomeProps) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "someProps");
    }
    if (!hasPublishedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "publishedAt");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "read");
    }
    if (someProps != null)
    {
      paramDataProcessor = someProps.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PropCard)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "someProps");
        }
      }
    }
    return new AggregatePropCard(propType, (AttributedText)localObject2, (List)localObject1, publishedAt, read, hasPropType, bool1, bool2, hasPublishedAt, hasRead);
    label551:
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
      paramObject = (AggregatePropCard)paramObject;
      if (propType != null)
      {
        if (propType.equals(propType)) {}
      }
      else {
        while (propType != null) {
          return false;
        }
      }
      if (headline != null)
      {
        if (headline.equals(headline)) {}
      }
      else {
        while (headline != null) {
          return false;
        }
      }
      if (someProps != null)
      {
        if (someProps.equals(someProps)) {}
      }
      else {
        while (someProps != null) {
          return false;
        }
      }
      if (publishedAt != publishedAt) {
        return false;
      }
    } while (read == read);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasPropType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasHeadline)
    {
      i = j + 1;
      if (headline._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headline._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasSomeProps) {
        break label176;
      }
      i += 2;
      localIterator = someProps.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label176;
      }
      PropCard localPropCard = (PropCard)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += headline.getSerializedSize();
        break;
      }
      i += localPropCard.getSerializedSize();
    }
    label176:
    j += 1;
    i = j;
    if (hasPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasRead) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (propType != null)
    {
      i = propType.hashCode();
      if (headline == null) {
        break label127;
      }
      j = headline.hashCode();
      label45:
      if (someProps == null) {
        break label132;
      }
    }
    label127:
    label132:
    for (int k = someProps.hashCode();; k = 0)
    {
      int n = (int)(publishedAt ^ publishedAt >>> 32);
      if (read) {
        m = 1;
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + n) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AggregatePropCard");
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
    label200:
    label317:
    label342:
    label375:
    label382:
    label430:
    label482:
    label488:
    label496:
    label498:
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
        localByteBuffer.putInt(-695078840);
        Iterator localIterator;
        if (hasPropType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, propType.ordinal());
          if (!hasHeadline) {
            break label342;
          }
          localByteBuffer.put((byte)1);
          if (headline._cachedId == null) {
            break label317;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headline._cachedId);
          headline.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSomeProps) {
            break label375;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, someProps.size());
          localIterator = someProps.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label382;
          }
          PropCard localPropCard = (PropCard)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localPropCard.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            headline.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label200;
            localByteBuffer.put((byte)0);
            break label200;
          }
          localByteBuffer.put((byte)1);
          localPropCard.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasRead) {
            break label488;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label482;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label496;
          }
          if (str != null) {
            break label498;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label430;
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
    implements RecordTemplateBuilder<AggregatePropCard>
  {
    private boolean hasHeadline = false;
    private boolean hasPropType = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasSomeProps = false;
    private AttributedText headline = null;
    private PropType propType = null;
    private long publishedAt = 0L;
    public boolean read = false;
    private List<PropCard> someProps = null;
    
    public Builder() {}
    
    public Builder(AggregatePropCard paramAggregatePropCard)
    {
      propType = propType;
      headline = headline;
      someProps = someProps;
      publishedAt = publishedAt;
      read = read;
      hasPropType = hasPropType;
      hasHeadline = hasHeadline;
      hasSomeProps = hasSomeProps;
      hasPublishedAt = hasPublishedAt;
      hasRead = hasRead;
    }
    
    public final AggregatePropCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AggregatePropCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (someProps != null)
      {
        paramFlavor = someProps.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((PropCard)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "someProps");
              if (!hasPropType) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "propType");
              }
              if (!hasHeadline) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "headline");
              }
              if (!hasSomeProps) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "someProps");
              }
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "publishedAt");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard", "read");
            }
          }
        }
      }
      return new AggregatePropCard(propType, headline, someProps, publishedAt, read, hasPropType, hasHeadline, hasSomeProps, hasPublishedAt, hasRead);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */