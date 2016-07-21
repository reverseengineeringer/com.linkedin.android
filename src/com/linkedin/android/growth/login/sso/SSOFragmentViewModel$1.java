package com.linkedin.android.growth.login.sso;

import android.widget.ImageView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.network.ImageRequest.ImageRequestListener;

final class SSOFragmentViewModel$1
  implements ImageRequest.ImageRequestListener
{
  SSOFragmentViewModel$1(SSOFragmentViewModel paramSSOFragmentViewModel, SSOFragmentViewHolder paramSSOFragmentViewHolder) {}
  
  public final void onErrorResponse(Object paramObject, String paramString, Exception paramException)
  {
    val$itemViewHolder.profilePicture.setVisibility(8);
    val$itemViewHolder.plusIcon.setVisibility(8);
  }
  
  public final void onResponse(Object paramObject, String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    val$itemViewHolder.profilePicture.setVisibility(0);
    val$itemViewHolder.plusIcon.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOFragmentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */