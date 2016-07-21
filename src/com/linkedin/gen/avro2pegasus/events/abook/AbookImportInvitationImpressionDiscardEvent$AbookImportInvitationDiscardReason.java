package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;

public final class AbookImportInvitationImpressionDiscardEvent$AbookImportInvitationDiscardReason
  implements UnionTemplate<AbookImportInvitationDiscardReason>
{
  public static final AbookImportInvitationImpressionDiscardEventBuilder.AbookImportInvitationDiscardReasonBuilder BUILDER = AbookImportInvitationImpressionDiscardEventBuilder.AbookImportInvitationDiscardReasonBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final AbookImportInvitationDiscardReason abookImportInvitationDiscardReasonValue;
  public final boolean hasAbookImportInvitationDiscardReasonValue;
  
  public AbookImportInvitationImpressionDiscardEvent$AbookImportInvitationDiscardReason(AbookImportInvitationDiscardReason paramAbookImportInvitationDiscardReason, boolean paramBoolean)
  {
    abookImportInvitationDiscardReasonValue = paramAbookImportInvitationDiscardReason;
    hasAbookImportInvitationDiscardReasonValue = paramBoolean;
    _cachedId = null;
  }
  
  public final AbookImportInvitationDiscardReason accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    if (hasAbookImportInvitationDiscardReasonValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.avro2pegasus.events.abook.AbookImportInvitationDiscardReason");
      paramDataProcessor.processEnum(abookImportInvitationDiscardReasonValue);
    }
    paramDataProcessor.endUnion();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new AbookImportInvitationDiscardReason(abookImportInvitationDiscardReasonValue, hasAbookImportInvitationDiscardReasonValue);
    }
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
      paramObject = (AbookImportInvitationDiscardReason)paramObject;
      if (abookImportInvitationDiscardReasonValue == null) {
        break;
      }
    } while (abookImportInvitationDiscardReasonValue.equals(abookImportInvitationDiscardReasonValue));
    for (;;)
    {
      return false;
      if (abookImportInvitationDiscardReasonValue == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (abookImportInvitationDiscardReasonValue != null) {}
    for (int i = abookImportInvitationDiscardReasonValue.hashCode();; i = 0)
    {
      i += 527;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
  {
    public AbookImportInvitationDiscardReason abookImportInvitationDiscardReasonValue = null;
    public boolean hasAbookImportInvitationDiscardReasonValue = false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */