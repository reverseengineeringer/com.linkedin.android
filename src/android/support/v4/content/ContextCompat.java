package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;

public class ContextCompat
{
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("permission is null");
    }
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  /* Error */
  public static java.io.File createFilesDir(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 41	java/io/File:exists	()Z
    //   9: ifne +23 -> 32
    //   12: aload_0
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 44	java/io/File:mkdirs	()Z
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokevirtual 41	java/io/File:exists	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifeq +10 -> 37
    //   30: aload_0
    //   31: astore_2
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: ldc 46
    //   39: new 48	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 50
    //   45: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: invokevirtual 55	java/io/File:getPath	()Ljava/lang/String;
    //   52: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 68	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aconst_null
    //   63: astore_2
    //   64: goto -32 -> 32
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramFile	java.io.File
    //   25	2	1	bool	boolean
    //   4	60	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	12	67	finally
    //   14	26	67	finally
    //   37	62	67	finally
  }
  
  public static final int getColor(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  public static final ColorStateList getColorStateList(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static final Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  public static boolean startActivities$5b3ef247(Context paramContext, Intent[] paramArrayOfIntent)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 16)
    {
      paramContext.startActivities(paramArrayOfIntent, null);
      return true;
    }
    if (i >= 11)
    {
      paramContext.startActivities(paramArrayOfIntent);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.ContextCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */