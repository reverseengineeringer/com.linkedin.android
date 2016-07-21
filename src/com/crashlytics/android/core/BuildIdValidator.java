package com.crashlytics.android.core;

final class BuildIdValidator
{
  final String buildId;
  final boolean requiringBuildId;
  
  public BuildIdValidator(String paramString, boolean paramBoolean)
  {
    buildId = paramString;
    requiringBuildId = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.BuildIdValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */