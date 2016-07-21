package android.support.v7.app;

final class TwilightCalculator
{
  static TwilightCalculator sInstance;
  public int state;
  public long sunrise;
  public long sunset;
  
  public final void calculateTwilight(long paramLong, double paramDouble1, double paramDouble2)
  {
    float f1 = (float)(paramLong - 946728000000L) / 8.64E7F;
    float f2 = 6.24006F + 0.01720197F * f1;
    double d = f2 + 0.03341960161924362D * Math.sin(f2) + 3.4906598739326E-4D * Math.sin(2.0F * f2) + 5.236000106378924E-6D * Math.sin(3.0F * f2) + 1.796593063D + 3.141592653589793D;
    paramDouble2 = -paramDouble2 / 360.0D;
    paramDouble2 = (float)Math.round(f1 - 9.0E-4F - paramDouble2) + 9.0E-4F + paramDouble2 + 0.0053D * Math.sin(f2) + -0.0069D * Math.sin(2.0D * d);
    d = Math.asin(Math.sin(d) * Math.sin(0.4092797040939331D));
    paramDouble1 *= 0.01745329238474369D;
    paramDouble1 = (Math.sin(-0.10471975803375244D) - Math.sin(paramDouble1) * Math.sin(d)) / (Math.cos(paramDouble1) * Math.cos(d));
    if (paramDouble1 >= 1.0D)
    {
      state = 1;
      sunset = -1L;
      sunrise = -1L;
      return;
    }
    if (paramDouble1 <= -1.0D)
    {
      state = 0;
      sunset = -1L;
      sunrise = -1L;
      return;
    }
    f1 = (float)(Math.acos(paramDouble1) / 6.283185307179586D);
    sunset = (Math.round((f1 + paramDouble2) * 8.64E7D) + 946728000000L);
    sunrise = (Math.round((paramDouble2 - f1) * 8.64E7D) + 946728000000L);
    if ((sunrise < paramLong) && (sunset > paramLong))
    {
      state = 0;
      return;
    }
    state = 1;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.TwilightCalculator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */