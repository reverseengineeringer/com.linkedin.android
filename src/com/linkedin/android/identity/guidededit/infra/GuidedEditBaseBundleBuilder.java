package com.linkedin.android.identity.guidededit.infra;

import android.os.Bundle;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;

public class GuidedEditBaseBundleBuilder
  implements BundleBuilder
{
  public Bundle bundle;
  
  public static GuidedEditBaseBundleBuilder copy(Bundle paramBundle)
  {
    GuidedEditBaseBundleBuilder localGuidedEditBaseBundleBuilder = new GuidedEditBaseBundleBuilder();
    bundle = new Bundle(paramBundle);
    return localGuidedEditBaseBundleBuilder;
  }
  
  public static GuidedEditBaseBundleBuilder create()
  {
    GuidedEditBaseBundleBuilder localGuidedEditBaseBundleBuilder = new GuidedEditBaseBundleBuilder();
    bundle = new Bundle();
    return localGuidedEditBaseBundleBuilder;
  }
  
  public static GuidedEditCategory getCategory(Bundle paramBundle)
  {
    return (GuidedEditCategory)RecordParceler.quietUnparcel(GuidedEditCategory.BUILDER, "category", paramBundle);
  }
  
  public static GuidedEditSource getGuidedEditSource(Bundle paramBundle)
  {
    paramBundle = (GuidedEditSource)paramBundle.getSerializable("guidedEditSource");
    if (paramBundle != null) {
      return paramBundle;
    }
    return GuidedEditSource.$UNKNOWN;
  }
  
  public static GuidedEditBaseBundleBuilder wrap(Bundle paramBundle)
  {
    GuidedEditBaseBundleBuilder localGuidedEditBaseBundleBuilder = new GuidedEditBaseBundleBuilder();
    bundle = paramBundle;
    return localGuidedEditBaseBundleBuilder;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final GuidedEditBaseBundleBuilder setCategory(GuidedEditCategory paramGuidedEditCategory)
  {
    if (paramGuidedEditCategory != null) {
      RecordParceler.quietParcel(paramGuidedEditCategory, "category", bundle);
    }
    return this;
  }
  
  public final GuidedEditBaseBundleBuilder setFlowTrackingId(String paramString)
  {
    bundle.putString("flowTrackingId", paramString);
    return this;
  }
  
  public final GuidedEditBaseBundleBuilder setGuidedEditForceCategoryPath(String paramString)
  {
    bundle.putString("guidedEditForceCategory", paramString);
    return this;
  }
  
  public final GuidedEditBaseBundleBuilder setGuidedEditSource(GuidedEditSource paramGuidedEditSource)
  {
    if (paramGuidedEditSource != null) {
      bundle.putSerializable("guidedEditSource", paramGuidedEditSource);
    }
    return this;
  }
  
  public final GuidedEditBaseBundleBuilder setPostEntityId(String paramString)
  {
    bundle.putString("postEntityID", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.GuidedEditBaseBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */