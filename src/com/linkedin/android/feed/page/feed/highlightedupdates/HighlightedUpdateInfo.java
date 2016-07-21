package com.linkedin.android.feed.page.feed.highlightedupdates;

public final class HighlightedUpdateInfo
{
  public String type;
  public String urnString;
  
  public HighlightedUpdateInfo(String paramString1, String paramString2)
  {
    urnString = paramString2;
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        type = "DEFAULT";
        return;
        if (paramString1.equals("ACCEPTED_INVITATION"))
        {
          i = 0;
          continue;
          if (paramString1.equals("VIRAL_ACTION")) {
            i = 1;
          }
        }
        break;
      }
    }
    type = "ACCEPTED_INVITATION";
    return;
    type = "VIRAL_ACTION";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdateInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */