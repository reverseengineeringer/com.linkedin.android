package okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString EMPTY = of(new byte[0]);
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  final byte[] data;
  transient int hashCode;
  transient String utf8;
  
  ByteString(byte[] paramArrayOfByte)
  {
    data = paramArrayOfByte;
  }
  
  public static ByteString decodeBase64(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("base64 == null");
    }
    paramString = Base64.decode(paramString);
    if (paramString != null) {
      return new ByteString(paramString);
    }
    return null;
  }
  
  private ByteString digest(String paramString)
  {
    try
    {
      paramString = of(MessageDigest.getInstance(paramString).digest(data));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static ByteString encodeUtf8(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    ByteString localByteString = new ByteString(paramString.getBytes(Util.UTF_8));
    utf8 = paramString;
    return localByteString;
  }
  
  public static ByteString of(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new ByteString((byte[])paramVarArgs.clone());
  }
  
  public String base64()
  {
    return Base64.encode(data);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return ((paramObject instanceof ByteString)) && (((ByteString)paramObject).size() == data.length) && (((ByteString)paramObject).rangeEquals(0, data, 0, data.length));
  }
  
  public byte getByte(int paramInt)
  {
    return data[paramInt];
  }
  
  public int hashCode()
  {
    int i = hashCode;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(data);
    hashCode = i;
    return i;
  }
  
  public String hex()
  {
    char[] arrayOfChar = new char[data.length * 2];
    byte[] arrayOfByte = data;
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = HEX_DIGITS[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = HEX_DIGITS[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public ByteString md5()
  {
    return digest("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 <= data.length - paramInt3) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (Util.arrayRangeEquals(data, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public int size()
  {
    return data.length;
  }
  
  public ByteString toAsciiLowercase()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this;
      if (i < data.length)
      {
        int j = data[i];
        if ((j >= 65) && (j <= 90))
        {
          localObject = (byte[])data.clone();
          localObject[i] = ((byte)(j + 32));
          i += 1;
          while (i < localObject.length)
          {
            j = localObject[i];
            if ((j >= 65) && (j <= 90)) {
              localObject[i] = ((byte)(j + 32));
            }
            i += 1;
          }
          localObject = new ByteString((byte[])localObject);
        }
      }
      else
      {
        return (ByteString)localObject;
      }
      i += 1;
    }
  }
  
  public byte[] toByteArray()
  {
    return (byte[])data.clone();
  }
  
  public String toString()
  {
    if (data.length == 0) {
      return "ByteString[size=0]";
    }
    if (data.length <= 16) {
      return String.format("ByteString[size=%s data=%s]", new Object[] { Integer.valueOf(data.length), hex() });
    }
    return String.format("ByteString[size=%s md5=%s]", new Object[] { Integer.valueOf(data.length), md5().hex() });
  }
  
  public String utf8()
  {
    String str = utf8;
    if (str != null) {
      return str;
    }
    str = new String(data, Util.UTF_8);
    utf8 = str;
    return str;
  }
  
  void write(Buffer paramBuffer)
  {
    paramBuffer.write(data, 0, data.length);
  }
}

/* Location:
 * Qualified Name:     okio.ByteString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */