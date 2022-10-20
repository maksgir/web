function isCorrect(x, y, r) {

    let x_is_correct = [-4, -3, -2, -1, 0, 1, 2, 3, 4].includes(Number(x));

    let y_is_correct = false;

    if (!(y === undefined || y === "")) {
        y_is_correct = y <= 3 && y >= -3;
    }

    let r_is_correct = [1, 1.5, 2, 2.5, 3].includes(Number(r));

    return x_is_correct && y_is_correct && r_is_correct;
}

function check_r() {
    let r = $('#r_val').val();
    return [1, 1.5, 2, 2.5, 3].includes(Number(r));
}
