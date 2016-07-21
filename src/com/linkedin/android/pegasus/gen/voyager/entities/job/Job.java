package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.common.EntityInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobSavingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Job
  implements FissileDataModel<Job>, RecordTemplate<Job>
{
  public static final JobBuilder BUILDER = JobBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Applicant applicant;
  public final JobApplyingInfo applyingInfo;
  public final BasicCompanyInfo basicCompanyInfo;
  public final boolean closed;
  public final String companyApplyPostUrl;
  public final String companyApplyUrl;
  public final String companyDescription;
  public final String companyName;
  public final String description;
  public final String employmentStatus;
  public final EntityInfo entityInfo;
  public final Urn entityUrn;
  public final String experienceLevel;
  public final List<EntitiesFlavor> flavors;
  public final boolean hasApplicant;
  public final boolean hasApplyingInfo;
  public final boolean hasBasicCompanyInfo;
  public final boolean hasClosed;
  public final boolean hasCompanyApplyPostUrl;
  public final boolean hasCompanyApplyUrl;
  public final boolean hasCompanyDescription;
  public final boolean hasCompanyName;
  public final boolean hasDescription;
  public final boolean hasEmploymentStatus;
  public final boolean hasEntityInfo;
  public final boolean hasEntityUrn;
  public final boolean hasExperienceLevel;
  public final boolean hasFlavors;
  public final boolean hasHeroImage;
  public final boolean hasIndustries;
  public final boolean hasIsLinkedInRouting;
  public final boolean hasJobFunctions;
  public final boolean hasJobPoster;
  public final boolean hasLinkedInRouting;
  public final boolean hasMiniCompany;
  public final boolean hasMiniJob;
  public final boolean hasNumberOfApplicants;
  public final boolean hasNumberOfViewers;
  public final boolean hasSavingInfo;
  public final boolean hasSections;
  public final boolean hasSkillsDescription;
  public final Image heroImage;
  public final List<String> industries;
  public final boolean isLinkedInRouting;
  public final List<String> jobFunctions;
  public final InCommonPerson jobPoster;
  public final boolean linkedInRouting;
  public final MiniCompany miniCompany;
  public final MiniJob miniJob;
  public final long numberOfApplicants;
  public final long numberOfViewers;
  public final JobSavingInfo savingInfo;
  public final JobSections sections;
  public final String skillsDescription;
  
  Job(Urn paramUrn, MiniJob paramMiniJob, BasicCompanyInfo paramBasicCompanyInfo, long paramLong1, List<String> paramList1, List<String> paramList2, String paramString1, String paramString2, MiniCompany paramMiniCompany, String paramString3, String paramString4, Image paramImage, String paramString5, String paramString6, InCommonPerson paramInCommonPerson, Applicant paramApplicant, JobSavingInfo paramJobSavingInfo, JobApplyingInfo paramJobApplyingInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString7, String paramString8, JobSections paramJobSections, EntityInfo paramEntityInfo, long paramLong2, boolean paramBoolean3, List<EntitiesFlavor> paramList, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21, boolean paramBoolean22, boolean paramBoolean23, boolean paramBoolean24, boolean paramBoolean25, boolean paramBoolean26, boolean paramBoolean27, boolean paramBoolean28, boolean paramBoolean29, boolean paramBoolean30)
  {
    entityUrn = paramUrn;
    miniJob = paramMiniJob;
    basicCompanyInfo = paramBasicCompanyInfo;
    numberOfApplicants = paramLong1;
    if (paramList1 == null)
    {
      paramMiniJob = null;
      industries = paramMiniJob;
      if (paramList2 != null) {
        break label375;
      }
      paramMiniJob = null;
      label54:
      jobFunctions = paramMiniJob;
      description = paramString1;
      companyName = paramString2;
      miniCompany = paramMiniCompany;
      companyDescription = paramString3;
      experienceLevel = paramString4;
      heroImage = paramImage;
      employmentStatus = paramString5;
      skillsDescription = paramString6;
      jobPoster = paramInCommonPerson;
      applicant = paramApplicant;
      savingInfo = paramJobSavingInfo;
      applyingInfo = paramJobApplyingInfo;
      isLinkedInRouting = paramBoolean1;
      linkedInRouting = paramBoolean2;
      companyApplyUrl = paramString7;
      companyApplyPostUrl = paramString8;
      sections = paramJobSections;
      entityInfo = paramEntityInfo;
      numberOfViewers = paramLong2;
      closed = paramBoolean3;
      if (paramList != null) {
        break label384;
      }
    }
    label375:
    label384:
    for (paramMiniJob = null;; paramMiniJob = Collections.unmodifiableList(paramList))
    {
      flavors = paramMiniJob;
      hasEntityUrn = paramBoolean4;
      hasMiniJob = paramBoolean5;
      hasBasicCompanyInfo = paramBoolean6;
      hasNumberOfApplicants = paramBoolean7;
      hasIndustries = paramBoolean8;
      hasJobFunctions = paramBoolean9;
      hasDescription = paramBoolean10;
      hasCompanyName = paramBoolean11;
      hasMiniCompany = paramBoolean12;
      hasCompanyDescription = paramBoolean13;
      hasExperienceLevel = paramBoolean14;
      hasHeroImage = paramBoolean15;
      hasEmploymentStatus = paramBoolean16;
      hasSkillsDescription = paramBoolean17;
      hasJobPoster = paramBoolean18;
      hasApplicant = paramBoolean19;
      hasSavingInfo = paramBoolean20;
      hasApplyingInfo = paramBoolean21;
      hasIsLinkedInRouting = paramBoolean22;
      hasLinkedInRouting = paramBoolean23;
      hasCompanyApplyUrl = paramBoolean24;
      hasCompanyApplyPostUrl = paramBoolean25;
      hasSections = paramBoolean26;
      hasEntityInfo = paramBoolean27;
      hasNumberOfViewers = paramBoolean28;
      hasClosed = paramBoolean29;
      hasFlavors = paramBoolean30;
      paramMiniJob = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramMiniJob = Collections.unmodifiableList(paramList1);
      break;
      paramMiniJob = Collections.unmodifiableList(paramList2);
      break label54;
    }
  }
  
  private Job accept(DataProcessor paramDataProcessor)
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
    Object localObject4 = null;
    boolean bool1 = false;
    label89:
    boolean bool2;
    if (hasMiniJob)
    {
      paramDataProcessor.startRecordField$505cff1c("miniJob");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniJob.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label321;
        }
        bool1 = true;
        localObject4 = localObject1;
      }
    }
    else
    {
      localObject5 = null;
      bool2 = false;
      if (hasBasicCompanyInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("basicCompanyInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label330;
        }
        localObject1 = basicCompanyInfo.accept(paramDataProcessor);
        label130:
        if (localObject1 == null) {
          break label348;
        }
        bool2 = true;
      }
    }
    Object localObject2;
    int i;
    Object localObject3;
    for (Object localObject5 = localObject1;; localObject5 = localObject1)
    {
      if (hasNumberOfApplicants)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfApplicants");
        paramDataProcessor.processLong(numberOfApplicants);
      }
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasIndustries) {
        break label372;
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
      localObject1 = (MiniJob)paramDataProcessor.processDataTemplate(miniJob);
      break;
      label321:
      bool1 = false;
      localObject4 = localObject1;
      break label89;
      label330:
      localObject1 = (BasicCompanyInfo)paramDataProcessor.processDataTemplate(basicCompanyInfo);
      break label130;
      label348:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    label372:
    boolean bool4;
    Object localObject6;
    for (boolean bool3 = true;; bool3 = false)
    {
      localObject2 = null;
      localObject3 = null;
      bool4 = false;
      if (!hasJobFunctions) {
        break label527;
      }
      paramDataProcessor.startRecordField$505cff1c("jobFunctions");
      jobFunctions.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = jobFunctions.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject6 = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject6);
        if (localObject2 != null) {
          ((List)localObject2).add(localObject6);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    label527:
    boolean bool5;
    label620:
    label632:
    Object localObject7;
    boolean bool6;
    label725:
    label737:
    Object localObject8;
    boolean bool7;
    label830:
    label842:
    Object localObject9;
    boolean bool8;
    label883:
    label895:
    Object localObject10;
    boolean bool9;
    label936:
    label948:
    Object localObject11;
    boolean bool10;
    label989:
    label1001:
    Object localObject12;
    boolean bool11;
    label1146:
    label1158:
    Object localObject13;
    boolean bool12;
    if (localObject2 != null)
    {
      bool4 = true;
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      if (hasCompanyName)
      {
        paramDataProcessor.startRecordField$505cff1c("companyName");
        paramDataProcessor.processString(companyName);
      }
      localObject6 = null;
      bool5 = false;
      if (hasMiniCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("miniCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1418;
        }
        localObject3 = miniCompany.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1436;
        }
        bool5 = true;
        localObject6 = localObject3;
      }
      if (hasCompanyDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("companyDescription");
        paramDataProcessor.processString(companyDescription);
      }
      if (hasExperienceLevel)
      {
        paramDataProcessor.startRecordField$505cff1c("experienceLevel");
        paramDataProcessor.processString(experienceLevel);
      }
      localObject7 = null;
      bool6 = false;
      if (hasHeroImage)
      {
        paramDataProcessor.startRecordField$505cff1c("heroImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1446;
        }
        localObject3 = heroImage.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1464;
        }
        bool6 = true;
        localObject7 = localObject3;
      }
      if (hasEmploymentStatus)
      {
        paramDataProcessor.startRecordField$505cff1c("employmentStatus");
        paramDataProcessor.processString(employmentStatus);
      }
      if (hasSkillsDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("skillsDescription");
        paramDataProcessor.processString(skillsDescription);
      }
      localObject8 = null;
      bool7 = false;
      if (hasJobPoster)
      {
        paramDataProcessor.startRecordField$505cff1c("jobPoster");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1474;
        }
        localObject3 = jobPoster.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1492;
        }
        bool7 = true;
        localObject8 = localObject3;
      }
      localObject9 = null;
      bool8 = false;
      if (hasApplicant)
      {
        paramDataProcessor.startRecordField$505cff1c("applicant");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1502;
        }
        localObject3 = applicant.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1520;
        }
        bool8 = true;
        localObject9 = localObject3;
      }
      localObject10 = null;
      bool9 = false;
      if (hasSavingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("savingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1530;
        }
        localObject3 = savingInfo.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1548;
        }
        bool9 = true;
        localObject10 = localObject3;
      }
      localObject11 = null;
      bool10 = false;
      if (hasApplyingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("applyingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1558;
        }
        localObject3 = applyingInfo.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1576;
        }
        bool10 = true;
        localObject11 = localObject3;
      }
      if (hasIsLinkedInRouting)
      {
        paramDataProcessor.startRecordField$505cff1c("isLinkedInRouting");
        paramDataProcessor.processBoolean(isLinkedInRouting);
      }
      if (hasLinkedInRouting)
      {
        paramDataProcessor.startRecordField$505cff1c("linkedInRouting");
        paramDataProcessor.processBoolean(linkedInRouting);
      }
      if (hasCompanyApplyUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("companyApplyUrl");
        paramDataProcessor.processString(companyApplyUrl);
      }
      if (hasCompanyApplyPostUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("companyApplyPostUrl");
        paramDataProcessor.processString(companyApplyPostUrl);
      }
      localObject12 = null;
      bool11 = false;
      if (hasSections)
      {
        paramDataProcessor.startRecordField$505cff1c("sections");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1586;
        }
        localObject3 = sections.accept(paramDataProcessor);
        if (localObject3 == null) {
          break label1604;
        }
        bool11 = true;
        localObject12 = localObject3;
      }
      localObject13 = null;
      bool12 = false;
      if (hasEntityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("entityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1614;
        }
        localObject3 = entityInfo.accept(paramDataProcessor);
        label1199:
        if (localObject3 == null) {
          break label1632;
        }
        bool12 = true;
        localObject13 = localObject3;
      }
      label1211:
      if (hasNumberOfViewers)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfViewers");
        paramDataProcessor.processLong(numberOfViewers);
      }
      if (hasClosed)
      {
        paramDataProcessor.startRecordField$505cff1c("closed");
        paramDataProcessor.processBoolean(closed);
      }
      localObject3 = null;
      localEntitiesFlavor = null;
      bool13 = false;
      if (!hasFlavors) {
        break label1672;
      }
      paramDataProcessor.startRecordField$505cff1c("flavors");
      flavors.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localEntitiesFlavor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = flavors.iterator();
      label1339:
      if (!localIterator.hasNext()) {
        break label1658;
      }
      localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1642;
      }
    }
    label1418:
    label1436:
    label1446:
    label1464:
    label1474:
    label1492:
    label1502:
    label1520:
    label1530:
    label1548:
    label1558:
    label1576:
    label1586:
    label1604:
    label1614:
    label1632:
    label1642:
    for (EntitiesFlavor localEntitiesFlavor = localEntitiesFlavor.accept(paramDataProcessor);; localEntitiesFlavor = (EntitiesFlavor)paramDataProcessor.processDataTemplate(localEntitiesFlavor))
    {
      if ((localObject3 != null) && (localEntitiesFlavor != null)) {
        ((List)localObject3).add(localEntitiesFlavor);
      }
      i += 1;
      break label1339;
      bool4 = false;
      break;
      localObject3 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break label620;
      bool5 = false;
      localObject6 = localObject3;
      break label632;
      localObject3 = (Image)paramDataProcessor.processDataTemplate(heroImage);
      break label725;
      bool6 = false;
      localObject7 = localObject3;
      break label737;
      localObject3 = (InCommonPerson)paramDataProcessor.processDataTemplate(jobPoster);
      break label830;
      bool7 = false;
      localObject8 = localObject3;
      break label842;
      localObject3 = (Applicant)paramDataProcessor.processDataTemplate(applicant);
      break label883;
      bool8 = false;
      localObject9 = localObject3;
      break label895;
      localObject3 = (JobSavingInfo)paramDataProcessor.processDataTemplate(savingInfo);
      break label936;
      bool9 = false;
      localObject10 = localObject3;
      break label948;
      localObject3 = (JobApplyingInfo)paramDataProcessor.processDataTemplate(applyingInfo);
      break label989;
      bool10 = false;
      localObject11 = localObject3;
      break label1001;
      localObject3 = (JobSections)paramDataProcessor.processDataTemplate(sections);
      break label1146;
      bool11 = false;
      localObject12 = localObject3;
      break label1158;
      localObject3 = (EntityInfo)paramDataProcessor.processDataTemplate(entityInfo);
      break label1199;
      bool12 = false;
      localObject13 = localObject3;
      break label1211;
    }
    label1658:
    paramDataProcessor.endArray();
    if (localObject3 != null) {}
    for (boolean bool13 = true;; bool13 = false)
    {
      label1672:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label2170;
      }
      if (!hasIndustries) {
        localObject1 = Collections.emptyList();
      }
      if (!hasJobFunctions) {
        localObject2 = Collections.emptyList();
      }
      if (!hasFlavors) {
        localObject3 = Collections.emptyList();
      }
      try
      {
        if (hasMiniJob) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "miniJob");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasNumberOfApplicants) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "numberOfApplicants");
    }
    if (!hasSavingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "savingInfo");
    }
    if (!hasApplyingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "applyingInfo");
    }
    if (!hasEntityInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "entityInfo");
    }
    if (industries != null)
    {
      paramDataProcessor = industries.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "industries");
        }
      }
    }
    if (jobFunctions != null)
    {
      paramDataProcessor = jobFunctions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "jobFunctions");
        }
      }
    }
    if (flavors != null)
    {
      paramDataProcessor = flavors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesFlavor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.Job", "flavors");
        }
      }
    }
    return new Job(entityUrn, (MiniJob)localObject4, (BasicCompanyInfo)localObject5, numberOfApplicants, (List)localObject1, (List)localObject2, description, companyName, (MiniCompany)localObject6, companyDescription, experienceLevel, (Image)localObject7, employmentStatus, skillsDescription, (InCommonPerson)localObject8, (Applicant)localObject9, (JobSavingInfo)localObject10, (JobApplyingInfo)localObject11, isLinkedInRouting, linkedInRouting, companyApplyUrl, companyApplyPostUrl, (JobSections)localObject12, (EntityInfo)localObject13, numberOfViewers, closed, (List)localObject3, hasEntityUrn, bool1, bool2, hasNumberOfApplicants, bool3, bool4, hasDescription, hasCompanyName, bool5, hasCompanyDescription, hasExperienceLevel, bool6, hasEmploymentStatus, hasSkillsDescription, bool7, bool8, bool9, bool10, hasIsLinkedInRouting, hasLinkedInRouting, hasCompanyApplyUrl, hasCompanyApplyPostUrl, bool11, bool12, hasNumberOfViewers, hasClosed, bool13);
    label2170:
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
      paramObject = (Job)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniJob != null)
      {
        if (miniJob.equals(miniJob)) {}
      }
      else {
        while (miniJob != null) {
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
      if (numberOfApplicants != numberOfApplicants) {
        return false;
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
      if (jobFunctions != null)
      {
        if (jobFunctions.equals(jobFunctions)) {}
      }
      else {
        while (jobFunctions != null) {
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
      if (companyName != null)
      {
        if (companyName.equals(companyName)) {}
      }
      else {
        while (companyName != null) {
          return false;
        }
      }
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (companyDescription != null)
      {
        if (companyDescription.equals(companyDescription)) {}
      }
      else {
        while (companyDescription != null) {
          return false;
        }
      }
      if (experienceLevel != null)
      {
        if (experienceLevel.equals(experienceLevel)) {}
      }
      else {
        while (experienceLevel != null) {
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
      if (employmentStatus != null)
      {
        if (employmentStatus.equals(employmentStatus)) {}
      }
      else {
        while (employmentStatus != null) {
          return false;
        }
      }
      if (skillsDescription != null)
      {
        if (skillsDescription.equals(skillsDescription)) {}
      }
      else {
        while (skillsDescription != null) {
          return false;
        }
      }
      if (jobPoster != null)
      {
        if (jobPoster.equals(jobPoster)) {}
      }
      else {
        while (jobPoster != null) {
          return false;
        }
      }
      if (applicant != null)
      {
        if (applicant.equals(applicant)) {}
      }
      else {
        while (applicant != null) {
          return false;
        }
      }
      if (savingInfo != null)
      {
        if (savingInfo.equals(savingInfo)) {}
      }
      else {
        while (savingInfo != null) {
          return false;
        }
      }
      if (applyingInfo != null)
      {
        if (applyingInfo.equals(applyingInfo)) {}
      }
      else {
        while (applyingInfo != null) {
          return false;
        }
      }
      if (isLinkedInRouting != isLinkedInRouting) {
        return false;
      }
      if (linkedInRouting != linkedInRouting) {
        return false;
      }
      if (companyApplyUrl != null)
      {
        if (companyApplyUrl.equals(companyApplyUrl)) {}
      }
      else {
        while (companyApplyUrl != null) {
          return false;
        }
      }
      if (companyApplyPostUrl != null)
      {
        if (companyApplyPostUrl.equals(companyApplyPostUrl)) {}
      }
      else {
        while (companyApplyPostUrl != null) {
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
      if (numberOfViewers != numberOfViewers) {
        return false;
      }
      if (closed != closed) {
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
    Object localObject;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniJob)
    {
      i = j + 1;
      if (miniJob._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniJob._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBasicCompanyInfo)
      {
        i = j + 1;
        if (basicCompanyInfo._cachedId == null) {
          break label218;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(basicCompanyInfo._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasNumberOfApplicants) {
        i = j + 8;
      }
      i += 1;
      j = i;
      if (!hasIndustries) {
        break label231;
      }
      i += 2;
      localObject = industries.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject).next());
      }
      i += miniJob.getSerializedSize();
      break;
      label218:
      i += basicCompanyInfo.getSerializedSize();
    }
    label231:
    i = j + 1;
    j = i;
    if (hasJobFunctions)
    {
      i += 2;
      localObject = jobFunctions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject).next());
      }
    }
    j += 1;
    i = j;
    if (hasDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
    }
    j = i + 1;
    i = j;
    if (hasCompanyName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyName);
    }
    j = i + 1;
    i = j;
    if (hasMiniCompany)
    {
      i = j + 1;
      if (miniCompany._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasCompanyDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyDescription);
      }
      j = i + 1;
      i = j;
      if (hasExperienceLevel) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(experienceLevel);
      }
      j = i + 1;
      i = j;
      if (hasHeroImage)
      {
        i = j + 1;
        if (heroImage._cachedId == null) {
          break label984;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(heroImage._cachedId);
      }
      label473:
      j = i + 1;
      i = j;
      if (hasEmploymentStatus) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(employmentStatus);
      }
      j = i + 1;
      i = j;
      if (hasSkillsDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(skillsDescription);
      }
      j = i + 1;
      i = j;
      if (hasJobPoster)
      {
        i = j + 1;
        if (jobPoster._cachedId == null) {
          break label997;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobPoster._cachedId);
      }
      label565:
      j = i + 1;
      i = j;
      if (hasApplicant)
      {
        i = j + 1;
        if (applicant._cachedId == null) {
          break label1010;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(applicant._cachedId);
      }
      label607:
      j = i + 1;
      i = j;
      if (hasSavingInfo)
      {
        i = j + 1;
        if (savingInfo._cachedId == null) {
          break label1023;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(savingInfo._cachedId);
      }
      label649:
      j = i + 1;
      i = j;
      if (hasApplyingInfo)
      {
        i = j + 1;
        if (applyingInfo._cachedId == null) {
          break label1036;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(applyingInfo._cachedId);
      }
      label691:
      j = i + 1;
      i = j;
      if (hasIsLinkedInRouting) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasLinkedInRouting) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasCompanyApplyUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyApplyUrl);
      }
      j = i + 1;
      i = j;
      if (hasCompanyApplyPostUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyApplyPostUrl);
      }
      j = i + 1;
      i = j;
      if (hasSections)
      {
        i = j + 1;
        if (sections._cachedId == null) {
          break label1049;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sections._cachedId);
      }
      label817:
      j = i + 1;
      i = j;
      if (hasEntityInfo)
      {
        i = j + 1;
        if (entityInfo._cachedId == null) {
          break label1062;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entityInfo._cachedId);
      }
      label859:
      j = i + 1;
      i = j;
      if (hasNumberOfViewers) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasClosed) {
        i = j + 1;
      }
      i += 1;
      j = i;
      if (!hasFlavors) {
        break label1086;
      }
      i += 2;
      localObject = flavors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label1086;
      }
      EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += miniCompany.getSerializedSize();
        break;
        label984:
        i += heroImage.getSerializedSize();
        break label473;
        label997:
        i += jobPoster.getSerializedSize();
        break label565;
        label1010:
        i += applicant.getSerializedSize();
        break label607;
        label1023:
        i += savingInfo.getSerializedSize();
        break label649;
        label1036:
        i += applyingInfo.getSerializedSize();
        break label691;
        label1049:
        i += sections.getSerializedSize();
        break label817;
        label1062:
        i += entityInfo.getSerializedSize();
        break label859;
      }
      i += localEntitiesFlavor.getSerializedSize();
    }
    label1086:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int i19 = 1;
    int i20 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label48:
    int k;
    label63:
    int i21;
    int m;
    label96:
    int n;
    label114:
    int i1;
    label130:
    int i2;
    label146:
    int i3;
    label162:
    int i4;
    label178:
    int i5;
    label194:
    int i6;
    label210:
    int i7;
    label226:
    int i8;
    label242:
    int i9;
    label258:
    int i10;
    label274:
    int i11;
    label290:
    int i12;
    label306:
    int i13;
    label316:
    int i14;
    label326:
    int i15;
    label342:
    int i16;
    label358:
    int i17;
    label374:
    int i18;
    label390:
    int i22;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (miniJob == null) {
        break label602;
      }
      j = miniJob.hashCode();
      if (basicCompanyInfo == null) {
        break label607;
      }
      k = basicCompanyInfo.hashCode();
      i21 = (int)(numberOfApplicants ^ numberOfApplicants >>> 32);
      if (industries == null) {
        break label612;
      }
      m = industries.hashCode();
      if (jobFunctions == null) {
        break label618;
      }
      n = jobFunctions.hashCode();
      if (description == null) {
        break label624;
      }
      i1 = description.hashCode();
      if (companyName == null) {
        break label630;
      }
      i2 = companyName.hashCode();
      if (miniCompany == null) {
        break label636;
      }
      i3 = miniCompany.hashCode();
      if (companyDescription == null) {
        break label642;
      }
      i4 = companyDescription.hashCode();
      if (experienceLevel == null) {
        break label648;
      }
      i5 = experienceLevel.hashCode();
      if (heroImage == null) {
        break label654;
      }
      i6 = heroImage.hashCode();
      if (employmentStatus == null) {
        break label660;
      }
      i7 = employmentStatus.hashCode();
      if (skillsDescription == null) {
        break label666;
      }
      i8 = skillsDescription.hashCode();
      if (jobPoster == null) {
        break label672;
      }
      i9 = jobPoster.hashCode();
      if (applicant == null) {
        break label678;
      }
      i10 = applicant.hashCode();
      if (savingInfo == null) {
        break label684;
      }
      i11 = savingInfo.hashCode();
      if (applyingInfo == null) {
        break label690;
      }
      i12 = applyingInfo.hashCode();
      if (!isLinkedInRouting) {
        break label696;
      }
      i13 = 1;
      if (!linkedInRouting) {
        break label702;
      }
      i14 = 1;
      if (companyApplyUrl == null) {
        break label708;
      }
      i15 = companyApplyUrl.hashCode();
      if (companyApplyPostUrl == null) {
        break label714;
      }
      i16 = companyApplyPostUrl.hashCode();
      if (sections == null) {
        break label720;
      }
      i17 = sections.hashCode();
      if (entityInfo == null) {
        break label726;
      }
      i18 = entityInfo.hashCode();
      i22 = (int)(numberOfViewers ^ numberOfViewers >>> 32);
      if (!closed) {
        break label732;
      }
    }
    for (;;)
    {
      if (flavors != null) {
        i20 = flavors.hashCode();
      }
      i = (((i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + ((k + (j + (i + 527) * 31) * 31) * 31 + i21) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i22) * 31 + i19) * 31 + i20;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label602:
      j = 0;
      break label48;
      label607:
      k = 0;
      break label63;
      label612:
      m = 0;
      break label96;
      label618:
      n = 0;
      break label114;
      label624:
      i1 = 0;
      break label130;
      label630:
      i2 = 0;
      break label146;
      label636:
      i3 = 0;
      break label162;
      label642:
      i4 = 0;
      break label178;
      label648:
      i5 = 0;
      break label194;
      label654:
      i6 = 0;
      break label210;
      label660:
      i7 = 0;
      break label226;
      label666:
      i8 = 0;
      break label242;
      label672:
      i9 = 0;
      break label258;
      label678:
      i10 = 0;
      break label274;
      label684:
      i11 = 0;
      break label290;
      label690:
      i12 = 0;
      break label306;
      label696:
      i13 = 0;
      break label316;
      label702:
      i14 = 0;
      break label326;
      label708:
      i15 = 0;
      break label342;
      label714:
      i16 = 0;
      break label358;
      label720:
      i17 = 0;
      break label374;
      label726:
      i18 = 0;
      break label390;
      label732:
      i19 = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Job");
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
    label373:
    label398:
    label408:
    label433:
    label443:
    label453:
    label592:
    label652:
    label678:
    label704:
    label764:
    label790:
    label816:
    label876:
    label936:
    label996:
    label1056:
    label1080:
    label1089:
    label1113:
    label1122:
    label1148:
    label1174:
    label1234:
    label1294:
    label1318:
    label1342:
    label1351:
    label1468:
    label1478:
    label1503:
    label1513:
    label1523:
    label1533:
    label1558:
    label1568:
    label1578:
    label1588:
    label1613:
    label1623:
    label1648:
    label1658:
    label1683:
    label1693:
    label1718:
    label1728:
    label1734:
    label1744:
    label1750:
    label1760:
    label1770:
    label1780:
    label1805:
    label1815:
    label1840:
    label1850:
    label1860:
    label1866:
    label1899:
    label1906:
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
        localByteBuffer.putInt(1010518203);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniJob) {
            break label398;
          }
          localByteBuffer.put((byte)1);
          if (miniJob._cachedId == null) {
            break label373;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniJob._cachedId);
          miniJob.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBasicCompanyInfo) {
            break label433;
          }
          localByteBuffer.put((byte)1);
          if (basicCompanyInfo._cachedId == null) {
            break label408;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, basicCompanyInfo._cachedId);
          basicCompanyInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasNumberOfApplicants) {
            break label443;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numberOfApplicants);
        }
        for (;;)
        {
          if (!hasIndustries) {
            break label453;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, industries.size());
          localObject = industries.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject).next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniJob.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label206;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)1);
          basicCompanyInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label266;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasJobFunctions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, jobFunctions.size());
          localObject = jobFunctions.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject).next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasDescription)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasCompanyName) {
            break label1468;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasMiniCompany) {
            break label1503;
          }
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId == null) {
            break label1478;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
          miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCompanyDescription) {
            break label1513;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyDescription);
          if (!hasExperienceLevel) {
            break label1523;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, experienceLevel);
          if (!hasHeroImage) {
            break label1558;
          }
          localByteBuffer.put((byte)1);
          if (heroImage._cachedId == null) {
            break label1533;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, heroImage._cachedId);
          heroImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEmploymentStatus) {
            break label1568;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, employmentStatus);
          if (!hasSkillsDescription) {
            break label1578;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, skillsDescription);
          if (!hasJobPoster) {
            break label1613;
          }
          localByteBuffer.put((byte)1);
          if (jobPoster._cachedId == null) {
            break label1588;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, jobPoster._cachedId);
          jobPoster.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasApplicant) {
            break label1648;
          }
          localByteBuffer.put((byte)1);
          if (applicant._cachedId == null) {
            break label1623;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, applicant._cachedId);
          applicant.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSavingInfo) {
            break label1683;
          }
          localByteBuffer.put((byte)1);
          if (savingInfo._cachedId == null) {
            break label1658;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, savingInfo._cachedId);
          savingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasApplyingInfo) {
            break label1718;
          }
          localByteBuffer.put((byte)1);
          if (applyingInfo._cachedId == null) {
            break label1693;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, applyingInfo._cachedId);
          applyingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasIsLinkedInRouting) {
            break label1734;
          }
          localByteBuffer.put((byte)1);
          if (!isLinkedInRouting) {
            break label1728;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasLinkedInRouting) {
            break label1750;
          }
          localByteBuffer.put((byte)1);
          if (!linkedInRouting) {
            break label1744;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasCompanyApplyUrl) {
            break label1760;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyApplyUrl);
          if (!hasCompanyApplyPostUrl) {
            break label1770;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyApplyPostUrl);
          if (!hasSections) {
            break label1805;
          }
          localByteBuffer.put((byte)1);
          if (sections._cachedId == null) {
            break label1780;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sections._cachedId);
          sections.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEntityInfo) {
            break label1840;
          }
          localByteBuffer.put((byte)1);
          if (entityInfo._cachedId == null) {
            break label1815;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, entityInfo._cachedId);
          entityInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasNumberOfViewers) {
            break label1850;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numberOfViewers);
          if (!hasClosed) {
            break label1866;
          }
          localByteBuffer.put((byte)1);
          if (!closed) {
            break label1860;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasFlavors) {
            break label1899;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, flavors.size());
          localObject = flavors.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label1906;
          }
          EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesFlavor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label592;
            localByteBuffer.put((byte)1);
            miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label652;
            localByteBuffer.put((byte)0);
            break label652;
            localByteBuffer.put((byte)0);
            break label678;
            localByteBuffer.put((byte)0);
            break label704;
            localByteBuffer.put((byte)1);
            heroImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label764;
            localByteBuffer.put((byte)0);
            break label764;
            localByteBuffer.put((byte)0);
            break label790;
            localByteBuffer.put((byte)0);
            break label816;
            localByteBuffer.put((byte)1);
            jobPoster.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label876;
            localByteBuffer.put((byte)0);
            break label876;
            localByteBuffer.put((byte)1);
            applicant.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label936;
            localByteBuffer.put((byte)0);
            break label936;
            localByteBuffer.put((byte)1);
            savingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label996;
            localByteBuffer.put((byte)0);
            break label996;
            localByteBuffer.put((byte)1);
            applyingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1056;
            localByteBuffer.put((byte)0);
            break label1056;
            i = 0;
            break label1080;
            localByteBuffer.put((byte)0);
            break label1089;
            i = 0;
            break label1113;
            localByteBuffer.put((byte)0);
            break label1122;
            localByteBuffer.put((byte)0);
            break label1148;
            localByteBuffer.put((byte)0);
            break label1174;
            localByteBuffer.put((byte)1);
            sections.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1234;
            localByteBuffer.put((byte)0);
            break label1234;
            localByteBuffer.put((byte)1);
            entityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1294;
            localByteBuffer.put((byte)0);
            break label1294;
            localByteBuffer.put((byte)0);
            break label1318;
            i = 0;
            break label1342;
            localByteBuffer.put((byte)0);
            break label1351;
          }
          localByteBuffer.put((byte)1);
          localEntitiesFlavor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.Job
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */