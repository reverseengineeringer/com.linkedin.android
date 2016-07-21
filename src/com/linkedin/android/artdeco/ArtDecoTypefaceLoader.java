package com.linkedin.android.artdeco;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public final class ArtDecoTypefaceLoader
{
  private static Typeface georgiaItalic;
  private static Typeface sourceSansProItalic;
  private static Typeface sourceSansProLight;
  private static Typeface sourceSansProRegular;
  private static Typeface sourceSansProSemibold;
  private static Typeface sourceSerifProBold;
  private static boolean wasInFallback;
  
  private static Typeface getFallBackTypeface(int paramInt)
  {
    if (ArtDeco.isCJK()) {
      return Typeface.create(Typeface.DEFAULT, 0);
    }
    return Typeface.create(Typeface.DEFAULT, paramInt);
  }
  
  private static Typeface sourceSansProRegular(AssetManager paramAssetManager)
  {
    if ((sourceSansProRegular == null) || (wasInFallback != ArtDeco.shouldFallback()))
    {
      wasInFallback = ArtDeco.shouldFallback();
      if (!ArtDeco.shouldFallback()) {
        break label38;
      }
    }
    label38:
    for (sourceSansProRegular = getFallBackTypeface(0);; sourceSansProRegular = Typeface.createFromAsset(paramAssetManager, "fonts/SourceSansPro-Regular.ttf")) {
      return sourceSansProRegular;
    }
  }
  
  public static Typeface sourceSansProSemibold(AssetManager paramAssetManager)
  {
    if ((sourceSansProSemibold == null) || (wasInFallback != ArtDeco.shouldFallback()))
    {
      wasInFallback = ArtDeco.shouldFallback();
      if (!ArtDeco.shouldFallback()) {
        break label38;
      }
    }
    label38:
    for (sourceSansProSemibold = getFallBackTypeface(1);; sourceSansProSemibold = Typeface.createFromAsset(paramAssetManager, "fonts/SourceSansPro-Semibold.ttf")) {
      return sourceSansProSemibold;
    }
  }
  
  public static Typeface typefaceForFontPath(AssetManager paramAssetManager, String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return Typeface.createFromAsset(paramAssetManager, paramString);
        if (paramString.equals("fonts/Georgia-Italic.ttf"))
        {
          i = 0;
          continue;
          if (paramString.equals("fonts/SourceSerifPro-Bold.ttf"))
          {
            i = 1;
            continue;
            if (paramString.equals("fonts/SourceSerifPro-Regular.ttf"))
            {
              i = 2;
              continue;
              if (paramString.equals("fonts/SourceSansPro-Italic.ttf"))
              {
                i = 3;
                continue;
                if (paramString.equals("fonts/SourceSansPro-Light.ttf"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("fonts/SourceSansPro-Regular.ttf"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("fonts/SourceSansPro-Semibold.ttf")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    if ((georgiaItalic == null) || (wasInFallback != ArtDeco.shouldFallback()))
    {
      wasInFallback = ArtDeco.shouldFallback();
      if (!ArtDeco.shouldFallback()) {
        break label259;
      }
    }
    label259:
    for (georgiaItalic = getFallBackTypeface(2);; georgiaItalic = Typeface.createFromAsset(paramAssetManager, "fonts/Georgia-Italic.ttf")) {
      return georgiaItalic;
    }
    if ((sourceSerifProBold == null) || (wasInFallback != ArtDeco.shouldFallback()))
    {
      wasInFallback = ArtDeco.shouldFallback();
      if (!ArtDeco.shouldFallback()) {
        break label309;
      }
    }
    label309:
    for (sourceSerifProBold = getFallBackTypeface(1);; sourceSerifProBold = Typeface.createFromAsset(paramAssetManager, "fonts/SourceSerifPro-Bold.ttf")) {
      return sourceSerifProBold;
    }
    return sourceSansProRegular(paramAssetManager);
    if ((sourceSansProItalic == null) || (wasInFallback != ArtDeco.shouldFallback()))
    {
      wasInFallback = ArtDeco.shouldFallback();
      if (!ArtDeco.shouldFallback()) {
        break label364;
      }
    }
    label364:
    for (sourceSansProItalic = getFallBackTypeface(2);; sourceSansProItalic = Typeface.createFromAsset(paramAssetManager, "fonts/SourceSansPro-Italic.ttf")) {
      return sourceSansProItalic;
    }
    if ((sourceSansProLight == null) || (wasInFallback != ArtDeco.shouldFallback()))
    {
      wasInFallback = ArtDeco.shouldFallback();
      if (!ArtDeco.shouldFallback()) {
        break label414;
      }
    }
    label414:
    for (sourceSansProLight = getFallBackTypeface(0);; sourceSansProLight = Typeface.createFromAsset(paramAssetManager, "fonts/SourceSansPro-Light.ttf")) {
      return sourceSansProLight;
    }
    return sourceSansProRegular(paramAssetManager);
    return sourceSansProSemibold(paramAssetManager);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.artdeco.ArtDecoTypefaceLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */