
create table api_query(
	id bigserial primary key,
	name varchar(20),
	contents varchar(1000),
	description varchar(300),
	resourcer_id int,
	created TIMESTAMPTZ,
	deleted TIMESTAMPTZ,
	is_enabled bool
);
create index api_query_resourcer on api_query(resourcer_id);

create table api_query_parameter(
	id bigserial primary key,
	name varchar(20),
	description varchar(300),
	io_type varchar(8),
	is_optional bool,
	query_id int,
	created TIMESTAMPTZ,
	deleted TIMESTAMPTZ,
	is_enabled bool
);
create index api_query_parameter_query_id on api_query_parameter(query_id);

create table api_resourcer_info(
	id bigserial primary key,
	name varchar(20),
	path varchar(300) unique,
	description varchar(300),
	access_name varchar(20),
	key varchar(128),
	driver varchar(20),
	driver_class_name varchar(100),
	created TIMESTAMPTZ,
	deleted TIMESTAMPTZ,
	is_enabled bool
);

create table api_router(
	id bigserial primary key,
	name varchar(20),
	path varchar(300) unique,
	description varchar(300),
	is_disabled bool,
	query_id int,
	created TIMESTAMPTZ,
	deleted TIMESTAMPTZ,
	is_enabled bool
);

create table api_resource_request(
	id bigserial primary key,
	requester_id int,
	router_id int,
	state int,
	created TIMESTAMPTZ,
	deleted TIMESTAMPTZ,
	is_enabled bool
);

create table api_query_argument(
	id bigserial primary key,
	query_parameter_id int,
	request_history_id int,
	contents varchar(300),
	created TIMESTAMPTZ,
	deleted TIMESTAMPTZ,
	is_enabled bool
);