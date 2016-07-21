package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AppCompatDrawableManager
{
  private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  private static final ColorFilterLruCache COLOR_FILTER_CACHE;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static AppCompatDrawableManager INSTANCE;
  private static final int[] TINT_CHECKABLE_BUTTON_LIST = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  private ArrayMap<String, InflateDelegate> mDelegates;
  private final Object mDrawableCacheLock = new Object();
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private SparseArray<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, SparseArray<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;
  
  static
  {
    COLOR_FILTER_CACHE = new ColorFilterLruCache();
    COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
    TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_ic_ab_back_mtrl_am_alpha, R.drawable.abc_ic_go_search_api_mtrl_alpha, R.drawable.abc_ic_search_api_mtrl_alpha, R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_ic_clear_mtrl_alpha, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha, R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha, R.drawable.abc_ic_voice_search_api_mtrl_alpha };
    COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[] { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material };
    COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[] { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
    TINT_COLOR_CONTROL_STATE_LIST = new int[] { R.drawable.abc_edit_text_material, R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material, R.drawable.abc_spinner_mtrl_am_alpha, R.drawable.abc_spinner_textfield_background_material, R.drawable.abc_ratingbar_full_material, R.drawable.abc_switch_track_mtrl_alpha, R.drawable.abc_switch_thumb_material, R.drawable.abc_btn_default_mtrl_shape, R.drawable.abc_btn_borderless_material };
  }
  
  private void addDelegate(String paramString, InflateDelegate paramInflateDelegate)
  {
    if (mDelegates == null) {
      mDelegates = new ArrayMap();
    }
    mDelegates.put(paramString, paramInflateDelegate);
  }
  
  private boolean addDrawableToCache(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (mDrawableCacheLock)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)mDrawableCaches.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new LongSparseArray();
          mDrawableCaches.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
  }
  
  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static ColorStateList createButtonColorStateList(Context paramContext, int paramInt)
  {
    int k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int[] arrayOfInt1 = ThemeUtils.DISABLED_STATE_SET;
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    paramContext = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, paramContext, arrayOfInt2, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return assetCookie << 32 | data;
  }
  
  public static AppCompatDrawableManager get()
  {
    if (INSTANCE == null)
    {
      AppCompatDrawableManager localAppCompatDrawableManager = new AppCompatDrawableManager();
      INSTANCE = localAppCompatDrawableManager;
      int i = Build.VERSION.SDK_INT;
      if (i < 23)
      {
        localAppCompatDrawableManager.addDelegate("vector", new VdcInflateDelegate((byte)0));
        if (i >= 11) {
          localAppCompatDrawableManager.addDelegate("animated-vector", new AvdcInflateDelegate((byte)0));
        }
      }
    }
    return INSTANCE;
  }
  
  private Drawable getCachedDrawable(Context paramContext, long paramLong)
  {
    LongSparseArray localLongSparseArray;
    synchronized (mDrawableCacheLock)
    {
      localLongSparseArray = (LongSparseArray)mDrawableCaches.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject2 = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject2 == null) {
        break label136;
      }
      localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
        return paramContext;
      }
    }
    int i = ContainerHelpers.binarySearch(mKeys, mSize, paramLong);
    if ((i >= 0) && (mValues[i] != LongSparseArray.DELETED))
    {
      mValues[i] = LongSparseArray.DELETED;
      mGarbage = true;
    }
    label136:
    return null;
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)COLOR_FILTER_CACHE.get(Integer.valueOf(ColorFilterLruCache.generateCacheKey(paramInt, paramMode)));
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      COLOR_FILTER_CACHE.put(Integer.valueOf(ColorFilterLruCache.generateCacheKey(paramInt, paramMode)), localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  private static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = DEFAULT_MODE;
    }
    localDrawable.setColorFilter(getPorterDuffColorFilter(paramInt, paramDrawable));
  }
  
  public static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }
    label67:
    label83:
    label107:
    label114:
    label134:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      Object localObject1;
      if ((mHasTintList) || (mHasTintMode)) {
        if (mHasTintList)
        {
          localColorStateList = mTintList;
          if (!mHasTintMode) {
            break label107;
          }
          paramTintInfo = mTintMode;
          localObject1 = localObject2;
          if (localColorStateList != null)
          {
            if (paramTintInfo != null) {
              break label114;
            }
            localObject1 = localObject2;
          }
          paramDrawable.setColorFilter((ColorFilter)localObject1);
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label134;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paramTintInfo = DEFAULT_MODE;
        break label67;
        localObject1 = getPorterDuffColorFilter(localColorStateList.getColorForState(paramArrayOfInt, 0), paramTintInfo);
        break label83;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  static boolean tintDrawableUsingColorFilter(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    Object localObject2 = DEFAULT_MODE;
    int j = 0;
    int i = 0;
    int k = -1;
    Object localObject1;
    if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      i = R.attr.colorControlNormal;
      j = 1;
      localObject1 = localObject2;
    }
    while (j != 0)
    {
      localObject2 = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        localObject2 = paramDrawable.mutate();
      }
      ((Drawable)localObject2).setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(paramContext, i), (PorterDuff.Mode)localObject1));
      if (k != -1) {
        ((Drawable)localObject2).setAlpha(k);
      }
      return true;
      if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
      {
        i = R.attr.colorControlActivated;
        j = 1;
        localObject1 = localObject2;
      }
      else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
      {
        i = 16842801;
        j = 1;
        localObject1 = PorterDuff.Mode.MULTIPLY;
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt == R.drawable.abc_list_divider_mtrl_alpha)
        {
          i = 16842800;
          j = 1;
          k = Math.round(40.8F);
          localObject1 = localObject2;
        }
      }
    }
    return false;
  }
  
  public final Drawable getDrawable(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = loadDrawableFromDelegates(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (mTypedValue == null) {
        mTypedValue = new TypedValue();
      }
      TypedValue localTypedValue = mTypedValue;
      paramContext.getResources().getValue(paramInt, localTypedValue, true);
      long l = createCacheKey(localTypedValue);
      localObject2 = getCachedDrawable(paramContext, l);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramInt == R.drawable.abc_cab_background_top_material) {
          localObject2 = new LayerDrawable(new Drawable[] { getDrawable(paramContext, R.drawable.abc_cab_background_internal_bg, false), getDrawable(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha, false) });
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setChangingConfigurations(changingConfigurations);
          addDrawableToCache(paramContext, l, (Drawable)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = tintDrawable(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      DrawableUtils.fixDrawable((Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  public final ColorStateList getTintList(Context paramContext, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    Object localObject3;
    int k;
    if (mTintLists != null)
    {
      localObject1 = (SparseArray)mTintLists.get(paramContext);
      if (localObject1 != null)
      {
        localObject1 = (ColorStateList)((SparseArray)localObject1).get(paramInt);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (paramInt != R.drawable.abc_edit_text_material) {
            break label234;
          }
          localObject1 = ThemeUtils.DISABLED_STATE_SET;
          i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject2 = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
          j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject3 = ThemeUtils.EMPTY_STATE_SET;
          k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        if (mTintLists == null) {
          mTintLists = new WeakHashMap();
        }
        localObject3 = (SparseArray)mTintLists.get(paramContext);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new SparseArray();
          mTintLists.put(paramContext, localObject2);
        }
        ((SparseArray)localObject2).append(paramInt, localObject1);
        localObject2 = localObject1;
      }
      return (ColorStateList)localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
      label234:
      if (paramInt == R.drawable.abc_switch_track_mtrl_alpha)
      {
        localObject1 = ThemeUtils.DISABLED_STATE_SET;
        i = ThemeUtils.getThemeAttrColor(paramContext, 16842800, 0.1F);
        localObject2 = ThemeUtils.CHECKED_STATE_SET;
        j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated, 0.3F);
        localObject3 = ThemeUtils.EMPTY_STATE_SET;
        k = ThemeUtils.getThemeAttrColor(paramContext, 16842800, 0.3F);
        localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
      }
      else
      {
        if (paramInt == R.drawable.abc_switch_thumb_material)
        {
          localObject1 = new int[3][];
          localObject2 = new int[3];
          localObject3 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
          if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
          {
            localObject1[0] = ThemeUtils.DISABLED_STATE_SET;
            localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
            localObject1[1] = ThemeUtils.CHECKED_STATE_SET;
            localObject2[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
            localObject1[2] = ThemeUtils.EMPTY_STATE_SET;
            localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          }
          for (;;)
          {
            localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
            break;
            localObject1[0] = ThemeUtils.DISABLED_STATE_SET;
            localObject2[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
            localObject1[1] = ThemeUtils.CHECKED_STATE_SET;
            localObject2[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
            localObject1[2] = ThemeUtils.EMPTY_STATE_SET;
            localObject2[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
          }
        }
        if (paramInt == R.drawable.abc_btn_default_mtrl_shape)
        {
          localObject1 = createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
        }
        else if (paramInt == R.drawable.abc_btn_borderless_material)
        {
          localObject1 = createButtonColorStateList(paramContext, 0);
        }
        else if (paramInt == R.drawable.abc_btn_colored_material)
        {
          localObject1 = createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
        }
        else if ((paramInt == R.drawable.abc_spinner_mtrl_am_alpha) || (paramInt == R.drawable.abc_spinner_textfield_background_material))
        {
          localObject1 = ThemeUtils.DISABLED_STATE_SET;
          i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject2 = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
          j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject3 = ThemeUtils.EMPTY_STATE_SET;
          k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
        }
        else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt))
        {
          localObject1 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
        }
        else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt))
        {
          i = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
          j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          localObject1 = ThemeUtils.DISABLED_STATE_SET;
          k = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject1 = new ColorStateList(new int[][] { localObject1, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.ACTIVATED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.CHECKED_STATE_SET, ThemeUtils.SELECTED_STATE_SET, ThemeUtils.EMPTY_STATE_SET }, new int[] { k, j, j, j, j, j, i });
        }
        else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt))
        {
          localObject1 = ThemeUtils.DISABLED_STATE_SET;
          i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject2 = ThemeUtils.CHECKED_STATE_SET;
          j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          localObject3 = ThemeUtils.EMPTY_STATE_SET;
          k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i, j, k });
        }
        else if (paramInt == R.drawable.abc_seekbar_thumb_material)
        {
          localObject1 = ThemeUtils.DISABLED_STATE_SET;
          i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlActivated);
          localObject2 = ThemeUtils.EMPTY_STATE_SET;
          j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2 }, new int[] { i, j });
        }
      }
    }
  }
  
  final Drawable loadDrawableFromDelegates(Context paramContext, int paramInt)
  {
    if ((mDelegates != null) && (!mDelegates.isEmpty()))
    {
      Object localObject1;
      Object localObject2;
      if (mKnownDrawableIdTags != null)
      {
        localObject1 = (String)mKnownDrawableIdTags.get(paramInt);
        if ((!"appcompat_skip_skip".equals(localObject1)) && ((localObject1 == null) || (mDelegates.get(localObject1) != null))) {
          break label82;
        }
        localObject2 = null;
      }
      label82:
      TypedValue localTypedValue;
      Object localObject4;
      long l;
      do
      {
        return (Drawable)localObject2;
        mKnownDrawableIdTags = new SparseArray();
        if (mTypedValue == null) {
          mTypedValue = new TypedValue();
        }
        localTypedValue = mTypedValue;
        localObject4 = paramContext.getResources();
        ((Resources)localObject4).getValue(paramInt, localTypedValue, true);
        l = createCacheKey(localTypedValue);
        localObject1 = getCachedDrawable(paramContext, l);
        localObject2 = localObject1;
      } while (localObject1 != null);
      Object localObject3 = localObject1;
      AttributeSet localAttributeSet;
      if (string != null)
      {
        localObject3 = localObject1;
        if (string.toString().endsWith(".xml"))
        {
          localObject3 = localObject1;
          try
          {
            localObject4 = ((Resources)localObject4).getXml(paramInt);
            localObject3 = localObject1;
            localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject4);
            int i;
            do
            {
              localObject3 = localObject1;
              i = ((XmlPullParser)localObject4).next();
            } while ((i != 2) && (i != 1));
            if (i != 2)
            {
              localObject3 = localObject1;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("AppCompatDrawableManager", "Exception while inflating drawable", paramContext);
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (localObject3 != null) {
          break;
        }
        mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
        return (Drawable)localObject3;
        localObject3 = localObject1;
        localObject2 = ((XmlPullParser)localObject4).getName();
        localObject3 = localObject1;
        mKnownDrawableIdTags.append(paramInt, localObject2);
        localObject3 = localObject1;
        InflateDelegate localInflateDelegate = (InflateDelegate)mDelegates.get(localObject2);
        localObject2 = localObject1;
        if (localInflateDelegate != null)
        {
          localObject3 = localObject1;
          localObject2 = localInflateDelegate.createFromXmlInner(paramContext, (XmlPullParser)localObject4, localAttributeSet, paramContext.getTheme());
        }
        localObject3 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          ((Drawable)localObject2).setChangingConfigurations(changingConfigurations);
          localObject3 = localObject2;
          addDrawableToCache(paramContext, l, (Drawable)localObject2);
          localObject3 = localObject2;
        }
      }
    }
    return null;
  }
  
  final Drawable tintDrawable(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = getTintList(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramDrawable = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramDrawable, (ColorStateList)localObject);
      paramContext = null;
      if (paramInt == R.drawable.abc_switch_thumb_material) {
        paramContext = PorterDuff.Mode.MULTIPLY;
      }
      localObject = paramDrawable;
      if (paramContext != null)
      {
        DrawableCompat.setTintMode(paramDrawable, paramContext);
        localObject = paramDrawable;
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject;
        if (paramInt == R.drawable.abc_seekbar_track_material)
        {
          localObject = (LayerDrawable)paramDrawable;
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
          return paramDrawable;
        }
        if ((paramInt == R.drawable.abc_ratingbar_indicator_material) || (paramInt == R.drawable.abc_ratingbar_small_material))
        {
          localObject = (LayerDrawable)paramDrawable;
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  private static final class AvdcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public final Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  private static final class ColorFilterLruCache
    extends LruCache<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache()
    {
      super();
    }
    
    static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
  }
  
  private static abstract interface InflateDelegate
  {
    public abstract Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  private static final class VdcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public final Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = VectorDrawableCompat.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatDrawableManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */