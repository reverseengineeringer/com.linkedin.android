package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;

public final class Action$AdditionalOptions
  implements UnionTemplate<AdditionalOptions>
{
  public static final ActionBuilder.AdditionalOptionsBuilder BUILDER = ActionBuilder.AdditionalOptionsBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final Action actionValue;
  public final boolean hasActionValue;
  public final boolean hasOpenLinkValue;
  public final OpenLink openLinkValue;
  
  public Action$AdditionalOptions(Action paramAction, OpenLink paramOpenLink, boolean paramBoolean1, boolean paramBoolean2)
  {
    actionValue = paramAction;
    openLinkValue = paramOpenLink;
    hasActionValue = paramBoolean1;
    hasOpenLinkValue = paramBoolean2;
  }
  
  public final AdditionalOptions accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasActionValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.semaphore.models.Action");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = actionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label149;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasOpenLinkValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.semaphore.models.OpenLink");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = openLinkValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new AdditionalOptions((Action)localObject2, (OpenLink)localObject1, bool1, bool2);
      localObject1 = (Action)paramDataProcessor.processDataTemplate(actionValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (OpenLink)paramDataProcessor.processDataTemplate(openLinkValue);
      break label95;
    }
    label181:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AdditionalOptions)paramObject;
      if (actionValue != null)
      {
        if (actionValue.equals(actionValue)) {}
      }
      else {
        while (actionValue != null) {
          return false;
        }
      }
      if (openLinkValue == null) {
        break;
      }
    } while (openLinkValue.equals(openLinkValue));
    for (;;)
    {
      return false;
      if (openLinkValue == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (actionValue != null) {}
    for (int i = actionValue.hashCode();; i = 0)
    {
      if (openLinkValue != null) {
        j = openLinkValue.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class Builder
  {
    public Action actionValue = null;
    public boolean hasActionValue = false;
    public boolean hasOpenLinkValue = false;
    public OpenLink openLinkValue = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.Action.AdditionalOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */