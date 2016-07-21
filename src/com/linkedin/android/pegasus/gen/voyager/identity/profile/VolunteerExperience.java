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
import java.io.IOException;
import java.nio.ByteBuffer;

public final class VolunteerExperience
  implements FissileDataModel<VolunteerExperience>, RecordTemplate<VolunteerExperience>
{
  public static final VolunteerExperienceBuilder BUILDER = VolunteerExperienceBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final VolunteerCause cause;
  public final VolunteerExperienceCompany company;
  public final String companyName;
  public final Urn companyUrn;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasCause;
  public final boolean hasCompany;
  public final boolean hasCompanyName;
  public final boolean hasCompanyUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasRole;
  public final boolean hasTimePeriod;
  public final String role;
  public final DateRange timePeriod;
  
  VolunteerExperience(Urn paramUrn1, String paramString1, Urn paramUrn2, String paramString2, VolunteerCause paramVolunteerCause, DateRange paramDateRange, String paramString3, VolunteerExperienceCompany paramVolunteerExperienceCompany, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    entityUrn = paramUrn1;
    companyName = paramString1;
    companyUrn = paramUrn2;
    role = paramString2;
    cause = paramVolunteerCause;
    timePeriod = paramDateRange;
    description = paramString3;
    company = paramVolunteerExperienceCompany;
    hasEntityUrn = paramBoolean1;
    hasCompanyName = paramBoolean2;
    hasCompanyUrn = paramBoolean3;
    hasRole = paramBoolean4;
    hasCause = paramBoolean5;
    hasTimePeriod = paramBoolean6;
    hasDescription = paramBoolean7;
    hasCompany = paramBoolean8;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final VolunteerExperience accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
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
      localObject1 = UrnCoercer.INSTANCE;
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
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = timePeriod.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label330;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label197:
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      localObject1 = null;
      bool2 = false;
      if (hasCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("company");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label339;
        }
        localObject1 = company.accept(paramDataProcessor);
        label261:
        if (localObject1 == null) {
          break label357;
        }
      }
    }
    label330:
    label339:
    label357:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label443;
      }
      try
      {
        if (hasCompanyName) {
          break label362;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience", "companyName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label197;
      localObject1 = (VolunteerExperienceCompany)paramDataProcessor.processDataTemplate(company);
      break label261;
    }
    label362:
    if (!hasRole) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience", "role");
    }
    return new VolunteerExperience(entityUrn, companyName, companyUrn, role, cause, (DateRange)localObject2, description, (VolunteerExperienceCompany)localObject1, hasEntityUrn, hasCompanyName, hasCompanyUrn, hasRole, hasCause, bool1, hasDescription, bool2);
    label443:
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
      paramObject = (VolunteerExperience)paramObject;
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
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (company == null) {
        break;
      }
    } while (company.equals(company));
    for (;;)
    {
      return false;
      if (company == null) {
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
      if (timePeriod._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      j = i + 1;
      i = j;
      if (hasCompany)
      {
        i = j + 1;
        if (company._cachedId == null) {
          break label273;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(company._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += timePeriod.getSerializedSize();
      break;
      label273:
      i += company.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
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
    label92:
    int i1;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (companyName == null) {
        break label198;
      }
      j = companyName.hashCode();
      if (companyUrn == null) {
        break label203;
      }
      k = companyUrn.hashCode();
      if (role == null) {
        break label208;
      }
      m = role.hashCode();
      if (cause == null) {
        break label214;
      }
      n = cause.hashCode();
      if (timePeriod == null) {
        break label220;
      }
      i1 = timePeriod.hashCode();
      label108:
      if (description == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = description.hashCode();; i2 = 0)
    {
      if (company != null) {
        i3 = company.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
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
      i1 = 0;
      break label108;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building VolunteerExperience");
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
    label345:
    label448:
    label458:
    label468:
    label478:
    label488:
    label513:
    label523:
    label533:
    label558:
    label566:
    label568:
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
        localByteBuffer.putInt(-1580519910);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCompanyName) {
            break label448;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasCompanyUrn) {
            break label458;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(companyUrn));
          if (!hasRole) {
            break label468;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, role);
          if (!hasCause) {
            break label478;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, cause.ordinal());
          if (!hasTimePeriod) {
            break label513;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label488;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label523;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasCompany) {
            break label558;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label533;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label566;
          }
          if (str != null) {
            break label568;
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
          break label345;
          localByteBuffer.put((byte)1);
          company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */