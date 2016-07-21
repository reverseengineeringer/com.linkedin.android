package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormCertification
  implements FissileDataModel<NormCertification>, RecordTemplate<NormCertification>
{
  public static final NormCertificationBuilder BUILDER = NormCertificationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String authority;
  public final Urn companyUrn;
  public final String displaySource;
  public final Urn entityUrn;
  public final boolean hasAuthority;
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
  
  NormCertification(Urn paramUrn1, String paramString1, String paramString2, String paramString3, String paramString4, DateRange paramDateRange, String paramString5, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    entityUrn = paramUrn1;
    name = paramString1;
    licenseNumber = paramString2;
    url = paramString3;
    displaySource = paramString4;
    timePeriod = paramDateRange;
    authority = paramString5;
    companyUrn = paramUrn2;
    hasEntityUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasLicenseNumber = paramBoolean3;
    hasUrl = paramBoolean4;
    hasDisplaySource = paramBoolean5;
    hasTimePeriod = paramBoolean6;
    hasAuthority = paramBoolean7;
    hasCompanyUrn = paramBoolean8;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  private NormCertification accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
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
    Object localObject = null;
    boolean bool = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label283;
      }
      localObject = timePeriod.accept(paramDataProcessor);
      if (localObject == null) {
        break label300;
      }
    }
    label283:
    label300:
    for (bool = true;; bool = false)
    {
      if (hasAuthority)
      {
        paramDataProcessor.startRecordField$505cff1c("authority");
        paramDataProcessor.processString(authority);
      }
      if (hasCompanyUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("companyUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(companyUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label371;
      }
      try
      {
        if (hasName) {
          break label305;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification", "name");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
    }
    label305:
    return new NormCertification(entityUrn, name, licenseNumber, url, displaySource, (DateRange)localObject, authority, companyUrn, hasEntityUrn, hasName, hasLicenseNumber, hasUrl, hasDisplaySource, bool, hasAuthority, hasCompanyUrn);
    label371:
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
      paramObject = (NormCertification)paramObject;
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
      if (companyUrn == null) {
        break;
      }
    } while (companyUrn.equals(companyUrn));
    for (;;)
    {
      return false;
      if (companyUrn == null) {
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
      if (timePeriod._cachedId == null) {
        break label251;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
    }
    for (;;)
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
      __sizeOfObject = i;
      return i;
      label251:
      i += timePeriod.getSerializedSize();
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
      if (name == null) {
        break label198;
      }
      j = name.hashCode();
      if (licenseNumber == null) {
        break label203;
      }
      k = licenseNumber.hashCode();
      if (url == null) {
        break label208;
      }
      m = url.hashCode();
      if (displaySource == null) {
        break label214;
      }
      n = displaySource.hashCode();
      if (timePeriod == null) {
        break label220;
      }
      i1 = timePeriod.hashCode();
      label108:
      if (authority == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = authority.hashCode();; i2 = 0)
    {
      if (companyUrn != null) {
        i3 = companyUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormCertification");
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
    label411:
    label421:
    label431:
    label441:
    label451:
    label476:
    label486:
    label496:
    label504:
    label506:
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
        localByteBuffer.putInt(-1656896276);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label411;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasLicenseNumber) {
            break label421;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, licenseNumber);
          if (!hasUrl) {
            break label431;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasDisplaySource) {
            break label441;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displaySource);
          if (!hasTimePeriod) {
            break label476;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label451;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAuthority) {
            break label486;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, authority);
          if (!hasCompanyUrn) {
            break label496;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(companyUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label504;
          }
          if (str != null) {
            break label506;
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
    implements RecordTemplateBuilder<NormCertification>
  {
    private String authority = null;
    private Urn companyUrn = null;
    private String displaySource = null;
    private Urn entityUrn = null;
    private boolean hasAuthority = false;
    private boolean hasCompanyUrn = false;
    private boolean hasDisplaySource = false;
    private boolean hasEntityUrn = false;
    private boolean hasLicenseNumber = false;
    private boolean hasName = false;
    private boolean hasTimePeriod = false;
    private boolean hasUrl = false;
    private String licenseNumber = null;
    private String name = null;
    private DateRange timePeriod = null;
    private String url = null;
    
    public Builder() {}
    
    public Builder(NormCertification paramNormCertification)
    {
      entityUrn = entityUrn;
      name = name;
      licenseNumber = licenseNumber;
      url = url;
      displaySource = displaySource;
      timePeriod = timePeriod;
      authority = authority;
      companyUrn = companyUrn;
      hasEntityUrn = hasEntityUrn;
      hasName = hasName;
      hasLicenseNumber = hasLicenseNumber;
      hasUrl = hasUrl;
      hasDisplaySource = hasDisplaySource;
      hasTimePeriod = hasTimePeriod;
      hasAuthority = hasAuthority;
      hasCompanyUrn = hasCompanyUrn;
    }
    
    public final NormCertification build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormCertification.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormCertification(entityUrn, name, licenseNumber, url, displaySource, timePeriod, authority, companyUrn, hasEntityUrn, hasName, hasLicenseNumber, hasUrl, hasDisplaySource, hasTimePeriod, hasAuthority, hasCompanyUrn);
      } while (hasName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification", "name");
    }
    
    public final Builder setAuthority(String paramString)
    {
      if (paramString == null)
      {
        hasAuthority = false;
        authority = null;
        return this;
      }
      hasAuthority = true;
      authority = paramString;
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
    
    public final Builder setLicenseNumber(String paramString)
    {
      if (paramString == null)
      {
        hasLicenseNumber = false;
        licenseNumber = null;
        return this;
      }
      hasLicenseNumber = true;
      licenseNumber = paramString;
      return this;
    }
    
    public final Builder setName(String paramString)
    {
      if (paramString == null)
      {
        hasName = false;
        name = null;
        return this;
      }
      hasName = true;
      name = paramString;
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
    
    public final Builder setUrl(String paramString)
    {
      if (paramString == null)
      {
        hasUrl = false;
        url = null;
        return this;
      }
      hasUrl = true;
      url = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */