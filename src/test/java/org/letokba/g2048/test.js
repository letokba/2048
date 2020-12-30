let matrix =  [
    0, 0, 0, 0,
    0, 0, 0, 0,
    0, 0, 0, 0,
    0, 0, 0, 0,
]

const randomMatrix = function () {
    for(let i = 0; i < 6; i++) {
        matrix[i] = Math.floor(Math.random() * 2) * 2;
    }
}

randomMatrix();
console.log(matrix);

