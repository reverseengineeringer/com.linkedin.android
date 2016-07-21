package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

public final class PackageVersion
  implements Versioned
{
  public static final Version VERSION = VersionUtil.parseVersion("2.5.2", "com.fasterxml.jackson.core", "jackson-core");
  
  public final Version version()
  {
    return VERSION;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.PackageVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */