/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.cdc.connectors.jdbc.config;

import java.util.Properties;

/** Jdbc Properties Formatter. */
public class JdbcPropertiesFormatter {
    public static Properties formatJdbcProperties(String jdbcPropertiesString) {
        Properties properties = new Properties();
        if (jdbcPropertiesString == null || jdbcPropertiesString.isEmpty()) {
            return properties;
        }

        String[] keyValuePairs = jdbcPropertiesString.split(",");
        for (String keyValuePair : keyValuePairs) {
            String[] keyValue = keyValuePair.split("=");
            if (keyValue.length == 2) {
                properties.setProperty(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        return properties;
    }
}
