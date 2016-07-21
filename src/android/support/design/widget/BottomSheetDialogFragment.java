package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment
  extends AppCompatDialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new BottomSheetDialog(getActivity(), getTheme());
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */