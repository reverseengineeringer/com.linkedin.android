package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.identity.VolunteerCause;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormVolunteerExperience
  implements FissileDataModel<NormVolunteerExperience>, RecordTemplate<NormVolunteerExperience>
{
  public static final NormVolunteerExperienceBuilder BUILDER = NormVolunteerExperienceBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final VolunteerCause cause;
  public final String companyName;
  public final Urn companyUrn;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasCause;
  public final boolean hasCompanyName;
  public final boolean hasCompanyUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasRole;
  public final boolean hasTimePeriod;
  public final String role;
  public final DateRange timePeriod;
  
  NormVolunteerExperience(Urn paramUrn1, String paramString1, Urn paramUrn2, String paramString2, VolunteerCause paramVolunteerCause, DateRange paramDateRange, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    entityUrn = paramUrn1;
    companyName = paramString1;
    companyUrn = paramUrn2;
    role = paramString2;
    cause = paramVolunteerCause;
    timePeriod = paramDateRange;
    description = paramString3;
    hasEntityUrn = paramBoolean1;
    hasCompanyName = paramBoolean2;
    hasCompanyUrn = paramBoolean3;
    hasRole = paramBoolean4;
    hasCause = paramBoolean5;
    hasTimePeriod = paramBoolean6;
    hasDescription = paramBoolean7;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  private NormVolunteerExperience accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasCompanyName)
    {
      paramDataProcessor.startRecordField$505cff1c("companyName");
      paramDataProcessor.processString(companyName);
    }
    if (hasCompanyUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("companyUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(companyUrn));
    }
    if (hasRole)
    {
      paramDataProcessor.startRecordField$505cff1c("role");
      paramDataProcessor.processString(role);
    }
    if (hasCause)
    {
      paramDataProcessor.startRecordField$505cff1c("cause");
      paramDataProcessor.processEnum(cause);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label257;
      }
      localObject = timePeriod.accept(paramDataProcessor);
      if (localObject == null) {
        break label274;
      }
    }
    label257:
    label274:
    for (bool = true;; bool = false)
    {
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label356;
      }
      try
      {
        if (hasCompanyName) {
          break label279;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience", "companyName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
    }
    label279:
    if (!hasRole) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience", "role");
    }
    return new NormVolunteerExperience(entityUrn, companyName, companyUrn, role, cause, (DateRange)localObject, description, hasEntityUrn, hasCompanyName, hasCompanyUrn, hasRole, hasCause, bool, hasDescription);
    label356:
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
      paramObject = (NormVolunteerExperience)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (companyName != null)
      {
        if (companyName.equals(companyName)) {}
      }
      else {
        while (companyName != null) {
          return false;
        }
      }
      if (companyUrn != null)
      {
        if (companyUrn.equals(companyUrn)) {}
      }
      else {
        while (companyUrn != null) {
          return false;
        }
      }
      if (role != null)
      {
        if (role.equals(role)) {}
      }
      else {
        while (role != null) {
          return false;
        }
      }
      if (cause != null)
      {
        if (cause.equals(cause)) {}
      }
      else {
        while (cause != null) {
          return false;
        }
      }
      if (timePeriod != null)
      {
        if (timePeriod.equals(timePeriod)) {}
      }
      else {
        while (timePeriod != null) {
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
    if (hasCompanyName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyName);
    }
    j = i + 1;
    i = j;
    if (hasCompanyUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(companyUrn));
    }
    j = i + 1;
    i = j;
    if (hasRole) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(role);
    }
    j = i + 1;
    i = j;
    if (hasCause) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasTimePeriod)
    {
      i = j + 1;
      if (timePeriod._cachedId == null) {
        break label218;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      __sizeOfObject = i;
      return i;
      label218:
      i += timePeriod.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (companyName == null) {
        break label176;
      }
      j = companyName.hashCode();
      if (companyUrn == null) {
        break label181;
      }
      k = companyUrn.hashCode();
      if (role == null) {
        break label186;
      }
      m = role.hashCode();
      if (cause == null) {
        break label192;
      }
      n = cause.hashCode();
      label92:
      if (timePeriod == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = timePeriod.hashCode();; i1 = 0)
    {
      if (description != null) {
        i2 = description.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
      n = 0;
      break label92;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormVolunteerExperience");
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
    label204:
    label230:
    label259:
    label319:
    label388:
    label398:
    label408:
    label418:
    label428:
    label453:
    label463:
    label471:
    label473:
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
        localByteBuffer.putInt(261062915);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCompanyName) {
            break label388;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasCompanyUrn) {
            break label398;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(companyUrn));
          if (!hasRole) {
            break label408;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, role);
          if (!hasCause) {
            break label418;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, cause.ordinal());
          if (!hasTimePeriod) {
            break label453;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label428;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label463;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label471;
          }
          if (str != null) {
            break label473;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label259;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label319;
          localByteBuffer.put((byte)0);
          break label319;
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
    implements RecordTemplateBuilder<NormVolunteerExperience>
  {
    private VolunteerCause cause = null;
    private String companyName = null;
    private Urn companyUrn = null;
    private String description = null;
    private Urn entityUrn = null;
    private boolean hasCause = false;
    private boolean hasCompanyName = false;
    private boolean hasCompanyUrn = false;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasRole = false;
    private boolean hasTimePeriod = false;
    private String role = null;
    private DateRange timePeriod = null;
    
    public Builder() {}
    
    public Builder(NormVolunteerExperience paramNormVolunteerExperience)
    {
      entityUrn = entityUrn;
      companyName = companyName;
      companyUrn = companyUrn;
      role = role;
      cause = cause;
      timePeriod = timePeriod;
      description = description;
      hasEntityUrn = hasEntityUrn;
      hasCompanyName = hasCompanyName;
      hasCompanyUrn = hasCompanyUrn;
      hasRole = hasRole;
      hasCause = hasCause;
      hasTimePeriod = hasTimePeriod;
      hasDescription = hasDescription;
    }
    
    public final NormVolunteerExperience build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormVolunteerExperience.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormVolunteerExperience(entityUrn, companyName, companyUrn, role, cause, timePeriod, description, hasEntityUrn, hasCompanyName, hasCompanyUrn, hasRole, hasCause, hasTimePeriod, hasDescription);
        if (!hasCompanyName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience", "companyName");
        }
      } while (hasRole);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience", "role");
    }
    
    public final Builder setCause(VolunteerCause paramVolunteerCause)
    {
      if (paramVolunteerCause == null)
      {
        hasCause = false;
        cause = null;
        return this;
      }
      hasCause = true;
      cause = paramVolunteerCause;
      return this;
    }
    
    public final Builder setCompanyName(String paramString)
    {
      if (paramString == null)
      {
        hasCompanyName = false;
        companyName = null;
        return this;
      }
      hasCompanyName = true;
      companyName = paramString;
      return this;
    }
    
    public final Builder setCompanyUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasCompanyUrn = false;
        companyUrn = null;
        return this;
      }
      hasCompanyUrn = true;
      companyUrn = paramUrn;
      return this;
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
    
    public final Builder setRole(String paramString)
    {
      if (paramString == null)
      {
        hasRole = false;
        role = null;
        return this;
      }
      hasRole = true;
      role = paramString;
      return this;
    }
    
    public final Builder setTimePeriod(DateRange paramDateRange)
    {
      if (paramDateRange == null)
      {
        hasTimePeriod = false;
        timePeriod = null;
        return this;
      }
      hasTimePeriod = true;
      timePeriod = paramDateRange;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */