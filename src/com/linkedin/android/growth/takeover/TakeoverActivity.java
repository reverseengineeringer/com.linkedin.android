package com.linkedin.android.growth.takeover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment;
import com.linkedin.android.growth.phonecollection.PhoneCollectionFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;

public class TakeoverActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getIntent().getExtras();
    TakeoverType localTakeoverType;
    if (localBundle == null)
    {
      localTakeoverType = null;
      if (localTakeoverType != null) {
        break label53;
      }
      CrashReporter.reportNonFatal(new IllegalStateException("takeover splash cannot be open because takeover type is missing!"));
      finish();
    }
    label53:
    do
    {
      return;
      localTakeoverType = (TakeoverType)localBundle.getSerializable("takeoverType");
      break;
      setContentView(2130968943);
    } while (paramBundle != null);
    paramBundle = TakeoverIntentBundleBuilder.getLegoTrackingToken(localBundle);
    if (TextUtils.isEmpty(paramBundle))
    {
      CrashReporter.reportNonFatal(new IllegalStateException(localTakeoverType.toString() + " takeover splash cannot be open because LegoTrackingToken is missing!"));
      finish();
      return;
    }
    switch (localTakeoverType)
    {
    default: 
      finish();
      return;
    }
    for (paramBundle = PhoneCollectionFragment.newInstance(new TakeoverIntentBundleBuilder(paramBundle, localTakeoverType));; paramBundle = CalendarSyncTakeoverFragment.newInstance(new TakeoverIntentBundleBuilder(paramBundle, localTakeoverType)))
    {
      getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.TakeoverActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */