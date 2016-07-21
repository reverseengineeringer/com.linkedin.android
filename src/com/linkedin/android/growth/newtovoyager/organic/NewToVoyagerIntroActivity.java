package com.linkedin.android.growth.newtovoyager.organic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.performance.CrashReporter;
import javax.inject.Inject;

public class NewToVoyagerIntroActivity
  extends BaseActivity
{
  @Inject
  FragmentManager fragmentManager;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968943);
    activityComponent.inject(this);
    if (paramBundle == null)
    {
      paramBundle = getIntent().getExtras().getString("legoTrackingTokenKey");
      if (paramBundle == null)
      {
        CrashReporter.reportNonFatal(new IllegalStateException("NTV Intro cannot open because lego tracking token is missing!"));
        finish();
      }
    }
    else
    {
      return;
    }
    paramBundle = new NewToVoyagerIntroBundle(paramBundle);
    fragmentManager.beginTransaction().add(16908290, fragmentRegistry.newToVoyagerOrganicIntro.newFragment(paramBundle)).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */