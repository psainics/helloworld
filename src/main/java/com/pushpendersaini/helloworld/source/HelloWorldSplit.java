package com.pushpendersaini.helloworld.source;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.InputSplit;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class HelloWorldSplit extends InputSplit implements Writable {
  @Override
  public void write(DataOutput dataOutput) throws IOException {
    // no-op
  }

  @Override
  public void readFields(DataInput dataInput) throws IOException {
    // no-op
  }

  @Override
  public long getLength() throws IOException, InterruptedException {
    return 0;
  }

  @Override
  public String[] getLocations() throws IOException, InterruptedException {
    return new String[0];
  }
}
