package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.PromptSettingsData;

final class CrashlyticsCore$7
  implements Runnable
{
  CrashlyticsCore$7(CrashlyticsCore paramCrashlyticsCore, Activity paramActivity, CrashlyticsCore.OptInLatch paramOptInLatch, DialogStringResolver paramDialogStringResolver, PromptSettingsData paramPromptSettingsData) {}
  
  public final void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(val$activity);
    Object localObject1 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        val$latch.setOptIn(true);
        paramAnonymousDialogInterface.dismiss();
      }
    };
    float f = val$activity.getResources().getDisplayMetrics().density;
    int i = CrashlyticsCore.access$400(f, 5);
    Object localObject2 = new TextView(val$activity);
    ((TextView)localObject2).setAutoLinkMask(15);
    Object localObject3 = val$stringResolver;
    ((TextView)localObject2).setText(((DialogStringResolver)localObject3).resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptMessage", promptData.message));
    ((TextView)localObject2).setTextAppearance(val$activity, 16973892);
    ((TextView)localObject2).setPadding(i, i, i, i);
    ((TextView)localObject2).setFocusable(false);
    localObject3 = new ScrollView(val$activity);
    ((ScrollView)localObject3).setPadding(CrashlyticsCore.access$400(f, 14), CrashlyticsCore.access$400(f, 2), CrashlyticsCore.access$400(f, 10), CrashlyticsCore.access$400(f, 12));
    ((ScrollView)localObject3).addView((View)localObject2);
    localObject2 = localBuilder.setView((View)localObject3);
    localObject3 = val$stringResolver;
    localObject2 = ((AlertDialog.Builder)localObject2).setTitle(((DialogStringResolver)localObject3).resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptTitle", promptData.title)).setCancelable(false);
    localObject3 = val$stringResolver;
    ((AlertDialog.Builder)localObject2).setNeutralButton(((DialogStringResolver)localObject3).resourceOrFallbackValue("com.crashlytics.CrashSubmissionSendTitle", promptData.sendButtonTitle), (DialogInterface.OnClickListener)localObject1);
    if (val$promptData.showCancelButton)
    {
      localObject1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          val$latch.setOptIn(false);
          paramAnonymousDialogInterface.dismiss();
        }
      };
      localObject2 = val$stringResolver;
      localBuilder.setNegativeButton(((DialogStringResolver)localObject2).resourceOrFallbackValue("com.crashlytics.CrashSubmissionCancelTitle", promptData.cancelButtonTitle), (DialogInterface.OnClickListener)localObject1);
    }
    if (val$promptData.showAlwaysSendButton)
    {
      localObject1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          PreferenceStoreImpl localPreferenceStoreImpl = new PreferenceStoreImpl(this$0);
          localPreferenceStoreImpl.save(localPreferenceStoreImpl.edit().putBoolean("always_send_reports_opt_in", true));
          val$latch.setOptIn(true);
          paramAnonymousDialogInterface.dismiss();
        }
      };
      localObject2 = val$stringResolver;
      localBuilder.setPositiveButton(((DialogStringResolver)localObject2).resourceOrFallbackValue("com.crashlytics.CrashSubmissionAlwaysSendTitle", promptData.alwaysSendButtonTitle), (DialogInterface.OnClickListener)localObject1);
    }
    localBuilder.show();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */