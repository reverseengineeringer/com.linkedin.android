package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileViewCard
  implements FissileDataModel<ProfileViewCard>, RecordTemplate<ProfileViewCard>
{
  public static final ProfileViewCardBuilder BUILDER = ProfileViewCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHeadline;
  public final boolean hasInsight;
  public final boolean hasProfileViewCta;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasViewer;
  public final AttributedText headline;
  public final Insight insight;
  public final AttributedText profileViewCta;
  public final long publishedAt;
  public final boolean read;
  public final ProfileViewer viewer;
  
  ProfileViewCard(long paramLong, ProfileViewer paramProfileViewer, Insight paramInsight, boolean paramBoolean1, AttributedText paramAttributedText1, AttributedText paramAttributedText2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    publishedAt = paramLong;
    viewer = paramProfileViewer;
    insight = paramInsight;
    read = paramBoolean1;
    headline = paramAttributedText1;
    profileViewCta = paramAttributedText2;
    hasPublishedAt = paramBoolean2;
    hasViewer = paramBoolean3;
    hasInsight = paramBoolean4;
    hasRead = paramBoolean5;
    hasHeadline = paramBoolean6;
    hasProfileViewCta = paramBoolean7;
    _cachedId = null;
  }
  
  public final ProfileViewCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    Object localObject3;
    boolean bool2;
    label120:
    label131:
    Object localObject4;
    boolean bool3;
    if (hasViewer)
    {
      paramDataProcessor.startRecordField$505cff1c("viewer");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = viewer.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label318;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label327;
        }
        localObject1 = insight.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label345;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      localObject4 = null;
      bool3 = false;
      if (hasHeadline)
      {
        paramDataProcessor.startRecordField$505cff1c("headline");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label354;
        }
        localObject1 = headline.accept(paramDataProcessor);
        label196:
        if (localObject1 == null) {
          break label372;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label208:
      localObject1 = null;
      bool4 = false;
      if (hasProfileViewCta)
      {
        paramDataProcessor.startRecordField$505cff1c("profileViewCta");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label382;
        }
        localObject1 = profileViewCta.accept(paramDataProcessor);
        label248:
        if (localObject1 == null) {
          break label400;
        }
      }
    }
    label318:
    label327:
    label345:
    label354:
    label372:
    label382:
    label400:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label482;
      }
      try
      {
        if (hasPublishedAt) {
          break label406;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (ProfileViewer)paramDataProcessor.processDataTemplate(viewer);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headline);
      break label196;
      bool3 = false;
      localObject4 = localObject1;
      break label208;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(profileViewCta);
      break label248;
    }
    label406:
    if (!hasViewer) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "viewer");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "read");
    }
    return new ProfileViewCard(publishedAt, (ProfileViewer)localObject2, (Insight)localObject3, read, (AttributedText)localObject4, (AttributedText)localObject1, hasPublishedAt, bool1, bool2, hasRead, bool3, bool4);
    label482:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ProfileViewCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (viewer != null)
      {
        if (viewer.equals(viewer)) {}
      }
      else {
        while (viewer != null) {
          return false;
        }
      }
      if (insight != null)
      {
        if (insight.equals(insight)) {}
      }
      else {
        while (insight != null) {
          return false;
        }
      }
      if (read != read) {
        return false;
      }
      if (headline != null)
      {
        if (headline.equals(headline)) {}
      }
      else {
        while (headline != null) {
          return false;
        }
      }
      if (profileViewCta == null) {
        break;
      }
    } while (profileViewCta.equals(profileViewCta));
    for (;;)
    {
      return false;
      if (profileViewCta == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasViewer)
    {
      i = j + 1;
      if (viewer._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viewer._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasInsight)
      {
        i = j + 1;
        if (insight._cachedId == null) {
          break label239;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
      label118:
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasHeadline)
      {
        i = j + 1;
        if (headline._cachedId == null) {
          break label252;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headline._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasProfileViewCta)
      {
        i = j + 1;
        if (profileViewCta._cachedId == null) {
          break label265;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(profileViewCta._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += viewer.getSerializedSize();
      break;
      label239:
      i += insight.getSerializedSize();
      break label118;
      label252:
      i += headline.getSerializedSize();
      break label177;
      label265:
      i += profileViewCta.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = (int)(publishedAt ^ publishedAt >>> 32);
    int i;
    int j;
    label60:
    int k;
    if (viewer != null)
    {
      i = viewer.hashCode();
      if (insight == null) {
        break label147;
      }
      j = insight.hashCode();
      if (!read) {
        break label152;
      }
      k = 1;
      label69:
      if (headline == null) {
        break label157;
      }
    }
    label147:
    label152:
    label157:
    for (int m = headline.hashCode();; m = 0)
    {
      if (profileViewCta != null) {
        n = profileViewCta.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
      k = 0;
      break label69;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileViewCard");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label194:
    label254:
    label278:
    label287:
    label347:
    label450:
    label475:
    label485:
    label510:
    label520:
    label526:
    label536:
    label561:
    label571:
    label596:
    label604:
    label606:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1920002853);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasViewer) {
            break label475;
          }
          localByteBuffer.put((byte)1);
          if (viewer._cachedId == null) {
            break label450;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, viewer._cachedId);
          viewer.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInsight) {
            break label510;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label485;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRead) {
            break label526;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label520;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasHeadline) {
            break label561;
          }
          localByteBuffer.put((byte)1);
          if (headline._cachedId == null) {
            break label536;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headline._cachedId);
          headline.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasProfileViewCta) {
            break label596;
          }
          localByteBuffer.put((byte)1);
          if (profileViewCta._cachedId == null) {
            break label571;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, profileViewCta._cachedId);
          profileViewCta.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label604;
          }
          if (str != null) {
            break label606;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          viewer.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label194;
          localByteBuffer.put((byte)0);
          break label194;
          localByteBuffer.put((byte)1);
          insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label254;
          localByteBuffer.put((byte)0);
          break label254;
          i = 0;
          break label278;
          localByteBuffer.put((byte)0);
          break label287;
          localByteBuffer.put((byte)1);
          headline.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label347;
          localByteBuffer.put((byte)0);
          break label347;
          localByteBuffer.put((byte)1);
          profileViewCta.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<ProfileViewCard>
  {
    private boolean hasHeadline = false;
    private boolean hasInsight = false;
    private boolean hasProfileViewCta = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasViewer = false;
    private AttributedText headline = null;
    private Insight insight = null;
    private AttributedText profileViewCta = null;
    private long publishedAt = 0L;
    public boolean read = false;
    private ProfileViewer viewer = null;
    
    public Builder() {}
    
    public Builder(ProfileViewCard paramProfileViewCard)
    {
      publishedAt = publishedAt;
      viewer = viewer;
      insight = insight;
      read = read;
      headline = headline;
      profileViewCta = profileViewCta;
      hasPublishedAt = hasPublishedAt;
      hasViewer = hasViewer;
      hasInsight = hasInsight;
      hasRead = hasRead;
      hasHeadline = hasHeadline;
      hasProfileViewCta = hasProfileViewCta;
    }
    
    public final ProfileViewCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileViewCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ProfileViewCard(publishedAt, viewer, insight, read, headline, profileViewCta, hasPublishedAt, hasViewer, hasInsight, hasRead, hasHeadline, hasProfileViewCta);
        if (!hasPublishedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "publishedAt");
        }
        if (!hasViewer) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "viewer");
        }
      } while (hasRead);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard", "read");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */