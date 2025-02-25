package com.pushpendersaini.helloworld.source;

import com.pushpendersaini.helloworld.common.PluginConstants;
import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.cdap.api.plugin.PluginConfig;
import io.cdap.cdap.etl.api.FailureCollector;

import javax.annotation.Nullable;

public class HelloWorldBatchSourceConfig extends PluginConfig {

  @Name(PluginConstants.PROPERTY_NAME_FREQUENCY)
  @Description("Number of times the plugin says hello world.")
  public Integer frequency;


  @Name(PluginConstants.PROPERTY_NAME_USER_MESSAGE)
  @Description("Custom message")
  @Nullable
  public String message=PluginConstants.PROPERTY_CONFIG_DEFAULT_MESSAGE;

  public HelloWorldBatchSourceConfig(){
    if(message==null || message.isEmpty())
    {
      message=PluginConstants.PROPERTY_CONFIG_DEFAULT_MESSAGE;
    }
  }

  public void validate(FailureCollector failureCollector) {
    if (frequency != null && frequency < 1) {
      failureCollector.addFailure("Property cannot be lower than 1.", "Use a frequency value of equal to or more than 1.").withConfigProperty(PluginConstants.PROPERTY_NAME_FREQUENCY);
    }
  }

  public int getFrequency() {
    return frequency == null ? PluginConstants.PROPERTY_DEFAULT_FREQUENCY : frequency;
  }
  public String getMessage(){ return (message == null || message.isEmpty()) ? PluginConstants.PROPERTY_CONFIG_DEFAULT_MESSAGE: message; }

}
