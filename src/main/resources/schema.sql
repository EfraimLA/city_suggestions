CREATE TABLE cities
(
    id          INT not null,
    name        TEXT,
    ascii       TEXT,
    alt_name    TEXT,
    lat         TEXT,
    long        TEXT,
    feat_class  CHAR,
    feat_code   TEXT,
    country     TEXT,
    cc2         TEXT,
    admin1      TEXT,
    admin2      TEXT,
    admin3      TEXT,
    admin4      TEXT,
    population  INT,
    elevation   INT,
    dem         INT,
    tz          TEXT,
    modified_at DATE,
    CONSTRAINT cities_pk
        PRIMARY KEY (id)
);

CREATE UNIQUE INDEX cities_id_uindex
    ON cities (id);
