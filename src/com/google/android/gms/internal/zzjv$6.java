package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzjv$6
  implements DialogInterface.OnClickListener
{
  zzjv$6(JsPromptResult paramJsPromptResult, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    zzOi.confirm(zzOj.getText().toString());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjv.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */