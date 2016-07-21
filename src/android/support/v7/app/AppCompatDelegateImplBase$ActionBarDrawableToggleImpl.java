package android.support.v7.app;

final class AppCompatDelegateImplBase$ActionBarDrawableToggleImpl
  implements ActionBarDrawerToggle.Delegate
{
  private AppCompatDelegateImplBase$ActionBarDrawableToggleImpl(AppCompatDelegateImplBase paramAppCompatDelegateImplBase) {}
  
  public final void setActionBarDescription(int paramInt)
  {
    ActionBar localActionBar = this$0.getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplBase.ActionBarDrawableToggleImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */