package com.linkedin.CrossPromoLib.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.models.types.TextType;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.fe.api.android.SubPromo;
import com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn;
import java.util.Map;

public class PromoUtils
{
  public static void addButton$6e97a4d(Button paramButton, RichText paramRichText, View.OnClickListener paramOnClickListener)
  {
    addText(paramButton, paramRichText);
    if (TextUtils.isEmpty(paramButton.getText()))
    {
      paramButton.setVisibility(4);
      paramButton.setOnClickListener(null);
      return;
    }
    paramButton.setOnClickListener(paramOnClickListener);
  }
  
  public static void addDetailText(TextView paramTextView, PromoModel paramPromoModel)
  {
    addRichTextToTextView(paramTextView, paramPromoModel, TextType.Detail, null);
  }
  
  public static void addPromptButton(Button paramButton, PromoModel paramPromoModel, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    addButton$6e97a4d(paramButton, Utils.getPromptText(paramContext, paramPromoModel), paramOnClickListener);
  }
  
  public static void addRichTextToSubPromoTextView(TextView paramTextView, SubPromo paramSubPromo, String paramString)
  {
    if (texts == null) {
      return;
    }
    addText(paramTextView, (RichText)texts.get(paramString));
  }
  
  public static void addRichTextToTextView(TextView paramTextView, PromoModel paramPromoModel, TextType paramTextType, Context paramContext)
  {
    addText(paramTextView, paramTextType.getRichText(paramPromoModel, paramContext));
  }
  
  public static void addText(TextView paramTextView, RichText paramRichText)
  {
    if ((paramRichText == null) || (paramTextView == null)) {}
    do
    {
      return;
      paramRichText = rawText;
    } while (TextUtils.isEmpty(paramRichText));
    paramTextView.setText(paramRichText);
  }
  
  public static void addTitleText(TextView paramTextView, PromoModel paramPromoModel)
  {
    addRichTextToTextView(paramTextView, paramPromoModel, TextType.Title, null);
  }
  
  public static <T> T firstNonNull(T... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] != null) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static RichText getBoltonText(SocialProofBoltOn paramSocialProofBoltOn)
  {
    if (paramSocialProofBoltOn == null) {
      return null;
    }
    return (RichText)firstNonNull(new RichText[] { boltonText, text });
  }
  
  public static void setViewVisibilityFromDetailView(View paramView, PromoModel paramPromoModel)
  {
    setViewVisibilityFromRichText(paramView, paramPromoModel, null, TextType.Detail);
  }
  
  public static void setViewVisibilityFromRichText(View paramView, PromoModel paramPromoModel, Context paramContext, TextType paramTextType)
  {
    paramPromoModel = paramTextType.getRichText(paramPromoModel, paramContext);
    if ((paramPromoModel == null) || (TextUtils.isEmpty(rawText))) {}
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.PromoUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */