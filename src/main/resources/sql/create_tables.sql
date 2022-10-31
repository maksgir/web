CREATE SEQUENCE IF NOT EXISTS seq_points START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS seq_user START WITH 1 INCREMENT BY 1;


CREATE TABLE IF NOT EXISTS "public"."users" (
    id INT DEFAULT nextval('seq_user') NOT NULL PRIMARY KEY,
    session_id VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS "public"."points" (
    id INT DEFAULT nextval('seq_points') NOT NULL PRIMARY KEY,
    x DOUBLE CHECK (x>=-4 and x<=4) NOT NULL,
    y DOUBLE CHECK (y>=-3 and y<=3) NOT NULL,
    r DOUBLE CHECK (r>=1 and x<=3) NOT NULL,
    timezone INT NOT NULL,
    exe_time DOUBLE NOT NULL,
    owner_id INT NOT NULL,
    CONSTRAINT fk_owner
    FOREIGN KEY(owner_id)
    REFERENCES users(id)
    );


