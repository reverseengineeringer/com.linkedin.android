package android.support.v7.widget;

public final class GridLayoutManager$DefaultSpanSizeLookup
  extends GridLayoutManager.SpanSizeLookup
{
  public final int getSpanIndex(int paramInt1, int paramInt2)
  {
    return paramInt1 % paramInt2;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.DefaultSpanSizeLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */