package com.pushpendersaini.helloworld.common;

import io.cdap.cdap.api.data.schema.Schema;

public final class PluginConstants {
    public static final String PLUGIN_NAME = "HelloWorld";
    public static final String PROPERTY_NAME_FREQUENCY = "frequency";
    public static final String PROPERTY_NAME_CUSTOM_MESSAGE="Custom Message";
    public static final String PROPERTY_CONFIG_FREQUENCY = "cdap.hello.world.config.frequency";
    public static final int PROPERTY_DEFAULT_FREQUENCY = 1;
    public static final String PROPERTY_CONFIG_DEFAULT_MESSAGE = "Hello world, this is a custom message";
    public static final String PLUGIN_OUT_VALUE = "Hello World!";
    public static final Schema PLUGIN_OUT_SCHEMA = Schema.recordOf("data", Schema.Field.of("message", Schema.of(Schema.Type.STRING)));
}
