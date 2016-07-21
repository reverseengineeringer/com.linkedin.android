package com.linkedin.messengerlib.crashes;

public class MessengerCrashReporter
{
  private static volatile MessengerCrashReporter crashReporter;
  public CrashReporterDelegate crashReporterDelegate;
  
  public static MessengerCrashReporter getCrashReporter()
  {
    if (crashReporter == null) {}
    try
    {
      if (crashReporter == null) {
        crashReporter = new MessengerCrashReporter();
      }
      return crashReporter;
    }
    finally {}
  }
  
  public final void reportNonFatal(Throwable paramThrowable)
  {
    if (crashReporterDelegate != null) {
      crashReporterDelegate.reportNonFatal(paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.crashes.MessengerCrashReporter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */