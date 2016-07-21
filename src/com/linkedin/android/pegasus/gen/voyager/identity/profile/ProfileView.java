package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Locale;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileView
  implements FissileDataModel<ProfileView>, RecordTemplate<ProfileView>
{
  public static final ProfileViewBuilder BUILDER = ProfileViewBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final CertificationView certificationView;
  public final CourseView courseView;
  public final EducationView educationView;
  public final Urn entityUrn;
  public final boolean hasCertificationView;
  public final boolean hasCourseView;
  public final boolean hasEducationView;
  public final boolean hasEntityUrn;
  public final boolean hasHonorView;
  public final boolean hasLanguageView;
  public final boolean hasOrganizationView;
  public final boolean hasPatentView;
  public final boolean hasPositionView;
  public final boolean hasPrimaryLocale;
  public final boolean hasProfile;
  public final boolean hasProjectView;
  public final boolean hasPublicationView;
  public final boolean hasSkillView;
  public final boolean hasTestScoreView;
  public final boolean hasVolunteerExperienceView;
  public final HonorView honorView;
  public final LanguageView languageView;
  public final OrganizationView organizationView;
  public final PatentView patentView;
  public final PositionView positionView;
  public final Locale primaryLocale;
  public final Profile profile;
  public final ProjectView projectView;
  public final PublicationView publicationView;
  public final SkillView skillView;
  public final TestScoreView testScoreView;
  public final VolunteerExperienceView volunteerExperienceView;
  
  ProfileView(Urn paramUrn, Profile paramProfile, Locale paramLocale, PositionView paramPositionView, EducationView paramEducationView, CertificationView paramCertificationView, CourseView paramCourseView, HonorView paramHonorView, LanguageView paramLanguageView, OrganizationView paramOrganizationView, PatentView paramPatentView, ProjectView paramProjectView, PublicationView paramPublicationView, SkillView paramSkillView, TestScoreView paramTestScoreView, VolunteerExperienceView paramVolunteerExperienceView, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16)
  {
    entityUrn = paramUrn;
    profile = paramProfile;
    primaryLocale = paramLocale;
    positionView = paramPositionView;
    educationView = paramEducationView;
    certificationView = paramCertificationView;
    courseView = paramCourseView;
    honorView = paramHonorView;
    languageView = paramLanguageView;
    organizationView = paramOrganizationView;
    patentView = paramPatentView;
    projectView = paramProjectView;
    publicationView = paramPublicationView;
    skillView = paramSkillView;
    testScoreView = paramTestScoreView;
    volunteerExperienceView = paramVolunteerExperienceView;
    hasEntityUrn = paramBoolean1;
    hasProfile = paramBoolean2;
    hasPrimaryLocale = paramBoolean3;
    hasPositionView = paramBoolean4;
    hasEducationView = paramBoolean5;
    hasCertificationView = paramBoolean6;
    hasCourseView = paramBoolean7;
    hasHonorView = paramBoolean8;
    hasLanguageView = paramBoolean9;
    hasOrganizationView = paramBoolean10;
    hasPatentView = paramBoolean11;
    hasProjectView = paramBoolean12;
    hasPublicationView = paramBoolean13;
    hasSkillView = paramBoolean14;
    hasTestScoreView = paramBoolean15;
    hasVolunteerExperienceView = paramBoolean16;
    paramProfile = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private ProfileView accept(DataProcessor paramDataProcessor)
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
    label179:
    label191:
    Object localObject5;
    boolean bool4;
    label231:
    label243:
    Object localObject6;
    boolean bool5;
    label283:
    label295:
    Object localObject7;
    boolean bool6;
    label335:
    label347:
    Object localObject8;
    boolean bool7;
    label387:
    label399:
    Object localObject9;
    boolean bool8;
    label439:
    label451:
    Object localObject10;
    boolean bool9;
    label491:
    label503:
    Object localObject11;
    boolean bool10;
    label543:
    label555:
    Object localObject12;
    boolean bool11;
    label595:
    label607:
    Object localObject13;
    boolean bool12;
    label647:
    label659:
    Object localObject14;
    boolean bool13;
    label699:
    label711:
    Object localObject15;
    boolean bool14;
    if (hasProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("profile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = profile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label876;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPrimaryLocale)
      {
        paramDataProcessor.startRecordField$505cff1c("primaryLocale");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label885;
        }
        localObject1 = primaryLocale.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label903;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasPositionView)
      {
        paramDataProcessor.startRecordField$505cff1c("positionView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label912;
        }
        localObject1 = positionView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label930;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasEducationView)
      {
        paramDataProcessor.startRecordField$505cff1c("educationView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label940;
        }
        localObject1 = educationView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label958;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasCertificationView)
      {
        paramDataProcessor.startRecordField$505cff1c("certificationView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label968;
        }
        localObject1 = certificationView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label986;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasCourseView)
      {
        paramDataProcessor.startRecordField$505cff1c("courseView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label996;
        }
        localObject1 = courseView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1014;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasHonorView)
      {
        paramDataProcessor.startRecordField$505cff1c("honorView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1024;
        }
        localObject1 = honorView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1042;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      localObject9 = null;
      bool8 = false;
      if (hasLanguageView)
      {
        paramDataProcessor.startRecordField$505cff1c("languageView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1052;
        }
        localObject1 = languageView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1070;
        }
        bool8 = true;
        localObject9 = localObject1;
      }
      localObject10 = null;
      bool9 = false;
      if (hasOrganizationView)
      {
        paramDataProcessor.startRecordField$505cff1c("organizationView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1080;
        }
        localObject1 = organizationView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1098;
        }
        bool9 = true;
        localObject10 = localObject1;
      }
      localObject11 = null;
      bool10 = false;
      if (hasPatentView)
      {
        paramDataProcessor.startRecordField$505cff1c("patentView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1108;
        }
        localObject1 = patentView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1126;
        }
        bool10 = true;
        localObject11 = localObject1;
      }
      localObject12 = null;
      bool11 = false;
      if (hasProjectView)
      {
        paramDataProcessor.startRecordField$505cff1c("projectView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1136;
        }
        localObject1 = projectView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1154;
        }
        bool11 = true;
        localObject12 = localObject1;
      }
      localObject13 = null;
      bool12 = false;
      if (hasPublicationView)
      {
        paramDataProcessor.startRecordField$505cff1c("publicationView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1164;
        }
        localObject1 = publicationView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1182;
        }
        bool12 = true;
        localObject13 = localObject1;
      }
      localObject14 = null;
      bool13 = false;
      if (hasSkillView)
      {
        paramDataProcessor.startRecordField$505cff1c("skillView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1192;
        }
        localObject1 = skillView.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1210;
        }
        bool13 = true;
        localObject14 = localObject1;
      }
      localObject15 = null;
      bool14 = false;
      if (hasTestScoreView)
      {
        paramDataProcessor.startRecordField$505cff1c("testScoreView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1220;
        }
        localObject1 = testScoreView.accept(paramDataProcessor);
        label752:
        if (localObject1 == null) {
          break label1238;
        }
        bool14 = true;
        localObject15 = localObject1;
      }
      label764:
      localObject1 = null;
      bool15 = false;
      if (hasVolunteerExperienceView)
      {
        paramDataProcessor.startRecordField$505cff1c("volunteerExperienceView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1248;
        }
        localObject1 = volunteerExperienceView.accept(paramDataProcessor);
        label805:
        if (localObject1 == null) {
          break label1266;
        }
      }
    }
    label876:
    label885:
    label903:
    label912:
    label930:
    label940:
    label958:
    label968:
    label986:
    label996:
    label1014:
    label1024:
    label1042:
    label1052:
    label1070:
    label1080:
    label1098:
    label1108:
    label1126:
    label1136:
    label1154:
    label1164:
    label1182:
    label1192:
    label1210:
    label1220:
    label1238:
    label1248:
    label1266:
    for (boolean bool15 = true;; bool15 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1608;
      }
      try
      {
        if (hasProfile) {
          break label1272;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "profile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Profile)paramDataProcessor.processDataTemplate(profile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (Locale)paramDataProcessor.processDataTemplate(primaryLocale);
      break label128;
      bool2 = false;
      localObject3 = localObject1;
      break label139;
      localObject1 = (PositionView)paramDataProcessor.processDataTemplate(positionView);
      break label179;
      bool3 = false;
      localObject4 = localObject1;
      break label191;
      localObject1 = (EducationView)paramDataProcessor.processDataTemplate(educationView);
      break label231;
      bool4 = false;
      localObject5 = localObject1;
      break label243;
      localObject1 = (CertificationView)paramDataProcessor.processDataTemplate(certificationView);
      break label283;
      bool5 = false;
      localObject6 = localObject1;
      break label295;
      localObject1 = (CourseView)paramDataProcessor.processDataTemplate(courseView);
      break label335;
      bool6 = false;
      localObject7 = localObject1;
      break label347;
      localObject1 = (HonorView)paramDataProcessor.processDataTemplate(honorView);
      break label387;
      bool7 = false;
      localObject8 = localObject1;
      break label399;
      localObject1 = (LanguageView)paramDataProcessor.processDataTemplate(languageView);
      break label439;
      bool8 = false;
      localObject9 = localObject1;
      break label451;
      localObject1 = (OrganizationView)paramDataProcessor.processDataTemplate(organizationView);
      break label491;
      bool9 = false;
      localObject10 = localObject1;
      break label503;
      localObject1 = (PatentView)paramDataProcessor.processDataTemplate(patentView);
      break label543;
      bool10 = false;
      localObject11 = localObject1;
      break label555;
      localObject1 = (ProjectView)paramDataProcessor.processDataTemplate(projectView);
      break label595;
      bool11 = false;
      localObject12 = localObject1;
      break label607;
      localObject1 = (PublicationView)paramDataProcessor.processDataTemplate(publicationView);
      break label647;
      bool12 = false;
      localObject13 = localObject1;
      break label659;
      localObject1 = (SkillView)paramDataProcessor.processDataTemplate(skillView);
      break label699;
      bool13 = false;
      localObject14 = localObject1;
      break label711;
      localObject1 = (TestScoreView)paramDataProcessor.processDataTemplate(testScoreView);
      break label752;
      bool14 = false;
      localObject15 = localObject1;
      break label764;
      localObject1 = (VolunteerExperienceView)paramDataProcessor.processDataTemplate(volunteerExperienceView);
      break label805;
    }
    label1272:
    if (!hasPositionView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "positionView");
    }
    if (!hasEducationView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "educationView");
    }
    if (!hasCertificationView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "certificationView");
    }
    if (!hasCourseView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "courseView");
    }
    if (!hasHonorView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "honorView");
    }
    if (!hasLanguageView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "languageView");
    }
    if (!hasOrganizationView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "organizationView");
    }
    if (!hasPatentView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "patentView");
    }
    if (!hasProjectView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "projectView");
    }
    if (!hasPublicationView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "publicationView");
    }
    if (!hasSkillView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "skillView");
    }
    if (!hasTestScoreView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "testScoreView");
    }
    if (!hasVolunteerExperienceView) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView", "volunteerExperienceView");
    }
    return new ProfileView(entityUrn, (Profile)localObject2, (Locale)localObject3, (PositionView)localObject4, (EducationView)localObject5, (CertificationView)localObject6, (CourseView)localObject7, (HonorView)localObject8, (LanguageView)localObject9, (OrganizationView)localObject10, (PatentView)localObject11, (ProjectView)localObject12, (PublicationView)localObject13, (SkillView)localObject14, (TestScoreView)localObject15, (VolunteerExperienceView)localObject1, hasEntityUrn, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15);
    label1608:
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
      paramObject = (ProfileView)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (profile != null)
      {
        if (profile.equals(profile)) {}
      }
      else {
        while (profile != null) {
          return false;
        }
      }
      if (primaryLocale != null)
      {
        if (primaryLocale.equals(primaryLocale)) {}
      }
      else {
        while (primaryLocale != null) {
          return false;
        }
      }
      if (positionView != null)
      {
        if (positionView.equals(positionView)) {}
      }
      else {
        while (positionView != null) {
          return false;
        }
      }
      if (educationView != null)
      {
        if (educationView.equals(educationView)) {}
      }
      else {
        while (educationView != null) {
          return false;
        }
      }
      if (certificationView != null)
      {
        if (certificationView.equals(certificationView)) {}
      }
      else {
        while (certificationView != null) {
          return false;
        }
      }
      if (courseView != null)
      {
        if (courseView.equals(courseView)) {}
      }
      else {
        while (courseView != null) {
          return false;
        }
      }
      if (honorView != null)
      {
        if (honorView.equals(honorView)) {}
      }
      else {
        while (honorView != null) {
          return false;
        }
      }
      if (languageView != null)
      {
        if (languageView.equals(languageView)) {}
      }
      else {
        while (languageView != null) {
          return false;
        }
      }
      if (organizationView != null)
      {
        if (organizationView.equals(organizationView)) {}
      }
      else {
        while (organizationView != null) {
          return false;
        }
      }
      if (patentView != null)
      {
        if (patentView.equals(patentView)) {}
      }
      else {
        while (patentView != null) {
          return false;
        }
      }
      if (projectView != null)
      {
        if (projectView.equals(projectView)) {}
      }
      else {
        while (projectView != null) {
          return false;
        }
      }
      if (publicationView != null)
      {
        if (publicationView.equals(publicationView)) {}
      }
      else {
        while (publicationView != null) {
          return false;
        }
      }
      if (skillView != null)
      {
        if (skillView.equals(skillView)) {}
      }
      else {
        while (skillView != null) {
          return false;
        }
      }
      if (testScoreView != null)
      {
        if (testScoreView.equals(testScoreView)) {}
      }
      else {
        while (testScoreView != null) {
          return false;
        }
      }
      if (volunteerExperienceView == null) {
        break;
      }
    } while (volunteerExperienceView.equals(volunteerExperienceView));
    for (;;)
    {
      return false;
      if (volunteerExperienceView == null) {
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
    if (hasProfile)
    {
      i = j + 1;
      if (profile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(profile._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasPrimaryLocale)
      {
        i = j + 1;
        if (primaryLocale._cachedId == null) {
          break label695;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(primaryLocale._cachedId);
      }
      label129:
      j = i + 1;
      i = j;
      if (hasPositionView)
      {
        i = j + 1;
        if (positionView._cachedId == null) {
          break label708;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(positionView._cachedId);
      }
      label171:
      j = i + 1;
      i = j;
      if (hasEducationView)
      {
        i = j + 1;
        if (educationView._cachedId == null) {
          break label721;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(educationView._cachedId);
      }
      label213:
      j = i + 1;
      i = j;
      if (hasCertificationView)
      {
        i = j + 1;
        if (certificationView._cachedId == null) {
          break label734;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(certificationView._cachedId);
      }
      label255:
      j = i + 1;
      i = j;
      if (hasCourseView)
      {
        i = j + 1;
        if (courseView._cachedId == null) {
          break label747;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(courseView._cachedId);
      }
      label297:
      j = i + 1;
      i = j;
      if (hasHonorView)
      {
        i = j + 1;
        if (honorView._cachedId == null) {
          break label760;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(honorView._cachedId);
      }
      label339:
      j = i + 1;
      i = j;
      if (hasLanguageView)
      {
        i = j + 1;
        if (languageView._cachedId == null) {
          break label773;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(languageView._cachedId);
      }
      label381:
      j = i + 1;
      i = j;
      if (hasOrganizationView)
      {
        i = j + 1;
        if (organizationView._cachedId == null) {
          break label786;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(organizationView._cachedId);
      }
      label423:
      j = i + 1;
      i = j;
      if (hasPatentView)
      {
        i = j + 1;
        if (patentView._cachedId == null) {
          break label799;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(patentView._cachedId);
      }
      label465:
      j = i + 1;
      i = j;
      if (hasProjectView)
      {
        i = j + 1;
        if (projectView._cachedId == null) {
          break label812;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(projectView._cachedId);
      }
      label507:
      j = i + 1;
      i = j;
      if (hasPublicationView)
      {
        i = j + 1;
        if (publicationView._cachedId == null) {
          break label825;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(publicationView._cachedId);
      }
      label549:
      j = i + 1;
      i = j;
      if (hasSkillView)
      {
        i = j + 1;
        if (skillView._cachedId == null) {
          break label838;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(skillView._cachedId);
      }
      label591:
      j = i + 1;
      i = j;
      if (hasTestScoreView)
      {
        i = j + 1;
        if (testScoreView._cachedId == null) {
          break label851;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(testScoreView._cachedId);
      }
      label633:
      j = i + 1;
      i = j;
      if (hasVolunteerExperienceView)
      {
        i = j + 1;
        if (volunteerExperienceView._cachedId == null) {
          break label864;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(volunteerExperienceView._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += profile.getSerializedSize();
      break;
      label695:
      i += primaryLocale.getSerializedSize();
      break label129;
      label708:
      i += positionView.getSerializedSize();
      break label171;
      label721:
      i += educationView.getSerializedSize();
      break label213;
      label734:
      i += certificationView.getSerializedSize();
      break label255;
      label747:
      i += courseView.getSerializedSize();
      break label297;
      label760:
      i += honorView.getSerializedSize();
      break label339;
      label773:
      i += languageView.getSerializedSize();
      break label381;
      label786:
      i += organizationView.getSerializedSize();
      break label423;
      label799:
      i += patentView.getSerializedSize();
      break label465;
      label812:
      i += projectView.getSerializedSize();
      break label507;
      label825:
      i += publicationView.getSerializedSize();
      break label549;
      label838:
      i += skillView.getSerializedSize();
      break label591;
      label851:
      i += testScoreView.getSerializedSize();
      break label633;
      label864:
      i += volunteerExperienceView.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i11 = 0;
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
    label204:
    int i8;
    label220:
    int i9;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (profile == null) {
        break label374;
      }
      j = profile.hashCode();
      if (primaryLocale == null) {
        break label379;
      }
      k = primaryLocale.hashCode();
      if (positionView == null) {
        break label384;
      }
      m = positionView.hashCode();
      if (educationView == null) {
        break label390;
      }
      n = educationView.hashCode();
      if (certificationView == null) {
        break label396;
      }
      i1 = certificationView.hashCode();
      if (courseView == null) {
        break label402;
      }
      i2 = courseView.hashCode();
      if (honorView == null) {
        break label408;
      }
      i3 = honorView.hashCode();
      if (languageView == null) {
        break label414;
      }
      i4 = languageView.hashCode();
      if (organizationView == null) {
        break label420;
      }
      i5 = organizationView.hashCode();
      if (patentView == null) {
        break label426;
      }
      i6 = patentView.hashCode();
      if (projectView == null) {
        break label432;
      }
      i7 = projectView.hashCode();
      if (publicationView == null) {
        break label438;
      }
      i8 = publicationView.hashCode();
      if (skillView == null) {
        break label444;
      }
      i9 = skillView.hashCode();
      label236:
      if (testScoreView == null) {
        break label450;
      }
    }
    label374:
    label379:
    label384:
    label390:
    label396:
    label402:
    label408:
    label414:
    label420:
    label426:
    label432:
    label438:
    label444:
    label450:
    for (int i10 = testScoreView.hashCode();; i10 = 0)
    {
      if (volunteerExperienceView != null) {
        i11 = volunteerExperienceView.hashCode();
      }
      i = (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i11;
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
      break label204;
      i8 = 0;
      break label220;
      i9 = 0;
      break label236;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileView");
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
    label326:
    label386:
    label446:
    label506:
    label566:
    label626:
    label686:
    label746:
    label806:
    label866:
    label926:
    label986:
    label1089:
    label1114:
    label1124:
    label1149:
    label1159:
    label1184:
    label1194:
    label1219:
    label1229:
    label1254:
    label1264:
    label1289:
    label1299:
    label1324:
    label1334:
    label1359:
    label1369:
    label1394:
    label1404:
    label1429:
    label1439:
    label1464:
    label1474:
    label1499:
    label1509:
    label1534:
    label1544:
    label1569:
    label1579:
    label1604:
    label1612:
    label1614:
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
        localByteBuffer.putInt(-684098530);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasProfile) {
            break label1114;
          }
          localByteBuffer.put((byte)1);
          if (profile._cachedId == null) {
            break label1089;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, profile._cachedId);
          profile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPrimaryLocale) {
            break label1149;
          }
          localByteBuffer.put((byte)1);
          if (primaryLocale._cachedId == null) {
            break label1124;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, primaryLocale._cachedId);
          primaryLocale.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPositionView) {
            break label1184;
          }
          localByteBuffer.put((byte)1);
          if (positionView._cachedId == null) {
            break label1159;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, positionView._cachedId);
          positionView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEducationView) {
            break label1219;
          }
          localByteBuffer.put((byte)1);
          if (educationView._cachedId == null) {
            break label1194;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, educationView._cachedId);
          educationView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCertificationView) {
            break label1254;
          }
          localByteBuffer.put((byte)1);
          if (certificationView._cachedId == null) {
            break label1229;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, certificationView._cachedId);
          certificationView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCourseView) {
            break label1289;
          }
          localByteBuffer.put((byte)1);
          if (courseView._cachedId == null) {
            break label1264;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, courseView._cachedId);
          courseView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHonorView) {
            break label1324;
          }
          localByteBuffer.put((byte)1);
          if (honorView._cachedId == null) {
            break label1299;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, honorView._cachedId);
          honorView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLanguageView) {
            break label1359;
          }
          localByteBuffer.put((byte)1);
          if (languageView._cachedId == null) {
            break label1334;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, languageView._cachedId);
          languageView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasOrganizationView) {
            break label1394;
          }
          localByteBuffer.put((byte)1);
          if (organizationView._cachedId == null) {
            break label1369;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, organizationView._cachedId);
          organizationView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPatentView) {
            break label1429;
          }
          localByteBuffer.put((byte)1);
          if (patentView._cachedId == null) {
            break label1404;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, patentView._cachedId);
          patentView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasProjectView) {
            break label1464;
          }
          localByteBuffer.put((byte)1);
          if (projectView._cachedId == null) {
            break label1439;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, projectView._cachedId);
          projectView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPublicationView) {
            break label1499;
          }
          localByteBuffer.put((byte)1);
          if (publicationView._cachedId == null) {
            break label1474;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, publicationView._cachedId);
          publicationView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSkillView) {
            break label1534;
          }
          localByteBuffer.put((byte)1);
          if (skillView._cachedId == null) {
            break label1509;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, skillView._cachedId);
          skillView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTestScoreView) {
            break label1569;
          }
          localByteBuffer.put((byte)1);
          if (testScoreView._cachedId == null) {
            break label1544;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, testScoreView._cachedId);
          testScoreView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasVolunteerExperienceView) {
            break label1604;
          }
          localByteBuffer.put((byte)1);
          if (volunteerExperienceView._cachedId == null) {
            break label1579;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, volunteerExperienceView._cachedId);
          volunteerExperienceView.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1612;
          }
          if (str != null) {
            break label1614;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          profile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label206;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)1);
          primaryLocale.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label266;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)1);
          positionView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label326;
          localByteBuffer.put((byte)0);
          break label326;
          localByteBuffer.put((byte)1);
          educationView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label386;
          localByteBuffer.put((byte)0);
          break label386;
          localByteBuffer.put((byte)1);
          certificationView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label446;
          localByteBuffer.put((byte)0);
          break label446;
          localByteBuffer.put((byte)1);
          courseView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label506;
          localByteBuffer.put((byte)0);
          break label506;
          localByteBuffer.put((byte)1);
          honorView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label566;
          localByteBuffer.put((byte)0);
          break label566;
          localByteBuffer.put((byte)1);
          languageView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label626;
          localByteBuffer.put((byte)0);
          break label626;
          localByteBuffer.put((byte)1);
          organizationView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label686;
          localByteBuffer.put((byte)0);
          break label686;
          localByteBuffer.put((byte)1);
          patentView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label746;
          localByteBuffer.put((byte)0);
          break label746;
          localByteBuffer.put((byte)1);
          projectView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label806;
          localByteBuffer.put((byte)0);
          break label806;
          localByteBuffer.put((byte)1);
          publicationView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label866;
          localByteBuffer.put((byte)0);
          break label866;
          localByteBuffer.put((byte)1);
          skillView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label926;
          localByteBuffer.put((byte)0);
          break label926;
          localByteBuffer.put((byte)1);
          testScoreView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label986;
          localByteBuffer.put((byte)0);
          break label986;
          localByteBuffer.put((byte)1);
          volunteerExperienceView.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */