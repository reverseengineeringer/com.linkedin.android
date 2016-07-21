package okhttp3;

final class ConnectionPool$1
  implements Runnable
{
  ConnectionPool$1(ConnectionPool paramConnectionPool) {}
  
  public final void run()
  {
    long l1;
    do
    {
      l1 = this$0.cleanup(System.nanoTime());
      if (l1 == -1L) {
        return;
      }
    } while (l1 <= 0L);
    long l2 = l1 / 1000000L;
    try
    {
      synchronized (this$0)
      {
        this$0.wait(l2, (int)(l1 - l2 * 1000000L));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.ConnectionPool.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */