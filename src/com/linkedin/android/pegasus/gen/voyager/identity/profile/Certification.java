package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Certification
  implements FissileDataModel<Certification>, RecordTemplate<Certification>
{
  public static final CertificationBuilder BUILDER = CertificationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String authority;
  public final MiniCompany company;
  public final Urn companyUrn;
  public final String displaySource;
  public final Urn entityUrn;
  public final boolean hasAuthority;
  public final boolean hasCompany;
  public final boolean hasCompanyUrn;
  public final boolean hasDisplaySource;
  public final boolean hasEntityUrn;
  public final boolean hasLicenseNumber;
  public final boolean hasName;
  public final boolean hasTimePeriod;
  public final boolean hasUrl;
  public final String licenseNumber;
  public final String name;
  public final DateRange timePeriod;
  public final String url;
  
  Certification(Urn paramUrn1, String paramString1, String paramString2, String paramString3, String paramString4, DateRange paramDateRange, String paramString5, Urn paramUrn2, MiniCompany paramMiniCompany, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    entityUrn = paramUrn1;
    name = paramString1;
    licenseNumber = paramString2;
    url = paramString3;
    displaySource = paramString4;
    timePeriod = paramDateRange;
    authority = paramString5;
    companyUrn = paramUrn2;
    company = paramMiniCompany;
    hasEntityUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasLicenseNumber = paramBoolean3;
    hasUrl = paramBoolean4;
    hasDisplaySource = paramBoolean5;
    hasTimePeriod = paramBoolean6;
    hasAuthority = paramBoolean7;
    hasCompanyUrn = paramBoolean8;
    hasCompany = paramBoolean9;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final Certification accept(DataProcessor paramDataProcessor)
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
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasLicenseNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("licenseNumber");
      paramDataProcessor.processString(licenseNumber);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasDisplaySource)
    {
      paramDataProcessor.startRecordField$505cff1c("displaySource");
      paramDataProcessor.processString(displaySource);
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
          break label355;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label189:
      if (hasAuthority)
      {
        paramDataProcessor.startRecordField$505cff1c("authority");
        paramDataProcessor.processString(authority);
      }
      if (hasCompanyUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("companyUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(companyUrn));
      }
      localObject1 = null;
      bool2 = false;
      if (hasCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("company");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label364;
        }
        localObject1 = company.accept(paramDataProcessor);
        label286:
        if (localObject1 == null) {
          break label382;
        }
      }
    }
    label355:
    label364:
    label382:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label457;
      }
      try
      {
        if (hasName) {
          break label387;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification", "name");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label189;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(company);
      break label286;
    }
    label387:
    return new Certification(entityUrn, name, licenseNumber, url, displaySource, (DateRange)localObject2, authority, companyUrn, (MiniCompany)localObject1, hasEntityUrn, hasName, hasLicenseNumber, hasUrl, hasDisplaySource, bool1, hasAuthority, hasCompanyUrn, bool2);
    label457:
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
      paramObject = (Certification)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (licenseNumber != null)
      {
        if (licenseNumber.equals(licenseNumber)) {}
      }
      else {
        while (licenseNumber != null) {
          return false;
        }
      }
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (displaySource != null)
      {
        if (displaySource.equals(displaySource)) {}
      }
      else {
        while (displaySource != null) {
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
      if (authority != null)
      {
        if (authority.equals(authority)) {}
      }
      else {
        while (authority != null) {
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
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasLicenseNumber) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(licenseNumber);
    }
    j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasDisplaySource) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displaySource);
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
      if (hasAuthority) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(authority);
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
      if (hasCompany)
      {
        i = j + 1;
        if (company._cachedId == null) {
          break label306;
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
      label306:
      i += company.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
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
    label108:
    int i2;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (name == null) {
        break label220;
      }
      j = name.hashCode();
      if (licenseNumber == null) {
        break label225;
      }
      k = licenseNumber.hashCode();
      if (url == null) {
        break label230;
      }
      m = url.hashCode();
      if (displaySource == null) {
        break label236;
      }
      n = displaySource.hashCode();
      if (timePeriod == null) {
        break label242;
      }
      i1 = timePeriod.hashCode();
      if (authority == null) {
        break label248;
      }
      i2 = authority.hashCode();
      label124:
      if (companyUrn == null) {
        break label254;
      }
    }
    label220:
    label225:
    label230:
    label236:
    label242:
    label248:
    label254:
    for (int i3 = companyUrn.hashCode();; i3 = 0)
    {
      if (company != null) {
        i4 = company.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
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
      i2 = 0;
      break label124;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Certification");
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
    label196:
    label222:
    label248:
    label308:
    label334:
    label368:
    label471:
    label481:
    label491:
    label501:
    label511:
    label536:
    label546:
    label556:
    label566:
    label591:
    label599:
    label601:
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
        localByteBuffer.putInt(-1008821172);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label471;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasLicenseNumber) {
            break label481;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, licenseNumber);
          if (!hasUrl) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasDisplaySource) {
            break label501;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displaySource);
          if (!hasTimePeriod) {
            break label536;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label511;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAuthority) {
            break label546;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, authority);
          if (!hasCompanyUrn) {
            break label556;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(companyUrn));
          if (!hasCompany) {
            break label591;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label566;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label599;
          }
          if (str != null) {
            break label601;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label248;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label308;
          localByteBuffer.put((byte)0);
          break label308;
          localByteBuffer.put((byte)0);
          break label334;
          localByteBuffer.put((byte)0);
          break label368;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */