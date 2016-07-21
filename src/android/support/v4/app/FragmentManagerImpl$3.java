package android.support.v4.app;

final class FragmentManagerImpl$3
  implements Runnable
{
  FragmentManagerImpl$3(FragmentManagerImpl paramFragmentManagerImpl, String paramString) {}
  
  public final void run()
  {
    FragmentManagerImpl localFragmentManagerImpl = this$0;
    FragmentHostCallback localFragmentHostCallback = this$0.mHost;
    localFragmentManagerImpl.popBackStackState$68507953(val$name, -1, val$flags);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */