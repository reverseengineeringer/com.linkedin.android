package com.linkedin.android.growth.login.phoneverification;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PhoneConfirmationFragment$$ViewInjector<T extends PhoneConfirmationFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131756169, "field 'phoneConfirm' and method 'onPhoneNumberEdited'");
    phoneConfirm = ((EditText)paramFinder.castView(localView, 2131756169, "field 'phoneConfirm'"));
    ((TextView)localView).addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramT.onPhoneNumberEdited(paramAnonymousEditable);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    countrySelector = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756168, "field 'countrySelector'"), 2131756168, "field 'countrySelector'"));
    phoneConfirmButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756171, "field 'phoneConfirmButton'"), 2131756171, "field 'phoneConfirmButton'"));
  }
  
  public void reset(T paramT)
  {
    phoneConfirm = null;
    countrySelector = null;
    phoneConfirmButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */