package com.linkedin.android.growth.onboarding.email_confirmation;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.ResultListener;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import java.io.UnsupportedEncodingException;

final class EmailConfirmationFragment$7
  implements View.OnClickListener
{
  EmailConfirmationFragment$7(EmailConfirmationFragment paramEmailConfirmationFragment, EditText paramEditText, AlertDialog paramAlertDialog) {}
  
  public final void onClick(View paramView)
  {
    paramView = this$0.emailSender;
    Object localObject3 = this$0.emailInput.getText().toString();
    Object localObject4 = val$passwordInput.getText().toString();
    Object localObject2 = EmailConfirmationFragment.access$300(this$0);
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("emailToAdd=").append((String)localObject3).append('&').append("password=").append((String)localObject4);
      localObject3 = mNetworkClient.getRequestFactory();
      localObject2 = paramView.getResponseListener((EmailManagementController.ResultListener)localObject2);
      localObject4 = mContext;
      localObject1 = ((RequestFactory)localObject3).getAbsoluteRequest$3868be9b(1, "https://www.linkedin-ei.com/psettings/email/change", (ResponseListener)localObject2, createsetBodycreate"application/x-www-form-urlencoded"toStringgetBytes"UTF-8"requestDelegate);
      mNetworkClient.add((AbstractRequest)localObject1);
      val$dialog.dismiss();
      return;
    }
    catch (UnsupportedEncodingException paramView)
    {
      for (;;)
      {
        Log.e(EmailManagementController.TAG, "Error encoding update email post body", paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */