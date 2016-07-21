package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

public final class SerializedString
  implements SerializableString, Serializable
{
  protected byte[] _unquotedUTF8Ref;
  protected final String _value;
  
  public SerializedString(String paramString)
  {
    _value = paramString;
  }
  
  public final byte[] asUnquotedUTF8()
  {
    byte[] arrayOfByte2 = _unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      _unquotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      return false;
    }
    paramObject = (SerializedString)paramObject;
    return _value.equals(_value);
  }
  
  public final String getValue()
  {
    return _value;
  }
  
  public final int hashCode()
  {
    return _value.hashCode();
  }
  
  public final String toString()
  {
    return _value;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.SerializedString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */