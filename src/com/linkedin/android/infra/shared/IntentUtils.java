package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build.VERSION;

public final class IntentUtils
{
  public static void grantReadUriPermission(Intent paramIntent, Activity paramActivity)
  {
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null) {
        grantReadUriPermission(paramIntent, paramActivity);
      }
    }
  }
  
  public static void grantReadUriPermission(Intent paramIntent1, Intent paramIntent2)
  {
    paramIntent1.addFlags(1);
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return;
      paramIntent2 = paramIntent2.getClipData();
      if (paramIntent2 != null)
      {
        ClipData localClipData = paramIntent1.getClipData();
        if (localClipData == null)
        {
          paramIntent1.setClipData(paramIntent2);
          return;
        }
        int i = 0;
        while (i < paramIntent2.getItemCount())
        {
          localClipData.addItem(paramIntent2.getItemAt(i));
          i += 1;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.IntentUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */