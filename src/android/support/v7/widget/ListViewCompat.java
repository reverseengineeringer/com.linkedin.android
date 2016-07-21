package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat
  extends ListView
{
  private static final int[] STATE_SET_NOTHING = { 0 };
  Field mIsChildViewEnabled;
  protected int mMotionPosition;
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  private GateKeeperDrawable mSelector;
  final Rect mSelectorRect = new Rect();
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      mIsChildViewEnabled.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!mSelectorRect.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(mSelectorRect);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    int i = 1;
    super.drawableStateChanged();
    setSelectorEnabled(true);
    Drawable localDrawable = getSelector();
    if (localDrawable != null) {
      if ((!touchModeDrawsInPressedStateCompat()) || (!isPressed())) {
        break label48;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localDrawable.setState(getDrawableState());
      }
      return;
      label48:
      i = 0;
    }
  }
  
  public final int measureHeightOfChildrenCompat$2e71581f$4868d301(int paramInt1, int paramInt2)
  {
    int i = getListPaddingTop();
    int k = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int j = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      i += k;
      return i;
    }
    i += k;
    label66:
    label84:
    int m;
    View localView;
    if ((j > 0) && (localObject != null))
    {
      localObject = null;
      n = 0;
      int i2 = localListAdapter.getCount();
      k = 0;
      if (k >= i2) {
        return i;
      }
      int i1 = localListAdapter.getItemViewType(k);
      m = n;
      if (i1 != n)
      {
        localObject = null;
        m = i1;
      }
      localView = localListAdapter.getView(k, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (height <= 0) {
        break label254;
      }
    }
    label254:
    for (int n = View.MeasureSpec.makeMeasureSpec(height, 1073741824);; n = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      localView.measure(paramInt1, n);
      localView.forceLayout();
      n = i;
      if (k > 0) {
        n = i + j;
      }
      n += localView.getMeasuredHeight();
      i = paramInt2;
      if (n >= paramInt2) {
        break;
      }
      k += 1;
      localObject = localView;
      i = n;
      n = m;
      break label84;
      j = 0;
      break label66;
    }
    return i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      mMotionPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (Object localObject = new GateKeeperDrawable(paramDrawable);; localObject = null)
    {
      mSelector = ((GateKeeperDrawable)localObject);
      super.setSelector(mSelector);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      mSelectionLeftPadding = left;
      mSelectionTopPadding = top;
      mSelectionRightPadding = right;
      mSelectionBottomPadding = bottom;
      return;
    }
  }
  
  protected void setSelectorEnabled(boolean paramBoolean)
  {
    if (mSelector != null) {
      mSelector.mEnabled = paramBoolean;
    }
  }
  
  protected boolean touchModeDrawsInPressedStateCompat()
  {
    return false;
  }
  
  private static final class GateKeeperDrawable
    extends DrawableWrapper
  {
    boolean mEnabled = true;
    
    public GateKeeperDrawable(Drawable paramDrawable)
    {
      super();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (mEnabled) {
        super.draw(paramCanvas);
      }
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (mEnabled) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (mEnabled) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      if (mEnabled) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (mEnabled) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ListViewCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */