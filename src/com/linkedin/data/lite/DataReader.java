package com.linkedin.data.lite;

public abstract interface DataReader
{
  public abstract long getByteOffset()
    throws DataReaderException;
  
  public abstract long getCharOffset()
    throws DataReaderException;
  
  public abstract Object getSourceRef()
    throws DataReaderException;
  
  public abstract boolean hasMoreArrayElements$255f299()
    throws DataReaderException;
  
  public abstract boolean hasMoreFields$255f299()
    throws DataReaderException;
  
  public abstract boolean hasMoreMapElements$255f299()
    throws DataReaderException;
  
  public abstract boolean isStartOfArray()
    throws DataReaderException;
  
  public abstract boolean isStartOfMap()
    throws DataReaderException;
  
  public abstract boolean readBoolean()
    throws DataReaderException;
  
  public abstract Bytes readBytes()
    throws DataReaderException;
  
  public abstract double readDouble()
    throws DataReaderException;
  
  public abstract <E extends Enum<E>> E readEnum(EnumBuilder<E> paramEnumBuilder)
    throws DataReaderException;
  
  public abstract float readFloat()
    throws DataReaderException;
  
  public abstract int readInt()
    throws DataReaderException;
  
  public abstract long readLong()
    throws DataReaderException;
  
  public abstract String readMapKey()
    throws DataReaderException;
  
  public abstract String readString()
    throws DataReaderException;
  
  public abstract boolean shouldReadField$11ca93e7(String paramString, JsonKeyStore paramJsonKeyStore)
    throws DataReaderException;
  
  public abstract void skipField()
    throws DataReaderException;
  
  public abstract void startField()
    throws DataReaderException;
  
  public abstract void startRecord()
    throws DataReaderException;
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.DataReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */