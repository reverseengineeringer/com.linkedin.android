package com.linkedin.android.pegasus.gen.voyager.identity.me;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class EndorsementCard
  implements FissileDataModel<EndorsementCard>, RecordTemplate<EndorsementCard>
{
  public static final EndorsementCardBuilder BUILDER = EndorsementCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Endorsement> endorsements;
  public final ActorMiniProfile endorser;
  public final boolean hasEndorsements;
  public final boolean hasEndorser;
  public final boolean hasInsight;
  public final boolean hasMessageAvailable;
  public final boolean hasNumEndorsements;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final Insight insight;
  public final boolean messageAvailable;
  public final long numEndorsements;
  public final long publishedAt;
  public final boolean read;
  
  EndorsementCard(long paramLong1, ActorMiniProfile paramActorMiniProfile, List<Endorsement> paramList, long paramLong2, Insight paramInsight, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    publishedAt = paramLong1;
    endorser = paramActorMiniProfile;
    if (paramList == null) {}
    for (paramActorMiniProfile = null;; paramActorMiniProfile = Collections.unmodifiableList(paramList))
    {
      endorsements = paramActorMiniProfile;
      numEndorsements = paramLong2;
      insight = paramInsight;
      read = paramBoolean1;
      messageAvailable = paramBoolean2;
      hasPublishedAt = paramBoolean3;
      hasEndorser = paramBoolean4;
      hasEndorsements = paramBoolean5;
      hasNumEndorsements = paramBoolean6;
      hasInsight = paramBoolean7;
      hasRead = paramBoolean8;
      hasMessageAvailable = paramBoolean9;
      _cachedId = null;
      return;
    }
  }
  
  public final EndorsementCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    boolean bool2;
    int i;
    if (hasEndorser)
    {
      paramDataProcessor.startRecordField$505cff1c("endorser");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = endorser.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label243;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      localObject1 = null;
      bool2 = false;
      if (!hasEndorsements) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("endorsements");
      endorsements.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = endorsements.iterator();
      label152:
      if (!localIterator.hasNext()) {
        break label268;
      }
      localObject3 = (Endorsement)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label252;
      }
    }
    label243:
    label252:
    for (Object localObject3 = ((Endorsement)localObject3).accept(paramDataProcessor);; localObject3 = (Endorsement)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject1 != null) && (localObject3 != null)) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
      break label152;
      localObject1 = (ActorMiniProfile)paramDataProcessor.processDataTemplate(endorser);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
    }
    label268:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      localObject3 = localObject1;
      label286:
      if (hasNumEndorsements)
      {
        paramDataProcessor.startRecordField$505cff1c("numEndorsements");
        paramDataProcessor.processLong(numEndorsements);
      }
      localObject1 = null;
      bool3 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label463;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label351:
        if (localObject1 == null) {
          break label481;
        }
      }
    }
    label463:
    label481:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      if (hasMessageAvailable)
      {
        paramDataProcessor.startRecordField$505cff1c("messageAvailable");
        paramDataProcessor.processBoolean(messageAvailable);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label645;
      }
      try
      {
        if (hasPublishedAt) {
          break label487;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      localObject3 = localObject1;
      break;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break label351;
    }
    label487:
    if (!hasEndorser) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorser");
    }
    if (!hasEndorsements) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorsements");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "read");
    }
    if (endorsements != null)
    {
      paramDataProcessor = endorsements.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Endorsement)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorsements");
        }
      }
    }
    return new EndorsementCard(publishedAt, (ActorMiniProfile)localObject2, (List)localObject3, numEndorsements, (Insight)localObject1, read, messageAvailable, hasPublishedAt, bool1, bool2, hasNumEndorsements, bool3, hasRead, hasMessageAvailable);
    label645:
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
      paramObject = (EndorsementCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (endorser != null)
      {
        if (endorser.equals(endorser)) {}
      }
      else {
        while (endorser != null) {
          return false;
        }
      }
      if (endorsements != null)
      {
        if (endorsements.equals(endorsements)) {}
      }
      else {
        while (endorsements != null) {
          return false;
        }
      }
      if (numEndorsements != numEndorsements) {
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
      if (read != read) {
        return false;
      }
    } while (messageAvailable == messageAvailable);
    return false;
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
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasEndorser)
    {
      i = j + 1;
      if (endorser._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(endorser._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasEndorsements) {
        break label177;
      }
      i += 2;
      localIterator = endorsements.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label177;
      }
      Endorsement localEndorsement = (Endorsement)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += endorser.getSerializedSize();
        break;
      }
      i += localEndorsement.getSerializedSize();
    }
    label177:
    j += 1;
    i = j;
    if (hasNumEndorsements) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasInsight)
    {
      i = j + 1;
      if (insight._cachedId == null) {
        break label278;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasMessageAvailable) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      label278:
      i += insight.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = (int)(publishedAt ^ publishedAt >>> 32);
    int i;
    int j;
    label62:
    int i2;
    int k;
    label92:
    int m;
    if (endorser != null)
    {
      i = endorser.hashCode();
      if (endorsements == null) {
        break label161;
      }
      j = endorsements.hashCode();
      i2 = (int)(numEndorsements ^ numEndorsements >>> 32);
      if (insight == null) {
        break label166;
      }
      k = insight.hashCode();
      if (!read) {
        break label171;
      }
      m = 1;
      label102:
      if (!messageAvailable) {
        break label177;
      }
    }
    for (;;)
    {
      i = (m + (k + ((j + (i + (i1 + 527) * 31) * 31) * 31 + i2) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label161:
      j = 0;
      break label62;
      label166:
      k = 0;
      break label92;
      label171:
      m = 0;
      break label102;
      label177:
      n = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EndorsementCard");
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
    label195:
    label312:
    label337:
    label370:
    label377:
    label461:
    label485:
    label494:
    label518:
    label570:
    label595:
    label605:
    label611:
    label621:
    label627:
    label635:
    label637:
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
        localByteBuffer.putInt(-705884018);
        Iterator localIterator;
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasEndorser) {
            break label337;
          }
          localByteBuffer.put((byte)1);
          if (endorser._cachedId == null) {
            break label312;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, endorser._cachedId);
          endorser.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEndorsements) {
            break label370;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, endorsements.size());
          localIterator = endorsements.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label377;
          }
          Endorsement localEndorsement = (Endorsement)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEndorsement.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            endorser.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label195;
            localByteBuffer.put((byte)0);
            break label195;
          }
          localByteBuffer.put((byte)1);
          localEndorsement.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasNumEndorsements)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numEndorsements);
          if (!hasInsight) {
            break label595;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label570;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRead) {
            break label611;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label605;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasMessageAvailable) {
            break label627;
          }
          localByteBuffer.put((byte)1);
          if (!messageAvailable) {
            break label621;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label635;
          }
          if (str != null) {
            break label637;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label461;
          localByteBuffer.put((byte)0);
          break label461;
          i = 0;
          break label485;
          localByteBuffer.put((byte)0);
          break label494;
          i = 0;
          break label518;
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
    implements RecordTemplateBuilder<EndorsementCard>
  {
    private List<Endorsement> endorsements = null;
    private ActorMiniProfile endorser = null;
    private boolean hasEndorsements = false;
    private boolean hasEndorser = false;
    private boolean hasInsight = false;
    private boolean hasMessageAvailable = false;
    private boolean hasNumEndorsements = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private Insight insight = null;
    private boolean messageAvailable = false;
    private long numEndorsements = 0L;
    private long publishedAt = 0L;
    public boolean read = false;
    
    public Builder() {}
    
    public Builder(EndorsementCard paramEndorsementCard)
    {
      publishedAt = publishedAt;
      endorser = endorser;
      endorsements = endorsements;
      numEndorsements = numEndorsements;
      insight = insight;
      read = read;
      messageAvailable = messageAvailable;
      hasPublishedAt = hasPublishedAt;
      hasEndorser = hasEndorser;
      hasEndorsements = hasEndorsements;
      hasNumEndorsements = hasNumEndorsements;
      hasInsight = hasInsight;
      hasRead = hasRead;
      hasMessageAvailable = hasMessageAvailable;
    }
    
    public final EndorsementCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EndorsementCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (endorsements != null)
      {
        paramFlavor = endorsements.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Endorsement)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorsements");
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "publishedAt");
              }
              if (!hasEndorser) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorser");
              }
              if (!hasEndorsements) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "endorsements");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard", "read");
            }
          }
        }
      }
      return new EndorsementCard(publishedAt, endorser, endorsements, numEndorsements, insight, read, messageAvailable, hasPublishedAt, hasEndorser, hasEndorsements, hasNumEndorsements, hasInsight, hasRead, hasMessageAvailable);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */