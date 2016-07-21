package com.linkedin.android.pegasus.gen.pemberly.text;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AttributeTypeBuilder
  implements FissileDataModelBuilder<AttributeType>, DataTemplateBuilder<AttributeType>
{
  public static final AttributeTypeBuilder INSTANCE = new AttributeTypeBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.pemberly.text.Bold");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.Italic");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.Paragraph");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.Hyperlink");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.Entity");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.List");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.ListItem");
    JSON_KEY_STORE.put("com.linkedin.pemberly.text.LineBreak");
  }
  
  public static AttributeType build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.Bold", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = BoldBuilder.INSTANCE;
        localObject8 = BoldBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.Italic", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = ItalicBuilder.INSTANCE;
        localObject7 = ItalicBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.Paragraph", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = ParagraphBuilder.INSTANCE;
        localObject6 = ParagraphBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.Hyperlink", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = HyperlinkBuilder.INSTANCE;
        localObject5 = HyperlinkBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.Entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = EntityBuilder.INSTANCE;
        localObject4 = EntityBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.List", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ListBuilder.INSTANCE;
        localObject3 = ListBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.ListItem", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ListItemBuilder.INSTANCE;
        localObject2 = ListItemBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.pemberly.text.LineBreak", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = LineBreakBuilder.INSTANCE;
        localObject1 = LineBreakBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool8) {
      j = 1;
    }
    int i = j;
    if (bool7)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
      }
      i = 1;
    }
    j = i;
    if (bool6)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
      }
      j = 1;
    }
    i = j;
    if (bool5)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
      }
      i = 1;
    }
    j = i;
    if (bool4)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
      }
      j = 1;
    }
    i = j;
    if (bool3)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
      }
      i = 1;
    }
    j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.pemberly.text.AttributeType");
    }
    return new AttributeType((Bold)localObject8, (Italic)localObject7, (Paragraph)localObject6, (Hyperlink)localObject5, (Entity)localObject4, (List)localObject3, (ListItem)localObject2, (LineBreak)localObject1, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static AttributeType readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AttributeType");
    }
    Object localObject1 = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      do
      {
        do
        {
          localObject8 = paramString;
          if (i != 0) {
            break;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            return null;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AttributeType");
    }
    Object localObject8 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AttributeType");
    }
    if (((ByteBuffer)localObject8).getInt() != -986364655)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject8);
      throw new IOException("UID mismatch. Can't read cached data when building AttributeType");
    }
    paramString = null;
    BoldBuilder localBoldBuilder = null;
    localObject1 = null;
    ItalicBuilder localItalicBuilder = null;
    Object localObject2 = null;
    ParagraphBuilder localParagraphBuilder = null;
    Object localObject3 = null;
    HyperlinkBuilder localHyperlinkBuilder = null;
    Object localObject4 = null;
    EntityBuilder localEntityBuilder = null;
    Object localObject5 = null;
    ListBuilder localListBuilder = null;
    Object localObject6 = null;
    ListItemBuilder localListItemBuilder = null;
    Object localObject7 = null;
    LineBreakBuilder localLineBreakBuilder = null;
    boolean bool2;
    boolean bool1;
    label313:
    label339:
    boolean bool3;
    label351:
    label413:
    label442:
    boolean bool4;
    label454:
    label516:
    label545:
    boolean bool5;
    label557:
    label619:
    label648:
    boolean bool6;
    label660:
    label722:
    label751:
    boolean bool7;
    label763:
    label825:
    label854:
    boolean bool8;
    if (((ByteBuffer)localObject8).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject8).get();
        paramString = localBoldBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localBoldBuilder = BoldBuilder.INSTANCE;
          paramString = BoldBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1113;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = BoldBuilder.INSTANCE;
          paramString = BoldBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (paramString == null) {
            break label1119;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1125;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject1 = localItalicBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localItalicBuilder = ItalicBuilder.INSTANCE;
          localObject1 = ItalicBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1131;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = ItalicBuilder.INSTANCE;
          localObject1 = ItalicBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1137;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1143;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject2 = localParagraphBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localParagraphBuilder = ParagraphBuilder.INSTANCE;
          localObject2 = ParagraphBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1149;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ParagraphBuilder.INSTANCE;
          localObject2 = ParagraphBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1155;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1161;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject3 = localHyperlinkBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localHyperlinkBuilder = HyperlinkBuilder.INSTANCE;
          localObject3 = HyperlinkBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1167;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = HyperlinkBuilder.INSTANCE;
          localObject3 = HyperlinkBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1173;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1179;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject4 = localEntityBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localEntityBuilder = EntityBuilder.INSTANCE;
          localObject4 = EntityBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1185;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = EntityBuilder.INSTANCE;
          localObject4 = EntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1191;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1197;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject5 = localListBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localListBuilder = ListBuilder.INSTANCE;
          localObject5 = ListBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1203;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = ListBuilder.INSTANCE;
          localObject5 = ListBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1209;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1215;
      }
      bool8 = true;
      label866:
      bool7 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject6 = localListItemBuilder;
        bool7 = bool8;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localListItemBuilder = ListItemBuilder.INSTANCE;
          localObject6 = ListItemBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1221;
          }
          bool7 = true;
        }
        label928:
        if (i == 1)
        {
          localObject6 = ListItemBuilder.INSTANCE;
          localObject6 = ListItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1227;
          }
          bool7 = true;
        }
      }
      label957:
      if (((ByteBuffer)localObject8).get() != 1) {
        break label1233;
      }
      bool8 = true;
      label969:
      bool9 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject8).get();
        localObject7 = localLineBreakBuilder;
        if (i == 0)
        {
          localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject8);
          localLineBreakBuilder = LineBreakBuilder.INSTANCE;
          localObject7 = LineBreakBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
          if (localObject7 == null) {
            break label1239;
          }
          bool8 = true;
        }
        label1027:
        bool9 = bool8;
        if (i == 1)
        {
          localObject7 = LineBreakBuilder.INSTANCE;
          localObject7 = LineBreakBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject8, null, paramFissionTransaction);
          if (localObject7 == null) {
            break label1245;
          }
        }
      }
    }
    label1113:
    label1119:
    label1125:
    label1131:
    label1137:
    label1143:
    label1149:
    label1155:
    label1161:
    label1167:
    label1173:
    label1179:
    label1185:
    label1191:
    label1197:
    label1203:
    label1209:
    label1215:
    label1221:
    label1227:
    label1233:
    label1239:
    label1245:
    for (boolean bool9 = true;; bool9 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject8);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label1254;
      }
      if (j == 0) {
        break label1251;
      }
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label313;
      bool1 = false;
      break label339;
      bool3 = false;
      break label351;
      bool2 = false;
      break label413;
      bool2 = false;
      break label442;
      bool4 = false;
      break label454;
      bool3 = false;
      break label516;
      bool3 = false;
      break label545;
      bool5 = false;
      break label557;
      bool4 = false;
      break label619;
      bool4 = false;
      break label648;
      bool6 = false;
      break label660;
      bool5 = false;
      break label722;
      bool5 = false;
      break label751;
      bool7 = false;
      break label763;
      bool6 = false;
      break label825;
      bool6 = false;
      break label854;
      bool8 = false;
      break label866;
      bool7 = false;
      break label928;
      bool7 = false;
      break label957;
      bool8 = false;
      break label969;
      bool8 = false;
      break label1027;
    }
    label1251:
    int i = 1;
    label1254:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
      }
      j = 1;
    }
    if ((bool9) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.pemberly.text.AttributeType from fission.");
    }
    return new AttributeType(paramString, (Italic)localObject1, (Paragraph)localObject2, (Hyperlink)localObject3, (Entity)localObject4, (List)localObject5, (ListItem)localObject6, (LineBreak)localObject7, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool9);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.AttributeTypeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */