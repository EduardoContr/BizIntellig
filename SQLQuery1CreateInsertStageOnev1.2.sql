CREATE TABLE [FactListdb].[dbo].TransactTable (
    TransactID int identity(100,1) PRIMARY KEY,
    WatchlistName varchar(50) NOT NULL,
    Symbol varchar(20) NOT NULL,
    Bid NUMERIC(10,5),
    Ask NUMERIC(10,5),
    Price NUMERIC(10,5) NULL,
    Chg$ NUMERIC(10,5) NULL,
    Chgpct NUMERIC(10,5) NULL,
    Openp NUMERIC(10,5) NULL,
    Highp NUMERIC(10,5) NULL,
    Lowp NUMERIC(10,5) NULL,
    Volume int NULL,


);

INSERT INTO [FactListdb].[dbo].TransactTable
VALUES 
('hilo','KALV',6.78,6.82,6.8,0.19,2.87,6.63,6.825,6.6,41.83),
('hilo','BIG',10.51,10.53,10.52,0.19,1.84,10.31,10.62,10.16,288.8),
('hilo','GOLD',18.6,18.61,18.61,0.1084,0.59,18.57,18.645,18.4,6180);

select * from TransactTable