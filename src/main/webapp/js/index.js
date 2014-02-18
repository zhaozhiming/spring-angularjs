var spa = angular.module('spa', ['ngRoute']);

spa.config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/uploadFile', {templateUrl: 'pages/upload_file.html'})
            .otherwise({redirectTo: '/home'});
    }]);

$(document).ready(function () {
    $('#sidebar').sidebar('toggle');
});