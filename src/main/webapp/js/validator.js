function isCorrect(x, y, r) {

    console.log("пришли " + x + " " + y + " " + r)


    let x_is_correct = [-4, -3, -2, -1, 0, 1, 2, 3, 4].includes(Number(x));

    let y_is_correct = false;

    if (!(y === undefined || y === "")) {
        y_is_correct = y <= 3 && y >= -3;
    }

    let r_is_correct = [1, 1.5, 2, 2.5, 3].includes(Number(r));

    console.log("значение х - " + x +" валидно: " + x_is_correct);
    console.log("значение y - " + y +" валидно: " + y_is_correct);
    console.log("значение r - " + r +" валидно: " + r_is_correct);


    return x_is_correct && y_is_correct && r_is_correct;
}