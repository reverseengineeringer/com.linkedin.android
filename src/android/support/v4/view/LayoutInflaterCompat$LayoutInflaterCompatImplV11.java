package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class LayoutInflaterCompat$LayoutInflaterCompatImplV11
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

/* Location:
 * Qualified Name:     android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplV11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */