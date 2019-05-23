use mysql;
select host, user from user;
-- 因为mysql版本是5.7，因此新建用户为如下命令：
create user xibian identified by 'xibian123456';
-- 将xibian数据库的权限授权给创建的xibian用户，密码为xibian123456：
grant all on xibian.* to xibian@'%' identified by 'xibian123456' with grant option;
-- 这一条命令一定要有：
flush privileges;