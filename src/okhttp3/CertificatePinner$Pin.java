package okhttp3;

import okio.ByteString;

final class CertificatePinner$Pin
{
  final ByteString hash;
  final String hashAlgorithm;
  final String pattern;
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Pin)) && (pattern.equals(pattern)) && (hashAlgorithm.equals(hashAlgorithm)) && (hash.equals(hash));
  }
  
  public final int hashCode()
  {
    return ((pattern.hashCode() + 527) * 31 + hashAlgorithm.hashCode()) * 31 + hash.hashCode();
  }
  
  public final String toString()
  {
    return hashAlgorithm + hash.base64();
  }
}

/* Location:
 * Qualified Name:     okhttp3.CertificatePinner.Pin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */