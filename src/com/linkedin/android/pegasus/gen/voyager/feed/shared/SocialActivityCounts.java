package com.linkedin.android.pegasus.gen.voyager.feed.shared;

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

public final class SocialActivityCounts
  implements FissileDataModel<SocialActivityCounts>, RecordTemplate<SocialActivityCounts>
{
  public static final SocialActivityCountsBuilder BUILDER = SocialActivityCountsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasLiked;
  public final boolean hasNumComments;
  public final boolean hasNumLikes;
  public final boolean hasNumViews;
  public final boolean liked;
  public final long numComments;
  public final long numLikes;
  public final long numViews;
  
  SocialActivityCounts(Urn paramUrn, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn;
    numComments = paramLong1;
    numLikes = paramLong2;
    numViews = paramLong3;
    liked = paramBoolean1;
    hasEntityUrn = paramBoolean2;
    hasNumComments = paramBoolean3;
    hasNumLikes = paramBoolean4;
    hasNumViews = paramBoolean5;
    hasLiked = paramBoolean6;
    UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final SocialActivityCounts accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasNumComments)
    {
      paramDataProcessor.startRecordField$505cff1c("numComments");
      paramDataProcessor.processLong(numComments);
    }
    if (hasNumLikes)
    {
      paramDataProcessor.startRecordField$505cff1c("numLikes");
      paramDataProcessor.processLong(numLikes);
    }
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    if (hasLiked)
    {
      paramDataProcessor.startRecordField$505cff1c("liked");
      paramDataProcessor.processBoolean(liked);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "entityUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasNumComments) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "numComments");
      }
      if (!hasNumLikes) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "numLikes");
      }
      if (!hasLiked) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "liked");
      }
      return new SocialActivityCounts(entityUrn, numComments, numLikes, numViews, liked, hasEntityUrn, hasNumComments, hasNumLikes, hasNumViews, hasLiked);
    }
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
      paramObject = (SocialActivityCounts)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (numComments != numComments) {
        return false;
      }
      if (numLikes != numLikes) {
        return false;
      }
      if (numViews != numViews) {
        return false;
      }
    } while (liked == liked);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasNumComments) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasNumLikes) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasNumViews) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasLiked) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      int k = (int)(numComments ^ numComments >>> 32);
      int m = (int)(numLikes ^ numLikes >>> 32);
      int n = (int)(numViews ^ numViews >>> 32);
      if (liked) {
        j = 1;
      }
      i = ((((i + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + j;
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
    int i = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialActivityCounts");
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
    label171:
    label195:
    label219:
    label240:
    label292:
    label302:
    label312:
    label322:
    label328:
    label336:
    label338:
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
        localByteBuffer.putInt(-288734264);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasNumComments) {
            break label292;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numComments);
          if (!hasNumLikes) {
            break label302;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numLikes);
          if (!hasNumViews) {
            break label312;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasLiked) {
            break label328;
          }
          localByteBuffer.put((byte)1);
          if (!liked) {
            break label322;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label336;
          }
          if (str != null) {
            break label338;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label171;
          localByteBuffer.put((byte)0);
          break label195;
          localByteBuffer.put((byte)0);
          break label219;
          i = 0;
          break label240;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<SocialActivityCounts>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasLiked = false;
    private boolean hasNumComments = false;
    private boolean hasNumLikes = false;
    private boolean hasNumViews = false;
    private boolean liked = false;
    private long numComments = 0L;
    private long numLikes = 0L;
    private long numViews = 0L;
    
    public Builder() {}
    
    public Builder(SocialActivityCounts paramSocialActivityCounts)
    {
      entityUrn = entityUrn;
      numComments = numComments;
      numLikes = numLikes;
      numViews = numViews;
      liked = liked;
      hasEntityUrn = hasEntityUrn;
      hasNumComments = hasNumComments;
      hasNumLikes = hasNumLikes;
      hasNumViews = hasNumViews;
      hasLiked = hasLiked;
    }
    
    public final SocialActivityCounts build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SocialActivityCounts.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SocialActivityCounts(entityUrn, numComments, numLikes, numViews, liked, hasEntityUrn, hasNumComments, hasNumLikes, hasNumViews, hasLiked);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "entityUrn");
        }
        if (!hasNumComments) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "numComments");
        }
        if (!hasNumLikes) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "numLikes");
        }
      } while (hasLiked);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "liked");
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
    
    public final Builder setLiked(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        hasLiked = false;
        liked = false;
        return this;
      }
      hasLiked = true;
      liked = paramBoolean.booleanValue();
      return this;
    }
    
    public final Builder setNumComments(Long paramLong)
    {
      if (paramLong == null)
      {
        hasNumComments = false;
        numComments = 0L;
        return this;
      }
      hasNumComments = true;
      numComments = paramLong.longValue();
      return this;
    }
    
    public final Builder setNumLikes(Long paramLong)
    {
      if (paramLong == null)
      {
        hasNumLikes = false;
        numLikes = 0L;
        return this;
      }
      hasNumLikes = true;
      numLikes = paramLong.longValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */