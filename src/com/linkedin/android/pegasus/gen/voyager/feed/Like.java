package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Like
  implements FissileDataModel<Like>, RecordTemplate<Like>
{
  public static final LikeBuilder BUILDER = LikeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final SocialActor actor;
  public final long createdAt;
  public final Urn entityUrn;
  public final boolean hasActor;
  public final boolean hasCreatedAt;
  public final boolean hasEntityUrn;
  public final boolean hasInsight;
  public final boolean hasThreadId;
  public final boolean hasUrn;
  public final Insight insight;
  public final String threadId;
  public final Urn urn;
  
  Like(Urn paramUrn1, Urn paramUrn2, SocialActor paramSocialActor, Insight paramInsight, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    urn = paramUrn1;
    entityUrn = paramUrn2;
    actor = paramSocialActor;
    insight = paramInsight;
    threadId = paramString;
    createdAt = paramLong;
    hasUrn = paramBoolean1;
    hasEntityUrn = paramBoolean2;
    hasActor = paramBoolean3;
    hasInsight = paramBoolean4;
    hasThreadId = paramBoolean5;
    hasCreatedAt = paramBoolean6;
    paramUrn1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final Like accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasActor)
    {
      paramDataProcessor.startRecordField$505cff1c("actor");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = actor.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label280;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label122:
      localObject1 = null;
      bool2 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label289;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label161:
        if (localObject1 == null) {
          break label307;
        }
      }
    }
    label280:
    label289:
    label307:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasThreadId)
      {
        paramDataProcessor.startRecordField$505cff1c("threadId");
        paramDataProcessor.processString(threadId);
      }
      if (hasCreatedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("createdAt");
        paramDataProcessor.processLong(createdAt);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label358;
      }
      try
      {
        if (hasActor) {
          break label312;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Like", "actor");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (SocialActor)paramDataProcessor.processDataTemplate(actor);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label122;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break label161;
    }
    label312:
    return new Like(urn, entityUrn, (SocialActor)localObject2, (Insight)localObject1, threadId, createdAt, hasUrn, hasEntityUrn, bool1, bool2, hasThreadId, hasCreatedAt);
    label358:
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
      paramObject = (Like)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (actor != null)
      {
        if (actor.equals(actor)) {}
      }
      else {
        while (actor != null) {
          return false;
        }
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
      if (threadId != null)
      {
        if (threadId.equals(threadId)) {}
      }
      else {
        while (threadId != null) {
          return false;
        }
      }
    } while (createdAt == createdAt);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    UrnCoercer localUrnCoercer;
    if (hasUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasActor)
    {
      i = j + 1;
      if (actor._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasInsight)
      {
        i = j + 1;
        if (insight._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasThreadId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(threadId);
      }
      j = i + 1;
      i = j;
      if (hasCreatedAt) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      i += actor.getSerializedSize();
      break;
      label224:
      i += insight.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (urn != null)
    {
      i = urn.hashCode();
      if (entityUrn == null) {
        break label149;
      }
      j = entityUrn.hashCode();
      if (actor == null) {
        break label154;
      }
      k = actor.hashCode();
      label60:
      if (insight == null) {
        break label159;
      }
    }
    label149:
    label154:
    label159:
    for (int m = insight.hashCode();; m = 0)
    {
      if (threadId != null) {
        n = threadId.hashCode();
      }
      i = ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n) * 31 + (int)(createdAt ^ createdAt >>> 32);
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Like");
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
    label178:
    label238:
    label298:
    label324:
    label391:
    label401:
    label426:
    label436:
    label461:
    label471:
    label481:
    label489:
    label491:
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
        localByteBuffer.putInt(1093299510);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasEntityUrn) {
            break label391;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasActor) {
            break label426;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label401;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInsight) {
            break label461;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label436;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasThreadId) {
            break label471;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, threadId);
          if (!hasCreatedAt) {
            break label481;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdAt);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label489;
          }
          if (str != null) {
            break label491;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label178;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label238;
          localByteBuffer.put((byte)0);
          break label238;
          localByteBuffer.put((byte)1);
          insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label298;
          localByteBuffer.put((byte)0);
          break label298;
          localByteBuffer.put((byte)0);
          break label324;
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
    implements RecordTemplateBuilder<Like>
  {
    private SocialActor actor = null;
    private long createdAt = 0L;
    private Urn entityUrn = null;
    private boolean hasActor = false;
    private boolean hasCreatedAt = false;
    private boolean hasEntityUrn = false;
    private boolean hasInsight = false;
    public boolean hasThreadId = false;
    private boolean hasUrn = false;
    private Insight insight = null;
    public String threadId = null;
    private Urn urn = null;
    
    public Builder() {}
    
    public Builder(Like paramLike)
    {
      urn = urn;
      entityUrn = entityUrn;
      actor = actor;
      insight = insight;
      threadId = threadId;
      createdAt = createdAt;
      hasUrn = hasUrn;
      hasEntityUrn = hasEntityUrn;
      hasActor = hasActor;
      hasInsight = hasInsight;
      hasThreadId = hasThreadId;
      hasCreatedAt = hasCreatedAt;
    }
    
    public final Like build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Like.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Like(urn, entityUrn, actor, insight, threadId, createdAt, hasUrn, hasEntityUrn, hasActor, hasInsight, hasThreadId, hasCreatedAt);
      } while (hasActor);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Like", "actor");
    }
    
    public final Builder setActor(SocialActor paramSocialActor)
    {
      if (paramSocialActor == null)
      {
        hasActor = false;
        actor = null;
        return this;
      }
      hasActor = true;
      actor = paramSocialActor;
      return this;
    }
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
    
    public final Builder setUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasUrn = false;
        urn = null;
        return this;
      }
      hasUrn = true;
      urn = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Like
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */