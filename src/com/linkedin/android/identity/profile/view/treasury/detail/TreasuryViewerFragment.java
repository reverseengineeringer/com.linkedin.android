package com.linkedin.android.identity.profile.view.treasury.detail;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.OnWindowFocusChangedListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasurySectionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;

public class TreasuryViewerFragment
  extends PageFragment
  implements ViewPager.OnPageChangeListener, OnBackPressedListener, OnWindowFocusChangedListener
{
  public static final String TAG = TreasuryViewerFragment.class.getSimpleName();
  private TreasuryDetailMediaEntryAdapter adapter;
  private Runnable autoHideRunnable = new TreasuryViewerFragment.1(this);
  @InjectView(2131755816)
  View backgroundOverlay;
  private int currentOrientation;
  private boolean disableUIAutoHide;
  TreasuryImageViewController imageViewerController;
  private RecordTemplateListener<CollectionTemplate<TreasuryMedia, CollectionMetadata>> modelListener;
  @InjectView(2131757800)
  LinearLayout navContainer;
  @InjectView(2131757803)
  ImageButton nextButton;
  @InjectView(2131757801)
  TextView positionText;
  @InjectView(2131757802)
  ImageButton previousButton;
  private String profileId;
  @InjectView(2131757797)
  ProgressBar progressBar;
  private TreasurySectionType sectionType;
  private int startIndex;
  @InjectView(2131757798)
  Toolbar toolbar;
  int totalElementCount;
  private Map<String, String> trackingHeader;
  private CollectionTemplateHelper<TreasuryMedia, CollectionMetadata> treasuryCollectionHelper;
  @InjectView(2131757799)
  Button viewButton;
  @InjectView(2131757796)
  ViewPager viewPager;
  
  private void attachImageController(int paramInt)
  {
    if (paramInt != viewPager.getCurrentItem()) {}
    TreasuryDetailEntryViewModel localTreasuryDetailEntryViewModel;
    label58:
    TreasuryViewerFragment.6 local6;
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localTreasuryDetailEntryViewModel = (TreasuryDetailEntryViewModel)adapter.getItem(paramInt);
      if ((clickListener == null) || (mediaType == 2)) {
        break;
      }
      viewButton.setOnClickListener(clickListener);
      viewButton.setVisibility(0);
      if (viewHolder == null) {
        break label188;
      }
      bool = false;
      if (mediaType == 2) {
        bool = true;
      }
      local6 = new TreasuryViewerFragment.6(this, bool, localTreasuryDetailEntryViewModel);
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    imageViewerController = new TreasuryImageViewController(localFragmentActivity, viewHolder.imageView, backgroundOverlay, toolbar, viewHolder.bottomContainer, navContainer, local6);
    imageViewerController.updatePhotoViewConfiguration();
    imageViewerController.updateBounds(imageManagedBitmap);
    if ((bool) || (imageManagedBitmap == null)) {}
    for (boolean bool = true;; bool = false)
    {
      disableUIAutoHide = bool;
      return;
      viewButton.setVisibility(8);
      break label58;
      label188:
      break;
    }
  }
  
  private CollectionTemplateHelper<TreasuryMedia, CollectionMetadata> getCollectionHelper()
  {
    if (treasuryCollectionHelper == null) {
      treasuryCollectionHelper = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, TreasuryMedia.BUILDER, CollectionMetadata.BUILDER);
    }
    return treasuryCollectionHelper;
  }
  
  private Uri getTreasuryMediaUri()
  {
    switch (TreasuryViewerFragment.7.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$profile$treasury$TreasurySectionType[sectionType.ordinal()])
    {
    default: 
      return ProfileRoutes.buildTreasuryMediaRouteForSummary(profileId);
    case 1: 
      str = getArguments().getString("sectionId");
      return ProfileRoutes.buildTreasuryMediaRouteForPosition(profileId, str);
    }
    String str = getArguments().getString("sectionId");
    return ProfileRoutes.buildTreasuryMediaRouteForEducation(profileId, str);
  }
  
  public static TreasuryViewerFragment newInstance(Bundle paramBundle)
  {
    TreasuryViewerFragment localTreasuryViewerFragment = new TreasuryViewerFragment();
    localTreasuryViewerFragment.setArguments(paramBundle);
    return localTreasuryViewerFragment;
  }
  
  private void setPositionText(int paramInt)
  {
    ViewUtils.setTextAndUpdateVisibility(positionText, fragmentComponent.i18NManager().getString(2131233309, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(totalElementCount) }));
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean onBackPressed()
  {
    delayedExecution.stopDelayedExecution(autoHideRunnable);
    if (imageViewerController != null)
    {
      imageViewerController.scaleToOriginalSize();
      imageViewerController.showUIElements();
      return true;
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (currentOrientation != orientation)
    {
      currentOrientation = orientation;
      if (imageViewerController != null) {
        imageViewerController.updatePhotoViewConfiguration();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    profileId = getArguments().getString("profileId");
    sectionType = ((TreasurySectionType)getArguments().getSerializable("sectionType"));
    startIndex = getArguments().getInt("mediaIndex");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969233, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    delayedExecution.stopDelayedExecution(autoHideRunnable);
    adapter = null;
    treasuryCollectionHelper = null;
    imageViewerController = null;
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(TreasuryDetailEntryBoundEvent paramTreasuryDetailEntryBoundEvent)
  {
    if (adapterIndex == startIndex)
    {
      progressBar.setVisibility(8);
      viewPager.setVisibility(0);
      attachImageController(startIndex);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    delayedExecution.stopDelayedExecution(autoHideRunnable);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (imageViewerController != null) {
      imageViewerController.showUIElements();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    boolean bool2 = true;
    ImageButton localImageButton;
    if ((paramInt >= adapter.getCount() - 2) && (getCollectionHelper().hasMoreDataToFetch()))
    {
      if (getTreasuryMediaUri() != null) {
        getCollectionHelper().fetchLoadMoreData(trackingHeader, 0, null, getTreasuryMediaUri(), modelListener, getRumSessionId());
      }
    }
    else
    {
      localImageButton = previousButton;
      if (paramInt == 0) {
        break label136;
      }
      bool1 = true;
      label69:
      localImageButton.setEnabled(bool1);
      localImageButton = nextButton;
      if (paramInt >= totalElementCount - 1) {
        break label141;
      }
    }
    label136:
    label141:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageButton.setEnabled(bool1);
      setPositionText(paramInt);
      attachImageController(paramInt);
      return;
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot fetch treasury items because URI is null"));
      break;
      bool1 = false;
      break label69;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new TreasuryViewerFragment.2(this, tracker, "profile_modal_close", new TrackingEventBuilder[0]);
    toolbar.setNavigationOnClickListener(paramView);
    toolbar.setBackgroundResource(2130837820);
    viewPager.addOnPageChangeListener(this);
    trackingHeader = Tracker.createPageInstanceHeader(getPageInstance());
    modelListener = new TreasuryViewerFragment.3(this);
    if (getTreasuryMediaUri() != null) {
      getCollectionHelper().fetchInitialData(trackingHeader, 2, getTreasuryMediaUri().toString(), modelListener, getRumSessionId());
    }
    for (;;)
    {
      nextButton.setOnClickListener(new TreasuryViewerFragment.4(this, tracker, "treasury_viewer_view_next_clicked", new TrackingEventBuilder[0]));
      previousButton.setOnClickListener(new TreasuryViewerFragment.5(this, tracker, "treasury_viewer_view_previous_clicked", new TrackingEventBuilder[0]));
      return;
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot fetch treasury items because URI is null"));
    }
  }
  
  public final void onWindowFocusChanged$1385ff()
  {
    if (!disableUIAutoHide) {
      delayedExecution.postDelayedExecutionOptional(autoHideRunnable, 1300L);
    }
  }
  
  public final String pageKey()
  {
    return "profile_view_treasury";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.treasury.detail.TreasuryViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */