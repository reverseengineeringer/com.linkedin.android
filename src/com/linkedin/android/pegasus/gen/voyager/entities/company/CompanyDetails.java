package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CompanyDetails
  implements FissileDataModel<CompanyDetails>, RecordTemplate<CompanyDetails>
{
  public static final CompanyDetailsBuilder BUILDER = CompanyDetailsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String companyType;
  public final String employeeCountRange;
  public final Date foundedDate;
  public final Date foundedOn;
  public final boolean hasCompanyType;
  public final boolean hasEmployeeCountRange;
  public final boolean hasFoundedDate;
  public final boolean hasFoundedOn;
  public final boolean hasHeadquarters;
  public final boolean hasIndustries;
  public final boolean hasSpecialties;
  public final boolean hasWebsiteUrl;
  public final String headquarters;
  public final List<String> industries;
  public final List<String> specialties;
  public final String websiteUrl;
  
  CompanyDetails(List<String> paramList1, String paramString1, String paramString2, String paramString3, List<String> paramList2, String paramString4, Date paramDate1, Date paramDate2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    if (paramList1 == null)
    {
      paramList1 = null;
      industries = paramList1;
      websiteUrl = paramString1;
      employeeCountRange = paramString2;
      companyType = paramString3;
      if (paramList2 != null) {
        break label133;
      }
    }
    label133:
    for (paramList1 = null;; paramList1 = Collections.unmodifiableList(paramList2))
    {
      specialties = paramList1;
      headquarters = paramString4;
      foundedDate = paramDate1;
      foundedOn = paramDate2;
      hasIndustries = paramBoolean1;
      hasWebsiteUrl = paramBoolean2;
      hasEmployeeCountRange = paramBoolean3;
      hasCompanyType = paramBoolean4;
      hasSpecialties = paramBoolean5;
      hasHeadquarters = paramBoolean6;
      hasFoundedDate = paramBoolean7;
      hasFoundedOn = paramBoolean8;
      _cachedId = null;
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  public final CompanyDetails accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    if (hasIndustries)
    {
      paramDataProcessor.startRecordField$505cff1c("industries");
      industries.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = industries.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject1 == null) {
        break label361;
      }
    }
    boolean bool2;
    Object localObject4;
    label361:
    for (bool1 = true;; bool1 = false)
    {
      if (hasWebsiteUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("websiteUrl");
        paramDataProcessor.processString(websiteUrl);
      }
      if (hasEmployeeCountRange)
      {
        paramDataProcessor.startRecordField$505cff1c("employeeCountRange");
        paramDataProcessor.processString(employeeCountRange);
      }
      if (hasCompanyType)
      {
        paramDataProcessor.startRecordField$505cff1c("companyType");
        paramDataProcessor.processString(companyType);
      }
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasSpecialties) {
        break label380;
      }
      paramDataProcessor.startRecordField$505cff1c("specialties");
      specialties.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = specialties.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject4);
        if (localObject2 != null) {
          ((List)localObject2).add(localObject4);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    label380:
    boolean bool3;
    if (localObject2 != null)
    {
      bool2 = true;
      if (hasHeadquarters)
      {
        paramDataProcessor.startRecordField$505cff1c("headquarters");
        paramDataProcessor.processString(headquarters);
      }
      localObject4 = null;
      bool3 = false;
      if (hasFoundedDate)
      {
        paramDataProcessor.startRecordField$505cff1c("foundedDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label610;
        }
        localObject3 = foundedDate.accept(paramDataProcessor);
        label445:
        if (localObject3 == null) {
          break label628;
        }
        bool3 = true;
        localObject4 = localObject3;
      }
      label457:
      localObject3 = null;
      bool4 = false;
      if (hasFoundedOn)
      {
        paramDataProcessor.startRecordField$505cff1c("foundedOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label638;
        }
        localObject3 = foundedOn.accept(paramDataProcessor);
        label497:
        if (localObject3 == null) {
          break label656;
        }
      }
    }
    label610:
    label628:
    label638:
    label656:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label767;
      }
      if (!hasIndustries) {
        localObject1 = Collections.emptyList();
      }
      if (!hasSpecialties) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (industries == null) {
          break label662;
        }
        paramDataProcessor = industries.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((String)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyDetails", "industries");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      break;
      localObject3 = (Date)paramDataProcessor.processDataTemplate(foundedDate);
      break label445;
      bool3 = false;
      localObject4 = localObject3;
      break label457;
      localObject3 = (Date)paramDataProcessor.processDataTemplate(foundedOn);
      break label497;
    }
    label662:
    if (specialties != null)
    {
      paramDataProcessor = specialties.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyDetails", "specialties");
        }
      }
    }
    return new CompanyDetails((List)localObject1, websiteUrl, employeeCountRange, companyType, (List)localObject2, headquarters, (Date)localObject4, (Date)localObject3, bool1, hasWebsiteUrl, hasEmployeeCountRange, hasCompanyType, bool2, hasHeadquarters, bool3, bool4);
    label767:
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
      paramObject = (CompanyDetails)paramObject;
      if (industries != null)
      {
        if (industries.equals(industries)) {}
      }
      else {
        while (industries != null) {
          return false;
        }
      }
      if (websiteUrl != null)
      {
        if (websiteUrl.equals(websiteUrl)) {}
      }
      else {
        while (websiteUrl != null) {
          return false;
        }
      }
      if (employeeCountRange != null)
      {
        if (employeeCountRange.equals(employeeCountRange)) {}
      }
      else {
        while (employeeCountRange != null) {
          return false;
        }
      }
      if (companyType != null)
      {
        if (companyType.equals(companyType)) {}
      }
      else {
        while (companyType != null) {
          return false;
        }
      }
      if (specialties != null)
      {
        if (specialties.equals(specialties)) {}
      }
      else {
        while (specialties != null) {
          return false;
        }
      }
      if (headquarters != null)
      {
        if (headquarters.equals(headquarters)) {}
      }
      else {
        while (headquarters != null) {
          return false;
        }
      }
      if (foundedDate != null)
      {
        if (foundedDate.equals(foundedDate)) {}
      }
      else {
        while (foundedDate != null) {
          return false;
        }
      }
      if (foundedOn == null) {
        break;
      }
    } while (foundedOn.equals(foundedOn));
    for (;;)
    {
      return false;
      if (foundedOn == null) {
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
    int j = i;
    Iterator localIterator;
    if (hasIndustries)
    {
      i += 2;
      localIterator = industries.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    j += 1;
    i = j;
    if (hasWebsiteUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(websiteUrl);
    }
    j = i + 1;
    i = j;
    if (hasEmployeeCountRange) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(employeeCountRange);
    }
    j = i + 1;
    i = j;
    if (hasCompanyType) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyType);
    }
    i += 1;
    j = i;
    if (hasSpecialties)
    {
      i += 2;
      localIterator = specialties.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    j += 1;
    i = j;
    if (hasHeadquarters) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(headquarters);
    }
    j = i + 1;
    i = j;
    if (hasFoundedDate)
    {
      i = j + 1;
      if (foundedDate._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(foundedDate._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasFoundedOn)
      {
        i = j + 1;
        if (foundedOn._cachedId == null) {
          break label336;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(foundedOn._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += foundedDate.getSerializedSize();
      break;
      label336:
      i += foundedOn.getSerializedSize();
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
    label47:
    int k;
    label62:
    int m;
    label78:
    int n;
    label96:
    int i1;
    if (industries != null)
    {
      i = industries.hashCode();
      if (websiteUrl == null) {
        break label202;
      }
      j = websiteUrl.hashCode();
      if (employeeCountRange == null) {
        break label207;
      }
      k = employeeCountRange.hashCode();
      if (companyType == null) {
        break label212;
      }
      m = companyType.hashCode();
      if (specialties == null) {
        break label218;
      }
      n = specialties.hashCode();
      if (headquarters == null) {
        break label224;
      }
      i1 = headquarters.hashCode();
      label112:
      if (foundedDate == null) {
        break label230;
      }
    }
    label202:
    label207:
    label212:
    label218:
    label224:
    label230:
    for (int i2 = foundedDate.hashCode();; i2 = 0)
    {
      if (foundedOn != null) {
        i3 = foundedOn.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
      m = 0;
      break label78;
      n = 0;
      break label96;
      i1 = 0;
      break label112;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyDetails");
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
    label242:
    label351:
    label361:
    label371:
    label464:
    label567:
    label592:
    label602:
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
        localByteBuffer.putInt(350410276);
        Iterator localIterator;
        if (hasIndustries)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, industries.size());
          localIterator = industries.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasWebsiteUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, websiteUrl);
          if (!hasEmployeeCountRange) {
            break label351;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, employeeCountRange);
          if (!hasCompanyType) {
            break label361;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyType);
        }
        for (;;)
        {
          if (!hasSpecialties) {
            break label371;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, specialties.size());
          localIterator = specialties.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label242;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasHeadquarters)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, headquarters);
          if (!hasFoundedDate) {
            break label592;
          }
          localByteBuffer.put((byte)1);
          if (foundedDate._cachedId == null) {
            break label567;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, foundedDate._cachedId);
          foundedDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFoundedOn) {
            break label627;
          }
          localByteBuffer.put((byte)1);
          if (foundedOn._cachedId == null) {
            break label602;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, foundedOn._cachedId);
          foundedOn.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          foundedDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label464;
          localByteBuffer.put((byte)0);
          break label464;
          localByteBuffer.put((byte)1);
          foundedOn.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */