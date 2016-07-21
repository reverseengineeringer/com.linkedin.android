package com.linkedin.android.feed.endor.datamodel.transformer.service;

import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.data.lite.RecordTemplate;

public abstract interface ModelTransformedCallback<PEGASUS_MODEL extends RecordTemplate<PEGASUS_MODEL>, DATA_MODEL, VIEW_MODEL extends ViewModel>
{
  public abstract void onModelTransformed(ModelData<PEGASUS_MODEL, DATA_MODEL, VIEW_MODEL> paramModelData);
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */