package com.linkedin.android.identity.me.notifications.cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class MeCardClickIntentListener
  extends TrackingOnClickListener
{
  private FragmentComponent fragmentComponent;
  private Bundle returnBundle;
  private Intent targetIntent;
  private int targetRequestCode;
  
  public MeCardClickIntentListener(FragmentComponent paramFragmentComponent, Intent paramIntent, Bundle paramBundle, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponent = paramFragmentComponent;
    targetRequestCode = 31;
    targetIntent = paramIntent;
    returnBundle = paramBundle;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new Intent(paramView.getContext(), IntentProxyActivity.class);
    paramView.putExtra("returnBundle", returnBundle);
    paramView.putExtra("targetIntent", targetIntent);
    fragmentComponent.fragment().startActivityForResult(paramView, targetRequestCode);
  }
  
  public static class IntentProxyActivity
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.cards.MeCardClickIntentListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */