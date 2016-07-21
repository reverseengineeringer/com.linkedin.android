package android.support.v4.app;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager
{
  public abstract void addOnBackStackChangedListener(OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract FragmentTransaction beginTransaction();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean executePendingTransactions();
  
  public abstract Fragment findFragmentById(int paramInt);
  
  public abstract Fragment findFragmentByTag(String paramString);
  
  public abstract BackStackEntry getBackStackEntryAt(int paramInt);
  
  public abstract int getBackStackEntryCount();
  
  public abstract Fragment getFragment(Bundle paramBundle, String paramString);
  
  public abstract List<Fragment> getFragments();
  
  public abstract boolean isDestroyed();
  
  public abstract void popBackStack();
  
  public abstract void popBackStack$255f295(int paramInt);
  
  public abstract void popBackStack$505cff1c(String paramString);
  
  public abstract boolean popBackStackImmediate();
  
  public abstract void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment);
  
  public abstract Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment);
  
  public static abstract interface BackStackEntry
  {
    public abstract String getName();
  }
  
  public static abstract interface OnBackStackChangedListener
  {
    public abstract void onBackStackChanged();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */