create table if not exists achieves
(
    id          int primary key auto_increment,
    name        varchar(255),
    description varchar(255)
);
create table if not exists customers
(
    id int primary key
);

create table if not exists customers_achieves
(
    customer_id int,
    achieve_id  int,
    constraint pk_customers_achieves primary key (customer_id, achieve_id),
    constraint fk_customer foreign key (customer_id) references customers (id) on delete cascade,
    constraint fk_achieve foreign key (achieve_id) references achieves (id) on delete cascade
);

create table if not exists logs
(
    id          int primary key auto_increment,
    msg         varchar(255),
    created     timestamp not null,
    customer_id int,
    name        varchar(255),
    last_name   varchar(255),
    balance     bigint,
    log_action  varchar(50)
);

insert into achieves (id, name, description) values (1, 'First step', 'We\'ve got when the balance more than 15 000'),
                                                    (2, 'Open to the World', 'When you have got fully filled account'),
                                                    (3, 'Extreme down', 'When you have negative balance');
