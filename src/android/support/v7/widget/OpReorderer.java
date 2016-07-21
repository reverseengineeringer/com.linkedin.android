package android.support.v7.widget;

final class OpReorderer
{
  final Callback mCallback;
  
  public OpReorderer(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  static abstract interface Callback
  {
    public abstract AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.OpReorderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */