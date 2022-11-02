$(function () {
    console.log("page ready");
    console.log(new Date().getTimezoneOffset());
    $('[id="j_idt9:timezone"]').val(new Date().getTimezoneOffset());
});