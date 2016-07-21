package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class Option
  implements RecordTemplate<Option>
{
  public static final OptionBuilder BUILDER = OptionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final Action action;
  public final boolean hasAction;
  public final boolean hasOpenLink;
  public final boolean hasSection;
  public final boolean hasType;
  public final OpenLink openLink;
  public final Section section;
  public final OptionType type;
  
  Option(OptionType paramOptionType, Action paramAction, Section paramSection, OpenLink paramOpenLink, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    type = paramOptionType;
    action = paramAction;
    section = paramSection;
    openLink = paramOpenLink;
    hasType = paramBoolean1;
    hasAction = paramBoolean2;
    hasSection = paramBoolean3;
    hasOpenLink = paramBoolean4;
  }
  
  public final Option accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    Object localObject3;
    boolean bool2;
    if (hasAction)
    {
      paramDataProcessor.startRecordField$505cff1c("action");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = action.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label238;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSection)
      {
        paramDataProcessor.startRecordField$505cff1c("section");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label247;
        }
        localObject1 = section.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label265;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label131:
      localObject1 = null;
      bool3 = false;
      if (hasOpenLink)
      {
        paramDataProcessor.startRecordField$505cff1c("openLink");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label274;
        }
        localObject1 = openLink.accept(paramDataProcessor);
        label171:
        if (localObject1 == null) {
          break label292;
        }
      }
    }
    label238:
    label247:
    label265:
    label274:
    label292:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label298;
      }
      return new Option(type, (Action)localObject2, (Section)localObject3, (OpenLink)localObject1, hasType, bool1, bool2, bool3);
      localObject1 = (Action)paramDataProcessor.processDataTemplate(action);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Section)paramDataProcessor.processDataTemplate(section);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (OpenLink)paramDataProcessor.processDataTemplate(openLink);
      break label171;
    }
    label298:
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
      paramObject = (Option)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (action != null)
      {
        if (action.equals(action)) {}
      }
      else {
        while (action != null) {
          return false;
        }
      }
      if (section != null)
      {
        if (section.equals(section)) {}
      }
      else {
        while (section != null) {
          return false;
        }
      }
      if (openLink == null) {
        break;
      }
    } while (openLink.equals(openLink));
    for (;;)
    {
      return false;
      if (openLink == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (type != null)
    {
      i = type.hashCode();
      if (action == null) {
        break label110;
      }
      j = action.hashCode();
      label45:
      if (section == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = section.hashCode();; k = 0)
    {
      if (openLink != null) {
        m = openLink.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.Option
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */