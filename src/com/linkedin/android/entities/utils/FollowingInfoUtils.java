package com.linkedin.android.entities.utils;

import com.linkedin.android.pegasus.gen.common.Urn;

public final class FollowingInfoUtils
{
  public static Urn createFollowingMemberInfoUrn(Object... paramVarArgs)
  {
    return Urn.createFromTuple("fs_followingInfo", new Object[] { Urn.createFromTuple("member", paramVarArgs) });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.utils.FollowingInfoUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */