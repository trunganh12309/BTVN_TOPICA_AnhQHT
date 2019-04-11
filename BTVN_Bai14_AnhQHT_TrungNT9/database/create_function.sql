CREATE OR REPLACE FUNCTION public.findPersonByName(pattern VARCHAR) RETURNS TABLE (
 person_id INT,
 person_name VARCHAR
)
 AS '
  SELECT * FROM public.person WHERE name LIKE pattern;
'
LANGUAGE sql;