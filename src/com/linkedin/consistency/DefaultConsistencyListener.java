package com.linkedin.consistency;

import android.util.Log;
import com.linkedin.data.lite.DataTemplate;
import java.util.Locale;

public abstract class DefaultConsistencyListener<MODEL extends DataTemplate<MODEL>>
  implements ConsistencyManagerListener
{
  private static final String TAG = DefaultConsistencyListener.class.getSimpleName();
  public MODEL currentModel;
  private Class<? extends DataTemplate> modelClass;
  
  public DefaultConsistencyListener(MODEL paramMODEL)
  {
    modelClass = paramMODEL.getClass();
    currentModel = paramMODEL;
  }
  
  public final DataTemplate<MODEL> currentModel()
  {
    return currentModel;
  }
  
  public void handleTypeDiscrepancy(Class<? extends DataTemplate> paramClass1, Class<? extends DataTemplate> paramClass2, String paramString)
  {
    paramClass1 = String.format(Locale.US, "Received a [%s] type of updated model but we currently have a [%s] type of model for id [%s]!", new Object[] { paramClass1, paramClass2, paramString });
    Log.e(TAG, paramClass1, new IllegalArgumentException(paramClass1));
  }
  
  public void modelDeleted$552c4e01() {}
  
  public final void modelUpdated(DataTemplate paramDataTemplate)
  {
    Object localObject = null;
    if (paramDataTemplate == null)
    {
      currentModel = null;
      modelDeleted$552c4e01();
      return;
    }
    if (paramDataTemplate.getClass().equals(modelClass))
    {
      currentModel = paramDataTemplate;
      safeModelUpdated(currentModel);
      return;
    }
    Class localClass1 = modelClass;
    Class localClass2 = paramDataTemplate.getClass();
    if (currentModel == null) {}
    for (paramDataTemplate = (DataTemplate)localObject;; paramDataTemplate = currentModel.id())
    {
      handleTypeDiscrepancy(localClass1, localClass2, paramDataTemplate);
      return;
    }
  }
  
  public abstract void safeModelUpdated(MODEL paramMODEL);
}

/* Location:
 * Qualified Name:     com.linkedin.consistency.DefaultConsistencyListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */