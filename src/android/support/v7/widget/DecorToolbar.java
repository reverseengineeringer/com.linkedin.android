package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;

public abstract interface DecorToolbar
{
  public abstract boolean canShowOverflowMenu();
  
  public abstract void collapseActionView();
  
  public abstract void dismissPopupMenus();
  
  public abstract Context getContext();
  
  public abstract int getDisplayOptions();
  
  public abstract int getDropdownSelectedPosition();
  
  public abstract Menu getMenu();
  
  public abstract int getNavigationMode();
  
  public abstract CharSequence getTitle();
  
  public abstract ViewGroup getViewGroup();
  
  public abstract int getVisibility();
  
  public abstract boolean hasExpandedActionView();
  
  public abstract boolean hideOverflowMenu();
  
  public abstract void initIndeterminateProgress();
  
  public abstract void initProgress();
  
  public abstract boolean isOverflowMenuShowPending();
  
  public abstract boolean isOverflowMenuShowing();
  
  public abstract void setCollapsible(boolean paramBoolean);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public abstract void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView);
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback);
  
  public abstract void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1);
  
  public abstract void setMenuPrepared();
  
  public abstract void setNavigationContentDescription(int paramInt);
  
  public abstract void setNavigationIcon(Drawable paramDrawable);
  
  public abstract void setNavigationMode$13462e();
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void setWindowCallback(Window.Callback paramCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
  
  public abstract ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong);
  
  public abstract boolean showOverflowMenu();
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DecorToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */