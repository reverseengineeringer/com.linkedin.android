package com.linkedin.android.growth.login.join;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.CustomTextInputLayout;

public class JoinFragment$$ViewInjector<T extends JoinFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    fullNameContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756011, null), 2131756011, "field 'fullNameContainer'"));
    fullNameInput = ((EditText)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756012, null), 2131756012, "field 'fullNameInput'"));
    fullNameLabel = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756013, null), 2131756013, "field 'fullNameLabel'"));
    firstNameContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756014, "field 'firstNameContainer'"), 2131756014, "field 'firstNameContainer'"));
    firstNameInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756015, "field 'firstNameInput'"), 2131756015, "field 'firstNameInput'"));
    lastNameContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756017, "field 'lastNameContainer'"), 2131756017, "field 'lastNameContainer'"));
    lastNameInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756018, "field 'lastNameInput'"), 2131756018, "field 'lastNameInput'"));
    emailOrPhoneContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756024, "field 'emailOrPhoneContainer'"), 2131756024, "field 'emailOrPhoneContainer'"));
    emailOrPhoneInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756025, "field 'emailOrPhoneInput'"), 2131756025, "field 'emailOrPhoneInput'"));
    passwordContainer = ((CustomTextInputLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756027, "field 'passwordContainer'"), 2131756027, "field 'passwordContainer'"));
    passwordInput = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756028, "field 'passwordInput'"), 2131756028, "field 'passwordInput'"));
    legalText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756008, "field 'legalText'"), 2131756008, "field 'legalText'"));
    joinButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756009, "field 'joinButton'"), 2131756009, "field 'joinButton'"));
    accountExistText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756010, "field 'accountExistText'"), 2131756010, "field 'accountExistText'"));
    firstNameLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756016, "field 'firstNameLabel'"), 2131756016, "field 'firstNameLabel'"));
    lastNameLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756019, "field 'lastNameLabel'"), 2131756019, "field 'lastNameLabel'"));
    emailOrPhoneBoxLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756026, "field 'emailOrPhoneBoxLabel'"), 2131756026, "field 'emailOrPhoneBoxLabel'"));
    passwordBoxLabel = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756029, "field 'passwordBoxLabel'"), 2131756029, "field 'passwordBoxLabel'"));
  }
  
  public void reset(T paramT)
  {
    fullNameContainer = null;
    fullNameInput = null;
    fullNameLabel = null;
    firstNameContainer = null;
    firstNameInput = null;
    lastNameContainer = null;
    lastNameInput = null;
    emailOrPhoneContainer = null;
    emailOrPhoneInput = null;
    passwordContainer = null;
    passwordInput = null;
    legalText = null;
    joinButton = null;
    accountExistText = null;
    firstNameLabel = null;
    lastNameLabel = null;
    emailOrPhoneBoxLabel = null;
    passwordBoxLabel = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */