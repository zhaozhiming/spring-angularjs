function TaskNewCtrl($scope, $http) {
    $http.get('/task/all').success(function(data) {
        $scope.phones = data;
    });

}