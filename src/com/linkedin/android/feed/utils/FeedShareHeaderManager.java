package com.linkedin.android.feed.utils;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.behavior.FABVerticalScrollHideBehavior;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.ref.WeakReference;

public final class FeedShareHeaderManager
{
  private WeakReference<RoundedImageView> actorImageReference;
  private WeakReference<AppBarLayout> appBarLayoutReference;
  private Context context;
  private WeakReference<FloatingActionButton> fabReference;
  private WeakReference<FragmentComponent> fragmentComponent;
  private WeakReference<View> headerDropShadowReference;
  private WeakReference<TextView> shareHeaderHintTextReference;
  private WeakReference<LinearLayout> upperLayoutReference;
  private boolean usingFab;
  
  public FeedShareHeaderManager(FragmentComponent paramFragmentComponent, AppBarLayout paramAppBarLayout, View paramView, LinearLayout paramLinearLayout, RoundedImageView paramRoundedImageView, TextView paramTextView, FloatingActionButton paramFloatingActionButton, String paramString)
  {
    context = paramFragmentComponent.context();
    fragmentComponent = new WeakReference(paramFragmentComponent);
    appBarLayoutReference = new WeakReference(paramAppBarLayout);
    headerDropShadowReference = new WeakReference(paramView);
    upperLayoutReference = new WeakReference(paramLinearLayout);
    actorImageReference = new WeakReference(paramRoundedImageView);
    shareHeaderHintTextReference = new WeakReference(paramTextView);
    fabReference = new WeakReference(paramFloatingActionButton);
    paramFragmentComponent = (FragmentComponent)fragmentComponent.get();
    int i;
    if (paramFragmentComponent != null)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          setupShareHeader(null);
        }
        break;
      }
    }
    do
    {
      return;
      if (!paramString.equals("fab")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("open_share_box_1")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("open_share_box_2")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("open_share_box_3")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("open_share_box_4")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("open_share_box_5")) {
        break;
      }
      i = 5;
      break;
      if (!"fab".equals(paramFragmentComponent.homeCachedLix().getTreatment(Lix.FEED_SHARE_ENTRY_POINT))) {
        break label452;
      }
      usingFab = true;
      paramView = (FloatingActionButton)fabReference.get();
      paramFragmentComponent = (AppBarLayout)appBarLayoutReference.get();
      paramAppBarLayout = (View)headerDropShadowReference.get();
    } while ((paramView == null) || (paramFragmentComponent == null) || (paramAppBarLayout == null));
    paramView.show();
    paramLinearLayout = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
    paramLinearLayout.setBehavior(new FABVerticalScrollHideBehavior());
    paramView.setLayoutParams(paramLinearLayout);
    paramView = (CoordinatorLayout.LayoutParams)paramFragmentComponent.getLayoutParams();
    height = 0;
    paramFragmentComponent.setLayoutParams(paramView);
    paramAppBarLayout.setVisibility(8);
    return;
    label452:
    setupShareHeader(null);
    return;
    setupShareHeader(paramFragmentComponent.i18NManager().getString(2131231293));
    return;
    setupShareHeader(paramFragmentComponent.i18NManager().getString(2131231294));
    return;
    setupShareHeader(paramFragmentComponent.i18NManager().getString(2131231295));
    return;
    setupShareHeader(paramFragmentComponent.i18NManager().getString(2131231296));
    return;
    setupShareHeader(paramFragmentComponent.i18NManager().getString(2131231297));
  }
  
  private void setupShareHeader(String paramString)
  {
    usingFab = false;
    FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
    RoundedImageView localRoundedImageView = (RoundedImageView)actorImageReference.get();
    TextView localTextView = (TextView)shareHeaderHintTextReference.get();
    LinearLayout localLinearLayout = (LinearLayout)upperLayoutReference.get();
    if ((paramString != null) && (localFragmentComponent != null) && (localRoundedImageView != null) && (localTextView != null))
    {
      setupProfileImage(localFragmentComponent.memberUtil().getMiniProfile());
      localTextView.setText(paramString);
    }
    while (localLinearLayout == null) {
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public final void setShareActionsVisibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (usingFab)
    {
      localObject = (FloatingActionButton)fabReference.get();
      if (localObject != null)
      {
        if (!paramBoolean1) {
          break label31;
        }
        ((FloatingActionButton)localObject).show();
      }
    }
    label31:
    do
    {
      return;
      ((FloatingActionButton)localObject).hide();
      return;
      localObject = (AppBarLayout)appBarLayoutReference.get();
    } while (localObject == null);
    ((AppBarLayout)localObject).setExpanded(paramBoolean1, paramBoolean2);
  }
  
  public final void setupProfileImage(MiniProfile paramMiniProfile)
  {
    RoundedImageView localRoundedImageView = (RoundedImageView)actorImageReference.get();
    FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
    if (localRoundedImageView != null)
    {
      if ((localFragmentComponent != null) && (paramMiniProfile != null)) {
        new ImageModel(picture, GhostImageUtils.getPerson(2131492961, paramMiniProfile), Util.retrieveRumSessionId(localFragmentComponent)).setImageView(localFragmentComponent.mediaCenter(), localRoundedImageView);
      }
    }
    else {
      return;
    }
    localRoundedImageView.setImageDrawable(GhostImageUtils.getAnonymousPerson(2131492961).getDrawable(context));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedShareHeaderManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */