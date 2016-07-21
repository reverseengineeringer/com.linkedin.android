package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class ShareUpdateContent$Content$Builder
{
  private boolean hasShareArticleValue = false;
  private boolean hasShareDocumentValue = false;
  private boolean hasShareImageValue = false;
  private boolean hasShareJobValue = false;
  private boolean hasShareTextValue = false;
  private boolean hasShareVideoValue = false;
  private ShareArticle shareArticleValue = null;
  private ShareDocument shareDocumentValue = null;
  private ShareImage shareImageValue = null;
  private ShareJob shareJobValue = null;
  private ShareText shareTextValue = null;
  private ShareVideo shareVideoValue = null;
  
  public final ShareUpdateContent.Content build()
    throws BuilderException
  {
    int j = 0;
    if (hasShareTextValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasShareArticleValue) {
      i = j + 1;
    }
    j = i;
    if (hasShareDocumentValue) {
      j = i + 1;
    }
    i = j;
    if (hasShareImageValue) {
      i = j + 1;
    }
    j = i;
    if (hasShareJobValue) {
      j = i + 1;
    }
    i = j;
    if (hasShareVideoValue) {
      i = j + 1;
    }
    if (i > 1) {
      throw new UnionMemberCountException("Content", i);
    }
    return new ShareUpdateContent.Content(shareTextValue, shareArticleValue, shareDocumentValue, shareImageValue, shareJobValue, shareVideoValue, hasShareTextValue, hasShareArticleValue, hasShareDocumentValue, hasShareImageValue, hasShareJobValue, hasShareVideoValue);
  }
  
  public final Builder setShareArticleValue(ShareArticle paramShareArticle)
  {
    if (paramShareArticle == null)
    {
      hasShareArticleValue = false;
      shareArticleValue = null;
      return this;
    }
    hasShareArticleValue = true;
    shareArticleValue = paramShareArticle;
    return this;
  }
  
  public final Builder setShareImageValue(ShareImage paramShareImage)
  {
    if (paramShareImage == null)
    {
      hasShareImageValue = false;
      shareImageValue = null;
      return this;
    }
    hasShareImageValue = true;
    shareImageValue = paramShareImage;
    return this;
  }
  
  public final Builder setShareTextValue(ShareText paramShareText)
  {
    if (paramShareText == null)
    {
      hasShareTextValue = false;
      shareTextValue = null;
      return this;
    }
    hasShareTextValue = true;
    shareTextValue = paramShareText;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */