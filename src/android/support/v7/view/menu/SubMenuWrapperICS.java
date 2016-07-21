package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class SubMenuWrapperICS
  extends MenuWrapperICS
  implements SubMenu
{
  SubMenuWrapperICS(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    super(paramContext, paramSupportSubMenu);
  }
  
  public final void clearHeader()
  {
    ((SupportSubMenu)mWrappedObject).clearHeader();
  }
  
  public final MenuItem getItem()
  {
    return getMenuItemWrapper(((SupportSubMenu)mWrappedObject).getItem());
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    ((SupportSubMenu)mWrappedObject).setHeaderIcon(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((SupportSubMenu)mWrappedObject).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    ((SupportSubMenu)mWrappedObject).setHeaderTitle(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((SupportSubMenu)mWrappedObject).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    ((SupportSubMenu)mWrappedObject).setHeaderView(paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    ((SupportSubMenu)mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    ((SupportSubMenu)mWrappedObject).setIcon(paramDrawable);
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.SubMenuWrapperICS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */