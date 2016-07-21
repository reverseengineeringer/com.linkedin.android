package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import java.util.Iterator;
import java.util.List;

public final class ViewedPackage$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */