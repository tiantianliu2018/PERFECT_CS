-- Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。
-- Department 表包含公司所有部门的信息。
-- 编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。
-- 题解：
    -- 首先 Employee 和 Department 表做一个 left join 可以得到总的表，每个部门的话根据部分分组，取前三个
--     # topN问题 sql模板
--     select *
--     from (
--        select *,
--               row_number() over (partition by 要分组的列名
--                            order by 要排序的列名 desc) as 排名
--        from 表名) as a
--     where 排名 <= N;

select  d.Name as Department, e.Name as Employee, e.Salary
from (
    select  *,
        dense_rank() over (partition by DepartmentId
                    order by Salary desc) as ranking
    from Employee)  as e
inner join Department as d on d.id = e.DepartmentId
where ranking <= 3;