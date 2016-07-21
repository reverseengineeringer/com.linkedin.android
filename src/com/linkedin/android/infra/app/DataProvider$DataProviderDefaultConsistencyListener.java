package com.linkedin.android.infra.app;

import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.DataTemplate;

final class DataProvider$DataProviderDefaultConsistencyListener<T extends DataTemplate<T>>
  extends DefaultConsistencyListener<T>
{
  public DataProvider$DataProviderDefaultConsistencyListener(T paramT)
  {
    super(paramT);
  }
  
  public final void safeModelUpdated(DataTemplate paramDataTemplate) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.DataProvider.DataProviderDefaultConsistencyListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */