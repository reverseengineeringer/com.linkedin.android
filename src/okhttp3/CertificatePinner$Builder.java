package okhttp3;

import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.tls.TrustRootIndex;

public final class CertificatePinner$Builder
{
  final List<CertificatePinner.Pin> pins = new ArrayList();
  TrustRootIndex trustRootIndex;
  
  public CertificatePinner$Builder() {}
  
  CertificatePinner$Builder(CertificatePinner paramCertificatePinner)
  {
    pins.addAll(CertificatePinner.access$200(paramCertificatePinner));
    trustRootIndex = CertificatePinner.access$300(paramCertificatePinner);
  }
  
  public final CertificatePinner build()
  {
    return new CertificatePinner(this, (byte)0);
  }
}

/* Location:
 * Qualified Name:     okhttp3.CertificatePinner.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */