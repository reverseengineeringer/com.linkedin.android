package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormEducation$Builder
  implements RecordTemplateBuilder<NormEducation>
{
  private String activities = null;
  private String degreeName = null;
  private Urn degreeUrn = null;
  private String description = null;
  private Urn entityUrn = null;
  private String fieldOfStudy = null;
  private Urn fieldOfStudyUrn = null;
  private String grade = null;
  private boolean hasActivities = false;
  private boolean hasDegreeName = false;
  private boolean hasDegreeUrn = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasFieldOfStudy = false;
  private boolean hasFieldOfStudyUrn = false;
  private boolean hasGrade = false;
  private boolean hasSchoolName = false;
  private boolean hasSchoolUrn = false;
  private boolean hasTimePeriod = false;
  private String schoolName = null;
  private Urn schoolUrn = null;
  private DateRange timePeriod = null;
  
  public NormEducation$Builder() {}
  
  public NormEducation$Builder(NormEducation paramNormEducation)
  {
    entityUrn = entityUrn;
    schoolUrn = schoolUrn;
    schoolName = schoolName;
    timePeriod = timePeriod;
    degreeName = degreeName;
    degreeUrn = degreeUrn;
    fieldOfStudy = fieldOfStudy;
    fieldOfStudyUrn = fieldOfStudyUrn;
    activities = activities;
    grade = grade;
    description = description;
    hasEntityUrn = hasEntityUrn;
    hasSchoolUrn = hasSchoolUrn;
    hasSchoolName = hasSchoolName;
    hasTimePeriod = hasTimePeriod;
    hasDegreeName = hasDegreeName;
    hasDegreeUrn = hasDegreeUrn;
    hasFieldOfStudy = hasFieldOfStudy;
    hasFieldOfStudyUrn = hasFieldOfStudyUrn;
    hasActivities = hasActivities;
    hasGrade = hasGrade;
    hasDescription = hasDescription;
  }
  
  public final NormEducation build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = NormEducation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new NormEducation(entityUrn, schoolUrn, schoolName, timePeriod, degreeName, degreeUrn, fieldOfStudy, fieldOfStudyUrn, activities, grade, description, hasEntityUrn, hasSchoolUrn, hasSchoolName, hasTimePeriod, hasDegreeName, hasDegreeUrn, hasFieldOfStudy, hasFieldOfStudyUrn, hasActivities, hasGrade, hasDescription);
  }
  
  public final Builder setActivities(String paramString)
  {
    if (paramString == null)
    {
      hasActivities = false;
      activities = null;
      return this;
    }
    hasActivities = true;
    activities = paramString;
    return this;
  }
  
  public final Builder setDegreeName(String paramString)
  {
    if (paramString == null)
    {
      hasDegreeName = false;
      degreeName = null;
      return this;
    }
    hasDegreeName = true;
    degreeName = paramString;
    return this;
  }
  
  public final Builder setDegreeUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasDegreeUrn = false;
      degreeUrn = null;
      return this;
    }
    hasDegreeUrn = true;
    degreeUrn = paramUrn;
    return this;
  }
  
  public final Builder setDescription(String paramString)
  {
    if (paramString == null)
    {
      hasDescription = false;
      description = null;
      return this;
    }
    hasDescription = true;
    description = paramString;
    return this;
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
  
  public final Builder setFieldOfStudy(String paramString)
  {
    if (paramString == null)
    {
      hasFieldOfStudy = false;
      fieldOfStudy = null;
      return this;
    }
    hasFieldOfStudy = true;
    fieldOfStudy = paramString;
    return this;
  }
  
  public final Builder setFieldOfStudyUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasFieldOfStudyUrn = false;
      fieldOfStudyUrn = null;
      return this;
    }
    hasFieldOfStudyUrn = true;
    fieldOfStudyUrn = paramUrn;
    return this;
  }
  
  public final Builder setGrade(String paramString)
  {
    if (paramString == null)
    {
      hasGrade = false;
      grade = null;
      return this;
    }
    hasGrade = true;
    grade = paramString;
    return this;
  }
  
  public final Builder setSchoolName(String paramString)
  {
    if (paramString == null)
    {
      hasSchoolName = false;
      schoolName = null;
      return this;
    }
    hasSchoolName = true;
    schoolName = paramString;
    return this;
  }
  
  public final Builder setSchoolUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasSchoolUrn = false;
      schoolUrn = null;
      return this;
    }
    hasSchoolUrn = true;
    schoolUrn = paramUrn;
    return this;
  }
  
  public final Builder setTimePeriod(DateRange paramDateRange)
  {
    if (paramDateRange == null)
    {
      hasTimePeriod = false;
      timePeriod = null;
      return this;
    }
    hasTimePeriod = true;
    timePeriod = paramDateRange;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */