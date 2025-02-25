package com.pushpendersaini.helloworld.source;

import com.pushpendersaini.helloworld.common.PluginConstants;
import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.annotation.Plugin;
import io.cdap.cdap.api.data.batch.Input;
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.dataset.lib.KeyValue;
import io.cdap.cdap.etl.api.Emitter;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.cdap.etl.api.PipelineConfigurer;
import io.cdap.cdap.etl.api.batch.BatchSource;
import io.cdap.cdap.etl.api.batch.BatchSourceContext;
import org.apache.hadoop.io.NullWritable;

@Plugin(type = BatchSource.PLUGIN_TYPE)
@Name(PluginConstants.PLUGIN_NAME)
@Description("Says Hello World configured number of times.")
public class HelloWorldBatchSource extends BatchSource<NullWritable, String, StructuredRecord> {

  private final HelloWorldBatchSourceConfig config;

  public HelloWorldBatchSource(HelloWorldBatchSourceConfig config) {
    this.config = config;
  }

  @Override
  public void configurePipeline(PipelineConfigurer pipelineConfigurer) {
    FailureCollector failureCollector = pipelineConfigurer.getStageConfigurer().getFailureCollector();
    config.validate(failureCollector);
    pipelineConfigurer.getStageConfigurer().setOutputSchema(PluginConstants.PLUGIN_OUT_SCHEMA);
  }

  @Override
  public void prepareRun(BatchSourceContext batchSourceContext) {
    batchSourceContext.setInput(Input.of(PluginConstants.PLUGIN_NAME, new HelloWorldInputFormatProvider(config)));
  }

  @Override
  public void transform(KeyValue<NullWritable, String> input, Emitter<StructuredRecord> emitter) throws Exception {
    emitter.emit(StructuredRecord.builder(PluginConstants.PLUGIN_OUT_SCHEMA).set("message", input.getValue()).build());
  }
}
