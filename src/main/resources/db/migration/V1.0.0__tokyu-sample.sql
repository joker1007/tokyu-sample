
    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    create table Todo (
       id bigint not null,
        createdAt datetime(6),
        name varchar(255),
        status integer,
        primary key (id)
    ) engine=InnoDB;
