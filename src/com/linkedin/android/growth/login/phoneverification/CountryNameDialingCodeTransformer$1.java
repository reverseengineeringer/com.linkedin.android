package com.linkedin.android.growth.login.phoneverification;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class CountryNameDialingCodeTransformer$1
  implements View.OnClickListener
{
  CountryNameDialingCodeTransformer$1(EditText paramEditText, CountryNameDialingCodeViewModel paramCountryNameDialingCodeViewModel, AlertDialog paramAlertDialog) {}
  
  public final void onClick(View paramView)
  {
    val$countrySelectorButton.setText(val$viewModel.dialingCode);
    val$countrySelectorDialog.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.CountryNameDialingCodeTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */