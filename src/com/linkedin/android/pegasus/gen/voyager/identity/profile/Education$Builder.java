package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Education$Builder
  implements RecordTemplateBuilder<Education>
{
  public String activities = null;
  private List<Urn> courses = null;
  public String degreeName = null;
  public Urn degreeUrn = null;
  public String description = null;
  private Urn entityUrn = null;
  public String fieldOfStudy = null;
  public Urn fieldOfStudyUrn = null;
  public String grade = null;
  public boolean hasActivities = false;
  private boolean hasCourses = false;
  public boolean hasDegreeName = false;
  public boolean hasDegreeUrn = false;
  public boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  public boolean hasFieldOfStudy = false;
  public boolean hasFieldOfStudyUrn = false;
  public boolean hasGrade = false;
  private boolean hasHonors = false;
  private boolean hasProjects = false;
  private boolean hasRecommendations = false;
  public boolean hasSchool = false;
  public boolean hasSchoolName = false;
  public boolean hasSchoolUrn = false;
  private boolean hasTestScores = false;
  public boolean hasTimePeriod = false;
  private List<Urn> honors = null;
  private List<Urn> projects = null;
  private List<Urn> recommendations = null;
  public MiniSchool school = null;
  public String schoolName = null;
  public Urn schoolUrn = null;
  private List<Urn> testScores = null;
  public DateRange timePeriod = null;
  
  public Education$Builder() {}
  
  public Education$Builder(Education paramEducation)
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
    honors = honors;
    courses = courses;
    school = school;
    testScores = testScores;
    projects = projects;
    recommendations = recommendations;
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
    hasHonors = hasHonors;
    hasCourses = hasCourses;
    hasSchool = hasSchool;
    hasTestScores = hasTestScores;
    hasProjects = hasProjects;
    hasRecommendations = hasRecommendations;
  }
  
  public final Education build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Education.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (honors != null)
    {
      paramFlavor = honors.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((Urn)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "honors");
      if (!hasHonors) {
        honors = Collections.emptyList();
      }
      if (!hasCourses) {
        courses = Collections.emptyList();
      }
      if (!hasTestScores) {
        testScores = Collections.emptyList();
      }
      if (!hasProjects) {
        projects = Collections.emptyList();
      }
      if (!hasRecommendations) {
        recommendations = Collections.emptyList();
      }
    }
    if (courses != null)
    {
      paramFlavor = courses.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "courses");
        }
      }
    }
    if (testScores != null)
    {
      paramFlavor = testScores.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "testScores");
        }
      }
    }
    if (projects != null)
    {
      paramFlavor = projects.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "projects");
        }
      }
    }
    if (recommendations != null)
    {
      paramFlavor = recommendations.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "recommendations");
        }
      }
    }
    return new Education(entityUrn, schoolUrn, schoolName, timePeriod, degreeName, degreeUrn, fieldOfStudy, fieldOfStudyUrn, activities, grade, description, honors, courses, school, testScores, projects, recommendations, hasEntityUrn, hasSchoolUrn, hasSchoolName, hasTimePeriod, hasDegreeName, hasDegreeUrn, hasFieldOfStudy, hasFieldOfStudyUrn, hasActivities, hasGrade, hasDescription, hasHonors, hasCourses, hasSchool, hasTestScores, hasProjects, hasRecommendations);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Education.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */