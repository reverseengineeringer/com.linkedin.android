package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public final class SupportActionModeWrapper
  extends android.view.ActionMode
{
  final Context mContext;
  final ActionMode mWrappedObject;
  
  public SupportActionModeWrapper(Context paramContext, ActionMode paramActionMode)
  {
    mContext = paramContext;
    mWrappedObject = paramActionMode;
  }
  
  public final void finish()
  {
    mWrappedObject.finish();
  }
  
  public final View getCustomView()
  {
    return mWrappedObject.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return MenuWrapperFactory.wrapSupportMenu(mContext, (SupportMenu)mWrappedObject.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return mWrappedObject.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return mWrappedObject.getSubtitle();
  }
  
  public final Object getTag()
  {
    return mWrappedObject.mTag;
  }
  
  public final CharSequence getTitle()
  {
    return mWrappedObject.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return mWrappedObject.mTitleOptionalHint;
  }
  
  public final void invalidate()
  {
    mWrappedObject.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return mWrappedObject.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    mWrappedObject.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    mWrappedObject.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    mWrappedObject.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    mWrappedObject.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    mWrappedObject.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mWrappedObject.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    mWrappedObject.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class CallbackWrapper
    implements ActionMode.Callback
  {
    final ArrayList<SupportActionModeWrapper> mActionModes;
    final Context mContext;
    final SimpleArrayMap<Menu, Menu> mMenus;
    final android.view.ActionMode.Callback mWrappedCallback;
    
    public CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
    {
      mContext = paramContext;
      mWrappedCallback = paramCallback;
      mActionModes = new ArrayList();
      mMenus = new SimpleArrayMap();
    }
    
    private Menu getMenuWrapper(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)mMenus.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = MenuWrapperFactory.wrapSupportMenu(mContext, (SupportMenu)paramMenu);
        mMenus.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final android.view.ActionMode getActionModeWrapper(ActionMode paramActionMode)
    {
      int i = 0;
      int j = mActionModes.size();
      while (i < j)
      {
        SupportActionModeWrapper localSupportActionModeWrapper = (SupportActionModeWrapper)mActionModes.get(i);
        if ((localSupportActionModeWrapper != null) && (mWrappedObject == paramActionMode)) {
          return localSupportActionModeWrapper;
        }
        i += 1;
      }
      paramActionMode = new SupportActionModeWrapper(mContext, paramActionMode);
      mActionModes.add(paramActionMode);
      return paramActionMode;
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.wrapSupportMenuItem(mContext, (SupportMenuItem)paramMenuItem));
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
    }
    
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.SupportActionModeWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */