package com.linkedin.messengerlib.shared;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerHostBridge;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.utils.I18NManager;
import java.lang.ref.WeakReference;

public class BaseFragment
  extends TrackableFragment
{
  public FragmentComponent fragmentComponent;
  private int fragmentId = -1;
  
  private MessengerHostBridge getHostBridge()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      if ((localFragmentActivity instanceof MessengerHostBridge))
      {
        localObject1 = (MessengerHostBridge)localFragmentActivity;
        localObject2 = localObject1;
        if (localObject1 == null) {
          throw new RuntimeException("Parent does not implement MessengerHostBridge: " + localFragmentActivity.toString() + ", " + getParentFragment().toString());
        }
      }
      else
      {
        Fragment localFragment = getParentFragment();
        localObject2 = localObject1;
        for (;;)
        {
          localObject1 = localObject2;
          if (localFragment == null) {
            break;
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          if ((localFragment instanceof MessengerHostBridge)) {
            localObject2 = (MessengerHostBridge)localFragment;
          } else {
            localFragment = localFragment.getParentFragment();
          }
        }
      }
    }
    return (MessengerHostBridge)localObject2;
  }
  
  public final MessengerDrawableResources getDrawableResources()
  {
    MessengerHostBridge localMessengerHostBridge = getHostBridge();
    if (localMessengerHostBridge != null) {
      return localMessengerHostBridge.getDrawableResources();
    }
    return null;
  }
  
  public final MessengerFABSupport getFABSupport()
  {
    if ((getParentFragment() instanceof MessengerFABSupport)) {
      return (MessengerFABSupport)getParentFragment();
    }
    return null;
  }
  
  public int getFragmentId()
  {
    return fragmentId;
  }
  
  public final I18NManager getI18nManager()
  {
    return fragmentComponent.i18NManager;
  }
  
  public final MessengerLixManager getLixManager()
  {
    MessengerHostBridge localMessengerHostBridge = getHostBridge();
    if (localMessengerHostBridge != null) {
      return localMessengerHostBridge.getLixManager();
    }
    return null;
  }
  
  public final MessengerLibApi getMessengerLibApi()
  {
    MessengerHostBridge localMessengerHostBridge = getHostBridge();
    if (localMessengerHostBridge != null) {
      return localMessengerHostBridge.getMessengerLibApi();
    }
    return null;
  }
  
  public final String getRefreshPageRumSessionId()
  {
    MessengerLibApi localMessengerLibApi = getMessengerLibApi();
    if (localMessengerLibApi == null) {
      return null;
    }
    return localMessengerLibApi.getRefreshPageRumSessionId();
  }
  
  public final String getRumSessionId()
  {
    MessengerLibApi localMessengerLibApi = getMessengerLibApi();
    if (localMessengerLibApi == null) {
      return null;
    }
    return localMessengerLibApi.getRumSessionId();
  }
  
  public final boolean isFragmentActive()
  {
    return (isAdded()) && (!isDetached()) && (!isRemoving());
  }
  
  public final boolean isFragmentResumedAndVisible()
  {
    return (isVisible()) && (isResumed());
  }
  
  public void onAttach(Context paramContext)
  {
    WeakReference localWeakReference = new WeakReference(this);
    I18NManager localI18NManager = new I18NManager(paramContext);
    fragmentComponent = new FragmentComponent(localI18NManager, new DataManager(paramContext.getApplicationContext(), localI18NManager), localWeakReference);
    super.onAttach(paramContext);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = getFragmentId();
    if (i == -1) {
      throw new RuntimeException("Your subclass must define getFragmentId()");
    }
    return paramLayoutInflater.inflate(i, paramViewGroup, false);
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    fragmentId = paramBundle.getInt("FRAGMENT_ID", fragmentId);
  }
  
  public final void showLongSnackbar(String paramString)
  {
    if (getView() != null) {
      Snackbar.make(getView(), paramString, 0).show();
    }
  }
  
  public static abstract interface BaseFragmentApi
  {
    public abstract Activity getActivity();
    
    public abstract I18NManager getI18nManager();
    
    public abstract MessengerLibApi getMessengerLibApi();
    
    public abstract void showLongSnackbar(String paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.shared.BaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */