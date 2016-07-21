package com.linkedin.android.pegasus.gen.pemberly.text;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AttributeType
  implements FissileDataModel<AttributeType>, UnionTemplate<AttributeType>
{
  public static final AttributeTypeBuilder BUILDER = AttributeTypeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Bold boldValue;
  public final Entity entityValue;
  public final boolean hasBoldValue;
  public final boolean hasEntityValue;
  public final boolean hasHyperlinkValue;
  public final boolean hasItalicValue;
  public final boolean hasLineBreakValue;
  public final boolean hasListItemValue;
  public final boolean hasListValue;
  public final boolean hasParagraphValue;
  public final Hyperlink hyperlinkValue;
  public final Italic italicValue;
  public final LineBreak lineBreakValue;
  public final ListItem listItemValue;
  public final List listValue;
  public final Paragraph paragraphValue;
  
  public AttributeType(Bold paramBold, Italic paramItalic, Paragraph paramParagraph, Hyperlink paramHyperlink, Entity paramEntity, List paramList, ListItem paramListItem, LineBreak paramLineBreak, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    boldValue = paramBold;
    italicValue = paramItalic;
    paragraphValue = paramParagraph;
    hyperlinkValue = paramHyperlink;
    entityValue = paramEntity;
    listValue = paramList;
    listItemValue = paramListItem;
    lineBreakValue = paramLineBreak;
    hasBoldValue = paramBoolean1;
    hasItalicValue = paramBoolean2;
    hasParagraphValue = paramBoolean3;
    hasHyperlinkValue = paramBoolean4;
    hasEntityValue = paramBoolean5;
    hasListValue = paramBoolean6;
    hasListItemValue = paramBoolean7;
    hasLineBreakValue = paramBoolean8;
    _cachedId = null;
  }
  
  public final AttributeType accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label52:
    Object localObject3;
    boolean bool2;
    label87:
    label98:
    Object localObject4;
    boolean bool3;
    label134:
    label146:
    Object localObject5;
    boolean bool4;
    label186:
    label198:
    Object localObject6;
    boolean bool5;
    label238:
    label250:
    Object localObject7;
    boolean bool6;
    label290:
    label302:
    Object localObject8;
    boolean bool7;
    if (hasBoldValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.Bold");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = Bold.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label465;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasItalicValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.Italic");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label474;
        }
        localObject1 = Italic.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label492;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasParagraphValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.Paragraph");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label501;
        }
        localObject1 = Paragraph.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label519;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasHyperlinkValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.Hyperlink");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label529;
        }
        localObject1 = hyperlinkValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label547;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasEntityValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.Entity");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label557;
        }
        localObject1 = entityValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label575;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasListValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.List");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label585;
        }
        localObject1 = listValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label603;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasListItemValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.ListItem");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label613;
        }
        localObject1 = ListItem.accept(paramDataProcessor);
        label338:
        if (localObject1 == null) {
          break label631;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      label350:
      localObject1 = null;
      bool8 = false;
      if (hasLineBreakValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.pemberly.text.LineBreak");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label641;
        }
        localObject1 = LineBreak.accept(paramDataProcessor);
        label386:
        if (localObject1 == null) {
          break label659;
        }
      }
    }
    label465:
    label474:
    label492:
    label501:
    label519:
    label529:
    label547:
    label557:
    label575:
    label585:
    label603:
    label613:
    label631:
    label641:
    label659:
    for (boolean bool8 = true;; bool8 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label665;
      }
      return new AttributeType((Bold)localObject2, (Italic)localObject3, (Paragraph)localObject4, (Hyperlink)localObject5, (Entity)localObject6, (List)localObject7, (ListItem)localObject8, (LineBreak)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8);
      localObject1 = (Bold)paramDataProcessor.processDataTemplate(boldValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label52;
      localObject1 = (Italic)paramDataProcessor.processDataTemplate(italicValue);
      break label87;
      bool2 = false;
      localObject3 = localObject1;
      break label98;
      localObject1 = (Paragraph)paramDataProcessor.processDataTemplate(paragraphValue);
      break label134;
      bool3 = false;
      localObject4 = localObject1;
      break label146;
      localObject1 = (Hyperlink)paramDataProcessor.processDataTemplate(hyperlinkValue);
      break label186;
      bool4 = false;
      localObject5 = localObject1;
      break label198;
      localObject1 = (Entity)paramDataProcessor.processDataTemplate(entityValue);
      break label238;
      bool5 = false;
      localObject6 = localObject1;
      break label250;
      localObject1 = (List)paramDataProcessor.processDataTemplate(listValue);
      break label290;
      bool6 = false;
      localObject7 = localObject1;
      break label302;
      localObject1 = (ListItem)paramDataProcessor.processDataTemplate(listItemValue);
      break label338;
      bool7 = false;
      localObject8 = localObject1;
      break label350;
      localObject1 = (LineBreak)paramDataProcessor.processDataTemplate(lineBreakValue);
      break label386;
    }
    label665:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AttributeType)paramObject;
      if (boldValue != null)
      {
        if (boldValue.equals(boldValue)) {}
      }
      else {
        while (boldValue != null) {
          return false;
        }
      }
      if (italicValue != null)
      {
        if (italicValue.equals(italicValue)) {}
      }
      else {
        while (italicValue != null) {
          return false;
        }
      }
      if (paragraphValue != null)
      {
        if (paragraphValue.equals(paragraphValue)) {}
      }
      else {
        while (paragraphValue != null) {
          return false;
        }
      }
      if (hyperlinkValue != null)
      {
        if (hyperlinkValue.equals(hyperlinkValue)) {}
      }
      else {
        while (hyperlinkValue != null) {
          return false;
        }
      }
      if (entityValue != null)
      {
        if (entityValue.equals(entityValue)) {}
      }
      else {
        while (entityValue != null) {
          return false;
        }
      }
      if (listValue != null)
      {
        if (listValue.equals(listValue)) {}
      }
      else {
        while (listValue != null) {
          return false;
        }
      }
      if (listItemValue != null)
      {
        if (listItemValue.equals(listItemValue)) {}
      }
      else {
        while (listItemValue != null) {
          return false;
        }
      }
      if (lineBreakValue == null) {
        break;
      }
    } while (lineBreakValue.equals(lineBreakValue));
    for (;;)
    {
      return false;
      if (lineBreakValue == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasBoldValue)
    {
      if (boldValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(boldValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasItalicValue)
      {
        i = j + 1;
        if (italicValue._cachedId == null) {
          break label366;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(italicValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasParagraphValue)
      {
        i = j + 1;
        if (paragraphValue._cachedId == null) {
          break label379;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(paragraphValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasHyperlinkValue)
      {
        i = j + 1;
        if (hyperlinkValue._cachedId == null) {
          break label392;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(hyperlinkValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasEntityValue)
      {
        i = j + 1;
        if (entityValue._cachedId == null) {
          break label405;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entityValue._cachedId);
      }
      label219:
      j = i + 1;
      i = j;
      if (hasListValue)
      {
        i = j + 1;
        if (listValue._cachedId == null) {
          break label418;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(listValue._cachedId);
      }
      label261:
      j = i + 1;
      i = j;
      if (hasListItemValue)
      {
        i = j + 1;
        if (listItemValue._cachedId == null) {
          break label431;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(listItemValue._cachedId);
      }
      label303:
      j = i + 1;
      i = j;
      if (hasLineBreakValue)
      {
        i = j + 1;
        if (lineBreakValue._cachedId == null) {
          break label444;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(lineBreakValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = boldValue.getSerializedSize() + 7;
      break;
      label366:
      i += italicValue.getSerializedSize();
      break label93;
      label379:
      i += paragraphValue.getSerializedSize();
      break label135;
      label392:
      i += hyperlinkValue.getSerializedSize();
      break label177;
      label405:
      i += entityValue.getSerializedSize();
      break label219;
      label418:
      i += listValue.getSerializedSize();
      break label261;
      label431:
      i += listItemValue.getSerializedSize();
      break label303;
      label444:
      i += lineBreakValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i1;
    if (boldValue != null)
    {
      i = boldValue.hashCode();
      if (italicValue == null) {
        break label198;
      }
      j = italicValue.hashCode();
      if (paragraphValue == null) {
        break label203;
      }
      k = paragraphValue.hashCode();
      if (hyperlinkValue == null) {
        break label208;
      }
      m = hyperlinkValue.hashCode();
      if (entityValue == null) {
        break label214;
      }
      n = entityValue.hashCode();
      if (listValue == null) {
        break label220;
      }
      i1 = listValue.hashCode();
      label108:
      if (listItemValue == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = listItemValue.hashCode();; i2 = 0)
    {
      if (lineBreakValue != null) {
        i3 = lineBreakValue.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label108;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AttributeType");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label231:
    label291:
    label351:
    label411:
    label471:
    label531:
    label659:
    label684:
    label694:
    label719:
    label729:
    label754:
    label764:
    label789:
    label799:
    label824:
    label834:
    label859:
    label869:
    label894:
    label902:
    label904:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-986364655);
        if (hasBoldValue)
        {
          localByteBuffer.put((byte)1);
          if (boldValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, boldValue._cachedId);
            boldValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasItalicValue) {
              break label684;
            }
            localByteBuffer.put((byte)1);
            if (italicValue._cachedId == null) {
              break label659;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, italicValue._cachedId);
            italicValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasParagraphValue) {
              break label719;
            }
            localByteBuffer.put((byte)1);
            if (paragraphValue._cachedId == null) {
              break label694;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, paragraphValue._cachedId);
            paragraphValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHyperlinkValue) {
              break label754;
            }
            localByteBuffer.put((byte)1);
            if (hyperlinkValue._cachedId == null) {
              break label729;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, hyperlinkValue._cachedId);
            hyperlinkValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEntityValue) {
              break label789;
            }
            localByteBuffer.put((byte)1);
            if (entityValue._cachedId == null) {
              break label764;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, entityValue._cachedId);
            entityValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasListValue) {
              break label824;
            }
            localByteBuffer.put((byte)1);
            if (listValue._cachedId == null) {
              break label799;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, listValue._cachedId);
            listValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasListItemValue) {
              break label859;
            }
            localByteBuffer.put((byte)1);
            if (listItemValue._cachedId == null) {
              break label834;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, listItemValue._cachedId);
            listItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLineBreakValue) {
              break label894;
            }
            localByteBuffer.put((byte)1);
            if (lineBreakValue._cachedId == null) {
              break label869;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, lineBreakValue._cachedId);
            lineBreakValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label902;
          }
          if (str != null) {
            break label904;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          boldValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          italicValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label231;
          localByteBuffer.put((byte)0);
          break label231;
          localByteBuffer.put((byte)1);
          paragraphValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label291;
          localByteBuffer.put((byte)0);
          break label291;
          localByteBuffer.put((byte)1);
          hyperlinkValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label351;
          localByteBuffer.put((byte)0);
          break label351;
          localByteBuffer.put((byte)1);
          entityValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label411;
          localByteBuffer.put((byte)0);
          break label411;
          localByteBuffer.put((byte)1);
          listValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label471;
          localByteBuffer.put((byte)0);
          break label471;
          localByteBuffer.put((byte)1);
          listItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label531;
          localByteBuffer.put((byte)0);
          break label531;
          localByteBuffer.put((byte)1);
          lineBreakValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
  {
    public Bold boldValue = null;
    public Entity entityValue = null;
    public boolean hasBoldValue = false;
    public boolean hasEntityValue = false;
    public boolean hasHyperlinkValue = false;
    public boolean hasItalicValue = false;
    public boolean hasLineBreakValue = false;
    public boolean hasListItemValue = false;
    public boolean hasListValue = false;
    public boolean hasParagraphValue = false;
    public Hyperlink hyperlinkValue = null;
    public Italic italicValue = null;
    public LineBreak lineBreakValue = null;
    public ListItem listItemValue = null;
    public List listValue = null;
    public Paragraph paragraphValue = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.AttributeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */