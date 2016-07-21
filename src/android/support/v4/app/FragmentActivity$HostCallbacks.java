package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.PrintWriter;

final class FragmentActivity$HostCallbacks
  extends FragmentHostCallback<FragmentActivity>
{
  public FragmentActivity$HostCallbacks(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  public final void onAttachFragment(Fragment paramFragment)
  {
    this$0.onAttachFragment(paramFragment);
  }
  
  public final void onDump$ec96877(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this$0.dump(paramString, null, paramPrintWriter, paramArrayOfString);
  }
  
  public final View onFindViewById(int paramInt)
  {
    return this$0.findViewById(paramInt);
  }
  
  public final LayoutInflater onGetLayoutInflater()
  {
    return this$0.getLayoutInflater().cloneInContext(this$0);
  }
  
  public final int onGetWindowAnimations()
  {
    Window localWindow = this$0.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return getAttributeswindowAnimations;
  }
  
  public final boolean onHasView()
  {
    Window localWindow = this$0.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public final boolean onHasWindowAnimations()
  {
    return this$0.getWindow() != null;
  }
  
  public final void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    FragmentActivity.access$000(this$0, paramFragment, paramArrayOfString, paramInt);
  }
  
  public final boolean onShouldSaveFragmentState$6585081f()
  {
    return !this$0.isFinishing();
  }
  
  public final boolean onShouldShowRequestPermissionRationale(String paramString)
  {
    return ActivityCompat.shouldShowRequestPermissionRationale(this$0, paramString);
  }
  
  public final void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this$0.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public final void onSupportInvalidateOptionsMenu()
  {
    this$0.supportInvalidateOptionsMenu();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentActivity.HostCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */