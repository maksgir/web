function initialize_table(board) {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {"init": 'true'},
        success: function (response) {
            Array.from(response).forEach(function (row) {

                    addInTable(convertToHtmlTable(row));
                }
            );
            console.log(response);
        },
        error: function (response) {
            alert(response);
        }
    });
}

function getPoints(board, radius, points) {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {"init": 'true'},
        success: function (response) {
            Array.from(response).forEach(function (row) {
                    let x = row.x, y = row.y, r = row.r, hit = row.hit;

                    if (r.toString() === radius.toString()) {
                        console.log("doroy");
                        let p = createPoint(board, x, y, hit);
                        console.log(p);
                        points.push(p);
                    }
                }
            );

        },
        error: function (response) {
            alert(response);
        }
    });
}

function clean_table(points) {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {"clean": 'true'},
        success: function (response) {
            console.log(response);
            let tBody = document.querySelector('#table_body');
            tBody.innerHTML = '';
            points.forEach(element => element.remove());
            points = [];
        },
        error: function (response) {
            alert(response);
        }
    });
}

function addInTable(data) {
    $('#table_body').append(data);
}

function convertToHtmlTable(data) {
    return "<tr>" +
        "<td class='result'>" + data.x + "</td>" +
        "<td class='result'>" + data.y + "</td>" +
        "<td class='result'>" + data.r + "</td>" +
        "<td class='result'>" + data.dt + "</td>" +
        "<td class='result'>" + data.executionTime + " ms</td>" +
        "<td class='result'>" + data.hit + "</td>" +
        "</tr>";
}