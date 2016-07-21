package com.linkedin.android.infra.shared;

import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import java.util.Collection;
import java.util.List;

public final class CollectionUtils
{
  public static <T> void addItemIfNonNull(List<T> paramList, T paramT)
  {
    if (paramT != null) {
      paramList.add(paramT);
    }
  }
  
  public static int getPagingTotal(CollectionTemplate paramCollectionTemplate)
  {
    if ((paramCollectionTemplate != null) && (paging != null) && (paging.hasTotal)) {
      return paging.total;
    }
    return 0;
  }
  
  public static boolean isEmpty(CollectionTemplate paramCollectionTemplate)
  {
    return (paramCollectionTemplate == null) || (elements == null) || (elements.isEmpty());
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean isNonEmpty(CollectionTemplate paramCollectionTemplate)
  {
    return (paramCollectionTemplate != null) && (elements != null) && (!elements.isEmpty());
  }
  
  public static boolean isNonEmpty(Collection paramCollection)
  {
    return !isEmpty(paramCollection);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.CollectionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */