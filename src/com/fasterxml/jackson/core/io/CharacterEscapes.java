package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

public abstract class CharacterEscapes
  implements Serializable
{
  public abstract int[] getEscapeCodesForAscii();
  
  public abstract SerializableString getEscapeSequence$428277ea();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.CharacterEscapes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */