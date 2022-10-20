<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Веб</title>
    <link href="css/styles.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/jsxgraph/distrib/jsxgraph.css"/>
    <script src="js/table_worker.js"></script>
    <script src="js/submit_data.js"></script>
    <script src="js/validator.js"></script>
    <script src="js/graph.js"></script>
    <script src="jquery/jquery-3.6.1.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://cdn.jsdelivr.net/npm/jsxgraph/distrib/jsxgraphcore.js"></script>


</head>

<body>
<div place="header">
    <span>Лабораторная работа №2</span>
    <span>Гиря Максим Р32131</span>
    <span>Вариант: 3189</span>
</div>
<div class="container">
    <div class="graph">
        <div id="jxgbox" class="jxgbox" style="width:300px; height:300px;padding: 0px"></div>
        <script src="js/graph.js"></script>
    </div>
    <div order="2">
        <form>
            <label><h3>Значение Х</h3><select class="choose" id="x_val">
                <option>-4</option>
                <option>-3</option>
                <option>-2</option>
                <option>-1</option>
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select></label><br><br>
            <label><h3>Значение Y</h3><input id="y_val" class="choose" type="number" min="-3" max="3"/></label><br><br>
            <label><h3>Значение R</h3><select id="r_val" class="choose">
                <option value="" selected disabled hidden>Выберите R</option>
                <option>1</option>
                <option>1.5</option>
                <option>2</option>
                <option>2.5</option>
                <option>3</option>
            </select></label><br><br><br>
            <button class="button" id="submitButton" type="button">Проверить</button>
        </form>
    </div>
    <div order="2">
        <table id="result_table">
            <button id="clearButton" class="button" type="button">Очистить таблицу</button>
            <tr class="first-line">
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Текущее время</th>
                <th>Время выполнения</th>
                <th>Результат</th>
            </tr>
            <tbody id="table_body">

            </tbody>
        </table>
    </div>
</div>
<div place="footer">
    <span><a href="https://github.com/maksgir"><img style="border-radius: 10px" src="img/gitlogo.png"></a></span>
</div>
</body>
</html>