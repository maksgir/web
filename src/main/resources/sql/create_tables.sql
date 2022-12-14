CREATE SEQUENCE IF NOT EXISTS seq_points START WITH 1 INCREMENT BY 1;


CREATE TABLE IF NOT EXISTS "public"."users" (
    session_id VARCHAR(50) NOT NULL PRIMARY KEY
    );

CREATE TABLE IF NOT EXISTS "public"."points" (
    id INT DEFAULT nextval('seq_points') NOT NULL PRIMARY KEY,
    x double precision CHECK (x>=-4 and x<=4) NOT NULL,
    y double precision CHECK (y>=-3 and y<=3) NOT NULL,
    r double precision CHECK (r>=1 and r<=3) NOT NULL,
    dt TIMESTAMP NOT NULL,
    exe_time double precision NOT NULL,
    owner_id VARCHAR(50) NOT NULL,
    hit BOOLEAN NOT NULL,
    CONSTRAINT fk_owner
    FOREIGN KEY(owner_id)
    REFERENCES users(session_id)
);


