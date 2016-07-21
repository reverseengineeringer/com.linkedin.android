package com.linkedin.android.growth.login.phoneverification;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PinVerificationFragment$$ViewInjector<T extends PinVerificationFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    pinVerifyButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756181, "field 'pinVerifyButton'"), 2131756181, "field 'pinVerifyButton'"));
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131756179, "field 'pinInputText' and method 'onPinEdited'");
    pinInputText = ((EditText)paramFinder.castView(localView, 2131756179, "field 'pinInputText'"));
    ((TextView)localView).addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramT.onPinEdited(paramAnonymousEditable);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    resendPinButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756182, "field 'resendPinButton'"), 2131756182, "field 'resendPinButton'"));
    changePhoneNumberButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756183, "field 'changePhoneNumberButton'"), 2131756183, "field 'changePhoneNumberButton'"));
    pinVerificationTitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756177, "field 'pinVerificationTitle'"), 2131756177, "field 'pinVerificationTitle'"));
  }
  
  public void reset(T paramT)
  {
    pinVerifyButton = null;
    pinInputText = null;
    resendPinButton = null;
    changePhoneNumberButton = null;
    pinVerificationTitle = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */