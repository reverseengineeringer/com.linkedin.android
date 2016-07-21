package com.linkedin.android.growth.utils;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.util.Patterns;
import android.widget.EditText;
import com.linkedin.android.growth.login.presenters.InputValidationPresenter;
import com.linkedin.android.infra.ChineseLocaleUtils;
import com.linkedin.android.infra.shared.StringUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public final class InputValidator
{
  public TextInputLayout emailOrPhone;
  private TextInputLayout firstName;
  private TextInputLayout fullName;
  public final InputValidationPresenter inputValidationPresenter;
  private boolean isPhoneNumberLoginAllowed;
  private TextInputLayout lastName;
  private Locale locale;
  private TextInputLayout password;
  private final StringUtils stringUtils;
  
  @Inject
  public InputValidator(StringUtils paramStringUtils, InputValidationPresenter paramInputValidationPresenter)
  {
    stringUtils = paramStringUtils;
    inputValidationPresenter = paramInputValidationPresenter;
  }
  
  public static boolean isInvalidEmail(CharSequence paramCharSequence)
  {
    return !Patterns.EMAIL_ADDRESS.matcher(paramCharSequence.toString().trim()).matches();
  }
  
  public final void bind(TextInputLayout paramTextInputLayout1, TextInputLayout paramTextInputLayout2, TextInputLayout paramTextInputLayout3, TextInputLayout paramTextInputLayout4, TextInputLayout paramTextInputLayout5, Locale paramLocale, boolean paramBoolean)
  {
    firstName = paramTextInputLayout1;
    lastName = paramTextInputLayout2;
    fullName = paramTextInputLayout3;
    emailOrPhone = paramTextInputLayout4;
    password = paramTextInputLayout5;
    locale = paramLocale;
    isPhoneNumberLoginAllowed = paramBoolean;
  }
  
  public final boolean validate()
  {
    Editable localEditable;
    int j;
    label49:
    label78:
    int k;
    label98:
    label137:
    int m;
    label158:
    label195:
    int n;
    if (firstName != null)
    {
      localEditable = firstName.getEditText().getText();
      if (StringUtils.isEmptyTrimmed(localEditable))
      {
        i = 0;
        inputValidationPresenter.presentValidation(i, firstName);
        if (i == 13) {
          break label323;
        }
        j = 0;
        if (lastName == null) {
          break label363;
        }
        localEditable = lastName.getEditText().getText();
        if (!StringUtils.isEmptyTrimmed(localEditable)) {
          break label328;
        }
        i = 1;
        inputValidationPresenter.presentValidation(i, lastName);
        if (i == 13) {
          break label363;
        }
        k = 0;
        if ((fullName == null) || (fullName.getEditText() == null)) {
          break label450;
        }
        localEditable = fullName.getEditText().getText();
        if (!StringUtils.isEmptyTrimmed(localEditable)) {
          break label368;
        }
        i = 2;
        inputValidationPresenter.presentValidation(i, fullName);
        if (i == 13) {
          break label450;
        }
        m = 0;
        if (emailOrPhone == null) {
          break label534;
        }
        localEditable = emailOrPhone.getEditText().getText();
        if (!StringUtils.isEmptyTrimmed(localEditable)) {
          break label461;
        }
        if (!isPhoneNumberLoginAllowed) {
          break label456;
        }
        i = 10;
        inputValidationPresenter.presentValidation(i, emailOrPhone);
        if (i == 13) {
          break label534;
        }
        n = 0;
        label216:
        if (password == null) {
          break label575;
        }
        localEditable = password.getEditText().getText();
        if (!StringUtils.isEmptyTrimmed(localEditable)) {
          break label540;
        }
        i = 4;
        label245:
        inputValidationPresenter.presentValidation(i, password);
        if (i == 13) {
          break label575;
        }
      }
    }
    label317:
    label323:
    label328:
    label357:
    label363:
    label368:
    label397:
    label444:
    label450:
    label456:
    label461:
    label534:
    label540:
    label569:
    label575:
    for (int i = 0;; i = 1)
    {
      if ((j == 0) || (k == 0) || (m == 0) || (n == 0) || (i == 0)) {
        break label580;
      }
      return true;
      if (localEditable.length() > 20) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label317;
        }
        i = 5;
        break;
      }
      i = 13;
      break;
      j = 1;
      break label49;
      if (localEditable.length() > 40) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label357;
        }
        i = 6;
        break;
      }
      i = 13;
      break label78;
      k = 1;
      break label98;
      if (localEditable.length() > 60) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label397;
        }
        i = 7;
        break;
      }
      if ((locale != null) && (ChineseLocaleUtils.isChineseLocale(locale)) && (!ChineseLocaleUtils.isValidChineseName(localEditable.toString()))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label444;
        }
        i = 12;
        break;
      }
      i = 13;
      break label137;
      m = 1;
      break label158;
      i = 3;
      break label195;
      if (isInvalidEmail(localEditable))
      {
        if (!Patterns.PHONE.matcher(localEditable.toString().trim().replaceAll("[()]", "")).matches()) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            if (isPhoneNumberLoginAllowed)
            {
              i = 11;
              break;
              i = 0;
              continue;
            }
            i = 8;
            break;
          }
        }
      }
      i = 13;
      break label195;
      n = 1;
      break label216;
      if (localEditable.length() < 6) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label569;
        }
        i = 9;
        break;
      }
      i = 13;
      break label245;
    }
    label580:
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.utils.InputValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */