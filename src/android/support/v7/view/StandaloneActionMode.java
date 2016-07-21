package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class StandaloneActionMode
  extends ActionMode
  implements MenuBuilder.Callback
{
  private ActionMode.Callback mCallback;
  private Context mContext;
  private ActionBarContextView mContextView;
  private WeakReference<View> mCustomView;
  private boolean mFinished;
  private boolean mFocusable;
  private MenuBuilder mMenu;
  
  public StandaloneActionMode(Context paramContext, ActionBarContextView paramActionBarContextView, ActionMode.Callback paramCallback, boolean paramBoolean)
  {
    mContext = paramContext;
    mContextView = paramActionBarContextView;
    mCallback = paramCallback;
    paramContext = new MenuBuilder(paramActionBarContextView.getContext());
    mDefaultShowAsAction = 1;
    mMenu = paramContext;
    mMenu.setCallback(this);
    mFocusable = paramBoolean;
  }
  
  public final void finish()
  {
    if (mFinished) {
      return;
    }
    mFinished = true;
    mContextView.sendAccessibilityEvent(32);
    mCallback.onDestroyActionMode(this);
  }
  
  public final View getCustomView()
  {
    if (mCustomView != null) {
      return (View)mCustomView.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return mMenu;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(mContextView.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return mContextView.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return mContextView.getTitle();
  }
  
  public final void invalidate()
  {
    mCallback.onPrepareActionMode(this, mMenu);
  }
  
  public final boolean isTitleOptional()
  {
    return mContextView.mTitleOptional;
  }
  
  public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return mCallback.onActionItemClicked(this, paramMenuItem);
  }
  
  public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    invalidate();
    mContextView.showOverflowMenu();
  }
  
  public final void setCustomView(View paramView)
  {
    mContextView.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      mCustomView = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    mContextView.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mContextView.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    mContextView.setTitleOptional(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.StandaloneActionMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */