package com.linkedin.android.ConfirmEmailAddress;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.linkedin.android.Constants;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DeepLinkEmailManagementController
{
  public static final String TAG = DeepLinkEmailManagementController.class.getName();
  public final Context mContext;
  public final AbstractNetworkClient mNetworkClient;
  
  public DeepLinkEmailManagementController(AbstractNetworkClient paramAbstractNetworkClient, Context paramContext)
  {
    mNetworkClient = paramAbstractNetworkClient;
    mContext = paramContext;
  }
  
  public static Uri getUri(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      return localUri;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "Failed to parse url " + paramString, localException);
    }
    return null;
  }
  
  public static final class Result
  {
    public String emailAddress;
    public String redirectUrlAlias;
    public Integer responseCode;
    
    public static Result fail(Integer paramInteger)
    {
      Result localResult = new Result();
      responseCode = paramInteger;
      return localResult;
    }
  }
  
  public static abstract interface ResultListener
  {
    public abstract void onResult(DeepLinkEmailManagementController.Result paramResult);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */