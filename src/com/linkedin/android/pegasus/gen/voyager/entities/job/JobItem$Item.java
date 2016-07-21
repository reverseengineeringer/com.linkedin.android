package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.InflowCompanyRankingInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRankingInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillsAnalytics;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobItem$Item
  implements FissileDataModel<Item>, UnionTemplate<Item>
{
  public static final JobItemBuilder.ItemBuilder BUILDER = JobItemBuilder.ItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ApplicantRanking applicantRankingValue;
  public final BasicCompanyInfo basicCompanyInfoValue;
  public final CompanyGrowthInsights companyGrowthInsightsValue;
  public final Description descriptionValue;
  public final EducationAnalytics educationAnalyticsValue;
  public final GroupedJobItem groupedJobItemValue;
  public final boolean hasApplicantRankingValue;
  public final boolean hasBasicCompanyInfoValue;
  public final boolean hasCompanyGrowthInsightsValue;
  public final boolean hasDescriptionValue;
  public final boolean hasEducationAnalyticsValue;
  public final boolean hasGroupedJobItemValue;
  public final boolean hasInCommonCompanyValue;
  public final boolean hasInCommonPersonValue;
  public final boolean hasInCommonSchoolValue;
  public final boolean hasInflowCompanyRankingInsightsValue;
  public final boolean hasJobCardValue;
  public final boolean hasJobDescriptionValue;
  public final boolean hasJobDetailsValue;
  public final boolean hasJobPosterValue;
  public final boolean hasMiniProfilesCollectionValue;
  public final boolean hasNextJobCollectionValue;
  public final boolean hasSchoolRankingInsightsValue;
  public final boolean hasSeniorityAnalyticsValue;
  public final boolean hasSimilarJobTitlesEmployeesValue;
  public final boolean hasSkillsAndExperienceValue;
  public final boolean hasTopSkillsAnalyticsValue;
  public final InCommonCompany inCommonCompanyValue;
  public final InCommonPerson inCommonPersonValue;
  public final InCommonSchool inCommonSchoolValue;
  public final InflowCompanyRankingInsights inflowCompanyRankingInsightsValue;
  public final JobCard jobCardValue;
  public final JobDescription jobDescriptionValue;
  public final JobDetails jobDetailsValue;
  public final JobPoster jobPosterValue;
  public final MiniProfilesCollection miniProfilesCollectionValue;
  public final NextJobCollection nextJobCollectionValue;
  public final SchoolRankingInsights schoolRankingInsightsValue;
  public final SeniorityAnalytics seniorityAnalyticsValue;
  public final SimilarJobTitlesEmployees similarJobTitlesEmployeesValue;
  public final SkillsAndExperience skillsAndExperienceValue;
  public final TopSkillsAnalytics topSkillsAnalyticsValue;
  
  JobItem$Item(GroupedJobItem paramGroupedJobItem, JobDescription paramJobDescription, JobDetails paramJobDetails, NextJobCollection paramNextJobCollection, SimilarJobTitlesEmployees paramSimilarJobTitlesEmployees, SkillsAndExperience paramSkillsAndExperience, Description paramDescription, MiniProfilesCollection paramMiniProfilesCollection, BasicCompanyInfo paramBasicCompanyInfo, InCommonCompany paramInCommonCompany, InCommonPerson paramInCommonPerson, InCommonSchool paramInCommonSchool, JobPoster paramJobPoster, ApplicantRanking paramApplicantRanking, CompanyGrowthInsights paramCompanyGrowthInsights, EducationAnalytics paramEducationAnalytics, InflowCompanyRankingInsights paramInflowCompanyRankingInsights, SchoolRankingInsights paramSchoolRankingInsights, SeniorityAnalytics paramSeniorityAnalytics, TopSkillsAnalytics paramTopSkillsAnalytics, JobCard paramJobCard, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21)
  {
    groupedJobItemValue = paramGroupedJobItem;
    jobDescriptionValue = paramJobDescription;
    jobDetailsValue = paramJobDetails;
    nextJobCollectionValue = paramNextJobCollection;
    similarJobTitlesEmployeesValue = paramSimilarJobTitlesEmployees;
    skillsAndExperienceValue = paramSkillsAndExperience;
    descriptionValue = paramDescription;
    miniProfilesCollectionValue = paramMiniProfilesCollection;
    basicCompanyInfoValue = paramBasicCompanyInfo;
    inCommonCompanyValue = paramInCommonCompany;
    inCommonPersonValue = paramInCommonPerson;
    inCommonSchoolValue = paramInCommonSchool;
    jobPosterValue = paramJobPoster;
    applicantRankingValue = paramApplicantRanking;
    companyGrowthInsightsValue = paramCompanyGrowthInsights;
    educationAnalyticsValue = paramEducationAnalytics;
    inflowCompanyRankingInsightsValue = paramInflowCompanyRankingInsights;
    schoolRankingInsightsValue = paramSchoolRankingInsights;
    seniorityAnalyticsValue = paramSeniorityAnalytics;
    topSkillsAnalyticsValue = paramTopSkillsAnalytics;
    jobCardValue = paramJobCard;
    hasGroupedJobItemValue = paramBoolean1;
    hasJobDescriptionValue = paramBoolean2;
    hasJobDetailsValue = paramBoolean3;
    hasNextJobCollectionValue = paramBoolean4;
    hasSimilarJobTitlesEmployeesValue = paramBoolean5;
    hasSkillsAndExperienceValue = paramBoolean6;
    hasDescriptionValue = paramBoolean7;
    hasMiniProfilesCollectionValue = paramBoolean8;
    hasBasicCompanyInfoValue = paramBoolean9;
    hasInCommonCompanyValue = paramBoolean10;
    hasInCommonPersonValue = paramBoolean11;
    hasInCommonSchoolValue = paramBoolean12;
    hasJobPosterValue = paramBoolean13;
    hasApplicantRankingValue = paramBoolean14;
    hasCompanyGrowthInsightsValue = paramBoolean15;
    hasEducationAnalyticsValue = paramBoolean16;
    hasInflowCompanyRankingInsightsValue = paramBoolean17;
    hasSchoolRankingInsightsValue = paramBoolean18;
    hasSeniorityAnalyticsValue = paramBoolean19;
    hasTopSkillsAnalyticsValue = paramBoolean20;
    hasJobCardValue = paramBoolean21;
    _cachedId = null;
  }
  
  public final Item accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    label198:
    label210:
    Object localObject6;
    boolean bool5;
    label250:
    label262:
    Object localObject7;
    boolean bool6;
    label302:
    label314:
    Object localObject8;
    boolean bool7;
    label354:
    label366:
    Object localObject9;
    boolean bool8;
    label406:
    label418:
    Object localObject10;
    boolean bool9;
    label459:
    label471:
    Object localObject11;
    boolean bool10;
    label512:
    label524:
    Object localObject12;
    boolean bool11;
    label565:
    label577:
    Object localObject13;
    boolean bool12;
    label618:
    label630:
    Object localObject14;
    boolean bool13;
    label671:
    label683:
    Object localObject15;
    boolean bool14;
    label724:
    label736:
    Object localObject16;
    boolean bool15;
    label777:
    label789:
    Object localObject17;
    boolean bool16;
    label830:
    label842:
    Object localObject18;
    boolean bool17;
    label883:
    label895:
    Object localObject19;
    boolean bool18;
    label936:
    label948:
    Object localObject20;
    boolean bool19;
    label989:
    label1001:
    Object localObject21;
    boolean bool20;
    if (hasGroupedJobItemValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.GroupedJobItem");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = groupedJobItemValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1226;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasJobDescriptionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.JobDescription");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1235;
        }
        localObject1 = jobDescriptionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1253;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasJobDetailsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.JobDetails");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1262;
        }
        localObject1 = jobDetailsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1280;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasNextJobCollectionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.NextJobCollection");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1290;
        }
        localObject1 = nextJobCollectionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1308;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasSimilarJobTitlesEmployeesValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.SimilarJobTitlesEmployees");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1318;
        }
        localObject1 = similarJobTitlesEmployeesValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1336;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasSkillsAndExperienceValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.SkillsAndExperience");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1346;
        }
        localObject1 = skillsAndExperienceValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1364;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasDescriptionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.Description");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1374;
        }
        localObject1 = descriptionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1392;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      localObject9 = null;
      bool8 = false;
      if (hasMiniProfilesCollectionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.MiniProfilesCollection");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1402;
        }
        localObject1 = miniProfilesCollectionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1420;
        }
        bool8 = true;
        localObject9 = localObject1;
      }
      localObject10 = null;
      bool9 = false;
      if (hasBasicCompanyInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.BasicCompanyInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1430;
        }
        localObject1 = basicCompanyInfoValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1448;
        }
        bool9 = true;
        localObject10 = localObject1;
      }
      localObject11 = null;
      bool10 = false;
      if (hasInCommonCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.incommon.InCommonCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1458;
        }
        localObject1 = inCommonCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1476;
        }
        bool10 = true;
        localObject11 = localObject1;
      }
      localObject12 = null;
      bool11 = false;
      if (hasInCommonPersonValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.incommon.InCommonPerson");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1486;
        }
        localObject1 = inCommonPersonValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1504;
        }
        bool11 = true;
        localObject12 = localObject1;
      }
      localObject13 = null;
      bool12 = false;
      if (hasInCommonSchoolValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.incommon.InCommonSchool");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1514;
        }
        localObject1 = inCommonSchoolValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1532;
        }
        bool12 = true;
        localObject13 = localObject1;
      }
      localObject14 = null;
      bool13 = false;
      if (hasJobPosterValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.JobPoster");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1542;
        }
        localObject1 = jobPosterValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1560;
        }
        bool13 = true;
        localObject14 = localObject1;
      }
      localObject15 = null;
      bool14 = false;
      if (hasApplicantRankingValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.ApplicantRanking");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1570;
        }
        localObject1 = applicantRankingValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1588;
        }
        bool14 = true;
        localObject15 = localObject1;
      }
      localObject16 = null;
      bool15 = false;
      if (hasCompanyGrowthInsightsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.CompanyGrowthInsights");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1598;
        }
        localObject1 = companyGrowthInsightsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1616;
        }
        bool15 = true;
        localObject16 = localObject1;
      }
      localObject17 = null;
      bool16 = false;
      if (hasEducationAnalyticsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.EducationAnalytics");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1626;
        }
        localObject1 = educationAnalyticsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1644;
        }
        bool16 = true;
        localObject17 = localObject1;
      }
      localObject18 = null;
      bool17 = false;
      if (hasInflowCompanyRankingInsightsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.InflowCompanyRankingInsights");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1654;
        }
        localObject1 = inflowCompanyRankingInsightsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1672;
        }
        bool17 = true;
        localObject18 = localObject1;
      }
      localObject19 = null;
      bool18 = false;
      if (hasSchoolRankingInsightsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.SchoolRankingInsights");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1682;
        }
        localObject1 = schoolRankingInsightsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1700;
        }
        bool18 = true;
        localObject19 = localObject1;
      }
      localObject20 = null;
      bool19 = false;
      if (hasSeniorityAnalyticsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.SeniorityAnalytics");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1710;
        }
        localObject1 = seniorityAnalyticsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1728;
        }
        bool19 = true;
        localObject20 = localObject1;
      }
      localObject21 = null;
      bool20 = false;
      if (hasTopSkillsAnalyticsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.job.analytics.TopSkillsAnalytics");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1738;
        }
        localObject1 = topSkillsAnalyticsValue.accept(paramDataProcessor);
        label1042:
        if (localObject1 == null) {
          break label1756;
        }
        bool20 = true;
        localObject21 = localObject1;
      }
      label1054:
      localObject1 = null;
      bool21 = false;
      if (hasJobCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.premium.onboarding.JobCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1766;
        }
        localObject1 = jobCardValue.accept(paramDataProcessor);
        label1095:
        if (localObject1 == null) {
          break label1784;
        }
      }
    }
    label1226:
    label1235:
    label1253:
    label1262:
    label1280:
    label1290:
    label1308:
    label1318:
    label1336:
    label1346:
    label1364:
    label1374:
    label1392:
    label1402:
    label1420:
    label1430:
    label1448:
    label1458:
    label1476:
    label1486:
    label1504:
    label1514:
    label1532:
    label1542:
    label1560:
    label1570:
    label1588:
    label1598:
    label1616:
    label1626:
    label1644:
    label1654:
    label1672:
    label1682:
    label1700:
    label1710:
    label1728:
    label1738:
    label1756:
    label1766:
    label1784:
    for (boolean bool21 = true;; bool21 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1790;
      }
      return new Item((GroupedJobItem)localObject2, (JobDescription)localObject3, (JobDetails)localObject4, (NextJobCollection)localObject5, (SimilarJobTitlesEmployees)localObject6, (SkillsAndExperience)localObject7, (Description)localObject8, (MiniProfilesCollection)localObject9, (BasicCompanyInfo)localObject10, (InCommonCompany)localObject11, (InCommonPerson)localObject12, (InCommonSchool)localObject13, (JobPoster)localObject14, (ApplicantRanking)localObject15, (CompanyGrowthInsights)localObject16, (EducationAnalytics)localObject17, (InflowCompanyRankingInsights)localObject18, (SchoolRankingInsights)localObject19, (SeniorityAnalytics)localObject20, (TopSkillsAnalytics)localObject21, (JobCard)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool21);
      localObject1 = (GroupedJobItem)paramDataProcessor.processDataTemplate(groupedJobItemValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (JobDescription)paramDataProcessor.processDataTemplate(jobDescriptionValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (JobDetails)paramDataProcessor.processDataTemplate(jobDetailsValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (NextJobCollection)paramDataProcessor.processDataTemplate(nextJobCollectionValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (SimilarJobTitlesEmployees)paramDataProcessor.processDataTemplate(similarJobTitlesEmployeesValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (SkillsAndExperience)paramDataProcessor.processDataTemplate(skillsAndExperienceValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (Description)paramDataProcessor.processDataTemplate(descriptionValue);
      break label354;
      bool7 = false;
      localObject8 = localObject1;
      break label366;
      localObject1 = (MiniProfilesCollection)paramDataProcessor.processDataTemplate(miniProfilesCollectionValue);
      break label406;
      bool8 = false;
      localObject9 = localObject1;
      break label418;
      localObject1 = (BasicCompanyInfo)paramDataProcessor.processDataTemplate(basicCompanyInfoValue);
      break label459;
      bool9 = false;
      localObject10 = localObject1;
      break label471;
      localObject1 = (InCommonCompany)paramDataProcessor.processDataTemplate(inCommonCompanyValue);
      break label512;
      bool10 = false;
      localObject11 = localObject1;
      break label524;
      localObject1 = (InCommonPerson)paramDataProcessor.processDataTemplate(inCommonPersonValue);
      break label565;
      bool11 = false;
      localObject12 = localObject1;
      break label577;
      localObject1 = (InCommonSchool)paramDataProcessor.processDataTemplate(inCommonSchoolValue);
      break label618;
      bool12 = false;
      localObject13 = localObject1;
      break label630;
      localObject1 = (JobPoster)paramDataProcessor.processDataTemplate(jobPosterValue);
      break label671;
      bool13 = false;
      localObject14 = localObject1;
      break label683;
      localObject1 = (ApplicantRanking)paramDataProcessor.processDataTemplate(applicantRankingValue);
      break label724;
      bool14 = false;
      localObject15 = localObject1;
      break label736;
      localObject1 = (CompanyGrowthInsights)paramDataProcessor.processDataTemplate(companyGrowthInsightsValue);
      break label777;
      bool15 = false;
      localObject16 = localObject1;
      break label789;
      localObject1 = (EducationAnalytics)paramDataProcessor.processDataTemplate(educationAnalyticsValue);
      break label830;
      bool16 = false;
      localObject17 = localObject1;
      break label842;
      localObject1 = (InflowCompanyRankingInsights)paramDataProcessor.processDataTemplate(inflowCompanyRankingInsightsValue);
      break label883;
      bool17 = false;
      localObject18 = localObject1;
      break label895;
      localObject1 = (SchoolRankingInsights)paramDataProcessor.processDataTemplate(schoolRankingInsightsValue);
      break label936;
      bool18 = false;
      localObject19 = localObject1;
      break label948;
      localObject1 = (SeniorityAnalytics)paramDataProcessor.processDataTemplate(seniorityAnalyticsValue);
      break label989;
      bool19 = false;
      localObject20 = localObject1;
      break label1001;
      localObject1 = (TopSkillsAnalytics)paramDataProcessor.processDataTemplate(topSkillsAnalyticsValue);
      break label1042;
      bool20 = false;
      localObject21 = localObject1;
      break label1054;
      localObject1 = (JobCard)paramDataProcessor.processDataTemplate(jobCardValue);
      break label1095;
    }
    label1790:
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
      paramObject = (Item)paramObject;
      if (groupedJobItemValue != null)
      {
        if (groupedJobItemValue.equals(groupedJobItemValue)) {}
      }
      else {
        while (groupedJobItemValue != null) {
          return false;
        }
      }
      if (jobDescriptionValue != null)
      {
        if (jobDescriptionValue.equals(jobDescriptionValue)) {}
      }
      else {
        while (jobDescriptionValue != null) {
          return false;
        }
      }
      if (jobDetailsValue != null)
      {
        if (jobDetailsValue.equals(jobDetailsValue)) {}
      }
      else {
        while (jobDetailsValue != null) {
          return false;
        }
      }
      if (nextJobCollectionValue != null)
      {
        if (nextJobCollectionValue.equals(nextJobCollectionValue)) {}
      }
      else {
        while (nextJobCollectionValue != null) {
          return false;
        }
      }
      if (similarJobTitlesEmployeesValue != null)
      {
        if (similarJobTitlesEmployeesValue.equals(similarJobTitlesEmployeesValue)) {}
      }
      else {
        while (similarJobTitlesEmployeesValue != null) {
          return false;
        }
      }
      if (skillsAndExperienceValue != null)
      {
        if (skillsAndExperienceValue.equals(skillsAndExperienceValue)) {}
      }
      else {
        while (skillsAndExperienceValue != null) {
          return false;
        }
      }
      if (descriptionValue != null)
      {
        if (descriptionValue.equals(descriptionValue)) {}
      }
      else {
        while (descriptionValue != null) {
          return false;
        }
      }
      if (miniProfilesCollectionValue != null)
      {
        if (miniProfilesCollectionValue.equals(miniProfilesCollectionValue)) {}
      }
      else {
        while (miniProfilesCollectionValue != null) {
          return false;
        }
      }
      if (basicCompanyInfoValue != null)
      {
        if (basicCompanyInfoValue.equals(basicCompanyInfoValue)) {}
      }
      else {
        while (basicCompanyInfoValue != null) {
          return false;
        }
      }
      if (inCommonCompanyValue != null)
      {
        if (inCommonCompanyValue.equals(inCommonCompanyValue)) {}
      }
      else {
        while (inCommonCompanyValue != null) {
          return false;
        }
      }
      if (inCommonPersonValue != null)
      {
        if (inCommonPersonValue.equals(inCommonPersonValue)) {}
      }
      else {
        while (inCommonPersonValue != null) {
          return false;
        }
      }
      if (inCommonSchoolValue != null)
      {
        if (inCommonSchoolValue.equals(inCommonSchoolValue)) {}
      }
      else {
        while (inCommonSchoolValue != null) {
          return false;
        }
      }
      if (jobPosterValue != null)
      {
        if (jobPosterValue.equals(jobPosterValue)) {}
      }
      else {
        while (jobPosterValue != null) {
          return false;
        }
      }
      if (applicantRankingValue != null)
      {
        if (applicantRankingValue.equals(applicantRankingValue)) {}
      }
      else {
        while (applicantRankingValue != null) {
          return false;
        }
      }
      if (companyGrowthInsightsValue != null)
      {
        if (companyGrowthInsightsValue.equals(companyGrowthInsightsValue)) {}
      }
      else {
        while (companyGrowthInsightsValue != null) {
          return false;
        }
      }
      if (educationAnalyticsValue != null)
      {
        if (educationAnalyticsValue.equals(educationAnalyticsValue)) {}
      }
      else {
        while (educationAnalyticsValue != null) {
          return false;
        }
      }
      if (inflowCompanyRankingInsightsValue != null)
      {
        if (inflowCompanyRankingInsightsValue.equals(inflowCompanyRankingInsightsValue)) {}
      }
      else {
        while (inflowCompanyRankingInsightsValue != null) {
          return false;
        }
      }
      if (schoolRankingInsightsValue != null)
      {
        if (schoolRankingInsightsValue.equals(schoolRankingInsightsValue)) {}
      }
      else {
        while (schoolRankingInsightsValue != null) {
          return false;
        }
      }
      if (seniorityAnalyticsValue != null)
      {
        if (seniorityAnalyticsValue.equals(seniorityAnalyticsValue)) {}
      }
      else {
        while (seniorityAnalyticsValue != null) {
          return false;
        }
      }
      if (topSkillsAnalyticsValue != null)
      {
        if (topSkillsAnalyticsValue.equals(topSkillsAnalyticsValue)) {}
      }
      else {
        while (topSkillsAnalyticsValue != null) {
          return false;
        }
      }
      if (jobCardValue == null) {
        break;
      }
    } while (jobCardValue.equals(jobCardValue));
    for (;;)
    {
      return false;
      if (jobCardValue == null) {
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
    if (hasGroupedJobItemValue)
    {
      if (groupedJobItemValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(groupedJobItemValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasJobDescriptionValue)
      {
        i = j + 1;
        if (jobDescriptionValue._cachedId == null) {
          break label912;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobDescriptionValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasJobDetailsValue)
      {
        i = j + 1;
        if (jobDetailsValue._cachedId == null) {
          break label925;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobDetailsValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasNextJobCollectionValue)
      {
        i = j + 1;
        if (nextJobCollectionValue._cachedId == null) {
          break label938;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(nextJobCollectionValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasSimilarJobTitlesEmployeesValue)
      {
        i = j + 1;
        if (similarJobTitlesEmployeesValue._cachedId == null) {
          break label951;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(similarJobTitlesEmployeesValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasSkillsAndExperienceValue)
      {
        i = j + 1;
        if (skillsAndExperienceValue._cachedId == null) {
          break label964;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(skillsAndExperienceValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasDescriptionValue)
      {
        i = j + 1;
        if (descriptionValue._cachedId == null) {
          break label977;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptionValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasMiniProfilesCollectionValue)
      {
        i = j + 1;
        if (miniProfilesCollectionValue._cachedId == null) {
          break label990;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfilesCollectionValue._cachedId);
      }
      label345:
      j = i + 1;
      i = j;
      if (hasBasicCompanyInfoValue)
      {
        i = j + 1;
        if (basicCompanyInfoValue._cachedId == null) {
          break label1003;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(basicCompanyInfoValue._cachedId);
      }
      label387:
      j = i + 1;
      i = j;
      if (hasInCommonCompanyValue)
      {
        i = j + 1;
        if (inCommonCompanyValue._cachedId == null) {
          break label1016;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(inCommonCompanyValue._cachedId);
      }
      label429:
      j = i + 1;
      i = j;
      if (hasInCommonPersonValue)
      {
        i = j + 1;
        if (inCommonPersonValue._cachedId == null) {
          break label1029;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(inCommonPersonValue._cachedId);
      }
      label471:
      j = i + 1;
      i = j;
      if (hasInCommonSchoolValue)
      {
        i = j + 1;
        if (inCommonSchoolValue._cachedId == null) {
          break label1042;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(inCommonSchoolValue._cachedId);
      }
      label513:
      j = i + 1;
      i = j;
      if (hasJobPosterValue)
      {
        i = j + 1;
        if (jobPosterValue._cachedId == null) {
          break label1055;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobPosterValue._cachedId);
      }
      label555:
      j = i + 1;
      i = j;
      if (hasApplicantRankingValue)
      {
        i = j + 1;
        if (applicantRankingValue._cachedId == null) {
          break label1068;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(applicantRankingValue._cachedId);
      }
      label597:
      j = i + 1;
      i = j;
      if (hasCompanyGrowthInsightsValue)
      {
        i = j + 1;
        if (companyGrowthInsightsValue._cachedId == null) {
          break label1081;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(companyGrowthInsightsValue._cachedId);
      }
      label639:
      j = i + 1;
      i = j;
      if (hasEducationAnalyticsValue)
      {
        i = j + 1;
        if (educationAnalyticsValue._cachedId == null) {
          break label1094;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(educationAnalyticsValue._cachedId);
      }
      label681:
      j = i + 1;
      i = j;
      if (hasInflowCompanyRankingInsightsValue)
      {
        i = j + 1;
        if (inflowCompanyRankingInsightsValue._cachedId == null) {
          break label1107;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(inflowCompanyRankingInsightsValue._cachedId);
      }
      label723:
      j = i + 1;
      i = j;
      if (hasSchoolRankingInsightsValue)
      {
        i = j + 1;
        if (schoolRankingInsightsValue._cachedId == null) {
          break label1120;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolRankingInsightsValue._cachedId);
      }
      label765:
      j = i + 1;
      i = j;
      if (hasSeniorityAnalyticsValue)
      {
        i = j + 1;
        if (seniorityAnalyticsValue._cachedId == null) {
          break label1133;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(seniorityAnalyticsValue._cachedId);
      }
      label807:
      j = i + 1;
      i = j;
      if (hasTopSkillsAnalyticsValue)
      {
        i = j + 1;
        if (topSkillsAnalyticsValue._cachedId == null) {
          break label1146;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(topSkillsAnalyticsValue._cachedId);
      }
      label849:
      j = i + 1;
      i = j;
      if (hasJobCardValue)
      {
        i = j + 1;
        if (jobCardValue._cachedId == null) {
          break label1159;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(jobCardValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = groupedJobItemValue.getSerializedSize() + 7;
      break;
      label912:
      i += jobDescriptionValue.getSerializedSize();
      break label93;
      label925:
      i += jobDetailsValue.getSerializedSize();
      break label135;
      label938:
      i += nextJobCollectionValue.getSerializedSize();
      break label177;
      label951:
      i += similarJobTitlesEmployeesValue.getSerializedSize();
      break label219;
      label964:
      i += skillsAndExperienceValue.getSerializedSize();
      break label261;
      label977:
      i += descriptionValue.getSerializedSize();
      break label303;
      label990:
      i += miniProfilesCollectionValue.getSerializedSize();
      break label345;
      label1003:
      i += basicCompanyInfoValue.getSerializedSize();
      break label387;
      label1016:
      i += inCommonCompanyValue.getSerializedSize();
      break label429;
      label1029:
      i += inCommonPersonValue.getSerializedSize();
      break label471;
      label1042:
      i += inCommonSchoolValue.getSerializedSize();
      break label513;
      label1055:
      i += jobPosterValue.getSerializedSize();
      break label555;
      label1068:
      i += applicantRankingValue.getSerializedSize();
      break label597;
      label1081:
      i += companyGrowthInsightsValue.getSerializedSize();
      break label639;
      label1094:
      i += educationAnalyticsValue.getSerializedSize();
      break label681;
      label1107:
      i += inflowCompanyRankingInsightsValue.getSerializedSize();
      break label723;
      label1120:
      i += schoolRankingInsightsValue.getSerializedSize();
      break label765;
      label1133:
      i += seniorityAnalyticsValue.getSerializedSize();
      break label807;
      label1146:
      i += topSkillsAnalyticsValue.getSerializedSize();
      break label849;
      label1159:
      i += jobCardValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i16 = 0;
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
    label124:
    int i3;
    label140:
    int i4;
    label156:
    int i5;
    label172:
    int i6;
    label188:
    int i7;
    label204:
    int i8;
    label220:
    int i9;
    label236:
    int i10;
    label252:
    int i11;
    label268:
    int i12;
    label284:
    int i13;
    label300:
    int i14;
    if (groupedJobItemValue != null)
    {
      i = groupedJobItemValue.hashCode();
      if (jobDescriptionValue == null) {
        break label484;
      }
      j = jobDescriptionValue.hashCode();
      if (jobDetailsValue == null) {
        break label489;
      }
      k = jobDetailsValue.hashCode();
      if (nextJobCollectionValue == null) {
        break label494;
      }
      m = nextJobCollectionValue.hashCode();
      if (similarJobTitlesEmployeesValue == null) {
        break label500;
      }
      n = similarJobTitlesEmployeesValue.hashCode();
      if (skillsAndExperienceValue == null) {
        break label506;
      }
      i1 = skillsAndExperienceValue.hashCode();
      if (descriptionValue == null) {
        break label512;
      }
      i2 = descriptionValue.hashCode();
      if (miniProfilesCollectionValue == null) {
        break label518;
      }
      i3 = miniProfilesCollectionValue.hashCode();
      if (basicCompanyInfoValue == null) {
        break label524;
      }
      i4 = basicCompanyInfoValue.hashCode();
      if (inCommonCompanyValue == null) {
        break label530;
      }
      i5 = inCommonCompanyValue.hashCode();
      if (inCommonPersonValue == null) {
        break label536;
      }
      i6 = inCommonPersonValue.hashCode();
      if (inCommonSchoolValue == null) {
        break label542;
      }
      i7 = inCommonSchoolValue.hashCode();
      if (jobPosterValue == null) {
        break label548;
      }
      i8 = jobPosterValue.hashCode();
      if (applicantRankingValue == null) {
        break label554;
      }
      i9 = applicantRankingValue.hashCode();
      if (companyGrowthInsightsValue == null) {
        break label560;
      }
      i10 = companyGrowthInsightsValue.hashCode();
      if (educationAnalyticsValue == null) {
        break label566;
      }
      i11 = educationAnalyticsValue.hashCode();
      if (inflowCompanyRankingInsightsValue == null) {
        break label572;
      }
      i12 = inflowCompanyRankingInsightsValue.hashCode();
      if (schoolRankingInsightsValue == null) {
        break label578;
      }
      i13 = schoolRankingInsightsValue.hashCode();
      if (seniorityAnalyticsValue == null) {
        break label584;
      }
      i14 = seniorityAnalyticsValue.hashCode();
      label316:
      if (topSkillsAnalyticsValue == null) {
        break label590;
      }
    }
    label484:
    label489:
    label494:
    label500:
    label506:
    label512:
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    label554:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    for (int i15 = topSkillsAnalyticsValue.hashCode();; i15 = 0)
    {
      if (jobCardValue != null) {
        i16 = jobCardValue.hashCode();
      }
      i = (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i16;
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
      i3 = 0;
      break label140;
      i4 = 0;
      break label156;
      i5 = 0;
      break label172;
      i6 = 0;
      break label188;
      i7 = 0;
      break label204;
      i8 = 0;
      break label220;
      i9 = 0;
      break label236;
      i10 = 0;
      break label252;
      i11 = 0;
      break label268;
      i12 = 0;
      break label284;
      i13 = 0;
      break label300;
      i14 = 0;
      break label316;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Item");
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
    label232:
    label292:
    label352:
    label412:
    label472:
    label532:
    label592:
    label652:
    label712:
    label772:
    label832:
    label892:
    label952:
    label1012:
    label1072:
    label1132:
    label1192:
    label1252:
    label1312:
    label1440:
    label1465:
    label1475:
    label1500:
    label1510:
    label1535:
    label1545:
    label1570:
    label1580:
    label1605:
    label1615:
    label1640:
    label1650:
    label1675:
    label1685:
    label1710:
    label1720:
    label1745:
    label1755:
    label1780:
    label1790:
    label1815:
    label1825:
    label1850:
    label1860:
    label1885:
    label1895:
    label1920:
    label1930:
    label1955:
    label1965:
    label1990:
    label2000:
    label2025:
    label2035:
    label2060:
    label2070:
    label2095:
    label2105:
    label2130:
    label2138:
    label2140:
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
        localByteBuffer.putInt(-844128655);
        if (hasGroupedJobItemValue)
        {
          localByteBuffer.put((byte)1);
          if (groupedJobItemValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, groupedJobItemValue._cachedId);
            groupedJobItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobDescriptionValue) {
              break label1465;
            }
            localByteBuffer.put((byte)1);
            if (jobDescriptionValue._cachedId == null) {
              break label1440;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobDescriptionValue._cachedId);
            jobDescriptionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobDetailsValue) {
              break label1500;
            }
            localByteBuffer.put((byte)1);
            if (jobDetailsValue._cachedId == null) {
              break label1475;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobDetailsValue._cachedId);
            jobDetailsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNextJobCollectionValue) {
              break label1535;
            }
            localByteBuffer.put((byte)1);
            if (nextJobCollectionValue._cachedId == null) {
              break label1510;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, nextJobCollectionValue._cachedId);
            nextJobCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSimilarJobTitlesEmployeesValue) {
              break label1570;
            }
            localByteBuffer.put((byte)1);
            if (similarJobTitlesEmployeesValue._cachedId == null) {
              break label1545;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, similarJobTitlesEmployeesValue._cachedId);
            similarJobTitlesEmployeesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSkillsAndExperienceValue) {
              break label1605;
            }
            localByteBuffer.put((byte)1);
            if (skillsAndExperienceValue._cachedId == null) {
              break label1580;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, skillsAndExperienceValue._cachedId);
            skillsAndExperienceValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDescriptionValue) {
              break label1640;
            }
            localByteBuffer.put((byte)1);
            if (descriptionValue._cachedId == null) {
              break label1615;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, descriptionValue._cachedId);
            descriptionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMiniProfilesCollectionValue) {
              break label1675;
            }
            localByteBuffer.put((byte)1);
            if (miniProfilesCollectionValue._cachedId == null) {
              break label1650;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfilesCollectionValue._cachedId);
            miniProfilesCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBasicCompanyInfoValue) {
              break label1710;
            }
            localByteBuffer.put((byte)1);
            if (basicCompanyInfoValue._cachedId == null) {
              break label1685;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, basicCompanyInfoValue._cachedId);
            basicCompanyInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInCommonCompanyValue) {
              break label1745;
            }
            localByteBuffer.put((byte)1);
            if (inCommonCompanyValue._cachedId == null) {
              break label1720;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inCommonCompanyValue._cachedId);
            inCommonCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInCommonPersonValue) {
              break label1780;
            }
            localByteBuffer.put((byte)1);
            if (inCommonPersonValue._cachedId == null) {
              break label1755;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inCommonPersonValue._cachedId);
            inCommonPersonValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInCommonSchoolValue) {
              break label1815;
            }
            localByteBuffer.put((byte)1);
            if (inCommonSchoolValue._cachedId == null) {
              break label1790;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inCommonSchoolValue._cachedId);
            inCommonSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobPosterValue) {
              break label1850;
            }
            localByteBuffer.put((byte)1);
            if (jobPosterValue._cachedId == null) {
              break label1825;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobPosterValue._cachedId);
            jobPosterValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasApplicantRankingValue) {
              break label1885;
            }
            localByteBuffer.put((byte)1);
            if (applicantRankingValue._cachedId == null) {
              break label1860;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, applicantRankingValue._cachedId);
            applicantRankingValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCompanyGrowthInsightsValue) {
              break label1920;
            }
            localByteBuffer.put((byte)1);
            if (companyGrowthInsightsValue._cachedId == null) {
              break label1895;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, companyGrowthInsightsValue._cachedId);
            companyGrowthInsightsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEducationAnalyticsValue) {
              break label1955;
            }
            localByteBuffer.put((byte)1);
            if (educationAnalyticsValue._cachedId == null) {
              break label1930;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, educationAnalyticsValue._cachedId);
            educationAnalyticsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInflowCompanyRankingInsightsValue) {
              break label1990;
            }
            localByteBuffer.put((byte)1);
            if (inflowCompanyRankingInsightsValue._cachedId == null) {
              break label1965;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, inflowCompanyRankingInsightsValue._cachedId);
            inflowCompanyRankingInsightsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSchoolRankingInsightsValue) {
              break label2025;
            }
            localByteBuffer.put((byte)1);
            if (schoolRankingInsightsValue._cachedId == null) {
              break label2000;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, schoolRankingInsightsValue._cachedId);
            schoolRankingInsightsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSeniorityAnalyticsValue) {
              break label2060;
            }
            localByteBuffer.put((byte)1);
            if (seniorityAnalyticsValue._cachedId == null) {
              break label2035;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, seniorityAnalyticsValue._cachedId);
            seniorityAnalyticsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTopSkillsAnalyticsValue) {
              break label2095;
            }
            localByteBuffer.put((byte)1);
            if (topSkillsAnalyticsValue._cachedId == null) {
              break label2070;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, topSkillsAnalyticsValue._cachedId);
            topSkillsAnalyticsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasJobCardValue) {
              break label2130;
            }
            localByteBuffer.put((byte)1);
            if (jobCardValue._cachedId == null) {
              break label2105;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jobCardValue._cachedId);
            jobCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label2138;
          }
          if (str != null) {
            break label2140;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          groupedJobItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          jobDescriptionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label232;
          localByteBuffer.put((byte)0);
          break label232;
          localByteBuffer.put((byte)1);
          jobDetailsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label292;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)1);
          nextJobCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label352;
          localByteBuffer.put((byte)0);
          break label352;
          localByteBuffer.put((byte)1);
          similarJobTitlesEmployeesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label412;
          localByteBuffer.put((byte)0);
          break label412;
          localByteBuffer.put((byte)1);
          skillsAndExperienceValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label472;
          localByteBuffer.put((byte)0);
          break label472;
          localByteBuffer.put((byte)1);
          descriptionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label532;
          localByteBuffer.put((byte)0);
          break label532;
          localByteBuffer.put((byte)1);
          miniProfilesCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label592;
          localByteBuffer.put((byte)0);
          break label592;
          localByteBuffer.put((byte)1);
          basicCompanyInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label652;
          localByteBuffer.put((byte)0);
          break label652;
          localByteBuffer.put((byte)1);
          inCommonCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label712;
          localByteBuffer.put((byte)0);
          break label712;
          localByteBuffer.put((byte)1);
          inCommonPersonValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label772;
          localByteBuffer.put((byte)0);
          break label772;
          localByteBuffer.put((byte)1);
          inCommonSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label832;
          localByteBuffer.put((byte)0);
          break label832;
          localByteBuffer.put((byte)1);
          jobPosterValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label892;
          localByteBuffer.put((byte)0);
          break label892;
          localByteBuffer.put((byte)1);
          applicantRankingValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label952;
          localByteBuffer.put((byte)0);
          break label952;
          localByteBuffer.put((byte)1);
          companyGrowthInsightsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1012;
          localByteBuffer.put((byte)0);
          break label1012;
          localByteBuffer.put((byte)1);
          educationAnalyticsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1072;
          localByteBuffer.put((byte)0);
          break label1072;
          localByteBuffer.put((byte)1);
          inflowCompanyRankingInsightsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1132;
          localByteBuffer.put((byte)0);
          break label1132;
          localByteBuffer.put((byte)1);
          schoolRankingInsightsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1192;
          localByteBuffer.put((byte)0);
          break label1192;
          localByteBuffer.put((byte)1);
          seniorityAnalyticsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1252;
          localByteBuffer.put((byte)0);
          break label1252;
          localByteBuffer.put((byte)1);
          topSkillsAnalyticsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1312;
          localByteBuffer.put((byte)0);
          break label1312;
          localByteBuffer.put((byte)1);
          jobCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem.Item
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */