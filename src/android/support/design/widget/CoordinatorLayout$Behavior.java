package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public abstract class CoordinatorLayout$Behavior<V extends View>
{
  public CoordinatorLayout$Behavior() {}
  
  public CoordinatorLayout$Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public static Object getTag(View paramView)
  {
    return getLayoutParamsmBehaviorTag;
  }
  
  public static void setTag(View paramView, Object paramObject)
  {
    getLayoutParamsmBehaviorTag = paramObject;
  }
  
  public boolean blocksInteractionBelow(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return getScrimOpacity(paramCoordinatorLayout, paramV) > 0.0F;
  }
  
  public int getScrimColor(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return -16777216;
  }
  
  public float getScrimOpacity(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return 0.0F;
  }
  
  public boolean isDirty(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return false;
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    return false;
  }
  
  public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout paramCoordinatorLayout, V paramV, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    return false;
  }
  
  public void onDependentViewRemoved(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return false;
  }
  
  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean onNestedFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onNestedScrollAccepted(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt) {}
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return View.BaseSavedState.EMPTY_STATE;
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
  {
    return false;
  }
  
  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */