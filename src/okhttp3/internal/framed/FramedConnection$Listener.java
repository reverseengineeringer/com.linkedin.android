package okhttp3.internal.framed;

import java.io.IOException;

public abstract class FramedConnection$Listener
{
  public static final Listener REFUSE_INCOMING_STREAMS = new FramedConnection.Listener.1();
  
  public void onSettings(FramedConnection paramFramedConnection) {}
  
  public abstract void onStream(FramedStream paramFramedStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     okhttp3.internal.framed.FramedConnection.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */