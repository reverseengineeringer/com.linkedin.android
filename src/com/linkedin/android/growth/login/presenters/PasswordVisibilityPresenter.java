package com.linkedin.android.growth.login.presenters;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import com.linkedin.android.infra.network.I18NManager;
import javax.inject.Inject;

public class PasswordVisibilityPresenter
{
  private final I18NManager i18nManager;
  @InjectView(2131756028)
  EditText passwordBox;
  @InjectView(2131756030)
  Button showHidePassword;
  
  @Inject
  public PasswordVisibilityPresenter(I18NManager paramI18NManager)
  {
    i18nManager = paramI18NManager;
  }
  
  private void setPasswordVisible(boolean paramBoolean)
  {
    int j = passwordBox.getSelectionStart();
    EditText localEditText = passwordBox;
    if (paramBoolean)
    {
      i = 145;
      localEditText.setInputType(i);
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i = 2131231447;; i = 2131231448)
    {
      showHidePassword.setText(i18nManager.getString(i));
      passwordBox.setSelection(j);
      return;
      i = 129;
      break;
    }
  }
  
  public final void bind(View paramView)
  {
    ButterKnife.inject(this, paramView);
    setPasswordVisible(false);
    onPasswordEdited(passwordBox.getText());
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131756028})
  public void onPasswordEdited(Editable paramEditable)
  {
    boolean bool = TextUtils.isEmpty(paramEditable);
    if (showHidePassword != null)
    {
      paramEditable = showHidePassword;
      if (!bool) {
        break label29;
      }
    }
    label29:
    for (int i = 4;; i = 0)
    {
      paramEditable.setVisibility(i);
      return;
    }
  }
  
  @OnClick({2131756030})
  public void toggleShowPassword()
  {
    if (passwordBox.getInputType() != 145) {}
    for (boolean bool = true;; bool = false)
    {
      setPasswordVisible(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */