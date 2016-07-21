package android.databinding;

public final class DataBindingUtil
{
  private static DataBindingComponent sDefaultComponent = null;
  private static DataBinderMapper sMapper = new DataBinderMapper();
  
  public static void setDefaultComponent(DataBindingComponent paramDataBindingComponent)
  {
    sDefaultComponent = paramDataBindingComponent;
  }
}

/* Location:
 * Qualified Name:     android.databinding.DataBindingUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */