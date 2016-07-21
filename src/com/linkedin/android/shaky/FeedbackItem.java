package com.linkedin.android.shaky;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class FeedbackItem
{
  public static final int BUG = 0;
  public static final int FEATURE = 1;
  public static final int GENERAL = 2;
  public final String description;
  public final int feedbackType;
  public final int icon;
  public final String title;
  
  public FeedbackItem(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    title = paramString1;
    description = paramString2;
    icon = paramInt1;
    feedbackType = paramInt2;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FeedbackType {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.FeedbackItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */