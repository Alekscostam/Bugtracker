-- INSERT INTO Institution(code) VALUES('85bDT-PZc1M-or5Vr-kmRQR');

INSERT INTO project(name,date,description,institution_code) VALUES('Project 1','1997-08-24','Bug tracker project1','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO project(name,date,description,institution_code) VALUES('Project 2','2020-10-24','Bug tracker project2','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO project(name,date,description,institution_code) VALUES('Project 3','2020-08-24','Bug tracker project3','85bDT-PZc1M-or5Vr-kmRQR');

INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Aleksander','Kowalski','kowalski.al@wp.pl','123','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Employee 1','Employee last1','Employee@wp.pl1','sadsd','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Employee 2','Employee last1','Employee@wp.pl1','sadsd','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Employee 3','Employee last1','Employee@wp.pl1','sadsd','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Employee 5','Employee last1','Employee@wp.pl1','sadsd','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Employee 6','Employee last1','Employee@wp.pl1','sadsd','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('Employee 7','Employee last1','Employee@wp.pl1','sadsd','85bDT-PZc1M-or5Vr-kmRQR');
INSERT INTO employee(first_name,last_name,email,password,institution_code) VALUES('asd','asd','asd@wp.pl','$2a$10$IZv9QCL212u3e3rlpbAqJ.2STaiJ2tdnpLdRkypxQclE2xN5QdbgW','asd-asd-asd-asd');



INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',0,0,1,1,'desc1');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1998-08-24',1,1,2,2,'desc2');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',2,2,3,3,'desc3');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('2020-08-24',0,3,4,1,'desc4');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',1,0,5,2,'desc5');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',2,1,6,3,'desc6');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',0,2,7,1,'desc7');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',2,3,8,2,'desc8');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',0,0,1,3,'desc9');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1998-08-24',1,1,2,1,'desc10');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',2,2,3,2,'desc11');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('2020-08-24',0,3,4,3,'desc12');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',1,0,5,1,'desc13');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',2,1,6,2,'desc14');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',0,2,7,3,'desc15');
INSERT INTO bug(date,level,progress,employee_id,project_id,description) VALUES('1997-08-24',1,3,8,1,'desc16');


INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(1,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(2,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(2,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(2,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(2,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(2,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(2,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(3,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(4,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(5,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(6,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(7,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(8,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(8,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(8,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(8,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(8,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(9,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(10,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(11,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(12,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(13,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,1);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,2);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(14,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(15,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(15,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(15,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(15,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(15,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(15,6);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(16,7);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(16,8);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(16,3);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(16,4);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(16,5);
INSERT INTO bug_employee(bug_id,employee_id) VALUES(16,6);













