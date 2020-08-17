SELECT
    /*%expand*/* 
FROM
    app.t_todo 
WHERE
    todo_id = /*todoId*/1 
ORDER BY
    prio;
