package com.crashlytics.android.core;

public final class CrashlyticsMissingDependencyException
  extends RuntimeException
{
  CrashlyticsMissingDependencyException(String paramString)
  {
    super("\n" + paramString + "\n");
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsMissingDependencyException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */