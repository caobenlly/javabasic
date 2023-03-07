DROP DATABASE IF EXISTS FinalTest;
CREATE DATABASE FinalTest;
USE FinalTest;
CREATE TABLE `User`(
	Id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    ExpInYear	TINYINT UNSIGNED,
    ProSkill	VARCHAR(50),
    ProjectId	TINYINT UNSIGNED,
    `Role`		ENUM('Employee', 'Manager','Admin')
);

INSERT INTO `User`  (FullName, 				Email,				 		`Password`,			ExpInYear		,		ProSkill	,ProjectId,	`Role`		) 
VALUES		                                                                                                     
					(N'Nguyen Thị A',		'mynt2407@gmail.com', 		'Mynguyen123',			7			,		null		,1,		'Manager'		),
					(N'Nguyen Van B',		'duynn03@gmail.com', 		'duyNguyen',			5			,		null		,2,		'Manager'		),
                    (N'Nguyen Hoang C',		'hungmanh@gmail.com', 		'hunGmanh1',			null		,		'test'		,1,		'Employee'		),
                    (N'Mai Thị D',			'nhung@gmail.com', 			'nhungtOng',			null		,		'java'		,1,		'Employee'		),
                    (N'Trần Kim E',			'kimoanh.tran@gmail.com', 	'tran.kim',				null		,		'java'		,2,		'Employee'		),
					(N'Ngô Khương Duy',		'khuongduy22@gmail.com', 	'khuongduy',			null	    ,		null		,null,		'Admin'		),
					(N'Nguyễn Huy Hùng',	'huyhung24@gmail.com', 	   'hhungdeptrai',			null		,		null		,null,		'Admin'		);
                    
SELECT *FROM `User`;