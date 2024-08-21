INSERT INTO `users` (`username`, `password`, `enabled`)
VALUES
	('user', 'pass', 1);
	
INSERT INTO `users` (`username`, `password`, `enabled`)
VALUES
	('admin', 'pass', 1);

INSERT INTO `authorities` (`username`, `authority`)
VALUES
	('admin', 'ROLE_ADMIN'),
	('user', 'ROLE_USER');