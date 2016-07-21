package android.support.v4.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

public final class PermissionChecker
{
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    int i = Process.myPid();
    int j = Process.myUid();
    String str1 = paramContext.getPackageName();
    if (paramContext.checkPermission(paramString, i, j) == -1) {
      return -1;
    }
    String str2 = AppOpsManagerCompat.permissionToOp(paramString);
    if (str2 != null)
    {
      paramString = str1;
      if (str1 == null)
      {
        paramString = paramContext.getPackageManager().getPackagesForUid(j);
        if ((paramString == null) || (paramString.length <= 0)) {
          return -1;
        }
        paramString = paramString[0];
      }
      if (AppOpsManagerCompat.noteProxyOp(paramContext, str2, paramString) != 0) {
        return -2;
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.PermissionChecker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */