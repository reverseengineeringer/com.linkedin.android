package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

public final class LayoutInflaterCompat
{
  static final LayoutInflaterCompatImpl IMPL = new LayoutInflaterCompatImplBase();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      IMPL = new LayoutInflaterCompatImplV21();
      return;
    }
    if (i >= 11)
    {
      IMPL = new LayoutInflaterCompatImplV11();
      return;
    }
  }
  
  public static LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater)
  {
    return IMPL.getFactory(paramLayoutInflater);
  }
  
  public static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    IMPL.setFactory(paramLayoutInflater, paramLayoutInflaterFactory);
  }
  
  static abstract interface LayoutInflaterCompatImpl
  {
    public abstract LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater);
    
    public abstract void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory);
  }
  
  static class LayoutInflaterCompatImplBase
    implements LayoutInflaterCompat.LayoutInflaterCompatImpl
  {
    public final LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater)
    {
      paramLayoutInflater = paramLayoutInflater.getFactory();
      if ((paramLayoutInflater instanceof LayoutInflaterCompatBase.FactoryWrapper)) {
        return mDelegateFactory;
      }
      return null;
    }
    
    public void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
    {
      if (paramLayoutInflaterFactory != null) {}
      for (paramLayoutInflaterFactory = new LayoutInflaterCompatBase.FactoryWrapper(paramLayoutInflaterFactory);; paramLayoutInflaterFactory = null)
      {
        paramLayoutInflater.setFactory(paramLayoutInflaterFactory);
        return;
      }
    }
  }
  
  static class LayoutInflaterCompatImplV11
    extends LayoutInflaterCompat.LayoutInflaterCompatImplBase
  {
    public void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
    {
      if (paramLayoutInflaterFactory != null) {}
      for (paramLayoutInflaterFactory = new LayoutInflaterCompatHC.FactoryWrapperHC(paramLayoutInflaterFactory);; paramLayoutInflaterFactory = null)
      {
        paramLayoutInflater.setFactory2(paramLayoutInflaterFactory);
        LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
        if (!(localFactory instanceof LayoutInflater.Factory2)) {
          break;
        }
        LayoutInflaterCompatHC.forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        return;
      }
      LayoutInflaterCompatHC.forceSetFactory2(paramLayoutInflater, paramLayoutInflaterFactory);
    }
  }
  
  static final class LayoutInflaterCompatImplV21
    extends LayoutInflaterCompat.LayoutInflaterCompatImplV11
  {
    public final void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
    {
      if (paramLayoutInflaterFactory != null) {}
      for (paramLayoutInflaterFactory = new LayoutInflaterCompatHC.FactoryWrapperHC(paramLayoutInflaterFactory);; paramLayoutInflaterFactory = null)
      {
        paramLayoutInflater.setFactory2(paramLayoutInflaterFactory);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.LayoutInflaterCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */