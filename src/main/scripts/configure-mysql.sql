# Create Databases
CREATE DATABASE sfg_dev;
CREATE DATABASE sfg_prod;

# Create DB service accounts
CREATE USER `sfg_dev_user`@'localhost'
    IDENTIFIED WITH caching_sha2_password BY 'T=6He6X?n?(#Y8$';
CREATE USER `sfg_dev_user`@'%'
    IDENTIFIED WITH caching_sha2_password BY 'T=6He6X?n?(#Y8$';
CREATE USER `sfg_prod_user`@'localhost'
    IDENTIFIED WITH caching_sha2_password BY 'T=6He6X?n?(#Y8$';
CREATE USER `sfg_prod_user`@'%'
    IDENTIFIED WITH caching_sha2_password BY 'T=6He6X?n?(#Y8$';


# Database grants
GRANT SELECT ON sfg_dev.* to `sfg_dev_user`@'localhost';
GRANT INSERT ON sfg_dev.* to `sfg_dev_user`@'localhost';
GRANT DELETE ON sfg_dev.* to `sfg_dev_user`@'localhost';
GRANT UPDATE ON sfg_dev.* to `sfg_dev_user`@'localhost';
GRANT SELECT ON sfg_prod.* to `sfg_prod_user`@'localhost';
GRANT INSERT ON sfg_prod.* to `sfg_prod_user`@'localhost';
GRANT DELETE ON sfg_prod.* to `sfg_prod_user`@'localhost';
GRANT UPDATE ON sfg_prod.* to `sfg_prod_user`@'localhost';
GRANT SELECT ON sfg_dev.* to `sfg_dev_user`@'%';
GRANT INSERT ON sfg_dev.* to `sfg_dev_user`@'%';
GRANT DELETE ON sfg_dev.* to `sfg_dev_user`@'%';
GRANT UPDATE ON sfg_dev.* to `sfg_dev_user`@'%';
GRANT SELECT ON sfg_prod.* to `sfg_prod_user`@'%';
GRANT INSERT ON sfg_prod.* to `sfg_prod_user`@'%';
GRANT DELETE ON sfg_prod.* to `sfg_prod_user`@'%';
GRANT UPDATE ON sfg_prod.* to `sfg_prod_user`@'%';