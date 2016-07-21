package android.support.v4.text;

final class TextDirectionHeuristicsCompat$AnyStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
  public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
  private final boolean mLookForRtl;
  
  private TextDirectionHeuristicsCompat$AnyStrong(boolean paramBoolean)
  {
    mLookForRtl = paramBoolean;
  }
  
  public final int checkRtl$4d1ed0d4(CharSequence paramCharSequence, int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j < paramInt + 0) {
        switch (TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(paramCharSequence.charAt(j))))
        {
        default: 
          j += 1;
          break;
        case 0: 
          if (!mLookForRtl) {}
          break;
        }
      }
    }
    do
    {
      return 0;
      i = 1;
      break;
      if (!mLookForRtl) {
        return 1;
      }
      i = 1;
      break;
      if (i == 0) {
        break label98;
      }
    } while (!mLookForRtl);
    return 1;
    label98:
    return 2;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */