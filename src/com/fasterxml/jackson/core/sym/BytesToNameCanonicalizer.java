package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

public final class BytesToNameCanonicalizer
{
  protected int _collCount;
  protected int _collEnd;
  protected Bucket[] _collList;
  private boolean _collListShared;
  protected int _count;
  protected final boolean _failOnDoS;
  protected int[] _hash;
  protected int _hashMask;
  private boolean _hashShared;
  protected boolean _intern;
  protected int _longestCollisionList;
  protected Name[] _mainNames;
  private boolean _namesShared;
  private transient boolean _needRehash;
  protected BitSet _overflows;
  protected final BytesToNameCanonicalizer _parent;
  private final int _seed;
  protected final AtomicReference<TableInfo> _tableInfo;
  
  public BytesToNameCanonicalizer(int paramInt)
  {
    _parent = null;
    _seed = paramInt;
    _intern = true;
    _failOnDoS = true;
    _tableInfo = new AtomicReference(initTableInfo$267dee87());
  }
  
  private BytesToNameCanonicalizer(BytesToNameCanonicalizer paramBytesToNameCanonicalizer, boolean paramBoolean1, int paramInt, boolean paramBoolean2, TableInfo paramTableInfo)
  {
    _parent = paramBytesToNameCanonicalizer;
    _seed = paramInt;
    _intern = paramBoolean1;
    _failOnDoS = paramBoolean2;
    _tableInfo = null;
    _count = count;
    _hashMask = mainHashMask;
    _hash = mainHash;
    _mainNames = mainNames;
    _collList = collList;
    _collCount = collCount;
    _collEnd = collEnd;
    _longestCollisionList = longestCollisionList;
    _needRehash = false;
    _hashShared = true;
    _namesShared = true;
    _collListShared = true;
  }
  
  private int calcHash(int paramInt)
  {
    paramInt = _seed ^ paramInt;
    paramInt += (paramInt >>> 15);
    return paramInt ^ paramInt >>> 9;
  }
  
  private int calcHash(int paramInt1, int paramInt2)
  {
    paramInt1 = (paramInt1 >>> 15 ^ paramInt1) + paramInt2 * 33 ^ _seed;
    paramInt1 += (paramInt1 >>> 7);
    return paramInt1 ^ paramInt1 >>> 4;
  }
  
  private int calcHash(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 3) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfInt[0] ^ _seed;
    i = ((i + (i >>> 9)) * 33 + paramArrayOfInt[1]) * 65599;
    i = i + (i >>> 15) ^ paramArrayOfInt[2];
    int j = i + (i >>> 17);
    i = 3;
    while (i < paramInt)
    {
      j = j * 31 ^ paramArrayOfInt[i];
      j += (j >>> 3);
      j ^= j << 7;
      i += 1;
    }
    paramInt = (j >>> 15) + j;
    return paramInt ^ paramInt << 9;
  }
  
  private void expandCollision()
  {
    Bucket[] arrayOfBucket = _collList;
    _collList = ((Bucket[])Arrays.copyOf(arrayOfBucket, arrayOfBucket.length * 2));
  }
  
  private int findBestBucket()
  {
    Bucket[] arrayOfBucket = _collList;
    int j = Integer.MAX_VALUE;
    int k = -1;
    int i = 0;
    int i1 = _collEnd;
    while (i < i1)
    {
      Bucket localBucket = arrayOfBucket[i];
      if (localBucket == null) {}
      int n;
      do
      {
        return i;
        n = length;
        m = j;
        if (n >= j) {
          break;
        }
      } while (n == 1);
      int m = n;
      k = i;
      i += 1;
      j = m;
    }
    return k;
  }
  
  private static TableInfo initTableInfo$267dee87()
  {
    return new TableInfo(new int[64], new Name[64]);
  }
  
  private void rehash()
  {
    _needRehash = false;
    _namesShared = false;
    int m = _hash.length;
    int i = m + m;
    if (i > 65536)
    {
      _count = 0;
      _longestCollisionList = 0;
      Arrays.fill(_hash, 0);
      Arrays.fill(_mainNames, null);
      Arrays.fill(_collList, null);
      _collCount = 0;
      _collEnd = 0;
    }
    label386:
    do
    {
      return;
      _hash = new int[i];
      _hashMask = (i - 1);
      Object localObject1 = _mainNames;
      _mainNames = new Name[i];
      i = 0;
      int j = 0;
      int n;
      while (j < m)
      {
        arrayOfBucket = localObject1[j];
        k = i;
        if (arrayOfBucket != null)
        {
          k = i + 1;
          i = arrayOfBucket.hashCode();
          n = i & _hashMask;
          _mainNames[n] = arrayOfBucket;
          _hash[n] = (i << 8);
        }
        j += 1;
        i = k;
      }
      int i1 = _collEnd;
      if (i1 == 0)
      {
        _longestCollisionList = 0;
        return;
      }
      _collCount = 0;
      _collEnd = 0;
      _collListShared = false;
      int k = 0;
      Bucket[] arrayOfBucket = _collList;
      _collList = new Bucket[arrayOfBucket.length];
      j = 0;
      while (j < i1)
      {
        localObject1 = arrayOfBucket[j];
        while (localObject1 != null)
        {
          m = i + 1;
          Object localObject2 = name;
          i = ((Name)localObject2).hashCode();
          int i2 = i & _hashMask;
          int i3 = _hash[i2];
          if (_mainNames[i2] == null)
          {
            _hash[i2] = (i << 8);
            _mainNames[i2] = localObject2;
            localObject1 = next;
            i = m;
          }
          else
          {
            _collCount += 1;
            i = i3 & 0xFF;
            if (i == 0) {
              if (_collEnd <= 254)
              {
                n = _collEnd;
                _collEnd += 1;
                i = n;
                if (n >= _collList.length)
                {
                  expandCollision();
                  i = n;
                }
                _hash[i2] = (i3 & 0xFF00 | i + 1);
              }
            }
            for (;;)
            {
              localObject2 = new Bucket((Name)localObject2, _collList[i]);
              _collList[i] = localObject2;
              k = Math.max(k, length);
              break;
              i = findBestBucket();
              break label386;
              i -= 1;
            }
          }
        }
        j += 1;
      }
      _longestCollisionList = k;
    } while (i == _count);
    throw new RuntimeException("Internal error: count after rehash " + i + "; should be " + _count);
  }
  
  public final Name addName(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    String str = paramString;
    if (_intern) {
      str = InternCache.instance.intern(paramString);
    }
    int i;
    if (paramInt < 3) {
      if (paramInt == 1) {
        i = calcHash(paramArrayOfInt[0]);
      }
    }
    for (;;)
    {
      if (paramInt < 4) {}
      switch (paramInt)
      {
      default: 
        if (paramInt >= 4) {
          break label327;
        }
        throw new IllegalArgumentException();
        i = calcHash(paramArrayOfInt[0], paramArrayOfInt[1]);
        continue;
        i = calcHash(paramArrayOfInt, paramInt);
      }
    }
    paramString = new Name1(str, i, paramArrayOfInt[0]);
    if (_hashShared)
    {
      paramArrayOfInt = _hash;
      _hash = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      _hashShared = false;
    }
    if (_needRehash) {
      rehash();
    }
    _count += 1;
    int j = i & _hashMask;
    if (_mainNames[j] == null)
    {
      _hash[j] = (i << 8);
      if (_namesShared)
      {
        paramArrayOfInt = _mainNames;
        _mainNames = ((Name[])Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
        _namesShared = false;
      }
      _mainNames[j] = paramString;
      label243:
      paramInt = _hash.length;
      if (_count > paramInt >> 1)
      {
        i = paramInt >> 2;
        if (_count <= paramInt - i) {
          break label708;
        }
        _needRehash = true;
      }
    }
    label327:
    label415:
    label496:
    label513:
    label556:
    label608:
    label616:
    label623:
    label683:
    label708:
    while (_collCount < i)
    {
      return paramString;
      paramString = new Name2(str, i, paramArrayOfInt[0], paramArrayOfInt[1]);
      break;
      paramString = new Name3(str, i, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
      break;
      j = paramArrayOfInt[0];
      int k = paramArrayOfInt[1];
      int m = paramArrayOfInt[2];
      int n = paramArrayOfInt[3];
      if (paramInt - 4 > 0) {}
      for (paramString = Arrays.copyOfRange(paramArrayOfInt, 4, paramInt);; paramString = null)
      {
        paramString = new NameN(str, i, j, k, m, n, paramString, paramInt);
        break;
      }
      if (_collListShared)
      {
        paramArrayOfInt = _collList;
        if (paramArrayOfInt == null)
        {
          _collList = new Bucket[32];
          _collListShared = false;
        }
      }
      else
      {
        _collCount += 1;
        k = _hash[j];
        paramInt = k & 0xFF;
        if (paramInt != 0) {
          break label616;
        }
        if (_collEnd > 254) {
          break label608;
        }
        i = _collEnd;
        _collEnd += 1;
        paramInt = i;
        if (i >= _collList.length)
        {
          expandCollision();
          paramInt = i;
        }
        _hash[j] = (k & 0xFF00 | paramInt + 1);
        paramArrayOfInt = new Bucket(paramString, _collList[paramInt]);
        if (length <= 200) {
          break label683;
        }
        if (_overflows != null) {
          break label623;
        }
        _overflows = new BitSet();
        _overflows.set(paramInt);
      }
      for (;;)
      {
        _collList[paramInt] = null;
        _count -= length;
        _longestCollisionList = -1;
        break;
        _collList = ((Bucket[])Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
        break label415;
        paramInt = findBestBucket();
        break label496;
        paramInt -= 1;
        break label513;
        if (!_overflows.get(paramInt)) {
          break label556;
        }
        if (_failOnDoS) {
          throw new IllegalStateException("Longest collision chain in symbol table (of size " + _count + ") now exceeds maximum, 200 -- suspect a DoS attack based on hash collisions");
        }
        _intern = false;
      }
      _collList[paramInt] = paramArrayOfInt;
      _longestCollisionList = Math.max(length, _longestCollisionList);
      break label243;
    }
    _needRehash = true;
    return paramString;
  }
  
  public final Name findName(int paramInt)
  {
    int i = calcHash(paramInt);
    int j = i & _hashMask;
    int k = _hash[j];
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localName = _mainNames[j];
      if (localName == null) {
        localObject = null;
      }
      do
      {
        return (Name)localObject;
        localObject = localName;
      } while (localName.equals(paramInt));
    }
    while (k != 0)
    {
      Name localName;
      j = k & 0xFF;
      if (j <= 0) {
        break;
      }
      Object localObject = _collList[(j - 1)];
      if (localObject == null) {
        break;
      }
      return ((Bucket)localObject).find(i, paramInt, 0);
    }
    return null;
    return null;
  }
  
  public final Name findName(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if (paramInt2 == 0)
    {
      i = calcHash(paramInt1);
      j = i & _hashMask;
      k = _hash[j];
      if ((k >> 8 ^ i) << 8 != 0) {
        break label122;
      }
      localName = _mainNames[j];
      if (localName != null) {
        break label70;
      }
      localObject = null;
    }
    label70:
    do
    {
      return (Name)localObject;
      i = calcHash(paramInt1, paramInt2);
      break;
      localObject = localName;
    } while (localName.equals(paramInt1, paramInt2));
    label122:
    while (k != 0)
    {
      Name localName;
      j = k & 0xFF;
      if (j <= 0) {
        break;
      }
      Object localObject = _collList[(j - 1)];
      if (localObject == null) {
        break;
      }
      return ((Bucket)localObject).find(i, paramInt1, paramInt2);
    }
    return null;
    return null;
  }
  
  public final Name findName(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    int j;
    Object localObject1;
    if (paramInt < 3)
    {
      j = paramArrayOfInt[0];
      if (paramInt < 2)
      {
        paramInt = i;
        localObject1 = findName(j, paramInt);
      }
    }
    int k;
    do
    {
      do
      {
        return (Name)localObject1;
        paramInt = paramArrayOfInt[1];
        break;
        i = calcHash(paramArrayOfInt, paramInt);
        j = i & _hashMask;
        k = _hash[j];
        if ((k >> 8 ^ i) << 8 != 0) {
          break label164;
        }
        localObject2 = _mainNames[j];
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (((Name)localObject2).equals(paramArrayOfInt, paramInt));
    label164:
    while (k != 0)
    {
      j = k & 0xFF;
      if (j <= 0) {
        break label225;
      }
      localObject1 = _collList[(j - 1)];
      if (localObject1 == null) {
        break label225;
      }
      if ((hash != i) || (!name.equals(paramArrayOfInt, paramInt))) {
        break;
      }
      return name;
    }
    return null;
    for (Object localObject2 = next;; localObject2 = next)
    {
      if (localObject2 == null) {
        break label223;
      }
      if (hash == i)
      {
        Name localName = name;
        localObject1 = localName;
        if (localName.equals(paramArrayOfInt, paramInt)) {
          break;
        }
      }
    }
    label223:
    return null;
    label225:
    return null;
  }
  
  public final BytesToNameCanonicalizer makeChild(int paramInt)
  {
    return new BytesToNameCanonicalizer(this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(paramInt), _seed, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(paramInt), (TableInfo)_tableInfo.get());
  }
  
  public final void release()
  {
    if (_parent != null) {
      if (_hashShared) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        BytesToNameCanonicalizer localBytesToNameCanonicalizer = _parent;
        TableInfo localTableInfo1 = new TableInfo(this);
        i = count;
        TableInfo localTableInfo2 = (TableInfo)_tableInfo.get();
        if (i != count)
        {
          if (i > 6000) {
            localTableInfo1 = initTableInfo$267dee87();
          }
          _tableInfo.compareAndSet(localTableInfo2, localTableInfo1);
        }
        _hashShared = true;
        _namesShared = true;
        _collListShared = true;
      }
      return;
    }
  }
  
  private static final class Bucket
  {
    public final int hash;
    public final int length;
    public final Name name;
    public final Bucket next;
    
    Bucket(Name paramName, Bucket paramBucket)
    {
      name = paramName;
      next = paramBucket;
      if (paramBucket == null) {}
      for (int i = 1;; i = length + 1)
      {
        length = i;
        hash = paramName.hashCode();
        return;
      }
    }
    
    public final Name find(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if ((hash == paramInt1) && (name.equals(paramInt2, paramInt3)))
      {
        localObject = name;
        return (Name)localObject;
      }
      for (Bucket localBucket = next;; localBucket = next)
      {
        if (localBucket == null) {
          break label80;
        }
        if (hash == paramInt1)
        {
          Name localName = name;
          localObject = localName;
          if (localName.equals(paramInt2, paramInt3)) {
            break;
          }
        }
      }
      label80:
      return null;
    }
  }
  
  private static final class TableInfo
  {
    public final int collCount;
    public final int collEnd;
    public final BytesToNameCanonicalizer.Bucket[] collList;
    public final int count;
    public final int longestCollisionList;
    public final int[] mainHash;
    public final int mainHashMask;
    public final Name[] mainNames;
    
    public TableInfo(BytesToNameCanonicalizer paramBytesToNameCanonicalizer)
    {
      count = _count;
      mainHashMask = _hashMask;
      mainHash = _hash;
      mainNames = _mainNames;
      collList = _collList;
      collCount = _collCount;
      collEnd = _collEnd;
      longestCollisionList = _longestCollisionList;
    }
    
    public TableInfo(int[] paramArrayOfInt, Name[] paramArrayOfName)
    {
      count = 0;
      mainHashMask = 63;
      mainHash = paramArrayOfInt;
      mainNames = paramArrayOfName;
      collList = null;
      collCount = 0;
      collEnd = 0;
      longestCollisionList = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */