package gr.ds.unipi.noda.api.parquet.classes;

import org.apache.parquet.io.api.Binary;
import org.apache.parquet.io.api.Converter;
import org.apache.parquet.io.api.GroupConverter;
import org.apache.parquet.io.api.PrimitiveConverter;
import org.apache.parquet.schema.GroupType;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.Type;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Iterator;
import java.util.Optional;

public class ParquetRecordConverter extends GroupConverter {
    private final Converter[] converters;
    private final String name;
    private final ParquetRecordConverter parent;
    protected Record record;

    public ParquetRecordConverter(GroupType schema) {
        this(schema, (String)null, (ParquetRecordConverter)null);
    }

    public ParquetRecordConverter(GroupType schema, String name, ParquetRecordConverter parent) {
        this.converters = new Converter[schema.getFieldCount()];
        this.parent = parent;
        this.name = name;
        int i = 0;

        Type field;
        for(Iterator var5 = schema.getFields().iterator(); var5.hasNext(); this.converters[i++] = this.createConverter(field)) {
            field = (Type)var5.next();
        }

    }

    private Converter createConverter(final Type field) {
        LogicalTypeAnnotation ltype = field.getLogicalTypeAnnotation();
        if (field.isPrimitive()) {
            return (Converter)(ltype != null ? (Converter)ltype.accept(new LogicalTypeAnnotation.LogicalTypeAnnotationVisitor<Converter>() {
                public Optional<Converter> visit(LogicalTypeAnnotation.StringLogicalTypeAnnotation stringLogicalType) {
                    return Optional.of(ParquetRecordConverter.this.new StringConverter(field.getName()));
                }

                public Optional<Converter> visit(LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimalLogicalType) {
                    int scale = decimalLogicalType.getScale();
                    return Optional.of(ParquetRecordConverter.this.new DecimalConverter(field.getName(), scale));
                }
            }).orElse(new ParquetRecordConverter.ParquetPrimitiveConverter(field.getName())) : new ParquetRecordConverter.ParquetPrimitiveConverter(field.getName()));
        } else {
            final GroupType groupType = field.asGroupType();
            return (Converter)(ltype != null ? (Converter)ltype.accept(new LogicalTypeAnnotation.LogicalTypeAnnotationVisitor<Converter>() {
                public Optional<Converter> visit(LogicalTypeAnnotation.MapLogicalTypeAnnotation mapLogicalType) {
                    return Optional.of(new ParquetMapRecordConverter(groupType, field.getName(), ParquetRecordConverter.this));
                }

                public Optional<Converter> visit(LogicalTypeAnnotation.ListLogicalTypeAnnotation listLogicalType) {
                    return Optional.of(new ParquetListRecordConverter(groupType, field.getName(), ParquetRecordConverter.this));
                }
            }).orElse(new ParquetRecordConverter(groupType, field.getName(), this)) : new ParquetRecordConverter(groupType, field.getName(), this));
        }
    }

    public Converter getConverter(int fieldIndex) {
        return this.converters[fieldIndex];
    }

    Record getCurrentRecord() {
        return this.record;
    }

    public void start() {
        this.record = new Record();
    }

    public void end() {
        if (this.parent != null) {
            this.parent.getCurrentRecord().add(this.name, this.record);
        }

    }

    private class DecimalConverter extends ParquetRecordConverter.ParquetPrimitiveConverter {
        private final int scale;

        public DecimalConverter(String name, int scale) {
            super(name);
            this.scale = scale;
        }

        public void addBinary(Binary value) {
            ParquetRecordConverter.this.record.add(this.name, new BigDecimal(new BigInteger(value.getBytes()), this.scale));
        }

        public void addInt(int value) {
            ParquetRecordConverter.this.record.add(this.name, BigDecimal.valueOf((long)value).movePointLeft(this.scale));
        }

        public void addLong(long value) {
            ParquetRecordConverter.this.record.add(this.name, BigDecimal.valueOf(value).movePointLeft(this.scale));
        }
    }

    private class StringConverter extends ParquetRecordConverter.ParquetPrimitiveConverter {
        public StringConverter(String name) {
            super(name);
        }

        public void addBinary(Binary value) {
            ParquetRecordConverter.this.record.add(this.name, value.toStringUsingUTF8());
        }
    }

    private class ParquetPrimitiveConverter extends PrimitiveConverter {
        protected final String name;

        public ParquetPrimitiveConverter(String name) {
            this.name = name;
        }

        public void addBinary(Binary value) {
            ParquetRecordConverter.this.record.add(this.name, value.getBytes());
        }

        public void addBoolean(boolean value) {
            ParquetRecordConverter.this.record.add(this.name, value);
        }

        public void addDouble(double value) {
            ParquetRecordConverter.this.record.add(this.name, value);
        }

        public void addFloat(float value) {
            ParquetRecordConverter.this.record.add(this.name, value);
        }

        public void addInt(int value) {
            ParquetRecordConverter.this.record.add(this.name, value);
        }

        public void addLong(long value) {
            ParquetRecordConverter.this.record.add(this.name, value);
        }
    }
}
