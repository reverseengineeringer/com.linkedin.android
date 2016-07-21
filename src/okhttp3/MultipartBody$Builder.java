package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;

public final class MultipartBody$Builder
{
  private final ByteString boundary;
  private final List<MultipartBody.Part> parts = new ArrayList();
  private MediaType type = MultipartBody.MIXED;
  
  public MultipartBody$Builder()
  {
    this(UUID.randomUUID().toString());
  }
  
  private MultipartBody$Builder(String paramString)
  {
    boundary = ByteString.encodeUtf8(paramString);
  }
  
  public final Builder addPart(Headers paramHeaders, RequestBody paramRequestBody)
  {
    return addPart(MultipartBody.Part.create(paramHeaders, paramRequestBody));
  }
  
  public final Builder addPart(MultipartBody.Part paramPart)
  {
    if (paramPart == null) {
      throw new NullPointerException("part == null");
    }
    parts.add(paramPart);
    return this;
  }
  
  public final MultipartBody build()
  {
    if (parts.isEmpty()) {
      throw new IllegalStateException("Multipart body must have at least one part.");
    }
    return new MultipartBody(boundary, type, parts);
  }
  
  public final Builder setType(MediaType paramMediaType)
  {
    if (paramMediaType == null) {
      throw new NullPointerException("type == null");
    }
    if (!type.equals("multipart")) {
      throw new IllegalArgumentException("multipart != " + paramMediaType);
    }
    type = paramMediaType;
    return this;
  }
}

/* Location:
 * Qualified Name:     okhttp3.MultipartBody.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */