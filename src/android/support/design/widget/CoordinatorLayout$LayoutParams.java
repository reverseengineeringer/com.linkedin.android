package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;

public class CoordinatorLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int anchorGravity = 0;
  public int gravity = 0;
  public int keyline = -1;
  View mAnchorDirectChild;
  int mAnchorId = -1;
  View mAnchorView;
  CoordinatorLayout.Behavior mBehavior;
  boolean mBehaviorResolved = false;
  Object mBehaviorTag;
  private boolean mDidAcceptNestedScroll;
  private boolean mDidBlockInteraction;
  private boolean mDidChangeAfterNestedScroll;
  final Rect mLastChildRect = new Rect();
  
  public CoordinatorLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  CoordinatorLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_LayoutParams);
    gravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
    mAnchorId = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_LayoutParams_layout_anchor, -1);
    anchorGravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
    keyline = localTypedArray.getInteger(R.styleable.CoordinatorLayout_LayoutParams_layout_keyline, -1);
    mBehaviorResolved = localTypedArray.hasValue(R.styleable.CoordinatorLayout_LayoutParams_layout_behavior);
    if (mBehaviorResolved) {
      mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, localTypedArray.getString(R.styleable.CoordinatorLayout_LayoutParams_layout_behavior));
    }
    localTypedArray.recycle();
  }
  
  public CoordinatorLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
  {
    mAnchorView = paramCoordinatorLayout.findViewById(mAnchorId);
    if (mAnchorView != null)
    {
      if (mAnchorView == paramCoordinatorLayout)
      {
        if (paramCoordinatorLayout.isInEditMode())
        {
          mAnchorDirectChild = null;
          mAnchorView = null;
          return;
        }
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
      }
      View localView = mAnchorView;
      for (ViewParent localViewParent = mAnchorView.getParent(); (localViewParent != paramCoordinatorLayout) && (localViewParent != null); localViewParent = localViewParent.getParent())
      {
        if (localViewParent == paramView)
        {
          if (paramCoordinatorLayout.isInEditMode())
          {
            mAnchorDirectChild = null;
            mAnchorView = null;
            return;
          }
          throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
      }
      mAnchorDirectChild = localView;
      return;
    }
    if (paramCoordinatorLayout.isInEditMode())
    {
      mAnchorDirectChild = null;
      mAnchorView = null;
      return;
    }
    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + paramCoordinatorLayout.getResources().getResourceName(mAnchorId) + " to anchor view " + paramView);
  }
  
  private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
  {
    if (mAnchorView.getId() != mAnchorId) {
      return false;
    }
    View localView = mAnchorView;
    for (ViewParent localViewParent = mAnchorView.getParent(); localViewParent != paramCoordinatorLayout; localViewParent = localViewParent.getParent())
    {
      if ((localViewParent == null) || (localViewParent == paramView))
      {
        mAnchorDirectChild = null;
        mAnchorView = null;
        return false;
      }
      if ((localViewParent instanceof View)) {
        localView = (View)localViewParent;
      }
    }
    mAnchorDirectChild = localView;
    return true;
  }
  
  void acceptNestedScroll(boolean paramBoolean)
  {
    mDidAcceptNestedScroll = paramBoolean;
  }
  
  boolean checkAnchorChanged()
  {
    return (mAnchorView == null) && (mAnchorId != -1);
  }
  
  boolean dependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return (paramView2 == mAnchorDirectChild) || ((mBehavior != null) && (mBehavior.layoutDependsOn(paramCoordinatorLayout, paramView1, paramView2)));
  }
  
  boolean didBlockInteraction()
  {
    if (mBehavior == null) {
      mDidBlockInteraction = false;
    }
    return mDidBlockInteraction;
  }
  
  View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    if (mAnchorId == -1)
    {
      mAnchorDirectChild = null;
      mAnchorView = null;
      return null;
    }
    if ((mAnchorView == null) || (!verifyAnchorView(paramView, paramCoordinatorLayout))) {
      resolveAnchorView(paramView, paramCoordinatorLayout);
    }
    return mAnchorView;
  }
  
  public int getAnchorId()
  {
    return mAnchorId;
  }
  
  public CoordinatorLayout.Behavior getBehavior()
  {
    return mBehavior;
  }
  
  boolean getChangedAfterNestedScroll()
  {
    return mDidChangeAfterNestedScroll;
  }
  
  Rect getLastChildRect()
  {
    return mLastChildRect;
  }
  
  void invalidateAnchor()
  {
    mAnchorDirectChild = null;
    mAnchorView = null;
  }
  
  boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    if (mDidBlockInteraction) {
      return true;
    }
    boolean bool2 = mDidBlockInteraction;
    if (mBehavior != null) {}
    for (boolean bool1 = mBehavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);; bool1 = false)
    {
      bool1 |= bool2;
      mDidBlockInteraction = bool1;
      return bool1;
    }
  }
  
  boolean isDirty(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return (mBehavior != null) && (mBehavior.isDirty(paramCoordinatorLayout, paramView));
  }
  
  boolean isNestedScrollAccepted()
  {
    return mDidAcceptNestedScroll;
  }
  
  void resetChangedAfterNestedScroll()
  {
    mDidChangeAfterNestedScroll = false;
  }
  
  void resetNestedScroll()
  {
    mDidAcceptNestedScroll = false;
  }
  
  void resetTouchBehaviorTracking()
  {
    mDidBlockInteraction = false;
  }
  
  public void setAnchorId(int paramInt)
  {
    invalidateAnchor();
    mAnchorId = paramInt;
  }
  
  public void setBehavior(CoordinatorLayout.Behavior paramBehavior)
  {
    if (mBehavior != paramBehavior)
    {
      mBehavior = paramBehavior;
      mBehaviorTag = null;
      mBehaviorResolved = true;
    }
  }
  
  void setChangedAfterNestedScroll(boolean paramBoolean)
  {
    mDidChangeAfterNestedScroll = paramBoolean;
  }
  
  void setLastChildRect(Rect paramRect)
  {
    mLastChildRect.set(paramRect);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */