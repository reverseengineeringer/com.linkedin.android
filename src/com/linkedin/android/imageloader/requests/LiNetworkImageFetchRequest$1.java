package com.linkedin.android.imageloader.requests;

final class LiNetworkImageFetchRequest$1
  implements com.linkedin.android.networking.interfaces.PerfEventListener
{
  LiNetworkImageFetchRequest$1(LiNetworkImageFetchRequest paramLiNetworkImageFetchRequest) {}
  
  public final void didReceiveFirstChunk(String paramString)
  {
    LiNetworkImageFetchRequest.access$000(this$0).didReceiveFirstChunk(paramString);
  }
  
  public final void dnsLookupDidEnd(String paramString)
  {
    LiNetworkImageFetchRequest.access$000(this$0).dnsLookupDidEnd(paramString);
  }
  
  public final void dnsLookupWillStart(String paramString)
  {
    LiNetworkImageFetchRequest.access$000(this$0).dnsLookupWillStart(paramString);
  }
  
  public final void requestDidEnd(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    LiNetworkImageFetchRequest.access$000(this$0).requestDidEnd(paramString1, paramLong1, paramLong2, paramString2);
  }
  
  public final void requestWillStart(String paramString)
  {
    LiNetworkImageFetchRequest.access$000(this$0).networkRequestWillStart(paramString);
  }
  
  public final void setCDNProvider$16da05f7(String paramString) {}
  
  public final void setPopId(String paramString)
  {
    LiNetworkImageFetchRequest.access$000(this$0).setPopId(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiNetworkImageFetchRequest.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */