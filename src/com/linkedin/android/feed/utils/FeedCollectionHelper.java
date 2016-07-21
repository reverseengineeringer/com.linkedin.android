package com.linkedin.android.feed.utils;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.collections.CollectionTemplateHelper.CollectionTemplateHelperListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;

public final class FeedCollectionHelper<E extends FissileDataModel<E>, M extends FissileDataModel<M>>
  extends CollectionTemplateHelper<E, M>
{
  public FeedCollectionHelper(FlagshipDataManager paramFlagshipDataManager, CollectionTemplateHelper.CollectionTemplateHelperListener<E> paramCollectionTemplateHelperListener, FissileDataModelBuilder<E> paramFissileDataModelBuilder, FissileDataModelBuilder<M> paramFissileDataModelBuilder1, boolean paramBoolean)
  {
    super(paramFlagshipDataManager, paramCollectionTemplateHelperListener, paramFissileDataModelBuilder, paramFissileDataModelBuilder1);
    copyMetadataAndPaging = paramBoolean;
  }
  
  public FeedCollectionHelper(FlagshipDataManager paramFlagshipDataManager, CollectionTemplateHelper.CollectionTemplateHelperListener<E> paramCollectionTemplateHelperListener, CollectionTemplate<E, M> paramCollectionTemplate, FissileDataModelBuilder<E> paramFissileDataModelBuilder, FissileDataModelBuilder<M> paramFissileDataModelBuilder1)
  {
    super(paramFlagshipDataManager, paramCollectionTemplateHelperListener, paramCollectionTemplate, paramFissileDataModelBuilder, paramFissileDataModelBuilder1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedCollectionHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */