package com.linkedin.android.growth.login.join;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class LegalTextChooserDialogBuilder$2
  implements DialogInterface.OnClickListener
{
  LegalTextChooserDialogBuilder$2(LegalTextChooserDialogBuilder paramLegalTextChooserDialogBuilder) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramDialogInterface.dismiss();
      return;
    case 0: 
    case 1: 
    case 2: 
      LegalTextChooserDialogBuilder.access$100(this$0, this$0.getString(LegalTextChooserDialogBuilder.access$000()[paramInt]));
      return;
    }
    LegalTextChooserDialogBuilder.access$100(this$0, LegalTextChooserDialogBuilder.access$200$185ab0e0());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.LegalTextChooserDialogBuilder.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */