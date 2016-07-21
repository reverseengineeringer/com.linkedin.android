package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;

public final class CharsToNameCanonicalizer
{
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected Bucket[] _buckets;
  protected boolean _canonicalize;
  protected boolean _dirty;
  protected final int _flags;
  public final int _hashSeed;
  protected int _indexMask;
  protected int _longestCollisionList;
  protected BitSet _overflows;
  protected CharsToNameCanonicalizer _parent;
  protected int _size;
  protected int _sizeThreshold;
  protected String[] _symbols;
  
  private CharsToNameCanonicalizer()
  {
    _canonicalize = true;
    _flags = -1;
    _dirty = true;
    _hashSeed = 0;
    _longestCollisionList = 0;
    initTables(64);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, int paramInt1, String[] paramArrayOfString, Bucket[] paramArrayOfBucket, int paramInt2, int paramInt3, int paramInt4)
  {
    _parent = paramCharsToNameCanonicalizer;
    _flags = paramInt1;
    _canonicalize = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt1);
    _symbols = paramArrayOfString;
    _buckets = paramArrayOfBucket;
    _size = paramInt2;
    _hashSeed = paramInt3;
    paramInt1 = paramArrayOfString.length;
    _sizeThreshold = (paramInt1 - (paramInt1 >> 2));
    _indexMask = (paramInt1 - 1);
    _longestCollisionList = paramInt4;
    _dirty = false;
  }
  
  private static String _findSymbol2(char[] paramArrayOfChar, int paramInt1, int paramInt2, Bucket paramBucket)
  {
    while (paramBucket != null)
    {
      String str = paramBucket.has(paramArrayOfChar, paramInt1, paramInt2);
      if (str != null) {
        return str;
      }
      paramBucket = next;
    }
    return null;
  }
  
  private int _hashToIndex(int paramInt)
  {
    return (paramInt >>> 15) + paramInt & _indexMask;
  }
  
  private int calcHash(String paramString)
  {
    int k = paramString.length();
    int i = _hashSeed;
    int j = 0;
    while (j < k)
    {
      i = i * 33 + paramString.charAt(j);
      j += 1;
    }
    j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  private int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = _hashSeed;
    int j = paramInt1;
    while (j < paramInt1 + paramInt2)
    {
      i = i * 33 + paramArrayOfChar[j];
      j += 1;
    }
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  public static CharsToNameCanonicalizer createRoot()
  {
    long l = System.currentTimeMillis();
    int i = (int)l;
    int j = (int)(l >>> 32);
    CharsToNameCanonicalizer localCharsToNameCanonicalizer = sBootstrapSymbolTable;
    return new CharsToNameCanonicalizer(null, -1, _symbols, _buckets, _size, i + j | 0x1, _longestCollisionList);
  }
  
  private void initTables(int paramInt)
  {
    _symbols = new String[paramInt];
    _buckets = new Bucket[paramInt >> 1];
    _indexMask = (paramInt - 1);
    _size = 0;
    _longestCollisionList = 0;
    _sizeThreshold = (paramInt - (paramInt >> 2));
  }
  
  private void rehash()
  {
    int i1 = _symbols.length;
    int i = i1 + i1;
    if (i > 65536)
    {
      _size = 0;
      _canonicalize = false;
      _symbols = new String[64];
      _buckets = new Bucket[32];
      _indexMask = 63;
      _dirty = true;
    }
    int k;
    label183:
    do
    {
      return;
      Object localObject1 = _symbols;
      Bucket[] arrayOfBucket = _buckets;
      _symbols = new String[i];
      _buckets = new Bucket[i >> 1];
      _indexMask = (i - 1);
      _sizeThreshold = (i - (i >> 2));
      int j = 0;
      i = 0;
      k = 0;
      Object localObject2;
      if (k < i1)
      {
        localObject2 = localObject1[k];
        m = j;
        int n = i;
        if (localObject2 != null)
        {
          m = j + 1;
          j = _hashToIndex(calcHash((String)localObject2));
          if (_symbols[j] != null) {
            break label183;
          }
          _symbols[j] = localObject2;
        }
        for (n = i;; n = Math.max(i, length))
        {
          k += 1;
          j = m;
          i = n;
          break;
          j >>= 1;
          localObject2 = new Bucket((String)localObject2, _buckets[j]);
          _buckets[j] = localObject2;
        }
      }
      k = 0;
      int m = i;
      i = k;
      k = j;
      while (i < i1 >> 1)
      {
        localObject1 = arrayOfBucket[i];
        j = m;
        if (localObject1 != null)
        {
          k += 1;
          localObject2 = symbol;
          m = _hashToIndex(calcHash((String)localObject2));
          if (_symbols[m] == null) {
            _symbols[m] = localObject2;
          }
          for (;;)
          {
            localObject1 = next;
            break;
            m >>= 1;
            localObject2 = new Bucket((String)localObject2, _buckets[m]);
            _buckets[m] = localObject2;
            j = Math.max(j, length);
          }
        }
        i += 1;
        m = j;
      }
      _longestCollisionList = m;
      _overflows = null;
    } while (k == _size);
    throw new Error("Internal error on SymbolTable.rehash(): had " + _size + " entries; now have " + k + ".");
  }
  
  public final String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt2 <= 0) {
      localObject = "";
    }
    int i;
    String str;
    do
    {
      Bucket localBucket;
      do
      {
        return (String)localObject;
        if (!_canonicalize) {
          return new String(paramArrayOfChar, paramInt1, paramInt2);
        }
        i = _hashToIndex(paramInt3);
        localObject = _symbols[i];
        if (localObject == null) {
          break;
        }
        if (((String)localObject).length() == paramInt2)
        {
          paramInt3 = 0;
          while (((String)localObject).charAt(paramInt3) == paramArrayOfChar[(paramInt1 + paramInt3)])
          {
            int j = paramInt3 + 1;
            paramInt3 = j;
            if (j == paramInt2) {
              return (String)localObject;
            }
          }
        }
        localBucket = _buckets[(i >> 1)];
        if (localBucket == null) {
          break;
        }
        str = localBucket.has(paramArrayOfChar, paramInt1, paramInt2);
        localObject = str;
      } while (str != null);
      str = _findSymbol2(paramArrayOfChar, paramInt1, paramInt2, next);
      localObject = str;
    } while (str != null);
    if (!_dirty)
    {
      localObject = _symbols;
      _symbols = ((String[])Arrays.copyOf((Object[])localObject, localObject.length));
      localObject = _buckets;
      _buckets = ((Bucket[])Arrays.copyOf((Object[])localObject, localObject.length));
      _dirty = true;
      paramInt3 = i;
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(_flags)) {
        paramArrayOfChar = InternCache.instance.intern((String)localObject);
      }
      _size += 1;
      if (_symbols[paramInt3] != null) {
        break label315;
      }
      _symbols[paramInt3] = paramArrayOfChar;
    }
    for (;;)
    {
      return paramArrayOfChar;
      paramInt3 = i;
      if (_size < _sizeThreshold) {
        break;
      }
      rehash();
      paramInt3 = _hashToIndex(calcHash(paramArrayOfChar, paramInt1, paramInt2));
      break;
      label315:
      paramInt1 = paramInt3 >> 1;
      localObject = new Bucket(paramArrayOfChar, _buckets[paramInt1]);
      paramInt2 = length;
      if (paramInt2 > 100)
      {
        if (_overflows == null)
        {
          _overflows = new BitSet();
          label366:
          _overflows.set(paramInt1);
        }
        for (;;)
        {
          _symbols[(paramInt1 + paramInt1)] = symbol;
          _buckets[paramInt1] = null;
          _size -= length;
          _longestCollisionList = -1;
          break;
          if (!_overflows.get(paramInt1)) {
            break label366;
          }
          if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(_flags)) {
            throw new IllegalStateException("Longest collision chain in symbol table (of size " + _size + ") now exceeds maximum, 100 -- suspect a DoS attack based on hash collisions");
          }
          _canonicalize = false;
        }
      }
      _buckets[paramInt1] = localObject;
      _longestCollisionList = Math.max(paramInt2, _longestCollisionList);
    }
  }
  
  public final CharsToNameCanonicalizer makeChild(int paramInt)
  {
    try
    {
      String[] arrayOfString = _symbols;
      Bucket[] arrayOfBucket = _buckets;
      int i = _size;
      int j = _hashSeed;
      int k = _longestCollisionList;
      return new CharsToNameCanonicalizer(this, paramInt, arrayOfString, arrayOfBucket, i, j, k);
    }
    finally {}
  }
  
  public final void release()
  {
    if (!_dirty) {}
    while ((_parent == null) || (!_canonicalize)) {
      return;
    }
    CharsToNameCanonicalizer localCharsToNameCanonicalizer = _parent;
    if (_size > 12000) {}
    for (;;)
    {
      try
      {
        localCharsToNameCanonicalizer.initTables(256);
        _dirty = false;
        _dirty = false;
        return;
      }
      finally {}
      if (_size <= _size) {
        continue;
      }
      try
      {
        _symbols = _symbols;
        _buckets = _buckets;
        _size = _size;
        _sizeThreshold = _sizeThreshold;
        _indexMask = _indexMask;
        _longestCollisionList = _longestCollisionList;
        _dirty = false;
      }
      finally {}
    }
  }
  
  static final class Bucket
  {
    public final int length;
    public final Bucket next;
    public final String symbol;
    
    public Bucket(String paramString, Bucket paramBucket)
    {
      symbol = paramString;
      next = paramBucket;
      if (paramBucket == null) {}
      for (int i = 1;; i = length + 1)
      {
        length = i;
        return;
      }
    }
    
    public final String has(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if (symbol.length() != paramInt2) {}
      int j;
      do
      {
        while (symbol.charAt(i) != paramArrayOfChar[(paramInt1 + i)])
        {
          return null;
          i = 0;
        }
        j = i + 1;
        int i = j;
      } while (j < paramInt2);
      return symbol;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */