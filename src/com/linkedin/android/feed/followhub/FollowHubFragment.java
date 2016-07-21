package com.linkedin.android.feed.followhub;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.SimpleOnTabSelectedListener;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.Tab;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendationType;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText.Builder;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FollowHubFragment
  extends PageFragment
{
  @InjectView(2131755776)
  TextView exitButton;
  @InjectView(2131755779)
  TabLayout tabLayout;
  @InjectView(2131755775)
  CollapsingToolbarLayout toolbarLayout;
  private final Map<Integer, TrackingOnClickListener> trackingOnClickListenerMap = new ArrayMap();
  @InjectView(2131755780)
  ViewPager viewPager;
  private FollowHubFragmentPagerAdapter viewPagerAdapter;
  
  private RecommendedPackage getRecommendedPackageMock(int paramInt)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        RecommendedPackage.Builder localBuilder = new RecommendedPackage.Builder();
        localObject = Integer.valueOf(paramInt);
        if (localObject == null)
        {
          hasPackageId = false;
          packageId = 0;
          localObject = new AnnotatedText.Builder().setValues(Collections.singletonList(new AnnotatedString.Builder().setValue("Discover Tab " + paramInt).build(RecordTemplate.Flavor.RECORD))).build();
          if (localObject == null)
          {
            hasReason = false;
            reason = null;
            localObject = RecommendationType.FOLLOW;
            if (localObject != null) {
              break label183;
            }
            hasRecommendationType = false;
            recommendationType = null;
            localObject = Collections.emptyList();
            if (localObject != null) {
              break label196;
            }
            hasRecommendedEntities = false;
            recommendedEntities = null;
            return localBuilder.build(RecordTemplate.Flavor.RECORD);
          }
        }
        else
        {
          hasPackageId = true;
          packageId = ((Integer)localObject).intValue();
          continue;
        }
        hasReason = true;
      }
      catch (BuilderException localBuilderException)
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Blame Melanie"));
        return null;
      }
      reason = ((AnnotatedText)localObject);
      continue;
      label183:
      hasRecommendationType = true;
      recommendationType = ((RecommendationType)localObject);
      continue;
      label196:
      hasRecommendedEntities = true;
      recommendedEntities = ((List)localObject);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968749, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    viewPagerAdapter = new FollowHubFragmentPagerAdapter(fragmentComponent, getFragmentManager());
    paramView = viewPagerAdapter;
    paramBundle = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      RecommendedPackage localRecommendedPackage = getRecommendedPackageMock(i);
      if (localRecommendedPackage != null) {
        paramBundle.add(localRecommendedPackage);
      }
      i += 1;
    }
    packages.addAll(paramBundle);
    paramView.notifyDataSetChanged();
    viewPager.setAdapter(viewPagerAdapter);
    viewPager.enableInteractionTracking(fragmentComponent.tracker(), "follow_hub_viewpager");
    tabLayout.setTabMode(0);
    tabLayout.setupWithViewPager$4740f1a6(viewPager, 0, 0, new SimpleOnTabSelectedListener()
    {
      public final void onTabSelected(TabLayout.Tab paramAnonymousTab, boolean paramAnonymousBoolean)
      {
        paramAnonymousTab = (TrackingOnClickListener)trackingOnClickListenerMap.get(Integer.valueOf(mPosition));
        if (paramAnonymousTab != null) {
          paramAnonymousTab.onClick(tabLayout);
        }
      }
    });
    exitButton.setOnClickListener(new TrackingOnClickListener(tracker, "preferences_discover_done", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        FollowHubFragment.access$000(FollowHubFragment.this);
      }
    });
  }
  
  public final String pageKey()
  {
    return "feed_preferences_discover";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */