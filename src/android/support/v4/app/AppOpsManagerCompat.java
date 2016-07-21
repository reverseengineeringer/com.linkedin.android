package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class AppOpsManagerCompat
{
  private static final AppOpsManagerImpl IMPL = new AppOpsManagerImpl((byte)0);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new AppOpsManager23((byte)0);
      return;
    }
  }
  
  public static int noteProxyOp(Context paramContext, String paramString1, String paramString2)
  {
    return IMPL.noteProxyOp(paramContext, paramString1, paramString2);
  }
  
  public static String permissionToOp(String paramString)
  {
    return IMPL.permissionToOp(paramString);
  }
  
  private static final class AppOpsManager23
    extends AppOpsManagerCompat.AppOpsManagerImpl
  {
    private AppOpsManager23()
    {
      super();
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
  
  private static class AppOpsManagerImpl
  {
    public int noteProxyOp(Context paramContext, String paramString1, String paramString2)
    {
      return 1;
    }
    
    public String permissionToOp(String paramString)
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.AppOpsManagerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */