package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.view.ViewGroup;

final class AppCompatDelegateImplV7$PanelFeatureState
{
  int background;
  View createdPanelView;
  ViewGroup decorView;
  int featureId;
  Bundle frozenActionViewState;
  int gravity;
  boolean isHandled;
  boolean isOpen;
  boolean isPrepared;
  ListMenuPresenter listMenuPresenter;
  Context listPresenterContext;
  MenuBuilder menu;
  public boolean qwertyMode;
  boolean refreshDecorView;
  boolean refreshMenuContent;
  View shownPanelView;
  int windowAnimations;
  int x;
  int y;
  
  AppCompatDelegateImplV7$PanelFeatureState(int paramInt)
  {
    featureId = paramInt;
    refreshDecorView = false;
  }
  
  final void setMenu(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == menu) {}
    do
    {
      return;
      if (menu != null) {
        menu.removeMenuPresenter(listMenuPresenter);
      }
      menu = paramMenuBuilder;
    } while ((paramMenuBuilder == null) || (listMenuPresenter == null));
    paramMenuBuilder.addMenuPresenter(listMenuPresenter);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */