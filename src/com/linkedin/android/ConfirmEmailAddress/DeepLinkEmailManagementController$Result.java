package com.linkedin.android.ConfirmEmailAddress;

public final class DeepLinkEmailManagementController$Result
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

/* Location:
 * Qualified Name:     com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */