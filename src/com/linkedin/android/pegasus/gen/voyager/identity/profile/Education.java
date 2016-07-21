package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
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

public final class Education
  implements FissileDataModel<Education>, RecordTemplate<Education>
{
  public static final EducationBuilder BUILDER = EducationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String activities;
  public final List<Urn> courses;
  public final String degreeName;
  public final Urn degreeUrn;
  public final String description;
  public final Urn entityUrn;
  public final String fieldOfStudy;
  public final Urn fieldOfStudyUrn;
  public final String grade;
  public final boolean hasActivities;
  public final boolean hasCourses;
  public final boolean hasDegreeName;
  public final boolean hasDegreeUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasFieldOfStudy;
  public final boolean hasFieldOfStudyUrn;
  public final boolean hasGrade;
  public final boolean hasHonors;
  public final boolean hasProjects;
  public final boolean hasRecommendations;
  public final boolean hasSchool;
  public final boolean hasSchoolName;
  public final boolean hasSchoolUrn;
  public final boolean hasTestScores;
  public final boolean hasTimePeriod;
  public final List<Urn> honors;
  public final List<Urn> projects;
  public final List<Urn> recommendations;
  public final MiniSchool school;
  public final String schoolName;
  public final Urn schoolUrn;
  public final List<Urn> testScores;
  public final DateRange timePeriod;
  
  Education(Urn paramUrn1, Urn paramUrn2, String paramString1, DateRange paramDateRange, String paramString2, Urn paramUrn3, String paramString3, Urn paramUrn4, String paramString4, String paramString5, String paramString6, List<Urn> paramList1, List<Urn> paramList2, MiniSchool paramMiniSchool, List<Urn> paramList3, List<Urn> paramList4, List<Urn> paramList5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17)
  {
    entityUrn = paramUrn1;
    schoolUrn = paramUrn2;
    schoolName = paramString1;
    timePeriod = paramDateRange;
    degreeName = paramString2;
    degreeUrn = paramUrn3;
    fieldOfStudy = paramString3;
    fieldOfStudyUrn = paramUrn4;
    activities = paramString4;
    grade = paramString5;
    description = paramString6;
    if (paramList1 == null)
    {
      paramUrn2 = null;
      honors = paramUrn2;
      if (paramList2 != null) {
        break label267;
      }
      paramUrn2 = null;
      label96:
      courses = paramUrn2;
      school = paramMiniSchool;
      if (paramList3 != null) {
        break label276;
      }
      paramUrn2 = null;
      label114:
      testScores = paramUrn2;
      if (paramList4 != null) {
        break label285;
      }
      paramUrn2 = null;
      label126:
      projects = paramUrn2;
      if (paramList5 != null) {
        break label294;
      }
    }
    label267:
    label276:
    label285:
    label294:
    for (paramUrn2 = null;; paramUrn2 = Collections.unmodifiableList(paramList5))
    {
      recommendations = paramUrn2;
      hasEntityUrn = paramBoolean1;
      hasSchoolUrn = paramBoolean2;
      hasSchoolName = paramBoolean3;
      hasTimePeriod = paramBoolean4;
      hasDegreeName = paramBoolean5;
      hasDegreeUrn = paramBoolean6;
      hasFieldOfStudy = paramBoolean7;
      hasFieldOfStudyUrn = paramBoolean8;
      hasActivities = paramBoolean9;
      hasGrade = paramBoolean10;
      hasDescription = paramBoolean11;
      hasHonors = paramBoolean12;
      hasCourses = paramBoolean13;
      hasSchool = paramBoolean14;
      hasTestScores = paramBoolean15;
      hasProjects = paramBoolean16;
      hasRecommendations = paramBoolean17;
      paramUrn2 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
      return;
      paramUrn2 = Collections.unmodifiableList(paramList1);
      break;
      paramUrn2 = Collections.unmodifiableList(paramList2);
      break label96;
      paramUrn2 = Collections.unmodifiableList(paramList3);
      break label114;
      paramUrn2 = Collections.unmodifiableList(paramList4);
      break label126;
    }
  }
  
  public final Education accept(DataProcessor paramDataProcessor)
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
    if (hasSchoolUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("schoolUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(schoolUrn));
    }
    if (hasSchoolName)
    {
      paramDataProcessor.startRecordField$505cff1c("schoolName");
      paramDataProcessor.processString(schoolName);
    }
    Object localObject6 = null;
    boolean bool1 = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label480;
      }
      localObject1 = timePeriod.accept(paramDataProcessor);
      if (localObject1 == null) {
        break label498;
      }
      bool1 = true;
    }
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    for (localObject6 = localObject1;; localObject6 = localObject1)
    {
      if (hasDegreeName)
      {
        paramDataProcessor.startRecordField$505cff1c("degreeName");
        paramDataProcessor.processString(degreeName);
      }
      if (hasDegreeUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("degreeUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(degreeUrn));
      }
      if (hasFieldOfStudy)
      {
        paramDataProcessor.startRecordField$505cff1c("fieldOfStudy");
        paramDataProcessor.processString(fieldOfStudy);
      }
      if (hasFieldOfStudyUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("fieldOfStudyUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
      }
      if (hasActivities)
      {
        paramDataProcessor.startRecordField$505cff1c("activities");
        paramDataProcessor.processString(activities);
      }
      if (hasGrade)
      {
        paramDataProcessor.startRecordField$505cff1c("grade");
        paramDataProcessor.processString(grade);
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasHonors) {
        break label521;
      }
      paramDataProcessor.startRecordField$505cff1c("honors");
      honors.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = honors.iterator();
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
      label480:
      localObject1 = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
      label498:
      bool1 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    label521:
    boolean bool3;
    Object localObject5;
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject2 = null;
      localObject3 = null;
      bool3 = false;
      if (!hasCourses) {
        break label683;
      }
      paramDataProcessor.startRecordField$505cff1c("courses");
      courses.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = courses.iterator();
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
    label683:
    boolean bool4;
    if (localObject2 != null)
    {
      bool3 = true;
      localObject7 = null;
      bool4 = false;
      if (hasSchool)
      {
        paramDataProcessor.startRecordField$505cff1c("school");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label884;
        }
        localObject3 = school.accept(paramDataProcessor);
        label723:
        if (localObject3 == null) {
          break label902;
        }
        bool4 = true;
      }
    }
    Object localObject8;
    for (Object localObject7 = localObject3;; localObject7 = localObject3)
    {
      localObject3 = null;
      localObject4 = null;
      bool5 = false;
      if (!hasTestScores) {
        break label926;
      }
      paramDataProcessor.startRecordField$505cff1c("testScores");
      testScores.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject4 = testScores.iterator();
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
      bool3 = false;
      break;
      label884:
      localObject3 = (MiniSchool)paramDataProcessor.processDataTemplate(school);
      break label723;
      label902:
      bool4 = false;
    }
    paramDataProcessor.endArray();
    if (localObject3 != null) {}
    label926:
    Object localObject9;
    for (boolean bool5 = true;; bool5 = false)
    {
      localObject4 = null;
      localObject5 = null;
      bool6 = false;
      if (!hasProjects) {
        break label1089;
      }
      paramDataProcessor.startRecordField$505cff1c("projects");
      projects.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      localObject5 = projects.iterator();
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
      label1089:
      localObject5 = null;
      localObject8 = null;
      bool7 = false;
      if (!hasRecommendations) {
        break label1252;
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
      label1252:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1716;
      }
      if (!hasHonors) {
        localObject1 = Collections.emptyList();
      }
      if (!hasCourses) {
        localObject2 = Collections.emptyList();
      }
      if (!hasTestScores) {
        localObject3 = Collections.emptyList();
      }
      if (!hasProjects) {
        localObject4 = Collections.emptyList();
      }
      if (!hasRecommendations) {
        localObject5 = Collections.emptyList();
      }
      try
      {
        if (honors == null) {
          break;
        }
        paramDataProcessor = honors.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Urn)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "honors");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (courses != null)
    {
      paramDataProcessor = courses.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "courses");
        }
      }
    }
    if (testScores != null)
    {
      paramDataProcessor = testScores.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "testScores");
        }
      }
    }
    if (projects != null)
    {
      paramDataProcessor = projects.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "projects");
        }
      }
    }
    if (recommendations != null)
    {
      paramDataProcessor = recommendations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Education", "recommendations");
        }
      }
    }
    return new Education(entityUrn, schoolUrn, schoolName, (DateRange)localObject6, degreeName, degreeUrn, fieldOfStudy, fieldOfStudyUrn, activities, grade, description, (List)localObject1, (List)localObject2, (MiniSchool)localObject7, (List)localObject3, (List)localObject4, (List)localObject5, hasEntityUrn, hasSchoolUrn, hasSchoolName, bool1, hasDegreeName, hasDegreeUrn, hasFieldOfStudy, hasFieldOfStudyUrn, hasActivities, hasGrade, hasDescription, bool2, bool3, bool4, bool5, bool6, bool7);
    label1716:
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
      paramObject = (Education)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (schoolUrn != null)
      {
        if (schoolUrn.equals(schoolUrn)) {}
      }
      else {
        while (schoolUrn != null) {
          return false;
        }
      }
      if (schoolName != null)
      {
        if (schoolName.equals(schoolName)) {}
      }
      else {
        while (schoolName != null) {
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
      if (degreeName != null)
      {
        if (degreeName.equals(degreeName)) {}
      }
      else {
        while (degreeName != null) {
          return false;
        }
      }
      if (degreeUrn != null)
      {
        if (degreeUrn.equals(degreeUrn)) {}
      }
      else {
        while (degreeUrn != null) {
          return false;
        }
      }
      if (fieldOfStudy != null)
      {
        if (fieldOfStudy.equals(fieldOfStudy)) {}
      }
      else {
        while (fieldOfStudy != null) {
          return false;
        }
      }
      if (fieldOfStudyUrn != null)
      {
        if (fieldOfStudyUrn.equals(fieldOfStudyUrn)) {}
      }
      else {
        while (fieldOfStudyUrn != null) {
          return false;
        }
      }
      if (activities != null)
      {
        if (activities.equals(activities)) {}
      }
      else {
        while (activities != null) {
          return false;
        }
      }
      if (grade != null)
      {
        if (grade.equals(grade)) {}
      }
      else {
        while (grade != null) {
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
      if (school != null)
      {
        if (school.equals(school)) {}
      }
      else {
        while (school != null) {
          return false;
        }
      }
      if (testScores != null)
      {
        if (testScores.equals(testScores)) {}
      }
      else {
        while (testScores != null) {
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
    if (hasSchoolUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(schoolUrn));
    }
    j = i + 1;
    i = j;
    if (hasSchoolName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(schoolName);
    }
    j = i + 1;
    i = j;
    if (hasTimePeriod)
    {
      i = j + 1;
      if (timePeriod._cachedId == null) {
        break label403;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
    }
    Urn localUrn;
    UrnCoercer localUrnCoercer;
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasDegreeName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(degreeName);
      }
      j = i + 1;
      i = j;
      if (hasDegreeUrn)
      {
        localObject = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(degreeUrn));
      }
      j = i + 1;
      i = j;
      if (hasFieldOfStudy) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(fieldOfStudy);
      }
      j = i + 1;
      i = j;
      if (hasFieldOfStudyUrn)
      {
        localObject = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
      }
      j = i + 1;
      i = j;
      if (hasActivities) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(activities);
      }
      j = i + 1;
      i = j;
      if (hasGrade) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(grade);
      }
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      i += 1;
      j = i;
      if (!hasHonors) {
        break;
      }
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
      label403:
      i += timePeriod.getSerializedSize();
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
    j += 1;
    i = j;
    if (hasSchool)
    {
      i = j + 1;
      if (school._cachedId == null) {
        break label598;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(school._cachedId);
    }
    for (;;)
    {
      i += 1;
      j = i;
      if (!hasTestScores) {
        break;
      }
      i += 2;
      localObject = testScores.iterator();
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
      label598:
      i += school.getSerializedSize();
    }
    i = j + 1;
    j = i;
    if (hasProjects)
    {
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
    int i12 = 0;
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
    label206:
    int i8;
    label224:
    int i9;
    label240:
    int i10;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (schoolUrn == null) {
        break label406;
      }
      j = schoolUrn.hashCode();
      if (schoolName == null) {
        break label411;
      }
      k = schoolName.hashCode();
      if (timePeriod == null) {
        break label416;
      }
      m = timePeriod.hashCode();
      if (degreeName == null) {
        break label422;
      }
      n = degreeName.hashCode();
      if (degreeUrn == null) {
        break label428;
      }
      i1 = degreeUrn.hashCode();
      if (fieldOfStudy == null) {
        break label434;
      }
      i2 = fieldOfStudy.hashCode();
      if (fieldOfStudyUrn == null) {
        break label440;
      }
      i3 = fieldOfStudyUrn.hashCode();
      if (activities == null) {
        break label446;
      }
      i4 = activities.hashCode();
      if (grade == null) {
        break label452;
      }
      i5 = grade.hashCode();
      if (description == null) {
        break label458;
      }
      i6 = description.hashCode();
      if (honors == null) {
        break label464;
      }
      i7 = honors.hashCode();
      if (courses == null) {
        break label470;
      }
      i8 = courses.hashCode();
      if (school == null) {
        break label476;
      }
      i9 = school.hashCode();
      if (testScores == null) {
        break label482;
      }
      i10 = testScores.hashCode();
      label258:
      if (projects == null) {
        break label488;
      }
    }
    label406:
    label411:
    label416:
    label422:
    label428:
    label434:
    label440:
    label446:
    label452:
    label458:
    label464:
    label470:
    label476:
    label482:
    label488:
    for (int i11 = projects.hashCode();; i11 = 0)
    {
      if (recommendations != null) {
        i12 = recommendations.hashCode();
      }
      i = (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i12;
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
      break label206;
      i8 = 0;
      break label224;
      i9 = 0;
      break label240;
      i10 = 0;
      break label258;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Education");
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
    label180:
    label206:
    label266:
    label292:
    label326:
    label352:
    label386:
    label412:
    label438:
    label559:
    label569:
    label579:
    label604:
    label614:
    label624:
    label634:
    label644:
    label654:
    label664:
    label674:
    label684:
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
        localByteBuffer.putInt(1566654455);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasSchoolUrn) {
            break label559;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(schoolUrn));
          if (!hasSchoolName) {
            break label569;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, schoolName);
          if (!hasTimePeriod) {
            break label604;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label579;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDegreeName) {
            break label614;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, degreeName);
          if (!hasDegreeUrn) {
            break label624;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(degreeUrn));
          if (!hasFieldOfStudy) {
            break label634;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, fieldOfStudy);
          if (!hasFieldOfStudyUrn) {
            break label644;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
          if (!hasActivities) {
            break label654;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, activities);
          if (!hasGrade) {
            break label664;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, grade);
          if (!hasDescription) {
            break label674;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
        }
        Urn localUrn;
        UrnCoercer localUrnCoercer;
        for (;;)
        {
          if (!hasHonors) {
            break label684;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, honors.size());
          localObject = honors.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label180;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label266;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)0);
          break label326;
          localByteBuffer.put((byte)0);
          break label352;
          localByteBuffer.put((byte)0);
          break label386;
          localByteBuffer.put((byte)0);
          break label412;
          localByteBuffer.put((byte)0);
          break label438;
          localByteBuffer.put((byte)0);
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
        if (hasSchool)
        {
          localByteBuffer.put((byte)1);
          if (school._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, school._cachedId);
            school.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (hasTestScores)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, testScores.size());
          localObject = testScores.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localUrn = (Urn)((Iterator)localObject).next();
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
          localByteBuffer.put((byte)1);
          school.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasProjects)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, projects.size());
          localObject = projects.iterator();
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
    
    public Builder() {}
    
    public Builder(Education paramEducation)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Education
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */