package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.SpinnerAdapter;

final class AppCompatSpinner$DropdownPopup
  extends ListPopupWindow
{
  private ListAdapter mAdapter;
  CharSequence mHintText;
  private final Rect mVisibleRect = new Rect();
  
  public AppCompatSpinner$DropdownPopup(final AppCompatSpinner paramAppCompatSpinner, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mDropDownAnchorView = paramAppCompatSpinner;
    setModal$1385ff();
    mPromptPosition = 0;
    mItemClickListener = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this$0.setSelection(paramAnonymousInt);
        if (this$0.getOnItemClickListener() != null) {
          this$0.performItemClick(paramAnonymousView, paramAnonymousInt, mAdapter.getItemId(paramAnonymousInt));
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
      ((Drawable)localObject).getPadding(AppCompatSpinner.access$300(this$0));
      if (ViewUtils.isLayoutRtl(this$0))
      {
        i = access$300this$0).right;
        n = this$0.getPaddingLeft();
        i1 = this$0.getPaddingRight();
        i2 = this$0.getWidth();
        if (AppCompatSpinner.access$400(this$0) != -2) {
          break label251;
        }
        int k = AppCompatSpinner.access$500(this$0, (SpinnerAdapter)mAdapter, mPopup.getBackground());
        int m = this$0.getContext().getResources().getDisplayMetrics().widthPixels - access$300this$0).left - access$300this$0).right;
        int j = k;
        if (k > m) {
          j = m;
        }
        setContentWidth(Math.max(j, i2 - n - i1));
        label178:
        if (!ViewUtils.isLayoutRtl(this$0)) {
          break label291;
        }
        i += i2 - i1 - mDropDownWidth;
      }
    }
    for (;;)
    {
      mDropDownHorizontalOffset = i;
      return;
      i = -access$300this$0).left;
      break;
      localObject = AppCompatSpinner.access$300(this$0);
      access$300this$0).right = 0;
      left = 0;
      break;
      label251:
      if (AppCompatSpinner.access$400(this$0) == -1)
      {
        setContentWidth(i2 - n - i1);
        break label178;
      }
      setContentWidth(AppCompatSpinner.access$400(this$0));
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
    int i = this$0.getSelectedItemPosition();
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
      localObject = this$0.getViewTreeObserver();
    } while (localObject == null);
    final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        if (!AppCompatSpinner.DropdownPopup.access$600(AppCompatSpinner.DropdownPopup.this, this$0))
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
        ViewTreeObserver localViewTreeObserver = this$0.getViewTreeObserver();
        if (localViewTreeObserver != null) {
          localViewTreeObserver.removeGlobalOnLayoutListener(local2);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.DropdownPopup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */