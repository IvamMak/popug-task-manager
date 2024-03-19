/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.schemaregistry.task.completed;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TaskCompletedAccountingPayload extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1373901629032158198L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskCompletedAccountingPayload\",\"namespace\":\"com.example.schemaregistry.task.completed\",\"fields\":[{\"name\":\"publicId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"executorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"price\",\"type\":\"double\"},{\"name\":\"date\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskCompletedAccountingPayload> ENCODER =
      new BinaryMessageEncoder<TaskCompletedAccountingPayload>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskCompletedAccountingPayload> DECODER =
      new BinaryMessageDecoder<TaskCompletedAccountingPayload>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TaskCompletedAccountingPayload> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TaskCompletedAccountingPayload> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TaskCompletedAccountingPayload> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskCompletedAccountingPayload>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TaskCompletedAccountingPayload to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TaskCompletedAccountingPayload from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TaskCompletedAccountingPayload instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TaskCompletedAccountingPayload fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String publicId;
  @Deprecated public java.lang.String executorId;
  @Deprecated public double price;
  @Deprecated public java.lang.String date;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskCompletedAccountingPayload() {}

  /**
   * All-args constructor.
   * @param publicId The new value for publicId
   * @param executorId The new value for executorId
   * @param price The new value for price
   * @param date The new value for date
   */
  public TaskCompletedAccountingPayload(java.lang.String publicId, java.lang.String executorId, java.lang.Double price, java.lang.String date) {
    this.publicId = publicId;
    this.executorId = executorId;
    this.price = price;
    this.date = date;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return publicId;
    case 1: return executorId;
    case 2: return price;
    case 3: return date;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: publicId = value$ != null ? value$.toString() : null; break;
    case 1: executorId = value$ != null ? value$.toString() : null; break;
    case 2: price = (java.lang.Double)value$; break;
    case 3: date = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'publicId' field.
   * @return The value of the 'publicId' field.
   */
  public java.lang.String getPublicId() {
    return publicId;
  }


  /**
   * Sets the value of the 'publicId' field.
   * @param value the value to set.
   */
  public void setPublicId(java.lang.String value) {
    this.publicId = value;
  }

  /**
   * Gets the value of the 'executorId' field.
   * @return The value of the 'executorId' field.
   */
  public java.lang.String getExecutorId() {
    return executorId;
  }


  /**
   * Sets the value of the 'executorId' field.
   * @param value the value to set.
   */
  public void setExecutorId(java.lang.String value) {
    this.executorId = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public double getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(double value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public java.lang.String getDate() {
    return date;
  }


  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.String value) {
    this.date = value;
  }

  /**
   * Creates a new TaskCompletedAccountingPayload RecordBuilder.
   * @return A new TaskCompletedAccountingPayload RecordBuilder
   */
  public static com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder newBuilder() {
    return new com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder();
  }

  /**
   * Creates a new TaskCompletedAccountingPayload RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskCompletedAccountingPayload RecordBuilder
   */
  public static com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder newBuilder(com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder other) {
    if (other == null) {
      return new com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder();
    } else {
      return new com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder(other);
    }
  }

  /**
   * Creates a new TaskCompletedAccountingPayload RecordBuilder by copying an existing TaskCompletedAccountingPayload instance.
   * @param other The existing instance to copy.
   * @return A new TaskCompletedAccountingPayload RecordBuilder
   */
  public static com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder newBuilder(com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload other) {
    if (other == null) {
      return new com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder();
    } else {
      return new com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder(other);
    }
  }

  /**
   * RecordBuilder for TaskCompletedAccountingPayload instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskCompletedAccountingPayload>
    implements org.apache.avro.data.RecordBuilder<TaskCompletedAccountingPayload> {

    private java.lang.String publicId;
    private java.lang.String executorId;
    private double price;
    private java.lang.String date;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.executorId)) {
        this.executorId = data().deepCopy(fields()[1].schema(), other.executorId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.date)) {
        this.date = data().deepCopy(fields()[3].schema(), other.date);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing TaskCompletedAccountingPayload instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.executorId)) {
        this.executorId = data().deepCopy(fields()[1].schema(), other.executorId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.date)) {
        this.date = data().deepCopy(fields()[3].schema(), other.date);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'publicId' field.
      * @return The value.
      */
    public java.lang.String getPublicId() {
      return publicId;
    }


    /**
      * Sets the value of the 'publicId' field.
      * @param value The value of 'publicId'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder setPublicId(java.lang.String value) {
      validate(fields()[0], value);
      this.publicId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'publicId' field has been set.
      * @return True if the 'publicId' field has been set, false otherwise.
      */
    public boolean hasPublicId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'publicId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder clearPublicId() {
      publicId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'executorId' field.
      * @return The value.
      */
    public java.lang.String getExecutorId() {
      return executorId;
    }


    /**
      * Sets the value of the 'executorId' field.
      * @param value The value of 'executorId'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder setExecutorId(java.lang.String value) {
      validate(fields()[1], value);
      this.executorId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'executorId' field has been set.
      * @return True if the 'executorId' field has been set, false otherwise.
      */
    public boolean hasExecutorId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'executorId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder clearExecutorId() {
      executorId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public double getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder setPrice(double value) {
      validate(fields()[2], value);
      this.price = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder clearPrice() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public java.lang.String getDate() {
      return date;
    }


    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder setDate(java.lang.String value) {
      validate(fields()[3], value);
      this.date = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload.Builder clearDate() {
      date = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskCompletedAccountingPayload build() {
      try {
        TaskCompletedAccountingPayload record = new TaskCompletedAccountingPayload();
        record.publicId = fieldSetFlags()[0] ? this.publicId : (java.lang.String) defaultValue(fields()[0]);
        record.executorId = fieldSetFlags()[1] ? this.executorId : (java.lang.String) defaultValue(fields()[1]);
        record.price = fieldSetFlags()[2] ? this.price : (java.lang.Double) defaultValue(fields()[2]);
        record.date = fieldSetFlags()[3] ? this.date : (java.lang.String) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskCompletedAccountingPayload>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskCompletedAccountingPayload>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskCompletedAccountingPayload>
    READER$ = (org.apache.avro.io.DatumReader<TaskCompletedAccountingPayload>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.publicId);

    out.writeString(this.executorId);

    out.writeDouble(this.price);

    out.writeString(this.date);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.publicId = in.readString();

      this.executorId = in.readString();

      this.price = in.readDouble();

      this.date = in.readString();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.publicId = in.readString();
          break;

        case 1:
          this.executorId = in.readString();
          break;

        case 2:
          this.price = in.readDouble();
          break;

        case 3:
          this.date = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









