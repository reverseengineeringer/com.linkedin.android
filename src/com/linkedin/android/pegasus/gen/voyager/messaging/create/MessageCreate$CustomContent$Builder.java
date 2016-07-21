package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class MessageCreate$CustomContent$Builder
{
  public boolean hasInmailContentCreateValue = false;
  public boolean hasMiniGroupUrnValue = false;
  public boolean hasShareCreateValue = false;
  public InmailContentCreate inmailContentCreateValue = null;
  public Urn miniGroupUrnValue = null;
  public ShareCreate shareCreateValue = null;
  
  public final MessageCreate.CustomContent build()
    throws BuilderException
  {
    int j = 0;
    if (hasInmailContentCreateValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasShareCreateValue) {
      i = j + 1;
    }
    j = i;
    if (hasMiniGroupUrnValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("CustomContent", j);
    }
    return new MessageCreate.CustomContent(inmailContentCreateValue, shareCreateValue, miniGroupUrnValue, hasInmailContentCreateValue, hasShareCreateValue, hasMiniGroupUrnValue);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate.CustomContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */