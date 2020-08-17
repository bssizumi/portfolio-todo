SELECT
    /*%expand*/* 
FROM
    app.t_todo 
WHERE
    list_id = /*listId*/1 
ORDER BY
    prio;
