function saveData(board, points, x, y, r) {
    $.ajax({
        type: "GET",
        url: "submit",
        async: false,
        data: {
            "x": x,
            "y": y,
            "r": r,
            "timezone": new Date().getTimezoneOffset()
        },
        success: function (data) {
            console.log(data);
            let x = data.x, y = data.y, r = data.r, hit = data.hit;
            let point = createPoint(board, x, y, hit);
            point.showElement();
            points[r].push(point);
            addInTable(convertToHtmlTable(data));
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}