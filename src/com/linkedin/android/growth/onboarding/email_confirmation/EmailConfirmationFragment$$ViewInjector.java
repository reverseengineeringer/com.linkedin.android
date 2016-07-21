package com.linkedin.android.growth.onboarding.email_confirmation;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.CustomTextInputLayout;

public class EmailConfirmationFragment$$ViewInjector<T extends EmailConfirmationFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756095, "field 'title'"), 2131756095, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756096, "field 'subtitle'"), 2131756096, "field 'subtitle'"));
    emailContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756097, "field 'emailContainer'"), 2131756097, "field 'emailContainer'"));
    emailInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756098, "field 'emailInput'"), 2131756098, "field 'emailInput'"));
    goToEmail = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756106, "field 'goToEmail'"), 2131756106, "field 'goToEmail'"));
    skipButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756107, "field 'skipButton'"), 2131756107, "field 'skipButton'"));
    emailLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756099, "field 'emailLabel'"), 2131756099, "field 'emailLabel'"));
    resendEmailText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756102, "field 'resendEmailText'"), 2131756102, "field 'resendEmailText'"));
    clearButton = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756101, "field 'clearButton'"), 2131756101, "field 'clearButton'"));
    editButton = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756100, "field 'editButton'"), 2131756100, "field 'editButton'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    subtitle = null;
    emailContainer = null;
    emailInput = null;
    goToEmail = null;
    skipButton = null;
    emailLabel = null;
    resendEmailText = null;
    clearButton = null;
    editButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */