package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import java.util.ArrayList;
import java.util.List;

public final class DocumentContents$zza
{
  public List<DocumentSection> zzTF;
  public String zzTG;
  public boolean zzTH;
  public Account zzTI;
  
  public final zza zza(DocumentSection paramDocumentSection)
  {
    if (zzTF == null) {
      zzTF = new ArrayList();
    }
    zzTF.add(paramDocumentSection);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentContents.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */