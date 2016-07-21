package com.crashlytics.android.answers;

import java.util.Map;

public final class SessionEvent$Builder
{
  Map<String, Object> customAttributes;
  String customType;
  public Map<String, String> details;
  Map<String, Object> predefinedAttributes;
  String predefinedType;
  final long timestamp;
  final SessionEvent.Type type;
  
  public SessionEvent$Builder(SessionEvent.Type paramType)
  {
    type = paramType;
    timestamp = System.currentTimeMillis();
    details = null;
    customType = null;
    customAttributes = null;
    predefinedType = null;
    predefinedAttributes = null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */