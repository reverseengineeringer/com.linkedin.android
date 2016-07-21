package com.linkedin.android.feed.shared.imageviewer;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider;
import com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider.UpdateDetailState;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.transformer.FeedImageViewerContentDetailTransformer;
import com.linkedin.android.feed.endor.ui.transformer.FeedImageViewerContentDetailTransformer.ImageViewerFragmentViewModelHolder;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageviewer.ImageViewerController;
import com.linkedin.android.imageviewer.ImageViewerController.ImageViewerListener;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.ImageRequest.ImageRequestListener;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.OnWindowFocusChangedListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class ImageViewerFragment
  extends PageFragment
  implements FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider, ImageRequest.ImageRequestListener, OnBackPressedListener, OnWindowFocusChangedListener
{
  private static final String TAG = ImageViewerFragment.class.getSimpleName();
  @Inject
  ActivityComponent activityComponent;
  private Runnable autoHideRunnable = new Runnable()
  {
    public final void run()
    {
      if (imageViewerController != null)
      {
        imageViewerController.enterFullscreenMode();
        imageViewerController.hideUIElements();
      }
    }
  };
  @InjectView(2131755816)
  View backgroundOverlay;
  @InjectView(2131755818)
  FeedComponentsView bottomContainer;
  private int currentOrientation;
  private long displayedTime;
  private FeedUpdateDetailDataProvider feedUpdateDetailDataProvider;
  @Inject
  FragmentComponent fragmentComponent;
  @InjectView(2131755817)
  LiImageView imageView;
  private ImageViewerController imageViewerController;
  private boolean isExiting;
  @Inject
  MediaCenter mediaCenter;
  private Image placeholderImage;
  @InjectView(2131755468)
  Toolbar toolbar;
  Update update;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  private String updateEntityUrnString;
  private String updateUrn;
  FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  
  private void fetchUpdateFromNetwork()
  {
    Object localObject = fragmentComponent;
    localObject = FeedRouteUtils.getSingleUpdateUrl((FragmentComponent)localObject, updateUrn, FeedRouteUtils.getCommentCount(((FragmentComponent)localObject).lixManager()), null);
    if ((!TextUtils.isEmpty(getRumSessionId())) && (feedUpdateDetailDataProvider != null)) {
      feedUpdateDetailDataProvider.performFullUpdateFetch(busSubscriberId, getRumSessionId(), (String)localObject, null, null, null, Tracker.createPageInstanceHeader(getPageInstance()));
    }
  }
  
  private void loadImage(Image paramImage)
  {
    if ((mediaCenter != null) && (imageView != null))
    {
      imageView.setVisibility(0);
      paramImage = mediaCenter.load(paramImage, getRumSessionId());
      placeholderDrawable = new ColorDrawable(ContextCompat.getColor(getContext(), 2131624051));
      requestListener = this;
      paramImage.into(imageView);
      if (imageViewerController != null) {
        imageViewerController.updatePhotoViewConfiguration();
      }
    }
  }
  
  private void setupWithInitialUpdate(Update paramUpdate)
  {
    if ((paramUpdate == null) || (!isAdded())) {
      return;
    }
    fragmentComponent.updateChangeCoordinator().listenForUpdates(paramUpdate, updateChangedListener);
    paramUpdate = FeedImageViewerContentDetailTransformer.toViewModel(fragmentComponent, viewPool, paramUpdate);
    if (image != null) {
      loadImage(image);
    }
    setupContentDetail(contentDetailViewModel);
    bottomContainer.setVisibility(0);
  }
  
  public final void doPause()
  {
    super.doPause();
    if ((update != null) && (update.tracking != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = displayedTime;
      getContext();
      FeedTracking.trackDetailFIE$5e2dcd44(tracker, update, update.tracking, displayedTime, l1 - l2);
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    if (feedUpdateDetailDataProvider != null) {
      feedUpdateDetailDataProvider.register(this);
    }
    displayedTime = System.currentTimeMillis();
  }
  
  public final int feedType()
  {
    return 2;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean onBackPressed()
  {
    delayedExecution.stopDelayedExecution(autoHideRunnable);
    if ((imageViewerController != null) && (imageViewerController.isScaled()))
    {
      imageViewerController.scaleToOriginalSize();
      imageViewerController.showUIElements();
      imageViewerController.exitFullscreenMode();
      return true;
    }
    if ((imageViewerController != null) && (imageViewerController.isInFullScreen()))
    {
      imageViewerController.toggleFullscreenMode();
      return true;
    }
    isExiting = true;
    if ((Build.VERSION.SDK_INT == 21) && (imageView.getDrawable() == null)) {
      getActivity().getWindow().setSharedElementEnterTransition(null);
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
    fragmentComponent.inject(this);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      updateUrn = ImageViewerBundle.getUpdateUrn(paramBundle);
      updateEntityUrnString = paramBundle.getString("updateEntityUrn");
      update = ImageViewerBundle.getUpdate(paramBundle);
      if ((update != null) && (update.entityUrn != null) && (updateEntityUrnString == null)) {
        updateEntityUrnString = update.entityUrn.toString();
      }
      placeholderImage = ImageViewerBundle.getPlaceholderImage(paramBundle);
    }
    if (activityComponent != null) {
      feedUpdateDetailDataProvider = activityComponent.feedUpdateDetailProvider();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968754, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    Log.e(TAG, "performFullUpdateFetch() failed with error ", paramDataManagerException);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramType = null;
    if (feedUpdateDetailDataProvider != null) {
      paramType = ((FeedUpdateDetailDataProvider.UpdateDetailState)feedUpdateDetailDataProvider.state).update();
    }
    if (paramType != null)
    {
      update = paramType;
      setupWithInitialUpdate(paramType);
    }
  }
  
  public void onDestroyView()
  {
    delayedExecution.stopDelayedExecution(autoHideRunnable);
    fragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    feedUpdateDetailDataProvider = null;
    imageViewerController = null;
    super.onDestroyView();
  }
  
  public final void onErrorResponse(Object paramObject, String paramString, Exception paramException)
  {
    Log.e(TAG, "image request failed with error ", paramException);
  }
  
  public final void onResponse(Object paramObject, String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    if ((!isAdded()) || (imageView == null)) {}
    while (imageViewerController == null) {
      return;
    }
    imageViewerController.updateBounds(paramManagedBitmap);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new ImageViewerController.ImageViewerListener()
    {
      public final void dismiss()
      {
        NavigationUtils.onUpPressed(getActivity(), true);
      }
      
      public final void moved()
      {
        delayedExecution.stopDelayedExecution(autoHideRunnable);
        new ControlInteractionEvent(tracker, "richmedia_viewer_container", ControlType.GESTURE_AREA, InteractionType.DRAG).send();
      }
      
      public final void tapped()
      {
        delayedExecution.stopDelayedExecution(autoHideRunnable);
        if (imageViewerController != null) {
          imageViewerController.toggleFullscreenMode();
        }
        trackButtonShortPress("richmedia_viewer_container");
      }
    };
    paramBundle = (BaseActivity)getActivity();
    if (paramBundle != null)
    {
      imageViewerController = new ImageViewerController(paramBundle, imageView, backgroundOverlay, toolbar, bottomContainer, paramView, true);
      imageViewerController.updatePhotoViewConfiguration();
      paramBundle.setEnterSharedElementCallback(new SharedElementCallback()
      {
        public final void onSharedElementStart(List<String> paramAnonymousList, List<View> paramAnonymousList1, List<View> paramAnonymousList2)
        {
          super.onSharedElementStart(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
          if (isExiting) {
            imageViewerController.cleanUp();
          }
        }
      });
    }
    currentOrientation = getResourcesgetConfigurationorientation;
    if (placeholderImage != null) {
      loadImage(placeholderImage);
    }
    paramView = new TrackingOnClickListener(tracker, "close", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = fragmentComponent.intentRegistry().home;
        FragmentActivity localFragmentActivity = getActivity();
        HomeBundle localHomeBundle = new HomeBundle();
        activeTab = HomeTabInfo.NOTIFICATIONS;
        paramAnonymousView = paramAnonymousView.newIntent(localFragmentActivity, localHomeBundle);
        NavigationUtils.navigateUp(getActivity(), paramAnonymousView, true);
      }
    };
    toolbar.setNavigationOnClickListener(paramView);
    toolbar.setBackgroundResource(2130837820);
    if (update != null) {
      setupWithInitialUpdate(update);
    }
    while (TextUtils.isEmpty(updateUrn)) {
      return;
    }
    paramView = new DefaultModelListener()
    {
      public final void onCacheError(DataManagerException paramAnonymousDataManagerException)
      {
        ImageViewerFragment.this.fetchUpdateFromNetwork();
      }
    };
    if (updateEntityUrnString != null)
    {
      FeedBundleBuilder.loadUpdateFromCache(fragmentComponent.dataManager(), paramView, updateEntityUrnString);
      return;
    }
    fetchUpdateFromNetwork();
  }
  
  public final void onWindowFocusChanged$1385ff()
  {
    delayedExecution.postDelayedExecutionOptional(autoHideRunnable, 1300L);
  }
  
  public final String pageKey()
  {
    return "feed_richmedia_viewer";
  }
  
  public final String provideDebugData()
  {
    if (update != null) {}
    for (String str = update.urn.toString(); str != null; str = updateUrn) {
      return "Image Viewer Activity Id: " + str;
    }
    return null;
  }
  
  final void setupContentDetail(FeedUpdateViewModel paramFeedUpdateViewModel)
  {
    bottomContainer.renderComponentChanges(paramFeedUpdateViewModel.getComponents(), LayoutInflater.from(fragmentComponent.context()), fragmentComponent.mediaCenter(), viewPool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */