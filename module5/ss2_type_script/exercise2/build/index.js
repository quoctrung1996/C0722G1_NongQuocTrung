"use strict";
let number1 = 0;
let number2 = 1;
let number3;
// @ts-ignore
function checkFibonaxi(number) {
    number3 = number1 + number2;
    if (number < number3) {
        return false;
    }
    if (number == number3) {
        return true;
    }
    number1 = number2;
    number2 = number3;
    return checkFibonaxi(number);
}
let arr = [0, 1, 2, 3, 5, 6, 8, 10];
let sum = 0;
for (let number of arr) {
    if (checkFibonaxi(number)) {
        sum += number;
    }
}
console.log(sum);
