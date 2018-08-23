load data
infile '/buginfo.csv'
into table "ZQ_BUG_INFO"
fields terminated by ','
(module,bugtitle,slevel,priority,bugstatus,activatecount,creator,creatortime,designate,designatetime,solver,solution,solvertime,closetime)