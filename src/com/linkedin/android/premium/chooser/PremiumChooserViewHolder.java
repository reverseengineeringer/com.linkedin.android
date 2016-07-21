package com.linkedin.android.premium.chooser;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.premium.StripedFrameLayout;

public class PremiumChooserViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<PremiumChooserViewHolder> CREATOR = new PremiumChooserViewHolder.1();
  @InjectView(2131757204)
  View background;
  @InjectView(2131757205)
  LiImageView backgroundImage;
  @InjectView(2131757208)
  TextView footer;
  @InjectView(2131757206)
  TextView headerText;
  @InjectView(2131757216)
  View large;
  @InjectView(2131757219)
  ImageButton largeDismiss;
  @InjectView(2131757218)
  View largeDismissBackground;
  @InjectView(2131757217)
  ViewPager largePager;
  @InjectView(2131757203)
  View layout;
  @InjectView(2131757212)
  Toolbar lightToolbar;
  @InjectView(2131757210)
  View multiViewPager;
  @InjectView(2131757209)
  HorizontalViewPagerCarousel pageIndicator;
  @InjectView(2131757211)
  ViewPager pager;
  @InjectView(2131757213)
  View splash;
  @InjectView(2131757214)
  StripedFrameLayout splashLogo;
  @InjectView(2131757207)
  Toolbar toolbar;
  
  private PremiumChooserViewHolder(View paramView)
  {
    super(paramView);
  }
  
  static PremiumChooserViewHolder createView$15152deb(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(CREATOR.getLayoutId(), paramViewGroup, false);
    return (PremiumChooserViewHolder)CREATOR.createViewHolder(paramLayoutInflater);
  }
  
  final void hideSplashPage()
  {
    splash.animate().alpha(0.0F).setDuration(splash.getResources().getInteger(2131558409)).setListener(new PremiumChooserViewHolder.2(this));
  }
  
  public final void showSplashPage()
  {
    splash.setVisibility(0);
    splashLogo.startStripeAnimator();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */