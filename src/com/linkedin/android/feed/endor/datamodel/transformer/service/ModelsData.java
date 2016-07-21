package com.linkedin.android.feed.endor.datamodel.transformer.service;

import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.data.lite.RecordTemplate;
import java.util.List;

public final class ModelsData<PEGASUS_MODEL extends RecordTemplate<PEGASUS_MODEL>, DATA_MODEL, VIEW_MODEL extends ViewModel>
{
  public final List<DATA_MODEL> dataModels;
  public final List<PEGASUS_MODEL> inputModels;
  public final List<VIEW_MODEL> viewModels;
  
  public ModelsData(List<PEGASUS_MODEL> paramList, List<DATA_MODEL> paramList1, List<VIEW_MODEL> paramList2)
  {
    inputModels = paramList;
    dataModels = paramList1;
    viewModels = paramList2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */