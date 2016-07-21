package com.linkedin.android.search;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadDegree;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadRegion;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSkill;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;

public class SearchBundleBuilder
  implements BundleBuilder
{
  private static final String TAG = SearchBundleBuilder.class.getSimpleName();
  public Bundle bundle = new Bundle();
  
  public static SearchBundleBuilder create()
  {
    return new SearchBundleBuilder();
  }
  
  public static SearchBundleBuilder create(Bundle paramBundle)
  {
    SearchBundleBuilder localSearchBundleBuilder = new SearchBundleBuilder();
    if (paramBundle != null) {}
    for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
    {
      bundle = paramBundle;
      return localSearchBundleBuilder;
    }
  }
  
  public static SearchBundleBuilder createAsJserp(String paramString)
  {
    SearchBundleBuilder localSearchBundleBuilder = new SearchBundleBuilder();
    bundle.putString("jserpUrl", paramString);
    localSearchBundleBuilder.setSearchType(SearchType.JOBS);
    localSearchBundleBuilder.setOrigin(SearchResultPageOrigin.JOB_SEARCH_RESULTS_PAGE.toString());
    return localSearchBundleBuilder;
  }
  
  public static MiniCompany getCompany(Bundle paramBundle)
  {
    return (MiniCompany)getTypeaheadEntity(MiniCompany.BUILDER, paramBundle);
  }
  
  public static String getCustomTrackingName(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("custom_tracking_name");
    }
    return null;
  }
  
  public static String getCustomTypeaheadClickTrackingName(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("custom_typeahead_click_tracking_name");
    }
    return null;
  }
  
  public static String getCustomTypeaheadPageKey(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("custom_typeahead_page_key");
    }
    return null;
  }
  
  public static String getCustomTypeaheadSearchBarCancelTrackingName(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("custom_typeahead_search_bar_cancel_tracking_name");
    }
    return null;
  }
  
  public static boolean getFakeHitAtTop(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("fake_hit_at_top"));
  }
  
  public static int getInputMaxLength(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 0;
    }
    return paramBundle.getInt("input_max_length");
  }
  
  public static boolean getIsHashTag(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("hashtag"));
  }
  
  public static String getJserpUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("jserpUrl");
  }
  
  public static MiniProfile getProfile(Bundle paramBundle)
  {
    return (MiniProfile)getTypeaheadEntity(MiniProfile.BUILDER, paramBundle);
  }
  
  public static String getQueryString(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("query_string");
  }
  
  public static MiniSchool getSchool(Bundle paramBundle)
  {
    return (MiniSchool)getTypeaheadEntity(MiniSchool.BUILDER, paramBundle);
  }
  
  public static String getSearchBarHintText(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("hint_text");
  }
  
  public static SearchQuery getSearchQuery(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      paramBundle = (SearchQuery)RecordParceler.unparcel(SearchQuery.BUILDER, "query_params", paramBundle);
      return paramBundle;
    }
    catch (DataReaderException paramBundle)
    {
      Log.d(TAG, "can't get query params");
    }
    return null;
  }
  
  public static SearchType getSearchType(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return (SearchType)paramBundle.getSerializable("search_type");
  }
  
  public static TypeaheadSkill getSkill(Bundle paramBundle)
  {
    paramBundle = getTypeaheadHitInfo(paramBundle);
    if (paramBundle == null) {
      return null;
    }
    return typeaheadSkillValue;
  }
  
  public static String getSuggestedEntity(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("suggested_entity");
    }
    return null;
  }
  
  public static String getText(Bundle paramBundle)
  {
    paramBundle = (TypeaheadHit)getTypeaheadEntity(TypeaheadHit.BUILDER, paramBundle);
    if (paramBundle != null) {
      return text.text;
    }
    return null;
  }
  
  private static <E extends RecordTemplate<E>> E getTypeaheadEntity(DataTemplateBuilder<E> paramDataTemplateBuilder, Bundle paramBundle)
  {
    RecordTemplate localRecordTemplate = null;
    if (paramBundle != null) {}
    try
    {
      localRecordTemplate = RecordParceler.unparcel(paramDataTemplateBuilder, "typeahead_pick_entity", paramBundle);
      return localRecordTemplate;
    }
    catch (DataReaderException paramDataTemplateBuilder) {}
    return null;
  }
  
  private static TypeaheadHit.HitInfo getTypeaheadHitInfo(Bundle paramBundle)
  {
    paramBundle = (TypeaheadHit)getTypeaheadEntity(TypeaheadHit.BUILDER, paramBundle);
    if (paramBundle != null) {
      return hitInfo;
    }
    return null;
  }
  
  public static int getTypeaheadSourece(Bundle paramBundle)
  {
    int i = 3;
    if (paramBundle != null) {
      i = paramBundle.getInt("typeahead_source", 3);
    }
    return i;
  }
  
  public static TypeaheadType getTypeaheadType(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("typeahead_type"))) {
      return null;
    }
    return TypeaheadType.of(paramBundle.getString("typeahead_type"));
  }
  
  public static Urn getUrn(Bundle paramBundle)
  {
    paramBundle = getTypeaheadHitInfo(paramBundle);
    if (paramBundle == null) {}
    do
    {
      return null;
      if (typeaheadDegreeValue != null) {
        return typeaheadDegreeValue.degreeUrn;
      }
      if (typeaheadFieldOfStudyValue != null) {
        return typeaheadFieldOfStudyValue.fieldOfStudyUrn;
      }
      if (typeaheadRegionValue != null) {
        return typeaheadRegionValue.regionUrn;
      }
    } while (typeaheadSkillValue == null);
    return typeaheadSkillValue.skill.entityUrn;
  }
  
  public static boolean hasFakeHit(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("fake_hit", true));
  }
  
  public static boolean isPickerMode(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("picker_mode"));
  }
  
  public static boolean shouldOpenJserp(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getString("jserpUrl") != null);
  }
  
  public static boolean shouldOpenSearchFragment(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("searchFragment", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final SearchBundleBuilder setCustomTrackingName(String paramString)
  {
    bundle.putString("custom_tracking_name", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setCustomTypeaheadClickTrackingName(String paramString)
  {
    bundle.putString("custom_typeahead_click_tracking_name", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setCustomTypeaheadPageKey(String paramString)
  {
    bundle.putString("custom_typeahead_page_key", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setCustomTypeaheadSearchBarCancelTrackingName(String paramString)
  {
    bundle.putString("custom_typeahead_search_bar_cancel_tracking_name", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setFakeHitAtTop$6c621e23()
  {
    bundle.putBoolean("fake_hit_at_top", false);
    return this;
  }
  
  public final SearchBundleBuilder setInputMaxLength$fdadbae()
  {
    bundle.putInt("input_max_length", 100);
    return this;
  }
  
  public final SearchBundleBuilder setOpenSearchFragment()
  {
    bundle.putBoolean("searchFragment", true);
    return this;
  }
  
  public final SearchBundleBuilder setOrigin(String paramString)
  {
    paramString = SearchUtils.getOriginFromString(paramString);
    bundle.putString("origin", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setPickerMode$6c621e23()
  {
    bundle.putBoolean("picker_mode", true);
    return this;
  }
  
  public final SearchBundleBuilder setQueryString(String paramString)
  {
    bundle.putString("query_string", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setSearchBarHintText(String paramString)
  {
    bundle.putString("hint_text", paramString);
    return this;
  }
  
  public final SearchBundleBuilder setSearchQuery(SearchQuery paramSearchQuery)
  {
    if (paramSearchQuery != null) {}
    try
    {
      RecordParceler.parcel(paramSearchQuery, "query_params", bundle);
      return this;
    }
    catch (JsonGeneratorException paramSearchQuery)
    {
      Log.d(TAG, "can't set query params");
    }
    return this;
  }
  
  public final SearchBundleBuilder setSearchType(SearchType paramSearchType)
  {
    bundle.putSerializable("search_type", paramSearchType);
    return this;
  }
  
  public final SearchBundleBuilder setTypeaheadType(TypeaheadType paramTypeaheadType)
  {
    if (paramTypeaheadType != null) {
      bundle.putString("typeahead_type", paramTypeaheadType.toString());
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.SearchBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */