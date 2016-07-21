package android.support.v4.view;

import android.view.LayoutInflater;

class LayoutInflaterCompat$LayoutInflaterCompatImplBase
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

/* Location:
 * Qualified Name:     android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */