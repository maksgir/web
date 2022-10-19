function saveData() {

    let x_value = $('#x_val').val();
    let y_value = $('#y_val').val();
    let r_value = $('#r_val').val();


    if (isCorrect(x_value, y_value, r_value)) {
        $.ajax({
            type: "GET",
            url: "submit",
            async: false,
            data: {
                "x": x_value.trim(),
                "y": y_value.trim(),
                "r": r_value.trim(),
                "timezone": new Date().getTimezoneOffset()
            },
            success: function (data) {
                console.log(data);
                let x = data.x, y = data.y, r = data.r, hit = data.hit;
                // let point = createPoint(board, x, y, hit);
                // point.showElement();
                // points[r].push(point);
                addInTable(convertToHtmlTable(data));
            },
            error: function (data) {
                alert(data);
            }
        });
    } else {
        alert("false");
    }
}