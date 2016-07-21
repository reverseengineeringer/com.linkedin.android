package com.linkedin.android.growth.lego;

import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;

public abstract class LegoDataProvider<STATE extends DataProvider.State>
  extends DataProvider<STATE, DataProvider.DataProviderListener>
{
  public LegoDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public abstract void prefetchData(WidgetContent paramWidgetContent, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */