# BizIntellig
Multidimensional Models and Over the Shoulder ETF, Stocks and TdAmeritrade ETL

Outline:
Extracting data from a Watchlist, an observation you will first make, kicks off the process.  The converting of the tab delimited file which is oferred as a service to TdAmeritrade clients from this format into comma-separated-values (.csv) files details this project work activity, the kick-off event.  The kick off event is inclusive of the addition of a date stamp column you will see inserted into an exported file, prior to the conversion of the newly structured file for consumption after its conversion into a .csv file.  The documentation for this first step is contained herein while the labeled folder, ".csv" contains select files for stocks grouped together in context in a "watchilst".  

  Azure SQL Component:
  Configuration for a db which will hold fact table information is set and saved in template version with Azure SQL Database service.  The template is used to replicate
  environ and for pushing or pulling to and from any public/private domains where user was granted access to make additions or edits as assigned.  
  Schema will be added and watchlist name, daily price and datestampe as provided in kickoff step above (among others) are column names which are included.  The data
  definition (DDL) language for integer, date and varchar (including limits to column with, eg., 250) is found in scripts initializing the db tables (schema).
  script.


per exported data set predicates the consumption of the data and subsequent aggregation by software, Business Intelligence platforms which depend on structured (sql) format.   then adding dim tables for date captures
the first release, the effort to report on information by group of stocks, watchlists, loosely mirroring a market cap group and industry, eg., small cap, growth, small cap/value, small cap biotech.  The extraction of data can be done on a daily basis, but it has to be done in real-time, as this is streaming data that the stock market is providing.  The streaming data concept allows to stream data at the cost of not having data storage for hourly statistics in an exportable data set, so the data is compiled on a daily basis, but at the end of that day all statistics that were collected such as opening price, hourly price and high for the day, volume and low for the day as well as change over the day are lost by the EOD (end-of-day).  However, capturing the data in a file exported, then transformed and loaded into a fact table, a table gathering data day over day will allo end users to analyze the data across a span of time and prior periods so long as they were exported.  The project in this repo is simply a fact table script, a load script and a reports view folder.  Intermediary steps are done in Extracting and Transforming the data from the fact and transaction table stored in a Sql (Oracle Mysql primary database and backed up in a robuts Sql Server Management Studio instance.  The automation of the activities will be managed using kanban boards and workflows a
