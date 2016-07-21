package com.linkedin.android.entities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.OnTabSelectedListener;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.Tab;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.TabLayoutOnPageChangeListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public abstract class EntityCoordinatorBaseFragment
  extends PageFragment
{
  private static final Set<String> SCROLLABLE_LOCALE_LANGUAGES = new HashSet(Arrays.asList(new String[] { "fr", "es", "nl", "pl", "ro", "ru", "sv", "tr" }));
  @InjectView(2131755466)
  public AppBarLayout appBarLayout;
  @InjectView(2131755467)
  public CollapsingToolbarLayout collapsingToolbarLayout;
  @InjectView(2131755473)
  protected ViewGroup errorContainer;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131755474)
  protected Toolbar errorToolbar;
  @InjectView(2131755460)
  protected ViewStub errorViewStub;
  @InjectView(2131755469)
  protected ViewGroup header;
  private boolean isDataDisplayed;
  @InjectView(2131755471)
  public ViewGroup loadingSpinner;
  @InjectView(2131755465)
  protected ViewGroup mainContent;
  private int openSearchEntryType;
  @InjectView(2131755145)
  protected ViewGroup searchBar;
  @InjectView(2131758545)
  protected View searchBarDivider;
  @InjectView(2131755328)
  protected TextView searchBarText;
  boolean showingTitle;
  @InjectView(2131755470)
  protected TabLayout tabLayout;
  @InjectView(2131755468)
  public Toolbar toolbar;
  private AppBarLayout.OnOffsetChangedListener topBarOffsetListener;
  public View topCard;
  @InjectView(2131755472)
  public ViewPager viewPager;
  
  private View.OnClickListener createNavigationOnClickListener()
  {
    new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (isResumed())
        {
          paramAnonymousView = fragmentComponent.intentRegistry().home;
          FragmentActivity localFragmentActivity = getActivity();
          HomeBundle localHomeBundle = new HomeBundle();
          activeTab = HomeTabInfo.FEED;
          paramAnonymousView = paramAnonymousView.newIntent(localFragmentActivity, localHomeBundle);
          NavigationUtils.navigateUp(getActivity(), paramAnonymousView, false);
        }
      }
    };
  }
  
  public abstract TrackingClosure<Void, Void> getOnErrorButtonClickClosure();
  
  public final List<ScreenElement> getScreenElements()
  {
    return Collections.singletonList(viewPager);
  }
  
  public abstract ViewHolderCreator<? extends BaseViewHolder> getViewHolderCreator();
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getContext();
    openSearchEntryType = SearchUtils.getOpenSearchEntryType$67eca9c3(fragmentComponent.lixManager(), Lix.ENTITIES_ADD_SEARCH_MENU);
    setupToolbar();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968679, paramViewGroup, false);
  }
  
  public void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((!isDataDisplayed) && (paramType == DataStore.Type.NETWORK))
    {
      loadingSpinner.setVisibility(8);
      showErrorPage();
    }
  }
  
  public void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (!isDataDisplayed)
    {
      loadingSpinner.setVisibility(8);
      isDataDisplayed = true;
      errorContainer.setVisibility(8);
      mainContent.setVisibility(0);
    }
  }
  
  public boolean onMenuClick(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final void onOffsetChangedForOpenBar(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      searchBarDivider.setVisibility(0);
      searchBar.setVisibility(0);
      return;
    }
    if (paramInt1 == -paramInt2)
    {
      searchBarDivider.setVisibility(8);
      searchBar.setVisibility(0);
      return;
    }
    searchBar.setVisibility(8);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    isDataDisplayed = false;
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    topCard = LayoutInflater.from(getActivity()).inflate(getViewHolderCreator().getLayoutId(), header, true);
  }
  
  public final void setTitle(final String paramString)
  {
    appBarLayout.removeOnOffsetChangedListener(topBarOffsetListener);
    if (openSearchEntryType == 2) {
      searchBarText.setText(paramString);
    }
    topBarOffsetListener = new AppBarLayout.OnOffsetChangedListener()
    {
      int scrollRange = -1;
      
      public final void onOffsetChanged(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        if ((collapsingToolbarLayout == null) || (!isResumed())) {}
        do
        {
          return;
          if (scrollRange == -1) {
            scrollRange = paramAnonymousAppBarLayout.getTotalScrollRange();
          }
          if (openSearchEntryType == 2)
          {
            onOffsetChangedForOpenBar(paramAnonymousInt, scrollRange);
            return;
          }
          paramAnonymousAppBarLayout = EntityCoordinatorBaseFragment.this;
          String str = paramString;
          if (scrollRange + paramAnonymousInt == 0)
          {
            collapsingToolbarLayout.setTitle(str);
            showingTitle = true;
            return;
          }
        } while (!showingTitle);
        collapsingToolbarLayout.setTitle(null);
        showingTitle = false;
      }
    };
    appBarLayout.addOnOffsetChangedListener(topBarOffsetListener);
  }
  
  public final void setupTabs(FragmentReferencingPagerAdapter paramFragmentReferencingPagerAdapter)
  {
    setupTabs(paramFragmentReferencingPagerAdapter, false);
  }
  
  public final void setupTabs(final FragmentReferencingPagerAdapter paramFragmentReferencingPagerAdapter, boolean paramBoolean)
  {
    viewPager.setAdapter(paramFragmentReferencingPagerAdapter);
    viewPager.enableInteractionTracking(tracker, "header_nav");
    if ((paramBoolean) && (paramFragmentReferencingPagerAdapter.getCount() == 1))
    {
      tabLayout.setVisibility(8);
      return;
    }
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    Locale localLocale = getResourcesgetConfigurationlocale;
    if ((localLocale != null) && (paramFragmentReferencingPagerAdapter.getCount() > 2) && (SCROLLABLE_LOCALE_LANGUAGES.contains(localLocale.getLanguage()))) {
      tabLayout.setTabMode(0);
    }
    tabLayout.setupWithViewPager$4740f1a6(viewPager, 0, 0, new TabLayout.OnTabSelectedListener()
    {
      public final void onTabReselected(TabLayout.Tab paramAnonymousTab, boolean paramAnonymousBoolean) {}
      
      public final void onTabScrollEnd(TabLayout.Tab paramAnonymousTab) {}
      
      public final void onTabScrollStart(TabLayout.Tab paramAnonymousTab) {}
      
      public final void onTabSelectAnimationEnd(TabLayout.Tab paramAnonymousTab)
      {
        paramAnonymousTab = paramFragmentReferencingPagerAdapter.getItemAtPosition(mPosition);
        if ((paramAnonymousTab instanceof EntityBaseTabFragment))
        {
          paramAnonymousTab = (EntityBaseTabFragment)paramAnonymousTab;
          if ((paramAnonymousTab.isVisible()) && (paramAnonymousTab.isResumed())) {
            paramAnonymousTab.toggleImpressionTracking(true);
          }
        }
      }
      
      public final void onTabSelectAnimationStart(TabLayout.Tab paramAnonymousTab) {}
      
      public final void onTabSelected(TabLayout.Tab paramAnonymousTab, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          new TrackingOnClickListener(tracker, "header_nav", new TrackingEventBuilder[0]).onClick(val$tabLayout);
        }
      }
    });
  }
  
  public void setupToolbar()
  {
    int i = ContextCompat.getColor(getContext(), 2131624108);
    collapsingToolbarLayout.setBackgroundColor(i);
    i = ContextCompat.getColor(getContext(), 2131624058);
    collapsingToolbarLayout.setCollapsedTitleTextColor(i);
    if ((openSearchEntryType == 1) && (isAdded()))
    {
      toolbar.inflateMenu(2131820559);
      MenuItem localMenuItem = toolbar.getMenu().findItem(2131758761);
      localMenuItem.setIcon(DrawableHelper.setTint(localMenuItem.getIcon(), ResourcesCompat.getColor(getResources(), 2131624058, getActivity().getTheme())));
    }
    if (openSearchEntryType != 2) {
      searchBar.setVisibility(8);
    }
    for (;;)
    {
      toolbar.setNavigationOnClickListener(createNavigationOnClickListener());
      toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            return onMenuClick(paramAnonymousMenuItem);
          }
          startActivity(fragmentComponent.intentRegistry().search.newIntent(getActivity(), SearchBundleBuilder.create()));
          trackButtonShortPress("search_icon");
          return true;
        }
      });
      return;
      searchBar.setOnClickListener(new TrackingOnClickListener(tracker, "open_search_box", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          if (isDetached()) {
            return;
          }
          paramAnonymousView = fragmentComponent.intentRegistry().search.newIntent(getActivity(), SearchBundleBuilder.create().setQueryString(searchBarText.getText().toString()));
          getActivity().startActivity(paramAnonymousView);
        }
      });
    }
  }
  
  public final void showErrorPage()
  {
    if ((!isAdded()) || (getView() == null)) {
      return;
    }
    isDataDisplayed = false;
    errorContainer.setVisibility(0);
    mainContent.setVisibility(8);
    errorToolbar.setNavigationOnClickListener(createNavigationOnClickListener());
    ErrorPageViewHolder localErrorPageViewHolder = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.setupDefaultErrorConfiguration(getContext(), getOnErrorButtonClickClosure());
    ErrorPageViewModel localErrorPageViewModel = errorPageViewModel;
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    fragmentComponent.mediaCenter();
    localErrorPageViewModel.onBindViewHolderWithErrorTracking$18b8048(localLayoutInflater, localErrorPageViewHolder, tracker, getPageInstance());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */