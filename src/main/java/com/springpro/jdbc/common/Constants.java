package com.springpro.jdbc.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String SCHEMA_DB_SCRIPT_PATH = "classpath:db/h2/schema.sql";
    public static final String TEST_DATA_SCRIPT_PATH = "classpath:db/h2/test-data.sql";
}
