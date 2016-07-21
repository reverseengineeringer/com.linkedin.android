package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout$Behavior
  extends HeaderBehavior<AppBarLayout>
{
  private static final int ANIMATE_OFFSET_DIPS_PER_SECOND = 300;
  private static final int INVALID_POSITION = -1;
  private ValueAnimatorCompat mAnimator;
  private WeakReference<View> mLastNestedScrollingChildRef;
  private int mOffsetDelta;
  private int mOffsetToChildIndexOnLayout = -1;
  private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
  private float mOffsetToChildIndexOnLayoutPerc;
  private DragCallback mOnDragCallback;
  private boolean mSkipNestedPreScroll;
  private boolean mWasNestedFlung;
  
  public AppBarLayout$Behavior() {}
  
  public AppBarLayout$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void animateOffsetTo(final CoordinatorLayout paramCoordinatorLayout, final AppBarLayout paramAppBarLayout, int paramInt)
  {
    int i = getTopBottomOffsetForScrollingSibling();
    if (i == paramInt)
    {
      if ((mAnimator != null) && (mAnimator.isRunning())) {
        mAnimator.cancel();
      }
      return;
    }
    if (mAnimator == null)
    {
      mAnimator = ViewUtils.createAnimator();
      mAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
      mAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
        {
          setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, paramAnonymousValueAnimatorCompat.getAnimatedIntValue());
        }
      });
    }
    for (;;)
    {
      float f = Math.abs(i - paramInt) / getResourcesgetDisplayMetricsdensity;
      mAnimator.setDuration(Math.round(1000.0F * f / 300.0F));
      mAnimator.setIntValues(i, paramInt);
      mAnimator.start();
      return;
      mAnimator.cancel();
    }
  }
  
  private static boolean checkFlag(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void dispatchOffsetUpdates(AppBarLayout paramAppBarLayout)
  {
    List localList = AppBarLayout.access$900(paramAppBarLayout);
    int i = 0;
    int j = localList.size();
    while (i < j)
    {
      AppBarLayout.OnOffsetChangedListener localOnOffsetChangedListener = (AppBarLayout.OnOffsetChangedListener)localList.get(i);
      if (localOnOffsetChangedListener != null) {
        localOnOffsetChangedListener.onOffsetChanged(paramAppBarLayout, getTopAndBottomOffset());
      }
      i += 1;
    }
  }
  
  private int getChildIndexOnOffset(AppBarLayout paramAppBarLayout, int paramInt)
  {
    int i = 0;
    int j = paramAppBarLayout.getChildCount();
    while (i < j)
    {
      View localView = paramAppBarLayout.getChildAt(i);
      if ((localView.getTop() <= -paramInt) && (localView.getBottom() >= -paramInt)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int interpolateOffset(AppBarLayout paramAppBarLayout, int paramInt)
  {
    int k = Math.abs(paramInt);
    int j = 0;
    int m = paramAppBarLayout.getChildCount();
    for (;;)
    {
      int i = paramInt;
      if (j < m)
      {
        View localView = paramAppBarLayout.getChildAt(j);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        Interpolator localInterpolator = localLayoutParams.getScrollInterpolator();
        if ((k < localView.getTop()) || (k > localView.getBottom())) {
          break label203;
        }
        i = paramInt;
        if (localInterpolator != null)
        {
          i = 0;
          m = localLayoutParams.getScrollFlags();
          if ((m & 0x1) != 0)
          {
            j = localView.getHeight() + topMargin + bottomMargin + 0;
            i = j;
            if ((m & 0x2) != 0) {
              i = j - ViewCompat.getMinimumHeight(localView);
            }
          }
          j = i;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            j = i - AppBarLayout.access$500(paramAppBarLayout);
          }
          i = paramInt;
          if (j > 0)
          {
            i = localView.getTop();
            i = Math.round(j * localInterpolator.getInterpolation((k - i) / j));
            i = Integer.signum(paramInt) * (localView.getTop() + i);
          }
        }
      }
      return i;
      label203:
      j += 1;
    }
  }
  
  private void snapToChildIfNeeded(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    int n = getTopBottomOffsetForScrollingSibling();
    int k = getChildIndexOnOffset(paramAppBarLayout, n);
    View localView;
    int i1;
    int m;
    int i;
    int j;
    if (k >= 0)
    {
      localView = paramAppBarLayout.getChildAt(k);
      i1 = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).getScrollFlags();
      if ((i1 & 0x11) == 17)
      {
        m = -localView.getTop();
        i = -localView.getBottom();
        j = i;
        if (k == paramAppBarLayout.getChildCount() - 1) {
          j = i + AppBarLayout.access$500(paramAppBarLayout);
        }
        if (!checkFlag(i1, 2)) {
          break label138;
        }
        i = j + ViewCompat.getMinimumHeight(localView);
        k = m;
        if (n >= (i + k) / 2) {
          break label185;
        }
      }
    }
    for (;;)
    {
      animateOffsetTo(paramCoordinatorLayout, paramAppBarLayout, MathUtils.constrain(i, -paramAppBarLayout.getTotalScrollRange(), 0));
      return;
      label138:
      i = j;
      k = m;
      if (!checkFlag(i1, 5)) {
        break;
      }
      i = j + ViewCompat.getMinimumHeight(localView);
      if (n < i)
      {
        k = i;
        i = j;
        break;
      }
      k = m;
      break;
      label185:
      i = k;
    }
  }
  
  boolean canDragView(AppBarLayout paramAppBarLayout)
  {
    boolean bool2 = true;
    boolean bool1;
    if (mOnDragCallback != null) {
      bool1 = mOnDragCallback.canDrag(paramAppBarLayout);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (mLastNestedScrollingChildRef == null);
      paramAppBarLayout = (View)mLastNestedScrollingChildRef.get();
      if ((paramAppBarLayout == null) || (!paramAppBarLayout.isShown())) {
        break;
      }
      bool1 = bool2;
    } while (!ViewCompat.canScrollVertically(paramAppBarLayout, -1));
    return false;
  }
  
  int getMaxDragOffset(AppBarLayout paramAppBarLayout)
  {
    return -AppBarLayout.access$400(paramAppBarLayout);
  }
  
  int getScrollRangeForDragFling(AppBarLayout paramAppBarLayout)
  {
    return paramAppBarLayout.getTotalScrollRange();
  }
  
  int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset() + mOffsetDelta;
  }
  
  void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    snapToChildIfNeeded(paramCoordinatorLayout, paramAppBarLayout);
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    int i = AppBarLayout.access$600(paramAppBarLayout);
    if (i != 0) {
      if ((i & 0x4) != 0)
      {
        paramInt = 1;
        if ((i & 0x2) == 0) {
          break label107;
        }
        i = -AppBarLayout.access$300(paramAppBarLayout);
        if (paramInt == 0) {
          break label95;
        }
        animateOffsetTo(paramCoordinatorLayout, paramAppBarLayout, i);
      }
    }
    label95:
    label107:
    while (mOffsetToChildIndexOnLayout < 0) {
      for (;;)
      {
        AppBarLayout.access$700(paramAppBarLayout);
        mOffsetToChildIndexOnLayout = -1;
        setTopAndBottomOffset(MathUtils.constrain(getTopAndBottomOffset(), -paramAppBarLayout.getTotalScrollRange(), 0));
        dispatchOffsetUpdates(paramAppBarLayout);
        return bool;
        paramInt = 0;
        continue;
        setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, i);
        continue;
        if ((i & 0x1) != 0) {
          if (paramInt != 0) {
            animateOffsetTo(paramCoordinatorLayout, paramAppBarLayout, 0);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, 0);
          }
        }
      }
    }
    paramCoordinatorLayout = paramAppBarLayout.getChildAt(mOffsetToChildIndexOnLayout);
    paramInt = -paramCoordinatorLayout.getBottom();
    if (mOffsetToChildIndexOnLayoutIsMinHeight) {
      paramInt += ViewCompat.getMinimumHeight(paramCoordinatorLayout);
    }
    for (;;)
    {
      setTopAndBottomOffset(paramInt);
      break;
      paramInt += Math.round(paramCoordinatorLayout.getHeight() * mOffsetToChildIndexOnLayoutPerc);
    }
  }
  
  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getLayoutParamsheight == -2)
    {
      paramCoordinatorLayout.onMeasureChild(paramAppBarLayout, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
      return true;
    }
    return super.onMeasureChild(paramCoordinatorLayout, paramAppBarLayout, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool = false;
    if (!paramBoolean) {
      paramBoolean = fling(paramCoordinatorLayout, paramAppBarLayout, -paramAppBarLayout.getTotalScrollRange(), 0, -paramFloat2);
    }
    for (;;)
    {
      mWasNestedFlung = paramBoolean;
      return paramBoolean;
      int i;
      if (paramFloat2 < 0.0F)
      {
        i = -paramAppBarLayout.getTotalScrollRange() + AppBarLayout.access$200(paramAppBarLayout);
        paramBoolean = bool;
        if (getTopBottomOffsetForScrollingSibling() < i)
        {
          animateOffsetTo(paramCoordinatorLayout, paramAppBarLayout, i);
          paramBoolean = true;
        }
      }
      else
      {
        i = -AppBarLayout.access$300(paramAppBarLayout);
        paramBoolean = bool;
        if (getTopBottomOffsetForScrollingSibling() > i)
        {
          animateOffsetTo(paramCoordinatorLayout, paramAppBarLayout, i);
          paramBoolean = true;
        }
      }
    }
  }
  
  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 != 0) && (!mSkipNestedPreScroll))
    {
      if (paramInt2 >= 0) {
        break label50;
      }
      paramInt1 = -paramAppBarLayout.getTotalScrollRange();
    }
    for (int i = paramInt1 + AppBarLayout.access$200(paramAppBarLayout);; i = 0)
    {
      paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramAppBarLayout, paramInt2, paramInt1, i);
      return;
      label50:
      paramInt1 = -AppBarLayout.access$300(paramAppBarLayout);
    }
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 < 0)
    {
      scroll(paramCoordinatorLayout, paramAppBarLayout, paramInt4, -AppBarLayout.access$400(paramAppBarLayout), 0);
      mSkipNestedPreScroll = true;
      return;
    }
    mSkipNestedPreScroll = false;
  }
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramCoordinatorLayout, paramAppBarLayout, paramParcelable.getSuperState());
      mOffsetToChildIndexOnLayout = firstVisibleChildIndex;
      mOffsetToChildIndexOnLayoutPerc = firstVisibileChildPercentageShown;
      mOffsetToChildIndexOnLayoutIsMinHeight = firstVisibileChildAtMinimumHeight;
      return;
    }
    super.onRestoreInstanceState(paramCoordinatorLayout, paramAppBarLayout, paramParcelable);
    mOffsetToChildIndexOnLayout = -1;
  }
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    Parcelable localParcelable = super.onSaveInstanceState(paramCoordinatorLayout, paramAppBarLayout);
    int j = getTopAndBottomOffset();
    int i = 0;
    int k = paramAppBarLayout.getChildCount();
    while (i < k)
    {
      paramCoordinatorLayout = paramAppBarLayout.getChildAt(i);
      int m = paramCoordinatorLayout.getBottom() + j;
      if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
      {
        paramAppBarLayout = new SavedState(localParcelable);
        firstVisibleChildIndex = i;
        if (m == ViewCompat.getMinimumHeight(paramCoordinatorLayout)) {}
        for (boolean bool = true;; bool = false)
        {
          firstVisibileChildAtMinimumHeight = bool;
          firstVisibileChildPercentageShown = (m / paramCoordinatorLayout.getHeight());
          return paramAppBarLayout;
        }
      }
      i += 1;
    }
    return localParcelable;
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (AppBarLayout.access$100(paramAppBarLayout)) && (paramCoordinatorLayout.getHeight() - paramView1.getHeight() <= paramAppBarLayout.getHeight())) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (mAnimator != null)) {
        mAnimator.cancel();
      }
      mLastNestedScrollingChildRef = null;
      return bool;
    }
  }
  
  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView)
  {
    if (!mWasNestedFlung) {
      snapToChildIfNeeded(paramCoordinatorLayout, paramAppBarLayout);
    }
    mSkipNestedPreScroll = false;
    mWasNestedFlung = false;
    mLastNestedScrollingChildRef = new WeakReference(paramView);
  }
  
  public void setDragCallback(DragCallback paramDragCallback)
  {
    mOnDragCallback = paramDragCallback;
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getTopBottomOffsetForScrollingSibling();
    int i = 0;
    if ((paramInt2 != 0) && (j >= paramInt2) && (j <= paramInt3))
    {
      paramInt2 = MathUtils.constrain(paramInt1, paramInt2, paramInt3);
      paramInt1 = i;
      if (j != paramInt2) {
        if (!AppBarLayout.access$800(paramAppBarLayout)) {
          break label112;
        }
      }
      label112:
      for (paramInt1 = interpolateOffset(paramAppBarLayout, paramInt2);; paramInt1 = paramInt2)
      {
        boolean bool = setTopAndBottomOffset(paramInt1);
        paramInt3 = j - paramInt2;
        mOffsetDelta = (paramInt2 - paramInt1);
        if ((!bool) && (AppBarLayout.access$800(paramAppBarLayout))) {
          paramCoordinatorLayout.dispatchDependentViewsChanged(paramAppBarLayout);
        }
        dispatchOffsetUpdates(paramAppBarLayout);
        paramInt1 = paramInt3;
        return paramInt1;
      }
    }
    mOffsetDelta = 0;
    return 0;
  }
  
  public static abstract class DragCallback
  {
    public abstract boolean canDrag(AppBarLayout paramAppBarLayout);
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public final AppBarLayout.Behavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new AppBarLayout.Behavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public final AppBarLayout.Behavior.SavedState[] newArray(int paramAnonymousInt)
      {
        return new AppBarLayout.Behavior.SavedState[paramAnonymousInt];
      }
    });
    boolean firstVisibileChildAtMinimumHeight;
    float firstVisibileChildPercentageShown;
    int firstVisibleChildIndex;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      firstVisibleChildIndex = paramParcel.readInt();
      firstVisibileChildPercentageShown = paramParcel.readFloat();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        firstVisibileChildAtMinimumHeight = bool;
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(firstVisibleChildIndex);
      paramParcel.writeFloat(firstVisibileChildPercentageShown);
      if (firstVisibileChildAtMinimumHeight) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */