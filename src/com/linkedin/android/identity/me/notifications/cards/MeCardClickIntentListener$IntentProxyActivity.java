package com.linkedin.android.identity.me.notifications.cards;

import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.infra.app.BaseActivity;

public class MeCardClickIntentListener$IntentProxyActivity
  extends BaseActivity
{
  private boolean didStartTarget;
  private Bundle returnBundle;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = new Intent();
    paramIntent.putExtras(returnBundle);
    paramIntent.putExtra("targetResultCode", paramInt2);
    setResult(-1, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      didStartTarget = false;
      if (getIntent() == null) {
        paramBundle = new Bundle();
      }
    }
    for (returnBundle = paramBundle;; returnBundle = paramBundle.getBundle("returnBundle"))
    {
      paramBundle = (Intent)returnBundle.getParcelable("targetIntent");
      if (paramBundle == null) {
        finish();
      }
      if (!didStartTarget) {
        startActivityForResult(paramBundle, 1);
      }
      didStartTarget = true;
      return;
      paramBundle = getIntent().getExtras();
      break;
      didStartTarget = paramBundle.getBoolean("didStartTarget", false);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("didStartTarget", didStartTarget);
    paramBundle.putBundle("returnBundle", returnBundle);
    super.onSaveInstanceState(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.cards.MeCardClickIntentListener.IntentProxyActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */