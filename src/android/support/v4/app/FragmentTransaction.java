package android.support.v4.app;

public abstract class FragmentTransaction
{
  public abstract FragmentTransaction add(int paramInt, Fragment paramFragment);
  
  public abstract FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString);
  
  public abstract FragmentTransaction add(Fragment paramFragment, String paramString);
  
  public abstract FragmentTransaction addToBackStack(String paramString);
  
  public abstract FragmentTransaction attach(Fragment paramFragment);
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract FragmentTransaction detach(Fragment paramFragment);
  
  public abstract FragmentTransaction disallowAddToBackStack();
  
  public abstract boolean isEmpty();
  
  public abstract FragmentTransaction remove(Fragment paramFragment);
  
  public abstract FragmentTransaction replace(int paramInt, Fragment paramFragment);
  
  public abstract FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString);
  
  public abstract FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract FragmentTransaction setCustomAnimations$228f0801();
  
  public abstract FragmentTransaction setTransition$9d93138();
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentTransaction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */