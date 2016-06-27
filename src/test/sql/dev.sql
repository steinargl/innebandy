
DROP TABLE activity;
DROP TABLE activity_type;
DROP TABLE user_preferences;
DROP TABLE special_day;

DELETE FROM activity where id > 0;
DELETE FROM activity_type where id > 0;

SELECT * FROM activity;
SELECT * FROM day;
SELECT * FROM work_item;
SELECT * FROM activity_type;

commit;


SET FOREIGN_KEY_CHECKS=0;


SELECT *
FROM activity AS a
INNER JOIN activity_type AS at
ON a.activity_type_id=at.id
LEFT JOIN time_registration AS tr
ON a.id=tr.activity_id
WHERE at.user_id='steinar';


#select activity0_.id as col_0_0_ 
select *
from activity activity0_ 
inner join activity_type activityty1_ on activity0_.activity_type_id=activityty1_.id 
left outer join time_registration timeregist2_ on activity0_.id=timeregist2_.activity_id 
where activityty1_.user_id='steinar' and (timeregist2_.date between '2016-04-18' AND '2016-24-04');
       
