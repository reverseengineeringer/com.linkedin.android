package com.linkedin.android.fission.interfaces;

import com.linkedin.data.lite.DataTemplate;

public abstract interface FissileDataModel<T extends DataTemplate<T>>
  extends FissileModel, DataTemplate<T>
{}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissileDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */