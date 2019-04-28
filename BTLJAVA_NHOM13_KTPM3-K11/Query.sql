create proc spud_update_quantity
@id int,
@quantity int
as
DECLARE @qty int
select @qty = quantity from Commic where id = @id
update Commic set Commic.quantity = @qty - @quantity where id = @id

create proc spud_input_quantity
@id int,
@inputquantity int
as
DECLARE @qty int
select @qty = quantity from Commic where id = @id
update Commic set Commic.quantity = @qty + @inputquantity where id = @id




SELECT * FROM Commic

drop proc spud_update_quantity

update Commic set Commic.quantity = 100

EXEC spud_update_quantity 1,3

SELECT * FROM Bill

select * from DetailBill

delete from Bill