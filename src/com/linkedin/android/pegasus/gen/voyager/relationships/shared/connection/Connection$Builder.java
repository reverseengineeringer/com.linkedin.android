package com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection;

import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.TwitterHandle;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Connection$Builder
  implements RecordTemplateBuilder<Connection>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  public boolean hasMiniProfile = false;
  private boolean hasPhoneNumbers = false;
  private boolean hasPrimaryEmailAddress = false;
  private boolean hasTwitterHandles = false;
  private boolean hasWeChatContactInfo = false;
  public MiniProfile miniProfile = null;
  private List<PhoneNumber> phoneNumbers = null;
  private String primaryEmailAddress = null;
  private List<TwitterHandle> twitterHandles = null;
  private WeChatContactInfo weChatContactInfo = null;
  
  private Connection build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Connection.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (phoneNumbers != null)
    {
      paramFlavor = phoneNumbers.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((PhoneNumber)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "phoneNumbers");
            if (!hasPhoneNumbers) {
              phoneNumbers = Collections.emptyList();
            }
            if (!hasTwitterHandles) {
              twitterHandles = Collections.emptyList();
            }
            if (hasMiniProfile) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "miniProfile");
          }
        }
      }
    }
    if (twitterHandles != null)
    {
      paramFlavor = twitterHandles.iterator();
      while (paramFlavor.hasNext()) {
        if ((TwitterHandle)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "twitterHandles");
        }
      }
    }
    return new Connection(entityUrn, miniProfile, phoneNumbers, primaryEmailAddress, twitterHandles, weChatContactInfo, hasEntityUrn, hasMiniProfile, hasPhoneNumbers, hasPrimaryEmailAddress, hasTwitterHandles, hasWeChatContactInfo);
  }
  
  public final Connection build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */