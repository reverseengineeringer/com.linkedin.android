package com.linkedin.android.infra.app;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PermissionRequester
{
  private static final String TAG = PermissionRequester.class.getSimpleName();
  private final Activity activity;
  private final android.app.Fragment fragment;
  private boolean isPermissionRequestInProgress;
  private final android.support.v4.app.Fragment supportFragment;
  
  public PermissionRequester(Activity paramActivity)
  {
    activity = paramActivity;
    fragment = null;
    supportFragment = null;
  }
  
  public PermissionRequester(android.app.Fragment paramFragment)
  {
    activity = null;
    fragment = paramFragment;
    supportFragment = null;
  }
  
  public PermissionRequester(android.support.v4.app.Fragment paramFragment)
  {
    activity = null;
    fragment = null;
    supportFragment = paramFragment;
  }
  
  private void doRequestPermissions(String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (fragment != null) {
        fragment.requestPermissions(paramArrayOfString, 99);
      }
    }
    else {
      return;
    }
    if (supportFragment != null)
    {
      supportFragment.requestPermissions(paramArrayOfString, 99);
      return;
    }
    ActivityCompat.requestPermissions(activity, paramArrayOfString, 99);
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = ContextCompat.checkSelfPermission(paramContext, paramString);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "Exception when checking for availability of permission " + paramString, paramContext);
    }
    return false;
  }
  
  public final boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt, PermissionRequestCallback paramPermissionRequestCallback)
  {
    if (paramInt != 99) {
      return false;
    }
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 0) {
        localHashSet1.add(paramArrayOfString[paramInt]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        Log.e(TAG, "User denied permission: " + paramArrayOfString[paramInt]);
        localHashSet2.add(paramArrayOfString[paramInt]);
      }
    }
    isPermissionRequestInProgress = false;
    if (paramPermissionRequestCallback != null) {
      paramPermissionRequestCallback.permissionsResult(Collections.unmodifiableSet(localHashSet1), Collections.unmodifiableSet(localHashSet2));
    }
    return true;
  }
  
  public final boolean requestPermissions(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (fragment != null) {
      localObject = fragment.getActivity();
    }
    while (localObject == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot request permission without a context"));
      return false;
      if (supportFragment != null) {
        localObject = supportFragment.getActivity();
      } else {
        localObject = activity;
      }
    }
    if (isPermissionRequestInProgress)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Already an ongoing permission request, something is seriously wrong!"));
      return false;
    }
    HashSet localHashSet = new HashSet();
    int j = paramArrayOfString.length;
    int i = 0;
    String str;
    while (i < j)
    {
      str = paramArrayOfString[i];
      if (!hasPermission((Context)localObject, str)) {
        localHashSet.add(str);
      }
      i += 1;
    }
    if (localHashSet.isEmpty()) {
      return true;
    }
    j = 0;
    paramArrayOfString = localHashSet.iterator();
    for (;;)
    {
      i = j;
      boolean bool;
      if (paramArrayOfString.hasNext())
      {
        str = (String)paramArrayOfString.next();
        if (Build.VERSION.SDK_INT < 23) {
          break label349;
        }
        if (fragment == null) {
          break label314;
        }
        bool = fragment.shouldShowRequestPermissionRationale(str);
      }
      while (bool)
      {
        i = 1;
        paramArrayOfString = (String[])localHashSet.toArray(new String[localHashSet.size()]);
        isPermissionRequestInProgress = true;
        if (i == 0) {
          break label355;
        }
        paramArrayOfString = new AlertDialog.Builder((Context)localObject).setTitle(paramInt1).setMessage(paramInt2).setPositiveButton(2131232790, new PermissionRequester.2(this, paramArrayOfString));
        localObject = new PermissionRequester.1(this);
        P.mOnCancelListener = ((DialogInterface.OnCancelListener)localObject);
        paramArrayOfString.create().show();
        return false;
        label314:
        if (supportFragment != null)
        {
          bool = supportFragment.shouldShowRequestPermissionRationale(str);
        }
        else
        {
          bool = ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
          continue;
          label349:
          bool = false;
        }
      }
    }
    label355:
    doRequestPermissions(paramArrayOfString);
    return false;
  }
  
  public static abstract interface PermissionRequestCallback
  {
    public abstract void permissionsResult(Set<String> paramSet1, Set<String> paramSet2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.PermissionRequester
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */