package com.linkedin.android.feed.endor.ui.transformer;

import java.util.List;

public class FeedTransformerUtils
{
  public static <T> boolean safeAdd(List<T> paramList, T paramT)
  {
    if (paramT != null)
    {
      paramList.add(paramT);
      return true;
    }
    return false;
  }
  
  public static <T> boolean safeAdd$7e084170(List<T> paramList1, List<T> paramList2)
  {
    if ((paramList2 != null) && (paramList2.size() == 2))
    {
      paramList1.addAll(paramList2);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */