package com.linkedin.android.infra.shared;

import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public final class GhostImageUtils
{
  private static final int[] BACKGROUND_COLORS = { 2131624031, 2131624022, 2131623964, 2131624004, 2131624045 };
  private static LixManager lixManager;
  
  public static GhostImage getAnonymousPerson(int paramInt)
  {
    return getGhostImage(paramInt, getPersonImage(paramInt), null, 0);
  }
  
  public static GhostImage getCompany(int paramInt, MiniCompany paramMiniCompany)
  {
    return getGhostImage(paramInt, getCompanyImage(paramInt), entityUrn, 1);
  }
  
  private static int getCompanyImage(int paramInt)
  {
    switch (paramInt)
    {
    case 2131492962: 
    case 2131492965: 
    case 2131492966: 
    default: 
      return 2130837965;
    case 2131492960: 
      return 2130837963;
    case 2131492961: 
      return 2130837964;
    case 2131492963: 
      return 2130837966;
    case 2131492964: 
      return 2130837967;
    case 2131492967: 
      return 2130837968;
    }
    return 2130837962;
  }
  
  private static GhostImage getGhostImage(int paramInt1, int paramInt2, Urn paramUrn, int paramInt3)
  {
    int k = 2131623973;
    int i = k;
    if (lixManager != null)
    {
      if (paramUrn != null) {
        i = k;
      }
    }
    else {
      return new GhostImage(paramInt1, i, paramInt2, 2131624055, paramInt3);
    }
    String str = lixManager.getTreatment(Lix.INFRA_GHOST_IMAGE_BACKGROUND);
    if ((!"control".equals(str)) && (!"gray".equals(str))) {}
    for (int j = 1;; j = 0)
    {
      i = k;
      if (j == 0) {
        break;
      }
      j = paramUrn.toString().hashCode() % BACKGROUND_COLORS.length;
      i = j;
      if (j < 0) {
        i = j + BACKGROUND_COLORS.length;
      }
      i = BACKGROUND_COLORS[i];
      break;
    }
  }
  
  public static GhostImage getGroup(int paramInt, MiniGroup paramMiniGroup)
  {
    return getGhostImage(paramInt, getGroupImage(paramInt), entityUrn, 1);
  }
  
  private static int getGroupImage(int paramInt)
  {
    switch (paramInt)
    {
    case 2131492962: 
    case 2131492965: 
    case 2131492966: 
    default: 
      return 2130838050;
    case 2131492960: 
      return 2130838048;
    case 2131492961: 
      return 2130838049;
    case 2131492963: 
      return 2130838051;
    case 2131492964: 
      return 2130838052;
    case 2131492967: 
      return 2130838053;
    }
    return 2130838047;
  }
  
  public static GhostImage getJob(int paramInt, MiniJob paramMiniJob)
  {
    return getGhostImage(paramInt, getJobImage(paramInt), entityUrn, 1);
  }
  
  private static int getJobImage(int paramInt)
  {
    switch (paramInt)
    {
    case 2131492962: 
    case 2131492965: 
    case 2131492966: 
    default: 
      return 2130838077;
    case 2131492960: 
      return 2130838075;
    case 2131492961: 
      return 2130838076;
    case 2131492963: 
      return 2130838078;
    case 2131492964: 
      return 2130838079;
    case 2131492967: 
      return 2130838080;
    }
    return 2130838074;
  }
  
  public static GhostImage getPeople$40c7869d()
  {
    return getGhostImage(2131492963, 2130838225, null, 0);
  }
  
  public static GhostImage getPerson(int paramInt, MiniProfile paramMiniProfile)
  {
    return getGhostImage(paramInt, getPersonImage(paramInt), entityUrn, 0);
  }
  
  private static int getPersonImage(int paramInt)
  {
    switch (paramInt)
    {
    case 2131492962: 
    case 2131492965: 
    case 2131492966: 
    default: 
      return 2130838234;
    case 2131492960: 
      return 2130838232;
    case 2131492961: 
      return 2130838233;
    case 2131492963: 
      return 2130838235;
    case 2131492964: 
      return 2130838236;
    case 2131492967: 
      return 2130838237;
    case 2131492968: 
      return 2130838230;
    }
    return 2130838231;
  }
  
  public static GhostImage getSchool(int paramInt, MiniSchool paramMiniSchool)
  {
    return getGhostImage(paramInt, getSchoolImage(paramInt), entityUrn, 1);
  }
  
  private static int getSchoolImage(int paramInt)
  {
    switch (paramInt)
    {
    case 2131492962: 
    case 2131492965: 
    case 2131492966: 
    default: 
      return 2130838318;
    case 2131492960: 
      return 2130838316;
    case 2131492961: 
      return 2130838317;
    case 2131492963: 
      return 2130838319;
    case 2131492964: 
      return 2130838320;
    case 2131492967: 
      return 2130838321;
    }
    return 2130838315;
  }
  
  public static GhostImage getUnstructuredCompany(int paramInt)
  {
    return getGhostImage(paramInt, getCompanyImage(paramInt), null, 1);
  }
  
  public static GhostImage getUnstructuredGroup(int paramInt)
  {
    return getGhostImage(paramInt, getGroupImage(paramInt), null, 1);
  }
  
  public static GhostImage getUnstructuredJob(int paramInt)
  {
    return getGhostImage(paramInt, getJobImage(paramInt), null, 1);
  }
  
  public static GhostImage getUnstructuredSchool(int paramInt)
  {
    return getGhostImage(paramInt, getSchoolImage(paramInt), null, 1);
  }
  
  public static void setLixManager(LixManager paramLixManager)
  {
    lixManager = paramLixManager;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.GhostImageUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */