package com.fasterxml.jackson.core;

import java.io.Serializable;

public final class JsonLocation
  implements Serializable
{
  public static final JsonLocation NA = new JsonLocation("N/A", -1L, -1L, -1, -1);
  final int _columnNr;
  final int _lineNr;
  public final transient Object _sourceRef;
  public final long _totalBytes;
  public final long _totalChars;
  
  public JsonLocation(Object paramObject, int paramInt1, int paramInt2)
  {
    this(paramObject, -1L, -1L, paramInt1, paramInt2);
  }
  
  public JsonLocation(Object paramObject, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    _sourceRef = paramObject;
    _totalBytes = paramLong1;
    _totalChars = paramLong2;
    _lineNr = paramInt1;
    _columnNr = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof JsonLocation)) {
        return false;
      }
      paramObject = (JsonLocation)paramObject;
      if (_sourceRef == null)
      {
        if (_sourceRef != null) {
          return false;
        }
      }
      else if (!_sourceRef.equals(_sourceRef)) {
        return false;
      }
    } while ((_lineNr == _lineNr) && (_columnNr == _columnNr) && (_totalChars == _totalChars) && (_totalBytes == _totalBytes));
    return false;
  }
  
  public final int hashCode()
  {
    if (_sourceRef == null) {}
    for (int i = 1;; i = _sourceRef.hashCode()) {
      return ((i ^ _lineNr) + _columnNr ^ (int)_totalChars) + (int)_totalBytes;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[Source: ");
    if (_sourceRef == null) {
      localStringBuilder.append("UNKNOWN");
    }
    for (;;)
    {
      localStringBuilder.append("; line: ");
      localStringBuilder.append(_lineNr);
      localStringBuilder.append(", column: ");
      localStringBuilder.append(_columnNr);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localStringBuilder.append(_sourceRef.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.JsonLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */