package com.linkedin.android.infra.viewmodel;

@Deprecated
public abstract interface ViewModelListener<VM extends ViewModel>
{
  @Deprecated
  public abstract void onViewModelChanged(VM paramVM);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.viewmodel.ViewModelListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */