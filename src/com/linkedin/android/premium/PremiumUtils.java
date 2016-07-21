package com.linkedin.android.premium;

import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.ui.spans.UrlSpan;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class PremiumUtils
{
  public static void arrangeVertically(View... paramVarArgs)
  {
    int i = 1;
    while (i < 3)
    {
      View localView1 = paramVarArgs[(i - 1)];
      View localView2 = paramVarArgs[i];
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
      localLayoutParams.addRule(3, localView1.getId());
      localView2.setLayoutParams(localLayoutParams);
      i += 1;
    }
  }
  
  public static RectF getBoundsInView(View paramView1, View paramView2)
  {
    float f1 = paramView1.getX();
    float f2 = paramView1.getY();
    RectF localRectF = new RectF(f1, f2, paramView1.getWidth() * paramView1.getScaleX() + f1, paramView1.getHeight() * paramView1.getScaleY() + f2);
    for (paramView1 = paramView1.getParent(); (paramView1 != null) && (paramView1 != paramView2); paramView1 = paramView1.getParent()) {
      if (((paramView1 instanceof View)) && (!(paramView1.getParent() instanceof ViewPager)))
      {
        View localView = (View)paramView1;
        localRectF.offset(localView.getX(), localView.getY());
        right = (left + (right - left) * localView.getScaleX());
        bottom = (top + (bottom - top) * localView.getScaleY());
      }
    }
    return localRectF;
  }
  
  public static void navigateUp(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null)
    {
      HomeIntent localHomeIntent = activityComponent.intentRegistry().home;
      HomeBundle localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.FEED;
      NavigationUtils.navigateUp(paramBaseActivity, localHomeIntent.newIntent(paramBaseActivity, localHomeBundle), false);
    }
  }
  
  public static void setBackground(PremiumModel.Gradient paramGradient, View... paramVarArgs)
  {
    int i = 0;
    if ((paramGradient != null) && (colors != null) && (colors.length > 0))
    {
      if (colors.length == 1)
      {
        j = paramVarArgs.length;
        i = 0;
        while (i < j)
        {
          paramVarArgs[i].setBackgroundColor(colors[0]);
          i += 1;
        }
      }
      if (Build.VERSION.SDK_INT < 16)
      {
        j = paramVarArgs.length;
        i = 0;
        while (i < j)
        {
          paramVarArgs[i].setBackgroundColor(colors[0]);
          i += 1;
        }
      }
      int j = paramVarArgs.length;
      while (i < j)
      {
        paramVarArgs[i].setBackground(new GradientDrawable(orientation, colors));
        i += 1;
      }
    }
  }
  
  public static boolean setBackgroundImage(TrackableFragment paramTrackableFragment, LiImageView paramLiImageView, View paramView, PremiumModel.Gradient paramGradient)
  {
    String str = fragmentComponent.lixManager().getTreatment(Lix.PREMIUM_CHOOSER_THEME);
    if ("image".equals(str))
    {
      paramLiImageView.setImageResource(2130838693);
      paramLiImageView.setVisibility(0);
      paramView.setBackgroundColor(ContextCompat.getColor(paramTrackableFragment.getContext(), 2131624263));
      return true;
    }
    if ("image_download".equals(str))
    {
      paramLiImageView.setVisibility(4);
      setBackground(paramGradient, new View[] { paramView });
      paramView = new PremiumUtils.1(paramTrackableFragment, paramLiImageView, paramView);
      paramLiImageView.getViewTreeObserver().addOnGlobalLayoutListener(new PremiumUtils.2(paramLiImageView, paramTrackableFragment, paramView));
      return true;
    }
    paramLiImageView.setVisibility(8);
    setBackground(paramGradient, new View[] { paramView });
    return false;
  }
  
  public static void setText(CharSequence paramCharSequence, TextView... paramVarArgs)
  {
    int j = 1;
    int i = 0;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      Object localObject;
      if (PremiumModel.getShowAttributedText()) {
        if ((paramCharSequence instanceof Spanned))
        {
          localObject = (CharacterStyle[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), CharacterStyle.class);
          if ((localObject != null) && (localObject.length > 0))
          {
            i = 1;
            if (i == 0) {
              break label131;
            }
          }
        }
      }
      label131:
      for (i = j;; i = 0)
      {
        int k = paramVarArgs.length;
        j = 0;
        while (j < k)
        {
          localObject = paramVarArgs[j];
          ((TextView)localObject).setVisibility(0);
          if ((i != 0) && ((localObject instanceof Button))) {
            ((TextView)localObject).setAllCaps(false);
          }
          ((TextView)localObject).setText(paramCharSequence);
          j += 1;
        }
        i = 0;
        break;
        i = 0;
        break;
      }
    }
    j = paramVarArgs.length;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  public static void setTextAndColor(PremiumModel.ColoredText paramColoredText, TextView... paramVarArgs)
  {
    setText(text, paramVarArgs);
    if (color != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramVarArgs[i].setTextColor(color.intValue());
        i += 1;
      }
    }
  }
  
  public static void showClickableLinks(FragmentComponent paramFragmentComponent, TextView... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      TextView localTextView = paramVarArgs[i];
      Object localObject = localTextView.getText();
      if ((localObject instanceof Spanned))
      {
        if ((localObject instanceof Spannable)) {}
        for (localObject = (Spannable)localObject;; localObject = new SpannableString((CharSequence)localObject))
        {
          URLSpan[] arrayOfURLSpan = (URLSpan[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), URLSpan.class);
          if ((arrayOfURLSpan == null) || (arrayOfURLSpan.length <= 0)) {
            break label201;
          }
          localTextView.setMovementMethod(LinkMovementMethod.getInstance());
          int m = arrayOfURLSpan.length;
          int j = 0;
          while (j < m)
          {
            URLSpan localURLSpan = arrayOfURLSpan[j];
            UrlSpan localUrlSpan = new UrlSpan(localURLSpan.getURL(), paramFragmentComponent, new TrackingEventBuilder[0]);
            int n = ((Spannable)localObject).getSpanStart(localURLSpan);
            int i1 = ((Spannable)localObject).getSpanEnd(localURLSpan);
            ((Spannable)localObject).removeSpan(localURLSpan);
            ((Spannable)localObject).setSpan(localUrlSpan, n, i1, 33);
            j += 1;
          }
        }
        localTextView.setText((CharSequence)localObject);
      }
      label201:
      i += 1;
    }
  }
  
  static int[] toARGB(int paramInt)
  {
    return new int[] { Color.alpha(paramInt), Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt) };
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */