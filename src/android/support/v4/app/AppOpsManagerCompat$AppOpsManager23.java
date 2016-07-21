package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

final class AppOpsManagerCompat$AppOpsManager23
  extends AppOpsManagerCompat.AppOpsManagerImpl
{
  private AppOpsManagerCompat$AppOpsManager23()
  {
    super((byte)0);
  }
  
  public final int noteProxyOp(Context paramContext, String paramString1, String paramString2)
  {
    return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(paramString1, paramString2);
  }
  
  public final String permissionToOp(String paramString)
  {
    return AppOpsManager.permissionToOp(paramString);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.AppOpsManagerCompat.AppOpsManager23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */