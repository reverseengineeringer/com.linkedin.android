package com.linkedin.android.search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.facet.SearchFacetFragment;
import com.linkedin.android.search.facet.SearchFacetTransformer;
import com.linkedin.android.search.typeahead.TypeaheadFragment;
import com.linkedin.android.search.unifiedsearch.SearchFragmentFactory;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Locale;
import javax.inject.Inject;

public class SearchActivity
  extends BaseActivity
  implements SearchBarListener, SearchPicker, SecondaryClusterActionListener
{
  private Bundle args;
  private String customTypeaheadSearchBarCancelTrackingName;
  @Inject
  SearchFacetTransformer facetTransformer;
  @Inject
  LixManager lixManager;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969389);
    activityComponent.inject(this);
    if (paramBundle == null)
    {
      args = getIntent().getExtras();
      customTypeaheadSearchBarCancelTrackingName = SearchBundleBuilder.getCustomTypeaheadSearchBarCancelTrackingName(args);
      paramBundle = null;
      if ((!SearchBundleBuilder.shouldOpenJserp(args)) || (EntityUtils.isLixEnabled(activityComponent.lixManager(), Lix.SEARCH_DISABLE_JSERP_LANDING_PAGE))) {
        break label123;
      }
    }
    Object localObject;
    label123:
    for (int i = 1; (SearchBundleBuilder.shouldOpenSearchFragment(args)) || (i != 0); i = 0)
    {
      localObject = SearchFragmentFactory.newFragment(SearchBundleBuilder.create(args));
      getSupportFragmentManager().beginTransaction().add(2131758464, (Fragment)localObject, paramBundle).commit();
      return;
    }
    if (SearchBundleBuilder.isPickerMode(args)) {}
    for (paramBundle = null;; paramBundle = "blended_typeahead_fragment_tag")
    {
      localObject = TypeaheadFragment.newInstance(SearchBundleBuilder.create(args));
      break;
    }
  }
  
  public final boolean onFacetAction(String paramString)
  {
    int i = -1;
    if (isSafeToExecuteTransaction())
    {
      paramString = SearchFacetFragment.newInstance(SearchBundleBuilder.create().setQueryString(paramString));
      i = getModalFragmentTransaction().replace(2131758464, paramString).addToBackStack(null).commit();
    }
    return i > 0;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    if (customTypeaheadSearchBarCancelTrackingName != null) {
      new ControlInteractionEvent(activityComponent.tracker(), customTypeaheadSearchBarCancelTrackingName, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
    }
    onBackPressed();
    return true;
  }
  
  public final boolean onQuerySubmit(String paramString1, String paramString2, SearchQuery paramSearchQuery, SearchType paramSearchType)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (getSupportFragmentManager().findFragmentByTag(paramString1) == null)
    {
      i = -1;
      if (isSafeToExecuteTransaction())
      {
        if (paramSearchType != null) {
          break label130;
        }
        paramSearchType = SearchType.ALL;
      }
    }
    label130:
    for (;;)
    {
      paramString2 = SearchBundleBuilder.create().setQueryString(paramString1).setOrigin(paramString2).setSearchQuery(paramSearchQuery).setSearchType(paramSearchType);
      if (activityComponent.searchDataProvider().forceOpenJobSearch) {
        paramString2.setSearchType(SearchType.JOBS);
      }
      paramString2 = SearchFragmentFactory.newFragment(paramString2);
      i = getPageFragmentTransaction().replace(2131758464, paramString2, paramString1).addToBackStack(null).commit();
      getSupportFragmentManager().executePendingTransactions();
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final boolean onQueryTextChange(String paramString)
  {
    return false;
  }
  
  public final void onSecondaryClusterTap(SearchBundleBuilder paramSearchBundleBuilder)
  {
    if (isSafeToExecuteTransaction())
    {
      paramSearchBundleBuilder = SearchFragmentFactory.newFragment(paramSearchBundleBuilder);
      getPageFragmentTransaction().replace(2131758464, paramSearchBundleBuilder).addToBackStack(null).commit();
    }
  }
  
  public final void openPickerTypeaheadFragment(TypeaheadType paramTypeaheadType, int paramInt1, int paramInt2)
  {
    String str = "search_minitypeahead_" + paramTypeaheadType.name().toLowerCase(Locale.US);
    if (isSafeToExecuteTransaction())
    {
      paramTypeaheadType = SearchBundleBuilder.create().setTypeaheadType(paramTypeaheadType).setPickerMode$6c621e23();
      bundle.putBoolean("fake_hit", false);
      bundle.putInt("typeahead_source", paramInt1);
      paramTypeaheadType = paramTypeaheadType.setCustomTypeaheadPageKey(str);
      if (paramInt2 != 0) {
        paramTypeaheadType.setSearchBarHintText(getString(paramInt2));
      }
      getModalFragmentTransaction().add(2131758464, TypeaheadFragment.newInstance(paramTypeaheadType), null).addToBackStack(null).commit();
    }
  }
  
  public final void pickAndReturnItem(Object paramObject)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((paramObject instanceof RecordTemplate)) {}
    for (;;)
    {
      try
      {
        RecordParceler.parcel((RecordTemplate)paramObject, "typeahead_pick_entity", localBundle);
        localIntent.putExtras(localBundle);
        setResult(-1, localIntent);
        finish();
        return;
      }
      catch (JsonGeneratorException paramObject)
      {
        Util.safeThrow(new IllegalStateException("Model parcel failed", (Throwable)paramObject));
        continue;
      }
      if ((paramObject instanceof Parcelable)) {
        localIntent.putExtra("typeahead_pick_entity", (Parcelable)paramObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.SearchActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */