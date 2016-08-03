package org.panda_lang.moonlight.core.memory.database.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataSerializer {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public DataSerializer(DataInputStream dataInputStream) {
        this(dataInputStream, null);
    }

    public DataSerializer(DataOutputStream dataOutputStream) {
        this(null, dataOutputStream);
    }

    public DataSerializer(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    public int available() throws IOException {
        return dataInputStream.available();
    }

    public int skipBytes(int i) throws IOException {
        return dataInputStream.skipBytes(i);
    }

    public void write(int v) throws IOException {
        dataOutputStream.write(v);
    }

    public void writeByte(byte v) throws IOException {
        dataOutputStream.writeByte(v);
    }

    public void writeShort(short v) throws IOException {
        dataOutputStream.writeShort(v);
    }

    public void writeChar(char v) throws IOException {
        dataOutputStream.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        dataOutputStream.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        dataOutputStream.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        dataOutputStream.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        dataOutputStream.writeDouble(v);
    }

    public void writeBoolean(boolean v) throws IOException {
        dataOutputStream.writeBoolean(v);
    }

    public void writeBytes(String s) throws IOException {
        dataOutputStream.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        dataOutputStream.writeChars(s);
    }

    public void writeUTF(String string) throws IOException {
        dataOutputStream.writeUTF(string);
    }

    public int read() throws IOException {
        return dataInputStream.read();
    }

    public int read(byte[] b) throws IOException {
        return dataInputStream.read(b);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return dataInputStream.read(b, off, len);
    }

    public byte readByte() throws IOException {
        return dataInputStream.readByte();
    }

    public short readShort() throws IOException {
        return dataInputStream.readShort();
    }

    public char readChar() throws IOException {
        return dataInputStream.readChar();
    }

    public int readInt() throws IOException {
        return dataInputStream.readInt();
    }

    public long readLong() throws IOException {
        return dataInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return dataInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return dataInputStream.readDouble();
    }

    public boolean readBoolean() throws IOException {
        return dataInputStream.readBoolean();
    }

    public int readUnsignedByte() throws IOException {
        return dataInputStream.readUnsignedByte();
    }

    public int readUnsignedShort() throws IOException {
        return dataInputStream.readUnsignedShort();
    }

    public String readUTF() throws IOException {
        return dataInputStream.readUTF();
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

}
