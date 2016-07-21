package com.linkedin.android.feed.endor.datamodel.transformer.service;

import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Collections;

public final class ModelTransformerConstants
{
  private static final ModelsData EMPTY_LIST_DATA = new ModelsData(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
  
  public static <P extends RecordTemplate<P>, D, V extends ViewModel> ModelsData<P, D, V> emptyListData()
  {
    return EMPTY_LIST_DATA;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformerConstants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */