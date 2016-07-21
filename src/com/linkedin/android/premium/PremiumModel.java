package com.linkedin.android.premium;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText.Builder;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PremiumModel
{
  private static final Pattern BUTTON_TEXT_PATTERN = Pattern.compile("^ButtonText([0-9]+)");
  private static boolean showAttributedText;
  
  public static CharSequence fromHtml(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()) || ((paramString.indexOf('<') < 0) && (paramString.indexOf('&') < 0))) {
      return paramString;
    }
    return Html.fromHtml(paramString);
  }
  
  public static CharSequence fromText(PremiumAttributedText paramPremiumAttributedText, String paramString, Context paramContext)
  {
    CharSequence localCharSequence = null;
    Object localObject2 = null;
    Object localObject1 = localCharSequence;
    label162:
    PremiumTextAppearance localPremiumTextAppearance;
    int i;
    if (showAttributedText)
    {
      localObject1 = localCharSequence;
      if (paramPremiumAttributedText != null)
      {
        localObject1 = localObject2;
        try
        {
          localCharSequence = AttributedTextUtils.getAttributedString(new AttributedText.Builder().setText(text).setAttributes(attributes).build(RecordTemplate.Flavor.RECORD), paramContext);
          localObject2 = localCharSequence;
          if (localCharSequence != null)
          {
            localObject1 = localCharSequence;
            localObject2 = localCharSequence;
            if (hasAppearances)
            {
              localObject1 = localCharSequence;
              localObject2 = localCharSequence;
              if (!appearances.isEmpty())
              {
                localObject1 = localCharSequence;
                if ((localCharSequence instanceof Spannable))
                {
                  localObject1 = localCharSequence;
                  localObject2 = (Spannable)localCharSequence;
                  localObject1 = localCharSequence;
                  String str1 = paramContext.getPackageName();
                  localObject1 = localCharSequence;
                  Resources localResources = paramContext.getResources();
                  localObject1 = localCharSequence;
                  paramPremiumAttributedText = appearances.iterator();
                  for (;;)
                  {
                    localObject1 = localCharSequence;
                    if (!paramPremiumAttributedText.hasNext()) {
                      break label403;
                    }
                    localObject1 = localCharSequence;
                    localPremiumTextAppearance = (PremiumTextAppearance)paramPremiumAttributedText.next();
                    localObject1 = localCharSequence;
                    String str2 = "TextAppearance.ArtDeco." + BUTTON_TEXT_PATTERN.matcher(appearance).replaceFirst("ButtonText.$1");
                    localObject1 = localCharSequence;
                    i = localResources.getIdentifier(str2, "style", str1);
                    if (i != 0) {
                      break;
                    }
                    localObject1 = localCharSequence;
                    Util.safeThrow$7a8b4789(new RuntimeException("Unknown style " + str2));
                  }
                  paramPremiumAttributedText = (PremiumAttributedText)localObject1;
                }
              }
            }
          }
        }
        catch (BuilderException paramPremiumAttributedText)
        {
          Util.safeThrow$7a8b4789(new RuntimeException(paramPremiumAttributedText));
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        paramPremiumAttributedText = fromHtml(paramString);
      }
      return paramPremiumAttributedText;
      localObject1 = localCharSequence;
      localObject2 = new SpannableString(localCharSequence);
      break;
      localObject1 = localCharSequence;
      if (length <= 0) {
        break label162;
      }
      localObject1 = localCharSequence;
      int j = start;
      localObject1 = localCharSequence;
      int k = start;
      localObject1 = localCharSequence;
      int m = length;
      localObject1 = localCharSequence;
      ((Spannable)localObject2).setSpan(new TextStyleSpan(paramContext, i), j, m + k, 33);
      break label162;
      label403:
      localObject1 = localObject2;
    }
  }
  
  static boolean getShowAttributedText()
  {
    return showAttributedText;
  }
  
  public static void setShowAttributedText(boolean paramBoolean)
  {
    showAttributedText = paramBoolean;
  }
  
  public static final class ColoredText
  {
    final Integer color;
    public final CharSequence text;
    
    public ColoredText(String paramString, Integer paramInteger)
    {
      text = PremiumModel.fromHtml(paramString);
      color = paramInteger;
    }
  }
  
  public static final class Gradient
  {
    public final int[] colors;
    final GradientDrawable.Orientation orientation;
    
    public Gradient(int paramInt)
    {
      this(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt });
    }
    
    public Gradient(GradientDrawable.Orientation paramOrientation, int... paramVarArgs)
    {
      if (paramOrientation != null) {}
      for (;;)
      {
        orientation = paramOrientation;
        colors = paramVarArgs;
        return;
        paramOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */