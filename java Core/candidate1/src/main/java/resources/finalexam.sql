create database if not exists finalexam;
use finalexam;

create table candidate(
    id             int primary key auto_increment,
    fisrtname      varchar(50),
    lastname       varchar(50),
    phone          varchar(14),
    email          varchar(50),
    `password`     varchar(50),
    exp_in_year    int,
    pro_skill      varchar(50),
    GraduationRank varchar(50), -- (Excellence, Good, Fair, Poor)
    `role`         varchar(50)  --ExperienceCandidate, FresherCandidate,....
);