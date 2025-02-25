package com.pushpendersaini.helloworld.source;

import com.pushpendersaini.helloworld.common.PluginConstants;
import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.plugin.PluginConfig;
import io.cdap.cdap.etl.api.FailureCollector;

public class HelloWorldBatchSourceConfig extends PluginConfig {

  @Name(PluginConstants.PROPERTY_NAME_FREQUENCY)
  @Description("Number of times the plugin says hello world.")
  public Integer frequency;

  public void validate(FailureCollector failureCollector) {
    if (frequency != null && frequency < 1) {
      failureCollector.addFailure("Property cannot be lower than 1.", "Use a frequency value of equal to or more than 1.").withConfigProperty(PluginConstants.PROPERTY_NAME_FREQUENCY);
    }
  }

  public int getFrequency() {
    return frequency == null ? PluginConstants.PROPERTY_DEFAULT_FREQUENCY : frequency;
  }

}
