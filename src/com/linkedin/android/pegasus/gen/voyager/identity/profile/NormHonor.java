package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
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

public final class NormHonor
  implements FissileDataModel<NormHonor>, RecordTemplate<NormHonor>
{
  public static final NormHonorBuilder BUILDER = NormHonorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasIssueDate;
  public final boolean hasIssuer;
  public final boolean hasOccupation;
  public final boolean hasTitle;
  public final Date issueDate;
  public final String issuer;
  public final Urn occupation;
  public final String title;
  
  NormHonor(Urn paramUrn1, String paramString1, Date paramDate, String paramString2, Urn paramUrn2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn1;
    title = paramString1;
    issueDate = paramDate;
    issuer = paramString2;
    occupation = paramUrn2;
    description = paramString3;
    hasEntityUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasIssueDate = paramBoolean3;
    hasIssuer = paramBoolean4;
    hasOccupation = paramBoolean5;
    hasDescription = paramBoolean6;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  private NormHonor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasIssueDate)
    {
      paramDataProcessor.startRecordField$505cff1c("issueDate");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label233;
      }
      localObject = issueDate.accept(paramDataProcessor);
      if (localObject == null) {
        break label250;
      }
    }
    label233:
    label250:
    for (bool = true;; bool = false)
    {
      if (hasIssuer)
      {
        paramDataProcessor.startRecordField$505cff1c("issuer");
        paramDataProcessor.processString(issuer);
      }
      if (hasOccupation)
      {
        paramDataProcessor.startRecordField$505cff1c("occupation");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(occupation));
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label305;
      }
      try
      {
        if (hasTitle) {
          break label255;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Date)paramDataProcessor.processDataTemplate(issueDate);
      break;
    }
    label255:
    return new NormHonor(entityUrn, title, (Date)localObject, issuer, occupation, description, hasEntityUrn, hasTitle, bool, hasIssuer, hasOccupation, hasDescription);
    label305:
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
      paramObject = (NormHonor)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
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
      if (issueDate != null)
      {
        if (issueDate.equals(issueDate)) {}
      }
      else {
        while (issueDate != null) {
          return false;
        }
      }
      if (issuer != null)
      {
        if (issuer.equals(issuer)) {}
      }
      else {
        while (issuer != null) {
          return false;
        }
      }
      if (occupation != null)
      {
        if (occupation.equals(occupation)) {}
      }
      else {
        while (occupation != null) {
          return false;
        }
      }
      if (description == null) {
        break;
      }
    } while (description.equals(description));
    for (;;)
    {
      return false;
      if (description == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasIssueDate)
    {
      i = j + 1;
      if (issueDate._cachedId == null) {
        break label201;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(issueDate._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasIssuer) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(issuer);
      }
      j = i + 1;
      i = j;
      if (hasOccupation)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(occupation));
      }
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      __sizeOfObject = i;
      return i;
      label201:
      i += issueDate.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (title == null) {
        break label154;
      }
      j = title.hashCode();
      if (issueDate == null) {
        break label159;
      }
      k = issueDate.hashCode();
      if (issuer == null) {
        break label164;
      }
      m = issuer.hashCode();
      label76:
      if (occupation == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = occupation.hashCode();; n = 0)
    {
      if (description != null) {
        i1 = description.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormHonor");
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
    label170:
    label230:
    label256:
    label290:
    label359:
    label369:
    label394:
    label404:
    label414:
    label424:
    label432:
    label434:
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
        localByteBuffer.putInt(1218685676);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label359;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasIssueDate) {
            break label394;
          }
          localByteBuffer.put((byte)1);
          if (issueDate._cachedId == null) {
            break label369;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, issueDate._cachedId);
          issueDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasIssuer) {
            break label404;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, issuer);
          if (!hasOccupation) {
            break label414;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(occupation));
          if (!hasDescription) {
            break label424;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label432;
          }
          if (str != null) {
            break label434;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          issueDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
          break label290;
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
    implements RecordTemplateBuilder<NormHonor>
  {
    private String description = null;
    private Urn entityUrn = null;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasIssueDate = false;
    private boolean hasIssuer = false;
    private boolean hasOccupation = false;
    private boolean hasTitle = false;
    private Date issueDate = null;
    private String issuer = null;
    private Urn occupation = null;
    private String title = null;
    
    public Builder() {}
    
    public Builder(NormHonor paramNormHonor)
    {
      entityUrn = entityUrn;
      title = title;
      issueDate = issueDate;
      issuer = issuer;
      occupation = occupation;
      description = description;
      hasEntityUrn = hasEntityUrn;
      hasTitle = hasTitle;
      hasIssueDate = hasIssueDate;
      hasIssuer = hasIssuer;
      hasOccupation = hasOccupation;
      hasDescription = hasDescription;
    }
    
    public final NormHonor build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormHonor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormHonor(entityUrn, title, issueDate, issuer, occupation, description, hasEntityUrn, hasTitle, hasIssueDate, hasIssuer, hasOccupation, hasDescription);
      } while (hasTitle);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor", "title");
    }
    
    public final Builder setDescription(String paramString)
    {
      if (paramString == null)
      {
        hasDescription = false;
        description = null;
        return this;
      }
      hasDescription = true;
      description = paramString;
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
    
    public final Builder setIssueDate(Date paramDate)
    {
      if (paramDate == null)
      {
        hasIssueDate = false;
        issueDate = null;
        return this;
      }
      hasIssueDate = true;
      issueDate = paramDate;
      return this;
    }
    
    public final Builder setIssuer(String paramString)
    {
      if (paramString == null)
      {
        hasIssuer = false;
        issuer = null;
        return this;
      }
      hasIssuer = true;
      issuer = paramString;
      return this;
    }
    
    public final Builder setOccupation(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasOccupation = false;
        occupation = null;
        return this;
      }
      hasOccupation = true;
      occupation = paramUrn;
      return this;
    }
    
    public final Builder setTitle(String paramString)
    {
      if (paramString == null)
      {
        hasTitle = false;
        title = null;
        return this;
      }
      hasTitle = true;
      title = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */