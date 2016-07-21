package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.common.EntityInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class School
  implements FissileDataModel<School>, RecordTemplate<School>
{
  public static final SchoolBuilder BUILDER = SchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String address;
  public final float admittedPercentage;
  public final BasicSchoolInfo basicSchoolInfo;
  public final String description;
  public final String emailAddress;
  public final EntityInfo entityInfo;
  public final Urn entityUrn;
  public final float femaleStudentPercentage;
  public final boolean financialAidAvailable;
  public final float financialAidPercentage;
  public final float graduationPercentage;
  public final boolean hasAddress;
  public final boolean hasAdmittedPercentage;
  public final boolean hasBasicSchoolInfo;
  public final boolean hasDescription;
  public final boolean hasEmailAddress;
  public final boolean hasEntityInfo;
  public final boolean hasEntityUrn;
  public final boolean hasFemaleStudentPercentage;
  public final boolean hasFinancialAidAvailable;
  public final boolean hasFinancialAidPercentage;
  public final boolean hasGraduationPercentage;
  public final boolean hasHeroImage;
  public final boolean hasHomepageUrl;
  public final boolean hasInStateTuition;
  public final boolean hasMaleStudentPercentage;
  public final boolean hasNumberOfFaculty;
  public final boolean hasNumberOfGradStudents;
  public final boolean hasNumberOfStudentsAndAlumni;
  public final boolean hasNumberOfUndergradStudents;
  public final boolean hasOutOfStateTuition;
  public final boolean hasPhoneNumber;
  public final boolean hasSchoolType;
  public final boolean hasSections;
  public final boolean hasStudentFacultyRatio;
  public final boolean hasTotalPopulation;
  public final boolean hasYearLevel;
  public final Image heroImage;
  public final String homepageUrl;
  public final String inStateTuition;
  public final float maleStudentPercentage;
  public final int numberOfFaculty;
  public final int numberOfGradStudents;
  public final int numberOfStudentsAndAlumni;
  public final int numberOfUndergradStudents;
  public final String outOfStateTuition;
  public final PhoneNumber phoneNumber;
  public final String schoolType;
  public final SchoolSections sections;
  public final float studentFacultyRatio;
  public final int totalPopulation;
  public final String yearLevel;
  
  School(Urn paramUrn, BasicSchoolInfo paramBasicSchoolInfo, Image paramImage, String paramString1, int paramInt1, String paramString2, String paramString3, PhoneNumber paramPhoneNumber, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean1, float paramFloat6, String paramString7, String paramString8, SchoolSections paramSchoolSections, EntityInfo paramEntityInfo, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21, boolean paramBoolean22, boolean paramBoolean23, boolean paramBoolean24, boolean paramBoolean25, boolean paramBoolean26, boolean paramBoolean27)
  {
    entityUrn = paramUrn;
    basicSchoolInfo = paramBasicSchoolInfo;
    heroImage = paramImage;
    description = paramString1;
    numberOfStudentsAndAlumni = paramInt1;
    homepageUrl = paramString2;
    emailAddress = paramString3;
    phoneNumber = paramPhoneNumber;
    schoolType = paramString4;
    address = paramString5;
    yearLevel = paramString6;
    numberOfUndergradStudents = paramInt2;
    numberOfGradStudents = paramInt3;
    numberOfFaculty = paramInt4;
    totalPopulation = paramInt5;
    maleStudentPercentage = paramFloat1;
    femaleStudentPercentage = paramFloat2;
    admittedPercentage = paramFloat3;
    graduationPercentage = paramFloat4;
    studentFacultyRatio = paramFloat5;
    financialAidAvailable = paramBoolean1;
    financialAidPercentage = paramFloat6;
    inStateTuition = paramString7;
    outOfStateTuition = paramString8;
    sections = paramSchoolSections;
    entityInfo = paramEntityInfo;
    hasEntityUrn = paramBoolean2;
    hasBasicSchoolInfo = paramBoolean3;
    hasHeroImage = paramBoolean4;
    hasDescription = paramBoolean5;
    hasNumberOfStudentsAndAlumni = paramBoolean6;
    hasHomepageUrl = paramBoolean7;
    hasEmailAddress = paramBoolean8;
    hasPhoneNumber = paramBoolean9;
    hasSchoolType = paramBoolean10;
    hasAddress = paramBoolean11;
    hasYearLevel = paramBoolean12;
    hasNumberOfUndergradStudents = paramBoolean13;
    hasNumberOfGradStudents = paramBoolean14;
    hasNumberOfFaculty = paramBoolean15;
    hasTotalPopulation = paramBoolean16;
    hasMaleStudentPercentage = paramBoolean17;
    hasFemaleStudentPercentage = paramBoolean18;
    hasAdmittedPercentage = paramBoolean19;
    hasGraduationPercentage = paramBoolean20;
    hasStudentFacultyRatio = paramBoolean21;
    hasFinancialAidAvailable = paramBoolean22;
    hasFinancialAidPercentage = paramBoolean23;
    hasInStateTuition = paramBoolean24;
    hasOutOfStateTuition = paramBoolean25;
    hasSections = paramBoolean26;
    hasEntityInfo = paramBoolean27;
    paramBasicSchoolInfo = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private School accept(DataProcessor paramDataProcessor)
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
    Object localObject2 = null;
    boolean bool1 = false;
    label89:
    Object localObject3;
    boolean bool2;
    label128:
    label139:
    Object localObject4;
    boolean bool3;
    label279:
    label291:
    Object localObject5;
    boolean bool4;
    if (hasBasicSchoolInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("basicSchoolInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = basicSchoolInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label872;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasHeroImage)
      {
        paramDataProcessor.startRecordField$505cff1c("heroImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label881;
        }
        localObject1 = heroImage.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label899;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      if (hasNumberOfStudentsAndAlumni)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfStudentsAndAlumni");
        paramDataProcessor.processInt(numberOfStudentsAndAlumni);
      }
      if (hasHomepageUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("homepageUrl");
        paramDataProcessor.processString(homepageUrl);
      }
      if (hasEmailAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("emailAddress");
        paramDataProcessor.processString(emailAddress);
      }
      localObject4 = null;
      bool3 = false;
      if (hasPhoneNumber)
      {
        paramDataProcessor.startRecordField$505cff1c("phoneNumber");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label908;
        }
        localObject1 = phoneNumber.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label926;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasSchoolType)
      {
        paramDataProcessor.startRecordField$505cff1c("schoolType");
        paramDataProcessor.processString(schoolType);
      }
      if (hasAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("address");
        paramDataProcessor.processString(address);
      }
      if (hasYearLevel)
      {
        paramDataProcessor.startRecordField$505cff1c("yearLevel");
        paramDataProcessor.processString(yearLevel);
      }
      if (hasNumberOfUndergradStudents)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfUndergradStudents");
        paramDataProcessor.processInt(numberOfUndergradStudents);
      }
      if (hasNumberOfGradStudents)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfGradStudents");
        paramDataProcessor.processInt(numberOfGradStudents);
      }
      if (hasNumberOfFaculty)
      {
        paramDataProcessor.startRecordField$505cff1c("numberOfFaculty");
        paramDataProcessor.processInt(numberOfFaculty);
      }
      if (hasTotalPopulation)
      {
        paramDataProcessor.startRecordField$505cff1c("totalPopulation");
        paramDataProcessor.processInt(totalPopulation);
      }
      if (hasMaleStudentPercentage)
      {
        paramDataProcessor.startRecordField$505cff1c("maleStudentPercentage");
        paramDataProcessor.processFloat(maleStudentPercentage);
      }
      if (hasFemaleStudentPercentage)
      {
        paramDataProcessor.startRecordField$505cff1c("femaleStudentPercentage");
        paramDataProcessor.processFloat(femaleStudentPercentage);
      }
      if (hasAdmittedPercentage)
      {
        paramDataProcessor.startRecordField$505cff1c("admittedPercentage");
        paramDataProcessor.processFloat(admittedPercentage);
      }
      if (hasGraduationPercentage)
      {
        paramDataProcessor.startRecordField$505cff1c("graduationPercentage");
        paramDataProcessor.processFloat(graduationPercentage);
      }
      if (hasStudentFacultyRatio)
      {
        paramDataProcessor.startRecordField$505cff1c("studentFacultyRatio");
        paramDataProcessor.processFloat(studentFacultyRatio);
      }
      if (hasFinancialAidAvailable)
      {
        paramDataProcessor.startRecordField$505cff1c("financialAidAvailable");
        paramDataProcessor.processBoolean(financialAidAvailable);
      }
      if (hasFinancialAidPercentage)
      {
        paramDataProcessor.startRecordField$505cff1c("financialAidPercentage");
        paramDataProcessor.processFloat(financialAidPercentage);
      }
      if (hasInStateTuition)
      {
        paramDataProcessor.startRecordField$505cff1c("inStateTuition");
        paramDataProcessor.processString(inStateTuition);
      }
      if (hasOutOfStateTuition)
      {
        paramDataProcessor.startRecordField$505cff1c("outOfStateTuition");
        paramDataProcessor.processString(outOfStateTuition);
      }
      localObject5 = null;
      bool4 = false;
      if (hasSections)
      {
        paramDataProcessor.startRecordField$505cff1c("sections");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label936;
        }
        localObject1 = sections.accept(paramDataProcessor);
        label748:
        if (localObject1 == null) {
          break label954;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label760:
      localObject1 = null;
      bool5 = false;
      if (hasEntityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("entityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label964;
        }
        localObject1 = entityInfo.accept(paramDataProcessor);
        label801:
        if (localObject1 == null) {
          break label982;
        }
      }
    }
    label872:
    label881:
    label899:
    label908:
    label926:
    label936:
    label954:
    label964:
    label982:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1203;
      }
      try
      {
        if (hasBasicSchoolInfo) {
          break label988;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.School", "basicSchoolInfo");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (BasicSchoolInfo)paramDataProcessor.processDataTemplate(basicSchoolInfo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(heroImage);
      break label128;
      bool2 = false;
      localObject3 = localObject1;
      break label139;
      localObject1 = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumber);
      break label279;
      bool3 = false;
      localObject4 = localObject1;
      break label291;
      localObject1 = (SchoolSections)paramDataProcessor.processDataTemplate(sections);
      break label748;
      bool4 = false;
      localObject5 = localObject1;
      break label760;
      localObject1 = (EntityInfo)paramDataProcessor.processDataTemplate(entityInfo);
      break label801;
    }
    label988:
    if (!hasEntityInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.School", "entityInfo");
    }
    return new School(entityUrn, (BasicSchoolInfo)localObject2, (Image)localObject3, description, numberOfStudentsAndAlumni, homepageUrl, emailAddress, (PhoneNumber)localObject4, schoolType, address, yearLevel, numberOfUndergradStudents, numberOfGradStudents, numberOfFaculty, totalPopulation, maleStudentPercentage, femaleStudentPercentage, admittedPercentage, graduationPercentage, studentFacultyRatio, financialAidAvailable, financialAidPercentage, inStateTuition, outOfStateTuition, (SchoolSections)localObject5, (EntityInfo)localObject1, hasEntityUrn, bool1, bool2, hasDescription, hasNumberOfStudentsAndAlumni, hasHomepageUrl, hasEmailAddress, bool3, hasSchoolType, hasAddress, hasYearLevel, hasNumberOfUndergradStudents, hasNumberOfGradStudents, hasNumberOfFaculty, hasTotalPopulation, hasMaleStudentPercentage, hasFemaleStudentPercentage, hasAdmittedPercentage, hasGraduationPercentage, hasStudentFacultyRatio, hasFinancialAidAvailable, hasFinancialAidPercentage, hasInStateTuition, hasOutOfStateTuition, bool4, bool5);
    label1203:
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
      paramObject = (School)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (basicSchoolInfo != null)
      {
        if (basicSchoolInfo.equals(basicSchoolInfo)) {}
      }
      else {
        while (basicSchoolInfo != null) {
          return false;
        }
      }
      if (heroImage != null)
      {
        if (heroImage.equals(heroImage)) {}
      }
      else {
        while (heroImage != null) {
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
      if (numberOfStudentsAndAlumni != numberOfStudentsAndAlumni) {
        return false;
      }
      if (homepageUrl != null)
      {
        if (homepageUrl.equals(homepageUrl)) {}
      }
      else {
        while (homepageUrl != null) {
          return false;
        }
      }
      if (emailAddress != null)
      {
        if (emailAddress.equals(emailAddress)) {}
      }
      else {
        while (emailAddress != null) {
          return false;
        }
      }
      if (phoneNumber != null)
      {
        if (phoneNumber.equals(phoneNumber)) {}
      }
      else {
        while (phoneNumber != null) {
          return false;
        }
      }
      if (schoolType != null)
      {
        if (schoolType.equals(schoolType)) {}
      }
      else {
        while (schoolType != null) {
          return false;
        }
      }
      if (address != null)
      {
        if (address.equals(address)) {}
      }
      else {
        while (address != null) {
          return false;
        }
      }
      if (yearLevel != null)
      {
        if (yearLevel.equals(yearLevel)) {}
      }
      else {
        while (yearLevel != null) {
          return false;
        }
      }
      if (numberOfUndergradStudents != numberOfUndergradStudents) {
        return false;
      }
      if (numberOfGradStudents != numberOfGradStudents) {
        return false;
      }
      if (numberOfFaculty != numberOfFaculty) {
        return false;
      }
      if (totalPopulation != totalPopulation) {
        return false;
      }
      if (maleStudentPercentage != maleStudentPercentage) {
        return false;
      }
      if (femaleStudentPercentage != femaleStudentPercentage) {
        return false;
      }
      if (admittedPercentage != admittedPercentage) {
        return false;
      }
      if (graduationPercentage != graduationPercentage) {
        return false;
      }
      if (studentFacultyRatio != studentFacultyRatio) {
        return false;
      }
      if (financialAidAvailable != financialAidAvailable) {
        return false;
      }
      if (financialAidPercentage != financialAidPercentage) {
        return false;
      }
      if (inStateTuition != null)
      {
        if (inStateTuition.equals(inStateTuition)) {}
      }
      else {
        while (inStateTuition != null) {
          return false;
        }
      }
      if (outOfStateTuition != null)
      {
        if (outOfStateTuition.equals(outOfStateTuition)) {}
      }
      else {
        while (outOfStateTuition != null) {
          return false;
        }
      }
      if (sections != null)
      {
        if (sections.equals(sections)) {}
      }
      else {
        while (sections != null) {
          return false;
        }
      }
      if (entityInfo == null) {
        break;
      }
    } while (entityInfo.equals(entityInfo));
    for (;;)
    {
      return false;
      if (entityInfo == null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBasicSchoolInfo)
    {
      i = j + 1;
      if (basicSchoolInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(basicSchoolInfo._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasHeroImage)
      {
        i = j + 1;
        if (heroImage._cachedId == null) {
          break label679;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(heroImage._cachedId);
      }
      label129:
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      j = i + 1;
      i = j;
      if (hasNumberOfStudentsAndAlumni) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasHomepageUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(homepageUrl);
      }
      j = i + 1;
      i = j;
      if (hasEmailAddress) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(emailAddress);
      }
      j = i + 1;
      i = j;
      if (hasPhoneNumber)
      {
        i = j + 1;
        if (phoneNumber._cachedId == null) {
          break label692;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneNumber._cachedId);
      }
      label263:
      j = i + 1;
      i = j;
      if (hasSchoolType) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(schoolType);
      }
      j = i + 1;
      i = j;
      if (hasAddress) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(address);
      }
      j = i + 1;
      i = j;
      if (hasYearLevel) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(yearLevel);
      }
      j = i + 1;
      i = j;
      if (hasNumberOfUndergradStudents) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasNumberOfGradStudents) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasNumberOfFaculty) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasTotalPopulation) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasMaleStudentPercentage) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasFemaleStudentPercentage) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasAdmittedPercentage) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasGraduationPercentage) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasStudentFacultyRatio) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasFinancialAidAvailable) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasFinancialAidPercentage) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasInStateTuition) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(inStateTuition);
      }
      j = i + 1;
      i = j;
      if (hasOutOfStateTuition) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(outOfStateTuition);
      }
      j = i + 1;
      i = j;
      if (hasSections)
      {
        i = j + 1;
        if (sections._cachedId == null) {
          break label705;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sections._cachedId);
      }
      label617:
      j = i + 1;
      i = j;
      if (hasEntityInfo)
      {
        i = j + 1;
        if (entityInfo._cachedId == null) {
          break label718;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entityInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += basicSchoolInfo.getSerializedSize();
      break;
      label679:
      i += heroImage.getSerializedSize();
      break label129;
      label692:
      i += phoneNumber.getSerializedSize();
      break label263;
      label705:
      i += sections.getSerializedSize();
      break label617;
      label718:
      i += entityInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i16 = 0;
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
    int i17;
    int n;
    label98:
    int i1;
    label114:
    int i2;
    label130:
    int i3;
    label146:
    int i4;
    label162:
    int i5;
    label178:
    int i18;
    int i19;
    int i20;
    int i21;
    int i6;
    label220:
    int i7;
    label238:
    int i8;
    label256:
    int i9;
    label274:
    int i10;
    label292:
    int i11;
    label302:
    int i12;
    label320:
    int i13;
    label336:
    int i14;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (basicSchoolInfo == null) {
        break label550;
      }
      j = basicSchoolInfo.hashCode();
      if (heroImage == null) {
        break label555;
      }
      k = heroImage.hashCode();
      if (description == null) {
        break label560;
      }
      m = description.hashCode();
      i17 = numberOfStudentsAndAlumni;
      if (homepageUrl == null) {
        break label566;
      }
      n = homepageUrl.hashCode();
      if (emailAddress == null) {
        break label572;
      }
      i1 = emailAddress.hashCode();
      if (phoneNumber == null) {
        break label578;
      }
      i2 = phoneNumber.hashCode();
      if (schoolType == null) {
        break label584;
      }
      i3 = schoolType.hashCode();
      if (address == null) {
        break label590;
      }
      i4 = address.hashCode();
      if (yearLevel == null) {
        break label596;
      }
      i5 = yearLevel.hashCode();
      i18 = numberOfUndergradStudents;
      i19 = numberOfGradStudents;
      i20 = numberOfFaculty;
      i21 = totalPopulation;
      if (maleStudentPercentage == 0.0F) {
        break label602;
      }
      i6 = Float.floatToIntBits(maleStudentPercentage);
      if (femaleStudentPercentage == 0.0F) {
        break label608;
      }
      i7 = Float.floatToIntBits(femaleStudentPercentage);
      if (admittedPercentage == 0.0F) {
        break label614;
      }
      i8 = Float.floatToIntBits(admittedPercentage);
      if (graduationPercentage == 0.0F) {
        break label620;
      }
      i9 = Float.floatToIntBits(graduationPercentage);
      if (studentFacultyRatio == 0.0F) {
        break label626;
      }
      i10 = Float.floatToIntBits(studentFacultyRatio);
      if (!financialAidAvailable) {
        break label632;
      }
      i11 = 1;
      if (financialAidPercentage == 0.0F) {
        break label638;
      }
      i12 = Float.floatToIntBits(financialAidPercentage);
      if (inStateTuition == null) {
        break label644;
      }
      i13 = inStateTuition.hashCode();
      if (outOfStateTuition == null) {
        break label650;
      }
      i14 = outOfStateTuition.hashCode();
      label352:
      if (sections == null) {
        break label656;
      }
    }
    label550:
    label555:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    label596:
    label602:
    label608:
    label614:
    label620:
    label626:
    label632:
    label638:
    label644:
    label650:
    label656:
    for (int i15 = sections.hashCode();; i15 = 0)
    {
      if (entityInfo != null) {
        i16 = entityInfo.hashCode();
      }
      i = (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (((((i5 + (i4 + (i3 + (i2 + (i1 + (n + ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i17) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i16;
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
      break label98;
      i1 = 0;
      break label114;
      i2 = 0;
      break label130;
      i3 = 0;
      break label146;
      i4 = 0;
      break label162;
      i5 = 0;
      break label178;
      i6 = 0;
      break label220;
      i7 = 0;
      break label238;
      i8 = 0;
      break label256;
      i9 = 0;
      break label274;
      i10 = 0;
      break label292;
      i11 = 0;
      break label302;
      i12 = 0;
      break label320;
      i13 = 0;
      break label336;
      i14 = 0;
      break label352;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building School");
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
    label206:
    label266:
    label292:
    label316:
    label342:
    label368:
    label428:
    label454:
    label480:
    label506:
    label530:
    label554:
    label578:
    label602:
    label626:
    label650:
    label674:
    label698:
    label722:
    label746:
    label755:
    label779:
    label805:
    label831:
    label891:
    label994:
    label1019:
    label1029:
    label1054:
    label1064:
    label1074:
    label1084:
    label1094:
    label1104:
    label1129:
    label1139:
    label1149:
    label1159:
    label1169:
    label1179:
    label1189:
    label1199:
    label1209:
    label1219:
    label1229:
    label1239:
    label1249:
    label1259:
    label1265:
    label1275:
    label1285:
    label1295:
    label1305:
    label1330:
    label1340:
    label1365:
    label1373:
    label1375:
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
        localByteBuffer.putInt(-1012799001);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasBasicSchoolInfo) {
            break label1019;
          }
          localByteBuffer.put((byte)1);
          if (basicSchoolInfo._cachedId == null) {
            break label994;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, basicSchoolInfo._cachedId);
          basicSchoolInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeroImage) {
            break label1054;
          }
          localByteBuffer.put((byte)1);
          if (heroImage._cachedId == null) {
            break label1029;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, heroImage._cachedId);
          heroImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label1064;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasNumberOfStudentsAndAlumni) {
            break label1074;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfStudentsAndAlumni);
          if (!hasHomepageUrl) {
            break label1084;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, homepageUrl);
          if (!hasEmailAddress) {
            break label1094;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, emailAddress);
          if (!hasPhoneNumber) {
            break label1129;
          }
          localByteBuffer.put((byte)1);
          if (phoneNumber._cachedId == null) {
            break label1104;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, phoneNumber._cachedId);
          phoneNumber.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSchoolType) {
            break label1139;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, schoolType);
          if (!hasAddress) {
            break label1149;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address);
          if (!hasYearLevel) {
            break label1159;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, yearLevel);
          if (!hasNumberOfUndergradStudents) {
            break label1169;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfUndergradStudents);
          if (!hasNumberOfGradStudents) {
            break label1179;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfGradStudents);
          if (!hasNumberOfFaculty) {
            break label1189;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numberOfFaculty);
          if (!hasTotalPopulation) {
            break label1199;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalPopulation);
          if (!hasMaleStudentPercentage) {
            break label1209;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(maleStudentPercentage);
          if (!hasFemaleStudentPercentage) {
            break label1219;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(femaleStudentPercentage);
          if (!hasAdmittedPercentage) {
            break label1229;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(admittedPercentage);
          if (!hasGraduationPercentage) {
            break label1239;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(graduationPercentage);
          if (!hasStudentFacultyRatio) {
            break label1249;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(studentFacultyRatio);
          if (!hasFinancialAidAvailable) {
            break label1265;
          }
          localByteBuffer.put((byte)1);
          if (!financialAidAvailable) {
            break label1259;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasFinancialAidPercentage) {
            break label1275;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(financialAidPercentage);
          if (!hasInStateTuition) {
            break label1285;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, inStateTuition);
          if (!hasOutOfStateTuition) {
            break label1295;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, outOfStateTuition);
          if (!hasSections) {
            break label1330;
          }
          localByteBuffer.put((byte)1);
          if (sections._cachedId == null) {
            break label1305;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sections._cachedId);
          sections.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEntityInfo) {
            break label1365;
          }
          localByteBuffer.put((byte)1);
          if (entityInfo._cachedId == null) {
            break label1340;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, entityInfo._cachedId);
          entityInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1373;
          }
          if (str != null) {
            break label1375;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          basicSchoolInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label206;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)1);
          heroImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label266;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)0);
          break label316;
          localByteBuffer.put((byte)0);
          break label342;
          localByteBuffer.put((byte)0);
          break label368;
          localByteBuffer.put((byte)1);
          phoneNumber.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label428;
          localByteBuffer.put((byte)0);
          break label428;
          localByteBuffer.put((byte)0);
          break label454;
          localByteBuffer.put((byte)0);
          break label480;
          localByteBuffer.put((byte)0);
          break label506;
          localByteBuffer.put((byte)0);
          break label530;
          localByteBuffer.put((byte)0);
          break label554;
          localByteBuffer.put((byte)0);
          break label578;
          localByteBuffer.put((byte)0);
          break label602;
          localByteBuffer.put((byte)0);
          break label626;
          localByteBuffer.put((byte)0);
          break label650;
          localByteBuffer.put((byte)0);
          break label674;
          localByteBuffer.put((byte)0);
          break label698;
          localByteBuffer.put((byte)0);
          break label722;
          i = 0;
          break label746;
          localByteBuffer.put((byte)0);
          break label755;
          localByteBuffer.put((byte)0);
          break label779;
          localByteBuffer.put((byte)0);
          break label805;
          localByteBuffer.put((byte)0);
          break label831;
          localByteBuffer.put((byte)1);
          sections.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label891;
          localByteBuffer.put((byte)0);
          break label891;
          localByteBuffer.put((byte)1);
          entityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.School
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */