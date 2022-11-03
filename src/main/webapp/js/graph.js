let board;
let points = [];
let serverPoints = [];
let figures = []

$(function () {
    board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-8, 6, 8, -6], axis: true, showCopyright: false});

    let rectangle = createRectangle(board, 1);
    let triangle = createTriangle(board, 1);
    let circle = createCircle(board, 1);
    figures = [rectangle, triangle, circle];

    $('[id="form:r_val"]').on('change', function () {
        clearFigures(board, figures);
        let newRadius = this.value;
        let rectangle = createRectangle(board, newRadius);
        let triangle = createTriangle(board, newRadius);
        let circle = createCircle(board, newRadius);
        figures = [rectangle, triangle, circle];

        updatePoints();
    });

    $('[id="form:x_selector"]').on("change", function () {
        $('[id="form:x_val"]').val($(this).val());
    });

    board.on("down", function (event) {
        if (event.button === 2 || event.target.className === 'JXG_navigation_button') {
            return;
        }

        if (check_r()) {
            let coords = board.getUsrCoordsOfMouse(event);
            let x = coords[0].toFixed(2);
            let y = coords[1].toFixed(2);
            let r = $('[id="form:r_val"]').val();
            console.log(x + " " + y + " " + r);
            $('[id="form:x_val"]').val(x);
            $('[id="form:y_val"]').val(y);
            $('[id="form:submitBtn"]').click();
        } else {
            alert("Нужно выбрать R");
        }
    });


});

function check_r() {
    let r = $('[id="form:r_val"]').val()
    return [1, 1.5, 2, 2.5, 3].includes(Number(r));
}

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
    let color = (hit ? "#7ce57c" : "#dc4a4a");
    return board.create("point", [x, y], {
        name: '', fixed: true, fillColor: color, fillOpacity: 1,
        strokewidth: 0
    });

}

function drawPointsByR(r) {
    for (let i = 0; i < serverPoints.length; i++) {
        let serverPoint = serverPoints[i];
        if (parseFloat(r) === serverPoint.r) {
            let point = createPoint(board, serverPoint.x, serverPoint.y, serverPoint.hit);
            points.push(point);
        }
    }
}

function clearPoints() {
    for (const point of points) {
        board.removeObject(point);
    }
    points = []
}