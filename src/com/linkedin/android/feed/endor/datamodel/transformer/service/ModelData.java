package com.linkedin.android.feed.endor.datamodel.transformer.service;

import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.data.lite.RecordTemplate;

public final class ModelData<PEGASUS_MODEL extends RecordTemplate<PEGASUS_MODEL>, DATA_MODEL, VIEW_MODEL extends ViewModel>
{
  public final DATA_MODEL dataModel;
  public final PEGASUS_MODEL inputModel;
  public final VIEW_MODEL viewModel;
  
  public ModelData(PEGASUS_MODEL paramPEGASUS_MODEL, DATA_MODEL paramDATA_MODEL, VIEW_MODEL paramVIEW_MODEL)
  {
    inputModel = paramPEGASUS_MODEL;
    dataModel = paramDATA_MODEL;
    viewModel = paramVIEW_MODEL;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */