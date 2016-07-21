package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.DescriptionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollectionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchoolBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRankingBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsightsBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalyticsBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.InflowCompanyRankingInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.InflowCompanyRankingInsightsBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRankingInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRankingInsightsBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityAnalyticsBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillsAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillsAnalyticsBuilder;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCardBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobItemBuilder$ItemBuilder
  implements FissileDataModelBuilder<JobItem.Item>, DataTemplateBuilder<JobItem.Item>
{
  public static final ItemBuilder INSTANCE = new ItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.entities.job.GroupedJobItem");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.JobDescription");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.JobDetails");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.NextJobCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.SimilarJobTitlesEmployees");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.SkillsAndExperience");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.Description");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.MiniProfilesCollection");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.BasicCompanyInfo");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.incommon.InCommonCompany");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.incommon.InCommonPerson");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.incommon.InCommonSchool");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.JobPoster");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.ApplicantRanking");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.CompanyGrowthInsights");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.EducationAnalytics");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.InflowCompanyRankingInsights");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.SchoolRankingInsights");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.SeniorityAnalytics");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.analytics.TopSkillsAnalytics");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.JobCard");
  }
  
  public static JobItem.Item build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject21 = null;
    Object localObject20 = null;
    Object localObject19 = null;
    Object localObject18 = null;
    Object localObject17 = null;
    Object localObject16 = null;
    Object localObject15 = null;
    Object localObject14 = null;
    Object localObject13 = null;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool21 = false;
    boolean bool20 = false;
    boolean bool19 = false;
    boolean bool18 = false;
    boolean bool17 = false;
    boolean bool16 = false;
    boolean bool15 = false;
    boolean bool14 = false;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.GroupedJobItem", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject21 = GroupedJobItemBuilder.INSTANCE;
        localObject21 = GroupedJobItemBuilder.build(paramDataReader);
        bool21 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.JobDescription", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject20 = JobDescriptionBuilder.INSTANCE;
        localObject20 = JobDescriptionBuilder.build(paramDataReader);
        bool20 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.JobDetails", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject19 = JobDetailsBuilder.INSTANCE;
        localObject19 = JobDetailsBuilder.build(paramDataReader);
        bool19 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.NextJobCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject18 = NextJobCollectionBuilder.INSTANCE;
        localObject18 = NextJobCollectionBuilder.build(paramDataReader);
        bool18 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.SimilarJobTitlesEmployees", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject17 = SimilarJobTitlesEmployeesBuilder.INSTANCE;
        localObject17 = SimilarJobTitlesEmployeesBuilder.build(paramDataReader);
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.SkillsAndExperience", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject16 = SkillsAndExperienceBuilder.INSTANCE;
        localObject16 = SkillsAndExperienceBuilder.build(paramDataReader);
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.Description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject15 = DescriptionBuilder.INSTANCE;
        localObject15 = DescriptionBuilder.build(paramDataReader);
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.MiniProfilesCollection", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject14 = MiniProfilesCollectionBuilder.INSTANCE;
        localObject14 = MiniProfilesCollectionBuilder.build(paramDataReader);
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.BasicCompanyInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject13 = BasicCompanyInfoBuilder.INSTANCE;
        localObject13 = BasicCompanyInfoBuilder.build(paramDataReader);
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.incommon.InCommonCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject12 = InCommonCompanyBuilder.INSTANCE;
        localObject12 = InCommonCompanyBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.incommon.InCommonPerson", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject11 = InCommonPersonBuilder.INSTANCE;
        localObject11 = InCommonPersonBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.incommon.InCommonSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = InCommonSchoolBuilder.INSTANCE;
        localObject10 = InCommonSchoolBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.JobPoster", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = JobPosterBuilder.INSTANCE;
        localObject9 = JobPosterBuilder.build(paramDataReader);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.ApplicantRanking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = ApplicantRankingBuilder.INSTANCE;
        localObject8 = ApplicantRankingBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.CompanyGrowthInsights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = CompanyGrowthInsightsBuilder.INSTANCE;
        localObject7 = CompanyGrowthInsightsBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.EducationAnalytics", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = EducationAnalyticsBuilder.INSTANCE;
        localObject6 = EducationAnalyticsBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.InflowCompanyRankingInsights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = InflowCompanyRankingInsightsBuilder.INSTANCE;
        localObject5 = InflowCompanyRankingInsightsBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.SchoolRankingInsights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = SchoolRankingInsightsBuilder.INSTANCE;
        localObject4 = SchoolRankingInsightsBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.SeniorityAnalytics", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = SeniorityAnalyticsBuilder.INSTANCE;
        localObject3 = SeniorityAnalyticsBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.analytics.TopSkillsAnalytics", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = TopSkillsAnalyticsBuilder.INSTANCE;
        localObject2 = TopSkillsAnalyticsBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.JobCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = JobCardBuilder.INSTANCE;
        localObject1 = JobCardBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool21) {
      j = 1;
    }
    int i = j;
    if (bool20)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool19)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool18)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool17)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool16)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool15)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool14)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool13)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool12)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      j = 1;
    }
    i = j;
    if (bool2)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Item");
    }
    return new JobItem.Item((GroupedJobItem)localObject21, (JobDescription)localObject20, (JobDetails)localObject19, (NextJobCollection)localObject18, (SimilarJobTitlesEmployees)localObject17, (SkillsAndExperience)localObject16, (Description)localObject15, (MiniProfilesCollection)localObject14, (BasicCompanyInfo)localObject13, (InCommonCompany)localObject12, (InCommonPerson)localObject11, (InCommonSchool)localObject10, (JobPoster)localObject9, (ApplicantRanking)localObject8, (CompanyGrowthInsights)localObject7, (EducationAnalytics)localObject6, (InflowCompanyRankingInsights)localObject5, (SchoolRankingInsights)localObject4, (SeniorityAnalytics)localObject3, (TopSkillsAnalytics)localObject2, (JobCard)localObject1, bool21, bool20, bool19, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static JobItem.Item readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobItem.Item");
    }
    Object localObject1 = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      do
      {
        do
        {
          localObject21 = paramString;
          if (i != 0) {
            break;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            return null;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobItem.Item");
    }
    Object localObject21 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobItem.Item");
    }
    if (((ByteBuffer)localObject21).getInt() != -844128655)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject21);
      throw new IOException("UID mismatch. Can't read cached data when building JobItem.Item");
    }
    paramString = null;
    GroupedJobItemBuilder localGroupedJobItemBuilder = null;
    localObject1 = null;
    JobDescriptionBuilder localJobDescriptionBuilder = null;
    Object localObject2 = null;
    JobDetailsBuilder localJobDetailsBuilder = null;
    Object localObject3 = null;
    NextJobCollectionBuilder localNextJobCollectionBuilder = null;
    Object localObject4 = null;
    SimilarJobTitlesEmployeesBuilder localSimilarJobTitlesEmployeesBuilder = null;
    Object localObject5 = null;
    SkillsAndExperienceBuilder localSkillsAndExperienceBuilder = null;
    Object localObject6 = null;
    DescriptionBuilder localDescriptionBuilder = null;
    Object localObject7 = null;
    MiniProfilesCollectionBuilder localMiniProfilesCollectionBuilder = null;
    Object localObject8 = null;
    BasicCompanyInfoBuilder localBasicCompanyInfoBuilder = null;
    Object localObject9 = null;
    InCommonCompanyBuilder localInCommonCompanyBuilder = null;
    Object localObject10 = null;
    InCommonPersonBuilder localInCommonPersonBuilder = null;
    Object localObject11 = null;
    InCommonSchoolBuilder localInCommonSchoolBuilder = null;
    Object localObject12 = null;
    JobPosterBuilder localJobPosterBuilder = null;
    Object localObject13 = null;
    ApplicantRankingBuilder localApplicantRankingBuilder = null;
    Object localObject14 = null;
    CompanyGrowthInsightsBuilder localCompanyGrowthInsightsBuilder = null;
    Object localObject15 = null;
    EducationAnalyticsBuilder localEducationAnalyticsBuilder = null;
    Object localObject16 = null;
    InflowCompanyRankingInsightsBuilder localInflowCompanyRankingInsightsBuilder = null;
    Object localObject17 = null;
    SchoolRankingInsightsBuilder localSchoolRankingInsightsBuilder = null;
    Object localObject18 = null;
    SeniorityAnalyticsBuilder localSeniorityAnalyticsBuilder = null;
    Object localObject19 = null;
    TopSkillsAnalyticsBuilder localTopSkillsAnalyticsBuilder = null;
    Object localObject20 = null;
    JobCardBuilder localJobCardBuilder = null;
    boolean bool2;
    boolean bool1;
    label396:
    label422:
    boolean bool3;
    label434:
    label496:
    label525:
    boolean bool4;
    label537:
    label599:
    label628:
    boolean bool5;
    label640:
    label702:
    label731:
    boolean bool6;
    label743:
    label805:
    label834:
    boolean bool7;
    label846:
    label908:
    label937:
    boolean bool8;
    label949:
    label1011:
    label1040:
    boolean bool9;
    label1052:
    label1114:
    label1143:
    boolean bool10;
    label1155:
    label1217:
    label1246:
    boolean bool11;
    label1258:
    label1320:
    label1349:
    boolean bool12;
    label1361:
    label1423:
    label1452:
    boolean bool13;
    label1464:
    label1526:
    label1555:
    boolean bool14;
    label1567:
    label1629:
    label1658:
    boolean bool15;
    label1670:
    label1732:
    label1761:
    boolean bool16;
    label1773:
    label1835:
    label1864:
    boolean bool17;
    label1876:
    label1938:
    label1967:
    boolean bool18;
    label1979:
    label2041:
    label2070:
    boolean bool19;
    label2082:
    label2144:
    label2173:
    boolean bool20;
    label2185:
    label2247:
    label2276:
    boolean bool21;
    if (((ByteBuffer)localObject21).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject21).get();
        paramString = localGroupedJobItemBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localGroupedJobItemBuilder = GroupedJobItemBuilder.INSTANCE;
          paramString = GroupedJobItemBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label2536;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = GroupedJobItemBuilder.INSTANCE;
          paramString = GroupedJobItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (paramString == null) {
            break label2542;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2548;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject1 = localJobDescriptionBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localJobDescriptionBuilder = JobDescriptionBuilder.INSTANCE;
          localObject1 = JobDescriptionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label2554;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = JobDescriptionBuilder.INSTANCE;
          localObject1 = JobDescriptionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label2560;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2566;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject2 = localJobDetailsBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localJobDetailsBuilder = JobDetailsBuilder.INSTANCE;
          localObject2 = JobDetailsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label2572;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = JobDetailsBuilder.INSTANCE;
          localObject2 = JobDetailsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label2578;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2584;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject3 = localNextJobCollectionBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localNextJobCollectionBuilder = NextJobCollectionBuilder.INSTANCE;
          localObject3 = NextJobCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label2590;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = NextJobCollectionBuilder.INSTANCE;
          localObject3 = NextJobCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label2596;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2602;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject4 = localSimilarJobTitlesEmployeesBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localSimilarJobTitlesEmployeesBuilder = SimilarJobTitlesEmployeesBuilder.INSTANCE;
          localObject4 = SimilarJobTitlesEmployeesBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label2608;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = SimilarJobTitlesEmployeesBuilder.INSTANCE;
          localObject4 = SimilarJobTitlesEmployeesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label2614;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2620;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject5 = localSkillsAndExperienceBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localSkillsAndExperienceBuilder = SkillsAndExperienceBuilder.INSTANCE;
          localObject5 = SkillsAndExperienceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label2626;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = SkillsAndExperienceBuilder.INSTANCE;
          localObject5 = SkillsAndExperienceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label2632;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2638;
      }
      bool8 = true;
      bool7 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject6 = localDescriptionBuilder;
        bool7 = bool8;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localDescriptionBuilder = DescriptionBuilder.INSTANCE;
          localObject6 = DescriptionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label2644;
          }
          bool7 = true;
        }
        if (i == 1)
        {
          localObject6 = DescriptionBuilder.INSTANCE;
          localObject6 = DescriptionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label2650;
          }
          bool7 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2656;
      }
      bool9 = true;
      bool8 = bool9;
      if (bool9)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject7 = localMiniProfilesCollectionBuilder;
        bool8 = bool9;
        if (i == 0)
        {
          localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localMiniProfilesCollectionBuilder = MiniProfilesCollectionBuilder.INSTANCE;
          localObject7 = MiniProfilesCollectionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
          if (localObject7 == null) {
            break label2662;
          }
          bool8 = true;
        }
        if (i == 1)
        {
          localObject7 = MiniProfilesCollectionBuilder.INSTANCE;
          localObject7 = MiniProfilesCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject7 == null) {
            break label2668;
          }
          bool8 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2674;
      }
      bool10 = true;
      bool9 = bool10;
      if (bool10)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject8 = localBasicCompanyInfoBuilder;
        bool9 = bool10;
        if (i == 0)
        {
          localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localBasicCompanyInfoBuilder = BasicCompanyInfoBuilder.INSTANCE;
          localObject8 = BasicCompanyInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
          if (localObject8 == null) {
            break label2680;
          }
          bool9 = true;
        }
        if (i == 1)
        {
          localObject8 = BasicCompanyInfoBuilder.INSTANCE;
          localObject8 = BasicCompanyInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject8 == null) {
            break label2686;
          }
          bool9 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2692;
      }
      bool11 = true;
      bool10 = bool11;
      if (bool11)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject9 = localInCommonCompanyBuilder;
        bool10 = bool11;
        if (i == 0)
        {
          localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localInCommonCompanyBuilder = InCommonCompanyBuilder.INSTANCE;
          localObject9 = InCommonCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
          if (localObject9 == null) {
            break label2698;
          }
          bool10 = true;
        }
        if (i == 1)
        {
          localObject9 = InCommonCompanyBuilder.INSTANCE;
          localObject9 = InCommonCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject9 == null) {
            break label2704;
          }
          bool10 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2710;
      }
      bool12 = true;
      bool11 = bool12;
      if (bool12)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject10 = localInCommonPersonBuilder;
        bool11 = bool12;
        if (i == 0)
        {
          localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localInCommonPersonBuilder = InCommonPersonBuilder.INSTANCE;
          localObject10 = InCommonPersonBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
          if (localObject10 == null) {
            break label2716;
          }
          bool11 = true;
        }
        if (i == 1)
        {
          localObject10 = InCommonPersonBuilder.INSTANCE;
          localObject10 = InCommonPersonBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject10 == null) {
            break label2722;
          }
          bool11 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2728;
      }
      bool13 = true;
      bool12 = bool13;
      if (bool13)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject11 = localInCommonSchoolBuilder;
        bool12 = bool13;
        if (i == 0)
        {
          localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localInCommonSchoolBuilder = InCommonSchoolBuilder.INSTANCE;
          localObject11 = InCommonSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
          if (localObject11 == null) {
            break label2734;
          }
          bool12 = true;
        }
        if (i == 1)
        {
          localObject11 = InCommonSchoolBuilder.INSTANCE;
          localObject11 = InCommonSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject11 == null) {
            break label2740;
          }
          bool12 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2746;
      }
      bool14 = true;
      bool13 = bool14;
      if (bool14)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject12 = localJobPosterBuilder;
        bool13 = bool14;
        if (i == 0)
        {
          localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localJobPosterBuilder = JobPosterBuilder.INSTANCE;
          localObject12 = JobPosterBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
          if (localObject12 == null) {
            break label2752;
          }
          bool13 = true;
        }
        if (i == 1)
        {
          localObject12 = JobPosterBuilder.INSTANCE;
          localObject12 = JobPosterBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject12 == null) {
            break label2758;
          }
          bool13 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2764;
      }
      bool15 = true;
      bool14 = bool15;
      if (bool15)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject13 = localApplicantRankingBuilder;
        bool14 = bool15;
        if (i == 0)
        {
          localObject13 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localApplicantRankingBuilder = ApplicantRankingBuilder.INSTANCE;
          localObject13 = ApplicantRankingBuilder.readFromFission(paramFissionAdapter, null, (String)localObject13, paramFissionTransaction);
          if (localObject13 == null) {
            break label2770;
          }
          bool14 = true;
        }
        if (i == 1)
        {
          localObject13 = ApplicantRankingBuilder.INSTANCE;
          localObject13 = ApplicantRankingBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject13 == null) {
            break label2776;
          }
          bool14 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2782;
      }
      bool16 = true;
      bool15 = bool16;
      if (bool16)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject14 = localCompanyGrowthInsightsBuilder;
        bool15 = bool16;
        if (i == 0)
        {
          localObject14 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localCompanyGrowthInsightsBuilder = CompanyGrowthInsightsBuilder.INSTANCE;
          localObject14 = CompanyGrowthInsightsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject14, paramFissionTransaction);
          if (localObject14 == null) {
            break label2788;
          }
          bool15 = true;
        }
        if (i == 1)
        {
          localObject14 = CompanyGrowthInsightsBuilder.INSTANCE;
          localObject14 = CompanyGrowthInsightsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject14 == null) {
            break label2794;
          }
          bool15 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2800;
      }
      bool17 = true;
      bool16 = bool17;
      if (bool17)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject15 = localEducationAnalyticsBuilder;
        bool16 = bool17;
        if (i == 0)
        {
          localObject15 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localEducationAnalyticsBuilder = EducationAnalyticsBuilder.INSTANCE;
          localObject15 = EducationAnalyticsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject15, paramFissionTransaction);
          if (localObject15 == null) {
            break label2806;
          }
          bool16 = true;
        }
        if (i == 1)
        {
          localObject15 = EducationAnalyticsBuilder.INSTANCE;
          localObject15 = EducationAnalyticsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject15 == null) {
            break label2812;
          }
          bool16 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2818;
      }
      bool18 = true;
      bool17 = bool18;
      if (bool18)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject16 = localInflowCompanyRankingInsightsBuilder;
        bool17 = bool18;
        if (i == 0)
        {
          localObject16 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localInflowCompanyRankingInsightsBuilder = InflowCompanyRankingInsightsBuilder.INSTANCE;
          localObject16 = InflowCompanyRankingInsightsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject16, paramFissionTransaction);
          if (localObject16 == null) {
            break label2824;
          }
          bool17 = true;
        }
        if (i == 1)
        {
          localObject16 = InflowCompanyRankingInsightsBuilder.INSTANCE;
          localObject16 = InflowCompanyRankingInsightsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject16 == null) {
            break label2830;
          }
          bool17 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2836;
      }
      bool19 = true;
      bool18 = bool19;
      if (bool19)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject17 = localSchoolRankingInsightsBuilder;
        bool18 = bool19;
        if (i == 0)
        {
          localObject17 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localSchoolRankingInsightsBuilder = SchoolRankingInsightsBuilder.INSTANCE;
          localObject17 = SchoolRankingInsightsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject17, paramFissionTransaction);
          if (localObject17 == null) {
            break label2842;
          }
          bool18 = true;
        }
        if (i == 1)
        {
          localObject17 = SchoolRankingInsightsBuilder.INSTANCE;
          localObject17 = SchoolRankingInsightsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject17 == null) {
            break label2848;
          }
          bool18 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2854;
      }
      bool20 = true;
      bool19 = bool20;
      if (bool20)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject18 = localSeniorityAnalyticsBuilder;
        bool19 = bool20;
        if (i == 0)
        {
          localObject18 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localSeniorityAnalyticsBuilder = SeniorityAnalyticsBuilder.INSTANCE;
          localObject18 = SeniorityAnalyticsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject18, paramFissionTransaction);
          if (localObject18 == null) {
            break label2860;
          }
          bool19 = true;
        }
        if (i == 1)
        {
          localObject18 = SeniorityAnalyticsBuilder.INSTANCE;
          localObject18 = SeniorityAnalyticsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject18 == null) {
            break label2866;
          }
          bool19 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2872;
      }
      bool21 = true;
      label2288:
      bool20 = bool21;
      if (bool21)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject19 = localTopSkillsAnalyticsBuilder;
        bool20 = bool21;
        if (i == 0)
        {
          localObject19 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localTopSkillsAnalyticsBuilder = TopSkillsAnalyticsBuilder.INSTANCE;
          localObject19 = TopSkillsAnalyticsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject19, paramFissionTransaction);
          if (localObject19 == null) {
            break label2878;
          }
          bool20 = true;
        }
        label2350:
        if (i == 1)
        {
          localObject19 = TopSkillsAnalyticsBuilder.INSTANCE;
          localObject19 = TopSkillsAnalyticsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject19 == null) {
            break label2884;
          }
          bool20 = true;
        }
      }
      label2379:
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2890;
      }
      bool21 = true;
      label2391:
      bool22 = bool21;
      if (bool21)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject20 = localJobCardBuilder;
        if (i == 0)
        {
          localObject20 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localJobCardBuilder = JobCardBuilder.INSTANCE;
          localObject20 = JobCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject20, paramFissionTransaction);
          if (localObject20 == null) {
            break label2896;
          }
          bool21 = true;
        }
        label2449:
        bool22 = bool21;
        if (i == 1)
        {
          localObject20 = JobCardBuilder.INSTANCE;
          localObject20 = JobCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject20 == null) {
            break label2902;
          }
        }
      }
    }
    label2536:
    label2542:
    label2548:
    label2554:
    label2560:
    label2566:
    label2572:
    label2578:
    label2584:
    label2590:
    label2596:
    label2602:
    label2608:
    label2614:
    label2620:
    label2626:
    label2632:
    label2638:
    label2644:
    label2650:
    label2656:
    label2662:
    label2668:
    label2674:
    label2680:
    label2686:
    label2692:
    label2698:
    label2704:
    label2710:
    label2716:
    label2722:
    label2728:
    label2734:
    label2740:
    label2746:
    label2752:
    label2758:
    label2764:
    label2770:
    label2776:
    label2782:
    label2788:
    label2794:
    label2800:
    label2806:
    label2812:
    label2818:
    label2824:
    label2830:
    label2836:
    label2842:
    label2848:
    label2854:
    label2860:
    label2866:
    label2872:
    label2878:
    label2884:
    label2890:
    label2896:
    label2902:
    for (boolean bool22 = true;; bool22 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject21);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label2911;
      }
      if (j == 0) {
        break label2908;
      }
      throw new IOException("Found more than 1 member when reading .Item from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label396;
      bool1 = false;
      break label422;
      bool3 = false;
      break label434;
      bool2 = false;
      break label496;
      bool2 = false;
      break label525;
      bool4 = false;
      break label537;
      bool3 = false;
      break label599;
      bool3 = false;
      break label628;
      bool5 = false;
      break label640;
      bool4 = false;
      break label702;
      bool4 = false;
      break label731;
      bool6 = false;
      break label743;
      bool5 = false;
      break label805;
      bool5 = false;
      break label834;
      bool7 = false;
      break label846;
      bool6 = false;
      break label908;
      bool6 = false;
      break label937;
      bool8 = false;
      break label949;
      bool7 = false;
      break label1011;
      bool7 = false;
      break label1040;
      bool9 = false;
      break label1052;
      bool8 = false;
      break label1114;
      bool8 = false;
      break label1143;
      bool10 = false;
      break label1155;
      bool9 = false;
      break label1217;
      bool9 = false;
      break label1246;
      bool11 = false;
      break label1258;
      bool10 = false;
      break label1320;
      bool10 = false;
      break label1349;
      bool12 = false;
      break label1361;
      bool11 = false;
      break label1423;
      bool11 = false;
      break label1452;
      bool13 = false;
      break label1464;
      bool12 = false;
      break label1526;
      bool12 = false;
      break label1555;
      bool14 = false;
      break label1567;
      bool13 = false;
      break label1629;
      bool13 = false;
      break label1658;
      bool15 = false;
      break label1670;
      bool14 = false;
      break label1732;
      bool14 = false;
      break label1761;
      bool16 = false;
      break label1773;
      bool15 = false;
      break label1835;
      bool15 = false;
      break label1864;
      bool17 = false;
      break label1876;
      bool16 = false;
      break label1938;
      bool16 = false;
      break label1967;
      bool18 = false;
      break label1979;
      bool17 = false;
      break label2041;
      bool17 = false;
      break label2070;
      bool19 = false;
      break label2082;
      bool18 = false;
      break label2144;
      bool18 = false;
      break label2173;
      bool20 = false;
      break label2185;
      bool19 = false;
      break label2247;
      bool19 = false;
      break label2276;
      bool21 = false;
      break label2288;
      bool20 = false;
      break label2350;
      bool20 = false;
      break label2379;
      bool21 = false;
      break label2391;
      bool21 = false;
      break label2449;
    }
    label2908:
    int i = 1;
    label2911:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool12)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool13)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool14)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool15)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool16)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool17)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool18)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool19)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool20)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Item from fission.");
      }
      i = 1;
    }
    if ((bool22) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading .Item from fission.");
    }
    return new JobItem.Item(paramString, (JobDescription)localObject1, (JobDetails)localObject2, (NextJobCollection)localObject3, (SimilarJobTitlesEmployees)localObject4, (SkillsAndExperience)localObject5, (Description)localObject6, (MiniProfilesCollection)localObject7, (BasicCompanyInfo)localObject8, (InCommonCompany)localObject9, (InCommonPerson)localObject10, (InCommonSchool)localObject11, (JobPoster)localObject12, (ApplicantRanking)localObject13, (CompanyGrowthInsights)localObject14, (EducationAnalytics)localObject15, (InflowCompanyRankingInsights)localObject16, (SchoolRankingInsights)localObject17, (SeniorityAnalytics)localObject18, (TopSkillsAnalytics)localObject19, (JobCard)localObject20, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool22);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemBuilder.ItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */