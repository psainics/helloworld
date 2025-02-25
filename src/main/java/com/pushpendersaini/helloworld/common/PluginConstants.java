package com.pushpendersaini.helloworld.common;

import io.cdap.cdap.api.data.schema.Schema;

public final class PluginConstants {

    // Plugin
    public static final String PLUGIN_NAME = "HelloWorld";

    // Property: frequency
    public static final String PROPERTY_NAME_FREQUENCY = "frequency";
    public static final String PROPERTY_CONFIG_KEY_FREQUENCY = "cdap.hello.world.config.frequency";
    public static final int PROPERTY_DEFAULT_FREQUENCY = 1;

    public static final String PROPERTY_NAME_USER_MESSAGE="User Message";
    public static String PROPERTY_CONFIG_KEY_MESSAGE="cdap.hello.world.config.message";
    public static final String PROPERTY_CONFIG_DEFAULT_MESSAGE = "Hello world, this is a custom message";


    // Output

    public static final String PROPERTY_NAME_USER_MESSAGE="User Message";
    public static final String PROPERTY_CONFIG_KEY_MESSAGE = "cdap.hello.world.config.message";
    public static final String PROPERTY_CONFIG_DEFAULT_MESSAGE = "Hello world, this is a custom message";

    public static final String PLUGIN_OUT_VALUE = "Hello World!";
    public static final Schema PLUGIN_OUT_SCHEMA = Schema.recordOf("data", Schema.Field.of("message", Schema.of(Schema.Type.STRING)));
}
