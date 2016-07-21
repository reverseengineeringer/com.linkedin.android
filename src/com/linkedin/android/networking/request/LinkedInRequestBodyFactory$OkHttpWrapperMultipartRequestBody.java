package com.linkedin.android.networking.request;

import com.linkedin.android.networking.interfaces.MultipartRequestBody;
import okhttp3.MultipartBody;

public abstract interface LinkedInRequestBodyFactory$OkHttpWrapperMultipartRequestBody
  extends MultipartRequestBody
{
  public abstract MultipartBody getMultiPartBody();
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.request.LinkedInRequestBodyFactory.OkHttpWrapperMultipartRequestBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */