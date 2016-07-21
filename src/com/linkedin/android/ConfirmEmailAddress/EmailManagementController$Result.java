package com.linkedin.android.ConfirmEmailAddress;

import org.json.JSONObject;

public final class EmailManagementController$Result
{
  public final JSONObject response;
  public final boolean success;
  
  EmailManagementController$Result(boolean paramBoolean, JSONObject paramJSONObject)
  {
    success = paramBoolean;
    response = paramJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.ConfirmEmailAddress.EmailManagementController.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */