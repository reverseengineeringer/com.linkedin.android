package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Position
  implements FissileDataModel<Position>, RecordTemplate<Position>
{
  public static final PositionBuilder BUILDER = PositionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final PositionCompany company;
  public final String companyName;
  public final Urn companyUrn;
  public final List<Urn> courses;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasCompany;
  public final boolean hasCompanyName;
  public final boolean hasCompanyUrn;
  public final boolean hasCourses;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasHonors;
  public final boolean hasLocationName;
  public final boolean hasOrganizations;
  public final boolean hasProjects;
  public final boolean hasRecommendations;
  public final boolean hasRegion;
  public final boolean hasTimePeriod;
  public final boolean hasTitle;
  public final List<Urn> honors;
  public final String locationName;
  public final List<Urn> organizations;
  public final List<Urn> projects;
  public final List<Urn> recommendations;
  public final Urn region;
  public final DateRange timePeriod;
  public final String title;
  
  Position(Urn paramUrn1, String paramString1, String paramString2, DateRange paramDateRange, Urn paramUrn2, String paramString3, String paramString4, Urn paramUrn3, PositionCompany paramPositionCompany, List<Urn> paramList1, List<Urn> paramList2, List<Urn> paramList3, List<Urn> paramList4, List<Urn> paramList5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14)
  {
    entityUrn = paramUrn1;
    title = paramString1;
    description = paramString2;
    timePeriod = paramDateRange;
    region = paramUrn2;
    locationName = paramString3;
    companyName = paramString4;
    companyUrn = paramUrn3;
    company = paramPositionCompany;
    if (paramList1 == null)
    {
      paramString1 = null;
      projects = paramString1;
      if (paramList2 != null) {
        break label231;
      }
      paramString1 = null;
      label84:
      organizations = paramString1;
      if (paramList3 != null) {
        break label240;
      }
      paramString1 = null;
      label96:
      honors = paramString1;
      if (paramList4 != null) {
        break label249;
      }
      paramString1 = null;
      label108:
      courses = paramString1;
      if (paramList5 != null) {
        break label258;
      }
    }
    label231:
    label240:
    label249:
    label258:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList5))
    {
      recommendations = paramString1;
      hasEntityUrn = paramBoolean1;
      hasTitle = paramBoolean2;
      hasDescription = paramBoolean3;
      hasTimePeriod = paramBoolean4;
      hasRegion = paramBoolean5;
      hasLocationName = paramBoolean6;
      hasCompanyName = paramBoolean7;
      hasCompanyUrn = paramBoolean8;
      hasCompany = paramBoolean9;
      hasProjects = paramBoolean10;
      hasOrganizations = paramBoolean11;
      hasHonors = paramBoolean12;
      hasCourses = paramBoolean13;
      hasRecommendations = paramBoolean14;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
      return;
      paramString1 = Collections.unmodifiableList(paramList1);
      break;
      paramString1 = Collections.unmodifiableList(paramList2);
      break label84;
      paramString1 = Collections.unmodifiableList(paramList3);
      break label96;
      paramString1 = Collections.unmodifiableList(paramList4);
      break label108;
    }
  }
  
  public final Position accept(DataProcessor paramDataProcessor)
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
    if (hasDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("description");
      paramDataProcessor.processString(description);
    }
    Object localObject6 = null;
    boolean bool1 = false;
    label139:
    boolean bool2;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = timePeriod.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label467;
        }
        bool1 = true;
        localObject6 = localObject1;
      }
    }
    else
    {
      if (hasRegion)
      {
        paramDataProcessor.startRecordField$505cff1c("region");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(region));
      }
      if (hasLocationName)
      {
        paramDataProcessor.startRecordField$505cff1c("locationName");
        paramDataProcessor.processString(locationName);
      }
      if (hasCompanyName)
      {
        paramDataProcessor.startRecordField$505cff1c("companyName");
        paramDataProcessor.processString(companyName);
      }
      if (hasCompanyUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("companyUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(companyUrn));
      }
      localObject7 = null;
      bool2 = false;
      if (hasCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("company");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label476;
        }
        localObject1 = company.accept(paramDataProcessor);
        label295:
        if (localObject1 == null) {
          break label494;
        }
        bool2 = true;
      }
    }
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    for (Object localObject7 = localObject1;; localObject7 = localObject1)
    {
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasProjects) {
        break label518;
      }
      paramDataProcessor.startRecordField$505cff1c("projects");
      projects.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = projects.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Urn)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        localObject4 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType((Urn)localObject3));
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      localObject1 = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
      label467:
      bool1 = false;
      localObject6 = localObject1;
      break label139;
      label476:
      localObject1 = (PositionCompany)paramDataProcessor.processDataTemplate(company);
      break label295;
      label494:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    label518:
    Object localObject5;
    for (boolean bool3 = true;; bool3 = false)
    {
      localObject2 = null;
      localObject3 = null;
      bool4 = false;
      if (!hasOrganizations) {
        break label680;
      }
      paramDataProcessor.startRecordField$505cff1c("organizations");
      organizations.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = organizations.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Urn)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        localObject5 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType((Urn)localObject4));
        if (localObject2 != null) {
          ((List)localObject2).add(localObject4);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    label680:
    Object localObject8;
    for (boolean bool4 = true;; bool4 = false)
    {
      localObject3 = null;
      localObject4 = null;
      bool5 = false;
      if (!hasHonors) {
        break label842;
      }
      paramDataProcessor.startRecordField$505cff1c("honors");
      honors.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject4 = honors.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Urn)((Iterator)localObject4).next();
        paramDataProcessor.processArrayItem(i);
        localObject8 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType((Urn)localObject5));
        if (localObject3 != null) {
          ((List)localObject3).add(localObject5);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject3 != null) {}
    label842:
    Object localObject9;
    for (boolean bool5 = true;; bool5 = false)
    {
      localObject4 = null;
      localObject5 = null;
      bool6 = false;
      if (!hasCourses) {
        break label1004;
      }
      paramDataProcessor.startRecordField$505cff1c("courses");
      courses.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      localObject5 = courses.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject8 = (Urn)((Iterator)localObject5).next();
        paramDataProcessor.processArrayItem(i);
        localObject9 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType((Urn)localObject8));
        if (localObject4 != null) {
          ((List)localObject4).add(localObject8);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject4 != null) {}
    for (boolean bool6 = true;; bool6 = false)
    {
      label1004:
      localObject5 = null;
      localObject8 = null;
      bool7 = false;
      if (!hasRecommendations) {
        break label1166;
      }
      paramDataProcessor.startRecordField$505cff1c("recommendations");
      recommendations.size();
      paramDataProcessor.startArray$13462e();
      localObject5 = localObject8;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject5 = new ArrayList();
      }
      i = 0;
      localObject8 = recommendations.iterator();
      while (((Iterator)localObject8).hasNext())
      {
        localObject9 = (Urn)((Iterator)localObject8).next();
        paramDataProcessor.processArrayItem(i);
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType((Urn)localObject9));
        if (localObject5 != null) {
          ((List)localObject5).add(localObject9);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject5 != null) {}
    for (boolean bool7 = true;; bool7 = false)
    {
      label1166:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1598;
      }
      if (!hasProjects) {
        localObject1 = Collections.emptyList();
      }
      if (!hasOrganizations) {
        localObject2 = Collections.emptyList();
      }
      if (!hasHonors) {
        localObject3 = Collections.emptyList();
      }
      if (!hasCourses) {
        localObject4 = Collections.emptyList();
      }
      if (!hasRecommendations) {
        localObject5 = Collections.emptyList();
      }
      try
      {
        if (projects == null) {
          break;
        }
        paramDataProcessor = projects.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Urn)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "projects");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (organizations != null)
    {
      paramDataProcessor = organizations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "organizations");
        }
      }
    }
    if (honors != null)
    {
      paramDataProcessor = honors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "honors");
        }
      }
    }
    if (courses != null)
    {
      paramDataProcessor = courses.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "courses");
        }
      }
    }
    if (recommendations != null)
    {
      paramDataProcessor = recommendations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Position", "recommendations");
        }
      }
    }
    return new Position(entityUrn, title, description, (DateRange)localObject6, region, locationName, companyName, companyUrn, (PositionCompany)localObject7, (List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4, (List)localObject5, hasEntityUrn, hasTitle, hasDescription, bool1, hasRegion, hasLocationName, hasCompanyName, hasCompanyUrn, bool2, bool3, bool4, bool5, bool6, bool7);
    label1598:
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
      paramObject = (Position)paramObject;
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
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (timePeriod != null)
      {
        if (timePeriod.equals(timePeriod)) {}
      }
      else {
        while (timePeriod != null) {
          return false;
        }
      }
      if (region != null)
      {
        if (region.equals(region)) {}
      }
      else {
        while (region != null) {
          return false;
        }
      }
      if (locationName != null)
      {
        if (locationName.equals(locationName)) {}
      }
      else {
        while (locationName != null) {
          return false;
        }
      }
      if (companyName != null)
      {
        if (companyName.equals(companyName)) {}
      }
      else {
        while (companyName != null) {
          return false;
        }
      }
      if (companyUrn != null)
      {
        if (companyUrn.equals(companyUrn)) {}
      }
      else {
        while (companyUrn != null) {
          return false;
        }
      }
      if (company != null)
      {
        if (company.equals(company)) {}
      }
      else {
        while (company != null) {
          return false;
        }
      }
      if (projects != null)
      {
        if (projects.equals(projects)) {}
      }
      else {
        while (projects != null) {
          return false;
        }
      }
      if (organizations != null)
      {
        if (organizations.equals(organizations)) {}
      }
      else {
        while (organizations != null) {
          return false;
        }
      }
      if (honors != null)
      {
        if (honors.equals(honors)) {}
      }
      else {
        while (honors != null) {
          return false;
        }
      }
      if (courses != null)
      {
        if (courses.equals(courses)) {}
      }
      else {
        while (courses != null) {
          return false;
        }
      }
      if (recommendations == null) {
        break;
      }
    } while (recommendations.equals(recommendations));
    for (;;)
    {
      return false;
      if (recommendations == null) {
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
    if (hasDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
    }
    j = i + 1;
    i = j;
    if (hasTimePeriod)
    {
      i = j + 1;
      if (timePeriod._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasRegion)
      {
        localObject = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(region));
      }
      j = i + 1;
      i = j;
      if (hasLocationName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(locationName);
      }
      j = i + 1;
      i = j;
      if (hasCompanyName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyName);
      }
      j = i + 1;
      i = j;
      if (hasCompanyUrn)
      {
        localObject = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(companyUrn));
      }
      j = i + 1;
      i = j;
      if (hasCompany)
      {
        i = j + 1;
        if (company._cachedId == null) {
          break label376;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(company._cachedId);
      }
    }
    Urn localUrn;
    UrnCoercer localUrnCoercer;
    for (;;)
    {
      i += 1;
      j = i;
      if (!hasProjects) {
        break label389;
      }
      i += 2;
      localObject = projects.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = (Urn)((Iterator)localObject).next();
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
      i += timePeriod.getSerializedSize();
      break;
      label376:
      i += company.getSerializedSize();
    }
    label389:
    i = j + 1;
    j = i;
    if (hasOrganizations)
    {
      i += 2;
      localObject = organizations.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = (Urn)((Iterator)localObject).next();
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
    }
    i = j + 1;
    j = i;
    if (hasHonors)
    {
      i += 2;
      localObject = honors.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = (Urn)((Iterator)localObject).next();
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
    }
    i = j + 1;
    j = i;
    if (hasCourses)
    {
      i += 2;
      localObject = courses.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = (Urn)((Iterator)localObject).next();
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
    }
    i = j + 1;
    j = i;
    if (hasRecommendations)
    {
      i += 2;
      localObject = recommendations.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = (Urn)((Iterator)localObject).next();
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
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
    int i2;
    label124:
    int i3;
    label140:
    int i4;
    label156:
    int i5;
    label174:
    int i6;
    label192:
    int i7;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (title == null) {
        break label340;
      }
      j = title.hashCode();
      if (description == null) {
        break label345;
      }
      k = description.hashCode();
      if (timePeriod == null) {
        break label350;
      }
      m = timePeriod.hashCode();
      if (region == null) {
        break label356;
      }
      n = region.hashCode();
      if (locationName == null) {
        break label362;
      }
      i1 = locationName.hashCode();
      if (companyName == null) {
        break label368;
      }
      i2 = companyName.hashCode();
      if (companyUrn == null) {
        break label374;
      }
      i3 = companyUrn.hashCode();
      if (company == null) {
        break label380;
      }
      i4 = company.hashCode();
      if (projects == null) {
        break label386;
      }
      i5 = projects.hashCode();
      if (organizations == null) {
        break label392;
      }
      i6 = organizations.hashCode();
      if (honors == null) {
        break label398;
      }
      i7 = honors.hashCode();
      label210:
      if (courses == null) {
        break label404;
      }
    }
    label340:
    label345:
    label350:
    label356:
    label362:
    label368:
    label374:
    label380:
    label386:
    label392:
    label398:
    label404:
    for (int i8 = courses.hashCode();; i8 = 0)
    {
      if (recommendations != null) {
        i9 = recommendations.hashCode();
      }
      i = (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i9;
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
      break label174;
      i6 = 0;
      break label192;
      i7 = 0;
      break label210;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Position");
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
    label258:
    label292:
    label318:
    label344:
    label378:
    label533:
    label543:
    label553:
    label578:
    label588:
    label598:
    label608:
    label618:
    label628:
    label653:
    label663:
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
        localByteBuffer.putInt(-521777773);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label533;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasDescription) {
            break label543;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasTimePeriod) {
            break label578;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label553;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRegion) {
            break label588;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(region));
          if (!hasLocationName) {
            break label598;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, locationName);
          if (!hasCompanyName) {
            break label608;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasCompanyUrn) {
            break label618;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(companyUrn));
          if (!hasCompany) {
            break label653;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label628;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        Urn localUrn;
        UrnCoercer localUrnCoercer;
        for (;;)
        {
          if (!hasProjects) {
            break label663;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, projects.size());
          localObject = projects.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label172;
          localByteBuffer.put((byte)0);
          break label198;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label258;
          localByteBuffer.put((byte)0);
          break label258;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)0);
          break label318;
          localByteBuffer.put((byte)0);
          break label344;
          localByteBuffer.put((byte)0);
          break label378;
          localByteBuffer.put((byte)1);
          company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasOrganizations)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, organizations.size());
          localObject = organizations.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
        }
        localByteBuffer.put((byte)0);
        if (hasHonors)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, honors.size());
          localObject = honors.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
        }
        localByteBuffer.put((byte)0);
        if (hasCourses)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, courses.size());
          localObject = courses.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
        }
        localByteBuffer.put((byte)0);
        if (hasRecommendations)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, recommendations.size());
          localObject = recommendations.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
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
  
  public static final class Builder
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
    
    public Builder() {}
    
    public Builder(Position paramPosition)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Position
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */