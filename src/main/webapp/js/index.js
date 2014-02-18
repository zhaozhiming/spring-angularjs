$(document).ready(function () {
    $('#sidebar').sidebar('toggle');
});

var spa = angular.module('spa', ['ngRoute', 'blueimp.fileupload']);

spa.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/uploadFile', {templateUrl: 'pages/upload_file.html'})
        .otherwise({redirectTo: '/home'});
}]);

spa.controller('FileUploadController', ['$scope', function($scope){
    // Options you want to pass to jQuery File Upload e.g.:
    console.log("test");
    $scope.options = {
        maxFileSize: 5000000,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i
    };

    $scope.submit = function() {

    }
}]);