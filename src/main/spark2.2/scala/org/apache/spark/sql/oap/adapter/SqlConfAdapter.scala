/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.oap.adapter

import org.apache.spark.internal.config.ConfigBuilder
import org.apache.spark.sql.internal.SQLConf

object SqlConfAdapter {
  def buildConf(key: String): ConfigBuilder = SQLConf.buildConf(key)

  val ORC_VECTORIZED_READER_ENABLED =
    SqlConfAdapter.buildConf("spark.sql.orc.enableVectorizedReader")
      .doc("Enables vectorized orc decoding.")
      .booleanConf
      .createWithDefault(true)

  val COLUMN_VECTOR_OFFHEAP_ENABLED =
    SqlConfAdapter.buildConf("spark.sql.columnVector.offheap.enabled")
      .internal()
      .doc("When true, use OffHeapColumnVector in ColumnarBatch.")
      .booleanConf
      .createWithDefault(false)

  val ORC_COPY_BATCH_TO_SPARK =
    SqlConfAdapter.buildConf("spark.sql.orc.copyBatchToSpark")
      .doc("Whether or not to copy the ORC columnar batch to Spark columnar batch in the " +
        "vectorized ORC reader.")
      .internal()
      .booleanConf
      .createWithDefault(false)
}
