package com.linkedin.android.premium.chooser;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.premium.PremiumModel.ColoredText;
import com.linkedin.android.premium.PremiumModel.Gradient;
import com.linkedin.android.premium.PremiumUtils;

public final class PremiumChooserViewModel
  extends ViewModel<PremiumChooserViewHolder>
{
  private static final int TRANSPARENT = toTransparent(-1);
  public int displayedProductIndex;
  public PremiumModel.ColoredText footer;
  public PremiumModel.ColoredText header;
  public boolean headerIsDark;
  public boolean invertPageIndicatorColor;
  public int[] productColors;
  
  static int toTransparent(int paramInt)
  {
    return Color.argb(0, Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }
  
  public final ViewHolderCreator<PremiumChooserViewHolder> getCreator()
  {
    return PremiumChooserViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$28e92a97(LayoutInflater paramLayoutInflater, PremiumChooserViewHolder paramPremiumChooserViewHolder)
  {
    pager.setCurrentItem(displayedProductIndex);
    largePager.setCurrentItem(displayedProductIndex);
    Drawable localDrawable;
    if (headerIsDark)
    {
      localDrawable = DrawableHelper.setTint(ContextCompat.getDrawable(paramLayoutInflater.getContext(), 2130838613), ContextCompat.getColor(paramLayoutInflater.getContext(), 2131624058));
      lightToolbar.setVisibility(4);
      toolbar.setVisibility(0);
      toolbar.setLogo(localDrawable);
      localDrawable = ContextCompat.getDrawable(paramLayoutInflater.getContext(), 2130837933);
      if (!headerIsDark) {
        break label235;
      }
      paramLayoutInflater = DrawableHelper.setTint(localDrawable, ContextCompat.getColor(paramLayoutInflater.getContext(), 2131623957));
      largeDismiss.setImageDrawable(paramLayoutInflater);
      PremiumUtils.setBackground(new PremiumModel.Gradient(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { TRANSPARENT, -1, -1 }), new View[] { largeDismissBackground });
    }
    for (;;)
    {
      PremiumUtils.setTextAndColor(header, new TextView[] { headerText });
      PremiumUtils.setTextAndColor(footer, new TextView[] { footer });
      pageIndicator.setInvert(invertPageIndicatorColor);
      paramPremiumChooserViewHolder.hideSplashPage();
      return;
      toolbar.setVisibility(4);
      lightToolbar.setVisibility(0);
      lightToolbar.setLogo(2130838613);
      break;
      label235:
      paramLayoutInflater = DrawableHelper.setTint(localDrawable, ContextCompat.getColor(paramLayoutInflater.getContext(), 2131624058));
      largeDismiss.setImageDrawable(paramLayoutInflater);
      PremiumUtils.setBackground(new PremiumModel.Gradient(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { TRANSPARENT, -16777216, -16777216 }), new View[] { largeDismissBackground });
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */