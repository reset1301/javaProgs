create table usr_pass_phr(
    id int8 not null,
    pass_phrase varchar(255)
  );
alter TABLE usr_pass_phr
    add constraint usr_pass_phr_fk foreign key (id) references usr(id);