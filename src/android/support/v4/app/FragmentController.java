package android.support.v4.app;

public final class FragmentController
{
  final FragmentHostCallback<?> mHost;
  
  FragmentController(FragmentHostCallback<?> paramFragmentHostCallback)
  {
    mHost = paramFragmentHostCallback;
  }
  
  public final boolean execPendingActions()
  {
    return mHost.mFragmentManager.execPendingActions();
  }
  
  final Fragment findFragmentByWho(String paramString)
  {
    return mHost.mFragmentManager.findFragmentByWho(paramString);
  }
  
  public final void noteStateNotSaved()
  {
    mHost.mFragmentManager.mStateSaved = false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */