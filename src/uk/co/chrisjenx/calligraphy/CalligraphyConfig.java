package uk.co.chrisjenx.calligraphy;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class CalligraphyConfig
{
  private static final Map<Class<? extends TextView>, Integer> DEFAULT_STYLES;
  private static CalligraphyConfig sInstance;
  final int mAttrId;
  final Map<Class<? extends TextView>, Integer> mClassStyleAttributeMap;
  final boolean mCustomViewCreation;
  final String mFontPath;
  final boolean mIsFontSet;
  final boolean mReflection;
  
  static
  {
    HashMap localHashMap = new HashMap();
    DEFAULT_STYLES = localHashMap;
    localHashMap.put(TextView.class, Integer.valueOf(16842884));
    DEFAULT_STYLES.put(Button.class, Integer.valueOf(16842824));
    DEFAULT_STYLES.put(EditText.class, Integer.valueOf(16842862));
    DEFAULT_STYLES.put(AutoCompleteTextView.class, Integer.valueOf(16842859));
    DEFAULT_STYLES.put(MultiAutoCompleteTextView.class, Integer.valueOf(16842859));
    DEFAULT_STYLES.put(CheckBox.class, Integer.valueOf(16842860));
    DEFAULT_STYLES.put(RadioButton.class, Integer.valueOf(16842878));
    DEFAULT_STYLES.put(ToggleButton.class, Integer.valueOf(16842827));
  }
  
  protected CalligraphyConfig(Builder paramBuilder)
  {
    mIsFontSet = isFontSet;
    mFontPath = fontAssetPath;
    mAttrId = attrId;
    mReflection = reflection;
    mCustomViewCreation = customViewCreation;
    HashMap localHashMap = new HashMap(DEFAULT_STYLES);
    localHashMap.putAll(mStyleClassMap);
    mClassStyleAttributeMap = Collections.unmodifiableMap(localHashMap);
  }
  
  public static CalligraphyConfig get()
  {
    if (sInstance == null) {
      sInstance = new CalligraphyConfig(new Builder());
    }
    return sInstance;
  }
  
  public static void initDefault(CalligraphyConfig paramCalligraphyConfig)
  {
    sInstance = paramCalligraphyConfig;
  }
  
  public static final class Builder
  {
    public int attrId;
    boolean customViewCreation;
    public String fontAssetPath;
    public boolean isFontSet;
    Map<Class<? extends TextView>, Integer> mStyleClassMap;
    boolean reflection;
    
    public Builder()
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
}

/* Location:
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */