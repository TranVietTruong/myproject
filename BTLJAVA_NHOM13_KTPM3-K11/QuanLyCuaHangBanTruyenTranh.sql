USE ComMic

CREATE TABLE Catagory
(
	id INT IDENTITY PRIMARY KEY,
	name_catagory NVARCHAR(255) NOT NULL
)

CREATE TABLE Publisher
(
	id INT IDENTITY PRIMARY KEY,
	name_publisher NVARCHAR(255) NOT NULL
)

CREATE TABLE Commic
(
	id INT IDENTITY PRIMARY KEY,
	name_commic NVARCHAR(255) NOT NULL,
	id_catagory INT,
	id_publisher INT,
	quantity INT,
	price INT,
	CONSTRAINT fk_id_catagory FOREIGN KEY(id_catagory) REFERENCES Catagory(id) ON DELETE SET NULL,
	CONSTRAINT fk_id_publisher FOREIGN KEY(id_publisher) REFERENCES Publisher(id) ON DELETE SET NULL,
)

CREATE TABLE Bill 
(
	id INT IDENTITY PRIMARY KEY,
	name_customer NVARCHAR(255) NOT NULL,
	name_employee NVARCHAR(255) NOT NULL,
	date_order DATETIME,
	note TEXT,
	total_money int,
	promotion int,
)

CREATE TABLE DetailBill
(
	id INT IDENTITY PRIMARY KEY,
	id_bill INT,
	id_commic INT,
	quantity_oder INT,
	CONSTRAINT fk_id_bill FOREIGN KEY(id_bill) REFERENCES Bill(id) ON DELETE CASCADE,
	CONSTRAINT FK_id_Commic FOREIGN KEY(id_commic) REFERENCES Commic(id) ON DELETE CASCADE 
)


CREATE TABLE Coupon
(
	id INT IDENTITY PRIMARY KEY,
	name_suppiler NVARCHAR(255) NOT NULL,
	date_order DATETIME,
	note text,
	total_money int
)

CREATE TABLE DetailCoupon
(
	id INT IDENTITY PRIMARY KEY,
	id_coupon INT,
	id_commic INT,
	quantity_order INT,
	import_price INT,
	CONSTRAINT fk_id_coupon FOREIGN KEY(id_coupon) REFERENCES Coupon(id) ON DELETE CASCADE,
	CONSTRAINT FK_id_Commic_Coupon FOREIGN KEY(id_commic) REFERENCES Commic(id) ON DELETE CASCADE 
)

CREATE TABLE Employee
(
	id INT IDENTITY PRIMARY KEY,
	name_employee NVARCHAR(255) NOT NULL,
	name_user NVARCHAR(255) NOT NULL,
	pass_word VARCHAR(255) NOT NULL,
	level_employee int
)