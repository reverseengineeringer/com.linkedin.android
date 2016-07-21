package android.support.v4.os;

public final class OperationCanceledException
  extends RuntimeException
{
  public OperationCanceledException()
  {
    this((byte)0);
  }
  
  private OperationCanceledException(byte paramByte)
  {
    super("The operation has been canceled.");
  }
}

/* Location:
 * Qualified Name:     android.support.v4.os.OperationCanceledException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */