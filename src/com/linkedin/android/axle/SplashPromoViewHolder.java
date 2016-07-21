package com.linkedin.android.axle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.crosspromo.fe.api.android.Promo;

class SplashPromoViewHolder
  extends BaseViewHolder
{
  final ViewGroup container;
  @InjectView(2131755231)
  Button dismissButton;
  private final FragmentComponent fragmentComponent;
  final FragmentManager fragmentManager;
  final LayoutInflater inflater;
  final boolean isDogfoodSplash;
  @InjectView(2131755229)
  HorizontalViewPagerCarousel pagerIndicator;
  final SplashPromo promoTemplate;
  private final View promoView;
  @InjectView(2131755232)
  Button promptButton;
  @InjectView(2131755233)
  Button secondaryPromptButton;
  @InjectView(2131755227)
  TextView title;
  final Tracker tracker;
  @InjectView(2131755228)
  WrapContentHeightViewPager viewPager;
  @InjectView(2131755226)
  ViewGroup viewPagerContainer;
  
  SplashPromoViewHolder(SplashPromo paramSplashPromo, FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager, Tracker paramTracker, ViewGroup paramViewGroup, View paramView, boolean paramBoolean)
  {
    super(paramView);
    promoTemplate = paramSplashPromo;
    promoView = paramView;
    fragmentComponent = paramFragmentComponent;
    fragmentManager = paramFragmentManager;
    tracker = paramTracker;
    container = paramViewGroup;
    inflater = LayoutInflater.from(paramView.getContext());
    isDogfoodSplash = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */