package com.linkedin.android.premium.chooser;

import android.content.Context;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.android.premium.PremiumModel.Gradient;
import java.util.Map;

public final class PremiumChooserPalette
{
  private static final GradientDrawable.Orientation LEFT_RIGHT = GradientDrawable.Orientation.LEFT_RIGHT;
  private static final GradientDrawable.Orientation TOP_BOTTOM = GradientDrawable.Orientation.TOP_BOTTOM;
  private static final PremiumModel.Gradient WHITE = new PremiumModel.Gradient(-1);
  private static int captionColor;
  private static PremiumChooserPalette dark;
  private static PremiumModel.Gradient darkHeaderBackground;
  private static int[] generalColors;
  private static PremiumModel.Gradient imageHeaderBackground;
  private static int[] jssColors;
  private static PremiumChooserPalette light;
  private static PremiumChooserPalette lightWithImage;
  private static int linkColor;
  private static int offWhite;
  private static int[] salesColors;
  private static int[] talentColors;
  SubscriptionModel.ButtonThemes buttonThemes;
  int footerTextColor;
  PremiumModel.Gradient headerBackground;
  boolean headerIsDark;
  int headerTextColor;
  boolean invertPageIndicatorColor;
  PremiumModel.Gradient productBackground;
  boolean productHeaderIsDark;
  private final Map<PremiumProductFamily, ProductTheme> productThemes = new ArrayMap(4);
  int smallToLargeTextColor;
  
  public static PremiumChooserPalette getPalette(LixManager paramLixManager, Context paramContext)
  {
    paramLixManager = paramLixManager.getTreatment(Lix.PREMIUM_CHOOSER_THEME);
    if (generalColors == null)
    {
      generalColors = new int[] { ContextCompat.getColor(paramContext, 2131624261), ContextCompat.getColor(paramContext, 2131624262) };
      jssColors = new int[] { ContextCompat.getColor(paramContext, 2131624264), ContextCompat.getColor(paramContext, 2131624265) };
      salesColors = new int[] { ContextCompat.getColor(paramContext, 2131624268), ContextCompat.getColor(paramContext, 2131624269) };
      talentColors = new int[] { ContextCompat.getColor(paramContext, 2131624270), ContextCompat.getColor(paramContext, 2131624271) };
      linkColor = ContextCompat.getColor(paramContext, 2131624266);
      offWhite = ContextCompat.getColor(paramContext, 2131624267);
      darkHeaderBackground = new PremiumModel.Gradient(GradientDrawable.Orientation.BL_TR, new int[] { ContextCompat.getColor(paramContext, 2131624255), ContextCompat.getColor(paramContext, 2131624256), ContextCompat.getColor(paramContext, 2131624257) });
      imageHeaderBackground = new PremiumModel.Gradient(TOP_BOTTOM, new int[] { ContextCompat.getColor(paramContext, 2131623970), ContextCompat.getColor(paramContext, 2131624263) });
      captionColor = ContextCompat.getColor(paramContext, 2131623959);
    }
    if ("theme_1".equals(paramLixManager))
    {
      if (dark == null)
      {
        paramLixManager = new PremiumChooserPalette();
        buttonThemes = new SubscriptionModel.ButtonThemes(2130969145, 2130969143);
        headerBackground = new PremiumModel.Gradient(offWhite);
        headerIsDark = false;
        headerTextColor = -16777216;
        footerTextColor = captionColor;
        productBackground = WHITE;
        productHeaderIsDark = true;
        productThemes.put(PremiumProductFamily.GENERAL, newDarkProductTheme(generalColors));
        productThemes.put(PremiumProductFamily.JSS, newDarkProductTheme(jssColors));
        productThemes.put(PremiumProductFamily.SALES, newDarkProductTheme(salesColors));
        productThemes.put(PremiumProductFamily.TALENT, newDarkProductTheme(talentColors));
        smallToLargeTextColor = linkColor;
        invertPageIndicatorColor = false;
        dark = paramLixManager;
      }
      return dark;
    }
    if (("image".equals(paramLixManager)) || ("image_download".equals(paramLixManager)))
    {
      if (lightWithImage == null)
      {
        paramLixManager = newLightPalette();
        headerBackground = imageHeaderBackground;
        footerTextColor = captionColor;
        lightWithImage = paramLixManager;
      }
      return lightWithImage;
    }
    if (light == null) {
      light = newLightPalette();
    }
    return light;
  }
  
  private static ProductTheme newDarkProductTheme(int[] paramArrayOfInt)
  {
    return new ProductTheme(new PremiumModel.Gradient(TOP_BOTTOM, paramArrayOfInt), new PremiumModel.Gradient(0), new PremiumModel.Gradient(LEFT_RIGHT, paramArrayOfInt), -1, -1);
  }
  
  private static PremiumChooserPalette newLightPalette()
  {
    PremiumChooserPalette localPremiumChooserPalette = new PremiumChooserPalette();
    productHeaderIsDark = false;
    buttonThemes = new SubscriptionModel.ButtonThemes(2130969144, 2130969142);
    headerBackground = darkHeaderBackground;
    headerIsDark = true;
    headerTextColor = -1;
    footerTextColor = -1;
    productBackground = WHITE;
    productThemes.put(PremiumProductFamily.GENERAL, newLightProductTheme(generalColors, 0));
    productThemes.put(PremiumProductFamily.JSS, newLightProductTheme(jssColors, 0));
    productThemes.put(PremiumProductFamily.SALES, newLightProductTheme(salesColors, 0));
    productThemes.put(PremiumProductFamily.TALENT, newLightProductTheme(talentColors, 1));
    smallToLargeTextColor = linkColor;
    invertPageIndicatorColor = true;
    return localPremiumChooserPalette;
  }
  
  private static ProductTheme newLightProductTheme(int[] paramArrayOfInt, int paramInt)
  {
    PremiumModel.Gradient localGradient = new PremiumModel.Gradient(LEFT_RIGHT, paramArrayOfInt);
    return new ProductTheme(WHITE, localGradient, localGradient, -16777216, paramArrayOfInt[paramInt]);
  }
  
  final ProductTheme getProductTheme(PremiumProductFamily paramPremiumProductFamily)
  {
    ProductTheme localProductTheme = (ProductTheme)productThemes.get(paramPremiumProductFamily);
    paramPremiumProductFamily = localProductTheme;
    if (localProductTheme == null) {
      paramPremiumProductFamily = (ProductTheme)productThemes.get(PremiumProductFamily.GENERAL);
    }
    return paramPremiumProductFamily;
  }
  
  static final class ProductTheme
  {
    final PremiumModel.Gradient footerDivider;
    final PremiumModel.Gradient headerBackground;
    final PremiumModel.Gradient headerDivider;
    final int headerTextColor;
    final int nameColor;
    
    public ProductTheme(PremiumModel.Gradient paramGradient1, PremiumModel.Gradient paramGradient2, PremiumModel.Gradient paramGradient3, int paramInt1, int paramInt2)
    {
      headerBackground = paramGradient1;
      headerDivider = paramGradient2;
      headerTextColor = paramInt1;
      nameColor = paramInt2;
      footerDivider = paramGradient3;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserPalette
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */