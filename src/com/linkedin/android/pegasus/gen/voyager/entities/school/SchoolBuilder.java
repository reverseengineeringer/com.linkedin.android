package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SchoolBuilder
  implements FissileDataModelBuilder<School>, DataTemplateBuilder<School>
{
  public static final SchoolBuilder INSTANCE = new SchoolBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("basicSchoolInfo");
    JSON_KEY_STORE.put("heroImage");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("numberOfStudentsAndAlumni");
    JSON_KEY_STORE.put("homepageUrl");
    JSON_KEY_STORE.put("emailAddress");
    JSON_KEY_STORE.put("phoneNumber");
    JSON_KEY_STORE.put("schoolType");
    JSON_KEY_STORE.put("address");
    JSON_KEY_STORE.put("yearLevel");
    JSON_KEY_STORE.put("numberOfUndergradStudents");
    JSON_KEY_STORE.put("numberOfGradStudents");
    JSON_KEY_STORE.put("numberOfFaculty");
    JSON_KEY_STORE.put("totalPopulation");
    JSON_KEY_STORE.put("maleStudentPercentage");
    JSON_KEY_STORE.put("femaleStudentPercentage");
    JSON_KEY_STORE.put("admittedPercentage");
    JSON_KEY_STORE.put("graduationPercentage");
    JSON_KEY_STORE.put("studentFacultyRatio");
    JSON_KEY_STORE.put("financialAidAvailable");
    JSON_KEY_STORE.put("financialAidPercentage");
    JSON_KEY_STORE.put("inStateTuition");
    JSON_KEY_STORE.put("outOfStateTuition");
    JSON_KEY_STORE.put("sections");
    JSON_KEY_STORE.put("entityInfo");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */