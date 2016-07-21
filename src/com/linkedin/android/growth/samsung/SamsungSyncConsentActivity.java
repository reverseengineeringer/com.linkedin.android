package com.linkedin.android.growth.samsung;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.logger.Log;

public class SamsungSyncConsentActivity
  extends BaseActivity
{
  private static final String TAG = SamsungSyncConsentActivity.class.getSimpleName();
  @InjectView(2131756267)
  Button continueButton;
  @InjectView(2131756270)
  TextView learnMoreTextView;
  private Intent redirectIntent;
  @InjectView(2131756265)
  Toolbar toolbar;
  
  public void finish()
  {
    if (redirectIntent != null) {
      startActivity(redirectIntent);
    }
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {}
    for (paramBundle = (Intent)paramBundle.getParcelable("redirect");; paramBundle = null)
    {
      redirectIntent = paramBundle;
      if ((!applicationComponent.auth().isAuthenticated()) || (redirectIntent == null)) {
        break;
      }
      setContentView(2130968873);
      ButterKnife.inject(this);
      learnMoreTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          getSupportFragmentManager().beginTransaction().replace(16908290, new SamsungSyncLearnMoreFragment()).commit();
        }
      });
      continueButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          applicationComponent.flagshipSharedPreferences().setDevTokenUserSelection(true);
          finish();
        }
      });
      toolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          applicationComponent.flagshipSharedPreferences().setDevTokenUserSelection(false);
          finish();
        }
      });
      return;
    }
    Log.e(TAG, "Need to be logged in and have a redirect intent set to access consent screen.");
    finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.samsung.SamsungSyncConsentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */