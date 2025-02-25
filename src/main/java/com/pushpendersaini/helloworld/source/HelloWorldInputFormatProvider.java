package com.pushpendersaini.helloworld.source;

import com.pushpendersaini.helloworld.common.PluginConstants;
import io.cdap.cdap.api.data.batch.InputFormatProvider;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldInputFormatProvider implements InputFormatProvider {

  private final Map<String, String> configMap;

  public HelloWorldInputFormatProvider(HelloWorldBatchSourceConfig config) {
    configMap = new HashMap<>();
    configMap.put(PluginConstants.PROPERTY_CONFIG_FREQUENCY, Integer.toString(config.getFrequency()));
    configMap.put(PluginConstants.PROPERTY_CONFIG_DEFAULT_MESSAGE, config.getMessage());
  }

  @Override
  public String getInputFormatClassName() {
    return HelloWorldInputFormat.class.getName();
  }

  @Override
  public Map<String, String> getInputFormatConfiguration() {
    return configMap;
  }
}
