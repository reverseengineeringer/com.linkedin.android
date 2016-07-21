package com.linkedin.android.infra.network;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.ContextThemeWrapper;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.internationalization.InternationalizationManager;
import com.linkedin.android.internationalization.LocaleManager;
import com.linkedin.android.internationalization.LocalizeStringApi;
import com.linkedin.android.networking.interfaces.InternationalizationApi;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.xmsg.Name;
import com.linkedin.xmsg.XMessageFormat;
import com.linkedin.xmsg.util.PseudoUtils;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

public final class I18NManager
  implements LocalizeStringApi, InternationalizationApi
{
  private final InternationalizationManager internationalizationManager;
  
  @Inject
  public I18NManager(Context paramContext)
  {
    internationalizationManager = new InternationalizationManager(paramContext);
  }
  
  public static CharSequence attachSpan(CharSequence paramCharSequence, ClickableSpan paramClickableSpan, String paramString1, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    int i = TextUtils.indexOf(paramCharSequence, paramString1);
    if (i != -1) {
      localSpannableStringBuilder.delete(i, paramString1.length() + i);
    }
    int j = TextUtils.indexOf(localSpannableStringBuilder, paramString2);
    if (j != -1) {
      localSpannableStringBuilder.delete(j, paramString2.length() + j);
    }
    if ((i != -1) && (j != -1) && (i < j)) {
      localSpannableStringBuilder.setSpan(paramClickableSpan, i, j, 33);
    }
    while ((i == -1) && (j == -1)) {
      return localSpannableStringBuilder;
    }
    Util.safeThrow(new RuntimeException("Tags are not closed in " + paramCharSequence));
    return localSpannableStringBuilder;
  }
  
  public static Name getName(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile == null) {
      return Name.builder();
    }
    return Name.builder().setFirstName(firstName).setLastName(lastName);
  }
  
  public static Name getName(String paramString1, String paramString2)
  {
    return Name.builder().setFirstName(paramString1).setLastName(paramString2);
  }
  
  public static CharSequence prependRightToLeftMarkerCharacter(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof Editable)) {
      return ((Editable)paramCharSequence).insert(0, "‫");
    }
    if ((paramCharSequence instanceof String)) {
      return "‫" + paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    paramCharSequence.insert(0, "‫");
    return paramCharSequence;
  }
  
  public static CharSequence removeSpanTag(CharSequence paramCharSequence, String paramString1, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    int i = TextUtils.indexOf(paramCharSequence, paramString1);
    if (i != -1) {
      localSpannableStringBuilder.delete(i, paramString1.length() + i);
    }
    i = TextUtils.indexOf(localSpannableStringBuilder, paramString2);
    if (i != -1) {
      localSpannableStringBuilder.delete(i, paramString2.length() + i);
    }
    return localSpannableStringBuilder;
  }
  
  public final CharSequence applyMarkerCharacter(CharSequence paramCharSequence)
  {
    if (isRtl()) {
      return prependRightToLeftMarkerCharacter(paramCharSequence);
    }
    if ((paramCharSequence instanceof Editable)) {
      return ((Editable)paramCharSequence).insert(0, "‪");
    }
    if ((paramCharSequence instanceof String)) {
      return "‪" + paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    paramCharSequence.insert(0, "‪");
    return new SpannedString(paramCharSequence);
  }
  
  public final String getCurrentLocale()
  {
    return internationalizationManager.localeManager.getCurrentLinkedInFrontEndLocaleString();
  }
  
  public final String getNamedString(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("givenName", paramString1);
    localArrayMap.put("familyName", paramString2);
    localArrayMap.put("maidenName", paramString3);
    return getString(paramInt, localArrayMap);
  }
  
  public final Spanned getSpannedString(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1 = internationalizationManager;
    paramVarArgs = Html.fromHtml(((InternationalizationManager)localObject1).getString(paramInt, paramVarArgs), null, xMsgTagHandler);
    if (!ArtDeco.shouldFallback()) {
      return paramVarArgs;
    }
    paramVarArgs = new SpannableStringBuilder(paramVarArgs);
    paramInt = paramVarArgs.length() - 1;
    if (paramInt > 0)
    {
      localObject1 = (StyleSpan[])paramVarArgs.getSpans(0, paramInt, StyleSpan.class);
      int j = localObject1.length;
      paramInt = i;
      if (paramInt < j)
      {
        Object localObject2 = localObject1[paramInt];
        if (((((StyleSpan)localObject2).getStyle() == 1) || (((StyleSpan)localObject2).getStyle() == 3)) && (ArtDeco.isCJK())) {
          paramVarArgs.removeSpan(localObject2);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (((StyleSpan)localObject2).getStyle() == 2) {
            paramVarArgs.removeSpan(localObject2);
          }
        }
      }
    }
    return paramVarArgs;
  }
  
  public final String getString(int paramInt)
  {
    return internationalizationManager.getString(paramInt);
  }
  
  public final String getString(int paramInt, Map<String, Object> paramMap)
  {
    Object localObject = internationalizationManager;
    Locale localLocale = localeManager.getCurrentApplicationLocale();
    boolean bool = ((InternationalizationManager)localObject).isPseudoLocale(localLocale);
    String str;
    if (bool)
    {
      str = wrapper.getString(paramInt);
      if (!bool) {
        break label71;
      }
    }
    label71:
    for (localObject = PseudoUtils.DEFAULT_PSEUDO_LOCALE;; localObject = localeManager.convertAppLocaleToLinkedInLocale(localLocale))
    {
      return XMessageFormat.format(str, paramMap, (Locale)localObject);
      str = appContext.getString(paramInt);
      break;
    }
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return internationalizationManager.getString(paramInt, paramVarArgs);
  }
  
  public final String getString(String paramString, Object... paramVarArgs)
  {
    return internationalizationManager.getString(paramString, paramVarArgs);
  }
  
  public final boolean isRtl()
  {
    return InternationalizationManager.isRtl(internationalizationManager.localeManager.getCurrentApplicationLocale());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.I18NManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */