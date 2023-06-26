Section One (1/2)
#Exposing API's for clients, Nutrition App in Python Hampton Nutrition Inc.
Outline:
API's allow the end user to use python, python libraries like numpy and others to quickly input and post data which is then returned with factual and actionable data.  The data that is selected for the Nutrition
API resolves to daily nutritional values, the remaining nutritional values and the percent breakdown by element.  These include:

-protein,
-calcium,
-iron,
-Potassium

The app and the API allow users to interact with the data from a menu to examine
what nutritional values were consumed, which were considered at store.

Section Two:
# BizIntellig
Multidimensional Models and Over the Shoulder ETF, Stocks and TdAmeritrade ETL

Outline:
Extracting data from a Watchlist, an observation you will first make, kicks off the action in this process.  

The converting of the tab delimited file which is oferred as a service to TdAmeritrade clients was the starting point, the platform that one uses at step one.  Tab delimited values are readable in excel, converted in the second step using excel from tab delimitted into excel format, then into table format for use in structured data anlyses using Power BI or Power Pivot (using com inputs).  In table format the sorting into ascending or descending order is doable as is the insertion of a date colum in yyyy-mm-dd format.  

The process of conversion into csv is necessary because the csv file format is readable in data science programs like R and Python.  This might come in handy for other reasons.  In some cases when converting data types from string to numeric or from alphanumeric into numeric (eg, 101k to 101,000) is simpler using these data science programs.  Calculating expected values and using scikit learn for ml algo useage also was helped out by csv formatting use.

Executive Summary:  The kick off event is inclusive of the addition of a date stamp column you will see inserted, then exported and transformed into a .csv file.  The documentation for this first step is contained herein while the labeled folder, ".csv" contains select files for stocks grouped together in context in a "watchilst".  

Analysis:  data is selected from tab delimtted Td Ameritrade watchlist or filtered for the components that matter to us the most, or the high, low, open and closing prices (four values).

Conclusion:  when calculating the mean price using the API (Python) one can then compare closing price to the high or low which demonstrates the momentum, the relative strength metrics, aka stochastics.

  Azure SQL Component:
  Configuration for a db which will hold fact table information is set and saved in template version with Azure SQL Database service.  The template is used to replicate
  environ and for pushing or pulling to and from any public/private domains where user was granted access to make additions or edits as assigned.  
  Schema will be added and watchlist name, daily price and datestampe as provided in kickoff step above (among others) are column names which are included.  The data
  definition (DDL) language for integer, date and varchar (including limits to column with, eg., 250) is found in scripts initializing the db tables (schema).
  script.


   PowerBI Component:
   The sql database that was created in Devops (Azure) enables the schema which is used for a fact table.  This fact table as mentioned above has a schema/ ddl.  When it is complete (the database is setup after connecting to the Database built in Devops/Azure), one adds data as necessary, then the data can be pushed into the powerBI asset to consume and visualize data.  DevOps team can stop start, push and pull at an increment suitable for refreshing data meaningfully (I.e., nightly on batch, weekly or infrequently, or ad hoc).  
   
   \\exec summ:  the first release, the effort to report on information by group of stocks, watchlists, loosely mirroring a market cap group and industry, eg., small cap, growth, small cap/value, small cap biotech.  The extraction of data can be done on a daily basis, but one might add what the benefit of "it has to be done  (eventually) in real-time", as this is streaming data that the stock market is providing which one should consider.  The streaming data concept allows to stream data at the cost of not having data storage for hourly statistics in an exportable data set, so the data is compiled on a daily basis, but at the end of that day all statistics that were collected such as opening price, hourly price and high for the day, volume and low for the day as well as change over the day are lost by the EOD (end-of-day).  However, capturing the data in a file exported, then transformed and loaded into a fact table, a table gathering data day over day will allo end users to analyze the data across a span of time and prior periods so long as they were exported.  The project in this repo is simply a fact table script, a load script and a reports view folder.  Intermediary steps are done in Extracting and Transforming the data from the fact and transaction table stored in a Sql (Oracle Mysql primary database and backed up in a robuts Sql Server Management Studio instance.  The automation of the activities will be managed using kanban boards and workflows a
