package com.linkedin.android.developer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.CountDownLatch;

final class OAuthService$1$1
  extends BroadcastReceiver
{
  OAuthService$1$1(OAuthService.1 param1, IOAuthServiceResultCallback paramIOAuthServiceResultCallback, CountDownLatch paramCountDownLatch) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    OAuthService.access$200(val$cb, paramIntent.getBundleExtra("ouath_result_bundle"));
    val$latch.countDown();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthService.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */