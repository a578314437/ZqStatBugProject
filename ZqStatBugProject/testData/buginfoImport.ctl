load data
CHARACTERSET AL32UTF8
infile '/home/oracle/testData/buginfo.csv'
REPLACE  into table ZQ_BUG_INFO
fields terminated by ',' 
trailing nullcols
(
MODULE,
bugtitle,
slevel,
priority,
bugstatus,
activatecount,
creator,
creatortime,
designate,
designatetime,
solver,
solution,
solvertime,
closetime
)
