package com.pushpendersaini.helloworld.source;

import com.pushpendersaini.helloworld.common.PluginConstants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class HelloWorldRecordReader extends RecordReader<NullWritable, String> {

  private int frequency;
  private int countProcessed = 0;

  @Override
  public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
    Configuration conf = taskAttemptContext.getConfiguration();
    // Plugin configuration
    frequency = conf.getInt(PluginConstants.PROPERTY_CONFIG_FREQUENCY, 1);
  }

  @Override
  public boolean nextKeyValue() throws IOException, InterruptedException {
    return countProcessed++ < frequency;
  }

  @Override
  public NullWritable getCurrentKey() throws IOException, InterruptedException {
    return NullWritable.get();
  }

  @Override
  public String getCurrentValue() throws IOException, InterruptedException {
    return PluginConstants.PLUGIN_OUT_VALUE + "#" + countProcessed;
  }

  @Override
  public float getProgress() throws IOException, InterruptedException {
    return (float) countProcessed / frequency;
  }

  @Override
  public void close() throws IOException {
    // no-op
  }
}
