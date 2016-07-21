package com.linkedin.android.liauthlib.thirdparty;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.linkedin.android.liauthlib.R.id;
import com.linkedin.android.liauthlib.R.layout;
import com.linkedin.android.liauthlib.common.LiSSOInfo;

final class LiThirdPartyAuthorizeActivity$5
  extends Handler
{
  LiThirdPartyAuthorizeActivity$5(LiThirdPartyAuthorizeActivity paramLiThirdPartyAuthorizeActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    new StringBuilder("got message to update ").append(what).append(" ").append(paramMessage.toString());
    switch (what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1000: 
      paramMessage = (LiThirdPartyAuthorizeResponse)obj;
      this$0.updateAppInfo(m_appName, m_permissionInfoList, m_logo);
      return;
    }
    Object localObject = (LiSSOInfo)obj;
    new StringBuilder("updating member info ").append(fullName).append("<end>");
    paramMessage = this$0;
    ViewStub localViewStub = (ViewStub)paramMessage.findViewById(R.id.member_info_viewstub);
    Bitmap localBitmap = LiSSOInfo.loadPicture(paramMessage.getApplicationContext());
    if (localBitmap != null)
    {
      m_externalCallStatus.m_hasMemberPic = true;
      localViewStub.setLayoutResource(R.layout.member_logo);
      localViewStub.setVisibility(0);
      localObject = (ImageView)paramMessage.findViewById(R.id.member_pic);
      if ((localBitmap.getHeight() > getLayoutParamsheight) || (localBitmap.getWidth() > getLayoutParamswidth)) {
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      ((ImageView)localObject).setImageBitmap(localBitmap);
    }
    for (;;)
    {
      m_externalCallStatus.m_memberPicResolved = true;
      paramMessage.updateLogoDisplay();
      return;
      localViewStub.setLayoutResource(R.layout.member_name);
      localViewStub.setVisibility(0);
      ((TextView)paramMessage.findViewById(R.id.member_name)).setText(fullName);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */