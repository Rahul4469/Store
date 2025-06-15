alter table addresses
    add state varchar(255) null;

ALTER TABLE addresses
    RENAME COLUMN zipcode TO zip;
