package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class Okio
{
  private static final Logger logger = Logger.getLogger(Okio.class.getName());
  
  public static Sink appendingSink(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return sink(new FileOutputStream(paramFile, true));
  }
  
  public static BufferedSink buffer(Sink paramSink)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    return new RealBufferedSink(paramSink);
  }
  
  public static BufferedSource buffer(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    return new RealBufferedSource(paramSource);
  }
  
  public static Sink sink(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return sink(new FileOutputStream(paramFile));
  }
  
  private static Sink sink(OutputStream paramOutputStream)
  {
    return sink(paramOutputStream, new Timeout());
  }
  
  private static Sink sink(OutputStream paramOutputStream, Timeout paramTimeout)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramTimeout == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new Okio.1(paramTimeout, paramOutputStream);
  }
  
  public static Sink sink(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    AsyncTimeout localAsyncTimeout = timeout(paramSocket);
    return new AsyncTimeout.1(localAsyncTimeout, sink(paramSocket.getOutputStream(), localAsyncTimeout));
  }
  
  public static Source source(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return source(new FileInputStream(paramFile));
  }
  
  public static Source source(InputStream paramInputStream)
  {
    return source(paramInputStream, new Timeout());
  }
  
  private static Source source(InputStream paramInputStream, Timeout paramTimeout)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramTimeout == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new Okio.2(paramTimeout, paramInputStream);
  }
  
  public static Source source(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    AsyncTimeout localAsyncTimeout = timeout(paramSocket);
    return new AsyncTimeout.2(localAsyncTimeout, source(paramSocket.getInputStream(), localAsyncTimeout));
  }
  
  private static AsyncTimeout timeout(Socket paramSocket)
  {
    return new Okio.3(paramSocket);
  }
}

/* Location:
 * Qualified Name:     okio.Okio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */