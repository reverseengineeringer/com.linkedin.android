package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class CompanyBuilder
  implements FissileDataModelBuilder<Company>, DataTemplateBuilder<Company>
{
  public static final CompanyBuilder INSTANCE = new CompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("basicCompanyInfo");
    JSON_KEY_STORE.put("heroImage");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("industries");
    JSON_KEY_STORE.put("websiteUrl");
    JSON_KEY_STORE.put("companyType");
    JSON_KEY_STORE.put("specialties");
    JSON_KEY_STORE.put("emailDomains");
    JSON_KEY_STORE.put("employeeCountRange");
    JSON_KEY_STORE.put("foundedDate");
    JSON_KEY_STORE.put("foundedOn");
    JSON_KEY_STORE.put("showcases");
    JSON_KEY_STORE.put("parentCompany");
    JSON_KEY_STORE.put("sections");
    JSON_KEY_STORE.put("entityInfo");
    JSON_KEY_STORE.put("numberOfEmployees");
    JSON_KEY_STORE.put("jobsCount");
    JSON_KEY_STORE.put("flavors");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */