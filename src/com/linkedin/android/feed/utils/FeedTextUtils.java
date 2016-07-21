package com.linkedin.android.feed.utils;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.linkedin.android.feed.mentions.MentionableImpl;
import com.linkedin.android.feed.shared.HashtagUtils;
import com.linkedin.android.feed.shared.HashtagUtils.Hashtag;
import com.linkedin.android.feed.shared.LinkUtils;
import com.linkedin.android.feed.shared.LinkUtils.Link;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.spans.EntityClickableSpan;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Entity;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText.Builder;
import com.linkedin.android.spyglass.mentions.MentionSpan;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class FeedTextUtils
{
  public static AnnotatedText getAnnotatedTextFromMentionsEditable(Editable paramEditable)
  {
    int m;
    String str;
    MentionSpan[] arrayOfMentionSpan;
    ArrayList localArrayList;
    int n;
    int j;
    int i;
    int i1;
    int i2;
    for (;;)
    {
      try
      {
        m = paramEditable.length();
        str = paramEditable.toString();
        arrayOfMentionSpan = (MentionSpan[])paramEditable.getSpans(0, m, MentionSpan.class);
        Arrays.sort(arrayOfMentionSpan, new Comparator() {});
        localArrayList = new ArrayList();
        n = 0;
        if (arrayOfMentionSpan.length > 0)
        {
          j = 0;
          if (j < 0) {
            break label168;
          }
          i = paramEditable.getSpanStart(arrayOfMentionSpan[0]);
          k = j;
          if (n >= m) {
            break label361;
          }
          if (n >= i) {
            break;
          }
          localObject1 = new AnnotatedString.Builder().setValue(str.substring(n, i)).build(RecordTemplate.Flavor.RECORD);
          j = i;
          i1 = i;
          i2 = k;
          localArrayList.add(localObject1);
          k = i2;
          i = i1;
          n = j;
          continue;
        }
        j = -1;
      }
      catch (BuilderException paramEditable)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(paramEditable));
        return null;
      }
      continue;
      label168:
      i = m;
      k = j;
    }
    Object localObject2 = arrayOfMentionSpan[k];
    int i3 = paramEditable.getSpanEnd(localObject2);
    Object localObject1 = null;
    if ((mention instanceof MentionableImpl)) {
      localObject1 = mention).entity;
    }
    localObject2 = new AnnotatedString.Builder().setValue(str.substring(i, i3));
    if (localObject1 == null)
    {
      hasEntity = false;
      entity = null;
      label256:
      localObject2 = ((AnnotatedString.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
      n = i3;
      if (arrayOfMentionSpan.length <= k + 1) {
        break label379;
      }
      i = k + 1;
      label283:
      if (i < 0) {
        break label384;
      }
    }
    label361:
    label379:
    label384:
    for (int k = paramEditable.getSpanStart(arrayOfMentionSpan[i]);; k = m)
    {
      localObject1 = localObject2;
      i2 = i;
      i1 = k;
      j = n;
      if (k >= i3) {
        break;
      }
      Util.safeThrow$7a8b4789(new RuntimeException("MentionSpan are overlapping when they should not be."));
      localObject1 = localObject2;
      i2 = i;
      i1 = k;
      j = n;
      break;
      hasEntity = true;
      entity = ((AnnotatedString.Entity)localObject1);
      break label256;
      paramEditable = new AnnotatedText.Builder().setValues(localArrayList).build();
      return paramEditable;
      i = -1;
      break label283;
    }
  }
  
  public static SpannableStringBuilder getSpannableTextFromAnnotatedText(AnnotatedText paramAnnotatedText, Update paramUpdate, FragmentComponent paramFragmentComponent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramAnnotatedText == null) || (CollectionUtils.isEmpty(values))) {
      return new SpannableStringBuilder();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramAnnotatedText = values;
    int i = 0;
    if (i < paramAnnotatedText.size())
    {
      Object localObject = (AnnotatedString)paramAnnotatedText.get(i);
      String str;
      int j;
      int k;
      if (localObject != null)
      {
        str = value;
        j = localSpannableStringBuilder.length();
        k = j + str.length();
        localSpannableStringBuilder.append(str);
        if ((entity == null) || (k <= j)) {
          break label147;
        }
        localSpannableStringBuilder.setSpan(EntityClickableSpan.getSpan(entity, paramFragmentComponent, paramUpdate, paramBoolean3), j, k, 33);
      }
      for (;;)
      {
        i += 1;
        break;
        label147:
        if (paramBoolean1)
        {
          localObject = LinkUtils.getWebLinks(str);
          j = 0;
          while (j < ((List)localObject).size())
          {
            LinkUtils.Link localLink = (LinkUtils.Link)((List)localObject).get(j);
            k = localSpannableStringBuilder.length();
            int m = str.length();
            localSpannableStringBuilder.setSpan(FeedTracking.newUrlSpan(url, paramFragmentComponent, paramUpdate, paramBoolean2), k - m + start, k - m + end, 33);
            j += 1;
          }
        }
      }
    }
    trim(localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  public static SpannableStringBuilder getSpannableTextFromAnnotatedText$6851e591(AnnotatedText paramAnnotatedText, Update paramUpdate, FragmentComponent paramFragmentComponent)
  {
    return getSpannableTextFromAnnotatedText(paramAnnotatedText, paramUpdate, paramFragmentComponent, true, false, false);
  }
  
  public static SpannableStringBuilder getTextWithHashtagSpans(FragmentComponent paramFragmentComponent, CharSequence paramCharSequence, Update paramUpdate, Comment paramComment)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), ClickableSpan.class);
    paramCharSequence = HashtagUtils.getHashtags(paramCharSequence);
    int i = 0;
    while (i < paramCharSequence.size())
    {
      HashtagUtils.Hashtag localHashtag = (HashtagUtils.Hashtag)paramCharSequence.get(i);
      if (!isPartOfExistingSpan(localSpannableStringBuilder, localHashtag, arrayOfClickableSpan)) {
        localSpannableStringBuilder.setSpan(FeedTracking.newHashtagSpan$6c4af0d(text, paramFragmentComponent, paramUpdate, paramComment), start, end, 33);
      }
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private static boolean isPartOfExistingSpan(SpannableStringBuilder paramSpannableStringBuilder, HashtagUtils.Hashtag paramHashtag, ClickableSpan[] paramArrayOfClickableSpan)
  {
    boolean bool2 = false;
    int j = paramArrayOfClickableSpan.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        ClickableSpan localClickableSpan = paramArrayOfClickableSpan[i];
        int k = paramSpannableStringBuilder.getSpanStart(localClickableSpan);
        int m = paramSpannableStringBuilder.getSpanEnd(localClickableSpan);
        int n = start;
        int i1 = end;
        if (((k <= n) && (n <= m)) || ((k <= i1) && (i1 <= m)) || ((n <= k) && (i1 >= m))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void setTextIsSelectable$352fc170(ApplicationComponent paramApplicationComponent, TextView paramTextView)
  {
    if (FeedLixHelper.isEnabled(paramApplicationComponent.lixManager(), Lix.FEED_SELECTABLE_TEXT)) {
      paramTextView.setTextIsSelectable(true);
    }
  }
  
  private static void trim(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (TextUtils.getTrimmedLength(paramSpannableStringBuilder) == 0) {
      paramSpannableStringBuilder.clear();
    }
    int i;
    do
    {
      return;
      i = 0;
      int j = paramSpannableStringBuilder.length();
      while ((i < j - 1) && (Character.isWhitespace(paramSpannableStringBuilder.charAt(i)))) {
        i += 1;
      }
      if (i > 0) {
        paramSpannableStringBuilder.delete(0, i);
      }
      i = paramSpannableStringBuilder.length() - 1;
      while ((i > 0) && (Character.isWhitespace(paramSpannableStringBuilder.charAt(i)))) {
        i -= 1;
      }
    } while (i >= paramSpannableStringBuilder.length() - 1);
    paramSpannableStringBuilder.delete(i + 1, paramSpannableStringBuilder.length());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedTextUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */