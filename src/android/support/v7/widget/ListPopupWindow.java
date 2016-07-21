package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ListPopupWindow
{
  private static Method sClipToWindowEnabledMethod;
  private static Method sGetMaxAvailableHeightMethod;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  public View mDropDownAnchorView;
  public int mDropDownGravity = 0;
  private int mDropDownHeight = -2;
  int mDropDownHorizontalOffset;
  public DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  int mDropDownVerticalOffset;
  boolean mDropDownVerticalOffsetSet;
  int mDropDownWidth = -2;
  private int mDropDownWindowLayoutType = 1002;
  private boolean mForceIgnoreOutsideTouch = false;
  private final Handler mHandler;
  private final ListSelectorHider mHideSelector = new ListSelectorHider((byte)0);
  public AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  private boolean mModal;
  private DataSetObserver mObserver;
  public PopupWindow mPopup;
  int mPromptPosition = 0;
  private View mPromptView;
  private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable((byte)0);
  private final PopupScrollListener mScrollListener = new PopupScrollListener((byte)0);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor((byte)0);
  
  static
  {
    try
    {
      sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    mContext = paramContext;
    mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    mDropDownHorizontalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    mDropDownVerticalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (mDropDownVerticalOffset != 0) {
      mDropDownVerticalOffsetSet = true;
    }
    localTypedArray.recycle();
    mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1);
    mPopup.setInputMethodMode(1);
    mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(mContext.getResources().getConfiguration().locale);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (sGetMaxAvailableHeightMethod != null) {
      try
      {
        int i = ((Integer)sGetMaxAvailableHeightMethod.invoke(mPopup, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException)
      {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }
    }
    return mPopup.getMaxAvailableHeight(paramView, paramInt);
  }
  
  public final void clearListSelection()
  {
    DropDownListView localDropDownListView = mDropDownList;
    if (localDropDownListView != null)
    {
      DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    mPopup.dismiss();
    if (mPromptView != null)
    {
      ViewParent localViewParent = mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(mPromptView);
      }
    }
    mPopup.setContentView(null);
    mDropDownList = null;
    mHandler.removeCallbacks(mResizePopupRunnable);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return mPopup.getInputMethodMode() == 2;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (mObserver == null) {
      mObserver = new PopupDataSetObserver((byte)0);
    }
    for (;;)
    {
      mAdapter = paramListAdapter;
      if (mAdapter != null) {
        paramListAdapter.registerDataSetObserver(mObserver);
      }
      if (mDropDownList != null) {
        mDropDownList.setAdapter(mAdapter);
      }
      return;
      if (mAdapter != null) {
        mAdapter.unregisterDataSetObserver(mObserver);
      }
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(mTempRect);
      mDropDownWidth = (mTempRect.left + mTempRect.right + paramInt);
      return;
    }
    mDropDownWidth = paramInt;
  }
  
  public final void setInputMethodMode$13462e()
  {
    mPopup.setInputMethodMode(2);
  }
  
  public final void setModal$1385ff()
  {
    mModal = true;
    mPopup.setFocusable(true);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label254:
    int j;
    int i;
    if (mDropDownList == null)
    {
      localObject2 = mContext;
      mShowDropDownRunnable = new Runnable()
      {
        public final void run()
        {
          View localView = mDropDownAnchorView;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            show();
          }
        }
      };
      if (!mModal)
      {
        bool1 = true;
        mDropDownList = new DropDownListView((Context)localObject2, bool1);
        if (mDropDownListHighlight != null) {
          mDropDownList.setSelector(mDropDownListHighlight);
        }
        mDropDownList.setAdapter(mAdapter);
        mDropDownList.setOnItemClickListener(mItemClickListener);
        mDropDownList.setFocusable(true);
        mDropDownList.setFocusableInTouchMode(true);
        mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = mDropDownList;
              if (paramAnonymousAdapterView != null) {
                ListPopupWindow.DropDownListView.access$502(paramAnonymousAdapterView, false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        mDropDownList.setOnScrollListener(mScrollListener);
        if (mItemSelectedListener != null) {
          mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
        }
        localObject1 = mDropDownList;
        localView = mPromptView;
        if (localView == null) {
          break label1233;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (mPromptPosition)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + mPromptPosition);
          if (mDropDownWidth >= 0)
          {
            j = mDropDownWidth;
            i = Integer.MIN_VALUE;
            label270:
            localView.measure(View.MeasureSpec.makeMeasureSpec(j, i), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i = localView.getMeasuredHeight();
            j = topMargin;
            i = bottomMargin + (i + j);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      mPopup.setContentView((View)localObject1);
      for (;;)
      {
        label326:
        localObject1 = mPopup.getBackground();
        int k;
        label389:
        label403:
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(mTempRect);
          j = mTempRect.top + mTempRect.bottom;
          k = j;
          if (!mDropDownVerticalOffsetSet)
          {
            mDropDownVerticalOffset = (-mTempRect.top);
            k = j;
          }
          if (mPopup.getInputMethodMode() != 2) {
            break label720;
          }
          bool1 = true;
          m = getMaxAvailableHeight(mDropDownAnchorView, mDropDownVerticalOffset, bool1);
          if ((!mDropDownAlwaysVisible) && (mDropDownHeight != -1)) {
            break label726;
          }
          i = m + k;
          bool1 = isInputMethodNotNeeded();
          PopupWindowCompat.setWindowLayoutType(mPopup, mDropDownWindowLayoutType);
          if (!mPopup.isShowing()) {
            break label982;
          }
          if (mDropDownWidth != -1) {
            break label874;
          }
          j = -1;
          label476:
          if (mDropDownHeight != -1) {
            break label950;
          }
          if (!bool1) {
            break label902;
          }
          label489:
          if (!bool1) {
            break label912;
          }
          localObject1 = mPopup;
          if (mDropDownWidth != -1) {
            break label907;
          }
          k = -1;
          label510:
          ((PopupWindow)localObject1).setWidth(k);
          mPopup.setHeight(0);
          label524:
          localObject1 = mPopup;
          if ((mForceIgnoreOutsideTouch) || (mDropDownAlwaysVisible)) {
            break label970;
          }
          bool1 = bool2;
          label548:
          ((PopupWindow)localObject1).setOutsideTouchable(bool1);
          localObject1 = mPopup;
          localObject2 = mDropDownAnchorView;
          k = mDropDownHorizontalOffset;
          m = mDropDownVerticalOffset;
          if (j >= 0) {
            break label976;
          }
          j = -1;
          label584:
          if (i >= 0) {
            break label979;
          }
          i = -1;
          label590:
          ((PopupWindow)localObject1).update((View)localObject2, k, m, j, i);
        }
        for (;;)
        {
          return;
          bool1 = false;
          break;
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          ((LinearLayout)localObject2).addView(localView);
          break label254;
          ((LinearLayout)localObject2).addView(localView);
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          break label254;
          i = 0;
          j = 0;
          break label270;
          mPopup.getContentView();
          localObject1 = mPromptView;
          if (localObject1 != null)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight();
            j = topMargin;
            i = bottomMargin + (i + j);
            break label326;
            mTempRect.setEmpty();
            k = 0;
            break label389;
            label720:
            bool1 = false;
            break label403;
            label726:
            switch (mDropDownWidth)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(mDropDownWidth, 1073741824);
            }
            for (;;)
            {
              m = mDropDownList.measureHeightOfChildrenCompat$2e71581f$4868d301(j, m - i);
              j = i;
              if (m > 0) {
                j = i + k;
              }
              i = m + j;
              break;
              j = View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), Integer.MIN_VALUE);
              continue;
              j = View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), 1073741824);
            }
            label874:
            if (mDropDownWidth == -2)
            {
              j = mDropDownAnchorView.getWidth();
              break label476;
            }
            j = mDropDownWidth;
            break label476;
            label902:
            i = -1;
            break label489;
            label907:
            k = 0;
            break label510;
            label912:
            localObject1 = mPopup;
            if (mDropDownWidth == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWidth(k);
              mPopup.setHeight(-1);
              break;
            }
            label950:
            if (mDropDownHeight == -2) {
              break label524;
            }
            i = mDropDownHeight;
            break label524;
            label970:
            bool1 = false;
            break label548;
            label976:
            break label584;
            label979:
            break label590;
            label982:
            if (mDropDownWidth == -1)
            {
              j = -1;
              label992:
              if (mDropDownHeight != -1) {
                break label1188;
              }
              i = -1;
              label1002:
              mPopup.setWidth(j);
              mPopup.setHeight(i);
              if (sClipToWindowEnabledMethod == null) {}
            }
            try
            {
              sClipToWindowEnabledMethod.invoke(mPopup, new Object[] { Boolean.valueOf(true) });
              localObject1 = mPopup;
              if ((!mForceIgnoreOutsideTouch) && (!mDropDownAlwaysVisible))
              {
                bool1 = bool3;
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                mPopup.setTouchInterceptor(mTouchInterceptor);
                PopupWindowCompat.showAsDropDown(mPopup, mDropDownAnchorView, mDropDownHorizontalOffset, mDropDownVerticalOffset, mDropDownGravity);
                mDropDownList.setSelection(-1);
                if ((!mModal) || (mDropDownList.isInTouchMode())) {
                  clearListSelection();
                }
                if (mModal) {
                  continue;
                }
                mHandler.post(mHideSelector);
                return;
                if (mDropDownWidth == -2)
                {
                  j = mDropDownAnchorView.getWidth();
                  break label992;
                }
                j = mDropDownWidth;
                break label992;
                label1188:
                if (mDropDownHeight == -2) {
                  break label1002;
                }
                i = mDropDownHeight;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                continue;
                bool1 = false;
              }
            }
          }
        }
        i = 0;
      }
      label1233:
      i = 0;
    }
  }
  
  private static final class DropDownListView
    extends ListViewCompat
  {
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private ListViewAutoScrollHelper mScrollHelper;
    
    public DropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(null, R.attr.dropDownListViewStyle);
      mHijackFocus = paramBoolean;
      setCacheColorHint(0);
    }
    
    public final boolean hasFocus()
    {
      return (mHijackFocus) || (super.hasFocus());
    }
    
    public final boolean hasWindowFocus()
    {
      return (mHijackFocus) || (super.hasWindowFocus());
    }
    
    public final boolean isFocused()
    {
      return (mHijackFocus) || (super.isFocused());
    }
    
    public final boolean isInTouchMode()
    {
      return ((mHijackFocus) && (mListSelectionHidden)) || (super.isInTouchMode());
    }
    
    public final boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      int i = 0;
      int j = MotionEventCompat.getActionMasked(paramMotionEvent);
      View localView;
      switch (j)
      {
      default: 
        bool1 = bool2;
        paramInt = i;
        if ((!bool1) || (paramInt != 0))
        {
          mDrawsInPressedState = false;
          setPressed(false);
          drawableStateChanged();
          localView = getChildAt(mMotionPosition - getFirstVisiblePosition());
          if (localView != null) {
            localView.setPressed(false);
          }
          if (mClickAnimation != null)
          {
            mClickAnimation.cancel();
            mClickAnimation = null;
          }
        }
        if (bool1)
        {
          if (mScrollHelper == null) {
            mScrollHelper = new ListViewAutoScrollHelper(this);
          }
          mScrollHelper.setEnabled(true);
          mScrollHelper.onTouch(this, paramMotionEvent);
        }
        break;
      }
      label418:
      while (mScrollHelper == null)
      {
        return bool1;
        bool1 = false;
        paramInt = i;
        break;
        bool1 = false;
        int k = paramMotionEvent.findPointerIndex(paramInt);
        if (k < 0)
        {
          bool1 = false;
          paramInt = i;
          break;
        }
        paramInt = (int)paramMotionEvent.getX(k);
        int m = (int)paramMotionEvent.getY(k);
        k = pointToPosition(paramInt, m);
        if (k == -1)
        {
          paramInt = 1;
          break;
        }
        localView = getChildAt(k - getFirstVisiblePosition());
        float f1 = paramInt;
        float f2 = m;
        mDrawsInPressedState = true;
        if (Build.VERSION.SDK_INT >= 21) {
          drawableHotspotChanged(f1, f2);
        }
        if (!isPressed()) {
          setPressed(true);
        }
        layoutChildren();
        if (mMotionPosition != -1)
        {
          localObject1 = getChildAt(mMotionPosition - getFirstVisiblePosition());
          if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
            ((View)localObject1).setPressed(false);
          }
        }
        mMotionPosition = k;
        float f3 = localView.getLeft();
        float f4 = localView.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
          localView.drawableHotspotChanged(f1 - f3, f2 - f4);
        }
        if (!localView.isPressed()) {
          localView.setPressed(true);
        }
        Object localObject1 = getSelector();
        Object localObject2;
        if ((localObject1 != null) && (k != -1))
        {
          paramInt = 1;
          if (paramInt != 0) {
            ((Drawable)localObject1).setVisible(false, false);
          }
          localObject2 = mSelectorRect;
          ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          left -= mSelectionLeftPadding;
          top -= mSelectionTopPadding;
          right += mSelectionRightPadding;
          bottom += mSelectionBottomPadding;
        }
        for (;;)
        {
          try
          {
            bool1 = mIsChildViewEnabled.getBoolean(this);
            if (localView.isEnabled() != bool1)
            {
              localObject2 = mIsChildViewEnabled;
              if (bool1) {
                continue;
              }
              bool1 = true;
              ((Field)localObject2).set(this, Boolean.valueOf(bool1));
              if (k != -1) {
                refreshDrawableState();
              }
            }
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            continue;
            bool1 = false;
            continue;
          }
          if (paramInt != 0)
          {
            localObject2 = mSelectorRect;
            f3 = ((Rect)localObject2).exactCenterX();
            f4 = ((Rect)localObject2).exactCenterY();
            if (getVisibility() != 0) {
              continue;
            }
            bool1 = true;
            ((Drawable)localObject1).setVisible(bool1, false);
            DrawableCompat.setHotspot((Drawable)localObject1, f3, f4);
          }
          localObject1 = getSelector();
          if ((localObject1 != null) && (k != -1)) {
            DrawableCompat.setHotspot((Drawable)localObject1, f1, f2);
          }
          setSelectorEnabled(false);
          refreshDrawableState();
          bool2 = true;
          paramInt = i;
          bool1 = bool2;
          if (j != 1) {
            break;
          }
          performItemClick(localView, k, getItemIdAtPosition(k));
          paramInt = i;
          bool1 = bool2;
          break;
          paramInt = 0;
          break label418;
          bool1 = false;
        }
      }
      mScrollHelper.setEnabled(false);
      return bool1;
    }
    
    protected final boolean touchModeDrawsInPressedStateCompat()
    {
      return (mDrawsInPressedState) || (super.touchModeDrawsInPressedStateCompat());
    }
  }
  
  public static abstract class ForwardingListener
    implements View.OnTouchListener
  {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    private final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation = new int[2];
    private Runnable mTriggerLongPress;
    private boolean mWasLongPress;
    
    public ForwardingListener(View paramView)
    {
      mSrc = paramView;
      mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      mTapTimeout = ViewConfiguration.getTapTimeout();
      mLongPressTimeout = ((mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2);
    }
    
    private void clearCallbacks()
    {
      if (mTriggerLongPress != null) {
        mSrc.removeCallbacks(mTriggerLongPress);
      }
      if (mDisallowIntercept != null) {
        mSrc.removeCallbacks(mDisallowIntercept);
      }
    }
    
    private boolean onTouchForwarded(MotionEvent paramMotionEvent)
    {
      boolean bool1 = true;
      Object localObject1 = mSrc;
      Object localObject2 = getPopup();
      if ((localObject2 == null) || (!mPopup.isShowing())) {
        bool1 = false;
      }
      for (;;)
      {
        return bool1;
        localObject2 = mDropDownList;
        if ((localObject2 == null) || (!((ListPopupWindow.DropDownListView)localObject2).isShown())) {
          return false;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        int[] arrayOfInt = mTmpLocation;
        ((View)localObject1).getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        localObject1 = mTmpLocation;
        ((View)localObject2).getLocationOnScreen((int[])localObject1);
        localMotionEvent.offsetLocation(-localObject1[0], -localObject1[1]);
        boolean bool2 = ((ListPopupWindow.DropDownListView)localObject2).onForwardedEvent(localMotionEvent, mActivePointerId);
        localMotionEvent.recycle();
        int i = MotionEventCompat.getActionMasked(paramMotionEvent);
        if ((i != 1) && (i != 3)) {}
        for (i = 1; (!bool2) || (i == 0); i = 0) {
          return false;
        }
      }
    }
    
    public abstract ListPopupWindow getPopup();
    
    public boolean onForwardingStarted()
    {
      ListPopupWindow localListPopupWindow = getPopup();
      if ((localListPopupWindow != null) && (!mPopup.isShowing())) {
        localListPopupWindow.show();
      }
      return true;
    }
    
    protected boolean onForwardingStopped()
    {
      ListPopupWindow localListPopupWindow = getPopup();
      if ((localListPopupWindow != null) && (mPopup.isShowing())) {
        localListPopupWindow.dismiss();
      }
      return true;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool3 = false;
      boolean bool4 = mForwarding;
      boolean bool1;
      if (bool4)
      {
        if (mWasLongPress)
        {
          bool1 = onTouchForwarded(paramMotionEvent);
          mForwarding = bool1;
          if (!bool1)
          {
            bool1 = bool3;
            if (!bool4) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
        if ((onTouchForwarded(paramMotionEvent)) || (!onForwardingStopped())) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      paramView = mSrc;
      if (paramView.isEnabled()) {}
      label128:
      int i;
      switch (MotionEventCompat.getActionMasked(paramMotionEvent))
      {
      default: 
        i = 0;
        label131:
        if ((i == 0) || (!onForwardingStarted())) {
          break;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        mSrc.onTouchEvent(paramView);
        paramView.recycle();
        bool1 = bool2;
        break;
        mActivePointerId = paramMotionEvent.getPointerId(0);
        mWasLongPress = false;
        if (mDisallowIntercept == null) {
          mDisallowIntercept = new DisallowIntercept((byte)0);
        }
        paramView.postDelayed(mDisallowIntercept, mTapTimeout);
        if (mTriggerLongPress == null) {
          mTriggerLongPress = new TriggerLongPress((byte)0);
        }
        paramView.postDelayed(mTriggerLongPress, mLongPressTimeout);
        break label128;
        i = paramMotionEvent.findPointerIndex(mActivePointerId);
        if (i < 0) {
          break label128;
        }
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        float f3 = mScaledTouchSlop;
        if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
        for (i = 1; i == 0; i = 0)
        {
          clearCallbacks();
          paramView.getParent().requestDisallowInterceptTouchEvent(true);
          i = 1;
          break label131;
        }
        clearCallbacks();
        break label128;
      }
    }
    
    private final class DisallowIntercept
      implements Runnable
    {
      private DisallowIntercept() {}
      
      public final void run()
      {
        mSrc.getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    
    private final class TriggerLongPress
      implements Runnable
    {
      private TriggerLongPress() {}
      
      public final void run()
      {
        ListPopupWindow.ForwardingListener.access$1000(ListPopupWindow.ForwardingListener.this);
      }
    }
  }
  
  private final class ListSelectorHider
    implements Runnable
  {
    private ListSelectorHider() {}
    
    public final void run()
    {
      clearListSelection();
    }
  }
  
  private final class PopupDataSetObserver
    extends DataSetObserver
  {
    private PopupDataSetObserver() {}
    
    public final void onChanged()
    {
      if (mPopup.isShowing()) {
        show();
      }
    }
    
    public final void onInvalidated()
    {
      dismiss();
    }
  }
  
  private final class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    private PopupScrollListener() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!isInputMethodNotNeeded()) && (mPopup.getContentView() != null))
      {
        mHandler.removeCallbacks(mResizePopupRunnable);
        mResizePopupRunnable.run();
      }
    }
  }
  
  private final class PopupTouchInterceptor
    implements View.OnTouchListener
  {
    private PopupTouchInterceptor() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (mPopup != null) && (mPopup.isShowing()) && (j >= 0) && (j < mPopup.getWidth()) && (k >= 0) && (k < mPopup.getHeight())) {
        mHandler.postDelayed(mResizePopupRunnable, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          mHandler.removeCallbacks(mResizePopupRunnable);
        }
      }
    }
  }
  
  private final class ResizePopupRunnable
    implements Runnable
  {
    private ResizePopupRunnable() {}
    
    public final void run()
    {
      if ((mDropDownList != null) && (ViewCompat.isAttachedToWindow(mDropDownList)) && (mDropDownList.getCount() > mDropDownList.getChildCount()) && (mDropDownList.getChildCount() <= mListItemExpandMaximum))
      {
        mPopup.setInputMethodMode(2);
        show();
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */