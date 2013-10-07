angular.element(document).ready(function() {
    angular.module("taskapp", []).
        config(['$routeProvider', function ($routeProvider) {
            $routeProvider.
                when("http://localhost:9898/spring-angularjs/task/new", {
                    templateUrl: "/spring-angularjs/pages/add.html",
                    controller: TaskNewCtrl
                }).otherwise({
                    redirectTo: "/spring-angularjs/index"
                })
        }]);
    angular.bootstrap(document, ['taskapp']);
});