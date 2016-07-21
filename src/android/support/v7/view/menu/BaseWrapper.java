package android.support.v7.view.menu;

public class BaseWrapper<T>
{
  public final T mWrappedObject;
  
  BaseWrapper(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    mWrappedObject = paramT;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.BaseWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */