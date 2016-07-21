package android.support.v4.view;

import android.view.LayoutInflater;

final class LayoutInflaterCompat$LayoutInflaterCompatImplV21
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

/* Location:
 * Qualified Name:     android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplV21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */