package com.crashlytics.android.beta;

final class BuildProperties
{
  public final String buildId;
  public final String packageName;
  public final String versionCode;
  public final String versionName;
  
  BuildProperties(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    versionCode = paramString1;
    versionName = paramString2;
    buildId = paramString3;
    packageName = paramString4;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.BuildProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */