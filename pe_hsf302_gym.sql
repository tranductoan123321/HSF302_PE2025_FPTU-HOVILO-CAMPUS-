use master;
go
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'pe_hsf302_gym')
BEGIN
	ALTER DATABASE [pe_hsf302_gym] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [pe_hsf302_gym] SET ONLINE;
	DROP DATABASE [pe_hsf302_gym];
END

create database pe_hsf302_gym;
go

use pe_hsf302_gym;
go

create table dbo.member
(
    id       int identity
        constraint member_pk
            primary key,
    username varchar(255) not null
        constraint member_pk_2
            unique,
    password varchar(255) not null,
    role     varchar(255) not null
)
go

create table dbo.training
(
    id               int identity
        constraint training_pk
            primary key,
    member_id        int not null
        constraint training_member_id_fk
            references dbo.member,
    duration_minutes int not null,
    notes            nvarchar(255)
)
go

INSERT INTO dbo.member (username, password, role)
VALUES ('herc', '$2a$10$fsEj0lhmeUFjZ2IiwRVBieLPYDd9yLJZJRNscwCSKltHdMjXVRNom', 'MEMBER'),
       ('pose', '$2a$10$bOzLrpimJOVJYHbKb0717OEjiiL4bmFMLQzPxX62C9ZWB/Cp4Sydu', 'VIP')
go

INSERT INTO dbo.training (member_id, duration_minutes, notes)
VALUES (1, 60, 'Cardio and basic warm-up exercises'),
       (1, 90, 'Leg day - squats, lunges raises'),
       (1, 45, 'Upper body strength - bench press and rows'),
       (1, 60, 'Full body workout with compound movements'),
       (1, 75, 'HIIT training - high intensity intervals'),
       (1, 30, 'Core stability and ab exercises'),
       (1, 90, 'Back and biceps training session'),
       (1, 60, 'Chest and triceps workout'),
       (1, 45, 'Shoulder and trap exercises'),
       (1, 120, 'Advanced powerlifting session'),
       (1, 60, 'Functional training with kettlebells'),
       (1, 75, 'Deadlift and squat variations'),
       (1, 45, 'Morning cardio - treadmill and bike'),
       (2, 60, 'Circuit training - 5 stations'),
       (2, 90, 'Strength endurance training'),
       (2, 30, 'Beginner introduction to gym equipment'),
       (2, 45, 'Basic compound movements practice'),
       (2, 60, 'Progressive overload - week 2'),
       (2, 75, 'Olympic weightlifting techniques'),
       (2, 90, 'Snatch and clean practice'),
       (2, 60, 'Accessory work for weightlifting'),
       (2, 60, 'Boxing conditioning and cardio'),
       (2, 45, 'Core training for combat sports'),
       (2, 75, 'Plyometric and agility drills'),
       (2, 60, 'Recovery session - stretching and mobility'),
       (2, 90, 'Hypertrophy training - chest focus'),
       (2, 75, 'Leg hypertrophy - high volume training'),
       (2, 45, 'Active recovery - light cardio'),
       (2, 60, 'Push workout - chest, shoulders, triceps'),
       (2, 75, 'Pull workout - back, biceps, rear delts')
go
