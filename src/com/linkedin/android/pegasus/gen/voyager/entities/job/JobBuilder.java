package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class JobBuilder
  implements FissileDataModelBuilder<Job>, DataTemplateBuilder<Job>
{
  public static final JobBuilder INSTANCE = new JobBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("miniJob");
    JSON_KEY_STORE.put("basicCompanyInfo");
    JSON_KEY_STORE.put("numberOfApplicants");
    JSON_KEY_STORE.put("industries");
    JSON_KEY_STORE.put("jobFunctions");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("companyName");
    JSON_KEY_STORE.put("miniCompany");
    JSON_KEY_STORE.put("companyDescription");
    JSON_KEY_STORE.put("experienceLevel");
    JSON_KEY_STORE.put("heroImage");
    JSON_KEY_STORE.put("employmentStatus");
    JSON_KEY_STORE.put("skillsDescription");
    JSON_KEY_STORE.put("jobPoster");
    JSON_KEY_STORE.put("applicant");
    JSON_KEY_STORE.put("savingInfo");
    JSON_KEY_STORE.put("applyingInfo");
    JSON_KEY_STORE.put("isLinkedInRouting");
    JSON_KEY_STORE.put("linkedInRouting");
    JSON_KEY_STORE.put("companyApplyUrl");
    JSON_KEY_STORE.put("companyApplyPostUrl");
    JSON_KEY_STORE.put("sections");
    JSON_KEY_STORE.put("entityInfo");
    JSON_KEY_STORE.put("numberOfViewers");
    JSON_KEY_STORE.put("closed");
    JSON_KEY_STORE.put("flavors");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */