
create table "ADDRESS"
(
    "ID"        bigint       not null
        constraint "ADDRESS_PKEY"
            primary key,
    "COUNTRY"   varchar(255) not null,
    "CITY"      varchar(255) not null,
    "STREET"    varchar(255) not null,
    "POST_CODE" varchar(15)  not null
);

alter table "ADDRESS"
    owner to postgres;

create table "PROJECT"
(
    "ID"    bigint       not null
        constraint "PROJECT_PKEY"
            primary key,
    "TITLE" varchar(255) not null
);

alter table "PROJECT"
    owner to postgres;

create table "EMPLOYEE"
(
    "ID"            bigint       not null
        constraint "EMPLOYEE_PKEY"
            primary key
        constraint "EMPLOYEE_FKEY"
            references "ADDRESS",
    "FIRST_NAME"    varchar(255) not null,
    "LAST_NAME"     varchar(255) not null,
    "BIRTHDAY_DATE" date         not null,
    "ADDRESS_ID"    bigint       not null
);

alter table "EMPLOYEE"
    owner to postgres;

create table "EMP_PROJ"
(
    "EMPLOYEE_ID" bigint not null
        constraint "EMPL_PROJ_EMPLOYEE_ID_fkey"
            references "EMPLOYEE",
    "PROJECT_ID"  bigint not null
        constraint "EMPL_PROJ_PROJECT_ID_FKEY"
            references "PROJECT"
);

alter table "EMP_PROJ"
    owner to postgres;


