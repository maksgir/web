function initialize_table() {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {"init" : 'true'},
        success: function(response) {
            Array.from(response).forEach(function (element) {
                let x = element.x, y = element.y, r = element.r, hit = element.hit;
                // points[r].push(createPoint(board, x, y, hit));
                addInTable(convertToHtmlTable(element));
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