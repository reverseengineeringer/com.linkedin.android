package android.support.v4.text;

final class TextDirectionHeuristicsCompat$FirstStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final FirstStrong INSTANCE = new FirstStrong();
  
  public final int checkRtl$4d1ed0d4(CharSequence paramCharSequence, int paramInt)
  {
    int j = 2;
    int i = 0;
    while ((i < paramInt + 0) && (j == 2))
    {
      j = TextDirectionHeuristicsCompat.access$100(Character.getDirectionality(paramCharSequence.charAt(i)));
      i += 1;
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.FirstStrong
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */