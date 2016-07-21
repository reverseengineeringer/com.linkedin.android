package com.linkedin.android.feed.endor.datamodel.content;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import java.util.List;

public class AnnotatedTextContentDataModel
  extends ContentDataModel
{
  public AnnotatedText text;
  
  public AnnotatedTextContentDataModel(AnnotatedText paramAnnotatedText)
  {
    text = paramAnnotatedText;
  }
  
  public final SpannableStringBuilder getSpannableTextFromAnnotatedText$6e69c961(Update paramUpdate, FragmentComponent paramFragmentComponent, boolean paramBoolean1, boolean paramBoolean2)
  {
    return FeedTextUtils.getSpannableTextFromAnnotatedText(text, paramUpdate, paramFragmentComponent, paramBoolean1, paramBoolean2, false);
  }
  
  public final boolean hasNonEmptyText()
  {
    return (text != null) && (text.values != null) && (!text.values.isEmpty()) && (!TextUtils.isEmpty(text.values.get(0)).value));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */