package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class RecommendedPackage$Builder
  implements RecordTemplateBuilder<RecommendedPackage>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  public boolean hasPackageId = false;
  public boolean hasReason = false;
  public boolean hasRecommendationType = false;
  public boolean hasRecommendedEntities = false;
  private boolean hasSecondaryReason = false;
  public int packageId = 0;
  public AnnotatedText reason = null;
  public RecommendationType recommendationType = null;
  public List<RecommendedEntity> recommendedEntities = null;
  private AnnotatedText secondaryReason = null;
  
  public final RecommendedPackage build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (RecommendedPackage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (recommendedEntities != null)
    {
      paramFlavor = recommendedEntities.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((RecommendedEntity)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendedEntities");
            if (!hasRecommendationType) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendationType");
            }
            if (hasRecommendedEntities) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendedEntities");
          }
        }
      }
    }
    return new RecommendedPackage(packageId, recommendationType, reason, secondaryReason, recommendedEntities, entityUrn, hasPackageId, hasRecommendationType, hasReason, hasSecondaryReason, hasRecommendedEntities, hasEntityUrn);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */