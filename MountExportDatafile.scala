// Databricks notebook source
val containerName = "storeagecontainer"
val storageAccountName = "contrerasenavarrostorage"
val sas = "sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2024-09-12T10:22:26Z&st=2024-09-12T02:22:26Z&spr=https&sig=WDx6sf0qiUjQnIMODWRY6wRcNH5XHcB%2F9EGNr56HQmM%3D"

val url = "wasbs://" + containerName + "@" + storageAccountName + ".blob.core.windows.net/"
var config = "fs.azure.sas." + containerName + "." + storageAccountName + ".blob.core.windows.net"

// COMMAND ----------

// COMMAND ----------

dbutils.fs.mount(
source = url,
mountPoint = "/mnt/files",
extraConfigs = Map(config -> sas))

// COMMAND ----------

// MAGIC %md
// MAGIC #End of Section

// COMMAND ----------

// MAGIC %fs ls /mnt/files

// COMMAND ----------

// MAGIC %md
// MAGIC #Start Check Mount using language of choice, scala for instance
// MAGIC

// COMMAND ----------

// MAGIC %fs ls /mnt/files
// MAGIC

// COMMAND ----------

val df = spark.read
.option("header","true")
.csv("dbfs:/mnt/files/Bookmar20watchlistappendfxmeasuredv2forcsv.csv")

// COMMAND ----------

// MAGIC %md
// MAGIC #ETL data imported as csv and ddl where each field in str data type (transform to schema of integers and whole numbers as numeric ddl type not strings (str) where necessary)

// COMMAND ----------

import org.apache.spark.sql.types._
val customSchema = StructType(
  List(
              StructField("Symbol", StringType, true),
              StructField("Last Price", IntegerType, true),
              StructField("Change $", IntegerType, true),  
              StructField("Change %", DecimalType(10,2), true),
              StructField("Bid", IntegerType, true),
              StructField("Ask", IntegerType, true),
              StructField("52 Week Range", StringType, true),
              StructField("Volume", StringType, true),
              StructField("Last Trade (ET)", DateType, true)              
	)
  
)

// COMMAND ----------

// MAGIC %md
// MAGIC #attach new revised schema to df (data frame)

// COMMAND ----------

val dfSchema = spark.read
.option("header","true")
.schema(customSchema)
.csv("dbfs:/mnt/files/Bookmar20watchlistappendfxmeasuredv2forcsv.csv")

// COMMAND ----------

// MAGIC %md
// MAGIC #View it via displayer

// COMMAND ----------

display(dfSchema)

// COMMAND ----------

// MAGIC %md
// MAGIC #Use Python to analyze some

// COMMAND ----------

// MAGIC %python
// MAGIC from pyspark.sql.types import *
// MAGIC customSchemaPython = StructType (
// MAGIC   [
// MAGIC               StructField("Symbol", StringType(), True),
// MAGIC               StructField("Last Price", DecimalType(10,2), True),
// MAGIC               StructField("Change $", DecimalType(10,2), True),  
// MAGIC               StructField("Change %", DecimalType(10,2), True),
// MAGIC               StructField("Bid", DecimalType(10,2), True),
// MAGIC               StructField("Ask", DecimalType(10,2), True),
// MAGIC               StructField("52 Week Range", StringType(), True),
// MAGIC               StructField("Volume", IntegerType(), True),
// MAGIC               StructField("Last Trade (ET)", DateType(), True) 
// MAGIC   ]
// MAGIC   
// MAGIC )

// COMMAND ----------

// MAGIC %md
// MAGIC #attach this schema to the df created previously 

// COMMAND ----------

// MAGIC %python
// MAGIC df = spark.read.format("csv") \
// MAGIC   .options(header='true', delimiter = ',') \
// MAGIC   .schema(customSchemaPython) \
// MAGIC   .load("dbfs:/mnt/files/Bookmar20watchlistappendfxmeasuredv2forcsv.csv")

// COMMAND ----------

// MAGIC %md #view data frame
// MAGIC

// COMMAND ----------

display(df)
