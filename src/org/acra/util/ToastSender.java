package org.acra.util;

import android.content.Context;
import android.widget.Toast;
import org.acra.ACRA;
import org.acra.log.ACRALog;

public final class ToastSender
{
  public static void sendToast$3047fd93(Context paramContext, int paramInt)
  {
    try
    {
      Toast.makeText(paramContext, paramInt, 1).show();
      return;
    }
    catch (RuntimeException paramContext)
    {
      ACRA.log.e(ACRA.LOG_TAG, "Could not send crash Toast", paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     org.acra.util.ToastSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */