package com.linkedin.android.infra.shared;

public abstract interface PhotoCropListener
{
  public abstract void onUploadFail();
  
  public abstract void onUploadSuccess(String paramString1, String paramString2, String paramString3, String paramString4);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.PhotoCropListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */