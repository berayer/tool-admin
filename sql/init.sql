create database `tool-admin`;

create table `SysUser` (
    `Id` int primary key comment 'Id',
    `Username` varchar(50) not null unique comment '用户名',
    `Password` varchar(255) not null comment '密码',
    `CreateBy` varchar(50) not null comment '创建人',
    `CreateTime` datetime not null comment '创建时间',
    `UpdateBy` varchar(50) comment '最后修改人',
    `UpdateTime` datetime comment '最后修改时间'
) comment '系统用户信息表';

create table `SysRole` (
    `Id` int primary key comment 'Id',
    `Name` varchar(50) not null unique comment '角色名称',
    `CreateBy` varchar(50) not null comment '创建人',
    `CreateTime` datetime not null comment '创建时间',
    `UpdateBy` varchar(50) comment '最后修改人',
    `UpdateTime` datetime comment '最后修改时间'
) comment '系统角色信息表';

create table `SysUserRole` (
    `Id` int primary key comment 'Id',
    `UserId` int not null comment '用户Id',
    `RoleId` int not null comment '角色Id',
    `CreateBy` varchar(50) not null comment '创建人',
    `CreateTime` datetime not null comment '创建时间',
    `UpdateBy` varchar(50) comment '最后修改人',
    `UpdateTime` datetime comment '最后修改时间',
    unique key un_userId_roleId (`UserId`, `RoleId`)
) comment '系统用户角色关联表';