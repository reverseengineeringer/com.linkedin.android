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
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormEducation
  implements FissileDataModel<NormEducation>, RecordTemplate<NormEducation>
{
  public static final NormEducationBuilder BUILDER = NormEducationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String activities;
  public final String degreeName;
  public final Urn degreeUrn;
  public final String description;
  public final Urn entityUrn;
  public final String fieldOfStudy;
  public final Urn fieldOfStudyUrn;
  public final String grade;
  public final boolean hasActivities;
  public final boolean hasDegreeName;
  public final boolean hasDegreeUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasFieldOfStudy;
  public final boolean hasFieldOfStudyUrn;
  public final boolean hasGrade;
  public final boolean hasSchoolName;
  public final boolean hasSchoolUrn;
  public final boolean hasTimePeriod;
  public final String schoolName;
  public final Urn schoolUrn;
  public final DateRange timePeriod;
  
  NormEducation(Urn paramUrn1, Urn paramUrn2, String paramString1, DateRange paramDateRange, String paramString2, Urn paramUrn3, String paramString3, Urn paramUrn4, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
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
    paramUrn2 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final NormEducation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasSchoolUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("schoolUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(schoolUrn));
    }
    if (hasSchoolName)
    {
      paramDataProcessor.startRecordField$505cff1c("schoolName");
      paramDataProcessor.processString(schoolName);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label434;
      }
      localObject = timePeriod.accept(paramDataProcessor);
      if (localObject == null) {
        break label451;
      }
    }
    label434:
    label451:
    for (bool = true;; bool = false)
    {
      if (hasDegreeName)
      {
        paramDataProcessor.startRecordField$505cff1c("degreeName");
        paramDataProcessor.processString(degreeName);
      }
      UrnCoercer localUrnCoercer;
      if (hasDegreeUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("degreeUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
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
        localUrnCoercer = UrnCoercer.INSTANCE;
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
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label456;
      }
      return new NormEducation(entityUrn, schoolUrn, schoolName, (DateRange)localObject, degreeName, degreeUrn, fieldOfStudy, fieldOfStudyUrn, activities, grade, description, hasEntityUrn, hasSchoolUrn, hasSchoolName, bool, hasDegreeName, hasDegreeUrn, hasFieldOfStudy, hasFieldOfStudyUrn, hasActivities, hasGrade, hasDescription);
      localObject = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
    }
    label456:
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
      paramObject = (NormEducation)paramObject;
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
      if (description == null) {
        break;
      }
    } while (description.equals(description));
    for (;;)
    {
      return false;
      if (description == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSchoolUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
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
        break label340;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
    }
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
        localUrnCoercer = UrnCoercer.INSTANCE;
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
        localUrnCoercer = UrnCoercer.INSTANCE;
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
      __sizeOfObject = i;
      return i;
      label340:
      i += timePeriod.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (schoolUrn == null) {
        break label264;
      }
      j = schoolUrn.hashCode();
      if (schoolName == null) {
        break label269;
      }
      k = schoolName.hashCode();
      if (timePeriod == null) {
        break label274;
      }
      m = timePeriod.hashCode();
      if (degreeName == null) {
        break label280;
      }
      n = degreeName.hashCode();
      if (degreeUrn == null) {
        break label286;
      }
      i1 = degreeUrn.hashCode();
      if (fieldOfStudy == null) {
        break label292;
      }
      i2 = fieldOfStudy.hashCode();
      if (fieldOfStudyUrn == null) {
        break label298;
      }
      i3 = fieldOfStudyUrn.hashCode();
      if (activities == null) {
        break label304;
      }
      i4 = activities.hashCode();
      label156:
      if (grade == null) {
        break label310;
      }
    }
    label264:
    label269:
    label274:
    label280:
    label286:
    label292:
    label298:
    label304:
    label310:
    for (int i5 = grade.hashCode();; i5 = 0)
    {
      if (description != null) {
        i6 = description.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormEducation");
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
    label178:
    label204:
    label264:
    label290:
    label324:
    label350:
    label384:
    label410:
    label436:
    label505:
    label515:
    label525:
    label550:
    label560:
    label570:
    label580:
    label590:
    label600:
    label610:
    label620:
    label628:
    label630:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1872910292);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasSchoolUrn) {
            break label505;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(schoolUrn));
          if (!hasSchoolName) {
            break label515;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, schoolName);
          if (!hasTimePeriod) {
            break label550;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label525;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDegreeName) {
            break label560;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, degreeName);
          if (!hasDegreeUrn) {
            break label570;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(degreeUrn));
          if (!hasFieldOfStudy) {
            break label580;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, fieldOfStudy);
          if (!hasFieldOfStudyUrn) {
            break label590;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(fieldOfStudyUrn));
          if (!hasActivities) {
            break label600;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, activities);
          if (!hasGrade) {
            break label610;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, grade);
          if (!hasDescription) {
            break label620;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label628;
          }
          if (str != null) {
            break label630;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label178;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)1);
          timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label264;
          localByteBuffer.put((byte)0);
          break label264;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)0);
          break label324;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)0);
          break label384;
          localByteBuffer.put((byte)0);
          break label410;
          localByteBuffer.put((byte)0);
          break label436;
          localByteBuffer.put((byte)0);
        }
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
    
    public Builder() {}
    
    public Builder(NormEducation paramNormEducation)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */