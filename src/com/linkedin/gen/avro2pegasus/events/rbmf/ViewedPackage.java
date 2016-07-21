package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ViewedPackage
  implements RecordTemplate<ViewedPackage>
{
  public static final ViewedPackageBuilder BUILDER = ViewedPackageBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<RecommendedEntity> entities;
  public final boolean hasEntities;
  public final boolean hasPackageFlowPosition;
  public final boolean hasPackageGridPosition;
  public final boolean hasPackageId;
  public final boolean hasPackageScreenPosition;
  public final boolean hasPackageType;
  public final int packageFlowPosition;
  public final GridPosition packageGridPosition;
  public final int packageId;
  public final int packageScreenPosition;
  public final PackageRecommendationType packageType;
  
  ViewedPackage(int paramInt1, PackageRecommendationType paramPackageRecommendationType, int paramInt2, int paramInt3, GridPosition paramGridPosition, List<RecommendedEntity> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    packageId = paramInt1;
    packageType = paramPackageRecommendationType;
    packageScreenPosition = paramInt2;
    packageFlowPosition = paramInt3;
    packageGridPosition = paramGridPosition;
    if (paramList == null) {}
    for (paramPackageRecommendationType = null;; paramPackageRecommendationType = Collections.unmodifiableList(paramList))
    {
      entities = paramPackageRecommendationType;
      hasPackageId = paramBoolean1;
      hasPackageType = paramBoolean2;
      hasPackageScreenPosition = paramBoolean3;
      hasPackageFlowPosition = paramBoolean4;
      hasPackageGridPosition = paramBoolean5;
      hasEntities = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  public final ViewedPackage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPackageId)
    {
      paramDataProcessor.startRecordField$505cff1c("packageId");
      paramDataProcessor.processInt(packageId);
    }
    if (hasPackageType)
    {
      paramDataProcessor.startRecordField$505cff1c("packageType");
      paramDataProcessor.processEnum(packageType);
    }
    if (hasPackageScreenPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("packageScreenPosition");
      paramDataProcessor.processInt(packageScreenPosition);
    }
    if (hasPackageFlowPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("packageFlowPosition");
      paramDataProcessor.processInt(packageFlowPosition);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label156:
    int i;
    if (hasPackageGridPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("packageGridPosition");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = packageGridPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label322;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localRecommendedEntity = null;
      bool2 = false;
      if (!hasEntities) {
        break label361;
      }
      paramDataProcessor.startRecordField$505cff1c("entities");
      entities.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localRecommendedEntity;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = entities.iterator();
      label231:
      if (!localIterator.hasNext()) {
        break label347;
      }
      localRecommendedEntity = (RecommendedEntity)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label331;
      }
    }
    label322:
    label331:
    for (RecommendedEntity localRecommendedEntity = localRecommendedEntity.accept(paramDataProcessor);; localRecommendedEntity = (RecommendedEntity)paramDataProcessor.processDataTemplate(localRecommendedEntity))
    {
      if ((localObject1 != null) && (localRecommendedEntity != null)) {
        ((List)localObject1).add(localRecommendedEntity);
      }
      i += 1;
      break label231;
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(packageGridPosition);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label156;
    }
    label347:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label361:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label527;
      }
      try
      {
        if (hasPackageFlowPosition) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage", "packageFlowPosition");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasEntities) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage", "entities");
    }
    if (entities != null)
    {
      paramDataProcessor = entities.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((RecommendedEntity)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage", "entities");
        }
      }
    }
    return new ViewedPackage(packageId, packageType, packageScreenPosition, packageFlowPosition, (GridPosition)localObject2, (List)localObject1, hasPackageId, hasPackageType, hasPackageScreenPosition, hasPackageFlowPosition, bool1, bool2);
    label527:
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
      paramObject = (ViewedPackage)paramObject;
      if (packageId != packageId) {
        return false;
      }
      if (packageType != null)
      {
        if (packageType.equals(packageType)) {}
      }
      else {
        while (packageType != null) {
          return false;
        }
      }
      if (packageScreenPosition != packageScreenPosition) {
        return false;
      }
      if (packageFlowPosition != packageFlowPosition) {
        return false;
      }
      if (packageGridPosition != null)
      {
        if (packageGridPosition.equals(packageGridPosition)) {}
      }
      else {
        while (packageGridPosition != null) {
          return false;
        }
      }
      if (entities == null) {
        break;
      }
    } while (entities.equals(entities));
    for (;;)
    {
      return false;
      if (entities == null) {
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
    int m = packageId;
    int i;
    int n;
    int i1;
    if (packageType != null)
    {
      i = packageType.hashCode();
      n = packageScreenPosition;
      i1 = packageFlowPosition;
      if (packageGridPosition == null) {
        break label125;
      }
    }
    label125:
    for (int j = packageGridPosition.hashCode();; j = 0)
    {
      if (entities != null) {
        k = entities.hashCode();
      }
      i = (j + (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<ViewedPackage>
  {
    private List<RecommendedEntity> entities = null;
    private boolean hasEntities = false;
    private boolean hasPackageFlowPosition = false;
    private boolean hasPackageGridPosition = false;
    public boolean hasPackageId = false;
    private boolean hasPackageScreenPosition = false;
    private boolean hasPackageType = false;
    private int packageFlowPosition = 0;
    private GridPosition packageGridPosition = null;
    public int packageId = 0;
    private int packageScreenPosition = 0;
    private PackageRecommendationType packageType = null;
    
    private ViewedPackage build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ViewedPackage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (entities != null)
      {
        paramFlavor = entities.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((RecommendedEntity)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage", "entities");
              if (!hasPackageFlowPosition) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage", "packageFlowPosition");
              }
              if (hasEntities) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage", "entities");
            }
          }
        }
      }
      return new ViewedPackage(packageId, packageType, packageScreenPosition, packageFlowPosition, packageGridPosition, entities, hasPackageId, hasPackageType, hasPackageScreenPosition, hasPackageFlowPosition, hasPackageGridPosition, hasEntities);
    }
    
    public final ViewedPackage build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Builder setEntities(List<RecommendedEntity> paramList)
    {
      hasEntities = true;
      entities = paramList;
      return this;
    }
    
    public final Builder setPackageFlowPosition(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasPackageFlowPosition = false;
        packageFlowPosition = 0;
        return this;
      }
      hasPackageFlowPosition = true;
      packageFlowPosition = paramInteger.intValue();
      return this;
    }
    
    public final Builder setPackageScreenPosition(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasPackageScreenPosition = false;
        packageScreenPosition = 0;
        return this;
      }
      hasPackageScreenPosition = true;
      packageScreenPosition = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */