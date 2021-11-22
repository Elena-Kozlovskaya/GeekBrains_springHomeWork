angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';
   /* $scope. - блок связки js-кода и html*/
    //функция згрузки студентов
    $scope.loadProducts = function () {
        //отправляем запрос on backend on address '/students'
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data; // data тело ответа на запрос
            });
    };
     $scope.deleteProduct = function(productId){
         $http.get(contextPath + '/products/delete/' + productId)
             .then(function (response) { //когда ответ (response)придет, то делай это V
                 alert('DELETED')
                 $scope.loadProducts();// обновляем список студентов после удаления
             });
    }
    $scope.changeScore = function(productId, delta){
         $http({
             url: contextPath + '/products/change_cost/',
             method: 'GET',
             params:{
                 productId: productId,
                 delta: delta
             }
         }).then(function (response) { //когда ответ (response)придет, то делай это V
                $scope.loadProducts();// обновляем список студентов после удаления
            });
    }

    $scope.loadProducts();
});