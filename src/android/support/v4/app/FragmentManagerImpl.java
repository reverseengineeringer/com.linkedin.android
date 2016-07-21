package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl
  extends FragmentManager
  implements LayoutInflaterFactory
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static boolean DEBUG;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB;
  static Field sAnimationListenerField;
  ArrayList<Fragment> mActive;
  ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<Integer> mAvailIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new Runnable()
  {
    public final void run()
    {
      execPendingActions();
    }
  };
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  FragmentHostCallback mHost;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<Runnable> mPendingActions;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    HONEYCOMB = bool;
    sAnimationListenerField = null;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void checkStateLoss()
  {
    if (mStateSaved) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + mNoTransactionsBecause);
    }
  }
  
  private Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, mNextAnim);
    if (localAnimation != null) {
      return localAnimation;
    }
    if (mNextAnim != 0)
    {
      paramFragment = AnimationUtils.loadAnimation(mHost.mContext, mNextAnim);
      if (paramFragment != null) {
        return paramFragment;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
      if (paramInt1 < 0) {
        return null;
      }
      break;
    case 4097: 
      if (paramBoolean) {}
      for (paramInt1 = 1;; paramInt1 = 2) {
        break;
      }
    case 8194: 
      if (paramBoolean) {}
      for (paramInt1 = 3;; paramInt1 = 4) {
        break;
      }
    case 4099: 
      if (paramBoolean) {}
      for (paramInt1 = 5;; paramInt1 = 6) {
        break;
      }
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (mHost.onHasWindowAnimations()) {
          paramInt1 = mHost.onGetWindowAnimations();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return makeOpenCloseAnimation$376f30fd(1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return makeOpenCloseAnimation$376f30fd(1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return makeOpenCloseAnimation$376f30fd(0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return makeOpenCloseAnimation$376f30fd(1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return makeFadeAnimation$424ea1bd(0.0F, 1.0F);
    case 6: 
      return makeFadeAnimation$424ea1bd(1.0F, 0.0F);
    }
    return null;
  }
  
  private static Animation makeFadeAnimation$424ea1bd(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(DECELERATE_CUBIC);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }
  
  private static Animation makeOpenCloseAnimation$376f30fd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  private void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, mCurState, 0, 0, false);
  }
  
  public static int reverseTransit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (mStateBundle == null) {
      mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(mStateBundle);
    if (!mStateBundle.isEmpty())
    {
      localObject2 = mStateBundle;
      mStateBundle = null;
    }
    if (mView != null) {
      saveFragmentViewState(paramFragment);
    }
    Object localObject1 = localObject2;
    if (mSavedViewState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", mSavedViewState);
    }
    localObject2 = localObject1;
    if (!mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", mUserVisibleHint);
    }
    return (Bundle)localObject2;
  }
  
  private void saveFragmentViewState(Fragment paramFragment)
  {
    if (mInnerView == null) {
      return;
    }
    if (mStateArray == null) {
      mStateArray = new SparseArray();
    }
    for (;;)
    {
      mInnerView.saveHierarchyState(mStateArray);
      if (mStateArray.size() <= 0) {
        break;
      }
      mSavedViewState = mStateArray;
      mStateArray = null;
      return;
      mStateArray.clear();
    }
  }
  
  /* Error */
  private void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 287	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 289	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 290	java/util/ArrayList:<init>	()V
    //   17: putfield 287	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 287	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 291	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +56 -> 91
    //   38: getstatic 79	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   41: ifeq +37 -> 78
    //   44: ldc_w 293
    //   47: new 135	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 295
    //   54: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_1
    //   58: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 300
    //   64: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 309	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: getfield 287	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   82: iload_1
    //   83: aload_2
    //   84: invokevirtual 313	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: iload_3
    //   92: iload_1
    //   93: if_icmpge +79 -> 172
    //   96: aload_0
    //   97: getfield 287	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   100: aconst_null
    //   101: invokevirtual 317	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 319	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   109: ifnonnull +14 -> 123
    //   112: aload_0
    //   113: new 289	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 290	java/util/ArrayList:<init>	()V
    //   120: putfield 319	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   123: getstatic 79	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   126: ifeq +27 -> 153
    //   129: ldc_w 293
    //   132: new 135	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 321
    //   139: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: iload_3
    //   143: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 309	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: aload_0
    //   154: getfield 319	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   157: iload_3
    //   158: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokevirtual 317	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   164: pop
    //   165: iload_3
    //   166: iconst_1
    //   167: iadd
    //   168: istore_3
    //   169: goto -78 -> 91
    //   172: getstatic 79	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   175: ifeq +37 -> 212
    //   178: ldc_w 293
    //   181: new 135	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 329
    //   188: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: iload_1
    //   192: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 331
    //   198: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_2
    //   202: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 309	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   211: pop
    //   212: aload_0
    //   213: getfield 287	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   216: aload_2
    //   217: invokevirtual 317	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: goto -133 -> 88
    //   224: astore_2
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_2
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	FragmentManagerImpl
    //   0	229	1	paramInt	int
    //   0	229	2	paramBackStackRecord	BackStackRecord
    //   31	138	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	224	finally
    //   20	29	224	finally
    //   38	78	224	finally
    //   78	88	224	finally
    //   88	90	224	finally
    //   96	123	224	finally
    //   123	153	224	finally
    //   153	165	224	finally
    //   172	212	224	finally
    //   212	221	224	finally
    //   225	227	224	finally
  }
  
  private static void setHWLayerAnimListenerIfAlpha(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null)) {}
    while (!shouldRunOnHWLayer(paramView, paramAnimation)) {
      return;
    }
    Object localObject1 = null;
    try
    {
      if (sAnimationListenerField == null)
      {
        localObject2 = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField = (Field)localObject2;
        ((Field)localObject2).setAccessible(true);
      }
      Object localObject2 = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
      localObject1 = localObject2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.e("FragmentManager", "No field with the name mListener is found in Animation class", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("FragmentManager", "Cannot access Animation's mListener field", localIllegalAccessException);
      }
    }
    paramAnimation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(paramView, paramAnimation, (Animation.AnimationListener)localObject1));
  }
  
  static boolean shouldRunOnHWLayer(View paramView, Animation paramAnimation)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = bool2;
      if (ViewCompat.getLayerType(paramView) == 0)
      {
        bool1 = bool2;
        if (ViewCompat.hasOverlappingRendering(paramView))
        {
          if (!(paramAnimation instanceof AlphaAnimation)) {
            break label54;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      label54:
      if ((paramAnimation instanceof AnimationSet))
      {
        paramView = ((AnimationSet)paramAnimation).getAnimations();
        i = 0;
        for (;;)
        {
          if (i >= paramView.size()) {
            break label106;
          }
          if ((paramView.get(i) instanceof AlphaAnimation))
          {
            i = 1;
            break;
          }
          i += 1;
        }
      }
      label106:
      i = 0;
    }
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (mHost != null) {}
    for (;;)
    {
      try
      {
        mHost.onDump$ec96877("  ", localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public final void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (mAdded == null) {
      mAdded = new ArrayList();
    }
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    makeActive(paramFragment);
    if (!mDetached)
    {
      if (mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      mAdded.add(paramFragment);
      mAdded = true;
      mRemoving = false;
      if ((mHasMenu) && (mMenuVisible)) {
        mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
  }
  
  public final void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (mBackStackChangeListeners == null) {
      mBackStackChangeListeners = new ArrayList();
    }
    mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public final int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      if ((mAvailBackStackIndices == null) || (mAvailBackStackIndices.size() <= 0))
      {
        if (mBackStackIndices == null) {
          mBackStackIndices = new ArrayList();
        }
        i = mBackStackIndices.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + paramBackStackRecord);
        }
        mBackStackIndices.add(paramBackStackRecord);
        return i;
      }
      int i = ((Integer)mAvailBackStackIndices.remove(mAvailBackStackIndices.size() - 1)).intValue();
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + i + " with " + paramBackStackRecord);
      }
      mBackStackIndices.set(i, paramBackStackRecord);
      return i;
    }
    finally {}
  }
  
  public final void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    mHost = paramFragmentHostCallback;
    mContainer = paramFragmentContainer;
    mParent = paramFragment;
  }
  
  public final void attachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (mDetached)
    {
      mDetached = false;
      if (!mAdded)
      {
        if (mAdded == null) {
          mAdded = new ArrayList();
        }
        if (mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
        mAdded.add(paramFragment);
        mAdded = true;
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment, mCurState, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public final void detachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!mDetached)
    {
      mDetached = true;
      if (mAdded)
      {
        if (mAdded != null)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          mAdded.remove(paramFragment);
        }
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
        mAdded = false;
        moveToState(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final void dispatchActivityCreated()
  {
    mStateSaved = false;
    moveToState$2563266(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performConfigurationChanged(paramConfiguration);
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public final void dispatchCreate()
  {
    mStateSaved = false;
    moveToState$2563266(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (mAdded != null)
    {
      i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (i >= mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)mAdded.get(i);
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
        i += 1;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    if (mCreatedMenus != null)
    {
      i = 0;
      while (i < mCreatedMenus.size())
      {
        paramMenu = (Fragment)mCreatedMenus.get(i);
        if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    mCreatedMenus = ((ArrayList)localObject2);
    return bool2;
  }
  
  public final void dispatchDestroy()
  {
    mDestroyed = true;
    execPendingActions();
    moveToState$2563266(0);
    mHost = null;
    mContainer = null;
    mParent = null;
  }
  
  public final void dispatchLowMemory()
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performLowMemory();
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (mAdded != null)
    {
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)mAdded.get(i);
        bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (localFragment.performPrepareOptionsMenu(paramMenu)) {
            bool2 = true;
          }
        }
        i += 1;
        bool1 = bool2;
      }
    }
    return bool2;
  }
  
  public final void dispatchResume()
  {
    mStateSaved = false;
    moveToState$2563266(5);
  }
  
  public final void dispatchStart()
  {
    mStateSaved = false;
    moveToState$2563266(4);
  }
  
  public final void dispatchStop()
  {
    mStateSaved = true;
    moveToState$2563266(3);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString + "    ";
    int j;
    int i;
    if (mActive != null)
    {
      j = mActive.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < j)
        {
          Fragment localFragment = (Fragment)mActive.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment);
          if (localFragment != null) {
            localFragment.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    if (mAdded != null)
    {
      j = mAdded.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i = 0;
        while (i < j)
        {
          paramFileDescriptor = (Fragment)mAdded.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (mCreatedMenus != null)
    {
      j = mCreatedMenus.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < j)
        {
          paramFileDescriptor = (Fragment)mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (mBackStack != null)
    {
      j = mBackStack.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < j)
        {
          paramFileDescriptor = (BackStackRecord)mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.dump$ec96877(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    try
    {
      if (mBackStackIndices != null)
      {
        j = mBackStackIndices.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < j)
          {
            paramFileDescriptor = (BackStackRecord)mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((mAvailBackStackIndices != null) && (mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(mAvailBackStackIndices.toArray()));
      }
      if (mPendingActions != null)
      {
        j = mPendingActions.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = 0;
          while (i < j)
          {
            paramFileDescriptor = (Runnable)mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(mHost);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(mContainer);
    if (mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(mStateSaved);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(mDestroyed);
    if (mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(mNeedMenuInvalidate);
    }
    if (mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(mNoTransactionsBecause);
    }
    if ((mAvailIndices != null) && (mAvailIndices.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(mAvailIndices.toArray()));
    }
  }
  
  public final void enqueueAction(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((mDestroyed) || (mHost == null)) {
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally
    {
      throw paramRunnable;
      if (mPendingActions == null) {
        mPendingActions = new ArrayList();
      }
      mPendingActions.add(paramRunnable);
      if (mPendingActions.size() == 1) {
        mHost.mHandler.removeCallbacks(mExecCommit);
      }
    }
  }
  
  public final boolean execPendingActions()
  {
    if (mExecutingActions) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != mHost.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    int j;
    for (boolean bool = false;; bool = true) {
      try
      {
        if ((mPendingActions == null) || (mPendingActions.size() == 0))
        {
          if (!mHavePendingDeferredStart) {
            break label276;
          }
          j = 0;
          i = 0;
          while (i < mActive.size())
          {
            Fragment localFragment = (Fragment)mActive.get(i);
            int k = j;
            int m;
            if (localFragment != null)
            {
              k = j;
              if (mLoaderManager != null) {
                m = j | mLoaderManager.hasRunningLoaders();
              }
            }
            i += 1;
            j = m;
          }
        }
        j = mPendingActions.size();
        if ((mTmpActions == null) || (mTmpActions.length < j)) {
          mTmpActions = new Runnable[j];
        }
        mPendingActions.toArray(mTmpActions);
        mPendingActions.clear();
        mHost.mHandler.removeCallbacks(mExecCommit);
        mExecutingActions = true;
        int i = 0;
        while (i < j)
        {
          mTmpActions[i].run();
          mTmpActions[i] = null;
          i += 1;
        }
        mExecutingActions = false;
      }
      finally {}
    }
    if (j == 0)
    {
      mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
    label276:
    return bool;
  }
  
  public final boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public final Fragment findFragmentById(int paramInt)
  {
    int i;
    Object localObject;
    if (mAdded != null)
    {
      i = mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mAdded.get(i);
        if ((localObject != null) && (mFragmentId == paramInt)) {
          return (Fragment)localObject;
        }
        i -= 1;
      }
    }
    if (mActive != null)
    {
      i = mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label112;
        }
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (mFragmentId == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label112:
    return null;
  }
  
  public final Fragment findFragmentByTag(String paramString)
  {
    int i;
    Object localObject;
    if ((mAdded != null) && (paramString != null))
    {
      i = mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mAdded.get(i);
        if ((localObject != null) && (paramString.equals(mTag))) {
          return (Fragment)localObject;
        }
        i -= 1;
      }
    }
    if ((mActive != null) && (paramString != null))
    {
      i = mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label126;
        }
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label126:
    return null;
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    if ((mActive != null) && (paramString != null))
    {
      int i = mActive.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public final FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)mBackStack.get(paramInt);
  }
  
  public final int getBackStackEntryCount()
  {
    if (mBackStack != null) {
      return mBackStack.size();
    }
    return 0;
  }
  
  public final Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i >= mActive.size()) {
        throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)mActive.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public final List<Fragment> getFragments()
  {
    return mActive;
  }
  
  public final void hideFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!mHidden)
    {
      mHidden = true;
      if (mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null)
        {
          setHWLayerAnimListenerIfAlpha(mView, localAnimation);
          mView.startAnimation(localAnimation);
        }
        mView.setVisibility(8);
      }
      if ((mAdded) && (mHasMenu) && (mMenuVisible)) {
        mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  public final boolean isDestroyed()
  {
    return mDestroyed;
  }
  
  final void makeActive(Fragment paramFragment)
  {
    if (mIndex >= 0) {}
    for (;;)
    {
      return;
      if ((mAvailIndices == null) || (mAvailIndices.size() <= 0))
      {
        if (mActive == null) {
          mActive = new ArrayList();
        }
        paramFragment.setIndex(mActive.size(), mParent);
        mActive.add(paramFragment);
      }
      while (DEBUG)
      {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        return;
        paramFragment.setIndex(((Integer)mAvailIndices.remove(mAvailIndices.size() - 1)).intValue(), mParent);
        mActive.set(mIndex, paramFragment);
      }
    }
  }
  
  final void moveToState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((mHost == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No host");
    }
    if ((!paramBoolean) && (mCurState == paramInt1)) {}
    do
    {
      do
      {
        return;
        mCurState = paramInt1;
      } while (mActive == null);
      boolean bool1 = false;
      int i = 0;
      while (i < mActive.size())
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        boolean bool2 = bool1;
        if (localFragment != null)
        {
          moveToState(localFragment, paramInt1, paramInt2, paramInt3, false);
          bool2 = bool1;
          if (mLoaderManager != null) {
            bool2 = bool1 | mLoaderManager.hasRunningLoaders();
          }
        }
        i += 1;
        bool1 = bool2;
      }
      if (!bool1) {
        startPendingDeferredFragments();
      }
    } while ((!mNeedMenuInvalidate) || (mHost == null) || (mCurState != 5));
    mHost.onSupportInvalidateOptionsMenu();
    mNeedMenuInvalidate = false;
  }
  
  final void moveToState(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    if (mAdded)
    {
      i = paramInt1;
      if (!mDetached) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    int j = i;
    if (mRemoving)
    {
      j = i;
      if (i > mState) {
        j = mState;
      }
    }
    paramInt1 = j;
    if (mDeferStart)
    {
      paramInt1 = j;
      if (mState < 4)
      {
        paramInt1 = j;
        if (j > 3) {
          paramInt1 = 3;
        }
      }
    }
    int k;
    if (mState < paramInt1)
    {
      if ((mFromLayout) && (!mInLayout)) {
        return;
      }
      if (mAnimatingAway != null)
      {
        mAnimatingAway = null;
        moveToState(paramFragment, mStateAfterAnimating, 0, 0, true);
      }
      i = paramInt1;
      k = paramInt1;
      j = paramInt1;
      switch (mState)
      {
      default: 
        i = paramInt1;
      }
    }
    while (mState != i)
    {
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; expected state " + i + " found " + mState);
      mState = i;
      return;
      if (DEBUG) {
        Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
      }
      j = paramInt1;
      if (mSavedFragmentState != null)
      {
        mSavedFragmentState.setClassLoader(mHost.mContext.getClassLoader());
        mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
        mTarget = getFragment(mSavedFragmentState, "android:target_state");
        if (mTarget != null) {
          mTargetRequestCode = mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        mUserVisibleHint = mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        j = paramInt1;
        if (!mUserVisibleHint)
        {
          mDeferStart = true;
          j = paramInt1;
          if (paramInt1 > 3) {
            j = 3;
          }
        }
      }
      mHost = mHost;
      mParentFragment = mParent;
      if (mParent != null) {}
      for (Object localObject1 = mParent.mChildFragmentManager;; localObject1 = mHost.mFragmentManager)
      {
        mFragmentManager = ((FragmentManagerImpl)localObject1);
        mCalled = false;
        paramFragment.onAttach(mHost.mContext);
        if (mCalled) {
          break;
        }
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      if (mParentFragment == null) {
        mHost.onAttachFragment(paramFragment);
      }
      if (!mRetaining) {
        paramFragment.performCreate(mSavedFragmentState);
      }
      mRetaining = false;
      i = j;
      label600:
      label632:
      Object localObject2;
      if (mFromLayout)
      {
        mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(mSavedFragmentState), null, mSavedFragmentState);
        if (mView == null) {
          break label1082;
        }
        mInnerView = mView;
        if (Build.VERSION.SDK_INT >= 11)
        {
          ViewCompat.setSaveFromParentEnabled$53599cc9(mView);
          if (mHidden) {
            mView.setVisibility(8);
          }
          paramFragment.onViewCreated(mView, mSavedFragmentState);
          i = j;
        }
      }
      else
      {
        k = i;
        if (i > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!mFromLayout)
          {
            localObject1 = null;
            if (mContainerId != 0)
            {
              localObject2 = (ViewGroup)mContainer.onFindViewById(mContainerId);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = localObject2;
                if (!mRestored)
                {
                  throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(mContainerId) + " (" + paramFragment.getResources().getResourceName(mContainerId) + ") for fragment " + paramFragment));
                  localObject1 = localObject2;
                }
              }
            }
            mContainer = ((ViewGroup)localObject1);
            mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(mSavedFragmentState), (ViewGroup)localObject1, mSavedFragmentState);
            if (mView == null) {
              break label1108;
            }
            mInnerView = mView;
            if (Build.VERSION.SDK_INT < 11) {
              break label1094;
            }
            ViewCompat.setSaveFromParentEnabled$53599cc9(mView);
            label851:
            if (localObject1 != null)
            {
              localObject2 = loadAnimation(paramFragment, paramInt2, true, paramInt3);
              if (localObject2 != null)
              {
                setHWLayerAnimListenerIfAlpha(mView, (Animation)localObject2);
                mView.startAnimation((Animation)localObject2);
              }
              ((ViewGroup)localObject1).addView(mView);
            }
            if (mHidden) {
              mView.setVisibility(8);
            }
            paramFragment.onViewCreated(mView, mSavedFragmentState);
          }
        }
      }
      for (;;)
      {
        paramFragment.performActivityCreated(mSavedFragmentState);
        if (mView != null) {
          paramFragment.restoreViewState(mSavedFragmentState);
        }
        mSavedFragmentState = null;
        k = i;
        j = k;
        if (k > 3)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          }
          paramFragment.performStart();
          j = k;
        }
        i = j;
        if (j <= 4) {
          break;
        }
        if (DEBUG) {
          Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
        }
        paramFragment.performResume();
        mSavedFragmentState = null;
        mSavedViewState = null;
        i = j;
        break;
        mView = NoSaveStateFrameLayout.wrap(mView);
        break label600;
        label1082:
        mInnerView = null;
        i = j;
        break label632;
        label1094:
        mView = NoSaveStateFrameLayout.wrap(mView);
        break label851;
        label1108:
        mInnerView = null;
      }
      i = paramInt1;
      if (mState > paramInt1) {
        switch (mState)
        {
        default: 
          i = paramInt1;
          break;
        case 1: 
        case 5: 
        case 4: 
        case 3: 
        case 2: 
          for (;;)
          {
            i = paramInt1;
            if (paramInt1 > 0) {
              break;
            }
            if ((mDestroyed) && (mAnimatingAway != null))
            {
              localObject1 = mAnimatingAway;
              mAnimatingAway = null;
              ((View)localObject1).clearAnimation();
            }
            if (mAnimatingAway == null) {
              break label1536;
            }
            mStateAfterAnimating = paramInt1;
            i = 1;
            break;
            if (paramInt1 < 5)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
              }
              paramFragment.performPause();
            }
            if (paramInt1 < 4)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
              }
              paramFragment.performStop();
            }
            if (paramInt1 < 3)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
              }
              paramFragment.performReallyStop();
            }
            if (paramInt1 < 2)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
              }
              if ((mView != null) && (mHost.onShouldSaveFragmentState$6585081f()) && (mSavedViewState == null)) {
                saveFragmentViewState(paramFragment);
              }
              paramFragment.performDestroyView();
              if ((mView != null) && (mContainer != null))
              {
                localObject2 = null;
                localObject1 = localObject2;
                if (mCurState > 0)
                {
                  localObject1 = localObject2;
                  if (!mDestroyed) {
                    localObject1 = loadAnimation(paramFragment, paramInt2, false, paramInt3);
                  }
                }
                if (localObject1 != null)
                {
                  mAnimatingAway = mView;
                  mStateAfterAnimating = paramInt1;
                  ((Animation)localObject1).setAnimationListener(new AnimateOnHWLayerIfNeededListener(mView, (Animation)localObject1)
                  {
                    public final void onAnimationEnd(Animation paramAnonymousAnimation)
                    {
                      super.onAnimationEnd(paramAnonymousAnimation);
                      if (paramFragmentmAnimatingAway != null)
                      {
                        paramFragmentmAnimatingAway = null;
                        moveToState(paramFragment, paramFragmentmStateAfterAnimating, 0, 0, false);
                      }
                    }
                  });
                  mView.startAnimation((Animation)localObject1);
                }
                mContainer.removeView(mView);
              }
              mContainer = null;
              mView = null;
              mInnerView = null;
            }
          }
          label1536:
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!mRetaining) {
            paramFragment.performDestroy();
          }
          for (;;)
          {
            mCalled = false;
            paramFragment.onDetach();
            if (mCalled) {
              break;
            }
            throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
            mState = 0;
          }
          i = paramInt1;
          if (!paramBoolean) {
            if (!mRetaining)
            {
              i = paramInt1;
              if (mIndex >= 0)
              {
                if (DEBUG) {
                  Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
                }
                mActive.set(mIndex, null);
                if (mAvailIndices == null) {
                  mAvailIndices = new ArrayList();
                }
                mAvailIndices.add(Integer.valueOf(mIndex));
                mHost.inactivateFragment(mWho);
                paramFragment.initState();
                i = paramInt1;
              }
            }
            else
            {
              mHost = null;
              mParentFragment = null;
              mFragmentManager = null;
              mChildFragmentManager = null;
              i = paramInt1;
            }
          }
          break;
        }
      }
    }
  }
  
  final void moveToState$2563266(int paramInt)
  {
    moveToState(paramInt, 0, 0, false);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {}
    String str1;
    int k;
    String str2;
    do
    {
      return null;
      paramString = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
      str1 = paramString;
      if (paramString == null) {
        str1 = localTypedArray.getString(0);
      }
      k = localTypedArray.getResourceId(1, -1);
      str2 = localTypedArray.getString(2);
      localTypedArray.recycle();
    } while (!Fragment.isSupportFragmentClass(mHost.mContext, str1));
    if (paramView != null) {}
    for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
      throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
    }
    int j;
    if (k != -1)
    {
      paramString = findFragmentById(k);
      paramView = paramString;
      if (paramString == null)
      {
        paramView = paramString;
        if (str2 != null) {
          paramView = findFragmentByTag(str2);
        }
      }
      paramString = paramView;
      if (paramView == null)
      {
        paramString = paramView;
        if (i != -1) {
          paramString = findFragmentById(i);
        }
      }
      if (DEBUG) {
        Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(k) + " fname=" + str1 + " existing=" + paramString);
      }
      if (paramString != null) {
        break label426;
      }
      paramView = Fragment.instantiate(paramContext, str1);
      mFromLayout = true;
      if (k == 0) {
        break label419;
      }
      j = k;
      label293:
      mFragmentId = j;
      mContainerId = i;
      mTag = str2;
      mInLayout = true;
      mFragmentManager = this;
      mHost = mHost;
      paramView.onInflate(mHost.mContext, paramAttributeSet, mSavedFragmentState);
      addFragment(paramView, true);
      label352:
      if ((mCurState > 0) || (!mFromLayout)) {
        break label555;
      }
      moveToState(paramView, 1, 0, 0, false);
    }
    for (;;)
    {
      if (mView != null) {
        break label563;
      }
      throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
      paramString = null;
      break;
      label419:
      j = i;
      break label293;
      label426:
      if (mInLayout) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
      }
      mInLayout = true;
      mHost = mHost;
      paramView = paramString;
      if (mRetaining) {
        break label352;
      }
      paramString.onInflate(mHost.mContext, paramAttributeSet, mSavedFragmentState);
      paramView = paramString;
      break label352;
      label555:
      moveToState(paramView);
    }
    label563:
    if (k != 0) {
      mView.setId(k);
    }
    if (mView.getTag() == null) {
      mView.setTag(str2);
    }
    return mView;
  }
  
  public final void performPendingDeferredStart(Fragment paramFragment)
  {
    if (mDeferStart)
    {
      if (mExecutingActions) {
        mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    mDeferStart = false;
    moveToState(paramFragment, mCurState, 0, 0, false);
  }
  
  public final void popBackStack()
  {
    enqueueAction(new Runnable()
    {
      public final void run()
      {
        FragmentManagerImpl localFragmentManagerImpl = FragmentManagerImpl.this;
        FragmentHostCallback localFragmentHostCallback = mHost;
        localFragmentManagerImpl.popBackStackState$68507953(null, -1, 0);
      }
    }, false);
  }
  
  public final void popBackStack$255f295(final int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt);
    }
    enqueueAction(new Runnable()
    {
      public final void run()
      {
        FragmentManagerImpl localFragmentManagerImpl = FragmentManagerImpl.this;
        FragmentHostCallback localFragmentHostCallback = mHost;
        localFragmentManagerImpl.popBackStackState$68507953(null, paramInt, val$flags);
      }
    }, false);
  }
  
  public final void popBackStack$505cff1c(final String paramString)
  {
    enqueueAction(new Runnable()
    {
      public final void run()
      {
        FragmentManagerImpl localFragmentManagerImpl = FragmentManagerImpl.this;
        FragmentHostCallback localFragmentHostCallback = mHost;
        localFragmentManagerImpl.popBackStackState$68507953(paramString, -1, val$flags);
      }
    }, false);
  }
  
  public final boolean popBackStackImmediate()
  {
    checkStateLoss();
    execPendingActions();
    return popBackStackState$68507953(null, -1, 0);
  }
  
  final boolean popBackStackState$68507953(String paramString, int paramInt1, int paramInt2)
  {
    if (mBackStack == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = mBackStack.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramString = (BackStackRecord)mBackStack.remove(paramInt1);
      localObject = new SparseArray();
      localSparseArray1 = new SparseArray();
      paramString.calculateBackFragments((SparseArray)localObject, localSparseArray1);
      paramString.popFromBackStack(true, null, (SparseArray)localObject, localSparseArray1);
      reportBackStackChanged();
      return true;
    }
    int i = -1;
    if ((paramString != null) || (paramInt1 >= 0))
    {
      int j = mBackStack.size() - 1;
      while (j >= 0)
      {
        localObject = (BackStackRecord)mBackStack.get(j);
        if (((paramString != null) && (paramString.equals(mName))) || ((paramInt1 >= 0) && (paramInt1 == mIndex))) {
          break;
        }
        j -= 1;
      }
      if (j < 0) {
        return false;
      }
      i = j;
      if ((paramInt2 & 0x1) != 0)
      {
        paramInt2 = j - 1;
        for (;;)
        {
          i = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          localObject = (BackStackRecord)mBackStack.get(paramInt2);
          if ((paramString == null) || (!paramString.equals(mName)))
          {
            i = paramInt2;
            if (paramInt1 < 0) {
              break;
            }
            i = paramInt2;
            if (paramInt1 != mIndex) {
              break;
            }
          }
          paramInt2 -= 1;
        }
      }
    }
    if (i == mBackStack.size() - 1) {
      return false;
    }
    Object localObject = new ArrayList();
    paramInt1 = mBackStack.size() - 1;
    while (paramInt1 > i)
    {
      ((ArrayList)localObject).add(mBackStack.remove(paramInt1));
      paramInt1 -= 1;
    }
    paramInt2 = ((ArrayList)localObject).size() - 1;
    SparseArray localSparseArray1 = new SparseArray();
    SparseArray localSparseArray2 = new SparseArray();
    paramInt1 = 0;
    while (paramInt1 <= paramInt2)
    {
      ((BackStackRecord)((ArrayList)localObject).get(paramInt1)).calculateBackFragments(localSparseArray1, localSparseArray2);
      paramInt1 += 1;
    }
    paramString = null;
    paramInt1 = 0;
    label379:
    BackStackRecord localBackStackRecord;
    if (paramInt1 <= paramInt2)
    {
      if (DEBUG) {
        Log.v("FragmentManager", "Popping back stack state: " + ((ArrayList)localObject).get(paramInt1));
      }
      localBackStackRecord = (BackStackRecord)((ArrayList)localObject).get(paramInt1);
      if (paramInt1 != paramInt2) {
        break label458;
      }
    }
    label458:
    for (boolean bool = true;; bool = false)
    {
      paramString = localBackStackRecord.popFromBackStack(bool, paramString, localSparseArray1, localSparseArray2);
      paramInt1 += 1;
      break label379;
      break;
    }
  }
  
  public final void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, mIndex);
  }
  
  public final void removeFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + mBackStackNesting);
    }
    if (!paramFragment.isInBackStack())
    {
      i = 1;
      if ((!mDetached) || (i != 0))
      {
        if (mAdded != null) {
          mAdded.remove(paramFragment);
        }
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
        mAdded = false;
        mRemoving = true;
        if (i == 0) {
          break label135;
        }
      }
    }
    label135:
    for (int i = 0;; i = 1)
    {
      moveToState(paramFragment, i, paramInt1, paramInt2, false);
      return;
      i = 0;
      break;
    }
  }
  
  final void reportBackStackChanged()
  {
    if (mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < mBackStackChangeListeners.size())
      {
        ((FragmentManager.OnBackStackChangedListener)mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  final void restoreAllState(Parcelable paramParcelable, List<Fragment> paramList)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      paramParcelable = (FragmentManagerState)paramParcelable;
      if (mActive != null)
      {
        Object localObject1;
        Object localObject2;
        if (paramList != null)
        {
          i = 0;
          while (i < paramList.size())
          {
            localObject1 = (Fragment)paramList.get(i);
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject1);
            }
            localObject2 = mActive[mIndex];
            mInstance = ((Fragment)localObject1);
            mSavedViewState = null;
            mBackStackNesting = 0;
            mInLayout = false;
            mAdded = false;
            mTarget = null;
            if (mSavedFragmentState != null)
            {
              mSavedFragmentState.setClassLoader(mHost.mContext.getClassLoader());
              mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
              mSavedFragmentState = mSavedFragmentState;
            }
            i += 1;
          }
        }
        mActive = new ArrayList(mActive.length);
        if (mAvailIndices != null) {
          mAvailIndices.clear();
        }
        int i = 0;
        if (i < mActive.length)
        {
          localObject1 = mActive[i];
          if (localObject1 != null)
          {
            localObject2 = mHost;
            Fragment localFragment = mParent;
            if (mInstance == null)
            {
              Context localContext = mContext;
              if (mArguments != null) {
                mArguments.setClassLoader(localContext.getClassLoader());
              }
              mInstance = Fragment.instantiate(localContext, mClassName, mArguments);
              if (mSavedFragmentState != null)
              {
                mSavedFragmentState.setClassLoader(localContext.getClassLoader());
                mInstance.mSavedFragmentState = mSavedFragmentState;
              }
              mInstance.setIndex(mIndex, localFragment);
              mInstance.mFromLayout = mFromLayout;
              mInstance.mRestored = true;
              mInstance.mFragmentId = mFragmentId;
              mInstance.mContainerId = mContainerId;
              mInstance.mTag = mTag;
              mInstance.mRetainInstance = mRetainInstance;
              mInstance.mDetached = mDetached;
              mInstance.mFragmentManager = mFragmentManager;
              if (DEBUG) {
                Log.v("FragmentManager", "Instantiated fragment " + mInstance);
              }
            }
            localObject2 = mInstance;
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject2);
            }
            mActive.add(localObject2);
            mInstance = null;
          }
          for (;;)
          {
            i += 1;
            break;
            mActive.add(null);
            if (mAvailIndices == null) {
              mAvailIndices = new ArrayList();
            }
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: avail #" + i);
            }
            mAvailIndices.add(Integer.valueOf(i));
          }
        }
        if (paramList != null)
        {
          i = 0;
          if (i < paramList.size())
          {
            localObject1 = (Fragment)paramList.get(i);
            if (mTargetIndex >= 0) {
              if (mTargetIndex >= mActive.size()) {
                break label709;
              }
            }
            for (mTarget = ((Fragment)mActive.get(mTargetIndex));; mTarget = null)
            {
              i += 1;
              break;
              label709:
              Log.w("FragmentManager", "Re-attaching retained fragment " + localObject1 + " target no longer exists: " + mTargetIndex);
            }
          }
        }
        if (mAdded != null)
        {
          mAdded = new ArrayList(mAdded.length);
          i = 0;
          while (i < mAdded.length)
          {
            paramList = (Fragment)mActive.get(mAdded[i]);
            if (paramList == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + mAdded[i]));
            }
            mAdded = true;
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramList);
            }
            if (mAdded.contains(paramList)) {
              throw new IllegalStateException("Already added!");
            }
            mAdded.add(paramList);
            i += 1;
          }
        }
        mAdded = null;
        if (mBackStack == null) {
          break;
        }
        mBackStack = new ArrayList(mBackStack.length);
        i = 0;
        while (i < mBackStack.length)
        {
          paramList = mBackStack[i].instantiate(this);
          if (DEBUG)
          {
            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + mIndex + "): " + paramList);
            paramList.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
          }
          mBackStack.add(paramList);
          if (mIndex >= 0) {
            setBackStackIndex(mIndex, paramList);
          }
          i += 1;
        }
      }
    }
    mBackStack = null;
  }
  
  final Parcelable saveAllState()
  {
    execPendingActions();
    if (HONEYCOMB) {
      mStateSaved = true;
    }
    if ((mActive == null) || (mActive.size() <= 0)) {}
    FragmentState[] arrayOfFragmentState;
    int j;
    int i;
    label355:
    do
    {
      return null;
      int m = mActive.size();
      arrayOfFragmentState = new FragmentState[m];
      j = 0;
      i = 0;
      if (i < m)
      {
        localObject1 = (Fragment)mActive.get(i);
        int k;
        if (localObject1 != null)
        {
          if (mIndex < 0) {
            throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + mIndex));
          }
          k = 1;
          localObject2 = new FragmentState((Fragment)localObject1);
          arrayOfFragmentState[i] = localObject2;
          if ((mState <= 0) || (mSavedFragmentState != null)) {
            break label355;
          }
          mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
          if (mTarget != null)
          {
            if (mTarget.mIndex < 0) {
              throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + mTarget));
            }
            if (mSavedFragmentState == null) {
              mSavedFragmentState = new Bundle();
            }
            putFragment(mSavedFragmentState, "android:target_state", mTarget);
            if (mTargetRequestCode != 0) {
              mSavedFragmentState.putInt("android:target_req_state", mTargetRequestCode);
            }
          }
        }
        for (;;)
        {
          j = k;
          if (DEBUG)
          {
            Log.v("FragmentManager", "Saved state of " + localObject1 + ": " + mSavedFragmentState);
            j = k;
          }
          i += 1;
          break;
          mSavedFragmentState = mSavedFragmentState;
        }
      }
      if (j != 0) {
        break;
      }
    } while (!DEBUG);
    Log.v("FragmentManager", "saveAllState: no fragments!");
    return null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    if (mAdded != null)
    {
      j = mAdded.size();
      localObject1 = localObject2;
      if (j > 0)
      {
        localObject2 = new int[j];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject2[i] = mAdded.get(i)).mIndex;
          if (localObject2[i] < 0) {
            throwException(new IllegalStateException("Failure saving state: active " + mAdded.get(i) + " has cleared index: " + localObject2[i]));
          }
          if (DEBUG) {
            Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + mAdded.get(i));
          }
          i += 1;
        }
      }
    }
    localObject2 = localObject3;
    if (mBackStack != null)
    {
      j = mBackStack.size();
      localObject2 = localObject3;
      if (j > 0)
      {
        localObject3 = new BackStackState[j];
        i = 0;
        for (;;)
        {
          localObject2 = localObject3;
          if (i >= j) {
            break;
          }
          localObject3[i] = new BackStackState((BackStackRecord)mBackStack.get(i));
          if (DEBUG) {
            Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + mBackStack.get(i));
          }
          i += 1;
        }
      }
    }
    localObject3 = new FragmentManagerState();
    mActive = arrayOfFragmentState;
    mAdded = ((int[])localObject1);
    mBackStack = ((BackStackState[])localObject2);
    return (Parcelable)localObject3;
  }
  
  public final Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return (Fragment.SavedState)localObject1;
  }
  
  public final void showFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (mHidden)
    {
      mHidden = false;
      if (mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
        {
          setHWLayerAnimListenerIfAlpha(mView, localAnimation);
          mView.startAnimation(localAnimation);
        }
        mView.setVisibility(0);
      }
      if ((mAdded) && (mHasMenu) && (mMenuVisible)) {
        mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  final void startPendingDeferredFragments()
  {
    if (mActive == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < mActive.size())
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (mParent != null) {
      DebugUtils.buildShortClassTag(mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(mHost, localStringBuilder);
    }
  }
  
  static class AnimateOnHWLayerIfNeededListener
    implements Animation.AnimationListener
  {
    private Animation.AnimationListener mOrignalListener = null;
    private boolean mShouldRunOnHWLayer = false;
    private View mView = null;
    
    public AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation)
    {
      if ((paramView == null) || (paramAnimation == null)) {
        return;
      }
      mView = paramView;
    }
    
    public AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation, Animation.AnimationListener paramAnimationListener)
    {
      if ((paramView == null) || (paramAnimation == null)) {
        return;
      }
      mOrignalListener = paramAnimationListener;
      mView = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if ((mView != null) && (mShouldRunOnHWLayer)) {
        mView.post(new Runnable()
        {
          public final void run()
          {
            ViewCompat.setLayerType(mView, 0, null);
          }
        });
      }
      if (mOrignalListener != null) {
        mOrignalListener.onAnimationEnd(paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      if (mOrignalListener != null) {
        mOrignalListener.onAnimationRepeat(paramAnimation);
      }
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if (mView != null)
      {
        mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(mView, paramAnimation);
        if (mShouldRunOnHWLayer) {
          mView.post(new Runnable()
          {
            public final void run()
            {
              ViewCompat.setLayerType(mView, 2, null);
            }
          });
        }
      }
      if (mOrignalListener != null) {
        mOrignalListener.onAnimationStart(paramAnimation);
      }
    }
  }
  
  static final class FragmentTag
  {
    public static final int[] Fragment = { 16842755, 16842960, 16842961 };
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */