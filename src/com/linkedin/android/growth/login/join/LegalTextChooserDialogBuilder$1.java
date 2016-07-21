package com.linkedin.android.growth.login.join;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import java.util.List;

final class LegalTextChooserDialogBuilder$1
  extends ArrayAdapter<String>
{
  LegalTextChooserDialogBuilder$1(LegalTextChooserDialogBuilder paramLegalTextChooserDialogBuilder, Context paramContext, List paramList)
  {
    super(paramContext, 17367057, 16908308, paramList);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    JellyBeanMr1Utils.setTextAlignment((TextView)paramView.findViewById(16908308), 5);
    return paramView;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.LegalTextChooserDialogBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */