package com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$TableInfo
{
  public final int collCount;
  public final int collEnd;
  public final BytesToNameCanonicalizer.Bucket[] collList;
  public final int count;
  public final int longestCollisionList;
  public final int[] mainHash;
  public final int mainHashMask;
  public final Name[] mainNames;
  
  public BytesToNameCanonicalizer$TableInfo(BytesToNameCanonicalizer paramBytesToNameCanonicalizer)
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
  
  public BytesToNameCanonicalizer$TableInfo(int[] paramArrayOfInt, Name[] paramArrayOfName)
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer.TableInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */