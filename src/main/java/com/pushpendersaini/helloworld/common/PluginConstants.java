package com.pushpendersaini.helloworld.common;

import io.cdap.cdap.api.data.schema.Schema;

public final class PluginConstants {

    // Plugin
    public static final String PLUGIN_NAME = "HelloWorld";

    // Properties
    public static final String PROPERTY_NAME_FREQUENCY = "frequency";
    public static final String PROPERTY_NAME_VERSION = "version";
    public static final String PROPERTY_CONFIG_KEY_FREQUENCY = "cdap.hello.world.config.frequency";
    public static final int PROPERTY_DEFAULT_FREQUENCY = 1;
    public static final String PROPERTY_DEFAULT_VERSION = "v1.0.0";
    public static final String PROPERTY_CONFIG_KEY_VERSION = "cdap.hello.world.config.version";

    // Output
    public static final String PLUGIN_OUT_VALUE = "Hello World!";
    public static final Schema PLUGIN_OUT_SCHEMA = Schema.recordOf("data", Schema.Field.of("message", Schema.of(Schema.Type.STRING)), Schema.Field.of("version", Schema.of(Schema.Type.STRING)));
}
