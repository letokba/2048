<%--
  Created by IntelliJ IDEA.
  User: Wait
  Date: 2020/12/29
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <style>

        .cell {
            width: 60px;
            height: 60px;
            margin: 15px;
            background-color: pink;
            font-size: 20px;
            float: left;
            text-align: center;
            line-height: 60px;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
        }

        .cap {
            width: 360px;
            height: 360px;
            background-color: #f0f0f0;
            padding: 20px;
            border-radius: 10px;
            margin: 50px auto;
        }
    </style>
</head>
<body>

<div id="app">
    <div class="cap">
        <div class="cell" v-for="item in matrix"> {{ item }}</div>
    </div>
</div>



<script>


    const vm = new Vue({
        el: '#app',
        data: {
            message: 'hello world',
            gameOver: false,
            initCount: 2,
            matrix: [
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
            ]
        },

        created: function (){
          this.randomMatrix();
        },

        watch: {
            gameOver: function (newVal) {
                if(newVal) {
                    alert("游戏结束");
                    this.randomMatrix();
                }
            }
        },

        methods: {
            httpRequest: function (direction) {
                let that = this;
                let body = {
                    "direction": direction,
                    "matrix": this.matrix
                }

                axios({
                    method: 'post',
                    url: 'http://localhost:8080/2048/api/move',
                    data: body,
                }).then(function (response) {
                    that.matrix = response.data.matrix;
                    that.gameOver = response.data.gameOver;
                })
            },

            randomMatrix: function () {
                let matrix = new Array(10).fill(0);
                for(let i = 0; i < this.initCount; i++) {
                    let index = Math.floor(Math.random() * (matrix.length - 1));
                    matrix[index] = Math.floor(Math.random() * 2) * 2;
                }
                this.matrix = matrix;
            }
        },

    });

    document.addEventListener('keyup', function (event) {
        let key = event.key;
        switch (key) {
            case 'ArrowUp': vm.httpRequest('up'); break;
            case 'ArrowDown': vm.httpRequest('down'); break;
            case 'ArrowLeft': vm.httpRequest('left'); break;
            case 'ArrowRight': vm.httpRequest('right'); break;
            default: break;
        }

    })

</script>

</body>
</html>
