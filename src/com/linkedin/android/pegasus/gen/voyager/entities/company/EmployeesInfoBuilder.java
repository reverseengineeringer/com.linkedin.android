package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class EmployeesInfoBuilder
  implements FissileDataModelBuilder<EmployeesInfo>, DataTemplateBuilder<EmployeesInfo>
{
  public static final EmployeesInfoBuilder INSTANCE = new EmployeesInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("miniCompany");
    JSON_KEY_STORE.put("numberOfEmployees");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeesInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */