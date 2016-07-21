package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.TwitterHandle;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ProfileContactInfo$Builder
  implements RecordTemplateBuilder<ProfileContactInfo>
{
  private String address = null;
  public Date birthDateOn = null;
  public NetworkVisibilitySetting birthdayVisibilitySetting = null;
  private String emailAddress = null;
  private Urn entityUrn = null;
  private boolean hasAddress = false;
  public boolean hasBirthDateOn = false;
  public boolean hasBirthdayVisibilitySetting = false;
  private boolean hasEmailAddress = false;
  private boolean hasEntityUrn = false;
  private boolean hasIms = false;
  private boolean hasPhoneNumbers = false;
  public boolean hasTwitterHandles = false;
  public boolean hasWeChatContactInfo = false;
  private boolean hasWebsites = false;
  private List<IM> ims = null;
  private List<PhoneNumber> phoneNumbers = null;
  public List<TwitterHandle> twitterHandles = null;
  public WeChatContactInfo weChatContactInfo = null;
  private List<ProfileWebsite> websites = null;
  
  public final ProfileContactInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileContactInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "phoneNumbers");
            if (!hasPhoneNumbers) {
              phoneNumbers = Collections.emptyList();
            }
            if (!hasWebsites) {
              websites = Collections.emptyList();
            }
            if (!hasTwitterHandles) {
              twitterHandles = Collections.emptyList();
            }
            if (!hasIms) {
              ims = Collections.emptyList();
            }
            if (hasEntityUrn) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "entityUrn");
          }
        }
      }
    }
    if (websites != null)
    {
      paramFlavor = websites.iterator();
      while (paramFlavor.hasNext()) {
        if ((ProfileWebsite)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "websites");
        }
      }
    }
    if (twitterHandles != null)
    {
      paramFlavor = twitterHandles.iterator();
      while (paramFlavor.hasNext()) {
        if ((TwitterHandle)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "twitterHandles");
        }
      }
    }
    if (ims != null)
    {
      paramFlavor = ims.iterator();
      while (paramFlavor.hasNext()) {
        if ((IM)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "ims");
        }
      }
    }
    return new ProfileContactInfo(entityUrn, weChatContactInfo, phoneNumbers, websites, twitterHandles, ims, emailAddress, address, birthDateOn, birthdayVisibilitySetting, hasEntityUrn, hasWeChatContactInfo, hasPhoneNumbers, hasWebsites, hasTwitterHandles, hasIms, hasEmailAddress, hasAddress, hasBirthDateOn, hasBirthdayVisibilitySetting);
  }
  
  public final Builder setAddress(String paramString)
  {
    if (paramString == null)
    {
      hasAddress = false;
      address = null;
      return this;
    }
    hasAddress = true;
    address = paramString;
    return this;
  }
  
  public final Builder setEmailAddress(String paramString)
  {
    if (paramString == null)
    {
      hasEmailAddress = false;
      emailAddress = null;
      return this;
    }
    hasEmailAddress = true;
    emailAddress = paramString;
    return this;
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
  
  public final Builder setIms(List<IM> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasIms = false;
      ims = Collections.emptyList();
      return this;
    }
    hasIms = true;
    ims = paramList;
    return this;
  }
  
  public final Builder setPhoneNumbers(List<PhoneNumber> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasPhoneNumbers = false;
      phoneNumbers = Collections.emptyList();
      return this;
    }
    hasPhoneNumbers = true;
    phoneNumbers = paramList;
    return this;
  }
  
  public final Builder setWebsites(List<ProfileWebsite> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasWebsites = false;
      websites = Collections.emptyList();
      return this;
    }
    hasWebsites = true;
    websites = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */