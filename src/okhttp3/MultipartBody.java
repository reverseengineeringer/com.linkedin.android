package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody
  extends RequestBody
{
  public static final MediaType ALTERNATIVE;
  private static final byte[] COLONSPACE = { 58, 32 };
  private static final byte[] CRLF = { 13, 10 };
  private static final byte[] DASHDASH = { 45, 45 };
  public static final MediaType DIGEST;
  public static final MediaType FORM;
  public static final MediaType MIXED = MediaType.parse("multipart/mixed");
  public static final MediaType PARALLEL;
  private final ByteString boundary;
  private long contentLength = -1L;
  private final MediaType contentType;
  private final MediaType originalType;
  private final List<Part> parts;
  
  static
  {
    ALTERNATIVE = MediaType.parse("multipart/alternative");
    DIGEST = MediaType.parse("multipart/digest");
    PARALLEL = MediaType.parse("multipart/parallel");
    FORM = MediaType.parse("multipart/form-data");
  }
  
  MultipartBody(ByteString paramByteString, MediaType paramMediaType, List<Part> paramList)
  {
    boundary = paramByteString;
    originalType = paramMediaType;
    contentType = MediaType.parse(paramMediaType + "; boundary=" + paramByteString.utf8());
    parts = Util.immutableList(paramList);
  }
  
  private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
    throws IOException
  {
    long l1 = 0L;
    Buffer localBuffer = null;
    if (paramBoolean)
    {
      localBuffer = new Buffer();
      paramBufferedSink = localBuffer;
    }
    int i = 0;
    int k = parts.size();
    if (i < k)
    {
      Object localObject2 = (Part)parts.get(i);
      Object localObject1 = headers;
      localObject2 = body;
      paramBufferedSink.write(DASHDASH);
      paramBufferedSink.write(boundary);
      paramBufferedSink.write(CRLF);
      if (localObject1 != null)
      {
        int j = 0;
        int m = namesAndValues.length / 2;
        while (j < m)
        {
          paramBufferedSink.writeUtf8(((Headers)localObject1).name(j)).write(COLONSPACE).writeUtf8(((Headers)localObject1).value(j)).write(CRLF);
          j += 1;
        }
      }
      localObject1 = ((RequestBody)localObject2).contentType();
      if (localObject1 != null) {
        paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject1).toString()).write(CRLF);
      }
      l2 = ((RequestBody)localObject2).contentLength();
      if (l2 != -1L)
      {
        paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(CRLF);
        label256:
        paramBufferedSink.write(CRLF);
        if (!paramBoolean) {
          break label307;
        }
        l1 += l2;
      }
      for (;;)
      {
        paramBufferedSink.write(CRLF);
        i += 1;
        break;
        if (!paramBoolean) {
          break label256;
        }
        localBuffer.clear();
        return -1L;
        label307:
        ((RequestBody)localObject2).writeTo(paramBufferedSink);
      }
    }
    paramBufferedSink.write(DASHDASH);
    paramBufferedSink.write(boundary);
    paramBufferedSink.write(DASHDASH);
    paramBufferedSink.write(CRLF);
    long l2 = l1;
    if (paramBoolean)
    {
      l2 = l1 + size;
      localBuffer.clear();
    }
    return l2;
  }
  
  public final long contentLength()
    throws IOException
  {
    long l = contentLength;
    if (l != -1L) {
      return l;
    }
    l = writeOrCountBytes(null, true);
    contentLength = l;
    return l;
  }
  
  public final MediaType contentType()
  {
    return contentType;
  }
  
  public final void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  public static final class Builder
  {
    private final ByteString boundary;
    private final List<MultipartBody.Part> parts = new ArrayList();
    private MediaType type = MultipartBody.MIXED;
    
    public Builder()
    {
      this(UUID.randomUUID().toString());
    }
    
    private Builder(String paramString)
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
  
  public static final class Part
  {
    final RequestBody body;
    final Headers headers;
    
    private Part(Headers paramHeaders, RequestBody paramRequestBody)
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
}

/* Location:
 * Qualified Name:     okhttp3.MultipartBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */