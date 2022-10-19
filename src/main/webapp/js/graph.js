$(function () {
    console.log("ready!");
    let board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-8, 6, 8, -6], axis: true, showCopyright: false});
    let pointsByRadius = {};
    let figures = [];
    // initialize_table(board, pointsByRadius);

    var r = $('#r_val').val();
    var r_selector = $('#r_val option');

    let circle = createCircle(board, r);
    let rectangle = createRectangle(board, r);
    let triangle = createTriangle(board, r);

    $('#r_val').on('change', function() {
        console.log(this.value);
        // clearFigures(board, figures);
        let newRadius = this.value;
        let rectangle = createRectangle(board, newRadius);
        let triangle = createTriangle(board, newRadius);
        let circle = createCircle(board, newRadius);
        // figures = [rectangle, triangle, circle];

        r.each(function() {
            let idxRadius = $(this).val();
            pointsByRadius[idxRadius].forEach(function (point) {
                if (idxRadius === newRadius)
                    point.showElement();
                else
                    point.hideElement();
            });
        });
    });

});

function clearFigures(board, figures) {
    console.log(figures);
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
    let color = hit ? "#7ce57c" : "#dc4a4a";
    return board.create("point", [x, y], {name: '', fixed: true, visible: false, fillColor: color, fillOpacity: 1,
        strokewidth: 0});

}