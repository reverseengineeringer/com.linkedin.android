package com.linkedin.android.infra.settings.ui;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.support.v7.app.AlertDialog.Builder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import javax.inject.Inject;

public final class PhoneOnlyUserDialogManager
{
  final Context context;
  final IntentRegistry intentRegistry;
  public Closure<Void, Void> onEmailClickCallback;
  final FlagshipSharedPreferences sharedPreferences;
  private final Tracker tracker;
  
  @Inject
  public PhoneOnlyUserDialogManager(Context paramContext, IntentRegistry paramIntentRegistry, FlagshipSharedPreferences paramFlagshipSharedPreferences, Tracker paramTracker)
  {
    context = paramContext;
    intentRegistry = paramIntentRegistry;
    sharedPreferences = paramFlagshipSharedPreferences;
    tracker = paramTracker;
  }
  
  public final void showDialog(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    PhoneOnlyUserDialogManager.1 local1 = new PhoneOnlyUserDialogManager.1(this);
    PhoneOnlyUserDialogManager.2 local2 = new PhoneOnlyUserDialogManager.2(this);
    PhoneOnlyUserDialogManager.3 local3 = new PhoneOnlyUserDialogManager.3(this);
    new PageViewEvent(tracker, "wwe_dialog_email_confirm", false).send();
    new AlertDialog.Builder(context, 2131362070).setMessage(context.getString(2131231639)).setPositiveButton(context.getString(2131231638), local2).setNegativeButton(context.getString(2131231637), local1).setOnKeyListener(local3).setOnDismissListener(paramOnDismissListener).show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.settings.ui.PhoneOnlyUserDialogManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */