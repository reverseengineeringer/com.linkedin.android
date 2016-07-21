package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  
  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    List localList = getSubjectAltNames(paramX509Certificate, 7);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    return localArrayList;
  }
  
  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      Iterator localIterator = paramX509Certificate.iterator();
      for (;;)
      {
        paramX509Certificate = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramX509Certificate = (List)localIterator.next();
        if ((paramX509Certificate != null) && (paramX509Certificate.size() >= 2))
        {
          Integer localInteger = (Integer)paramX509Certificate.get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            paramX509Certificate = (String)paramX509Certificate.get(1);
            if (paramX509Certificate != null) {
              localArrayList.add(paramX509Certificate);
            }
          }
        }
      }
      return paramX509Certificate;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      paramX509Certificate = Collections.emptyList();
    }
  }
  
  private static boolean verifyHostname(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith(".."))) {}
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.startsWith(".")) || (paramString2.endsWith("..")));
          str = paramString1;
          if (!paramString1.endsWith(".")) {
            str = paramString1 + '.';
          }
          paramString1 = paramString2;
          if (!paramString2.endsWith(".")) {
            paramString1 = paramString2 + '.';
          }
          paramString1 = paramString1.toLowerCase(Locale.US);
          if (!paramString1.contains("*")) {
            return str.equals(paramString1);
          }
        } while ((!paramString1.startsWith("*.")) || (paramString1.indexOf('*', 1) != -1) || (str.length() < paramString1.length()) || ("*.".equals(paramString1)));
        paramString1 = paramString1.substring(1);
      } while (!str.endsWith(paramString1));
      i = str.length() - paramString1.length();
    } while ((i > 0) && (str.lastIndexOf('.', i - 1) != -1));
    return true;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      paramSSLSession = (X509Certificate)paramSSLSession.getPeerCertificates()[0];
      int j;
      int i;
      label89:
      DistinguishedNameParser localDistinguishedNameParser;
      if (Util.verifyAsIpAddress(paramString))
      {
        paramSSLSession = getSubjectAltNames(paramSSLSession, 7);
        j = paramSSLSession.size();
        i = 0;
        if (i >= j) {
          break label717;
        }
        if (paramString.equalsIgnoreCase((String)paramSSLSession.get(i))) {
          return true;
        }
      }
      else
      {
        String str = paramString.toLowerCase(Locale.US);
        paramString = getSubjectAltNames(paramSSLSession, 2);
        int k = paramString.size();
        j = 0;
        i = 0;
        if (j < k)
        {
          if (!verifyHostname(str, (String)paramString.get(j))) {
            break label719;
          }
          return true;
        }
        if (i == 0)
        {
          localDistinguishedNameParser = new DistinguishedNameParser(paramSSLSession.getSubjectX500Principal());
          pos = 0;
          beg = 0;
          end = 0;
          cur = 0;
          chars = dn.toCharArray();
          paramSSLSession = localDistinguishedNameParser.nextAT();
          if (paramSSLSession != null) {
            break label707;
          }
          paramString = null;
          while (paramString != null)
          {
            return verifyHostname(str, paramString);
            label194:
            paramString = "";
            if (pos == length) {
              paramString = null;
            } else {
              switch (chars[pos])
              {
              }
            }
          }
        }
      }
      for (;;)
      {
        paramString = localDistinguishedNameParser.escapedAV();
        while (!"cn".equalsIgnoreCase(paramSSLSession))
        {
          if (pos < length) {
            break label579;
          }
          paramString = null;
          break;
          pos += 1;
          beg = pos;
          end = beg;
          if (pos == length) {
            throw new IllegalStateException("Unexpected end of DN: " + dn);
          }
          if (chars[pos] == '"') {
            for (pos += 1; (pos < length) && (chars[pos] == ' '); pos += 1) {}
          }
          if (chars[pos] == '\\') {
            chars[end] = localDistinguishedNameParser.getEscaped();
          }
          for (;;)
          {
            pos += 1;
            end += 1;
            break;
            chars[end] = chars[pos];
          }
          paramString = new String(chars, beg, end - beg);
          continue;
          paramString = localDistinguishedNameParser.hexAV();
        }
        label579:
        if ((chars[pos] != ',') && (chars[pos] != ';') && (chars[pos] != '+')) {
          throw new IllegalStateException("Malformed DN: " + dn);
        }
        pos += 1;
        paramSSLSession = localDistinguishedNameParser.nextAT();
        if (paramSSLSession == null)
        {
          throw new IllegalStateException("Malformed DN: " + dn);
          return false;
          label707:
          break label194;
          i += 1;
          break;
          label717:
          return false;
          label719:
          j += 1;
          i = 1;
          break label89;
        }
        break label194;
      }
      return false;
    }
    catch (SSLException paramString) {}
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.tls.OkHostnameVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */