function saveData(board, x, y, r, points) {
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
            let p = createPoint(board, x, y, hit)
            points.push(p);
            addInTable(convertToHtmlTable(data));
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}