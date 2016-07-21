package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;

final class DefaultEbmlReader
  implements EbmlReader
{
  private long elementContentSize;
  private int elementId;
  private int elementState;
  private final Stack<MasterElement> masterElementsStack = new Stack();
  private EbmlReaderOutput output;
  private final byte[] scratch = new byte[8];
  private final VarintReader varintReader = new VarintReader();
  
  private long readInteger(ExtractorInput paramExtractorInput, int paramInt)
    throws IOException, InterruptedException
  {
    paramExtractorInput.readFully(scratch, 0, paramInt);
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 8 | scratch[i] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  public final void init(EbmlReaderOutput paramEbmlReaderOutput)
  {
    output = paramEbmlReaderOutput;
  }
  
  public final boolean read(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    boolean bool;
    if (output != null)
    {
      bool = true;
      Assertions.checkState(bool);
    }
    for (;;)
    {
      if ((!masterElementsStack.isEmpty()) && (paramExtractorInput.getPosition() >= masterElementsStack.peek()).elementEndPosition))
      {
        output.endMasterElement(masterElementsStack.pop()).elementId);
        return true;
        bool = false;
        break;
      }
      long l1;
      if (elementState == 0)
      {
        l1 = varintReader.readUnsignedVarint(paramExtractorInput, true, false);
        if (l1 == -1L) {
          return false;
        }
        elementId = ((int)l1);
        elementState = 1;
      }
      if (elementState == 1)
      {
        elementContentSize = varintReader.readUnsignedVarint(paramExtractorInput, false, true);
        elementState = 2;
      }
      int i = output.getElementType(elementId);
      EbmlReaderOutput localEbmlReaderOutput;
      int j;
      switch (i)
      {
      default: 
        throw new IllegalStateException("Invalid element type " + i);
      case 1: 
        l1 = paramExtractorInput.getPosition();
        long l2 = elementContentSize;
        masterElementsStack.add(new MasterElement(elementId, l1 + l2, (byte)0));
        output.startMasterElement(elementId, l1, elementContentSize);
        elementState = 0;
        return true;
      case 2: 
        if (elementContentSize > 8L) {
          throw new IllegalStateException("Invalid integer size: " + elementContentSize);
        }
        output.integerElement(elementId, readInteger(paramExtractorInput, (int)elementContentSize));
        elementState = 0;
        return true;
      case 5: 
        if ((elementContentSize != 4L) && (elementContentSize != 8L)) {
          throw new IllegalStateException("Invalid float size: " + elementContentSize);
        }
        localEbmlReaderOutput = output;
        i = elementId;
        j = (int)elementContentSize;
        l1 = readInteger(paramExtractorInput, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localEbmlReaderOutput.floatElement(i, d);
          elementState = 0;
          return true;
        }
      case 3: 
        if (elementContentSize > 2147483647L) {
          throw new IllegalStateException("String element size: " + elementContentSize);
        }
        localEbmlReaderOutput = output;
        i = elementId;
        j = (int)elementContentSize;
        byte[] arrayOfByte = new byte[j];
        paramExtractorInput.readFully(arrayOfByte, 0, j);
        localEbmlReaderOutput.stringElement(i, new String(arrayOfByte, Charset.forName("UTF-8")));
        elementState = 0;
        return true;
      case 4: 
        output.binaryElement(elementId, (int)elementContentSize, paramExtractorInput);
        elementState = 0;
        return true;
      }
      paramExtractorInput.skipFully((int)elementContentSize);
      elementState = 0;
    }
  }
  
  public final void reset()
  {
    elementState = 0;
    masterElementsStack.clear();
    varintReader.reset();
  }
  
  private static final class MasterElement
  {
    final long elementEndPosition;
    final int elementId;
    
    private MasterElement(int paramInt, long paramLong)
    {
      elementId = paramInt;
      elementEndPosition = paramLong;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.DefaultEbmlReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */