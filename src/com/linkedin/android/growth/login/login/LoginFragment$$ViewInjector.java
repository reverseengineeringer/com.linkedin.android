package com.linkedin.android.growth.login.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.CustomTextInputLayout;

public class LoginFragment$$ViewInjector<T extends LoginFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    emailOrPhoneContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756024, "field 'emailOrPhoneContainer'"), 2131756024, "field 'emailOrPhoneContainer'"));
    emailOrPhoneInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756025, "field 'emailOrPhoneInput'"), 2131756025, "field 'emailOrPhoneInput'"));
    passwordContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756027, "field 'passwordContainer'"), 2131756027, "field 'passwordContainer'"));
    passwordInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756028, "field 'passwordInput'"), 2131756028, "field 'passwordInput'"));
    signInButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756021, "field 'signInButton'"), 2131756021, "field 'signInButton'"));
    forgetPasswordText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756022, "field 'forgetPasswordText'"), 2131756022, "field 'forgetPasswordText'"));
    joinText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756023, "field 'joinText'"), 2131756023, "field 'joinText'"));
    emailOrPhoneBoxLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756026, "field 'emailOrPhoneBoxLabel'"), 2131756026, "field 'emailOrPhoneBoxLabel'"));
    passwordBoxLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756029, "field 'passwordBoxLabel'"), 2131756029, "field 'passwordBoxLabel'"));
  }
  
  public void reset(T paramT)
  {
    emailOrPhoneContainer = null;
    emailOrPhoneInput = null;
    passwordContainer = null;
    passwordInput = null;
    signInButton = null;
    forgetPasswordText = null;
    joinText = null;
    emailOrPhoneBoxLabel = null;
    passwordBoxLabel = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */