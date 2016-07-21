package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.support.v4.util.MapCollections;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, Runnable
{
  static final boolean SUPPORTS_TRANSITIONS;
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  Op mHead;
  int mIndex = -1;
  final FragmentManagerImpl mManager;
  String mName;
  int mNumOp;
  int mPopEnterAnim;
  int mPopExitAnim;
  ArrayList<String> mSharedElementSourceNames;
  ArrayList<String> mSharedElementTargetNames;
  Op mTail;
  int mTransition;
  int mTransitionStyle;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      SUPPORTS_TRANSITIONS = bool;
      return;
    }
  }
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    mManager = paramFragmentManagerImpl;
  }
  
  private TransitionState beginTransition(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, boolean paramBoolean)
  {
    TransitionState localTransitionState = new TransitionState();
    nonExistentView = new View(mManager.mHost.mContext);
    int i = 0;
    int j = 0;
    while (j < paramSparseArray1.size())
    {
      if (configureTransitions(paramSparseArray1.keyAt(j), localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        i = 1;
      }
      j += 1;
    }
    j = 0;
    while (j < paramSparseArray2.size())
    {
      int m = paramSparseArray2.keyAt(j);
      int k = i;
      if (paramSparseArray1.get(m) == null)
      {
        k = i;
        if (configureTransitions(m, localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
          k = 1;
        }
      }
      j += 1;
      i = k;
    }
    paramSparseArray1 = localTransitionState;
    if (i == 0) {
      paramSparseArray1 = null;
    }
    return paramSparseArray1;
  }
  
  private void calculateFragments(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!mManager.mContainer.onHasView()) {}
    Op localOp;
    do
    {
      return;
      localOp = mHead;
    } while (localOp == null);
    switch (cmd)
    {
    }
    for (;;)
    {
      localOp = next;
      break;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      Object localObject1 = fragment;
      if (mManager.mAdded != null)
      {
        int i = 0;
        if (i < mManager.mAdded.size())
        {
          Fragment localFragment = (Fragment)mManager.mAdded.get(i);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (mContainerId != mContainerId) {}
          }
          else
          {
            if (localFragment != localObject1) {
              break label197;
            }
            localObject2 = null;
            paramSparseArray2.remove(mContainerId);
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            break;
            label197:
            setFirstOut(paramSparseArray1, paramSparseArray2, localFragment);
            localObject2 = localObject1;
          }
        }
      }
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
    }
  }
  
  private static Object captureExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      paramFragment = paramFragment.getView();
      localObject = paramObject;
      if (paramObject != null)
      {
        FragmentTransitionCompat21.captureTransitioningViews(paramArrayList, paramFragment);
        if (paramArrayMap != null) {
          paramArrayList.removeAll(paramArrayMap.values());
        }
        if (!paramArrayList.isEmpty()) {
          break label52;
        }
        localObject = null;
      }
    }
    return localObject;
    label52:
    paramArrayList.add(paramView);
    FragmentTransitionCompat21.addTargets((Transition)paramObject, paramArrayList);
    return paramObject;
  }
  
  private int commitInternal(boolean paramBoolean)
  {
    if (mCommitted) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      Log.v("FragmentManager", "Commit: " + this);
      dump$ec96877("  ", new PrintWriter(new LogWriter("FragmentManager")));
    }
    mCommitted = true;
    if (mAddToBackStack) {}
    for (mIndex = mManager.allocBackStackIndex(this);; mIndex = -1)
    {
      mManager.enqueueAction(this, paramBoolean);
      return mIndex;
    }
  }
  
  private boolean configureTransitions(final int paramInt, final TransitionState paramTransitionState, final boolean paramBoolean, final SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    final ViewGroup localViewGroup = (ViewGroup)mManager.mContainer.onFindViewById(paramInt);
    if (localViewGroup == null) {
      return false;
    }
    final Object localObject5 = (Fragment)paramSparseArray2.get(paramInt);
    final Object localObject6 = (Fragment)paramSparseArray1.get(paramInt);
    Object localObject1;
    if (localObject5 == null)
    {
      localObject1 = null;
      if ((localObject5 != null) && (localObject6 != null)) {
        break label167;
      }
      paramSparseArray1 = null;
    }
    Object localObject3;
    final ArrayList localArrayList1;
    Object localObject2;
    Object localObject4;
    for (;;)
    {
      if (localObject6 != null) {
        break label237;
      }
      localObject3 = null;
      paramSparseArray2 = null;
      localArrayList1 = new ArrayList();
      localObject2 = paramSparseArray1;
      if (paramSparseArray1 != null)
      {
        localObject4 = remapSharedElements(paramTransitionState, (Fragment)localObject6, paramBoolean);
        if (!((ArrayMap)localObject4).isEmpty()) {
          break label268;
        }
        localObject2 = null;
        paramSparseArray2 = null;
      }
      if ((localObject1 != null) || (localObject2 != null) || (localObject3 != null)) {
        break label363;
      }
      return false;
      if (paramBoolean) {}
      for (paramSparseArray1 = ((Fragment)localObject5).getReenterTransition();; paramSparseArray1 = ((Fragment)localObject5).getEnterTransition())
      {
        localObject1 = FragmentTransitionCompat21.cloneTransition(paramSparseArray1);
        break;
      }
      label167:
      if (paramBoolean) {}
      for (paramSparseArray1 = ((Fragment)localObject6).getSharedElementReturnTransition();; paramSparseArray1 = ((Fragment)localObject5).getSharedElementEnterTransition())
      {
        if (paramSparseArray1 != null) {
          break label199;
        }
        paramSparseArray1 = null;
        break;
      }
      label199:
      paramSparseArray2 = (Transition)paramSparseArray1;
      if (paramSparseArray2 == null)
      {
        paramSparseArray1 = null;
      }
      else
      {
        paramSparseArray1 = new TransitionSet();
        paramSparseArray1.addTransition(paramSparseArray2);
      }
    }
    label237:
    if (paramBoolean) {}
    for (paramSparseArray2 = ((Fragment)localObject6).getReturnTransition();; paramSparseArray2 = ((Fragment)localObject6).getExitTransition())
    {
      localObject3 = FragmentTransitionCompat21.cloneTransition(paramSparseArray2);
      break;
    }
    label268:
    if (paramBoolean) {}
    for (paramSparseArray2 = mEnterTransitionCallback;; paramSparseArray2 = mEnterTransitionCallback)
    {
      if (paramSparseArray2 != null) {
        paramSparseArray2.onSharedElementStart(new ArrayList(((ArrayMap)localObject4).keySet()), new ArrayList(((ArrayMap)localObject4).values()), null);
      }
      localViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          localViewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
          if (paramSparseArray1 != null)
          {
            FragmentTransitionCompat21.removeTargets(paramSparseArray1, localArrayList1);
            localArrayList1.clear();
            ArrayMap localArrayMap = BackStackRecord.access$000(BackStackRecord.this, paramTransitionState, paramBoolean, localObject5);
            FragmentTransitionCompat21.setSharedElementTargets(paramSparseArray1, paramTransitionStatenonExistentView, localArrayMap, localArrayList1);
            BackStackRecord.access$100(BackStackRecord.this, localArrayMap, paramTransitionState);
            BackStackRecord.access$200$4a5f5891(localObject5, localObject6, paramBoolean, localArrayMap);
          }
          return true;
        }
      });
      localObject2 = paramSparseArray1;
      paramSparseArray2 = (SparseArray<Fragment>)localObject4;
      break;
    }
    label363:
    ArrayList localArrayList2 = new ArrayList();
    Object localObject7 = captureExitingViews(localObject3, (Fragment)localObject6, localArrayList2, paramSparseArray2, nonExistentView);
    if ((mSharedElementTargetNames != null) && (paramSparseArray2 != null))
    {
      paramSparseArray1 = (View)paramSparseArray2.get(mSharedElementTargetNames.get(0));
      if (paramSparseArray1 != null)
      {
        if (localObject7 != null) {
          FragmentTransitionCompat21.setEpicenter(localObject7, paramSparseArray1);
        }
        if (localObject2 != null) {
          FragmentTransitionCompat21.setEpicenter(localObject2, paramSparseArray1);
        }
      }
    }
    FragmentTransitionCompat21.ViewRetriever local1 = new FragmentTransitionCompat21.ViewRetriever()
    {
      public final View getView()
      {
        return localObject5.getView();
      }
    };
    localObject6 = new ArrayList();
    ArrayMap localArrayMap = new ArrayMap();
    boolean bool = true;
    if (localObject5 != null)
    {
      if (paramBoolean) {
        bool = ((Fragment)localObject5).getAllowReturnTransitionOverlap();
      }
    }
    else
    {
      localObject3 = (Transition)localObject1;
      paramSparseArray1 = (Transition)localObject7;
      localObject5 = (Transition)localObject2;
      if ((localObject3 == null) || (paramSparseArray1 == null)) {
        break label956;
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject4 = new TransitionSet();
        if (localObject3 != null) {
          ((TransitionSet)localObject4).addTransition((Transition)localObject3);
        }
        if (paramSparseArray1 != null) {
          ((TransitionSet)localObject4).addTransition(paramSparseArray1);
        }
        paramSparseArray1 = (SparseArray<Fragment>)localObject4;
        if (localObject5 != null)
        {
          ((TransitionSet)localObject4).addTransition((Transition)localObject5);
          paramSparseArray1 = (SparseArray<Fragment>)localObject4;
        }
      }
      label951:
      for (;;)
      {
        if (paramSparseArray1 != null)
        {
          localObject3 = nonExistentView;
          localObject4 = enteringEpicenterView;
          localObject5 = nameOverrides;
          if ((localObject1 != null) || (localObject2 != null))
          {
            Transition localTransition = (Transition)localObject1;
            if (localTransition != null) {
              localTransition.addTarget((View)localObject3);
            }
            if (localObject2 != null) {
              FragmentTransitionCompat21.setSharedElementTargets(localObject2, (View)localObject3, paramSparseArray2, localArrayList1);
            }
            localViewGroup.getViewTreeObserver().addOnPreDrawListener(new FragmentTransitionCompat21.2(localViewGroup, localTransition, (View)localObject3, local1, (Map)localObject5, localArrayMap, (ArrayList)localObject6));
            if (localTransition != null) {
              localTransition.setEpicenterCallback(new FragmentTransitionCompat21.3((FragmentTransitionCompat21.EpicenterView)localObject4));
            }
          }
          localViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              localViewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
              BackStackRecord.this.excludeHiddenFragments(paramTransitionState, paramInt, paramSparseArray1);
              return true;
            }
          });
          FragmentTransitionCompat21.excludeTarget(paramSparseArray1, nonExistentView, true);
          excludeHiddenFragments(paramTransitionState, paramInt, paramSparseArray1);
          TransitionManager.beginDelayedTransition(localViewGroup, (Transition)paramSparseArray1);
          paramSparseArray2 = nonExistentView;
          paramTransitionState = hiddenFragmentViews;
          localObject1 = (Transition)localObject1;
          localObject3 = (Transition)localObject7;
          localObject2 = (Transition)localObject2;
          localObject4 = (Transition)paramSparseArray1;
          if (localObject4 != null) {
            localViewGroup.getViewTreeObserver().addOnPreDrawListener(new FragmentTransitionCompat21.4(localViewGroup, (Transition)localObject1, (ArrayList)localObject6, (Transition)localObject3, localArrayList2, (Transition)localObject2, localArrayList1, localArrayMap, paramTransitionState, (Transition)localObject4, paramSparseArray2));
          }
        }
        if (paramSparseArray1 == null) {
          break label954;
        }
        return true;
        bool = ((Fragment)localObject5).getAllowEnterTransitionOverlap();
        break;
        if ((paramSparseArray1 != null) && (localObject3 != null)) {
          paramSparseArray1 = new TransitionSet().addTransition(paramSparseArray1).addTransition((Transition)localObject3).setOrdering(1);
        }
        for (;;)
        {
          if (localObject5 == null) {
            break label951;
          }
          localObject3 = new TransitionSet();
          if (paramSparseArray1 != null) {
            ((TransitionSet)localObject3).addTransition(paramSparseArray1);
          }
          ((TransitionSet)localObject3).addTransition((Transition)localObject5);
          paramSparseArray1 = (SparseArray<Fragment>)localObject3;
          break;
          if (paramSparseArray1 == null)
          {
            paramSparseArray1 = (SparseArray<Fragment>)localObject3;
            if (localObject3 == null) {
              paramSparseArray1 = null;
            }
          }
        }
      }
      label954:
      return false;
      label956:
      bool = true;
    }
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    mFragmentManager = mManager;
    if (paramString != null)
    {
      if ((mTag != null) && (!paramString.equals(mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + mTag + " now " + paramString);
      }
      mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((mFragmentId != 0) && (mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + mFragmentId + " now " + paramInt1);
      }
      mFragmentId = paramInt1;
      mContainerId = paramInt1;
    }
    paramString = new Op();
    cmd = paramInt2;
    fragment = paramFragment;
    addOp(paramString);
  }
  
  private void excludeHiddenFragments(TransitionState paramTransitionState, int paramInt, Object paramObject)
  {
    if (mManager.mAdded != null)
    {
      int i = 0;
      if (i < mManager.mAdded.size())
      {
        Fragment localFragment = (Fragment)mManager.mAdded.get(i);
        if ((mView != null) && (mContainer != null) && (mContainerId == paramInt))
        {
          if (!mHidden) {
            break label125;
          }
          if (!hiddenFragmentViews.contains(mView))
          {
            FragmentTransitionCompat21.excludeTarget(paramObject, mView, true);
            hiddenFragmentViews.add(mView);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label125:
          FragmentTransitionCompat21.excludeTarget(paramObject, mView, false);
          hiddenFragmentViews.remove(mView);
        }
      }
    }
  }
  
  private static ArrayMap<String, View> remapNames(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayMap<String, View> paramArrayMap)
  {
    if (paramArrayMap.isEmpty()) {
      return paramArrayMap;
    }
    ArrayMap localArrayMap = new ArrayMap();
    int j = paramArrayList1.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayMap.get(paramArrayList1.get(i));
      if (localView != null) {
        localArrayMap.put(paramArrayList2.get(i), localView);
      }
      i += 1;
    }
    return localArrayMap;
  }
  
  private ArrayMap<String, View> remapSharedElements(TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (mSharedElementSourceNames != null)
    {
      FragmentTransitionCompat21.findNamedViews(localArrayMap2, paramFragment.getView());
      if (!paramBoolean) {
        break label74;
      }
      MapCollections.retainAllHelper(localArrayMap2, mSharedElementTargetNames);
    }
    label74:
    for (localArrayMap1 = localArrayMap2; paramBoolean; localArrayMap1 = remapNames(mSharedElementSourceNames, mSharedElementTargetNames, localArrayMap2))
    {
      if (mEnterTransitionCallback != null) {
        paramFragment = mEnterTransitionCallback;
      }
      setBackNameOverrides(paramTransitionState, localArrayMap1, false);
      return localArrayMap1;
    }
    if (mExitTransitionCallback != null) {
      paramFragment = mExitTransitionCallback;
    }
    setNameOverrides(paramTransitionState, localArrayMap1, false);
    return localArrayMap1;
  }
  
  private void setBackNameOverrides(TransitionState paramTransitionState, ArrayMap<String, View> paramArrayMap, boolean paramBoolean)
  {
    int i;
    int j;
    label13:
    String str;
    Object localObject;
    if (mSharedElementTargetNames == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      str = (String)mSharedElementSourceNames.get(j);
      localObject = (View)paramArrayMap.get((String)mSharedElementTargetNames.get(j));
      if (localObject != null)
      {
        localObject = ((View)localObject).getTransitionName();
        if (!paramBoolean) {
          break label103;
        }
        setNameOverride(nameOverrides, str, (String)localObject);
      }
    }
    for (;;)
    {
      j += 1;
      break label13;
      i = mSharedElementTargetNames.size();
      break;
      label103:
      setNameOverride(nameOverrides, (String)localObject, str);
    }
  }
  
  private static void setFirstOut(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = mContainerId;
      if ((i != 0) && (!paramFragment.isHidden()))
      {
        if ((paramFragment.isAdded()) && (paramFragment.getView() != null) && (paramSparseArray1.get(i) == null)) {
          paramSparseArray1.put(i, paramFragment);
        }
        if (paramSparseArray2.get(i) == paramFragment) {
          paramSparseArray2.remove(i);
        }
      }
    }
  }
  
  private void setLastIn(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = mContainerId;
      if (i != 0)
      {
        if (!paramFragment.isAdded()) {
          paramSparseArray2.put(i, paramFragment);
        }
        if (paramSparseArray1.get(i) == paramFragment) {
          paramSparseArray1.remove(i);
        }
      }
      if ((mState <= 0) && (mManager.mCurState > 0))
      {
        mManager.makeActive(paramFragment);
        mManager.moveToState(paramFragment, 1, 0, 0, false);
      }
    }
  }
  
  private static void setNameOverride(ArrayMap<String, String> paramArrayMap, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 != null) && (paramString2 != null)) {
      i = 0;
    }
    while (i < paramArrayMap.size())
    {
      if (paramString1.equals(paramArrayMap.valueAt(i)))
      {
        paramArrayMap.setValueAt(i, paramString2);
        return;
      }
      i += 1;
    }
    paramArrayMap.put(paramString1, paramString2);
  }
  
  private static void setNameOverrides(TransitionState paramTransitionState, ArrayMap<String, View> paramArrayMap, boolean paramBoolean)
  {
    int j = paramArrayMap.size();
    int i = 0;
    if (i < j)
    {
      String str1 = (String)paramArrayMap.keyAt(i);
      String str2 = ((View)paramArrayMap.valueAt(i)).getTransitionName();
      if (paramBoolean) {
        setNameOverride(nameOverrides, str1, str2);
      }
      for (;;)
      {
        i += 1;
        break;
        setNameOverride(nameOverrides, str2, str1);
      }
    }
  }
  
  private static void setNameOverrides(TransitionState paramTransitionState, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i = 0;
      while (i < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        setNameOverride(nameOverrides, str1, str2);
        i += 1;
      }
    }
  }
  
  public final FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public final FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public final FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  final void addOp(Op paramOp)
  {
    if (mHead == null)
    {
      mTail = paramOp;
      mHead = paramOp;
    }
    for (;;)
    {
      enterAnim = mEnterAnim;
      exitAnim = mExitAnim;
      popEnterAnim = mPopEnterAnim;
      popExitAnim = mPopExitAnim;
      mNumOp += 1;
      return;
      prev = mTail;
      mTail.next = paramOp;
      mTail = paramOp;
    }
  }
  
  public final FragmentTransaction addToBackStack(String paramString)
  {
    if (!mAllowAddToBackStack) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    mAddToBackStack = true;
    mName = paramString;
    return this;
  }
  
  public final FragmentTransaction attach(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 7;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  final void bumpBackStackNesting(int paramInt)
  {
    if (!mAddToBackStack) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      for (Op localOp = mHead; localOp != null; localOp = next)
      {
        Fragment localFragment;
        if (fragment != null)
        {
          localFragment = fragment;
          mBackStackNesting += paramInt;
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
          }
        }
        if (removed != null)
        {
          int i = removed.size() - 1;
          while (i >= 0)
          {
            localFragment = (Fragment)removed.get(i);
            mBackStackNesting += paramInt;
            if (FragmentManagerImpl.DEBUG) {
              Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + mBackStackNesting);
            }
            i -= 1;
          }
        }
      }
    }
  }
  
  public final void calculateBackFragments(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!mManager.mContainer.onHasView()) {}
    Op localOp;
    do
    {
      return;
      localOp = mTail;
    } while (localOp == null);
    switch (cmd)
    {
    }
    for (;;)
    {
      localOp = prev;
      break;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      if (removed != null)
      {
        int i = removed.size() - 1;
        while (i >= 0)
        {
          setLastIn(paramSparseArray1, paramSparseArray2, (Fragment)removed.get(i));
          i -= 1;
        }
      }
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
    }
  }
  
  public final int commit()
  {
    return commitInternal(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  public final FragmentTransaction detach(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 6;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public final FragmentTransaction disallowAddToBackStack()
  {
    if (mAddToBackStack) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    mAllowAddToBackStack = false;
    return this;
  }
  
  public final void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(mCommitted);
      if (mTransition != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(mTransition));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(mTransitionStyle));
      }
      if ((mEnterAnim != 0) || (mExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(mExitAnim));
      }
      if ((mPopEnterAnim != 0) || (mPopExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(mPopExitAnim));
      }
      if ((mBreadCrumbTitleRes != 0) || (mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(mBreadCrumbTitleText);
      }
      if ((mBreadCrumbShortTitleRes != 0) || (mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(mBreadCrumbShortTitleText);
      }
    }
    if (mHead != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      Op localOp = mHead;
      int i = 0;
      while (localOp != null)
      {
        String str1;
        int j;
        switch (cmd)
        {
        default: 
          str1 = "cmd=" + cmd;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(fragment);
          if (paramBoolean)
          {
            if ((enterAnim != 0) || (exitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(enterAnim));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(exitAnim));
            }
            if ((popEnterAnim != 0) || (popExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(popEnterAnim));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(popExitAnim));
            }
          }
          if ((removed == null) || (removed.size() <= 0)) {
            break label804;
          }
          j = 0;
          label638:
          if (j >= removed.size()) {
            break label804;
          }
          paramPrintWriter.print(str2);
          if (removed.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(removed.get(j));
          j += 1;
          break label638;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (j == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
        }
        label804:
        localOp = next;
        i += 1;
      }
    }
  }
  
  public final void dump$ec96877(String paramString, PrintWriter paramPrintWriter)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public final String getName()
  {
    return mName;
  }
  
  public final boolean isEmpty()
  {
    return mNumOp == 0;
  }
  
  public final TransitionState popFromBackStack(boolean paramBoolean, TransitionState paramTransitionState, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (FragmentManagerImpl.DEBUG)
    {
      Log.v("FragmentManager", "popFromBackStack: " + this);
      dump$ec96877("  ", new PrintWriter(new LogWriter("FragmentManager")));
    }
    TransitionState localTransitionState = paramTransitionState;
    if (SUPPORTS_TRANSITIONS)
    {
      localTransitionState = paramTransitionState;
      if (mManager.mCurState > 0)
      {
        if (paramTransitionState != null) {
          break label228;
        }
        if (paramSparseArray1.size() == 0)
        {
          localTransitionState = paramTransitionState;
          if (paramSparseArray2.size() == 0) {}
        }
        else
        {
          localTransitionState = beginTransition(paramSparseArray1, paramSparseArray2, true);
        }
      }
    }
    label108:
    bumpBackStackNesting(-1);
    int i;
    label121:
    int j;
    label129:
    int k;
    if (localTransitionState != null)
    {
      i = 0;
      if (localTransitionState == null) {
        break label262;
      }
      j = 0;
      paramTransitionState = mTail;
      if (paramTransitionState == null) {
        break label551;
      }
      if (localTransitionState == null) {
        break label271;
      }
      k = 0;
      label146:
      if (localTransitionState == null) {
        break label280;
      }
    }
    label228:
    label262:
    label271:
    label280:
    for (int m = 0;; m = popExitAnim) {
      switch (cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + cmd);
        localTransitionState = paramTransitionState;
        if (paramBoolean) {
          break label108;
        }
        setNameOverrides(paramTransitionState, mSharedElementTargetNames, mSharedElementSourceNames);
        localTransitionState = paramTransitionState;
        break label108;
        i = mTransitionStyle;
        break label121;
        j = mTransition;
        break label129;
        k = popEnterAnim;
        break label146;
      }
    }
    paramSparseArray1 = fragment;
    mNextAnim = m;
    mManager.removeFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
    for (;;)
    {
      paramTransitionState = prev;
      break;
      paramSparseArray1 = fragment;
      if (paramSparseArray1 != null)
      {
        mNextAnim = m;
        mManager.removeFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
      }
      if (removed != null)
      {
        m = 0;
        while (m < removed.size())
        {
          paramSparseArray1 = (Fragment)removed.get(m);
          mNextAnim = k;
          mManager.addFragment(paramSparseArray1, false);
          m += 1;
        }
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.addFragment(paramSparseArray1, false);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.showFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = m;
        mManager.hideFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.attachFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.detachFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
      }
    }
    label551:
    if (paramBoolean)
    {
      mManager.moveToState(mManager.mCurState, FragmentManagerImpl.reverseTransit(j), i, true);
      localTransitionState = null;
    }
    if (mIndex >= 0)
    {
      paramTransitionState = mManager;
      i = mIndex;
    }
    try
    {
      mBackStackIndices.set(i, null);
      if (mAvailBackStackIndices == null) {
        mAvailBackStackIndices = new ArrayList();
      }
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Freeing back stack index " + i);
      }
      mAvailBackStackIndices.add(Integer.valueOf(i));
      mIndex = -1;
      return localTransitionState;
    }
    finally {}
  }
  
  public final FragmentTransaction remove(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 3;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public final FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public final FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public final void run()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Run: " + this);
    }
    if ((mAddToBackStack) && (mIndex < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    bumpBackStackNesting(1);
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (SUPPORTS_TRANSITIONS)
    {
      localObject2 = localObject1;
      if (mManager.mCurState > 0)
      {
        localObject1 = new SparseArray();
        localObject2 = new SparseArray();
        calculateFragments((SparseArray)localObject1, (SparseArray)localObject2);
        localObject2 = beginTransition((SparseArray)localObject1, (SparseArray)localObject2, false);
      }
    }
    int i;
    label131:
    int j;
    label138:
    Op localOp;
    int k;
    if (localObject2 != null)
    {
      i = 0;
      if (localObject2 == null) {
        break label249;
      }
      j = 0;
      localOp = mHead;
      if (localOp == null) {
        break label744;
      }
      if (localObject2 == null) {
        break label257;
      }
      k = 0;
      label156:
      if (localObject2 == null) {
        break label266;
      }
    }
    label249:
    label257:
    label266:
    for (int m = 0;; m = exitAnim) {
      switch (cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + cmd);
        i = mTransitionStyle;
        break label131;
        j = mTransition;
        break label138;
        k = enterAnim;
        break label156;
      }
    }
    localObject1 = fragment;
    mNextAnim = k;
    mManager.addFragment((Fragment)localObject1, false);
    for (;;)
    {
      localOp = next;
      break;
      localObject1 = fragment;
      int i1 = mContainerId;
      Object localObject3 = localObject1;
      if (mManager.mAdded != null)
      {
        int n = mManager.mAdded.size() - 1;
        localObject3 = localObject1;
        if (n >= 0)
        {
          Fragment localFragment = (Fragment)mManager.mAdded.get(n);
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localFragment);
          }
          localObject3 = localObject1;
          if (mContainerId == i1)
          {
            if (localFragment != localObject1) {
              break label462;
            }
            localObject3 = null;
            fragment = null;
          }
          for (;;)
          {
            n -= 1;
            localObject1 = localObject3;
            break;
            label462:
            if (removed == null) {
              removed = new ArrayList();
            }
            removed.add(localFragment);
            mNextAnim = m;
            if (mAddToBackStack)
            {
              mBackStackNesting += 1;
              if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + mBackStackNesting);
              }
            }
            mManager.removeFragment(localFragment, j, i);
            localObject3 = localObject1;
          }
        }
      }
      if (localObject3 != null)
      {
        mNextAnim = k;
        mManager.addFragment((Fragment)localObject3, false);
        continue;
        localObject1 = fragment;
        mNextAnim = m;
        mManager.removeFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = m;
        mManager.hideFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = k;
        mManager.showFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = m;
        mManager.detachFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = k;
        mManager.attachFragment((Fragment)localObject1, j, i);
      }
    }
    label744:
    mManager.moveToState(mManager.mCurState, j, i, true);
    if (mAddToBackStack)
    {
      localObject1 = mManager;
      if (mBackStack == null) {
        mBackStack = new ArrayList();
      }
      mBackStack.add(this);
      ((FragmentManagerImpl)localObject1).reportBackStackChanged();
    }
  }
  
  public final FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mEnterAnim = paramInt1;
    mExitAnim = paramInt2;
    mPopEnterAnim = paramInt3;
    mPopExitAnim = paramInt4;
    return this;
  }
  
  public final FragmentTransaction setCustomAnimations$228f0801()
  {
    return setCustomAnimations(2131034153, 2131034154, 0, 0);
  }
  
  public final FragmentTransaction setTransition$9d93138()
  {
    mTransition = 4097;
    return this;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(mIndex);
    }
    if (mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Op
  {
    int cmd;
    int enterAnim;
    int exitAnim;
    Fragment fragment;
    Op next;
    int popEnterAnim;
    int popExitAnim;
    Op prev;
    ArrayList<Fragment> removed;
  }
  
  public final class TransitionState
  {
    public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
    public ArrayList<View> hiddenFragmentViews = new ArrayList();
    public ArrayMap<String, String> nameOverrides = new ArrayMap();
    public View nonExistentView;
    
    public TransitionState() {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */