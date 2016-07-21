package com.linkedin.android.liauthlib.thirdparty;

import android.graphics.Bitmap;
import android.os.AsyncTask;

final class LiThirdPartyAuthorizeActivity$DownloadImageTask
  extends AsyncTask<String, Void, Bitmap>
{
  String companyName;
  
  public LiThirdPartyAuthorizeActivity$DownloadImageTask(LiThirdPartyAuthorizeActivity paramLiThirdPartyAuthorizeActivity, String paramString)
  {
    companyName = paramString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.DownloadImageTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */