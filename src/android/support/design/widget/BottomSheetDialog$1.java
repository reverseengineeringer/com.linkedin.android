package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

class BottomSheetDialog$1
  implements View.OnClickListener
{
  BottomSheetDialog$1(BottomSheetDialog paramBottomSheetDialog) {}
  
  public void onClick(View paramView)
  {
    if (this$0.isShowing()) {
      this$0.cancel();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */