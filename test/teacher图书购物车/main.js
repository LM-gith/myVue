const mv = new  Vue({
    el:'#app',
    data:{
        books : [
            {id : 1, name : '算法导论', date : '2020-10-11', price : 111, num : 1},
            {id : 2, name : '代码大全', date : '2011-11-12', price : 112, num : 1},
            {id : 3, name : '编程艺术', date : '2019-03-13', price : 113, num : 1},
            {id : 4, name : '编译原理', date : '2020-01-14', price : 114, num : 1}
        ]
    },
    methods : {
        addNum : function (index) {
            this.books[index].num++;
        },
        subNum : function (index) {
            this.books[index].num--;
        },
        delBook : function (index) {
            this.books.splice(index, 1);
        }
    },
    computed : {
        totalPrice : function () {
            /*let result = 0;
            for (let book of this.books){
                result = result + book.price * book.num;
            }
            return result;*/

            return this.books.reduce(function (preValue,n) {
                return preValue + n.price * n.num;
            },0)
        },
        seen : function () {
            if (this.books.length == 0){
                return false;
            }
            return true;
        }

    },
    filters : {
        showPrice : function (price) {
            return '￥' + price.toFixed(2);
        }
    }
})