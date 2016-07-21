package com.linkedin.android.growth.abi.m2m;

import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.TintableImageView;

public class AbiMemberContactViewHolder$$ViewInjector<T extends AbiMemberContactViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    connectText = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755946, null), 2131755946, "field 'connectText'"));
    invitedText = ((Button)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755947, null), 2131755947, "field 'invitedText'"));
    connectButtonInternational = ((TintableImageView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755945, null), 2131755945, "field 'connectButtonInternational'"));
    inviteButtonInternationalClicked = ((AppCompatImageButton)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755910, null), 2131755910, "field 'inviteButtonInternationalClicked'"));
    picture = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755930, "field 'picture'"), 2131755930, "field 'picture'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755932, "field 'title'"), 2131755932, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755933, "field 'subtitle'"), 2131755933, "field 'subtitle'"));
    invitationIconContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755944, "field 'invitationIconContainer'"));
    m2mItemContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755929, "field 'm2mItemContainer'"));
  }
  
  public void reset(T paramT)
  {
    connectText = null;
    invitedText = null;
    connectButtonInternational = null;
    inviteButtonInternationalClicked = null;
    picture = null;
    title = null;
    subtitle = null;
    invitationIconContainer = null;
    m2mItemContainer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.AbiMemberContactViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */