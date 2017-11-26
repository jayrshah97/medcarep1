var doctordashController = angular.module('doctordash-controller',[]);


doctordashController.controller('doctordashController', function($scope, $rootScope, $location,$state,doctordashAPI){
        $scope.count = {};
        $scope.patienList = {};
        doctordashAPI.getCount().success(function(response){
            console.log(response);
            if(response.status){
                $scope.count.opdCount = response.opdCount;
                $scope.count.admitCount = response.admitCount;
            }
            else{
            }
        }).error(function(data, status, headers, config){console.log("Error");});

        $scope.getOpdPatients= function () {
            doctordashAPI.getOpdList().success(function(response){
                console.log(response);
                if(response.status){
                    $scope.patienList = response.patientOpdList;
                    $scope.listname=response.listname;
                }
                else{
                }
            }).error(function(data, status, headers, config){console.log("Error");});
    },

    $scope.getAdmittedPatients= function () {
        doctordashAPI.getAdmittedList().success(function(response){
            console.log(response);
            if(response.status){
                $scope.patienList = response.patientAdmittedList;
                $scope.listname=response.listname;
            }
            else{
            }
        }).error(function(data, status, headers, config){console.log("Error");});
    }
});