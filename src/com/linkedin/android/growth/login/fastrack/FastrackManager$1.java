package com.linkedin.android.growth.login.fastrack;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.EditText;
import com.linkedin.android.growth.login.PrefillManager;

public class FastrackManager$1
  extends ResultReceiver
{
  public FastrackManager$1(FastrackManager paramFastrackManager, Handler paramHandler, EditText paramEditText)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(val$emailOrPhoneInput.getText()))
    {
      if ((paramInt == 200) && (paramBundle != null)) {
        val$emailOrPhoneInput.setText(paramBundle.getString("emailAddress"));
      }
    }
    else {
      return;
    }
    this$0.prefillManager.prefill(val$emailOrPhoneInput);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.fastrack.FastrackManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */