package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class ContactSyncAdapter$ImageDownloader
  implements ResponseListener<byte[], Object>
{
  private final Account account;
  private final String profileId;
  final String url;
  
  public ContactSyncAdapter$ImageDownloader(ContactSyncAdapter paramContactSyncAdapter, Account paramAccount, String paramString1, String paramString2)
  {
    account = paramAccount;
    profileId = paramString1;
    url = paramString2;
  }
  
  public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
  {
    Log.v(ContactSyncAdapter.access$100(), "Failed to download photo for " + profileId, paramIOException);
  }
  
  public final Object parseErrorResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.ImageDownloader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */