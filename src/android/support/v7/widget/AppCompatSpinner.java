package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE;
  private static final boolean IS_AT_LEAST_JB;
  private static final boolean IS_AT_LEAST_M;
  private AppCompatBackgroundHelper mBackgroundTintHelper;
  private AppCompatDrawableManager mDrawableManager;
  private int mDropDownWidth;
  private ListPopupWindow.ForwardingListener mForwardingListener;
  private DropdownPopup mPopup;
  private Context mPopupContext;
  private boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  private final Rect mTempRect = new Rect();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool = true;
      IS_AT_LEAST_M = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      IS_AT_LEAST_JB = bool;
      ATTRS_ANDROID_SPINNERMODE = new int[] { 16843505 };
      return;
      bool = false;
      break;
    }
  }
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, paramAttributeSet, R.styleable.Spinner, paramInt1);
    mDrawableManager = AppCompatDrawableManager.get();
    mBackgroundTintHelper = new AppCompatBackgroundHelper(this, mDrawableManager);
    int j;
    Object localObject;
    if (paramTheme != null)
    {
      paramTheme = new ContextThemeWrapper(paramContext, paramTheme);
      mPopupContext = paramTheme;
      if (mPopupContext != null)
      {
        j = paramInt2;
        if (paramInt2 == -1)
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label475;
          }
          localObject = null;
          paramTheme = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS_ANDROID_SPINNERMODE, paramInt1, 0);
        i = paramInt2;
        paramTheme = localTypedArray;
        localObject = localTypedArray;
        if (localTypedArray.hasValue(0))
        {
          paramTheme = localTypedArray;
          localObject = localTypedArray;
          i = localTypedArray.getInt(0, 0);
        }
        j = i;
        if (localTypedArray != null)
        {
          localTypedArray.recycle();
          j = i;
        }
      }
      catch (Exception localException)
      {
        int i;
        localObject = paramTheme;
        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", localException);
        j = paramInt2;
        if (paramTheme == null) {
          continue;
        }
        paramTheme.recycle();
        j = paramInt2;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((TypedArray)localObject).recycle();
      }
      if (j == 1)
      {
        paramTheme = new DropdownPopup(mPopupContext, paramAttributeSet, paramInt1);
        localObject = TintTypedArray.obtainStyledAttributes$89ace2b(mPopupContext, paramAttributeSet, R.styleable.Spinner, paramInt1);
        mDropDownWidth = ((TintTypedArray)localObject).getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
        paramTheme.setBackgroundDrawable(((TintTypedArray)localObject).getDrawable(R.styleable.Spinner_android_popupBackground));
        paramInt2 = R.styleable.Spinner_android_prompt;
        mHintText = mWrapped.getString(paramInt2);
        mWrapped.recycle();
        mPopup = paramTheme;
        mForwardingListener = new ListPopupWindow.ForwardingListener(this)
        {
          public final ListPopupWindow getPopup()
          {
            return paramTheme;
          }
          
          public final boolean onForwardingStarted()
          {
            if (!mPopup.mPopup.isShowing()) {
              mPopup.show();
            }
            return true;
          }
        };
      }
      paramInt2 = R.styleable.Spinner_android_entries;
      paramTheme = mWrapped.getTextArray(paramInt2);
      if (paramTheme != null)
      {
        paramContext = new ArrayAdapter(paramContext, 17367048, paramTheme);
        paramContext.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        setAdapter(paramContext);
      }
      mWrapped.recycle();
      mPopupSet = true;
      if (mTempAdapter != null)
      {
        setAdapter(mTempAdapter);
        mTempAdapter = null;
      }
      mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt1);
      return;
      i = localTintTypedArray.getResourceId(R.styleable.Spinner_popupTheme, 0);
      if (i != 0)
      {
        paramTheme = new ContextThemeWrapper(paramContext, i);
        break;
      }
      if (!IS_AT_LEAST_M)
      {
        paramTheme = paramContext;
        break;
      }
      paramTheme = null;
      break;
      label475:
      j = 1;
    }
  }
  
  private int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int j;
    if (paramSpinnerAdapter == null) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      i = 0;
      View localView = null;
      int k = 0;
      int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
      int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
      j = Math.max(0, getSelectedItemPosition());
      int i3 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
      j = Math.max(0, j - (15 - (i3 - j)));
      while (j < i3)
      {
        int n = paramSpinnerAdapter.getItemViewType(j);
        int m = k;
        if (n != k)
        {
          m = n;
          localView = null;
        }
        localView = paramSpinnerAdapter.getView(j, localView, this);
        if (localView.getLayoutParams() == null) {
          localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        localView.measure(i1, i2);
        i = Math.max(i, localView.getMeasuredWidth());
        j += 1;
        k = m;
      }
      j = i;
    } while (paramDrawable == null);
    paramDrawable.getPadding(mTempRect);
    return i + (mTempRect.left + mTempRect.right);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (mBackgroundTintHelper != null) {
      mBackgroundTintHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (mPopup != null) {
      return mPopup.mDropDownHorizontalOffset;
    }
    if (IS_AT_LEAST_JB) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (mPopup != null)
    {
      localDropdownPopup = mPopup;
      if (mDropDownVerticalOffsetSet) {}
    }
    while (!IS_AT_LEAST_JB)
    {
      DropdownPopup localDropdownPopup;
      return 0;
      return mDropDownVerticalOffset;
    }
    return super.getDropDownVerticalOffset();
  }
  
  public int getDropDownWidth()
  {
    if (mPopup != null) {
      return mDropDownWidth;
    }
    if (IS_AT_LEAST_JB) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (mPopup != null) {
      return mPopup.mPopup.getBackground();
    }
    if (IS_AT_LEAST_JB) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (mPopup != null) {
      return mPopupContext;
    }
    if (IS_AT_LEAST_M) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (mPopup != null) {
      return mPopup.mHintText;
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (mBackgroundTintHelper != null) {
      return mBackgroundTintHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (mBackgroundTintHelper != null) {
      return mBackgroundTintHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((mPopup != null) && (mPopup.mPopup.isShowing())) {
      mPopup.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((mForwardingListener != null) && (mForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (mPopup != null)
    {
      if (!mPopup.mPopup.isShowing()) {
        mPopup.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!mPopupSet) {
      mTempAdapter = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (mPopup == null);
    if (mPopupContext == null) {}
    for (Context localContext = getContext();; localContext = mPopupContext)
    {
      mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (mBackgroundTintHelper != null) {
      mBackgroundTintHelper.setInternalBackgroundTint(null);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (mBackgroundTintHelper != null) {
      mBackgroundTintHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (mPopup != null) {
      mPopup.mDropDownHorizontalOffset = paramInt;
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (mPopup != null)
    {
      localDropdownPopup = mPopup;
      mDropDownVerticalOffset = paramInt;
      mDropDownVerticalOffsetSet = true;
    }
    while (!IS_AT_LEAST_JB)
    {
      DropdownPopup localDropdownPopup;
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (mPopup != null) {
      mDropDownWidth = paramInt;
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (mPopup != null) {
      mPopup.setBackgroundDrawable(paramDrawable);
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(ContextCompat.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (mPopup != null)
    {
      mPopup.mHintText = paramCharSequence;
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTintHelper != null) {
      mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTintHelper != null) {
      mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  private static final class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
      if ((paramTheme != null) && (AppCompatSpinner.IS_AT_LEAST_M) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
      {
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
    }
    
    public final boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public final int getCount()
    {
      if (mAdapter == null) {
        return 0;
      }
      return mAdapter.getCount();
    }
    
    public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (mAdapter == null) {
        return null;
      }
      return mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final Object getItem(int paramInt)
    {
      if (mAdapter == null) {
        return null;
      }
      return mAdapter.getItem(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      if (mAdapter == null) {
        return -1L;
      }
      return mAdapter.getItemId(paramInt);
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
    
    public final boolean hasStableIds()
    {
      return (mAdapter != null) && (mAdapter.hasStableIds());
    }
    
    public final boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (mAdapter != null) {
        mAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (mAdapter != null) {
        mAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private final class DropdownPopup
    extends ListPopupWindow
  {
    private ListAdapter mAdapter;
    CharSequence mHintText;
    private final Rect mVisibleRect = new Rect();
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      mDropDownAnchorView = AppCompatSpinner.this;
      setModal$1385ff();
      mPromptPosition = 0;
      mItemClickListener = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          setSelection(paramAnonymousInt);
          if (getOnItemClickListener() != null) {
            performItemClick(paramAnonymousView, paramAnonymousInt, mAdapter.getItemId(paramAnonymousInt));
          }
          dismiss();
        }
      };
    }
    
    final void computeContentWidth()
    {
      Object localObject = mPopup.getBackground();
      int i = 0;
      int n;
      int i1;
      int i2;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this))
        {
          i = mTempRect.right;
          n = getPaddingLeft();
          i1 = getPaddingRight();
          i2 = getWidth();
          if (mDropDownWidth != -2) {
            break label251;
          }
          int k = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)mAdapter, mPopup.getBackground());
          int m = getContext().getResources().getDisplayMetrics().widthPixels - mTempRect.left - mTempRect.right;
          int j = k;
          if (k > m) {
            j = m;
          }
          setContentWidth(Math.max(j, i2 - n - i1));
          label178:
          if (!ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
            break label291;
          }
          i += i2 - i1 - mDropDownWidth;
        }
      }
      for (;;)
      {
        mDropDownHorizontalOffset = i;
        return;
        i = -mTempRect.left;
        break;
        localObject = mTempRect;
        mTempRect.right = 0;
        left = 0;
        break;
        label251:
        if (mDropDownWidth == -1)
        {
          setContentWidth(i2 - n - i1);
          break label178;
        }
        setContentWidth(mDropDownWidth);
        break label178;
        label291:
        i += n;
      }
    }
    
    public final void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      mAdapter = paramListAdapter;
    }
    
    public final void show()
    {
      boolean bool = mPopup.isShowing();
      computeContentWidth();
      setInputMethodMode$13462e();
      super.show();
      mDropDownList.setChoiceMode(1);
      int i = getSelectedItemPosition();
      Object localObject = mDropDownList;
      if ((mPopup.isShowing()) && (localObject != null))
      {
        ListPopupWindow.DropDownListView.access$502((ListPopupWindow.DropDownListView)localObject, false);
        ((ListPopupWindow.DropDownListView)localObject).setSelection(i);
        if ((Build.VERSION.SDK_INT >= 11) && (((ListPopupWindow.DropDownListView)localObject).getChoiceMode() != 0)) {
          ((ListPopupWindow.DropDownListView)localObject).setItemChecked(i, true);
        }
      }
      if (bool) {}
      do
      {
        return;
        localObject = getViewTreeObserver();
      } while (localObject == null);
      final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          if (!AppCompatSpinner.DropdownPopup.access$600(AppCompatSpinner.DropdownPopup.this, AppCompatSpinner.this))
          {
            dismiss();
            return;
          }
          computeContentWidth();
          AppCompatSpinner.DropdownPopup.this.show();
        }
      };
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
      setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
          if (localViewTreeObserver != null) {
            localViewTreeObserver.removeGlobalOnLayoutListener(local2);
          }
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */