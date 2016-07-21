package com.linkedin.android.networking.interfaces;

public abstract interface RequestDelegate$ContentType
{
  public static final String JSON_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  public static final String MULTIPART_MIXED_CONTENT_TYPE = String.format("multipart/mixed; boundary=%s", new Object[] { "xyz" });
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.interfaces.RequestDelegate.ContentType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */