package com.linkedin.android.pegasus.gen.voyager.jobs;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobSavingInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JobDetails
  implements FissileDataModel<JobDetails>, RecordTemplate<JobDetails>
{
  public static final JobDetailsBuilder BUILDER = JobDetailsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ApplyMethod applyMethod;
  public final JobApplyingInfo applyingInfo;
  public final long closedAt;
  public final CompanyDetails companyDetails;
  public final AttributedText description;
  public final Urn entityUrn;
  public final String formattedEmploymentStatus;
  public final String formattedExperienceLevel;
  public final List<String> formattedIndustries;
  public final List<String> formattedJobFunctions;
  public final String formattedLocation;
  public final boolean hasApplyMethod;
  public final boolean hasApplyingInfo;
  public final boolean hasClosedAt;
  public final boolean hasCompanyDetails;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasFormattedEmploymentStatus;
  public final boolean hasFormattedExperienceLevel;
  public final boolean hasFormattedIndustries;
  public final boolean hasFormattedJobFunctions;
  public final boolean hasFormattedLocation;
  public final boolean hasJobState;
  public final boolean hasListedAt;
  public final boolean hasSavingInfo;
  public final boolean hasSkillsDescription;
  public final boolean hasTitle;
  public final boolean hasViews;
  public final JobState jobState;
  public final long listedAt;
  public final JobSavingInfo savingInfo;
  public final AttributedText skillsDescription;
  public final String title;
  public final long views;
  
  JobDetails(Urn paramUrn, String paramString1, String paramString2, String paramString3, String paramString4, JobState paramJobState, long paramLong1, long paramLong2, CompanyDetails paramCompanyDetails, AttributedText paramAttributedText1, AttributedText paramAttributedText2, JobSavingInfo paramJobSavingInfo, JobApplyingInfo paramJobApplyingInfo, ApplyMethod paramApplyMethod, long paramLong3, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17)
  {
    entityUrn = paramUrn;
    title = paramString1;
    formattedEmploymentStatus = paramString2;
    formattedExperienceLevel = paramString3;
    formattedLocation = paramString4;
    jobState = paramJobState;
    listedAt = paramLong1;
    closedAt = paramLong2;
    companyDetails = paramCompanyDetails;
    description = paramAttributedText1;
    skillsDescription = paramAttributedText2;
    savingInfo = paramJobSavingInfo;
    applyingInfo = paramJobApplyingInfo;
    applyMethod = paramApplyMethod;
    views = paramLong3;
    if (paramList1 == null)
    {
      paramString1 = null;
      formattedIndustries = paramString1;
      if (paramList2 != null) {
        break label249;
      }
    }
    label249:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList2))
    {
      formattedJobFunctions = paramString1;
      hasEntityUrn = paramBoolean1;
      hasTitle = paramBoolean2;
      hasFormattedEmploymentStatus = paramBoolean3;
      hasFormattedExperienceLevel = paramBoolean4;
      hasFormattedLocation = paramBoolean5;
      hasJobState = paramBoolean6;
      hasListedAt = paramBoolean7;
      hasClosedAt = paramBoolean8;
      hasCompanyDetails = paramBoolean9;
      hasDescription = paramBoolean10;
      hasSkillsDescription = paramBoolean11;
      hasSavingInfo = paramBoolean12;
      hasApplyingInfo = paramBoolean13;
      hasApplyMethod = paramBoolean14;
      hasViews = paramBoolean15;
      hasFormattedIndustries = paramBoolean16;
      hasFormattedJobFunctions = paramBoolean17;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramString1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  private JobDetails accept(DataProcessor paramDataProcessor)
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
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasFormattedEmploymentStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("formattedEmploymentStatus");
      paramDataProcessor.processString(formattedEmploymentStatus);
    }
    if (hasFormattedExperienceLevel)
    {
      paramDataProcessor.startRecordField$505cff1c("formattedExperienceLevel");
      paramDataProcessor.processString(formattedExperienceLevel);
    }
    if (hasFormattedLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("formattedLocation");
      paramDataProcessor.processString(formattedLocation);
    }
    if (hasJobState)
    {
      paramDataProcessor.startRecordField$505cff1c("jobState");
      paramDataProcessor.processEnum(jobState);
    }
    if (hasListedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("listedAt");
      paramDataProcessor.processLong(listedAt);
    }
    if (hasClosedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("closedAt");
      paramDataProcessor.processLong(closedAt);
    }
    Object localObject3 = null;
    boolean bool1 = false;
    label264:
    Object localObject4;
    boolean bool2;
    label304:
    label316:
    Object localObject5;
    boolean bool3;
    label356:
    label368:
    Object localObject6;
    boolean bool4;
    label408:
    label420:
    Object localObject7;
    boolean bool5;
    label460:
    label472:
    boolean bool6;
    if (hasCompanyDetails)
    {
      paramDataProcessor.startRecordField$505cff1c("companyDetails");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = companyDetails.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label701;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject4 = null;
      bool2 = false;
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label710;
        }
        localObject1 = description.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label728;
        }
        bool2 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool3 = false;
      if (hasSkillsDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("skillsDescription");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label738;
        }
        localObject1 = skillsDescription.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label756;
        }
        bool3 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool4 = false;
      if (hasSavingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("savingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label766;
        }
        localObject1 = savingInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label784;
        }
        bool4 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool5 = false;
      if (hasApplyingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("applyingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label794;
        }
        localObject1 = applyingInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label812;
        }
        bool5 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool6 = false;
      if (hasApplyMethod)
      {
        paramDataProcessor.startRecordField$505cff1c("applyMethod");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label822;
        }
        localObject1 = applyMethod.accept(paramDataProcessor);
        label512:
        if (localObject1 == null) {
          break label840;
        }
        bool6 = true;
      }
    }
    Object localObject2;
    int i;
    Object localObject9;
    for (Object localObject8 = localObject1;; localObject8 = localObject1)
    {
      if (hasViews)
      {
        paramDataProcessor.startRecordField$505cff1c("views");
        paramDataProcessor.processLong(views);
      }
      localObject1 = null;
      localObject2 = null;
      bool7 = false;
      if (!hasFormattedIndustries) {
        break label864;
      }
      paramDataProcessor.startRecordField$505cff1c("formattedIndustries");
      formattedIndustries.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = formattedIndustries.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject9 = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject9);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject9);
        }
        i += 1;
      }
      localObject1 = (CompanyDetails)paramDataProcessor.processDataTemplate(companyDetails);
      break;
      label701:
      bool1 = false;
      localObject3 = localObject1;
      break label264;
      label710:
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(description);
      break label304;
      label728:
      bool2 = false;
      localObject4 = localObject1;
      break label316;
      label738:
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(skillsDescription);
      break label356;
      label756:
      bool3 = false;
      localObject5 = localObject1;
      break label368;
      label766:
      localObject1 = (JobSavingInfo)paramDataProcessor.processDataTemplate(savingInfo);
      break label408;
      label784:
      bool4 = false;
      localObject6 = localObject1;
      break label420;
      label794:
      localObject1 = (JobApplyingInfo)paramDataProcessor.processDataTemplate(applyingInfo);
      break label460;
      label812:
      bool5 = false;
      localObject7 = localObject1;
      break label472;
      label822:
      localObject1 = (ApplyMethod)paramDataProcessor.processDataTemplate(applyMethod);
      break label512;
      label840:
      bool6 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool7 = true;; bool7 = false)
    {
      label864:
      localObject2 = null;
      localObject9 = null;
      bool8 = false;
      if (!hasFormattedJobFunctions) {
        break label1019;
      }
      paramDataProcessor.startRecordField$505cff1c("formattedJobFunctions");
      formattedJobFunctions.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject9;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject9 = formattedJobFunctions.iterator();
      while (((Iterator)localObject9).hasNext())
      {
        String str = (String)((Iterator)localObject9).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject2 != null) {
          ((List)localObject2).add(str);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool8 = true;; bool8 = false)
    {
      label1019:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1508;
      }
      if (!hasFormattedIndustries) {
        localObject1 = Collections.emptyList();
      }
      if (!hasFormattedJobFunctions) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "title");
    }
    if (!hasFormattedEmploymentStatus) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "formattedEmploymentStatus");
    }
    if (!hasFormattedExperienceLevel) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "formattedExperienceLevel");
    }
    if (!hasJobState) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "jobState");
    }
    if (!hasListedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "listedAt");
    }
    if (!hasCompanyDetails) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "companyDetails");
    }
    if (!hasDescription) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "description");
    }
    if (!hasSavingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "savingInfo");
    }
    if (!hasApplyingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "applyingInfo");
    }
    if (!hasApplyMethod) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "applyMethod");
    }
    if (formattedIndustries != null)
    {
      paramDataProcessor = formattedIndustries.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "formattedIndustries");
        }
      }
    }
    if (formattedJobFunctions != null)
    {
      paramDataProcessor = formattedJobFunctions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails", "formattedJobFunctions");
        }
      }
    }
    return new JobDetails(entityUrn, title, formattedEmploymentStatus, formattedExperienceLevel, formattedLocation, jobState, listedAt, closedAt, (CompanyDetails)localObject3, (AttributedText)localObject4, (AttributedText)localObject5, (JobSavingInfo)localObject6, (JobApplyingInfo)localObject7, (ApplyMethod)localObject8, views, (List)localObject1, (List)localObject2, hasEntityUrn, hasTitle, hasFormattedEmploymentStatus, hasFormattedExperienceLevel, hasFormattedLocation, hasJobState, hasListedAt, hasClosedAt, bool1, bool2, bool3, bool4, bool5, bool6, hasViews, bool7, bool8);
    label1508:
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
      paramObject = (JobDetails)paramObject;
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
      if (formattedEmploymentStatus != null)
      {
        if (formattedEmploymentStatus.equals(formattedEmploymentStatus)) {}
      }
      else {
        while (formattedEmploymentStatus != null) {
          return false;
        }
      }
      if (formattedExperienceLevel != null)
      {
        if (formattedExperienceLevel.equals(formattedExperienceLevel)) {}
      }
      else {
        while (formattedExperienceLevel != null) {
          return false;
        }
      }
      if (formattedLocation != null)
      {
        if (formattedLocation.equals(formattedLocation)) {}
      }
      else {
        while (formattedLocation != null) {
          return false;
        }
      }
      if (jobState != null)
      {
        if (jobState.equals(jobState)) {}
      }
      else {
        while (jobState != null) {
          return false;
        }
      }
      if (listedAt != listedAt) {
        return false;
      }
      if (closedAt != closedAt) {
        return false;
      }
      if (companyDetails != null)
      {
        if (companyDetails.equals(companyDetails)) {}
      }
      else {
        while (companyDetails != null) {
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
      if (skillsDescription != null)
      {
        if (skillsDescription.equals(skillsDescription)) {}
      }
      else {
        while (skillsDescription != null) {
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
      if (applyMethod != null)
      {
        if (applyMethod.equals(applyMethod)) {}
      }
      else {
        while (applyMethod != null) {
          return false;
        }
      }
      if (views != views) {
        return false;
      }
      if (formattedIndustries != null)
      {
        if (formattedIndustries.equals(formattedIndustries)) {}
      }
      else {
        while (formattedIndustries != null) {
          return false;
        }
      }
      if (formattedJobFunctions == null) {
        break;
      }
    } while (formattedJobFunctions.equals(formattedJobFunctions));
    for (;;)
    {
      return false;
      if (formattedJobFunctions == null) {
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
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasFormattedEmploymentStatus) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(formattedEmploymentStatus);
    }
    j = i + 1;
    i = j;
    if (hasFormattedExperienceLevel) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(formattedExperienceLevel);
    }
    j = i + 1;
    i = j;
    if (hasFormattedLocation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(formattedLocation);
    }
    j = i + 1;
    i = j;
    if (hasJobState) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasListedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasClosedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasCompanyDetails)
    {
      i = j + 1;
      if (companyDetails._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(companyDetails._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasDescription)
      {
        i = j + 1;
        if (description._cachedId == null) {
          break label539;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(description._cachedId);
      }
      label282:
      j = i + 1;
      i = j;
      if (hasSkillsDescription)
      {
        i = j + 1;
        if (skillsDescription._cachedId == null) {
          break label552;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(skillsDescription._cachedId);
      }
      label324:
      j = i + 1;
      i = j;
      if (hasSavingInfo)
      {
        i = j + 1;
        if (savingInfo._cachedId == null) {
          break label565;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(savingInfo._cachedId);
      }
      label366:
      j = i + 1;
      i = j;
      if (hasApplyingInfo)
      {
        i = j + 1;
        if (applyingInfo._cachedId == null) {
          break label578;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(applyingInfo._cachedId);
      }
      label408:
      j = i + 1;
      i = j;
      if (hasApplyMethod)
      {
        i = j + 1;
        if (applyMethod._cachedId == null) {
          break label591;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(applyMethod._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasViews) {
        i = j + 8;
      }
      i += 1;
      j = i;
      if (!hasFormattedIndustries) {
        break label604;
      }
      i += 2;
      localObject = formattedIndustries.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject).next());
      }
      i += companyDetails.getSerializedSize();
      break;
      label539:
      i += description.getSerializedSize();
      break label282;
      label552:
      i += skillsDescription.getSerializedSize();
      break label324;
      label565:
      i += savingInfo.getSerializedSize();
      break label366;
      label578:
      i += applyingInfo.getSerializedSize();
      break label408;
      label591:
      i += applyMethod.getSerializedSize();
    }
    label604:
    i = j + 1;
    j = i;
    if (hasFormattedJobFunctions)
    {
      i += 2;
      localObject = formattedJobFunctions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)((Iterator)localObject).next());
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int i9 = 0;
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
    int i10;
    int i11;
    int i2;
    label154:
    int i3;
    label170:
    int i4;
    label186:
    int i5;
    label202:
    int i6;
    label218:
    int i7;
    label234:
    int i12;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (title == null) {
        break label397;
      }
      j = title.hashCode();
      if (formattedEmploymentStatus == null) {
        break label402;
      }
      k = formattedEmploymentStatus.hashCode();
      if (formattedExperienceLevel == null) {
        break label407;
      }
      m = formattedExperienceLevel.hashCode();
      if (formattedLocation == null) {
        break label413;
      }
      n = formattedLocation.hashCode();
      if (jobState == null) {
        break label419;
      }
      i1 = jobState.hashCode();
      i10 = (int)(listedAt ^ listedAt >>> 32);
      i11 = (int)(closedAt ^ closedAt >>> 32);
      if (companyDetails == null) {
        break label425;
      }
      i2 = companyDetails.hashCode();
      if (description == null) {
        break label431;
      }
      i3 = description.hashCode();
      if (skillsDescription == null) {
        break label437;
      }
      i4 = skillsDescription.hashCode();
      if (savingInfo == null) {
        break label443;
      }
      i5 = savingInfo.hashCode();
      if (applyingInfo == null) {
        break label449;
      }
      i6 = applyingInfo.hashCode();
      if (applyMethod == null) {
        break label455;
      }
      i7 = applyMethod.hashCode();
      i12 = (int)(views ^ views >>> 32);
      if (formattedIndustries == null) {
        break label461;
      }
    }
    label397:
    label402:
    label407:
    label413:
    label419:
    label425:
    label431:
    label437:
    label443:
    label449:
    label455:
    label461:
    for (int i8 = formattedIndustries.hashCode();; i8 = 0)
    {
      if (formattedJobFunctions != null) {
        i9 = formattedJobFunctions.hashCode();
      }
      i = (i8 + ((i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (((i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i10) * 31 + i11) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i12) * 31) * 31 + i9;
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
      break label154;
      i3 = 0;
      break label170;
      i4 = 0;
      break label186;
      i5 = 0;
      break label202;
      i6 = 0;
      break label218;
      i7 = 0;
      break label234;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JobDetails");
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
    label172:
    label198:
    label224:
    label250:
    label279:
    label303:
    label327:
    label387:
    label447:
    label507:
    label567:
    label627:
    label687:
    label794:
    label804:
    label814:
    label824:
    label834:
    label844:
    label854:
    label864:
    label889:
    label899:
    label924:
    label934:
    label959:
    label969:
    label994:
    label1004:
    label1029:
    label1039:
    label1064:
    label1074:
    label1084:
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
        localByteBuffer.putInt(30344711);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label794;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasFormattedEmploymentStatus) {
            break label804;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, formattedEmploymentStatus);
          if (!hasFormattedExperienceLevel) {
            break label814;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, formattedExperienceLevel);
          if (!hasFormattedLocation) {
            break label824;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, formattedLocation);
          if (!hasJobState) {
            break label834;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, jobState.ordinal());
          if (!hasListedAt) {
            break label844;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(listedAt);
          if (!hasClosedAt) {
            break label854;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(closedAt);
          if (!hasCompanyDetails) {
            break label889;
          }
          localByteBuffer.put((byte)1);
          if (companyDetails._cachedId == null) {
            break label864;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, companyDetails._cachedId);
          companyDetails.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label924;
          }
          localByteBuffer.put((byte)1);
          if (description._cachedId == null) {
            break label899;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, description._cachedId);
          description.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSkillsDescription) {
            break label959;
          }
          localByteBuffer.put((byte)1);
          if (skillsDescription._cachedId == null) {
            break label934;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, skillsDescription._cachedId);
          skillsDescription.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSavingInfo) {
            break label994;
          }
          localByteBuffer.put((byte)1);
          if (savingInfo._cachedId == null) {
            break label969;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, savingInfo._cachedId);
          savingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasApplyingInfo) {
            break label1029;
          }
          localByteBuffer.put((byte)1);
          if (applyingInfo._cachedId == null) {
            break label1004;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, applyingInfo._cachedId);
          applyingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasApplyMethod) {
            break label1064;
          }
          localByteBuffer.put((byte)1);
          if (applyMethod._cachedId == null) {
            break label1039;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, applyMethod._cachedId);
          applyMethod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasViews) {
            break label1074;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(views);
        }
        for (;;)
        {
          if (!hasFormattedIndustries) {
            break label1084;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, formattedIndustries.size());
          localObject = formattedIndustries.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject).next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label172;
          localByteBuffer.put((byte)0);
          break label198;
          localByteBuffer.put((byte)0);
          break label224;
          localByteBuffer.put((byte)0);
          break label250;
          localByteBuffer.put((byte)0);
          break label279;
          localByteBuffer.put((byte)0);
          break label303;
          localByteBuffer.put((byte)0);
          break label327;
          localByteBuffer.put((byte)1);
          companyDetails.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label387;
          localByteBuffer.put((byte)0);
          break label387;
          localByteBuffer.put((byte)1);
          description.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label447;
          localByteBuffer.put((byte)0);
          break label447;
          localByteBuffer.put((byte)1);
          skillsDescription.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label507;
          localByteBuffer.put((byte)0);
          break label507;
          localByteBuffer.put((byte)1);
          savingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label567;
          localByteBuffer.put((byte)0);
          break label567;
          localByteBuffer.put((byte)1);
          applyingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label627;
          localByteBuffer.put((byte)0);
          break label627;
          localByteBuffer.put((byte)1);
          applyMethod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label687;
          localByteBuffer.put((byte)0);
          break label687;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasFormattedJobFunctions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, formattedJobFunctions.size());
          localObject = formattedJobFunctions.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)((Iterator)localObject).next());
          }
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
  
  public static final class ApplyMethod
    implements FissileDataModel<ApplyMethod>, UnionTemplate<ApplyMethod>
  {
    public static final JobDetailsBuilder.ApplyMethodBuilder BUILDER = JobDetailsBuilder.ApplyMethodBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasOffsiteApplyValue;
    public final boolean hasSimpleOnsiteApplyValue;
    public final OffsiteApply offsiteApplyValue;
    public final SimpleOnsiteApply simpleOnsiteApplyValue;
    
    ApplyMethod(OffsiteApply paramOffsiteApply, SimpleOnsiteApply paramSimpleOnsiteApply, boolean paramBoolean1, boolean paramBoolean2)
    {
      offsiteApplyValue = paramOffsiteApply;
      simpleOnsiteApplyValue = paramSimpleOnsiteApply;
      hasOffsiteApplyValue = paramBoolean1;
      hasSimpleOnsiteApplyValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final ApplyMethod accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasOffsiteApplyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.jobs.OffsiteApply");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = offsiteApplyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label145;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label56:
        localObject1 = null;
        bool2 = false;
        if (hasSimpleOnsiteApplyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.jobs.SimpleOnsiteApply");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label154;
          }
          localObject1 = SimpleOnsiteApply.accept(paramDataProcessor);
          label91:
          if (localObject1 == null) {
            break label172;
          }
        }
      }
      label145:
      label154:
      label172:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label177;
        }
        return new ApplyMethod((OffsiteApply)localObject2, (SimpleOnsiteApply)localObject1, bool1, bool2);
        localObject1 = (OffsiteApply)paramDataProcessor.processDataTemplate(offsiteApplyValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (SimpleOnsiteApply)paramDataProcessor.processDataTemplate(simpleOnsiteApplyValue);
        break label91;
      }
      label177:
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
        paramObject = (ApplyMethod)paramObject;
        if (offsiteApplyValue != null)
        {
          if (offsiteApplyValue.equals(offsiteApplyValue)) {}
        }
        else {
          while (offsiteApplyValue != null) {
            return false;
          }
        }
        if (simpleOnsiteApplyValue == null) {
          break;
        }
      } while (simpleOnsiteApplyValue.equals(simpleOnsiteApplyValue));
      for (;;)
      {
        return false;
        if (simpleOnsiteApplyValue == null) {
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
      if (hasOffsiteApplyValue)
      {
        if (offsiteApplyValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(offsiteApplyValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasSimpleOnsiteApplyValue)
        {
          i = j + 1;
          if (simpleOnsiteApplyValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(simpleOnsiteApplyValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = offsiteApplyValue.getSerializedSize() + 7;
        break;
        label114:
        i += simpleOnsiteApplyValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (offsiteApplyValue != null) {}
      for (int i = offsiteApplyValue.hashCode();; i = 0)
      {
        if (simpleOnsiteApplyValue != null) {
          j = simpleOnsiteApplyValue.hashCode();
        }
        i = (i + 527) * 31 + j;
        _cachedHashCode = i;
        return i;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ApplyMethod");
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
      label298:
      label323:
      label331:
      label333:
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
          localByteBuffer.putInt(1225190631);
          if (hasOffsiteApplyValue)
          {
            localByteBuffer.put((byte)1);
            if (offsiteApplyValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, offsiteApplyValue._cachedId);
              offsiteApplyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSimpleOnsiteApplyValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (simpleOnsiteApplyValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, simpleOnsiteApplyValue._cachedId);
              simpleOnsiteApplyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label331;
            }
            if (str != null) {
              break label333;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            offsiteApplyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            simpleOnsiteApplyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class CompanyDetails
    implements FissileDataModel<CompanyDetails>, UnionTemplate<CompanyDetails>
  {
    public static final JobDetailsBuilder.CompanyDetailsBuilder BUILDER = JobDetailsBuilder.CompanyDetailsBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasJobPostingCompanyNameValue;
    public final boolean hasJobPostingCompanyValue;
    public final JobPostingCompanyName jobPostingCompanyNameValue;
    public final JobPostingCompany jobPostingCompanyValue;
    
    CompanyDetails(JobPostingCompanyName paramJobPostingCompanyName, JobPostingCompany paramJobPostingCompany, boolean paramBoolean1, boolean paramBoolean2)
    {
      jobPostingCompanyNameValue = paramJobPostingCompanyName;
      jobPostingCompanyValue = paramJobPostingCompany;
      hasJobPostingCompanyNameValue = paramBoolean1;
      hasJobPostingCompanyValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final CompanyDetails accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasJobPostingCompanyNameValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.jobs.JobPostingCompanyName");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = jobPostingCompanyNameValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label56:
        localObject1 = null;
        bool2 = false;
        if (hasJobPostingCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.jobs.JobPostingCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = jobPostingCompanyValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new CompanyDetails((JobPostingCompanyName)localObject2, (JobPostingCompany)localObject1, bool1, bool2);
        localObject1 = (JobPostingCompanyName)paramDataProcessor.processDataTemplate(jobPostingCompanyNameValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (JobPostingCompany)paramDataProcessor.processDataTemplate(jobPostingCompanyValue);
        break label95;
      }
      label181:
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
        if (jobPostingCompanyNameValue != null)
        {
          if (jobPostingCompanyNameValue.equals(jobPostingCompanyNameValue)) {}
        }
        else {
          while (jobPostingCompanyNameValue != null) {
            return false;
          }
        }
        if (jobPostingCompanyValue == null) {
          break;
        }
      } while (jobPostingCompanyValue.equals(jobPostingCompanyValue));
      for (;;)
      {
        return false;
        if (jobPostingCompanyValue == null) {
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
      if (hasJobPostingCompanyNameValue)
      {
        if (jobPostingCompanyNameValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(jobPostingCompanyNameValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasJobPostingCompanyValue)
        {
          i = j + 1;
          if (jobPostingCompanyValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobPostingCompanyValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = jobPostingCompanyNameValue.getSerializedSize() + 7;
        break;
        label114:
        i += jobPostingCompanyValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (jobPostingCompanyNameValue != null) {}
      for (int i = jobPostingCompanyNameValue.hashCode();; i = 0)
      {
        if (jobPostingCompanyValue != null) {
          j = jobPostingCompanyValue.hashCode();
        }
        i = (i + 527) * 31 + j;
        _cachedHashCode = i;
        return i;
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
      label298:
      label323:
      label331:
      label333:
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
          localByteBuffer.putInt(-802615071);
          if (hasJobPostingCompanyNameValue)
          {
            localByteBuffer.put((byte)1);
            if (jobPostingCompanyNameValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, jobPostingCompanyNameValue._cachedId);
              jobPostingCompanyNameValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasJobPostingCompanyValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (jobPostingCompanyValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, jobPostingCompanyValue._cachedId);
              jobPostingCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label331;
            }
            if (str != null) {
              break label333;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            jobPostingCompanyNameValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            jobPostingCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */