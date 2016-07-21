package android.support.v4.text;

import java.util.Locale;

public final class TextDirectionHeuristicsCompat
{
  public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false, (byte)0);
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
  public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.INSTANCE;
  public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false, (byte)0);
  public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true, (byte)0);
  
  static
  {
    FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false, (byte)0);
    FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true, (byte)0);
  }
  
  private static final class AnyStrong
    implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
  {
    public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
    private final boolean mLookForRtl;
    
    private AnyStrong(boolean paramBoolean)
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
  
  private static final class FirstStrong
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
  
  private static abstract interface TextDirectionAlgorithm
  {
    public abstract int checkRtl$4d1ed0d4(CharSequence paramCharSequence, int paramInt);
  }
  
  private static abstract class TextDirectionHeuristicImpl
    implements TextDirectionHeuristicCompat
  {
    private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
    
    public TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm)
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
  
  private static final class TextDirectionHeuristicInternal
    extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
  {
    private final boolean mDefaultIsRtl;
    
    private TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm, boolean paramBoolean)
    {
      super();
      mDefaultIsRtl = paramBoolean;
    }
    
    protected final boolean defaultIsRtl()
    {
      return mDefaultIsRtl;
    }
  }
  
  private static final class TextDirectionHeuristicLocale
    extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
  {
    public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
    
    public TextDirectionHeuristicLocale()
    {
      super();
    }
    
    protected final boolean defaultIsRtl()
    {
      return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */