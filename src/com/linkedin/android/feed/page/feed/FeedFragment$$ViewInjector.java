package com.linkedin.android.feed.page.feed;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.EfficientCoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.internal.DebouncingOnClickListener;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton;
import com.makeramen.roundedimageview.RoundedImageView;

public class FeedFragment$$ViewInjector<T extends FeedFragment>
  extends BaseFeedFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    coordinatorLayout = ((EfficientCoordinatorLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755782, "field 'coordinatorLayout'"), 2131755782, "field 'coordinatorLayout'"));
    appBarLayout = ((AppBarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755784, "field 'appBarLayout'"), 2131755784, "field 'appBarLayout'"));
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131755800, "field 'fab' and method 'shareButtonClick'");
    fab = ((FloatingActionButton)paramFinder.castView(localView, 2131755800, "field 'fab'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.shareButtonClick();
      }
    });
    updatesContainer = ((EfficientCoordinatorLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755793, "field 'updatesContainer'"), 2131755793, "field 'updatesContainer'"));
    errorViewStub = ((ViewStub)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755783, "field 'errorViewStub'"), 2131755783, "field 'errorViewStub'"));
    buttonLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755731, "field 'buttonLayout'"), 2131755731, "field 'buttonLayout'"));
    localView = (View)paramFinder.findRequiredView(paramObject, 2131755785, "field 'upperLayout' and method 'shareHeaderClick'");
    upperLayout = ((LinearLayout)paramFinder.castView(localView, 2131755785, "field 'upperLayout'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.shareHeaderClick();
      }
    });
    actorImage = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755786, "field 'actorImage'"), 2131755786, "field 'actorImage'"));
    shareHeaderHintText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755787, "field 'shareHeaderHintText'"), 2131755787, "field 'shareHeaderHintText'"));
    localView = (View)paramFinder.findRequiredView(paramObject, 2131755789, "field 'shareButton' and method 'shareButtonClick'");
    shareButton = ((LinearLayout)paramFinder.castView(localView, 2131755789, "field 'shareButton'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.shareButtonClick();
      }
    });
    localView = (View)paramFinder.findRequiredView(paramObject, 2131755791, "field 'cameraButton' and method 'shareCameraClick'");
    cameraButton = ((LinearLayout)paramFinder.castView(localView, 2131755791, "field 'cameraButton'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.shareCameraClick();
      }
    });
    shareButtonText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755790, "field 'shareButtonText'"), 2131755790, "field 'shareButtonText'"));
    cameraButtonText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755792, "field 'cameraButtonText'"), 2131755792, "field 'cameraButtonText'"));
    headerDropShadow = ((View)paramFinder.findRequiredView(paramObject, 2131755799, "field 'headerDropShadow'"));
    localView = (View)paramFinder.findRequiredView(paramObject, 2131755798, "field 'newUpdatesPill' and method 'onNewUpdatesClicked'");
    newUpdatesPill = ((NewUpdatesPillButton)paramFinder.castView(localView, 2131755798, "field 'newUpdatesPill'"));
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.onNewUpdatesClicked();
      }
    });
    heroContainer = ((CollapsingToolbarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755795, "field 'heroContainer'"), 2131755795, "field 'heroContainer'"));
    heroAppBarLayout = ((AppBarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755794, "field 'heroAppBarLayout'"), 2131755794, "field 'heroAppBarLayout'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    coordinatorLayout = null;
    appBarLayout = null;
    fab = null;
    updatesContainer = null;
    errorViewStub = null;
    buttonLayout = null;
    upperLayout = null;
    actorImage = null;
    shareHeaderHintText = null;
    shareButton = null;
    cameraButton = null;
    shareButtonText = null;
    cameraButtonText = null;
    headerDropShadow = null;
    newUpdatesPill = null;
    heroContainer = null;
    heroAppBarLayout = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */