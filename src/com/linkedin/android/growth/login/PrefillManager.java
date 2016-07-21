package com.linkedin.android.growth.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public final class PrefillManager
{
  private final Context context;
  
  @Inject
  public PrefillManager(Context paramContext)
  {
    context = paramContext;
  }
  
  public final void prefill(EditText paramEditText)
  {
    Account[] arrayOfAccount = AccountManager.get(context).getAccounts();
    if (arrayOfAccount.length <= 0) {
      return;
    }
    Object localObject1 = null;
    int j = arrayOfAccount.length;
    int i = 0;
    label28:
    Object localObject2;
    if (i < j)
    {
      localObject2 = arrayOfAccount[i];
      if (type.equals("com.google"))
      {
        label52:
        if (localObject2 == null) {
          break label112;
        }
        paramEditText.setText(name);
        return;
      }
      String str = name;
      if (!Patterns.EMAIL_ADDRESS.matcher(str.toString().trim()).matches()) {
        break label114;
      }
      localObject1 = localObject2;
    }
    label112:
    label114:
    for (;;)
    {
      i += 1;
      break label28;
      localObject2 = localObject1;
      break label52;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.PrefillManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */