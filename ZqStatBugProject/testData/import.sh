cd /home/oracle/
source .bash_profile
cd /testData
sqlldr userid=sspcom/Tydic300047@127.0.0.1:1521/orcl control=buginfoImport.ctl skip=1
