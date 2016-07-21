package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class TypeaheadHit$HitInfo$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */