package com.conviva.platforms.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.conviva.api.system.ICallbackInterface;
import com.conviva.api.system.IStorageInterface;

public final class AndroidStorageInterface
  implements IStorageInterface
{
  private Context _context = null;
  
  public AndroidStorageInterface(Context paramContext)
  {
    _context = paramContext;
  }
  
  public final void loadData(String paramString1, String paramString2, ICallbackInterface paramICallbackInterface)
  {
    paramString1 = _context.getSharedPreferences(paramString1, 0);
    try
    {
      paramString1 = paramString1.getString(paramString2, null);
      paramICallbackInterface.done(true, paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramICallbackInterface.done(false, paramString1.toString());
    }
  }
  
  public final void saveData(String paramString1, String paramString2, String paramString3, ICallbackInterface paramICallbackInterface)
  {
    paramString1 = _context.getSharedPreferences(paramString1, 0).edit();
    paramString1.putString(paramString2, paramString3);
    if (paramString1.commit())
    {
      paramICallbackInterface.done(true, paramString3);
      return;
    }
    paramICallbackInterface.done(false, "Failed to write data");
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidStorageInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */