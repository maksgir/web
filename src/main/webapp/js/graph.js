$(function () {
    console.log("ready!");

    let board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-8, 6, 8, -6], axis: true, showCopyright: false});
    let figures = [];
    var points = [];

    initialize_table(board);

    $('#r_val').on('change', function () {
        clearFigures(board, figures);
        let newRadius = this.value;
        let rectangle = createRectangle(board, newRadius);
        let triangle = createTriangle(board, newRadius);
        let circle = createCircle(board, newRadius);
        figures = [rectangle, triangle, circle];

        points.forEach(element => element.remove());
        points = [];
        getPoints(board, newRadius, points);
    });

    board.on("down", function (event) {
        if (event.button === 2 || event.target.className === 'JXG_navigation_button') {
            return;
        }

        if (check_r()) {
            let coords = board.getUsrCoordsOfMouse(event);
            let x = coords[0].toFixed(2);
            let y = coords[1].toFixed(2);
            let r = $('#r_val').val()
            saveData(board, x, y, r, points);
        } else {
            alert("Нужно выбрать R");
        }
    });


    $('#submitButton').click(function (event) {
        let x = $('#x_val').val();
        let y = $('#y_val').val();
        let r = $('#r_val').val();
        if (!isCorrect(x, y, r)) {
            alert("Данные не верны");
        } else {
            saveData(board, x, y, r, points);
        }
    });

    $('#clearButton').click(function (event) {
        clearFigures(board, figures);
        clean_table(points);
    });


});

function clearFigures(board, figures) {
    for (const object of figures) {
        let points = object.ancestors;
        for (const point in points) board.removeObject(point);
        board.removeObject(object);
    }
}

function createRectangle(board, r) {
    let rectanglePoint1 = board.create('point', [0, 0], {name: '', fixed: true, visible: false});
    let rectanglePoint2 = board.create('point', [r, 0], {name: '', fixed: true, visible: false});
    let rectanglePoint3 = board.create('point', [r, -r / 2], {name: '', fixed: true, visible: false});
    let rectanglePoint4 = board.create('point', [0, -r / 2], {name: '', fixed: true, visible: false});
    return board.create('polygon', [rectanglePoint1, rectanglePoint2, rectanglePoint3, rectanglePoint4],
        {fillColor: 'rgba(224, 0, 253, 0.92)', fillOpacity: 1});
}

function createTriangle(board, r) {
    let trianglePoint1 = board.create('point', [0, 0], {name: '', fixed: true, visible: false});
    let trianglePoint2 = board.create('point', [-r / 2, 0], {name: '', fixed: true, visible: false});
    let trianglePoint3 = board.create('point', [0, r / 2], {name: '', fixed: true, visible: false});
    return board.create('polygon', [trianglePoint1, trianglePoint2, trianglePoint3], {
        fillColor: 'rgba(224, 0, 253, 0.92)',
        fillOpacity: 1
    });
}

function createCircle(board, r) {
    let circlePoint1 = board.create('point', [-r / 2, 0], {name: '', fixed: true, visible: false});
    let circlePoint2 = board.create('point', [0, -r / 2], {name: '', fixed: true, visible: false});
    let centerPoint = board.create('point', [0, 0], {name: '', fixed: true, visible: false});

    return board.create('sector', [centerPoint, circlePoint1, circlePoint2],
        {fillColor: 'rgba(224, 0, 253, 0.92)', fillOpacity: 1});
}

function createPoint(board, x, y, hit) {
    console.log(hit);
    let color = (hit === "Попал" ? "#7ce57c" : "#dc4a4a");
    return board.create("point", [x, y], {
        name: '', fixed: true, fillColor: color, fillOpacity: 1,
        strokewidth: 0
    });

}