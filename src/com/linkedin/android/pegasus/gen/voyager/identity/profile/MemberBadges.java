package com.linkedin.android.pegasus.gen.voyager.identity.profile;

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

public final class MemberBadges
  implements FissileDataModel<MemberBadges>, RecordTemplate<MemberBadges>
{
  public static final MemberBadgesBuilder BUILDER = MemberBadgesBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasInfluencer;
  public final boolean hasJobSeeker;
  public final boolean hasOpenLink;
  public final boolean hasPremium;
  public final boolean influencer;
  public final boolean jobSeeker;
  public final boolean openLink;
  public final boolean premium;
  
  MemberBadges(Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    entityUrn = paramUrn;
    influencer = paramBoolean1;
    jobSeeker = paramBoolean2;
    premium = paramBoolean3;
    openLink = paramBoolean4;
    hasEntityUrn = paramBoolean5;
    hasInfluencer = paramBoolean6;
    hasJobSeeker = paramBoolean7;
    hasPremium = paramBoolean8;
    hasOpenLink = paramBoolean9;
    UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private MemberBadges accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasInfluencer)
    {
      paramDataProcessor.startRecordField$505cff1c("influencer");
      paramDataProcessor.processBoolean(influencer);
    }
    if (hasJobSeeker)
    {
      paramDataProcessor.startRecordField$505cff1c("jobSeeker");
      paramDataProcessor.processBoolean(jobSeeker);
    }
    if (hasPremium)
    {
      paramDataProcessor.startRecordField$505cff1c("premium");
      paramDataProcessor.processBoolean(premium);
    }
    if (hasOpenLink)
    {
      paramDataProcessor.startRecordField$505cff1c("openLink");
      paramDataProcessor.processBoolean(openLink);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasInfluencer) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "influencer");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasJobSeeker) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "jobSeeker");
      }
      if (!hasPremium) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "premium");
      }
      if (!hasOpenLink) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "openLink");
      }
      return new MemberBadges(entityUrn, influencer, jobSeeker, premium, openLink, hasEntityUrn, hasInfluencer, hasJobSeeker, hasPremium, hasOpenLink);
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
      paramObject = (MemberBadges)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (influencer != influencer) {
        return false;
      }
      if (jobSeeker != jobSeeker) {
        return false;
      }
      if (premium != premium) {
        return false;
      }
    } while (openLink == openLink);
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
    if (hasInfluencer) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasJobSeeker) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasPremium) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasOpenLink) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label39:
    int k;
    label48:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (!influencer) {
        break label105;
      }
      j = 1;
      if (!jobSeeker) {
        break label110;
      }
      k = 1;
      if (!premium) {
        break label115;
      }
      m = 1;
      label58:
      if (!openLink) {
        break label121;
      }
    }
    for (;;)
    {
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label105:
      j = 0;
      break label39;
      label110:
      k = 0;
      break label48;
      label115:
      m = 0;
      break label58;
      label121:
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
    int j = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MemberBadges");
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
    label180:
    label204:
    label213:
    label237:
    label246:
    label271:
    label323:
    label329:
    label339:
    label345:
    label355:
    label361:
    label371:
    label377:
    label385:
    label387:
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
        localByteBuffer.putInt(-838661710);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasInfluencer) {
            break label329;
          }
          localByteBuffer.put((byte)1);
          if (!influencer) {
            break label323;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasJobSeeker) {
            break label345;
          }
          localByteBuffer.put((byte)1);
          if (!jobSeeker) {
            break label339;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasPremium) {
            break label361;
          }
          localByteBuffer.put((byte)1);
          if (!premium) {
            break label355;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasOpenLink) {
            break label377;
          }
          localByteBuffer.put((byte)1);
          if (!openLink) {
            break label371;
          }
          i = j;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label385;
          }
          if (str != null) {
            break label387;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label171;
          localByteBuffer.put((byte)0);
          break label180;
          i = 0;
          break label204;
          localByteBuffer.put((byte)0);
          break label213;
          i = 0;
          break label237;
          localByteBuffer.put((byte)0);
          break label246;
          i = 0;
          break label271;
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
    implements RecordTemplateBuilder<MemberBadges>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasInfluencer = false;
    private boolean hasJobSeeker = false;
    private boolean hasOpenLink = false;
    public boolean hasPremium = false;
    private boolean influencer = false;
    private boolean jobSeeker = false;
    private boolean openLink = false;
    public boolean premium = false;
    
    public Builder() {}
    
    public Builder(MemberBadges paramMemberBadges)
    {
      entityUrn = entityUrn;
      influencer = influencer;
      jobSeeker = jobSeeker;
      premium = premium;
      openLink = openLink;
      hasEntityUrn = hasEntityUrn;
      hasInfluencer = hasInfluencer;
      hasJobSeeker = hasJobSeeker;
      hasPremium = hasPremium;
      hasOpenLink = hasOpenLink;
    }
    
    public final MemberBadges build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MemberBadges.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MemberBadges(entityUrn, influencer, jobSeeker, premium, openLink, hasEntityUrn, hasInfluencer, hasJobSeeker, hasPremium, hasOpenLink);
        if (!hasInfluencer) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "influencer");
        }
        if (!hasJobSeeker) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "jobSeeker");
        }
        if (!hasPremium) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "premium");
        }
      } while (hasOpenLink);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "openLink");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */