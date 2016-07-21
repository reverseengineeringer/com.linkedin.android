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
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormPosition
  implements FissileDataModel<NormPosition>, RecordTemplate<NormPosition>
{
  public static final NormPositionBuilder BUILDER = NormPositionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String companyName;
  public final Urn companyUrn;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasCompanyName;
  public final boolean hasCompanyUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasLocationName;
  public final boolean hasRegion;
  public final boolean hasTimePeriod;
  public final boolean hasTitle;
  public final String locationName;
  public final Urn region;
  public final DateRange timePeriod;
  public final String title;
  
  NormPosition(Urn paramUrn1, String paramString1, String paramString2, DateRange paramDateRange, Urn paramUrn2, String paramString3, String paramString4, Urn paramUrn3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    entityUrn = paramUrn1;
    title = paramString1;
    description = paramString2;
    timePeriod = paramDateRange;
    region = paramUrn2;
    locationName = paramString3;
    companyName = paramString4;
    companyUrn = paramUrn3;
    hasEntityUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasDescription = paramBoolean3;
    hasTimePeriod = paramBoolean4;
    hasRegion = paramBoolean5;
    hasLocationName = paramBoolean6;
    hasCompanyName = paramBoolean7;
    hasCompanyUrn = paramBoolean8;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final NormPosition accept(DataProcessor paramDataProcessor)
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
    if (hasDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("description");
      paramDataProcessor.processString(description);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label328;
      }
      localObject = timePeriod.accept(paramDataProcessor);
      if (localObject == null) {
        break label345;
      }
    }
    label328:
    label345:
    for (bool = true;; bool = false)
    {
      UrnCoercer localUrnCoercer;
      if (hasRegion)
      {
        paramDataProcessor.startRecordField$505cff1c("region");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(region));
      }
      if (hasLocationName)
      {
        paramDataProcessor.startRecordField$505cff1c("locationName");
        paramDataProcessor.processString(locationName);
      }
      if (hasCompanyName)
      {
        paramDataProcessor.startRecordField$505cff1c("companyName");
        paramDataProcessor.processString(companyName);
      }
      if (hasCompanyUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("companyUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(companyUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label350;
      }
      return new NormPosition(entityUrn, title, description, (DateRange)localObject, region, locationName, companyName, companyUrn, hasEntityUrn, hasTitle, hasDescription, bool, hasRegion, hasLocationName, hasCompanyName, hasCompanyUrn);
      localObject = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
    }
    label350:
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
      paramObject = (NormPosition)paramObject;
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
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
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
      if (region != null)
      {
        if (region.equals(region)) {}
      }
      else {
        while (region != null) {
          return false;
        }
      }
      if (locationName != null)
      {
        if (locationName.equals(locationName)) {}
      }
      else {
        while (locationName != null) {
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
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
    }
    j = i + 1;
    i = j;
    if (hasTimePeriod)
    {
      i = j + 1;
      if (timePeriod._cachedId == null) {
        break label258;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasRegion)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(region));
      }
      j = i + 1;
      i = j;
      if (hasLocationName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(locationName);
      }
      j = i + 1;
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
      __sizeOfObject = i;
      return i;
      label258:
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
      if (title == null) {
        break label198;
      }
      j = title.hashCode();
      if (description == null) {
        break label203;
      }
      k = description.hashCode();
      if (timePeriod == null) {
        break label208;
      }
      m = timePeriod.hashCode();
      if (region == null) {
        break label214;
      }
      n = region.hashCode();
      if (locationName == null) {
        break label220;
      }
      i1 = locationName.hashCode();
      label108:
      if (companyName == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = companyName.hashCode();; i2 = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormPosition");
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
    label256:
    label290:
    label316:
    label342:
    label419:
    label429:
    label439:
    label464:
    label474:
    label484:
    label494:
    label504:
    label512:
    label514:
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
        localByteBuffer.putInt(623544189);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label419;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasDescription) {
            break label429;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasTimePeriod) {
            break label464;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label439;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRegion) {
            break label474;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(region));
          if (!hasLocationName) {
            break label484;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, locationName);
          if (!hasCompanyName) {
            break label494;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasCompanyUrn) {
            break label504;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(companyUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label512;
          }
          if (str != null) {
            break label514;
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
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label256;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)0);
          break label316;
          localByteBuffer.put((byte)0);
          break label342;
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
    implements RecordTemplateBuilder<NormPosition>
  {
    private String companyName = null;
    private Urn companyUrn = null;
    private String description = null;
    private Urn entityUrn = null;
    private boolean hasCompanyName = false;
    private boolean hasCompanyUrn = false;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasLocationName = false;
    private boolean hasRegion = false;
    private boolean hasTimePeriod = false;
    private boolean hasTitle = false;
    private String locationName = null;
    private Urn region = null;
    private DateRange timePeriod = null;
    private String title = null;
    
    public Builder() {}
    
    public Builder(NormPosition paramNormPosition)
    {
      entityUrn = entityUrn;
      title = title;
      description = description;
      timePeriod = timePeriod;
      region = region;
      locationName = locationName;
      companyName = companyName;
      companyUrn = companyUrn;
      hasEntityUrn = hasEntityUrn;
      hasTitle = hasTitle;
      hasDescription = hasDescription;
      hasTimePeriod = hasTimePeriod;
      hasRegion = hasRegion;
      hasLocationName = hasLocationName;
      hasCompanyName = hasCompanyName;
      hasCompanyUrn = hasCompanyUrn;
    }
    
    public final NormPosition build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = NormPosition.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new NormPosition(entityUrn, title, description, timePeriod, region, locationName, companyName, companyUrn, hasEntityUrn, hasTitle, hasDescription, hasTimePeriod, hasRegion, hasLocationName, hasCompanyName, hasCompanyUrn);
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
    
    public final Builder setLocationName(String paramString)
    {
      if (paramString == null)
      {
        hasLocationName = false;
        locationName = null;
        return this;
      }
      hasLocationName = true;
      locationName = paramString;
      return this;
    }
    
    public final Builder setRegion(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasRegion = false;
        region = null;
        return this;
      }
      hasRegion = true;
      region = paramUrn;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */