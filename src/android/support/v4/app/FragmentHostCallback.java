package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E>
  extends FragmentContainer
{
  final Activity mActivity;
  SimpleArrayMap<String, LoaderManager> mAllLoaderManagers;
  boolean mCheckedForLoaderManager;
  final Context mContext;
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  final Handler mHandler;
  LoaderManagerImpl mLoaderManager;
  boolean mLoadersStarted;
  boolean mRetainLoaders;
  final int mWindowAnimations;
  
  private FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    mActivity = paramActivity;
    mContext = paramContext;
    mHandler = paramHandler;
    mWindowAnimations = 0;
  }
  
  FragmentHostCallback(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, mHandler);
  }
  
  final LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mAllLoaderManagers == null) {
      mAllLoaderManagers = new SimpleArrayMap();
    }
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(paramString);
    if (localLoaderManagerImpl == null)
    {
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
        mAllLoaderManagers.put(paramString, localLoaderManagerImpl);
      }
      return localLoaderManagerImpl;
    }
    mHost = this;
    return localLoaderManagerImpl;
  }
  
  final void inactivateFragment(String paramString)
  {
    if (mAllLoaderManagers != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(paramString);
      if ((localLoaderManagerImpl != null) && (!mRetaining))
      {
        localLoaderManagerImpl.doDestroy();
        mAllLoaderManagers.remove(paramString);
      }
    }
  }
  
  void onAttachFragment(Fragment paramFragment) {}
  
  public void onDump$ec96877(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public abstract E onGetHost();
  
  public LayoutInflater onGetLayoutInflater()
  {
    return (LayoutInflater)mContext.getSystemService("layout_inflater");
  }
  
  public int onGetWindowAnimations()
  {
    return mWindowAnimations;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
  
  public void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {}
  
  public boolean onShouldSaveFragmentState$6585081f()
  {
    return true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(String paramString)
  {
    return false;
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    mContext.startActivity(paramIntent);
  }
  
  public void onSupportInvalidateOptionsMenu() {}
  
  final SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig()
  {
    int k = 0;
    int j = 0;
    if (mAllLoaderManagers != null)
    {
      int m = mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[m];
      int i = m - 1;
      while (i >= 0)
      {
        arrayOfLoaderManagerImpl[i] = ((LoaderManagerImpl)mAllLoaderManagers.valueAt(i));
        i -= 1;
      }
      k = 0;
      i = j;
      j = k;
      k = i;
      if (j < m)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[j];
        if (mRetaining) {
          i = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          localLoaderManagerImpl.doDestroy();
          mAllLoaderManagers.remove(mWho);
        }
      }
    }
    if (k != 0) {
      return mAllLoaderManagers;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentHostCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */