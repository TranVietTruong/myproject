SELECT *,FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') as dateorder
FROM Bill WHERE is_delete = 0 
AND FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb') 

SELECT Sum(quantity_oder) as sltruyendaban FROM Bill INNER JOIN DetailBill ON BILL.id = DetailBill.id_bill
WHERE FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb') 

SELECT * FROM Bill INNER JOIN DetailBill ON BILL.id = DetailBill.id_bill
WHERE FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb') 

SELECT Commic.name_commic,sum(DetailBill.quantity_oder) as tsl,Commic.id FROM Commic,Bill,DetailBill 
WHERE DetailBill.id_commic = Commic.id AND DetailBill.id_bill = Bill.id 
AND FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb')  
GROUP BY Commic.id ORDER BY tsl

SELECT Commic.name_commic, Commic.id, sum(DetailBill.quantity_oder) as soluong FROM Commic,Bill,DetailBill 
WHERE DetailBill.id_commic = Commic.id AND DetailBill.id_bill = Bill.id 
AND FORMAT(Bill.date_order,'MM/dd/yyyy','en-gb') = FORMAT(GETDATE(),'dd/MM/yyyy','en-gb')  
GROUP BY Commic.name_commic, Commic.id ORDER BY soluong DESC

