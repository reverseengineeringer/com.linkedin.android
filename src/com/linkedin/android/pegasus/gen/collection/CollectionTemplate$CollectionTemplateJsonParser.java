package com.linkedin.android.pegasus.gen.collection;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;

public final class CollectionTemplate$CollectionTemplateJsonParser<E extends FissileDataModel<E>, M extends FissileDataModel<M>>
  implements FissileDataModelBuilder<CollectionTemplate<E, M>>, DataTemplateBuilder<CollectionTemplate<E, M>>
{
  private final FissileDataModelBuilder<E> elementModelBuilder;
  private final FissileDataModelBuilder<M> metadataModelBuilder;
  
  public CollectionTemplate$CollectionTemplateJsonParser(FissileDataModelBuilder<E> paramFissileDataModelBuilder, FissileDataModelBuilder<M> paramFissileDataModelBuilder1)
  {
    elementModelBuilder = paramFissileDataModelBuilder;
    metadataModelBuilder = paramFissileDataModelBuilder1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */