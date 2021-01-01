DROP TABLE IF EXISTS bug_employee ;
DROP TABLE IF EXISTS employee_project ;
DROP TABLE IF EXISTS bug ;
DROP TABLE IF EXISTS employee ;
DROP TABLE IF EXISTS institution ;
DROP TABLE IF EXISTS project ;




create table project
(
    id          bigserial not null constraint project_pkey primary key,
    date        timestamp,
    description varchar(255),
    name        varchar(255),
    institution_code    varchar(255)
);


create table employee
(
    id             bigserial not null constraint employee_pkey primary key,
    email          varchar(255),
    first_name     varchar(255),
    last_name      varchar(255),
    password       varchar(255),
    institution_code     varchar(255)
);

create table bug
(
    id          bigserial not null constraint bug_pkey primary key,
    date        timestamp,
    last_modify  timestamp,
    description varchar(255),
    level       integer,
    progress    integer,
    employee_id bigserial not null constraint fk_bug_employee references employee(id),
    project_id  bigserial not null constraint fk_bug_project references project(id)
);


create table bug_employee
(
    bug_id       bigserial not null constraint fkaxlm9mparw77y92nkc7us6q4b  references bug(id),
    employee_id  bigserial not null constraint fk9pp1sw9e2inav2mmgmbn7vk0v    references employee(id),
    constraint bug_employee_pkey primary key (bug_id, employee_id)
);

-- create table employee_project
-- (
--     employee_id bigserial not null constraint fkb25s5hgggo6k4au4sye7teb3a references employee(id),
--     project_id  bigserial not null constraint fk4yddvnm7283a40plkcti66wv9 references project(id),
--     constraint employee_project_pkey primary key (employee_id, project_id)
-- );