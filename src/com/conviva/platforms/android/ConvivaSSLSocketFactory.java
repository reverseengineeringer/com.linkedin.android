package com.conviva.platforms.android;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;

public final class ConvivaSSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public ConvivaSSLSocketFactory(SSLContext paramSSLContext)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(null);
    sslContext = paramSSLContext;
  }
  
  public final Socket createSocket()
    throws IOException
  {
    return sslContext.getSocketFactory().createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.ConvivaSSLSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */