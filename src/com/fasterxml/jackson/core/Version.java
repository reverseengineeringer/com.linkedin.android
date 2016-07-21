package com.fasterxml.jackson.core;

import java.io.Serializable;

public final class Version
  implements Serializable, Comparable<Version>
{
  private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, null, null, null);
  protected final String _artifactId;
  protected final String _groupId;
  protected final int _majorVersion;
  protected final int _minorVersion;
  protected final int _patchLevel;
  protected final String _snapshotInfo;
  
  public Version(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    _majorVersion = paramInt1;
    _minorVersion = paramInt2;
    _patchLevel = paramInt3;
    _snapshotInfo = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    _groupId = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    _artifactId = paramString1;
  }
  
  public static Version unknownVersion()
  {
    return UNKNOWN_VERSION;
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
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (Version)paramObject;
    } while ((_majorVersion == _majorVersion) && (_minorVersion == _minorVersion) && (_patchLevel == _patchLevel) && (_artifactId.equals(_artifactId)) && (_groupId.equals(_groupId)));
    return false;
  }
  
  public final int hashCode()
  {
    return _artifactId.hashCode() ^ _groupId.hashCode() + _majorVersion - _minorVersion + _patchLevel;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(_majorVersion).append('.');
    localStringBuilder.append(_minorVersion).append('.');
    localStringBuilder.append(_patchLevel);
    if ((_snapshotInfo != null) && (_snapshotInfo.length() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuilder.append('-').append(_snapshotInfo);
      }
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.Version
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */