package android.support.v7.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class SupportMenuInflater
  extends MenuInflater
{
  private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
  private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private final Object[] mActionProviderConstructorArguments;
  private final Object[] mActionViewConstructorArguments;
  private Context mContext;
  private Object mRealOwner;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    ACTION_VIEW_CONSTRUCTOR_SIGNATURE = arrayOfClass;
    ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = arrayOfClass;
  }
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    mContext = paramContext;
    mActionViewConstructorArguments = new Object[] { paramContext };
    mActionProviderConstructorArguments = mActionViewConstructorArguments;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    int k = 0;
    Menu localMenu = null;
    label55:
    int j;
    int n;
    if (i == 2)
    {
      paramMenu = paramXmlPullParser.getName();
      if (paramMenu.equals("menu"))
      {
        i = paramXmlPullParser.next();
        j = 0;
        n = i;
        label62:
        if (j != 0) {
          return;
        }
      }
    }
    int m;
    switch (n)
    {
    default: 
      paramMenu = localMenu;
      m = j;
      i = k;
    case 2: 
    case 3: 
      for (;;)
      {
        n = paramXmlPullParser.next();
        k = i;
        j = m;
        localMenu = paramMenu;
        break label62;
        throw new RuntimeException("Expecting menu, got " + paramMenu);
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label55;
        i = k;
        m = j;
        paramMenu = localMenu;
        if (k == 0)
        {
          paramMenu = paramXmlPullParser.getName();
          if (paramMenu.equals("group"))
          {
            paramMenu = this$0.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
            groupId = paramMenu.getResourceId(R.styleable.MenuGroup_android_id, 0);
            groupCategory = paramMenu.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            groupOrder = paramMenu.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            groupCheckable = paramMenu.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            groupVisible = paramMenu.getBoolean(R.styleable.MenuGroup_android_visible, true);
            groupEnabled = paramMenu.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            paramMenu.recycle();
            i = k;
            m = j;
            paramMenu = localMenu;
          }
          else
          {
            if (paramMenu.equals("item"))
            {
              paramMenu = this$0.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
              itemId = paramMenu.getResourceId(R.styleable.MenuItem_android_id, 0);
              itemCategoryOrder = (paramMenu.getInt(R.styleable.MenuItem_android_menuCategory, groupCategory) & 0xFFFF0000 | paramMenu.getInt(R.styleable.MenuItem_android_orderInCategory, groupOrder) & 0xFFFF);
              itemTitle = paramMenu.getText(R.styleable.MenuItem_android_title);
              itemTitleCondensed = paramMenu.getText(R.styleable.MenuItem_android_titleCondensed);
              itemIconResId = paramMenu.getResourceId(R.styleable.MenuItem_android_icon, 0);
              itemAlphabeticShortcut = MenuState.getShortcut(paramMenu.getString(R.styleable.MenuItem_android_alphabeticShortcut));
              itemNumericShortcut = MenuState.getShortcut(paramMenu.getString(R.styleable.MenuItem_android_numericShortcut));
              if (paramMenu.hasValue(R.styleable.MenuItem_android_checkable)) {
                if (paramMenu.getBoolean(R.styleable.MenuItem_android_checkable, false))
                {
                  i = 1;
                  label487:
                  itemCheckable = i;
                  label494:
                  itemChecked = paramMenu.getBoolean(R.styleable.MenuItem_android_checked, false);
                  itemVisible = paramMenu.getBoolean(R.styleable.MenuItem_android_visible, groupVisible);
                  itemEnabled = paramMenu.getBoolean(R.styleable.MenuItem_android_enabled, groupEnabled);
                  itemShowAsAction = paramMenu.getInt(R.styleable.MenuItem_showAsAction, -1);
                  itemListenerMethodName = paramMenu.getString(R.styleable.MenuItem_android_onClick);
                  itemActionViewLayout = paramMenu.getResourceId(R.styleable.MenuItem_actionLayout, 0);
                  itemActionViewClassName = paramMenu.getString(R.styleable.MenuItem_actionViewClass);
                  itemActionProviderClassName = paramMenu.getString(R.styleable.MenuItem_actionProviderClass);
                  if (itemActionProviderClassName == null) {
                    break label707;
                  }
                  i = 1;
                  label614:
                  if ((i == 0) || (itemActionViewLayout != 0) || (itemActionViewClassName != null)) {
                    break label713;
                  }
                }
              }
              for (itemActionProvider = ((ActionProvider)localMenuState.newInstance(itemActionProviderClassName, ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this$0.mActionProviderConstructorArguments));; itemActionProvider = null)
              {
                paramMenu.recycle();
                itemAdded = false;
                i = k;
                m = j;
                paramMenu = localMenu;
                break;
                i = 0;
                break label487;
                itemCheckable = groupCheckable;
                break label494;
                label707:
                i = 0;
                break label614;
                label713:
                if (i != 0) {
                  Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
              }
            }
            if (paramMenu.equals("menu"))
            {
              parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
              i = k;
              m = j;
              paramMenu = localMenu;
            }
            else
            {
              i = 1;
              m = j;
              continue;
              String str = paramXmlPullParser.getName();
              if ((k != 0) && (str.equals(localMenu)))
              {
                i = 0;
                paramMenu = null;
                m = j;
              }
              else if (str.equals("group"))
              {
                localMenuState.resetGroup();
                i = k;
                m = j;
                paramMenu = localMenu;
              }
              else if (str.equals("item"))
              {
                i = k;
                m = j;
                paramMenu = localMenu;
                if (!itemAdded) {
                  if ((itemActionProvider != null) && (itemActionProvider.hasSubMenu()))
                  {
                    localMenuState.addSubMenuItem();
                    i = k;
                    m = j;
                    paramMenu = localMenu;
                  }
                  else
                  {
                    itemAdded = true;
                    localMenuState.setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
                    i = k;
                    m = j;
                    paramMenu = localMenu;
                  }
                }
              }
              else
              {
                i = k;
                m = j;
                paramMenu = localMenu;
                if (str.equals("menu"))
                {
                  m = 1;
                  i = k;
                  paramMenu = localMenu;
                }
              }
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 360
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 362	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 38	android/support/v7/view/SupportMenuInflater:mContext	Landroid/content/Context;
    //   26: invokevirtual 366	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 372	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 378	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 333	android/support/v7/view/SupportMenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 383 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 385	android/view/InflateException
    //   78: dup
    //   79: ldc_w 387
    //   82: aload_2
    //   83: invokespecial 390	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +9 -> 98
    //   92: aload_3
    //   93: invokeinterface 383 1 0
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload 5
    //   103: astore_3
    //   104: new 385	android/view/InflateException
    //   107: dup
    //   108: ldc_w 387
    //   111: aload_2
    //   112: invokespecial 390	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	SupportMenuInflater
    //   0	116	1	paramInt	int
    //   0	116	2	paramMenu	Menu
    //   15	89	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	85	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	87	finally
    //   46	58	87	finally
    //   75	87	87	finally
    //   104	116	87	finally
    //   22	35	100	java/io/IOException
    //   46	58	100	java/io/IOException
  }
  
  private static final class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES = { MenuItem.class };
    private Method mMethod;
    private Object mRealOwner;
    
    public InflatedOnMenuItemClickListener(Object paramObject, String paramString)
    {
      mRealOwner = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        mMethod = localClass.getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception paramObject)
      {
        paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (mMethod.getReturnType() == Boolean.TYPE) {
          return ((Boolean)mMethod.invoke(mRealOwner, new Object[] { paramMenuItem })).booleanValue();
        }
        mMethod.invoke(mRealOwner, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private final class MenuState
  {
    int groupCategory;
    int groupCheckable;
    boolean groupEnabled;
    int groupId;
    int groupOrder;
    boolean groupVisible;
    ActionProvider itemActionProvider;
    String itemActionProviderClassName;
    String itemActionViewClassName;
    int itemActionViewLayout;
    boolean itemAdded;
    char itemAlphabeticShortcut;
    int itemCategoryOrder;
    int itemCheckable;
    boolean itemChecked;
    boolean itemEnabled;
    int itemIconResId;
    int itemId;
    String itemListenerMethodName;
    char itemNumericShortcut;
    int itemShowAsAction;
    CharSequence itemTitle;
    CharSequence itemTitleCondensed;
    boolean itemVisible;
    Menu menu;
    
    public MenuState(Menu paramMenu)
    {
      menu = paramMenu;
      resetGroup();
    }
    
    static char getShortcut(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    public final SubMenu addSubMenuItem()
    {
      itemAdded = true;
      SubMenu localSubMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }
    
    final <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
      }
      return null;
    }
    
    public final void resetGroup()
    {
      groupId = 0;
      groupCategory = 0;
      groupOrder = 0;
      groupCheckable = 0;
      groupVisible = true;
      groupEnabled = true;
    }
    
    final void setItem(MenuItem paramMenuItem)
    {
      boolean bool = false;
      Object localObject = paramMenuItem.setChecked(itemChecked).setVisible(itemVisible).setEnabled(itemEnabled);
      if (itemCheckable > 0) {
        bool = true;
      }
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(itemTitleCondensed).setIcon(itemIconResId).setAlphabeticShortcut(itemAlphabeticShortcut).setNumericShortcut(itemNumericShortcut);
      if (itemShowAsAction >= 0) {
        MenuItemCompat.setShowAsAction(paramMenuItem, itemShowAsAction);
      }
      if (itemListenerMethodName != null)
      {
        if (mContext.isRestricted()) {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
        paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.access$400(SupportMenuInflater.this), itemListenerMethodName));
      }
      if (itemCheckable >= 2)
      {
        if ((paramMenuItem instanceof MenuItemImpl)) {
          ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
        }
      }
      else
      {
        int i = 0;
        if (itemActionViewClassName != null)
        {
          MenuItemCompat.setActionView(paramMenuItem, (View)newInstance(itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, mActionViewConstructorArguments));
          i = 1;
        }
        if (itemActionViewLayout > 0)
        {
          if (i != 0) {
            break label351;
          }
          MenuItemCompat.setActionView(paramMenuItem, itemActionViewLayout);
        }
      }
      for (;;)
      {
        if (itemActionProvider != null) {
          MenuItemCompat.setActionProvider(paramMenuItem, itemActionProvider);
        }
        return;
        if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
          break;
        }
        localObject = (MenuItemWrapperICS)paramMenuItem;
        try
        {
          if (mSetExclusiveCheckableMethod == null) {
            mSetExclusiveCheckableMethod = ((SupportMenuItem)mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
          }
          mSetExclusiveCheckableMethod.invoke(mWrappedObject, new Object[] { Boolean.valueOf(true) });
        }
        catch (Exception localException)
        {
          Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
        }
        break;
        label351:
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.SupportMenuInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */