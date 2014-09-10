with CTE as 
	(select id, name, parent_id
	from Pages where parent_id is NULL

	union all
	select s.id, s.name, s.parent_id
	from CTE c join Pages p on p.parent_id = c.id
	)
	select * from CTE order by parent_id