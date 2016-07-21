package com.linkedin.android.growth.abi.m2g;

import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.TintableImageView;

public class AbiGuestContactViewHolder$$ViewInjector<T extends AbiGuestContactViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755927, "field 'title'"), 2131755927, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755928, "field 'subtitle'"), 2131755928, "field 'subtitle'"));
    invitationIconContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755944, "field 'invitationIconContainer'"));
    m2gItemContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755921, "field 'm2gItemContainer'"));
    m2gItemPictureContainer = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755922, "field 'm2gItemPictureContainer'"), 2131755922, "field 'm2gItemPictureContainer'"));
    m2gItemPictureImageView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755923, "field 'm2gItemPictureImageView'"), 2131755923, "field 'm2gItemPictureImageView'"));
    m2gItemPictureTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755924, "field 'm2gItemPictureTextView'"), 2131755924, "field 'm2gItemPictureTextView'"));
    connectText = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755946, null), 2131755946, "field 'connectText'"));
    invitedText = ((Button)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755947, null), 2131755947, "field 'invitedText'"));
    inviteButtonInternational = ((TintableImageView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755945, null), 2131755945, "field 'inviteButtonInternational'"));
    inviteButtonInternationalClicked = ((AppCompatImageButton)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755910, null), 2131755910, "field 'inviteButtonInternationalClicked'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    subtitle = null;
    invitationIconContainer = null;
    m2gItemContainer = null;
    m2gItemPictureContainer = null;
    m2gItemPictureImageView = null;
    m2gItemPictureTextView = null;
    connectText = null;
    invitedText = null;
    inviteButtonInternational = null;
    inviteButtonInternationalClicked = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.AbiGuestContactViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */