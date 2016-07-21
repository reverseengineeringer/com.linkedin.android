package com.google.android.exoplayer.text.eia608;

import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class Eia608Parser
{
  private static final int[] BASIC_CHARACTER_SET = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] SPECIAL_CHARACTER_SET = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] SPECIAL_ES_FR_CHARACTER_SET = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] SPECIAL_PT_DE_CHARACTER_SET = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final ArrayList<ClosedCaption> captions = new ArrayList();
  private final ParsableBitArray seiBuffer = new ParsableBitArray();
  private final StringBuilder stringBuilder = new StringBuilder();
  
  private void addBufferedText()
  {
    if (stringBuilder.length() > 0)
    {
      captions.add(new ClosedCaptionText(stringBuilder.toString()));
      stringBuilder.setLength(0);
    }
  }
  
  private void addCtrl(byte paramByte1, byte paramByte2)
  {
    addBufferedText();
    captions.add(new ClosedCaptionCtrl(paramByte1, paramByte2));
  }
  
  private void backspace()
  {
    addCtrl((byte)20, (byte)33);
  }
  
  static boolean canParse(String paramString)
  {
    return paramString.equals("application/eia-608");
  }
  
  private static char getChar(byte paramByte)
  {
    return (char)BASIC_CHARACTER_SET[((paramByte & 0x7F) - 32)];
  }
  
  public static boolean isSeiMessageEia608(int paramInt1, int paramInt2, ParsableByteArray paramParsableByteArray)
  {
    if ((paramInt1 != 4) || (paramInt2 < 8)) {}
    int i;
    int j;
    int k;
    do
    {
      return false;
      paramInt1 = position;
      paramInt2 = paramParsableByteArray.readUnsignedByte();
      i = paramParsableByteArray.readUnsignedShort();
      j = paramParsableByteArray.readInt();
      k = paramParsableByteArray.readUnsignedByte();
      paramParsableByteArray.setPosition(paramInt1);
    } while ((paramInt2 != 181) || (i != 49) || (j != 1195456820) || (k != 3));
    return true;
  }
  
  final ClosedCaptionList parse(SampleHolder paramSampleHolder)
  {
    if (size < 10) {
      return null;
    }
    captions.clear();
    stringBuilder.setLength(0);
    Object localObject = seiBuffer;
    byte[] arrayOfByte = data.array();
    ((ParsableBitArray)localObject).reset(arrayOfByte, arrayOfByte.length);
    seiBuffer.skipBits(67);
    int j = seiBuffer.readBits(5);
    seiBuffer.skipBits(8);
    int i = 0;
    if (i < j)
    {
      seiBuffer.skipBits(5);
      if (!seiBuffer.readBit()) {
        seiBuffer.skipBits(18);
      }
      for (;;)
      {
        i += 1;
        break;
        if (seiBuffer.readBits(2) != 0)
        {
          seiBuffer.skipBits(16);
        }
        else
        {
          seiBuffer.skipBits(1);
          byte b1 = (byte)seiBuffer.readBits(7);
          seiBuffer.skipBits(1);
          byte b2 = (byte)seiBuffer.readBits(7);
          if ((b1 != 0) || (b2 != 0)) {
            if (((b1 == 17) || (b1 == 25)) && ((b2 & 0x70) == 48))
            {
              stringBuilder.append((char)SPECIAL_CHARACTER_SET[(b2 & 0xF)]);
            }
            else if (((b1 == 18) || (b1 == 26)) && ((b2 & 0x60) == 32))
            {
              backspace();
              stringBuilder.append((char)SPECIAL_ES_FR_CHARACTER_SET[(b2 & 0x1F)]);
            }
            else if (((b1 == 19) || (b1 == 27)) && ((b2 & 0x60) == 32))
            {
              backspace();
              stringBuilder.append((char)SPECIAL_PT_DE_CHARACTER_SET[(b2 & 0x1F)]);
            }
            else if (b1 < 32)
            {
              addCtrl(b1, b2);
            }
            else
            {
              stringBuilder.append(getChar(b1));
              if (b2 >= 32) {
                stringBuilder.append(getChar(b2));
              }
            }
          }
        }
      }
    }
    addBufferedText();
    if (captions.isEmpty()) {
      return null;
    }
    localObject = new ClosedCaption[captions.size()];
    captions.toArray((Object[])localObject);
    return new ClosedCaptionList(timeUs, paramSampleHolder.isDecodeOnly(), (ClosedCaption[])localObject);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.eia608.Eia608Parser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */