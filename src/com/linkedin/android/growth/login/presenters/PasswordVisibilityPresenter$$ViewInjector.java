package com.linkedin.android.growth.login.presenters;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import butterknife.internal.DebouncingOnClickListener;

public class PasswordVisibilityPresenter$$ViewInjector<T extends PasswordVisibilityPresenter>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    View localView = (View)paramFinder.findRequiredView(paramObject, 2131756028, "field 'passwordBox' and method 'onPasswordEdited'");
    passwordBox = ((EditText)paramFinder.castView(localView, 2131756028, "field 'passwordBox'"));
    ((TextView)localView).addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramT.onPasswordEdited(paramAnonymousEditable);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    paramObject = (View)paramFinder.findRequiredView(paramObject, 2131756030, "field 'showHidePassword' and method 'toggleShowPassword'");
    showHidePassword = ((Button)paramFinder.castView((View)paramObject, 2131756030, "field 'showHidePassword'"));
    ((View)paramObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.toggleShowPassword();
      }
    });
  }
  
  public void reset(T paramT)
  {
    passwordBox = null;
    showHidePassword = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */