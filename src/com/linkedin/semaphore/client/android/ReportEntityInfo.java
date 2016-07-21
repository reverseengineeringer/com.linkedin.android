package com.linkedin.semaphore.client.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ReportEntityInfo
  implements RecordTemplate<ReportEntityInfo>
{
  public static final ReportEntityInfoBuilder BUILDER = ReportEntityInfoBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String author;
  public final String entity;
  public final boolean hasAuthor;
  public final boolean hasEntity;
  public final boolean hasParent;
  public final String parent;
  
  ReportEntityInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entity = paramString1;
    author = paramString2;
    parent = paramString3;
    hasEntity = paramBoolean1;
    hasAuthor = paramBoolean2;
    hasParent = paramBoolean3;
  }
  
  public final ReportEntityInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      paramDataProcessor.processString(entity);
    }
    if (hasAuthor)
    {
      paramDataProcessor.startRecordField$505cff1c("author");
      paramDataProcessor.processString(author);
    }
    if (hasParent)
    {
      paramDataProcessor.startRecordField$505cff1c("parent");
      paramDataProcessor.processString(parent);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new ReportEntityInfo(entity, author, parent, hasEntity, hasAuthor, hasParent);
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
      paramObject = (ReportEntityInfo)paramObject;
      if (entity != null)
      {
        if (entity.equals(entity)) {}
      }
      else {
        while (entity != null) {
          return false;
        }
      }
      if (author != null)
      {
        if (author.equals(author)) {}
      }
      else {
        while (author != null) {
          return false;
        }
      }
      if (parent == null) {
        break;
      }
    } while (parent.equals(parent));
    for (;;)
    {
      return false;
      if (parent == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (entity != null)
    {
      i = entity.hashCode();
      if (author == null) {
        break label87;
      }
    }
    label87:
    for (int j = author.hashCode();; j = 0)
    {
      if (parent != null) {
        k = parent.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<ReportEntityInfo>
  {
    public String author = null;
    public String entity = null;
    public boolean hasAuthor = false;
    public boolean hasEntity = false;
    public boolean hasParent = false;
    public String parent = null;
    
    public final ReportEntityInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ReportEntityInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ReportEntityInfo(entity, author, parent, hasEntity, hasAuthor, hasParent);
      } while (hasEntity);
      throw new MissingRecordFieldException("com.linkedin.semaphore.client.android.ReportEntityInfo", "entity");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.client.android.ReportEntityInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */