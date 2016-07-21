package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class ApplyJobViaLinkedInViewHolder$$ViewInjector<T extends ApplyJobViaLinkedInViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    actorImage = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755535, "field 'actorImage'"), 2131755535, "field 'actorImage'"));
    name = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755523, "field 'name'"), 2131755523, "field 'name'"));
    headline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755524, "field 'headline'"), 2131755524, "field 'headline'"));
    location = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755525, "field 'location'"), 2131755525, "field 'location'"));
    emailInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755526, "field 'emailInput'"), 2131755526, "field 'emailInput'"));
    phoneInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755528, "field 'phoneInput'"), 2131755528, "field 'phoneInput'"));
    submitApplicationButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755531, "field 'submitApplicationButton'"), 2131755531, "field 'submitApplicationButton'"));
    editProfileButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755532, "field 'editProfileButton'"), 2131755532, "field 'editProfileButton'"));
    closeModalButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755536, "field 'closeModalButton'"), 2131755536, "field 'closeModalButton'"));
    loadingOverlay = ((View)paramFinder.findRequiredView(paramObject, 2131755533, "field 'loadingOverlay'"));
    loadingSpinner = ((ProgressBar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755534, "field 'loadingSpinner'"), 2131755534, "field 'loadingSpinner'"));
  }
  
  public void reset(T paramT)
  {
    actorImage = null;
    name = null;
    headline = null;
    location = null;
    emailInput = null;
    phoneInput = null;
    submitApplicationButton = null;
    editProfileButton = null;
    closeModalButton = null;
    loadingOverlay = null;
    loadingSpinner = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */