CREATE TABLE IF NOT EXISTS t_sys_function (
  id varchar(40) NOT NULL COMMENT '角色ID',
  name varchar(40) DEFAULT NULL COMMENT '功能名称',
  module varchar(40) DEFAULT NULL COMMENT '功能模块',
  remark varchar(100) DEFAULT NULL COMMENT '功能名称',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统功能信息表';

CREATE TABLE IF NOT EXISTS t_sys_option (
  id varchar(20) NOT NULL COMMENT '参数ID',
  data varchar(2000) NOT NULL COMMENT '参数值',
  remark varchar(100) DEFAULT NULL COMMENT '参数描述',
  updatedAt varchar(20) DEFAULT NULL COMMENT '更新时间',
  updatedBy varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

CREATE TABLE IF NOT EXISTS t_sys_organization (
  id varchar(20) NOT NULL COMMENT '机构ID',
  parent_id varchar(20) NOT NULL COMMENT '父级机构ID',
  name varchar(20) DEFAULT NULL COMMENT '机构名称',
  remark varchar(100) DEFAULT NULL COMMENT '机构描述',
  status varchar(10) NOT NULL COMMENT '机构状态',
  createdAt varchar(20) DEFAULT NULL COMMENT '创建时间',
  updatedAt varchar(20) DEFAULT NULL COMMENT '更新时间',
  createdBy varchar(20) DEFAULT NULL COMMENT '创建人',
  updatedBy varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统机构信息表';

CREATE TABLE IF NOT EXISTS t_sys_role (
  id varchar(20) NOT NULL COMMENT '角色ID',
  name varchar(20) DEFAULT NULL COMMENT '角色名称',
  functions varchar(2000) NOT NULL COMMENT '功能列表',
  status varchar(10) NOT NULL COMMENT '角色状态',
  remark varchar(100) DEFAULT NULL COMMENT '参数描述',
  createdAt varchar(20) DEFAULT NULL COMMENT '创建时间',
  updatedAt varchar(20) DEFAULT NULL COMMENT '更新时间',
  createdBy varchar(20) DEFAULT NULL COMMENT '创建人',
  updatedBy varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工解色信息表';

CREATE TABLE IF NOT EXISTS t_sys_staff (
  id varchar(20) NOT NULL COMMENT '员工ID',
  password varchar(32) NOT NULL COMMENT '登录密码',
  roles varchar(1000) NOT NULL COMMENT '角色列表',
  organizations varchar(2000) NOT NULL COMMENT '员工机构',
  status varchar(10) NOT NULL COMMENT '员工状态',
  pwd_fail_cnt int(2) NOT NULL COMMENT '密码错误次数',
  totp_key varchar(20) DEFAULT NULL COMMENT 'TOTP密钥',
  name varchar(20) DEFAULT NULL COMMENT '员工姓名',
  email varchar(50) DEFAULT NULL COMMENT '员工邮箱',
  gender varchar(20) DEFAULT NULL COMMENT '员工姓别',
  phoneNumber varchar(20) DEFAULT NULL COMMENT '员工电话号码',
  lastLoginAt varchar(20) DEFAULT NULL COMMENT '最后登录时间',
  createdAt varchar(20) DEFAULT NULL COMMENT '创建时间',
  updatedAt varchar(20) DEFAULT NULL COMMENT '更新时间',
  createdBy varchar(20) DEFAULT NULL COMMENT '创建人',
  updatedBy varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表';
