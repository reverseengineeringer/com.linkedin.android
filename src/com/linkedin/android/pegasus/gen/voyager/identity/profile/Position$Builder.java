package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Position$Builder
  implements RecordTemplateBuilder<Position>
{
  public PositionCompany company = null;
  public String companyName = null;
  public Urn companyUrn = null;
  private List<Urn> courses = null;
  public String description = null;
  private Urn entityUrn = null;
  public boolean hasCompany = false;
  public boolean hasCompanyName = false;
  public boolean hasCompanyUrn = false;
  private boolean hasCourses = false;
  public boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasHonors = false;
  public boolean hasLocationName = false;
  private boolean hasOrganizations = false;
  private boolean hasProjects = false;
  private boolean hasRecommendations = false;
  public boolean hasRegion = false;
  public boolean hasTimePeriod = false;
  public boolean hasTitle = false;
  private List<Urn> honors = null;
  public String locationName = null;
  private List<Urn> organizations = null;
  private List<Urn> projects = null;
  private List<Urn> recommendations = null;
  public Urn region = null;
  public DateRange timePeriod = null;
  public String title = null;
  
  public Position$Builder() {}
  
  public Position$Builder(Position paramPosition)
  {
    entityUrn = entityUrn;
    title = title;
    description = description;
    timePeriod = timePeriod;
    region = region;
    locationName = locationName;
    companyName = companyName;
    companyUrn = companyUrn;
    company = company;
    projects = projects;
    organizations = organizations;
    honors = honors;
    courses = courses;
    recommendations = recommendations;
    hasEntityUrn = hasEntityUrn;
    hasTitle = hasTitle;
    hasDescription = hasDescription;
    hasTimePeriod = hasTimePeriod;
    hasRegion = hasRegion;
    hasLocationName = hasLocationName;
    hasCompanyName = hasCompanyName;
    hasCompanyUrn = hasCompanyUrn;
    hasCompany = hasCompany;
    hasProjects = hasProjects;
    hasOrganizations = hasOrganizations;
    hasHonors = hasHonors;
    hasCourses = hasCourses;
    hasRecommendations = hasRecommendations;
  }
  
  public final Position build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Position.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (projects != null)
    {
      paramFlavor = projects.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((Urn)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "projects");
      if (!hasProjects) {
        projects = Collections.emptyList();
      }
      if (!hasOrganizations) {
        organizations = Collections.emptyList();
      }
      if (!hasHonors) {
        honors = Collections.emptyList();
      }
      if (!hasCourses) {
        courses = Collections.emptyList();
      }
      if (!hasRecommendations) {
        recommendations = Collections.emptyList();
      }
    }
    if (organizations != null)
    {
      paramFlavor = organizations.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "organizations");
        }
      }
    }
    if (honors != null)
    {
      paramFlavor = honors.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "honors");
        }
      }
    }
    if (courses != null)
    {
      paramFlavor = courses.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "courses");
        }
      }
    }
    if (recommendations != null)
    {
      paramFlavor = recommendations.iterator();
      while (paramFlavor.hasNext()) {
        if ((Urn)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "recommendations");
        }
      }
    }
    return new Position(entityUrn, title, description, timePeriod, region, locationName, companyName, companyUrn, company, projects, organizations, honors, courses, recommendations, hasEntityUrn, hasTitle, hasDescription, hasTimePeriod, hasRegion, hasLocationName, hasCompanyName, hasCompanyUrn, hasCompany, hasProjects, hasOrganizations, hasHonors, hasCourses, hasRecommendations);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Position.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */