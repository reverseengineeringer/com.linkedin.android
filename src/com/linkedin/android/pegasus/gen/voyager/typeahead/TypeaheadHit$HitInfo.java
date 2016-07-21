package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TypeaheadHit$HitInfo
  implements FissileDataModel<HitInfo>, UnionTemplate<HitInfo>
{
  public static final TypeaheadHitBuilder.HitInfoBuilder BUILDER = TypeaheadHitBuilder.HitInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasTypeaheadAutoCompleteValue;
  public final boolean hasTypeaheadCityValue;
  public final boolean hasTypeaheadCompanyValue;
  public final boolean hasTypeaheadCountryValue;
  public final boolean hasTypeaheadDegreeValue;
  public final boolean hasTypeaheadFieldOfStudyValue;
  public final boolean hasTypeaheadGroupValue;
  public final boolean hasTypeaheadIndustryValue;
  public final boolean hasTypeaheadPostalCodeValue;
  public final boolean hasTypeaheadProfileValue;
  public final boolean hasTypeaheadRegionValue;
  public final boolean hasTypeaheadSchoolValue;
  public final boolean hasTypeaheadShowcaseValue;
  public final boolean hasTypeaheadSiteFeatureValue;
  public final boolean hasTypeaheadSkillValue;
  public final boolean hasTypeaheadStateValue;
  public final boolean hasTypeaheadSuggestionValue;
  public final boolean hasTypeaheadTitleValue;
  public final TypeaheadAutoComplete typeaheadAutoCompleteValue;
  public final TypeaheadCity typeaheadCityValue;
  public final TypeaheadCompany typeaheadCompanyValue;
  public final TypeaheadCountry typeaheadCountryValue;
  public final TypeaheadDegree typeaheadDegreeValue;
  public final TypeaheadFieldOfStudy typeaheadFieldOfStudyValue;
  public final TypeaheadGroup typeaheadGroupValue;
  public final TypeaheadIndustry typeaheadIndustryValue;
  public final TypeaheadPostalCode typeaheadPostalCodeValue;
  public final TypeaheadProfile typeaheadProfileValue;
  public final TypeaheadRegion typeaheadRegionValue;
  public final TypeaheadSchool typeaheadSchoolValue;
  public final TypeaheadShowcase typeaheadShowcaseValue;
  public final TypeaheadSiteFeature typeaheadSiteFeatureValue;
  public final TypeaheadSkill typeaheadSkillValue;
  public final TypeaheadState typeaheadStateValue;
  public final TypeaheadSuggestion typeaheadSuggestionValue;
  public final TypeaheadTitle typeaheadTitleValue;
  
  TypeaheadHit$HitInfo(TypeaheadProfile paramTypeaheadProfile, TypeaheadAutoComplete paramTypeaheadAutoComplete, TypeaheadCompany paramTypeaheadCompany, TypeaheadSchool paramTypeaheadSchool, TypeaheadTitle paramTypeaheadTitle, TypeaheadFieldOfStudy paramTypeaheadFieldOfStudy, TypeaheadRegion paramTypeaheadRegion, TypeaheadDegree paramTypeaheadDegree, TypeaheadGroup paramTypeaheadGroup, TypeaheadSiteFeature paramTypeaheadSiteFeature, TypeaheadShowcase paramTypeaheadShowcase, TypeaheadSkill paramTypeaheadSkill, TypeaheadSuggestion paramTypeaheadSuggestion, TypeaheadCountry paramTypeaheadCountry, TypeaheadState paramTypeaheadState, TypeaheadCity paramTypeaheadCity, TypeaheadPostalCode paramTypeaheadPostalCode, TypeaheadIndustry paramTypeaheadIndustry, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18)
  {
    typeaheadProfileValue = paramTypeaheadProfile;
    typeaheadAutoCompleteValue = paramTypeaheadAutoComplete;
    typeaheadCompanyValue = paramTypeaheadCompany;
    typeaheadSchoolValue = paramTypeaheadSchool;
    typeaheadTitleValue = paramTypeaheadTitle;
    typeaheadFieldOfStudyValue = paramTypeaheadFieldOfStudy;
    typeaheadRegionValue = paramTypeaheadRegion;
    typeaheadDegreeValue = paramTypeaheadDegree;
    typeaheadGroupValue = paramTypeaheadGroup;
    typeaheadSiteFeatureValue = paramTypeaheadSiteFeature;
    typeaheadShowcaseValue = paramTypeaheadShowcase;
    typeaheadSkillValue = paramTypeaheadSkill;
    typeaheadSuggestionValue = paramTypeaheadSuggestion;
    typeaheadCountryValue = paramTypeaheadCountry;
    typeaheadStateValue = paramTypeaheadState;
    typeaheadCityValue = paramTypeaheadCity;
    typeaheadPostalCodeValue = paramTypeaheadPostalCode;
    typeaheadIndustryValue = paramTypeaheadIndustry;
    hasTypeaheadProfileValue = paramBoolean1;
    hasTypeaheadAutoCompleteValue = paramBoolean2;
    hasTypeaheadCompanyValue = paramBoolean3;
    hasTypeaheadSchoolValue = paramBoolean4;
    hasTypeaheadTitleValue = paramBoolean5;
    hasTypeaheadFieldOfStudyValue = paramBoolean6;
    hasTypeaheadRegionValue = paramBoolean7;
    hasTypeaheadDegreeValue = paramBoolean8;
    hasTypeaheadGroupValue = paramBoolean9;
    hasTypeaheadSiteFeatureValue = paramBoolean10;
    hasTypeaheadShowcaseValue = paramBoolean11;
    hasTypeaheadSkillValue = paramBoolean12;
    hasTypeaheadSuggestionValue = paramBoolean13;
    hasTypeaheadCountryValue = paramBoolean14;
    hasTypeaheadStateValue = paramBoolean15;
    hasTypeaheadCityValue = paramBoolean16;
    hasTypeaheadPostalCodeValue = paramBoolean17;
    hasTypeaheadIndustryValue = paramBoolean18;
    _cachedId = null;
  }
  
  public final HitInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    label198:
    label210:
    Object localObject6;
    boolean bool5;
    label250:
    label262:
    Object localObject7;
    boolean bool6;
    label302:
    label314:
    Object localObject8;
    boolean bool7;
    label354:
    label366:
    Object localObject9;
    boolean bool8;
    label406:
    label418:
    Object localObject10;
    boolean bool9;
    label458:
    label470:
    Object localObject11;
    boolean bool10;
    label510:
    label522:
    Object localObject12;
    boolean bool11;
    label563:
    label575:
    Object localObject13;
    boolean bool12;
    label616:
    label628:
    Object localObject14;
    boolean bool13;
    label669:
    label681:
    Object localObject15;
    boolean bool14;
    label722:
    label734:
    Object localObject16;
    boolean bool15;
    label775:
    label787:
    Object localObject17;
    boolean bool16;
    label828:
    label840:
    Object localObject18;
    boolean bool17;
    if (hasTypeaheadProfileValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = typeaheadProfileValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1053;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasTypeaheadAutoCompleteValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadAutoComplete");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1062;
        }
        localObject1 = typeaheadAutoCompleteValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1080;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasTypeaheadCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1089;
        }
        localObject1 = typeaheadCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1107;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasTypeaheadSchoolValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadSchool");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1117;
        }
        localObject1 = typeaheadSchoolValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1135;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasTypeaheadTitleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadTitle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1145;
        }
        localObject1 = typeaheadTitleValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1163;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasTypeaheadFieldOfStudyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadFieldOfStudy");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1173;
        }
        localObject1 = typeaheadFieldOfStudyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1191;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasTypeaheadRegionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadRegion");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1201;
        }
        localObject1 = typeaheadRegionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1219;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      localObject9 = null;
      bool8 = false;
      if (hasTypeaheadDegreeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadDegree");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1229;
        }
        localObject1 = typeaheadDegreeValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1247;
        }
        bool8 = true;
        localObject9 = localObject1;
      }
      localObject10 = null;
      bool9 = false;
      if (hasTypeaheadGroupValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadGroup");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1257;
        }
        localObject1 = typeaheadGroupValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1275;
        }
        bool9 = true;
        localObject10 = localObject1;
      }
      localObject11 = null;
      bool10 = false;
      if (hasTypeaheadSiteFeatureValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadSiteFeature");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1285;
        }
        localObject1 = typeaheadSiteFeatureValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1303;
        }
        bool10 = true;
        localObject11 = localObject1;
      }
      localObject12 = null;
      bool11 = false;
      if (hasTypeaheadShowcaseValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadShowcase");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1313;
        }
        localObject1 = typeaheadShowcaseValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1331;
        }
        bool11 = true;
        localObject12 = localObject1;
      }
      localObject13 = null;
      bool12 = false;
      if (hasTypeaheadSkillValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadSkill");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1341;
        }
        localObject1 = typeaheadSkillValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1359;
        }
        bool12 = true;
        localObject13 = localObject1;
      }
      localObject14 = null;
      bool13 = false;
      if (hasTypeaheadSuggestionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadSuggestion");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1369;
        }
        localObject1 = typeaheadSuggestionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1387;
        }
        bool13 = true;
        localObject14 = localObject1;
      }
      localObject15 = null;
      bool14 = false;
      if (hasTypeaheadCountryValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadCountry");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1397;
        }
        localObject1 = typeaheadCountryValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1415;
        }
        bool14 = true;
        localObject15 = localObject1;
      }
      localObject16 = null;
      bool15 = false;
      if (hasTypeaheadStateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadState");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1425;
        }
        localObject1 = typeaheadStateValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1443;
        }
        bool15 = true;
        localObject16 = localObject1;
      }
      localObject17 = null;
      bool16 = false;
      if (hasTypeaheadCityValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadCity");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1453;
        }
        localObject1 = typeaheadCityValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label1471;
        }
        bool16 = true;
        localObject17 = localObject1;
      }
      localObject18 = null;
      bool17 = false;
      if (hasTypeaheadPostalCodeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadPostalCode");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1481;
        }
        localObject1 = typeaheadPostalCodeValue.accept(paramDataProcessor);
        label881:
        if (localObject1 == null) {
          break label1499;
        }
        bool17 = true;
        localObject18 = localObject1;
      }
      label893:
      localObject1 = null;
      bool18 = false;
      if (hasTypeaheadIndustryValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadIndustry");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1509;
        }
        localObject1 = typeaheadIndustryValue.accept(paramDataProcessor);
        label934:
        if (localObject1 == null) {
          break label1527;
        }
      }
    }
    label1053:
    label1062:
    label1080:
    label1089:
    label1107:
    label1117:
    label1135:
    label1145:
    label1163:
    label1173:
    label1191:
    label1201:
    label1219:
    label1229:
    label1247:
    label1257:
    label1275:
    label1285:
    label1303:
    label1313:
    label1331:
    label1341:
    label1359:
    label1369:
    label1387:
    label1397:
    label1415:
    label1425:
    label1443:
    label1453:
    label1471:
    label1481:
    label1499:
    label1509:
    label1527:
    for (boolean bool18 = true;; bool18 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1533;
      }
      return new HitInfo((TypeaheadProfile)localObject2, (TypeaheadAutoComplete)localObject3, (TypeaheadCompany)localObject4, (TypeaheadSchool)localObject5, (TypeaheadTitle)localObject6, (TypeaheadFieldOfStudy)localObject7, (TypeaheadRegion)localObject8, (TypeaheadDegree)localObject9, (TypeaheadGroup)localObject10, (TypeaheadSiteFeature)localObject11, (TypeaheadShowcase)localObject12, (TypeaheadSkill)localObject13, (TypeaheadSuggestion)localObject14, (TypeaheadCountry)localObject15, (TypeaheadState)localObject16, (TypeaheadCity)localObject17, (TypeaheadPostalCode)localObject18, (TypeaheadIndustry)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18);
      localObject1 = (TypeaheadProfile)paramDataProcessor.processDataTemplate(typeaheadProfileValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (TypeaheadAutoComplete)paramDataProcessor.processDataTemplate(typeaheadAutoCompleteValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (TypeaheadCompany)paramDataProcessor.processDataTemplate(typeaheadCompanyValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (TypeaheadSchool)paramDataProcessor.processDataTemplate(typeaheadSchoolValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (TypeaheadTitle)paramDataProcessor.processDataTemplate(typeaheadTitleValue);
      break label250;
      bool5 = false;
      localObject6 = localObject1;
      break label262;
      localObject1 = (TypeaheadFieldOfStudy)paramDataProcessor.processDataTemplate(typeaheadFieldOfStudyValue);
      break label302;
      bool6 = false;
      localObject7 = localObject1;
      break label314;
      localObject1 = (TypeaheadRegion)paramDataProcessor.processDataTemplate(typeaheadRegionValue);
      break label354;
      bool7 = false;
      localObject8 = localObject1;
      break label366;
      localObject1 = (TypeaheadDegree)paramDataProcessor.processDataTemplate(typeaheadDegreeValue);
      break label406;
      bool8 = false;
      localObject9 = localObject1;
      break label418;
      localObject1 = (TypeaheadGroup)paramDataProcessor.processDataTemplate(typeaheadGroupValue);
      break label458;
      bool9 = false;
      localObject10 = localObject1;
      break label470;
      localObject1 = (TypeaheadSiteFeature)paramDataProcessor.processDataTemplate(typeaheadSiteFeatureValue);
      break label510;
      bool10 = false;
      localObject11 = localObject1;
      break label522;
      localObject1 = (TypeaheadShowcase)paramDataProcessor.processDataTemplate(typeaheadShowcaseValue);
      break label563;
      bool11 = false;
      localObject12 = localObject1;
      break label575;
      localObject1 = (TypeaheadSkill)paramDataProcessor.processDataTemplate(typeaheadSkillValue);
      break label616;
      bool12 = false;
      localObject13 = localObject1;
      break label628;
      localObject1 = (TypeaheadSuggestion)paramDataProcessor.processDataTemplate(typeaheadSuggestionValue);
      break label669;
      bool13 = false;
      localObject14 = localObject1;
      break label681;
      localObject1 = (TypeaheadCountry)paramDataProcessor.processDataTemplate(typeaheadCountryValue);
      break label722;
      bool14 = false;
      localObject15 = localObject1;
      break label734;
      localObject1 = (TypeaheadState)paramDataProcessor.processDataTemplate(typeaheadStateValue);
      break label775;
      bool15 = false;
      localObject16 = localObject1;
      break label787;
      localObject1 = (TypeaheadCity)paramDataProcessor.processDataTemplate(typeaheadCityValue);
      break label828;
      bool16 = false;
      localObject17 = localObject1;
      break label840;
      localObject1 = (TypeaheadPostalCode)paramDataProcessor.processDataTemplate(typeaheadPostalCodeValue);
      break label881;
      bool17 = false;
      localObject18 = localObject1;
      break label893;
      localObject1 = (TypeaheadIndustry)paramDataProcessor.processDataTemplate(typeaheadIndustryValue);
      break label934;
    }
    label1533:
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
      paramObject = (HitInfo)paramObject;
      if (typeaheadProfileValue != null)
      {
        if (typeaheadProfileValue.equals(typeaheadProfileValue)) {}
      }
      else {
        while (typeaheadProfileValue != null) {
          return false;
        }
      }
      if (typeaheadAutoCompleteValue != null)
      {
        if (typeaheadAutoCompleteValue.equals(typeaheadAutoCompleteValue)) {}
      }
      else {
        while (typeaheadAutoCompleteValue != null) {
          return false;
        }
      }
      if (typeaheadCompanyValue != null)
      {
        if (typeaheadCompanyValue.equals(typeaheadCompanyValue)) {}
      }
      else {
        while (typeaheadCompanyValue != null) {
          return false;
        }
      }
      if (typeaheadSchoolValue != null)
      {
        if (typeaheadSchoolValue.equals(typeaheadSchoolValue)) {}
      }
      else {
        while (typeaheadSchoolValue != null) {
          return false;
        }
      }
      if (typeaheadTitleValue != null)
      {
        if (typeaheadTitleValue.equals(typeaheadTitleValue)) {}
      }
      else {
        while (typeaheadTitleValue != null) {
          return false;
        }
      }
      if (typeaheadFieldOfStudyValue != null)
      {
        if (typeaheadFieldOfStudyValue.equals(typeaheadFieldOfStudyValue)) {}
      }
      else {
        while (typeaheadFieldOfStudyValue != null) {
          return false;
        }
      }
      if (typeaheadRegionValue != null)
      {
        if (typeaheadRegionValue.equals(typeaheadRegionValue)) {}
      }
      else {
        while (typeaheadRegionValue != null) {
          return false;
        }
      }
      if (typeaheadDegreeValue != null)
      {
        if (typeaheadDegreeValue.equals(typeaheadDegreeValue)) {}
      }
      else {
        while (typeaheadDegreeValue != null) {
          return false;
        }
      }
      if (typeaheadGroupValue != null)
      {
        if (typeaheadGroupValue.equals(typeaheadGroupValue)) {}
      }
      else {
        while (typeaheadGroupValue != null) {
          return false;
        }
      }
      if (typeaheadSiteFeatureValue != null)
      {
        if (typeaheadSiteFeatureValue.equals(typeaheadSiteFeatureValue)) {}
      }
      else {
        while (typeaheadSiteFeatureValue != null) {
          return false;
        }
      }
      if (typeaheadShowcaseValue != null)
      {
        if (typeaheadShowcaseValue.equals(typeaheadShowcaseValue)) {}
      }
      else {
        while (typeaheadShowcaseValue != null) {
          return false;
        }
      }
      if (typeaheadSkillValue != null)
      {
        if (typeaheadSkillValue.equals(typeaheadSkillValue)) {}
      }
      else {
        while (typeaheadSkillValue != null) {
          return false;
        }
      }
      if (typeaheadSuggestionValue != null)
      {
        if (typeaheadSuggestionValue.equals(typeaheadSuggestionValue)) {}
      }
      else {
        while (typeaheadSuggestionValue != null) {
          return false;
        }
      }
      if (typeaheadCountryValue != null)
      {
        if (typeaheadCountryValue.equals(typeaheadCountryValue)) {}
      }
      else {
        while (typeaheadCountryValue != null) {
          return false;
        }
      }
      if (typeaheadStateValue != null)
      {
        if (typeaheadStateValue.equals(typeaheadStateValue)) {}
      }
      else {
        while (typeaheadStateValue != null) {
          return false;
        }
      }
      if (typeaheadCityValue != null)
      {
        if (typeaheadCityValue.equals(typeaheadCityValue)) {}
      }
      else {
        while (typeaheadCityValue != null) {
          return false;
        }
      }
      if (typeaheadPostalCodeValue != null)
      {
        if (typeaheadPostalCodeValue.equals(typeaheadPostalCodeValue)) {}
      }
      else {
        while (typeaheadPostalCodeValue != null) {
          return false;
        }
      }
      if (typeaheadIndustryValue == null) {
        break;
      }
    } while (typeaheadIndustryValue.equals(typeaheadIndustryValue));
    for (;;)
    {
      return false;
      if (typeaheadIndustryValue == null) {
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
    if (hasTypeaheadProfileValue)
    {
      if (typeaheadProfileValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(typeaheadProfileValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasTypeaheadAutoCompleteValue)
      {
        i = j + 1;
        if (typeaheadAutoCompleteValue._cachedId == null) {
          break label786;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadAutoCompleteValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasTypeaheadCompanyValue)
      {
        i = j + 1;
        if (typeaheadCompanyValue._cachedId == null) {
          break label799;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadCompanyValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasTypeaheadSchoolValue)
      {
        i = j + 1;
        if (typeaheadSchoolValue._cachedId == null) {
          break label812;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadSchoolValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasTypeaheadTitleValue)
      {
        i = j + 1;
        if (typeaheadTitleValue._cachedId == null) {
          break label825;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadTitleValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasTypeaheadFieldOfStudyValue)
      {
        i = j + 1;
        if (typeaheadFieldOfStudyValue._cachedId == null) {
          break label838;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadFieldOfStudyValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasTypeaheadRegionValue)
      {
        i = j + 1;
        if (typeaheadRegionValue._cachedId == null) {
          break label851;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadRegionValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasTypeaheadDegreeValue)
      {
        i = j + 1;
        if (typeaheadDegreeValue._cachedId == null) {
          break label864;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadDegreeValue._cachedId);
      }
      label345:
      j = i + 1;
      i = j;
      if (hasTypeaheadGroupValue)
      {
        i = j + 1;
        if (typeaheadGroupValue._cachedId == null) {
          break label877;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadGroupValue._cachedId);
      }
      label387:
      j = i + 1;
      i = j;
      if (hasTypeaheadSiteFeatureValue)
      {
        i = j + 1;
        if (typeaheadSiteFeatureValue._cachedId == null) {
          break label890;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadSiteFeatureValue._cachedId);
      }
      label429:
      j = i + 1;
      i = j;
      if (hasTypeaheadShowcaseValue)
      {
        i = j + 1;
        if (typeaheadShowcaseValue._cachedId == null) {
          break label903;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadShowcaseValue._cachedId);
      }
      label471:
      j = i + 1;
      i = j;
      if (hasTypeaheadSkillValue)
      {
        i = j + 1;
        if (typeaheadSkillValue._cachedId == null) {
          break label916;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadSkillValue._cachedId);
      }
      label513:
      j = i + 1;
      i = j;
      if (hasTypeaheadSuggestionValue)
      {
        i = j + 1;
        if (typeaheadSuggestionValue._cachedId == null) {
          break label929;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadSuggestionValue._cachedId);
      }
      label555:
      j = i + 1;
      i = j;
      if (hasTypeaheadCountryValue)
      {
        i = j + 1;
        if (typeaheadCountryValue._cachedId == null) {
          break label942;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadCountryValue._cachedId);
      }
      label597:
      j = i + 1;
      i = j;
      if (hasTypeaheadStateValue)
      {
        i = j + 1;
        if (typeaheadStateValue._cachedId == null) {
          break label955;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadStateValue._cachedId);
      }
      label639:
      j = i + 1;
      i = j;
      if (hasTypeaheadCityValue)
      {
        i = j + 1;
        if (typeaheadCityValue._cachedId == null) {
          break label968;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadCityValue._cachedId);
      }
      label681:
      j = i + 1;
      i = j;
      if (hasTypeaheadPostalCodeValue)
      {
        i = j + 1;
        if (typeaheadPostalCodeValue._cachedId == null) {
          break label981;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadPostalCodeValue._cachedId);
      }
      label723:
      j = i + 1;
      i = j;
      if (hasTypeaheadIndustryValue)
      {
        i = j + 1;
        if (typeaheadIndustryValue._cachedId == null) {
          break label994;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadIndustryValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = typeaheadProfileValue.getSerializedSize() + 7;
      break;
      label786:
      i += typeaheadAutoCompleteValue.getSerializedSize();
      break label93;
      label799:
      i += typeaheadCompanyValue.getSerializedSize();
      break label135;
      label812:
      i += typeaheadSchoolValue.getSerializedSize();
      break label177;
      label825:
      i += typeaheadTitleValue.getSerializedSize();
      break label219;
      label838:
      i += typeaheadFieldOfStudyValue.getSerializedSize();
      break label261;
      label851:
      i += typeaheadRegionValue.getSerializedSize();
      break label303;
      label864:
      i += typeaheadDegreeValue.getSerializedSize();
      break label345;
      label877:
      i += typeaheadGroupValue.getSerializedSize();
      break label387;
      label890:
      i += typeaheadSiteFeatureValue.getSerializedSize();
      break label429;
      label903:
      i += typeaheadShowcaseValue.getSerializedSize();
      break label471;
      label916:
      i += typeaheadSkillValue.getSerializedSize();
      break label513;
      label929:
      i += typeaheadSuggestionValue.getSerializedSize();
      break label555;
      label942:
      i += typeaheadCountryValue.getSerializedSize();
      break label597;
      label955:
      i += typeaheadStateValue.getSerializedSize();
      break label639;
      label968:
      i += typeaheadCityValue.getSerializedSize();
      break label681;
      label981:
      i += typeaheadPostalCodeValue.getSerializedSize();
      break label723;
      label994:
      i += typeaheadIndustryValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i13 = 0;
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
    label236:
    int i10;
    label252:
    int i11;
    if (typeaheadProfileValue != null)
    {
      i = typeaheadProfileValue.hashCode();
      if (typeaheadAutoCompleteValue == null) {
        break label418;
      }
      j = typeaheadAutoCompleteValue.hashCode();
      if (typeaheadCompanyValue == null) {
        break label423;
      }
      k = typeaheadCompanyValue.hashCode();
      if (typeaheadSchoolValue == null) {
        break label428;
      }
      m = typeaheadSchoolValue.hashCode();
      if (typeaheadTitleValue == null) {
        break label434;
      }
      n = typeaheadTitleValue.hashCode();
      if (typeaheadFieldOfStudyValue == null) {
        break label440;
      }
      i1 = typeaheadFieldOfStudyValue.hashCode();
      if (typeaheadRegionValue == null) {
        break label446;
      }
      i2 = typeaheadRegionValue.hashCode();
      if (typeaheadDegreeValue == null) {
        break label452;
      }
      i3 = typeaheadDegreeValue.hashCode();
      if (typeaheadGroupValue == null) {
        break label458;
      }
      i4 = typeaheadGroupValue.hashCode();
      if (typeaheadSiteFeatureValue == null) {
        break label464;
      }
      i5 = typeaheadSiteFeatureValue.hashCode();
      if (typeaheadShowcaseValue == null) {
        break label470;
      }
      i6 = typeaheadShowcaseValue.hashCode();
      if (typeaheadSkillValue == null) {
        break label476;
      }
      i7 = typeaheadSkillValue.hashCode();
      if (typeaheadSuggestionValue == null) {
        break label482;
      }
      i8 = typeaheadSuggestionValue.hashCode();
      if (typeaheadCountryValue == null) {
        break label488;
      }
      i9 = typeaheadCountryValue.hashCode();
      if (typeaheadStateValue == null) {
        break label494;
      }
      i10 = typeaheadStateValue.hashCode();
      if (typeaheadCityValue == null) {
        break label500;
      }
      i11 = typeaheadCityValue.hashCode();
      label268:
      if (typeaheadPostalCodeValue == null) {
        break label506;
      }
    }
    label418:
    label423:
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
    label494:
    label500:
    label506:
    for (int i12 = typeaheadPostalCodeValue.hashCode();; i12 = 0)
    {
      if (typeaheadIndustryValue != null) {
        i13 = typeaheadIndustryValue.hashCode();
      }
      i = (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i13;
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
      i10 = 0;
      break label252;
      i11 = 0;
      break label268;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building HitInfo");
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
    label232:
    label292:
    label352:
    label412:
    label472:
    label532:
    label592:
    label652:
    label712:
    label772:
    label832:
    label892:
    label952:
    label1012:
    label1072:
    label1132:
    label1260:
    label1285:
    label1295:
    label1320:
    label1330:
    label1355:
    label1365:
    label1390:
    label1400:
    label1425:
    label1435:
    label1460:
    label1470:
    label1495:
    label1505:
    label1530:
    label1540:
    label1565:
    label1575:
    label1600:
    label1610:
    label1635:
    label1645:
    label1670:
    label1680:
    label1705:
    label1715:
    label1740:
    label1750:
    label1775:
    label1785:
    label1810:
    label1820:
    label1845:
    label1853:
    label1855:
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
        localByteBuffer.putInt(588273137);
        if (hasTypeaheadProfileValue)
        {
          localByteBuffer.put((byte)1);
          if (typeaheadProfileValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadProfileValue._cachedId);
            typeaheadProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadAutoCompleteValue) {
              break label1285;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadAutoCompleteValue._cachedId == null) {
              break label1260;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadAutoCompleteValue._cachedId);
            typeaheadAutoCompleteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadCompanyValue) {
              break label1320;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadCompanyValue._cachedId == null) {
              break label1295;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadCompanyValue._cachedId);
            typeaheadCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadSchoolValue) {
              break label1355;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadSchoolValue._cachedId == null) {
              break label1330;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadSchoolValue._cachedId);
            typeaheadSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadTitleValue) {
              break label1390;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadTitleValue._cachedId == null) {
              break label1365;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadTitleValue._cachedId);
            typeaheadTitleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadFieldOfStudyValue) {
              break label1425;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadFieldOfStudyValue._cachedId == null) {
              break label1400;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadFieldOfStudyValue._cachedId);
            typeaheadFieldOfStudyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadRegionValue) {
              break label1460;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadRegionValue._cachedId == null) {
              break label1435;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadRegionValue._cachedId);
            typeaheadRegionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadDegreeValue) {
              break label1495;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadDegreeValue._cachedId == null) {
              break label1470;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadDegreeValue._cachedId);
            typeaheadDegreeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadGroupValue) {
              break label1530;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadGroupValue._cachedId == null) {
              break label1505;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadGroupValue._cachedId);
            typeaheadGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadSiteFeatureValue) {
              break label1565;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadSiteFeatureValue._cachedId == null) {
              break label1540;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadSiteFeatureValue._cachedId);
            typeaheadSiteFeatureValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadShowcaseValue) {
              break label1600;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadShowcaseValue._cachedId == null) {
              break label1575;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadShowcaseValue._cachedId);
            typeaheadShowcaseValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadSkillValue) {
              break label1635;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadSkillValue._cachedId == null) {
              break label1610;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadSkillValue._cachedId);
            typeaheadSkillValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadSuggestionValue) {
              break label1670;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadSuggestionValue._cachedId == null) {
              break label1645;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadSuggestionValue._cachedId);
            typeaheadSuggestionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadCountryValue) {
              break label1705;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadCountryValue._cachedId == null) {
              break label1680;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadCountryValue._cachedId);
            typeaheadCountryValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadStateValue) {
              break label1740;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadStateValue._cachedId == null) {
              break label1715;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadStateValue._cachedId);
            typeaheadStateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadCityValue) {
              break label1775;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadCityValue._cachedId == null) {
              break label1750;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadCityValue._cachedId);
            typeaheadCityValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadPostalCodeValue) {
              break label1810;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadPostalCodeValue._cachedId == null) {
              break label1785;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadPostalCodeValue._cachedId);
            typeaheadPostalCodeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTypeaheadIndustryValue) {
              break label1845;
            }
            localByteBuffer.put((byte)1);
            if (typeaheadIndustryValue._cachedId == null) {
              break label1820;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, typeaheadIndustryValue._cachedId);
            typeaheadIndustryValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1853;
          }
          if (str != null) {
            break label1855;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          typeaheadProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          typeaheadAutoCompleteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label232;
          localByteBuffer.put((byte)0);
          break label232;
          localByteBuffer.put((byte)1);
          typeaheadCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label292;
          localByteBuffer.put((byte)0);
          break label292;
          localByteBuffer.put((byte)1);
          typeaheadSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label352;
          localByteBuffer.put((byte)0);
          break label352;
          localByteBuffer.put((byte)1);
          typeaheadTitleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label412;
          localByteBuffer.put((byte)0);
          break label412;
          localByteBuffer.put((byte)1);
          typeaheadFieldOfStudyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label472;
          localByteBuffer.put((byte)0);
          break label472;
          localByteBuffer.put((byte)1);
          typeaheadRegionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label532;
          localByteBuffer.put((byte)0);
          break label532;
          localByteBuffer.put((byte)1);
          typeaheadDegreeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label592;
          localByteBuffer.put((byte)0);
          break label592;
          localByteBuffer.put((byte)1);
          typeaheadGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label652;
          localByteBuffer.put((byte)0);
          break label652;
          localByteBuffer.put((byte)1);
          typeaheadSiteFeatureValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label712;
          localByteBuffer.put((byte)0);
          break label712;
          localByteBuffer.put((byte)1);
          typeaheadShowcaseValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label772;
          localByteBuffer.put((byte)0);
          break label772;
          localByteBuffer.put((byte)1);
          typeaheadSkillValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label832;
          localByteBuffer.put((byte)0);
          break label832;
          localByteBuffer.put((byte)1);
          typeaheadSuggestionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label892;
          localByteBuffer.put((byte)0);
          break label892;
          localByteBuffer.put((byte)1);
          typeaheadCountryValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label952;
          localByteBuffer.put((byte)0);
          break label952;
          localByteBuffer.put((byte)1);
          typeaheadStateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1012;
          localByteBuffer.put((byte)0);
          break label1012;
          localByteBuffer.put((byte)1);
          typeaheadCityValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1072;
          localByteBuffer.put((byte)0);
          break label1072;
          localByteBuffer.put((byte)1);
          typeaheadPostalCodeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label1132;
          localByteBuffer.put((byte)0);
          break label1132;
          localByteBuffer.put((byte)1);
          typeaheadIndustryValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
  {
    private boolean hasTypeaheadAutoCompleteValue = false;
    private boolean hasTypeaheadCityValue = false;
    private boolean hasTypeaheadCompanyValue = false;
    private boolean hasTypeaheadCountryValue = false;
    private boolean hasTypeaheadDegreeValue = false;
    private boolean hasTypeaheadFieldOfStudyValue = false;
    private boolean hasTypeaheadGroupValue = false;
    private boolean hasTypeaheadIndustryValue = false;
    private boolean hasTypeaheadPostalCodeValue = false;
    public boolean hasTypeaheadProfileValue = false;
    private boolean hasTypeaheadRegionValue = false;
    private boolean hasTypeaheadSchoolValue = false;
    private boolean hasTypeaheadShowcaseValue = false;
    private boolean hasTypeaheadSiteFeatureValue = false;
    private boolean hasTypeaheadSkillValue = false;
    private boolean hasTypeaheadStateValue = false;
    private boolean hasTypeaheadSuggestionValue = false;
    public boolean hasTypeaheadTitleValue = false;
    private TypeaheadAutoComplete typeaheadAutoCompleteValue = null;
    private TypeaheadCity typeaheadCityValue = null;
    private TypeaheadCompany typeaheadCompanyValue = null;
    private TypeaheadCountry typeaheadCountryValue = null;
    private TypeaheadDegree typeaheadDegreeValue = null;
    private TypeaheadFieldOfStudy typeaheadFieldOfStudyValue = null;
    private TypeaheadGroup typeaheadGroupValue = null;
    private TypeaheadIndustry typeaheadIndustryValue = null;
    private TypeaheadPostalCode typeaheadPostalCodeValue = null;
    public TypeaheadProfile typeaheadProfileValue = null;
    private TypeaheadRegion typeaheadRegionValue = null;
    private TypeaheadSchool typeaheadSchoolValue = null;
    private TypeaheadShowcase typeaheadShowcaseValue = null;
    private TypeaheadSiteFeature typeaheadSiteFeatureValue = null;
    private TypeaheadSkill typeaheadSkillValue = null;
    private TypeaheadState typeaheadStateValue = null;
    private TypeaheadSuggestion typeaheadSuggestionValue = null;
    public TypeaheadTitle typeaheadTitleValue = null;
    
    public final TypeaheadHit.HitInfo build()
      throws BuilderException
    {
      int j = 0;
      if (hasTypeaheadProfileValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasTypeaheadAutoCompleteValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadCompanyValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadSchoolValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadTitleValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadFieldOfStudyValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadRegionValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadDegreeValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadGroupValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadSiteFeatureValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadShowcaseValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadSkillValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadSuggestionValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadCountryValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadStateValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadCityValue) {
        i = j + 1;
      }
      j = i;
      if (hasTypeaheadPostalCodeValue) {
        j = i + 1;
      }
      i = j;
      if (hasTypeaheadIndustryValue) {
        i = j + 1;
      }
      if (i > 1) {
        throw new UnionMemberCountException("HitInfo", i);
      }
      return new TypeaheadHit.HitInfo(typeaheadProfileValue, typeaheadAutoCompleteValue, typeaheadCompanyValue, typeaheadSchoolValue, typeaheadTitleValue, typeaheadFieldOfStudyValue, typeaheadRegionValue, typeaheadDegreeValue, typeaheadGroupValue, typeaheadSiteFeatureValue, typeaheadShowcaseValue, typeaheadSkillValue, typeaheadSuggestionValue, typeaheadCountryValue, typeaheadStateValue, typeaheadCityValue, typeaheadPostalCodeValue, typeaheadIndustryValue, hasTypeaheadProfileValue, hasTypeaheadAutoCompleteValue, hasTypeaheadCompanyValue, hasTypeaheadSchoolValue, hasTypeaheadTitleValue, hasTypeaheadFieldOfStudyValue, hasTypeaheadRegionValue, hasTypeaheadDegreeValue, hasTypeaheadGroupValue, hasTypeaheadSiteFeatureValue, hasTypeaheadShowcaseValue, hasTypeaheadSkillValue, hasTypeaheadSuggestionValue, hasTypeaheadCountryValue, hasTypeaheadStateValue, hasTypeaheadCityValue, hasTypeaheadPostalCodeValue, hasTypeaheadIndustryValue);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */