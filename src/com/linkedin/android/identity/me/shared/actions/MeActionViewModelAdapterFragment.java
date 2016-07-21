package com.linkedin.android.identity.me.shared.actions;

import android.content.Intent;
import com.linkedin.android.fission.interfaces.FissileModel;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;

public abstract interface MeActionViewModelAdapterFragment<DATA_MODEL extends RecordTemplate<DATA_MODEL>,  extends FissileModel, VIEW_MODEL extends ViewModel>
{
  public abstract DataTemplateBuilder<DATA_MODEL> getDataModelParser();
  
  public abstract VIEW_MODEL getViewModel(String paramString);
  
  public abstract ViewModelArrayAdapter<VIEW_MODEL> getViewModelAdapter();
  
  public abstract void showSnackbar(String paramString, Intent paramIntent, int paramInt1, int paramInt2);
  
  public abstract VIEW_MODEL transformDataModel(int paramInt, VIEW_MODEL paramVIEW_MODEL, DATA_MODEL paramDATA_MODEL);
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actions.MeActionViewModelAdapterFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */