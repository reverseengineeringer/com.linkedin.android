package com.linkedin.messengerlib.shared;

import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.utils.I18NManager;
import java.lang.ref.WeakReference;

public final class FragmentComponent
{
  public final DataManager dataManager;
  private final WeakReference<BaseFragment> fragmentRef;
  public final I18NManager i18NManager;
  
  public FragmentComponent(I18NManager paramI18NManager, DataManager paramDataManager, WeakReference<BaseFragment> paramWeakReference)
  {
    i18NManager = paramI18NManager;
    dataManager = paramDataManager;
    fragmentRef = paramWeakReference;
  }
  
  public final MessengerDrawableResources drawableResources()
  {
    if (fragmentRef.get() != null) {
      return ((BaseFragment)fragmentRef.get()).getDrawableResources();
    }
    return null;
  }
  
  public final BaseFragment fragment()
  {
    return (BaseFragment)fragmentRef.get();
  }
  
  public final MessengerLibApi libApi()
  {
    if (fragmentRef.get() != null) {
      return ((BaseFragment)fragmentRef.get()).getMessengerLibApi();
    }
    return null;
  }
  
  public final MessengerLixManager lixManager()
  {
    if (fragmentRef.get() != null) {
      return ((BaseFragment)fragmentRef.get()).getLixManager();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.shared.FragmentComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */