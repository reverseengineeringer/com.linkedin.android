package com.linkedin.consistency;

import com.linkedin.data.lite.DataTemplate;

public abstract interface ConsistencyManagerListener
{
  public abstract DataTemplate currentModel();
  
  public abstract void modelUpdated(DataTemplate paramDataTemplate);
}

/* Location:
 * Qualified Name:     com.linkedin.consistency.ConsistencyManagerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */