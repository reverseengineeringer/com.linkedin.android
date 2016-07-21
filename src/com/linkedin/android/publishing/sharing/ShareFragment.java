package com.linkedin.android.publishing.sharing;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Map;

public class ShareFragment
  extends PageFragment
{
  @InjectView(2131758633)
  TabLayout tabLayout;
  @InjectView(2131758632)
  Toolbar toolbar;
  private final Map<Integer, TrackingOnClickListener> trackingOnClickListenerMap = new ArrayMap();
  @InjectView(2131758634)
  ViewPager viewPager;
  ShareFragmentPagerAdapter viewPagerAdapter;
  private TrackingOnClickListener viewPagerTrackingOnClickListener;
  
  public final boolean isAnchorPage()
  {
    return !ShareBundle.isReshare(getArguments());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969434, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    int j = 1;
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    viewPagerAdapter = new ShareFragmentPagerAdapter(getFragmentManager(), fragmentComponent, paramBundle);
    viewPager.setOffscreenPageLimit(0);
    viewPager.setAdapter(viewPagerAdapter);
    viewPager.enableInteractionTracking(fragmentComponent.tracker(), "share_viewpager");
    paramView = fragmentComponent.tracker();
    viewPagerTrackingOnClickListener = new TrackingOnClickListener(paramView, "share_viewpager", new TrackingEventBuilder[0]);
    trackingOnClickListenerMap.put(Integer.valueOf(0), new TrackingOnClickListener(paramView, "reshare_tab", new TrackingEventBuilder[0]));
    trackingOnClickListenerMap.put(Integer.valueOf(1), new TrackingOnClickListener(paramView, "message_tab", new TrackingEventBuilder[0]));
    tabLayout.setupWithViewPager$4740f1a6(viewPager, 0, 0, new ShareFragment.1(this));
    tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), 2131624058));
    boolean bool = ShareBundle.isReshare(paramBundle);
    paramView = ShareBundle.getShareCreatorBundle(paramBundle);
    int i;
    if (paramView != null)
    {
      paramView = paramView.build();
      if ((paramView == null) || (!paramView.getBoolean("open_message", false))) {
        break label336;
      }
      i = 1;
      label228:
      if ((bool) && (i != 0)) {
        viewPager.setCurrentItem(1);
      }
      paramView = ShareBundle.getTitle(paramBundle, i18NManager);
      paramBundle = toolbar;
      ViewCompat.setElevation(paramBundle, getResources().getDimension(2131493575));
      if ((!bool) || (viewPagerAdapter.getCount() == 1)) {
        tabLayout.setVisibility(8);
      }
      if ((paramView == null) || (bool)) {
        break label341;
      }
      i = j;
      label309:
      if (i == 0) {
        break label346;
      }
    }
    for (;;)
    {
      paramBundle.setTitle(paramView);
      paramBundle.setNavigationOnClickListener(new ShareFragment.2(this));
      return;
      paramView = null;
      break;
      label336:
      i = 0;
      break label228;
      label341:
      i = 0;
      break label309;
      label346:
      paramView = null;
    }
  }
  
  public final String pageKey()
  {
    if (ShareBundle.isReshare(getArguments())) {
      return "feed_reshare";
    }
    return "feed_share";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.ShareFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */