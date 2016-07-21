package com.fasterxml.jackson.core.util;

import java.util.ArrayList;
import java.util.Arrays;

public final class TextBuffer
{
  static final char[] NO_CHARS = new char[0];
  public final BufferRecycler _allocator;
  public char[] _currentSegment;
  public int _currentSize;
  public boolean _hasSegments = false;
  public char[] _inputBuffer;
  public int _inputLen;
  public int _inputStart;
  public char[] _resultArray;
  public String _resultString;
  public int _segmentSize;
  private ArrayList<char[]> _segments;
  
  public TextBuffer(BufferRecycler paramBufferRecycler)
  {
    _allocator = paramBufferRecycler;
  }
  
  public final char[] buf(int paramInt)
  {
    if (_allocator != null) {
      return _allocator.allocCharBuffer(2, paramInt);
    }
    return new char[Math.max(paramInt, 1000)];
  }
  
  public final void clearSegments()
  {
    _hasSegments = false;
    _segments.clear();
    _segmentSize = 0;
    _currentSize = 0;
  }
  
  public final char[] contentsAsArray()
  {
    char[] arrayOfChar2 = _resultArray;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      if (_resultString == null) {
        break label40;
      }
      arrayOfChar1 = _resultString.toCharArray();
    }
    label40:
    int i;
    int j;
    for (;;)
    {
      _resultArray = arrayOfChar1;
      return arrayOfChar1;
      if (_inputStart >= 0)
      {
        i = _inputLen;
        if (i <= 0)
        {
          arrayOfChar1 = NO_CHARS;
        }
        else
        {
          j = _inputStart;
          if (j == 0) {
            arrayOfChar1 = Arrays.copyOf(_inputBuffer, i);
          } else {
            arrayOfChar1 = Arrays.copyOfRange(_inputBuffer, j, i + j);
          }
        }
      }
      else
      {
        i = size();
        if (i > 0) {
          break;
        }
        arrayOfChar1 = NO_CHARS;
      }
    }
    arrayOfChar1 = new char[i];
    if (_segments != null)
    {
      int k = _segments.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        arrayOfChar2 = (char[])_segments.get(j);
        int m = arrayOfChar2.length;
        System.arraycopy(arrayOfChar2, 0, arrayOfChar1, i, m);
        i += m;
        j += 1;
      }
    }
    for (;;)
    {
      System.arraycopy(_currentSegment, 0, arrayOfChar1, i, _currentSize);
      break;
      i = 0;
    }
  }
  
  public final String contentsAsString()
  {
    if (_resultString == null)
    {
      if (_resultArray == null) {
        break label34;
      }
      _resultString = new String(_resultArray);
    }
    for (;;)
    {
      return _resultString;
      label34:
      if (_inputStart >= 0)
      {
        if (_inputLen <= 0)
        {
          _resultString = "";
          return "";
        }
        _resultString = new String(_inputBuffer, _inputStart, _inputLen);
      }
      else
      {
        int i = _segmentSize;
        int j = _currentSize;
        if (i == 0)
        {
          if (j == 0) {}
          for (localObject = "";; localObject = new String(_currentSegment, 0, j))
          {
            _resultString = ((String)localObject);
            break;
          }
        }
        Object localObject = new StringBuilder(i + j);
        if (_segments != null)
        {
          i = 0;
          j = _segments.size();
          while (i < j)
          {
            char[] arrayOfChar = (char[])_segments.get(i);
            ((StringBuilder)localObject).append(arrayOfChar, 0, arrayOfChar.length);
            i += 1;
          }
        }
        ((StringBuilder)localObject).append(_currentSegment, 0, _currentSize);
        _resultString = ((StringBuilder)localObject).toString();
      }
    }
  }
  
  public final char[] emptyAndGetCurrentSegment()
  {
    _inputStart = -1;
    _currentSize = 0;
    _inputLen = 0;
    _inputBuffer = null;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
    char[] arrayOfChar2 = _currentSegment;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = buf(0);
      _currentSegment = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public final void expand$13462e()
  {
    if (_segments == null) {
      _segments = new ArrayList();
    }
    char[] arrayOfChar = _currentSegment;
    _hasSegments = true;
    _segments.add(arrayOfChar);
    _segmentSize += arrayOfChar.length;
    _currentSize = 0;
    int i = arrayOfChar.length;
    int j = i + (i >> 1);
    if (j < 1000) {
      i = 1000;
    }
    for (;;)
    {
      _currentSegment = new char[i];
      return;
      i = j;
      if (j > 262144) {
        i = 262144;
      }
    }
  }
  
  public final char[] expandCurrentSegment()
  {
    char[] arrayOfChar = _currentSegment;
    int k = arrayOfChar.length;
    int j = k + (k >> 1);
    int i = j;
    if (j > 262144) {
      i = k + (k >> 2);
    }
    arrayOfChar = Arrays.copyOf(arrayOfChar, i);
    _currentSegment = arrayOfChar;
    return arrayOfChar;
  }
  
  public final char[] finishCurrentSegment()
  {
    if (_segments == null) {
      _segments = new ArrayList();
    }
    _hasSegments = true;
    _segments.add(_currentSegment);
    int i = _currentSegment.length;
    _segmentSize += i;
    _currentSize = 0;
    int j = i + (i >> 1);
    if (j < 1000) {
      i = 1000;
    }
    for (;;)
    {
      char[] arrayOfChar = new char[i];
      _currentSegment = arrayOfChar;
      return arrayOfChar;
      i = j;
      if (j > 262144) {
        i = 262144;
      }
    }
  }
  
  public final char[] getCurrentSegment()
  {
    if (_inputStart >= 0) {
      unshare(1);
    }
    for (;;)
    {
      return _currentSegment;
      char[] arrayOfChar = _currentSegment;
      if (arrayOfChar == null) {
        _currentSegment = buf(0);
      } else if (_currentSize >= arrayOfChar.length) {
        expand$13462e();
      }
    }
  }
  
  public final char[] getTextBuffer()
  {
    if (_inputStart >= 0) {
      return _inputBuffer;
    }
    if (_resultArray != null) {
      return _resultArray;
    }
    if (_resultString != null)
    {
      char[] arrayOfChar = _resultString.toCharArray();
      _resultArray = arrayOfChar;
      return arrayOfChar;
    }
    if (!_hasSegments) {
      return _currentSegment;
    }
    return contentsAsArray();
  }
  
  public final int getTextOffset()
  {
    if (_inputStart >= 0) {
      return _inputStart;
    }
    return 0;
  }
  
  public final void resetWithEmpty()
  {
    _inputStart = -1;
    _currentSize = 0;
    _inputLen = 0;
    _inputBuffer = null;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
  }
  
  public final void resetWithShared(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _resultString = null;
    _resultArray = null;
    _inputBuffer = paramArrayOfChar;
    _inputStart = paramInt1;
    _inputLen = paramInt2;
    if (_hasSegments) {
      clearSegments();
    }
  }
  
  public final int size()
  {
    if (_inputStart >= 0) {
      return _inputLen;
    }
    if (_resultArray != null) {
      return _resultArray.length;
    }
    if (_resultString != null) {
      return _resultString.length();
    }
    return _segmentSize + _currentSize;
  }
  
  public final String toString()
  {
    return contentsAsString();
  }
  
  public final void unshare(int paramInt)
  {
    int i = _inputLen;
    _inputLen = 0;
    char[] arrayOfChar = _inputBuffer;
    _inputBuffer = null;
    int j = _inputStart;
    _inputStart = -1;
    paramInt = i + paramInt;
    if ((_currentSegment == null) || (paramInt > _currentSegment.length)) {
      _currentSegment = buf(paramInt);
    }
    if (i > 0) {
      System.arraycopy(arrayOfChar, j, _currentSegment, 0, i);
    }
    _segmentSize = 0;
    _currentSize = i;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.TextBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */