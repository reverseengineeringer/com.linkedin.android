package okhttp3;

public final class MultipartBody$Part
{
  final RequestBody body;
  final Headers headers;
  
  private MultipartBody$Part(Headers paramHeaders, RequestBody paramRequestBody)
  {
    headers = paramHeaders;
    body = paramRequestBody;
  }
  
  public static Part create(Headers paramHeaders, RequestBody paramRequestBody)
  {
    if (paramRequestBody == null) {
      throw new NullPointerException("body == null");
    }
    if ((paramHeaders != null) && (paramHeaders.get("Content-Type") != null)) {
      throw new IllegalArgumentException("Unexpected header: Content-Type");
    }
    if ((paramHeaders != null) && (paramHeaders.get("Content-Length") != null)) {
      throw new IllegalArgumentException("Unexpected header: Content-Length");
    }
    return new Part(paramHeaders, paramRequestBody);
  }
}

/* Location:
 * Qualified Name:     okhttp3.MultipartBody.Part
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */