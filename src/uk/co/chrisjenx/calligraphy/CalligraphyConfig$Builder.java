package uk.co.chrisjenx.calligraphy;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

public final class CalligraphyConfig$Builder
{
  public int attrId;
  boolean customViewCreation;
  public String fontAssetPath;
  public boolean isFontSet;
  Map<Class<? extends TextView>, Integer> mStyleClassMap;
  boolean reflection;
  
  public CalligraphyConfig$Builder()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      reflection = bool;
      customViewCreation = true;
      attrId = R.attr.fontPath;
      isFontSet = false;
      fontAssetPath = null;
      mStyleClassMap = new HashMap();
      return;
    }
  }
  
  public final CalligraphyConfig build()
  {
    if (!TextUtils.isEmpty(fontAssetPath)) {}
    for (boolean bool = true;; bool = false)
    {
      isFontSet = bool;
      return new CalligraphyConfig(this);
    }
  }
}

/* Location:
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */