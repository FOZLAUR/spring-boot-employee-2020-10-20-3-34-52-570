CREATE TABLE COMPANY (
    company_id int PRIMARY KEY AUTO_INCREMENT,
    company_name varchar(255)
);

CREATE TABLE EMPLOYEE (
    employee_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    age int,
    gender varchar(255),
    salary int,
    company_id int,
    FOREIGN KEY (company_id) REFERENCES COMPANY(company_id)
);