create table User (
    id bigint auto_increment primary key,
    first_name varchar(255),
    last_name varchar(255),
    address varchar(255),
    phone_number varchar(255),
    email varchar(255),
    birthday varchar(255),
    main_account_id BIGINT,
    FOREIGN KEY (main_account_id) REFERENCES account(id)
);

create table Account (
    id bigint auto_increment primary key,
    account_type varchar(255),
    balance decimal,
    creating_date varchar(255),
    status varchar(255),
    user_id bigint,
    foreign key (user_id) references User(id)
);