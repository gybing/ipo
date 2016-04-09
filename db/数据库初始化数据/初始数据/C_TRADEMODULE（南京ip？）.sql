prompt Importing table C_TRADEMODULE...
set feedback off
set define off
insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (10, '综合管理平台', 'integrated', '综合管理平台', null, null, null, 'Y', null, null, null, 'N', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (11, '财务系统', 'finance', '财务系统', 'FN_F_firmADD', 'FN_F_FirmToStatus', 'FN_F_FirmDel', 'Y', null, null, null, 'N', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (13, '仓单管理系统', 'bill', '仓单管理系统', 'FN_BI_firmADD', null, 'FN_BI_FirmDel', 'Y', '10.0.100.181', 20371, 20372, 'Y', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (32, '单点登录系统', 'activeuser', '单点登录系统', null, null, null, 'N', null, null, null, 'N', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (12, '仓库管理系统', 'warehouse', '仓库管理系统', null, null, null, 'N', null, null, null, 'N', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (19, '加盟会员管理系统', 'broker', '加盟会员管理系统', 'FN_BR_firmADD', null, null, 'N', null, null, null, 'N', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (15, '订单管理系统', 'timebargain', '订单管理系统', 'FN_T_firmADD', null, 'FN_T_FirmDel', 'Y', '10.0.100.181', 20671, 20672, 'Y', 'Y');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (99, '公用系统', 'common', '公用系统', null, null, null, 'N', '10.0.100.181', 20171, 20172, 'Y', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (40, 'IPO', 'ipo', 'IPO', null, null, null, 'Y', '127.0.0.1', 20971, 20972, 'Y', 'N');

insert into C_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (28, '银行接口', 'bank', '银行接口', 'FN_F_B_firmADD', null, 'FN_F_B_FirmDEL', 'Y', '10.0.100.181', 4117, 4118, 'N', 'N');
commit;

prompt Done.
