package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Contributor
  implements RecordTemplate<Contributor>
{
  public static final ContributorBuilder BUILDER = ContributorBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasMemberUrn;
  public final boolean hasName;
  public final String memberUrn;
  public final String name;
  
  Contributor(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    name = paramString1;
    memberUrn = paramString2;
    hasName = paramBoolean1;
    hasMemberUrn = paramBoolean2;
    _cachedId = null;
  }
  
  public final Contributor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasMemberUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("memberUrn");
      paramDataProcessor.processString(memberUrn);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasName) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.Contributor", "name");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new Contributor(name, memberUrn, hasName, hasMemberUrn);
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
      paramObject = (Contributor)paramObject;
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (memberUrn == null) {
        break;
      }
    } while (memberUrn.equals(memberUrn));
    for (;;)
    {
      return false;
      if (memberUrn == null) {
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
    if (name != null) {}
    for (int i = name.hashCode();; i = 0)
    {
      if (memberUrn != null) {
        j = memberUrn.hashCode();
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Contributor>
  {
    public boolean hasMemberUrn = false;
    private boolean hasName = false;
    public String memberUrn = null;
    private String name = null;
    
    public final Contributor build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Contributor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Contributor(name, memberUrn, hasName, hasMemberUrn);
      } while (hasName);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.Contributor", "name");
    }
    
    public final Builder setName(String paramString)
    {
      if (paramString == null)
      {
        hasName = false;
        name = null;
        return this;
      }
      hasName = true;
      name = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.Contributor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */