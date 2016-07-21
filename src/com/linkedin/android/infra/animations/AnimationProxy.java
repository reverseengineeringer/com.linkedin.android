package com.linkedin.android.infra.animations;

import android.support.v4.app.FragmentTransaction;

public final class AnimationProxy
{
  public static FragmentTransaction setAnimations(FragmentTransaction paramFragmentTransaction, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramFragmentTransaction.setCustomAnimations(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.animations.AnimationProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */