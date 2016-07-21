package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.R.attr;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public class BottomSheetDialog
  extends AppCompatDialog
{
  private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback()
  {
    public void onSlide(View paramAnonymousView, float paramAnonymousFloat) {}
    
    public void onStateChanged(View paramAnonymousView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 5) {
        dismiss();
      }
    }
  };
  
  public BottomSheetDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BottomSheetDialog(Context paramContext, int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }
  
  protected BottomSheetDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    supportRequestWindowFeature(1);
  }
  
  private static int getThemeResId(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, localTypedValue, true)) {
        i = resourceId;
      }
    }
    else
    {
      return i;
    }
    return R.style.Theme_Design_Light_BottomSheetDialog;
  }
  
  private boolean shouldWindowCloseOnTouchOutside()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    TypedValue localTypedValue;
    do
    {
      return true;
      localTypedValue = new TypedValue();
      if (!getContext().getTheme().resolveAttribute(16843611, localTypedValue, true)) {
        break;
      }
    } while (data != 0);
    return false;
    return false;
  }
  
  private View wrapInBottomSheet(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(R.id.design_bottom_sheet);
    BottomSheetBehavior.from(paramView).setBottomSheetCallback(mBottomSheetCallback);
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      if (shouldWindowCloseOnTouchOutside()) {
        localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (isShowing()) {
              cancel();
            }
          }
        });
      }
      return localCoordinatorLayout;
      paramView.addView(localView, paramLayoutParams);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(wrapInBottomSheet(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, paramLayoutParams));
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */