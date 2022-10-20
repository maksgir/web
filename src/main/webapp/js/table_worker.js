function initialize_table(board, points) {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {"init" : 'true'},
        success: function(response) {
            Array.from(response).forEach(function (row) {
                let x = row.x, y = row.y, r = row.r, hit = row.hit;
                points[r].push(createPoint(board, x, y, hit));
                addInTable(convertToHtmlTable(row));
            }
            );
            console.log(response);
        },
        error: function(response) {
            alert(response);
        }
    });
}

function clean_table() {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {"clean" : 'true'},
        success: function(response) {
            console.log(response);
            let tBody = document.querySelector('#table_body');
            tBody.innerHTML = '';
        },
        error: function(response) {
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