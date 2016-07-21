package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class MobileApplicationLixTreatment
  implements RecordTemplate<MobileApplicationLixTreatment>
{
  public static final MobileApplicationLixTreatmentBuilder BUILDER = MobileApplicationLixTreatmentBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasTestKey;
  public final boolean hasTreatment;
  public final String testKey;
  public final String treatment;
  
  MobileApplicationLixTreatment(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    testKey = paramString1;
    treatment = paramString2;
    hasTestKey = paramBoolean1;
    hasTreatment = paramBoolean2;
    _cachedId = null;
  }
  
  public final MobileApplicationLixTreatment accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTestKey)
    {
      paramDataProcessor.startRecordField$505cff1c("testKey");
      paramDataProcessor.processString(testKey);
    }
    if (hasTreatment)
    {
      paramDataProcessor.startRecordField$505cff1c("treatment");
      paramDataProcessor.processString(treatment);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new MobileApplicationLixTreatment(testKey, treatment, hasTestKey, hasTreatment);
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
      paramObject = (MobileApplicationLixTreatment)paramObject;
      if (testKey != null)
      {
        if (testKey.equals(testKey)) {}
      }
      else {
        while (testKey != null) {
          return false;
        }
      }
      if (treatment == null) {
        break;
      }
    } while (treatment.equals(treatment));
    for (;;)
    {
      return false;
      if (treatment == null) {
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
    if (testKey != null) {}
    for (int i = testKey.hashCode();; i = 0)
    {
      if (treatment != null) {
        j = treatment.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationLixTreatment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */