package com.linkedin.android.feed.shared.imageviewer;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class ImageViewerOnClickListener
  extends TrackingOnClickListener
{
  private boolean alreadyDisplayingUpdateDetail;
  private FragmentComponent fragmentComponent;
  private long mLastClickTime;
  private Image placeholderImage;
  private Update update;
  private String updateEntityUrnString;
  private String updateUrn;
  
  public ImageViewerOnClickListener(Update paramUpdate, boolean paramBoolean, FragmentComponent paramFragmentComponent, Image paramImage, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    update = paramUpdate;
    updateUrn = urn.toString();
    if (entityUrn == null) {}
    for (paramUpdate = null;; paramUpdate = entityUrn.toString())
    {
      updateEntityUrnString = paramUpdate;
      alreadyDisplayingUpdateDetail = paramBoolean;
      fragmentComponent = paramFragmentComponent;
      placeholderImage = paramImage;
      return;
    }
  }
  
  public ImageViewerOnClickListener(String paramString1, FragmentComponent paramFragmentComponent, Image paramImage, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString2, paramVarArgs);
    updateUrn = paramString1;
    updateEntityUrnString = null;
    alreadyDisplayingUpdateDetail = false;
    fragmentComponent = paramFragmentComponent;
    placeholderImage = paramImage;
  }
  
  public final void onClick(View paramView)
  {
    if (SystemClock.elapsedRealtime() - mLastClickTime < 1500L) {
      return;
    }
    mLastClickTime = SystemClock.elapsedRealtime();
    super.onClick(paramView);
    Fragment localFragment = fragmentComponent.fragment();
    ImageViewerBundle localImageViewerBundle = null;
    if (update != null) {
      localImageViewerBundle = ImageViewerBundle.create(update, alreadyDisplayingUpdateDetail);
    }
    for (;;)
    {
      if (localImageViewerBundle != null)
      {
        if (placeholderImage != null) {
          localImageViewerBundle.setPlaceholderImage(placeholderImage);
        }
        localFragment.startActivityForResult(fragmentComponent.intentRegistry().imageViewer.newIntent(fragmentComponent.activity(), localImageViewerBundle), 15, ActivityOptionsCompat.makeSceneTransitionAnimation(localFragment.getActivity(), paramView, paramView.getResources().getString(2131233909)).toBundle());
      }
      fragmentComponent.eventBus();
      Bus.publish(new ClickEvent(19, updateUrn.toString()));
      return;
      if (!TextUtils.isEmpty(updateUrn)) {
        localImageViewerBundle = ImageViewerBundle.create(updateUrn, updateEntityUrnString, alreadyDisplayingUpdateDetail);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */