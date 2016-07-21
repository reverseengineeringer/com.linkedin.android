package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.media.session.MediaController;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity
  extends BaseFragmentActivityHoneycomb
  implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompatApi23.RequestPermissionsRequestCodeValidator
{
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  static final String FRAGMENTS_TAG = "android:support:fragments";
  private static final int HONEYCOMB = 11;
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  private static final String TAG = "FragmentActivity";
  boolean mCreated;
  final FragmentController mFragments = new FragmentController(new HostCallbacks());
  final Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      case 1: 
        do
        {
          return;
        } while (!mStopped);
        doReallyStop(false);
        return;
      }
      onResumeFragments();
      mFragments.execPendingActions();
    }
  };
  MediaControllerCompat mMediaController;
  int mNextCandidateRequestIndex;
  boolean mOptionsMenuInvalidated;
  SparseArrayCompat<String> mPendingFragmentActivityResults;
  boolean mReallyStopped;
  boolean mRequestedPermissionsFromFragment;
  boolean mResumed;
  boolean mRetaining;
  boolean mStartedActivityFromFragment;
  boolean mStopped;
  
  private int allocateRequestIndex(Fragment paramFragment)
  {
    if (mPendingFragmentActivityResults.size() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    while (mPendingFragmentActivityResults.indexOfKey(mNextCandidateRequestIndex) >= 0) {
      mNextCandidateRequestIndex = ((mNextCandidateRequestIndex + 1) % 65534);
    }
    int i = mNextCandidateRequestIndex;
    mPendingFragmentActivityResults.put(i, mWho);
    mNextCandidateRequestIndex = ((mNextCandidateRequestIndex + 1) % 65534);
    return i;
  }
  
  private void dumpViewHierarchy(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
    }
    for (;;)
    {
      return;
      paramPrintWriter.println(viewToString(paramView));
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        if (j > 0)
        {
          paramString = paramString + "  ";
          int i = 0;
          while (i < j)
          {
            dumpViewHierarchy(paramString, paramPrintWriter, paramView.getChildAt(i));
            i += 1;
          }
        }
      }
    }
  }
  
  private void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt == -1)
    {
      ActivityCompat.requestPermissions(this, paramArrayOfString, paramInt);
      return;
    }
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    try
    {
      mRequestedPermissionsFromFragment = true;
      ActivityCompat.requestPermissions(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt));
      return;
    }
    finally
    {
      mRequestedPermissionsFromFragment = false;
    }
  }
  
  private static String viewToString(View paramView)
  {
    char c3 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    char c1;
    label118:
    label135:
    label152:
    label169:
    label186:
    label203:
    label220:
    label244:
    label261:
    int i;
    Object localObject;
    switch (paramView.getVisibility())
    {
    default: 
      localStringBuilder.append('.');
      if (paramView.isFocusable())
      {
        c1 = 'F';
        localStringBuilder.append(c1);
        if (!paramView.isEnabled()) {
          break label570;
        }
        c1 = 'E';
        localStringBuilder.append(c1);
        if (!paramView.willNotDraw()) {
          break label576;
        }
        c1 = '.';
        localStringBuilder.append(c1);
        if (!paramView.isHorizontalScrollBarEnabled()) {
          break label582;
        }
        c1 = 'H';
        localStringBuilder.append(c1);
        if (!paramView.isVerticalScrollBarEnabled()) {
          break label588;
        }
        c1 = 'V';
        localStringBuilder.append(c1);
        if (!paramView.isClickable()) {
          break label594;
        }
        c1 = 'C';
        localStringBuilder.append(c1);
        if (!paramView.isLongClickable()) {
          break label600;
        }
        c1 = 'L';
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        if (!paramView.isFocused()) {
          break label606;
        }
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isSelected()) {
          break label612;
        }
        c1 = 'S';
        localStringBuilder.append(c1);
        c1 = c2;
        if (paramView.isPressed()) {
          c1 = 'P';
        }
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        i = paramView.getId();
        if (i != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(i));
          localObject = paramView.getResources();
          if ((i != 0) && (localObject != null)) {
            switch (0xFF000000 & i)
            {
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramView = ((Resources)localObject).getResourcePackageName(i);
        String str = ((Resources)localObject).getResourceTypeName(i);
        localObject = ((Resources)localObject).getResourceEntryName(i);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
      }
      catch (Resources.NotFoundException paramView)
      {
        label570:
        label576:
        label582:
        label588:
        label594:
        label600:
        label606:
        label612:
        continue;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append('V');
      break;
      localStringBuilder.append('I');
      break;
      localStringBuilder.append('G');
      break;
      c1 = '.';
      break label118;
      c1 = '.';
      break label135;
      c1 = 'D';
      break label152;
      c1 = '.';
      break label169;
      c1 = '.';
      break label186;
      c1 = '.';
      break label203;
      c1 = '.';
      break label220;
      c1 = '.';
      break label244;
      c1 = '.';
      break label261;
      paramView = "app";
      continue;
      paramView = "android";
    }
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return mFragments.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!mReallyStopped)
    {
      mReallyStopped = true;
      mRetaining = paramBoolean;
      mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = Build.VERSION.SDK_INT;
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(mReallyStopped);
    FragmentHostCallback localFragmentHostCallback = mFragments.mHost;
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(mLoadersStarted);
    if (mLoaderManager != null)
    {
      paramPrintWriter.print(str);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
      paramPrintWriter.println(":");
      mLoaderManager.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    mFragments.mHost.mFragmentManager.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    dumpViewHierarchy(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {
      return custom;
    }
    return null;
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return mFragments.mHost.mFragmentManager;
  }
  
  public LoaderManager getSupportLoaderManager()
  {
    FragmentHostCallback localFragmentHostCallback = mFragments.mHost;
    if (mLoaderManager != null) {
      return mLoaderManager;
    }
    mCheckedForLoaderManager = true;
    mLoaderManager = localFragmentHostCallback.getLoaderManager("(root)", mLoadersStarted, true);
    return mLoaderManager;
  }
  
  public final MediaControllerCompat getSupportMediaController()
  {
    return mMediaController;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i -= 1;
      String str = (String)mPendingFragmentActivityResults.get(i);
      mPendingFragmentActivityResults.remove(i);
      if (str == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = mFragments.findFragmentByWho(str);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
        return;
      }
      localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    if (!mFragments.mHost.mFragmentManager.popBackStackImmediate()) {
      onBackPressedNotHandled();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = mFragments;
    mHost.mFragmentManager.attachController(mHost, mHost, null);
    super.onCreate(paramBundle);
    localObject2 = (NonConfigurationInstances)getLastNonConfigurationInstance();
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      localObject3 = mFragments;
      localObject4 = loaders;
      mHost.mAllLoaderManagers = ((SimpleArrayMap)localObject4);
    }
    if (paramBundle != null)
    {
      localObject3 = paramBundle.getParcelable("android:support:fragments");
      localObject4 = mFragments;
      if (localObject2 != null) {
        localObject1 = fragments;
      }
      mHost.mFragmentManager.restoreAllState((Parcelable)localObject3, (List)localObject1);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        localObject1 = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject1 != null) && (paramBundle != null) && (localObject1.length == paramBundle.length)) {
          break label209;
        }
        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
      }
    }
    for (;;)
    {
      if (mPendingFragmentActivityResults == null)
      {
        mPendingFragmentActivityResults = new SparseArrayCompat();
        mNextCandidateRequestIndex = 0;
      }
      mFragments.mHost.mFragmentManager.dispatchCreate();
      return;
      label209:
      mPendingFragmentActivityResults = new SparseArrayCompat(localObject1.length);
      int i = 0;
      while (i < localObject1.length)
      {
        mPendingFragmentActivityResults.put(localObject1[i], paramBundle[i]);
        i += 1;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      FragmentController localFragmentController = mFragments;
      MenuInflater localMenuInflater = getMenuInflater();
      boolean bool2 = mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, localMenuInflater);
      if (Build.VERSION.SDK_INT >= 11) {
        return bool1 | bool2;
      }
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    mFragments.mHost.mFragmentManager.dispatchDestroy();
    FragmentHostCallback localFragmentHostCallback = mFragments.mHost;
    if (mLoaderManager != null) {
      mLoaderManager.doDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    mFragments.mHost.mFragmentManager.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
    }
    return mFragments.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    mResumed = false;
    if (mHandler.hasMessages(2))
    {
      mHandler.removeMessages(2);
      onResumeFragments();
    }
    mFragments.mHost.mFragmentManager.moveToState$2563266(4);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    mHandler.removeMessages(2);
    onResumeFragments();
    mFragments.execPendingActions();
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (mOptionsMenuInvalidated)
      {
        mOptionsMenuInvalidated = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return onPrepareOptionsPanel(paramView, paramMenu) | mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  void onReallyStop()
  {
    Object localObject = mFragments;
    boolean bool = mRetaining;
    localObject = mHost;
    mRetainLoaders = bool;
    if ((mLoaderManager != null) && (mLoadersStarted))
    {
      mLoadersStarted = false;
      if (!bool) {
        break label65;
      }
      mLoaderManager.doRetain();
    }
    for (;;)
    {
      mFragments.mHost.mFragmentManager.moveToState$2563266(2);
      return;
      label65:
      mLoaderManager.doStop();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = paramInt >> 16 & 0xFFFF;
    String str;
    if (i != 0)
    {
      i -= 1;
      str = (String)mPendingFragmentActivityResults.get(i);
      mPendingFragmentActivityResults.remove(i);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
      }
    }
    else
    {
      return;
    }
    Fragment localFragment = mFragments.findFragmentByWho(str);
    if (localFragment == null)
    {
      Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
      return;
    }
    localFragment.onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    mHandler.sendEmptyMessage(2);
    mResumed = true;
    mFragments.execPendingActions();
  }
  
  public void onResumeFragments()
  {
    mFragments.mHost.mFragmentManager.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (mStopped) {
      doReallyStop(true);
    }
    Object localObject4 = onRetainCustomNonConfigurationInstance();
    FragmentManagerImpl localFragmentManagerImpl = mFragments.mHost.mFragmentManager;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (mActive != null)
    {
      int i = 0;
      localObject1 = null;
      if (i < mActive.size())
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        localObject3 = localObject1;
        if (localFragment != null)
        {
          localObject3 = localObject1;
          if (mRetainInstance)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            mRetaining = true;
            if (mTarget == null) {
              break label189;
            }
          }
        }
        label189:
        for (int j = mTarget.mIndex;; j = -1)
        {
          mTargetIndex = j;
          localObject3 = localObject2;
          if (FragmentManagerImpl.DEBUG)
          {
            Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
            localObject3 = localObject2;
          }
          i += 1;
          localObject1 = localObject3;
          break;
        }
      }
    }
    for (;;)
    {
      localObject2 = mFragments.mHost.retainLoaderNonConfig();
      if ((localObject1 == null) && (localObject2 == null) && (localObject4 == null)) {
        return null;
      }
      localObject3 = new NonConfigurationInstances();
      custom = localObject4;
      fragments = ((List)localObject1);
      loaders = ((SimpleArrayMap)localObject2);
      return localObject3;
      localObject1 = null;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject = mFragments.mHost.mFragmentManager.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (mPendingFragmentActivityResults.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", mNextCandidateRequestIndex);
      localObject = new int[mPendingFragmentActivityResults.size()];
      String[] arrayOfString = new String[mPendingFragmentActivityResults.size()];
      int i = 0;
      while (i < mPendingFragmentActivityResults.size())
      {
        localObject[i] = mPendingFragmentActivityResults.keyAt(i);
        arrayOfString[i] = ((String)mPendingFragmentActivityResults.valueAt(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    mStopped = false;
    mReallyStopped = false;
    mHandler.removeMessages(1);
    if (!mCreated)
    {
      mCreated = true;
      mFragments.mHost.mFragmentManager.dispatchActivityCreated();
    }
    mFragments.noteStateNotSaved();
    mFragments.execPendingActions();
    Object localObject = mFragments.mHost;
    if (!mLoadersStarted)
    {
      mLoadersStarted = true;
      if (mLoaderManager == null) {
        break label183;
      }
      mLoaderManager.doStart();
    }
    FragmentHostCallback localFragmentHostCallback;
    int k;
    for (;;)
    {
      mCheckedForLoaderManager = true;
      mFragments.mHost.mFragmentManager.dispatchStart();
      localFragmentHostCallback = mFragments.mHost;
      if (mAllLoaderManagers == null) {
        return;
      }
      k = mAllLoaderManagers.size();
      localObject = new LoaderManagerImpl[k];
      i = k - 1;
      while (i >= 0)
      {
        localObject[i] = ((LoaderManagerImpl)mAllLoaderManagers.valueAt(i));
        i -= 1;
      }
      label183:
      if (!mCheckedForLoaderManager)
      {
        mLoaderManager = ((FragmentHostCallback)localObject).getLoaderManager("(root)", mLoadersStarted, false);
        if ((mLoaderManager != null) && (!mLoaderManager.mStarted)) {
          mLoaderManager.doStart();
        }
      }
    }
    int i = 0;
    while (i < k)
    {
      localFragmentHostCallback = localObject[i];
      if (mRetaining)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "Finished Retaining in " + localFragmentHostCallback);
        }
        mRetaining = false;
        int j = mLoaders.size() - 1;
        while (j >= 0)
        {
          LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)mLoaders.valueAt(j);
          if (mRetaining)
          {
            if (LoaderManagerImpl.DEBUG) {
              Log.v("LoaderManager", "  Finished Retaining: " + localLoaderInfo);
            }
            mRetaining = false;
            if ((mStarted != mRetainingStarted) && (!mStarted)) {
              localLoaderInfo.stop();
            }
          }
          if ((mStarted) && (mHaveData) && (!mReportNextStart)) {
            localLoaderInfo.callOnLoadFinished(mLoader, mData);
          }
          j -= 1;
        }
      }
      localFragmentHostCallback.doReportStart();
      i += 1;
    }
  }
  
  public void onStateNotSaved()
  {
    mFragments.noteStateNotSaved();
  }
  
  public void onStop()
  {
    super.onStop();
    mStopped = true;
    mHandler.sendEmptyMessage(1);
    mFragments.mHost.mFragmentManager.dispatchStop();
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setEnterSharedElementCallback(ActivityCompat21.createCallback(ActivityCompat.createCallback(paramSharedElementCallback)));
    }
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setExitSharedElementCallback(ActivityCompat21.createCallback(ActivityCompat.createCallback(paramSharedElementCallback)));
    }
  }
  
  public final void setSupportMediaController(MediaControllerCompat paramMediaControllerCompat)
  {
    mMediaController = paramMediaControllerCompat;
    if (Build.VERSION.SDK_INT >= 21) {
      setMediaController((MediaController)mImpl.getMediaController());
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!mStartedActivityFromFragment) && (paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    mStartedActivityFromFragment = true;
    if (paramInt == -1) {}
    try
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      mStartedActivityFromFragment = false;
    }
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    ActivityCompat.startActivityForResult(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt), paramBundle);
    mStartedActivityFromFragment = false;
  }
  
  public void supportFinishAfterTransition()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      finishAfterTransition();
      return;
    }
    finish();
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    mOptionsMenuInvalidated = true;
  }
  
  public void supportPostponeEnterTransition()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      postponeEnterTransition();
    }
  }
  
  public void supportStartPostponedEnterTransition()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      startPostponedEnterTransition();
    }
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt)
  {
    if ((!mRequestedPermissionsFromFragment) && (paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
  }
  
  final class HostCallbacks
    extends FragmentHostCallback<FragmentActivity>
  {
    public HostCallbacks()
    {
      super();
    }
    
    public final void onAttachFragment(Fragment paramFragment)
    {
      FragmentActivity.this.onAttachFragment(paramFragment);
    }
    
    public final void onDump$ec96877(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      dump(paramString, null, paramPrintWriter, paramArrayOfString);
    }
    
    public final View onFindViewById(int paramInt)
    {
      return findViewById(paramInt);
    }
    
    public final LayoutInflater onGetLayoutInflater()
    {
      return getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public final int onGetWindowAnimations()
    {
      Window localWindow = getWindow();
      if (localWindow == null) {
        return 0;
      }
      return getAttributeswindowAnimations;
    }
    
    public final boolean onHasView()
    {
      Window localWindow = getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public final boolean onHasWindowAnimations()
    {
      return getWindow() != null;
    }
    
    public final void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
    {
      FragmentActivity.this.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
    }
    
    public final boolean onShouldSaveFragmentState$6585081f()
    {
      return !isFinishing();
    }
    
    public final boolean onShouldShowRequestPermissionRationale(String paramString)
    {
      return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, paramString);
    }
    
    public final void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
    {
      startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    }
    
    public final void onSupportInvalidateOptionsMenu()
    {
      supportInvalidateOptionsMenu();
    }
  }
  
  static final class NonConfigurationInstances
  {
    Object custom;
    List<Fragment> fragments;
    SimpleArrayMap<String, LoaderManager> loaders;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */