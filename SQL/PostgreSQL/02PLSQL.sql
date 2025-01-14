--Returns HelloWorld!


CREATE OR REPLACE FUNCTION display()  
RETURNS varchar AS'

BEGIN

	return ''Hello World!'';

END;
'LANGUAGE 'plpgsql';






		rno int primary key,
		name varchar(20) not null,
		per float
	);

--Returns Query (Table)



CREATE OR REPLACE FUNCTION display(input_rno int)  
RETURNS TABLE( rno student.rno%TYPE, name student.name%TYPE, per student.per%TYPE )
AS'

BEGIN

	RETURN QUERY 
	SELECT *
	FROM student 
	WHERE student.rno = input_rno; 

END;
'LANGUAGE 'plpgsql';
