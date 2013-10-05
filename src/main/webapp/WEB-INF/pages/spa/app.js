angular.module("taskapp", []).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when("/spring-angularjs/task/new", {
                templateUrl: "/spring-angularjs/add.html",
                controller: TaskNewCtrl
            }).otherwise({
                redirectTo: "/spring-angularjs/index"
            })
    }]);