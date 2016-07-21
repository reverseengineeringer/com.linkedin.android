package com.linkedin.android.growth.lego;

import android.content.Intent;

public abstract interface LegoFlowNavigation
{
  public abstract void exitFlow(Intent paramIntent);
  
  public abstract int getFlowContainer();
  
  public abstract int getFlowLayout();
  
  public abstract void moveToNextGroupLegoWidget();
  
  public abstract void moveToNextLegoWidget();
  
  public abstract void moveToPreviousLegoWidget();
  
  public abstract void startFlow();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoFlowNavigation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */