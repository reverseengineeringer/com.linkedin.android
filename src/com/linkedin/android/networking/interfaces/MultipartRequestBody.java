package com.linkedin.android.networking.interfaces;

import java.util.List;

public abstract interface MultipartRequestBody
  extends RequestBody
{
  public abstract void addPart(RequestBody paramRequestBody);
  
  public abstract List<RequestBody> getParts();
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.interfaces.MultipartRequestBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */