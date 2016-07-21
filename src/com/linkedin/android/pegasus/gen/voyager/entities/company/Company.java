package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.common.EntityInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Company
  implements FissileDataModel<Company>, RecordTemplate<Company>
{
  public static final CompanyBuilder BUILDER = CompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final BasicCompanyInfo basicCompanyInfo;
  public final String companyType;
  public final String description;
  public final List<String> emailDomains;
  public final String employeeCountRange;
  public final EntityInfo entityInfo;
  public final Urn entityUrn;
  public final List<EntitiesFlavor> flavors;
  public final Date foundedDate;
  public final Date foundedOn;
  public final boolean hasBasicCompanyInfo;
  public final boolean hasCompanyType;
  public final boolean hasDescription;
  public final boolean hasEmailDomains;
  public final boolean hasEmployeeCountRange;
  public final boolean hasEntityInfo;
  public final boolean hasEntityUrn;
  public final boolean hasFlavors;
  public final boolean hasFoundedDate;
  public final boolean hasFoundedOn;
  public final boolean hasHeroImage;
  public final boolean hasIndustries;
  public final boolean hasJobsCount;
  public final boolean hasNumberOfEmployees;
  public final boolean hasParentCompany;
  public final boolean hasSections;
  public final boolean hasShowcases;
  public final boolean hasSpecialties;
  public final boolean hasWebsiteUrl;
  public final Image heroImage;
  public final List<String> industries;
  public final int jobsCount;
  public final int numberOfEmployees;
  public final MiniCompany parentCompany;
  public final CompanySections sections;
  public final List<BasicCompanyInfo> showcases;
  public final List<String> specialties;
  public final String websiteUrl;
  
  Company(Urn paramUrn, BasicCompanyInfo paramBasicCompanyInfo, Image paramImage, String paramString1, List<String> paramList1, String paramString2, String paramString3, List<String> paramList2, List<String> paramList3, String paramString4, Date paramDate1, Date paramDate2, List<BasicCompanyInfo> paramList, MiniCompany paramMiniCompany, CompanySections paramCompanySections, EntityInfo paramEntityInfo, int paramInt1, int paramInt2, List<EntitiesFlavor> paramList4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19)
  {
    entityUrn = paramUrn;
    basicCompanyInfo = paramBasicCompanyInfo;
    heroImage = paramImage;
    description = paramString1;
    if (paramList1 == null)
    {
      paramBasicCompanyInfo = null;
      industries = paramBasicCompanyInfo;
      websiteUrl = paramString2;
      companyType = paramString3;
      if (paramList2 != null) {
        break label291;
      }
      paramBasicCompanyInfo = null;
      label66:
      specialties = paramBasicCompanyInfo;
      if (paramList3 != null) {
        break label300;
      }
      paramBasicCompanyInfo = null;
      label78:
      emailDomains = paramBasicCompanyInfo;
      employeeCountRange = paramString4;
      foundedDate = paramDate1;
      foundedOn = paramDate2;
      if (paramList != null) {
        break label309;
      }
      paramBasicCompanyInfo = null;
      label108:
      showcases = paramBasicCompanyInfo;
      parentCompany = paramMiniCompany;
      sections = paramCompanySections;
      entityInfo = paramEntityInfo;
      numberOfEmployees = paramInt1;
      jobsCount = paramInt2;
      if (paramList4 != null) {
        break label318;
      }
    }
    label291:
    label300:
    label309:
    label318:
    for (paramBasicCompanyInfo = null;; paramBasicCompanyInfo = Collections.unmodifiableList(paramList4))
    {
      flavors = paramBasicCompanyInfo;
      hasEntityUrn = paramBoolean1;
      hasBasicCompanyInfo = paramBoolean2;
      hasHeroImage = paramBoolean3;
      hasDescription = paramBoolean4;
      hasIndustries = paramBoolean5;
      hasWebsiteUrl = paramBoolean6;
      hasCompanyType = paramBoolean7;
      hasSpecialties = paramBoolean8;
      hasEmailDomains = paramBoolean9;
      hasEmployeeCountRange = paramBoolean10;
      hasFoundedDate = paramBoolean11;
      hasFoundedOn = paramBoolean12;
      hasShowcases = paramBoolean13;
      hasParentCompany = paramBoolean14;
      hasSections = paramBoolean15;
      hasEntityInfo = paramBoolean16;
      hasNumberOfEmployees = paramBoolean17;
      hasJobsCount = paramBoolean18;
      hasFlavors = paramBoolean19;
      paramBasicCompanyInfo = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramBasicCompanyInfo = Collections.unmodifiableList(paramList1);
      break;
      paramBasicCompanyInfo = Collections.unmodifiableList(paramList2);
      break label66;
      paramBasicCompanyInfo = Collections.unmodifiableList(paramList3);
      break label78;
      paramBasicCompanyInfo = Collections.unmodifiableList(paramList);
      break label108;
    }
  }
  
  private Company accept(DataProcessor paramDataProcessor)
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
    Object localObject6 = null;
    boolean bool1 = false;
    label89:
    boolean bool2;
    if (hasBasicCompanyInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("basicCompanyInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = basicCompanyInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label318;
        }
        bool1 = true;
        localObject6 = localObject1;
      }
    }
    else
    {
      localObject7 = null;
      bool2 = false;
      if (hasHeroImage)
      {
        paramDataProcessor.startRecordField$505cff1c("heroImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label327;
        }
        localObject1 = heroImage.accept(paramDataProcessor);
        label129:
        if (localObject1 == null) {
          break label345;
        }
        bool2 = true;
      }
    }
    Object localObject2;
    int i;
    Object localObject3;
    for (Object localObject7 = localObject1;; localObject7 = localObject1)
    {
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasIndustries) {
        break label369;
      }
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
      localObject1 = (BasicCompanyInfo)paramDataProcessor.processDataTemplate(basicCompanyInfo);
      break;
      label318:
      bool1 = false;
      localObject6 = localObject1;
      break label89;
      label327:
      localObject1 = (Image)paramDataProcessor.processDataTemplate(heroImage);
      break label129;
      label345:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    label369:
    Object localObject4;
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasWebsiteUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("websiteUrl");
        paramDataProcessor.processString(websiteUrl);
      }
      if (hasCompanyType)
      {
        paramDataProcessor.startRecordField$505cff1c("companyType");
        paramDataProcessor.processString(companyType);
      }
      localObject2 = null;
      localObject3 = null;
      bool4 = false;
      if (!hasSpecialties) {
        break label576;
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
    if (localObject2 != null) {}
    label576:
    boolean bool5;
    for (boolean bool4 = true;; bool4 = false)
    {
      localObject3 = null;
      localObject4 = null;
      bool5 = false;
      if (!hasEmailDomains) {
        break label731;
      }
      paramDataProcessor.startRecordField$505cff1c("emailDomains");
      emailDomains.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject4 = emailDomains.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject5);
        if (localObject3 != null) {
          ((List)localObject3).add(localObject5);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    label731:
    Object localObject8;
    boolean bool6;
    label798:
    label810:
    Object localObject9;
    boolean bool7;
    label851:
    label863:
    boolean bool8;
    Object localObject10;
    if (localObject3 != null)
    {
      bool5 = true;
      if (hasEmployeeCountRange)
      {
        paramDataProcessor.startRecordField$505cff1c("employeeCountRange");
        paramDataProcessor.processString(employeeCountRange);
      }
      localObject8 = null;
      bool6 = false;
      if (hasFoundedDate)
      {
        paramDataProcessor.startRecordField$505cff1c("foundedDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1018;
        }
        localObject4 = foundedDate.accept(paramDataProcessor);
        if (localObject4 == null) {
          break label1036;
        }
        bool6 = true;
        localObject8 = localObject4;
      }
      localObject9 = null;
      bool7 = false;
      if (hasFoundedOn)
      {
        paramDataProcessor.startRecordField$505cff1c("foundedOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1046;
        }
        localObject4 = foundedOn.accept(paramDataProcessor);
        if (localObject4 == null) {
          break label1064;
        }
        bool7 = true;
        localObject9 = localObject4;
      }
      localObject4 = null;
      localObject5 = null;
      bool8 = false;
      if (!hasShowcases) {
        break label1104;
      }
      paramDataProcessor.startRecordField$505cff1c("showcases");
      showcases.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      localObject10 = showcases.iterator();
      label939:
      if (!((Iterator)localObject10).hasNext()) {
        break label1090;
      }
      localObject5 = (BasicCompanyInfo)((Iterator)localObject10).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1074;
      }
    }
    label1018:
    label1036:
    label1046:
    label1064:
    label1074:
    for (Object localObject5 = ((BasicCompanyInfo)localObject5).accept(paramDataProcessor);; localObject5 = (BasicCompanyInfo)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject4 != null) && (localObject5 != null)) {
        ((List)localObject4).add(localObject5);
      }
      i += 1;
      break label939;
      bool5 = false;
      break;
      localObject4 = (Date)paramDataProcessor.processDataTemplate(foundedDate);
      break label798;
      bool6 = false;
      localObject8 = localObject4;
      break label810;
      localObject4 = (Date)paramDataProcessor.processDataTemplate(foundedOn);
      break label851;
      bool7 = false;
      localObject9 = localObject4;
      break label863;
    }
    label1090:
    paramDataProcessor.endArray();
    label1104:
    boolean bool9;
    label1145:
    label1157:
    Object localObject11;
    boolean bool10;
    label1198:
    label1210:
    Object localObject12;
    boolean bool11;
    if (localObject4 != null)
    {
      bool8 = true;
      localObject10 = null;
      bool9 = false;
      if (hasParentCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("parentCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1470;
        }
        localObject5 = parentCompany.accept(paramDataProcessor);
        if (localObject5 == null) {
          break label1488;
        }
        bool9 = true;
        localObject10 = localObject5;
      }
      localObject11 = null;
      bool10 = false;
      if (hasSections)
      {
        paramDataProcessor.startRecordField$505cff1c("sections");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1498;
        }
        localObject5 = sections.accept(paramDataProcessor);
        if (localObject5 == null) {
          break label1516;
        }
        bool10 = true;
        localObject11 = localObject5;
      }
      localObject12 = null;
      bool11 = false;
      if (hasEntityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("entityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1526;
        }
        localObject5 = entityInfo.accept(paramDataProcessor);
        label1251:
        if (localObject5 == null) {
          break label1544;
        }
        bool11 = true;
        localObject12 = localObject5;
      }
      label1263:
      if (hasNumberOfEmployees)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfEmployees");
        paramDataProcessor.processInt(numberOfEmployees);
      }
      if (hasJobsCount)
      {
        paramDataProcessor.startRecordField$505cff1c("jobsCount");
        paramDataProcessor.processInt(jobsCount);
      }
      localObject5 = null;
      localEntitiesFlavor = null;
      bool12 = false;
      if (!hasFlavors) {
        break label1584;
      }
      paramDataProcessor.startRecordField$505cff1c("flavors");
      flavors.size();
      paramDataProcessor.startArray$13462e();
      localObject5 = localEntitiesFlavor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject5 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = flavors.iterator();
      label1391:
      if (!localIterator.hasNext()) {
        break label1570;
      }
      localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1554;
      }
    }
    label1470:
    label1488:
    label1498:
    label1516:
    label1526:
    label1544:
    label1554:
    for (EntitiesFlavor localEntitiesFlavor = localEntitiesFlavor.accept(paramDataProcessor);; localEntitiesFlavor = (EntitiesFlavor)paramDataProcessor.processDataTemplate(localEntitiesFlavor))
    {
      if ((localObject5 != null) && (localEntitiesFlavor != null)) {
        ((List)localObject5).add(localEntitiesFlavor);
      }
      i += 1;
      break label1391;
      bool8 = false;
      break;
      localObject5 = (MiniCompany)paramDataProcessor.processDataTemplate(parentCompany);
      break label1145;
      bool9 = false;
      localObject10 = localObject5;
      break label1157;
      localObject5 = (CompanySections)paramDataProcessor.processDataTemplate(sections);
      break label1198;
      bool10 = false;
      localObject11 = localObject5;
      break label1210;
      localObject5 = (EntityInfo)paramDataProcessor.processDataTemplate(entityInfo);
      break label1251;
      bool11 = false;
      localObject12 = localObject5;
      break label1263;
    }
    label1570:
    paramDataProcessor.endArray();
    if (localObject5 != null) {}
    for (boolean bool12 = true;; bool12 = false)
    {
      label1584:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label2086;
      }
      if (!hasIndustries) {
        localObject1 = Collections.emptyList();
      }
      if (!hasSpecialties) {
        localObject2 = Collections.emptyList();
      }
      if (!hasEmailDomains) {
        localObject3 = Collections.emptyList();
      }
      if (!hasShowcases) {
        localObject4 = Collections.emptyList();
      }
      if (!hasFlavors) {
        localObject5 = Collections.emptyList();
      }
      try
      {
        if (hasBasicCompanyInfo) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "basicCompanyInfo");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasEntityInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "entityInfo");
    }
    if (industries != null)
    {
      paramDataProcessor = industries.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "industries");
        }
      }
    }
    if (specialties != null)
    {
      paramDataProcessor = specialties.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "specialties");
        }
      }
    }
    if (emailDomains != null)
    {
      paramDataProcessor = emailDomains.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "emailDomains");
        }
      }
    }
    if (showcases != null)
    {
      paramDataProcessor = showcases.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((BasicCompanyInfo)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "showcases");
        }
      }
    }
    if (flavors != null)
    {
      paramDataProcessor = flavors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesFlavor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.Company", "flavors");
        }
      }
    }
    return new Company(entityUrn, (BasicCompanyInfo)localObject6, (Image)localObject7, description, (List)localObject1, websiteUrl, companyType, (List)localObject2, (List)localObject3, employeeCountRange, (Date)localObject8, (Date)localObject9, (List)localObject4, (MiniCompany)localObject10, (CompanySections)localObject11, (EntityInfo)localObject12, numberOfEmployees, jobsCount, (List)localObject5, hasEntityUrn, bool1, bool2, hasDescription, bool3, hasWebsiteUrl, hasCompanyType, bool4, bool5, hasEmployeeCountRange, bool6, bool7, bool8, bool9, bool10, bool11, hasNumberOfEmployees, hasJobsCount, bool12);
    label2086:
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
      paramObject = (Company)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (basicCompanyInfo != null)
      {
        if (basicCompanyInfo.equals(basicCompanyInfo)) {}
      }
      else {
        while (basicCompanyInfo != null) {
          return false;
        }
      }
      if (heroImage != null)
      {
        if (heroImage.equals(heroImage)) {}
      }
      else {
        while (heroImage != null) {
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
      if (emailDomains != null)
      {
        if (emailDomains.equals(emailDomains)) {}
      }
      else {
        while (emailDomains != null) {
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
      if (foundedDate != null)
      {
        if (foundedDate.equals(foundedDate)) {}
      }
      else {
        while (foundedDate != null) {
          return false;
        }
      }
      if (foundedOn != null)
      {
        if (foundedOn.equals(foundedOn)) {}
      }
      else {
        while (foundedOn != null) {
          return false;
        }
      }
      if (showcases != null)
      {
        if (showcases.equals(showcases)) {}
      }
      else {
        while (showcases != null) {
          return false;
        }
      }
      if (parentCompany != null)
      {
        if (parentCompany.equals(parentCompany)) {}
      }
      else {
        while (parentCompany != null) {
          return false;
        }
      }
      if (sections != null)
      {
        if (sections.equals(sections)) {}
      }
      else {
        while (sections != null) {
          return false;
        }
      }
      if (entityInfo != null)
      {
        if (entityInfo.equals(entityInfo)) {}
      }
      else {
        while (entityInfo != null) {
          return false;
        }
      }
      if (numberOfEmployees != numberOfEmployees) {
        return false;
      }
      if (jobsCount != jobsCount) {
        return false;
      }
      if (flavors == null) {
        break;
      }
    } while (flavors.equals(flavors));
    for (;;)
    {
      return false;
      if (flavors == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBasicCompanyInfo)
    {
      i = j + 1;
      if (basicCompanyInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(basicCompanyInfo._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasHeroImage)
      {
        i = j + 1;
        if (heroImage._cachedId == null) {
          break label225;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(heroImage._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      i += 1;
      j = i;
      if (!hasIndustries) {
        break label238;
      }
      i += 2;
      localObject1 = industries.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject1).next());
      }
      i += basicCompanyInfo.getSerializedSize();
      break;
      label225:
      i += heroImage.getSerializedSize();
    }
    label238:
    j += 1;
    i = j;
    if (hasWebsiteUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(websiteUrl);
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
      localObject1 = specialties.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject1).next());
      }
    }
    i = j + 1;
    j = i;
    if (hasEmailDomains)
    {
      i += 2;
      localObject1 = emailDomains.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject1).next());
      }
    }
    j += 1;
    i = j;
    if (hasEmployeeCountRange) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(employeeCountRange);
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
          break label603;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(foundedOn._cachedId);
      }
      label513:
      i += 1;
      j = i;
      if (!hasShowcases) {
        break label627;
      }
      i += 2;
      localObject1 = showcases.iterator();
    }
    Object localObject2;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label627;
      }
      localObject2 = (BasicCompanyInfo)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += foundedDate.getSerializedSize();
        break;
        label603:
        i += foundedOn.getSerializedSize();
        break label513;
      }
      i += ((BasicCompanyInfo)localObject2).getSerializedSize();
    }
    label627:
    j += 1;
    i = j;
    if (hasParentCompany)
    {
      i = j + 1;
      if (parentCompany._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(parentCompany._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSections)
      {
        i = j + 1;
        if (sections._cachedId == null) {
          break label877;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sections._cachedId);
      }
      label711:
      j = i + 1;
      i = j;
      if (hasEntityInfo)
      {
        i = j + 1;
        if (entityInfo._cachedId == null) {
          break label890;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entityInfo._cachedId);
      }
      label753:
      j = i + 1;
      i = j;
      if (hasNumberOfEmployees) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasJobsCount) {
        i = j + 4;
      }
      i += 1;
      j = i;
      if (!hasFlavors) {
        break label914;
      }
      i += 2;
      localObject1 = flavors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label914;
      }
      localObject2 = (EntitiesFlavor)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += parentCompany.getSerializedSize();
        break;
        label877:
        i += sections.getSerializedSize();
        break label711;
        label890:
        i += entityInfo.getSerializedSize();
        break label753;
      }
      i += ((EntitiesFlavor)localObject2).getSerializedSize();
    }
    label914:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int i12 = 0;
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
    label94:
    int i1;
    label110:
    int i2;
    label126:
    int i3;
    label144:
    int i4;
    label162:
    int i5;
    label178:
    int i6;
    label194:
    int i7;
    label210:
    int i8;
    label228:
    int i9;
    label244:
    int i10;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (basicCompanyInfo == null) {
        break label430;
      }
      j = basicCompanyInfo.hashCode();
      if (heroImage == null) {
        break label435;
      }
      k = heroImage.hashCode();
      if (description == null) {
        break label440;
      }
      m = description.hashCode();
      if (industries == null) {
        break label446;
      }
      n = industries.hashCode();
      if (websiteUrl == null) {
        break label452;
      }
      i1 = websiteUrl.hashCode();
      if (companyType == null) {
        break label458;
      }
      i2 = companyType.hashCode();
      if (specialties == null) {
        break label464;
      }
      i3 = specialties.hashCode();
      if (emailDomains == null) {
        break label470;
      }
      i4 = emailDomains.hashCode();
      if (employeeCountRange == null) {
        break label476;
      }
      i5 = employeeCountRange.hashCode();
      if (foundedDate == null) {
        break label482;
      }
      i6 = foundedDate.hashCode();
      if (foundedOn == null) {
        break label488;
      }
      i7 = foundedOn.hashCode();
      if (showcases == null) {
        break label494;
      }
      i8 = showcases.hashCode();
      if (parentCompany == null) {
        break label500;
      }
      i9 = parentCompany.hashCode();
      if (sections == null) {
        break label506;
      }
      i10 = sections.hashCode();
      label260:
      if (entityInfo == null) {
        break label512;
      }
    }
    label430:
    label435:
    label440:
    label446:
    label452:
    label458:
    label464:
    label470:
    label476:
    label482:
    label488:
    label494:
    label500:
    label506:
    label512:
    for (int i11 = entityInfo.hashCode();; i11 = 0)
    {
      int i13 = numberOfEmployees;
      int i14 = jobsCount;
      if (flavors != null) {
        i12 = flavors.hashCode();
      }
      i = (((i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31 + i14) * 31 + i12;
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
      break label94;
      i1 = 0;
      break label110;
      i2 = 0;
      break label126;
      i3 = 0;
      break label144;
      i4 = 0;
      break label162;
      i5 = 0;
      break label178;
      i6 = 0;
      break label194;
      i7 = 0;
      break label210;
      i8 = 0;
      break label228;
      i9 = 0;
      break label244;
      i10 = 0;
      break label260;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Company");
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
    label206:
    label266:
    label375:
    label400:
    label410:
    label435:
    label445:
    label455:
    label597:
    label607:
    label780:
    label840:
    label957:
    label982:
    label992:
    label1017:
    label1050:
    label1057:
    label1177:
    label1237:
    label1261:
    label1285:
    label1427:
    label1452:
    label1462:
    label1487:
    label1497:
    label1507:
    label1540:
    label1547:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1369457278);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasBasicCompanyInfo) {
            break label400;
          }
          localByteBuffer.put((byte)1);
          if (basicCompanyInfo._cachedId == null) {
            break label375;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, basicCompanyInfo._cachedId);
          basicCompanyInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeroImage) {
            break label435;
          }
          localByteBuffer.put((byte)1);
          if (heroImage._cachedId == null) {
            break label410;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, heroImage._cachedId);
          heroImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label445;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
        }
        for (;;)
        {
          if (!hasIndustries) {
            break label455;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, industries.size());
          localObject1 = industries.iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject1).next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          basicCompanyInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label206;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)1);
          heroImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label266;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasWebsiteUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, websiteUrl);
          if (!hasCompanyType) {
            break label597;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyType);
        }
        for (;;)
        {
          if (!hasSpecialties) {
            break label607;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, specialties.size());
          localObject1 = specialties.iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject1).next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasEmailDomains)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, emailDomains.size());
          localObject1 = emailDomains.iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject1).next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasEmployeeCountRange)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, employeeCountRange);
          if (!hasFoundedDate) {
            break label982;
          }
          localByteBuffer.put((byte)1);
          if (foundedDate._cachedId == null) {
            break label957;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, foundedDate._cachedId);
          foundedDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFoundedOn) {
            break label1017;
          }
          localByteBuffer.put((byte)1);
          if (foundedOn._cachedId == null) {
            break label992;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, foundedOn._cachedId);
          foundedOn.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasShowcases) {
            break label1050;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, showcases.size());
          localObject1 = showcases.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1057;
          }
          localObject2 = (BasicCompanyInfo)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((BasicCompanyInfo)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            foundedDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label780;
            localByteBuffer.put((byte)0);
            break label780;
            localByteBuffer.put((byte)1);
            foundedOn.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label840;
            localByteBuffer.put((byte)0);
            break label840;
          }
          localByteBuffer.put((byte)1);
          ((BasicCompanyInfo)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasParentCompany)
        {
          localByteBuffer.put((byte)1);
          if (parentCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, parentCompany._cachedId);
            parentCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSections) {
              break label1452;
            }
            localByteBuffer.put((byte)1);
            if (sections._cachedId == null) {
              break label1427;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sections._cachedId);
            sections.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEntityInfo) {
              break label1487;
            }
            localByteBuffer.put((byte)1);
            if (entityInfo._cachedId == null) {
              break label1462;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, entityInfo._cachedId);
            entityInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNumberOfEmployees) {
              break label1497;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(numberOfEmployees);
            if (!hasJobsCount) {
              break label1507;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(jobsCount);
            if (!hasFlavors) {
              break label1540;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, flavors.size());
            localObject1 = flavors.iterator();
          }
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1547;
          }
          localObject2 = (EntitiesFlavor)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((EntitiesFlavor)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            parentCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            sections.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1177;
            localByteBuffer.put((byte)0);
            break label1177;
            localByteBuffer.put((byte)1);
            entityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1237;
            localByteBuffer.put((byte)0);
            break label1237;
            localByteBuffer.put((byte)0);
            break label1261;
            localByteBuffer.put((byte)0);
            break label1285;
          }
          localByteBuffer.put((byte)1);
          ((EntitiesFlavor)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.Company
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */