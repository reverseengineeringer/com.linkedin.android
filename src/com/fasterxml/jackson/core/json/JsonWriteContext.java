package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;

public final class JsonWriteContext
  extends JsonStreamContext
{
  protected JsonWriteContext _child = null;
  protected String _currentName;
  protected Object _currentValue;
  protected DupDetector _dups;
  protected boolean _gotName;
  protected final JsonWriteContext _parent;
  
  public JsonWriteContext(int paramInt, JsonWriteContext paramJsonWriteContext, DupDetector paramDupDetector)
  {
    _type = paramInt;
    _parent = paramJsonWriteContext;
    _dups = paramDupDetector;
    _index = -1;
  }
  
  private JsonWriteContext reset(int paramInt)
  {
    _type = paramInt;
    _index = -1;
    _currentName = null;
    _gotName = false;
    _currentValue = null;
    if (_dups != null) {
      _dups.reset();
    }
    return this;
  }
  
  public final JsonWriteContext createChildArrayContext()
  {
    Object localObject = _child;
    if (localObject == null)
    {
      if (_dups == null) {}
      for (localObject = null;; localObject = _dups.child())
      {
        localObject = new JsonWriteContext(1, this, (DupDetector)localObject);
        _child = ((JsonWriteContext)localObject);
        return (JsonWriteContext)localObject;
      }
    }
    return ((JsonWriteContext)localObject).reset(1);
  }
  
  public final JsonWriteContext createChildObjectContext()
  {
    Object localObject = _child;
    if (localObject == null)
    {
      if (_dups == null) {}
      for (localObject = null;; localObject = _dups.child())
      {
        localObject = new JsonWriteContext(2, this, (DupDetector)localObject);
        _child = ((JsonWriteContext)localObject);
        return (JsonWriteContext)localObject;
      }
    }
    return ((JsonWriteContext)localObject).reset(2);
  }
  
  public final JsonWriteContext getParent()
  {
    return _parent;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    if (_type == 2)
    {
      localStringBuilder.append('{');
      if (_currentName != null)
      {
        localStringBuilder.append('"');
        localStringBuilder.append(_currentName);
        localStringBuilder.append('"');
        localStringBuilder.append('}');
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append('?');
      break;
      if (_type == 1)
      {
        localStringBuilder.append('[');
        localStringBuilder.append(getCurrentIndex());
        localStringBuilder.append(']');
      }
      else
      {
        localStringBuilder.append("/");
      }
    }
  }
  
  public final int writeFieldName(String paramString)
    throws JsonProcessingException
  {
    int i = 1;
    if (_gotName) {
      i = 4;
    }
    do
    {
      return i;
      _gotName = true;
      _currentName = paramString;
      if ((_dups != null) && (_dups.isDup(paramString))) {
        throw new JsonGenerationException("Duplicate field '" + paramString + "'");
      }
    } while (_index >= 0);
    return 0;
  }
  
  public final int writeValue()
  {
    if (_type == 2)
    {
      _gotName = false;
      _index += 1;
      return 2;
    }
    if (_type == 1)
    {
      int i = _index;
      _index += 1;
      if (i < 0) {
        return 0;
      }
      return 1;
    }
    _index += 1;
    if (_index == 0) {
      return 0;
    }
    return 3;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.JsonWriteContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */