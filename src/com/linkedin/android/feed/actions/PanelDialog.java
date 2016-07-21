package com.linkedin.android.feed.actions;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.ViewUtils;
import java.util.List;

public class PanelDialog
  extends Dialog
{
  protected LinearLayout contentView;
  protected FragmentComponent fragmentComponent;
  protected LayoutInflater inflater;
  protected int insertPos;
  protected List<PanelDialogItem> panelItems;
  protected View rootView;
  protected WindowManager windowManager;
  
  public PanelDialog(FragmentComponent paramFragmentComponent)
  {
    super(paramFragmentComponent.activity());
    fragmentComponent = paramFragmentComponent;
    inflater = ((LayoutInflater)paramFragmentComponent.activity().getSystemService("layout_inflater"));
    windowManager = ((WindowManager)paramFragmentComponent.activity().getSystemService("window"));
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  @SuppressLint({"InflateParams"})
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    rootView = inflater.inflate(2130968737, null);
    contentView = ((LinearLayout)rootView.findViewById(2131755749));
    int j = panelItems.size();
    contentView.setWeightSum(j);
    int i = 0;
    if (i < j)
    {
      paramBundle = (PanelDialogItem)panelItems.get(i);
      CharSequence localCharSequence1 = title;
      CharSequence localCharSequence2 = subtitle;
      Drawable localDrawable = ContextCompat.getDrawable(fragmentComponent.context(), iconResId);
      View localView = inflater.inflate(2130968736, contentView, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131755743);
      TextView localTextView1 = (TextView)localView.findViewById(2131755745);
      TextView localTextView2 = (TextView)localView.findViewById(2131755746);
      if (localDrawable != null) {
        localImageView.setImageDrawable(localDrawable);
      }
      for (;;)
      {
        ViewUtils.setTextAndUpdateVisibility(localTextView1, localCharSequence1, false);
        ViewUtils.setTextAndUpdateVisibility(localTextView2, localCharSequence2, false);
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (paramBundlelistener != null) {
              paramBundlelistener.onClick(paramAnonymousView);
            }
            dismiss();
          }
        });
        localView.setFocusable(true);
        localView.setClickable(true);
        contentView.addView(localView, insertPos);
        insertPos += 1;
        i += 1;
        break;
        localImageView.setVisibility(4);
      }
    }
    rootView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    setContentView(rootView);
    setCanceledOnTouchOutside(true);
  }
  
  public final PanelDialog setPanelItems(List<PanelDialogItem> paramList)
  {
    panelItems = paramList;
    return this;
  }
  
  public static final class PanelDialogItem
  {
    public int iconResId;
    public View.OnClickListener listener;
    public CharSequence subtitle;
    public CharSequence title;
    
    public PanelDialogItem(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, View.OnClickListener paramOnClickListener)
    {
      title = paramCharSequence1;
      subtitle = paramCharSequence2;
      iconResId = paramInt;
      listener = paramOnClickListener;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.PanelDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */