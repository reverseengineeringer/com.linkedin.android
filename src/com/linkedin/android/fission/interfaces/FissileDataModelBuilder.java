package com.linkedin.android.fission.interfaces;

import com.linkedin.data.lite.DataTemplateBuilder;

public abstract interface FissileDataModelBuilder<T extends FissileDataModel<T>>
  extends FissileModelBuilder<T>, DataTemplateBuilder<T>
{}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissileDataModelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */