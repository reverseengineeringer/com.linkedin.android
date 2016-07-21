package android.support.v4.text;

abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
  implements TextDirectionHeuristicCompat
{
  private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
  
  public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm)
  {
    mAlgorithm = paramTextDirectionAlgorithm;
  }
  
  protected abstract boolean defaultIsRtl();
  
  public final boolean isRtl$4d1ed0c3(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
      throw new IllegalArgumentException();
    }
    if (mAlgorithm == null) {
      return defaultIsRtl();
    }
    switch (mAlgorithm.checkRtl$4d1ed0d4(paramCharSequence, paramInt))
    {
    default: 
      return defaultIsRtl();
    case 0: 
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */